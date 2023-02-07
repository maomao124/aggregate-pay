import axios from 'axios'
import { Message, MessageBox } from 'element-ui'
import { UserModule } from '@/store/modules/user'

const service = axios.create({
  baseURL: process.env.VUE_APP_BASE_API,
  timeout: 5000
})
service.defaults.headers.post['Content-Type'] = 'application/json'

// Request interceptors
service.interceptors.request.use(
  config => {
    // Add X-Access-Token header to every request, you can add other custom headers here
    if (UserModule.token) {
      config.headers['Authorization'] = 'Bearer ' + UserModule.token
      config.headers['tenantId'] = UserModule.tenantId
    }
    return config
  },
  error => {
    Promise.reject(error)
  }
)

// Response interceptors
service.interceptors.response.use(

  response => {
    // console.log(response.status)
    // return response.data

    let status = response.status
    if (status !== 200) {
      // Message({
      //   message: response.err,
      //   type: 'error',
      //   duration: 5 * 1000
      // })
      // 5001: token过期
      // 5002: 无效token
      // 5003: token校验异常
      if (status === 401) {
        MessageBox.confirm(
          response.data.errMessage,
          '退出',
          {
            confirmButtonText: '确定',
            cancelButtonText: '取消',
            type: 'warning'
          }
        ).then(() => {
          UserModule.ResetToken()
          location.reload() // To prevent bugs from vue-router
        })
      }
      return Promise.reject(new Error('Error'))
    } else {
      return response.data
    }
  },
  error => {
    let status = error.response.status
    if (status === 401 || status === 500) {
      Message({
        message: error.response.data.errMessage,
        type: 'error',
        duration: 5 * 1000
      })

      // UserModule.ResetToken()
      // location.reload() 
      // MessageBox.confirm(
      //   error.response.data.errMessage,
      //   '退出',
      //   {
      //     confirmButtonText: '确定',
      //     cancelButtonText: '取消',
      //     type: 'warning'
      //   }
      // ).then(() => {
      //   UserModule.ResetToken()
      //   location.reload() // To prevent bugs from vue-router
      // })
    } else {
      Message({
        message: error.message,
        type: 'error',
        duration: 5 * 1000
      })
    }

    return Promise.reject(error)
  }
)

export default service
