import request from '@/utils/request'
import { UserModule } from '@/store/modules/user'

export const login = (data: any) =>
  request({
    url: 'uaa/oauth/token',
    method: 'post',
    data
  })

//登录
export const checkToken = (data: any) =>
  request({
    url:`uaa/oauth/check_token`,
    method:'post',
    data
  })

  //注册
export const registryData = (data:any) => 
  request({
    url:`/merchant/merchants/register`,
    method:'post',
    data
  })
  //注册时获取验证码
  export const getMsgCode = (phone:string) =>
    request({
      url:`merchant/sms?phone=${phone}`,
      method:'get'
    })
//登录时获取验证码
  export const getLoginCode = (phone:string) =>
    request({
      url:`/user/getMessage?phone=${phone}`,
      method:'get'
    })

//查询商户下的应用列表
export const getAppList = (appId:any) =>
request({
  url:`/merchant/my/merchants/${appId}/app-list?tenantId=${UserModule.tenantId}`,
  method:'get'
})

//根据租户获取商户信息
export const getMsgFromTenement = (tenantId:any) =>
request({
  url:`/merchant/my/merchants/${tenantId}/tenant-merchant?tenantId=${UserModule.tenantId}`,
  method:'get'
})

//获取多个租户对应的多个商户信息
export const getMsgsFromTenements = () =>
request({
  url:`/merchant/my/tenants-merchants?tenantId=${UserModule.tenantId}`,
  method:'get'
})
