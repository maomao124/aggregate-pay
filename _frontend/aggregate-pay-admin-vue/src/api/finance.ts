import request from '@/utils/request'
import { UserModule } from '@/store/modules/user'
// //分页条件查询商户下门店
// export const getStoresData = (pageNo:number,pageSize:number) =>
//   request({
//     url: `/merchant/my/stores/merchants/page?pageNo=${pageNo}&pageSize=${pageSize}&tenantId=${UserModule.tenantId}`,
//     method: 'get'
//   })

//证件上传
export const upload = (data:any) =>
  request({
    url: `/zuul/merchant/upload?tenantId=${UserModule.tenantId}`,
    method: 'post',
    data
  })

//商户个人认证资料保存(申请)
export const setApprove =  (data:any) => 
  request ({
      url:`/merchant/my/merchants/save?tenantId=${UserModule.tenantId}`,
      method:'post',
      data
  })

//根据租户获取商户信息
export const getList =  () => 
  request ({
      url:`/merchant/my/merchants?tenantId=${UserModule.tenantId}`,
      method:'get'
  })
