import request from '@/utils/request'
import { UserModule } from '@/store/modules/user'

//商户个人认证审核
export const OneApprove = (auditStatus:any,id:number) =>
  request({
    url: `/operation/m/merchants/audit/${auditStatus}?tenantId=${id}`,
    method: 'post'
  })


//商户列表
export const storeList = (data:any,pageNo:any,pageSize:any) =>
  request({
    url: `/operation/m/merchants/page?pageNo=${pageNo}&pageSize=${pageSize}&tenantId=${UserModule.tenantId}`,
    method: 'post',
    data
  })


//根据商户获取商户信息
export const getMsgFromMer = (id:any) =>
  request({
    url: `/operation/m/merchants?id=${id}`,
    method: 'get'
  })

//查询某个员工的信息
export const SearchMsg = (id:any) =>
  request({
    url: `/operation/m/staffs/${id}?tenantId=${UserModule.tenantId}`,
    method: 'get'
  })

  //删除某员工
export const delMember = (id:any) =>
request({
  url: `/operation/m/staffs/${id}?tenantId=${UserModule.tenantId}`,
  method: 'DELETE'
})

//分页条件查询会员信息
export const getMemberMsg = (pageNo:number,pageSize:number) =>
request({
  url: `/operation/m/staffs/page?pageNo=${pageNo}&pageSize=${pageSize}&tenantId=${UserModule.tenantId}`,
  method: 'get'
})

//删除某商户
export const delMerchants = (id:any) =>
request({
  url: `/operation/m/merchants?tenantId=${UserModule.tenantId}`,
  method: 'DELETE'
})
