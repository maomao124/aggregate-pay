import request from '@/utils/request'
import { UserModule } from '@/store/modules/user'

//商户配置实际支付参数
export const setParams =  (data:any) => 
  request ({
      url:`/merchant/my/pay-channel-params?tenantId=${UserModule.tenantId}`,
      method:'post',
      data
  })

//获取所有平台支付渠道
export const getAllPayChannel =  () => 
  request ({
      url:`/merchant/my/platform-channels?tenantId=${UserModule.tenantId}`,
      method:'get'
  })

//修改商户配置实际支付参数
export const updateRealPayParam =  (data:any) => 
  request ({
      url:`/merchant/my/pay-channel-params?tenantId=${UserModule.tenantId}`,
      method:'put',
      data
  })

//获取某应用下平台支付渠道所包含的原始支付参数列表
export const getPayChannelIncludePayParams =  (appId:any,platformChannel:any) => 
  request ({
      url:`/merchant/my/pay-channel-params/apps/${appId}/platform-channels/${platformChannel}?tenantId=${UserModule.tenantId}`,
      method:'get'
  })


//获取某应用下平台支付渠道所包含的某个原始支付参数
export const getPayChannelIncludeOnlyPayParams =  (appId:any,platformChannel:any,payChannel:any) => 
  request ({
      url:`/merchant/my/pay-channel-params/apps/${appId}/platform-channels/${platformChannel}/pay-channels/${payChannel}?tenantId=${UserModule.tenantId}`,
      method:'get'
  })

//获取商户配置实际支付参数,用于快捷复制填写参数
export const getRealPayParamsUseCopy =  (merchantId:any,payChannel:any) => 
  request ({
      url:`/merchant/my/pay-channel-params/merchants/${merchantId}/pay-channels/${payChannel}?tenantId=${UserModule.tenantId}`,
      method:'get'
  })

//获取商户配置实际支付参数
export const getRealPayParams=  (id:any) => 
  request ({
      url:`/merchant/my/pay-channel-params/${id}?tenantId=${UserModule.tenantId}`,
      method:'get'
  })

//根据平台支付渠道(编码)获取原始支付渠道
export const getPayChannelFromPayCode=  (platformChannelCode:any) => 
  request ({
      url:`/merchant/my/pay-channels/platform-channel/${platformChannelCode}?tenantId=${UserModule.tenantId}`,
      method:'get'
  })