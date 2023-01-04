/* eslint-disable */
import axios, { AxiosInstance } from 'axios'
import { Message, MessageBox } from 'element-ui'
import store from '@/store'
let isRest = false
const instance = axios.create({
  withCredentials: true,
  timeout: 60000
})
instance.interceptors.request.use(config => {
  const data = {}
  if (!config.data) config.data = {}
  if (config.method === 'get' || config.method === 'delete') {
    config.params = config.data
    Object.assign(config.params, data)
  } else {
    Object.assign(config.data, data)
  }
  if (process.env.NODE_ENV !== 'production') {
    const baseURL = 'development'
    if (baseURL.startsWith('http')) {
      config.baseURL = 'localhttp'
      config.headers.token = 'eyJhbGciOiJSUzI1NiJ9.eyJzdWIiOiIzIiwiYWNjb3VudCI6InBpbmRhIiwibmFtZSI6IuW5s-WPsOeuoeeQhuWRmCIsIm9yZ2lkIjoxMDAsInN0YXRpb25pZCI6MTAwLCJleHAiOjE2MDI1MjkwMjR9.J-ozSUoFfDyoUZLdlTj75x07RRKWiF36j_FM8mnuwe11bWpeqic_P8LHeya4TSqutlLhx29AgYnvCId_H1G45KtcUmwvuAH8L9EOo5y2PIZydMmB6PsV29ZEpUdECeh4aINgQuRH3f3iOt6eH0xxXEowGEVwZ9gg8NevwGqy1R4'
      config.headers.localhttp = baseURL + (config.url || '').replace('/services/', '/service/').replace('/files/', '/file/')
    } else {
      config.baseURL = baseURL
    }
  }
  config.hideLoading = showLoading(Symbol('request'))
  return config
})
instance.interceptors.response.use(response => {
  const { config } = response
  const res = response.data || {}
  const info = res.data && res.data.msg
  const infoMsg = res && res.msg
  if (config.hideLoading) config.hideLoading()
  if (config.responseType === 'blob') {
    if (!(res instanceof Blob)) {
      Message.error(res.desc || '系统异常')
      return Promise.reject(res.desc)
    }
    const fileName = config.data.get('displayName') || config.data.get('fileName')
    if (navigator.msSaveBlob) {
      navigator.msSaveBlob(res, fileName)
    } else if ('download' in document.createElement('a')) { // 非IE下载
      const elink = document.createElement('a')
      elink.download = fileName
      elink.style.display = 'none'
      elink.href = URL.createObjectURL(res)
      document.body.appendChild(elink)
      elink.click()
      URL.revokeObjectURL(elink.href) // 释放URL 对象
      document.body.removeChild(elink)
    } else { // IE10+下载
      window.open(URL.createObjectURL(res))
    }
    return null
  } else {
    if (String(res.code) === '200' || String(res.code) === '0') {
      if (!res.data) {
        let msg = typeof config.showMsg === 'string' ? config.showMsg : res.msg
        config.showMsg && msg && Message.success(msg)
        return res
      }
      // && res.data.stateCode === undefined
      if (res.data) {
        let msg = typeof config.showMsg === 'string' ? config.showMsg : res.msg
        config.showMsg && msg && Message.success(msg)
        return res.data
      }
      const { stateCode = {} } = res.data
      if (String(stateCode.code) === '200' || String(stateCode.code) === '0') {
        let msg = typeof config.showMsg === 'string' ? config.showMsg : stateCode.desc
        config.showMsg && msg && Message.success(msg)
        delete res.data.stateCode
        return res.data
      } else {
        if (String(stateCode.code) !== '405') Message.error(config.errorMsg || stateCode.msg || stateCode.desc || res.desc || String(response.status))
        return Promise.reject(res)
      }
    } else {
      if (res.data && res.data.code === '200') {
        let msg = typeof config.showMsg === 'string' ? config.showMsg : res.data.msg
        config.showMsg && msg && Message.success(msg)
        return res.data
      }
      if (String(res.code) === '503' && !isRest) {
        isRest = true
        return MessageBox.confirm('长时间无操作，系统超时，需重新登录', '确定登出', {
          confirmButtonText: '重新登录',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          return store.dispatch('logout')
        }).finally(() => {
          isRest = false
        })
      } else {
        Message.error(config.errorMsg || info || infoMsg || res.desc || res.msg || '系统错误')
      }
      return Promise.reject(res)
    }
  }
}, error => {
  if (error.config && error.config.hideLoading)error.config.hideLoading()
  Message.error(error.message)
  return Promise.reject(error)
})

let arr:Array<symbol> = []
function isShowLoading () {
  setTimeout(() => {
    let flag = arr.length > 0
    flag !== store.state.loading && store.commit('updateLoading', flag)
  }, 100)
}
function showLoading (symbolId:symbol) {
  arr.push(symbolId)
  isShowLoading()
  return function () {
    arr.splice(arr.indexOf(symbolId), 1)
    isShowLoading()
  }
}
interface Cmethod <T>{
  (target:T, name:string): T
}
export interface Method<T = any, R = any>{
  (data?: T, showMsg?: boolean | string, errMsg?: boolean | string):Promise<R>
}
interface FormatData<T = any> {
  (res: T, data: any): T
}
export function createApi (args:any, format?: FormatData, request:AxiosInstance = instance):Cmethod<any> {
  return function (target, name) {
    const oldValue = target[name]
    target[name] = async function (data:any = {}, showMsg?: any, errorMsg?: any) {
      const res = await instance({
        ...args,
        data,
        showMsg: showMsg !== undefined ? showMsg : args.showMsg,
        errorMsg: errorMsg !== undefined ? errorMsg : args.errorMsg
      })
      if (format) {
        return format.call(this, res, data)
      }
      return typeof oldValue === 'function' ? oldValue.call(this, res) : res
    }
    return target
  }
}

export const getList = (url: string, params = {}) => {
  return instance({
    method: 'get',
    url,
    data: {...params},
    headers: {
      'Content-Type': 'application/x-www-from-urlencoded',
    }
  })
}

export default instance
