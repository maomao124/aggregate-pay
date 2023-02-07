import request from '@/utils/request'
import { UserModule } from '@/store/modules/user'
// //分页条件查询商户下门店
// export const getStoresData = (pageNo:number,pageSize:number) =>
//   request({
//     url: `/merchant/my/stores/merchants/page?pageNo=${pageNo}&pageSize=${pageSize}&tenantId=${UserModule.tenantId}`,
//     method: 'get'
//   })

//创建应用
export const createApp = (data:any) =>
  request({
    url: `/merchant/my/apps?tenantId=${UserModule.tenantId}`,
    method: 'post',
    data
  })

//获取商户下应用列表
export const getAppList =  () => 
  request ({
      url:`/merchant/my/apps?tenantId=${UserModule.tenantId}`,
      method:'get'
  })

  //修改应用
export const updateApp = (data:any) =>
    request({
        url:`/merchant/my/apps?tenantId=${UserModule.tenantId}`,
        method:'put',
        data
    })

//获取某应用，根据应用的业务主键appId
export const getAppFromId =  (appId:string) => 
    request ({
        url:`/merchant/my/apps/${appId}?tenantId=${UserModule.tenantId}`,
        method:'get'
    })

//商户生成应用二维码
export const createCode =  (appId:number,totalAmount:number) => 
    request ({
        url:`/merchant/my/apps/${appId}?tenantId=${UserModule.tenantId}&totalAmount=${totalAmount}`,
        method:'get'
    })

//查询app下绑定的服务类型（或者叫平台支付渠道）
export const getServiceType =  (appId:string) => 
    request ({
        url:`/merchant/my/apps/${appId}/platform-channels?tenantId=${UserModule.tenantId}`,
        method:'get'
    })

//为应用绑定平台支付渠道
export const boundRoad = (appId:string,platformChannelCodes:any) =>
    request({
        url:`/merchant/my/apps/${appId}/platform-channels?tenantId=${UserModule.tenantId}&platformChannelCodes=${platformChannelCodes}`,
        method:'post'
    })

//商户修改某应用的Webhooks
export const updateWebhooks= (data:any,id:any,notifyUrl:any) =>
    request({
        url:`/merchant/my/apps/${id}/notify-url/${notifyUrl}?tenantId=${UserModule.tenantId}`,
        method:'put',
        data
    })

//为应用解绑平台支付渠道
export const delPayChannel= (appId:any,platformChannelCode:any) =>
    request({
        url:`/merchant/my/apps/${appId}/platform-channels/${platformChannelCode}?tenantId=${UserModule.tenantId}`,
        method:'DELETE'
    })

//生成商户应用门店二维码
export const getStoresDataCode =  (appId:string,storeId:string,body:string,totalAmount:string) => 
    request ({
        url:`/merchant/my/apps/${appId}/stores/${storeId}/app-store-qrcode?tenantId=${UserModule.tenantId}&body=${body}&totalAmount=${totalAmount}`,
        method:'get'
    })
//查询应用是否绑定了某个服务类型
export const searchIsBindService =  (appId:string,platformChannel:string) => 
    request ({
        url:`/merchant/my/merchants/apps/platformchannels?tenantId=${UserModule.tenantId}&appId=${appId}&platformChannel=${platformChannel}`,
        method:'get'
    })
//某商户下所有应用的交易汇总
export const getDealCollect = (data:any) =>
    request({
        url:`/merchant/my/merchants/transactions?tenantId=${UserModule.tenantId}`,
        method:'post',
        data
    })

//商户下所有交易按照应用分类汇总
export const getAllDealFromAppType = () =>
    request({
        url:`/merchant/my/merchants/transactions/apps?tenantId=${UserModule.tenantId}`,
        method:'post'
    })

//商户下所有交易按渠道汇总
export const getAllDealFromChannel = () =>
    request({
        url:`/merchant/my/merchants/transactions/channels?tenantId=${UserModule.tenantId}`,
        method:'post'
    })

//查询某个订单交易明细
export const getOrderDeal = (data:any,tradeNumber:any) =>
    request({
        url:`/merchant/my/merchants/transactions/${tradeNumber}?tenantId=${UserModule.tenantId}`,
        method:'post',
        data
    })

//B扫C支付接口
export const BscanC = (data:any) =>
    request({
        url:`/merchant/createOrderBCscanPay?tenantId=${UserModule.tenantId}`,
        method:'post',
        data
    })

//获取客户端信息，展示开启的支付
export const getPayParams = (appId:string) =>
    request({
        url:`/merchant/my/apps/clientdetails/${appId}?tenantId=${UserModule.tenantId}`,
        method:'get'
    })