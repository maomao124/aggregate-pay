import request from '@/utils/request'
import { UserModule } from '@/store/modules/user'
//分页条件查询商户下门店
export const getStoresData = (pageNo:number,pageSize:number,data:any) =>
  request({
    url: `/merchant/my/stores/merchants/page?pageNo=${pageNo}&pageSize=${pageSize}&tenantId=${UserModule.tenantId}`,
    method: 'post',
    data
  })

//删除某门店
export const delStore = (id:number) =>
  request({
    url: `/merchant/my/stores/${id}?tenantId=${UserModule.tenantId}`,
    method: 'delete'
  })

//修改某门店信息
export const updateStore = (data:any) =>
  request({
    url: `/merchant/my/stores?tenantId=${UserModule.tenantId}`,
    method: 'put',
    data
  })
//查询某个门店的信息
export const searchStore = (id:number) =>
  request({
    url: `/merchant/my/stores/${id}?tenantId=${UserModule.tenantId}`,
    method: 'get'
  })
  //分页查询商户下员工
  export const getMemberData = (pageNo:number,pageSize:number,data:any) =>
  request({
    url: `/merchant/my/staffs/page?pageNo=${pageNo}&pageSize=${pageSize}&tenantId=${UserModule.tenantId}`,
    method: 'post',
    data
  })

    //查询某个员工的信息
    export const searchMemberData = (id:any) =>
    request({
      url: `/merchant/my/staffs/${id}?tenantId=${UserModule.tenantId}`,
      method: 'get'
    })

  //删除某个员工的信息
  export const delMember = (id:number) =>
  request({
    url: `/merchant/my/staffs/${id}?tenantId=${UserModule.tenantId}`,
    method: 'delete'
  })

  //修改员工信息
  export const updateMember = (data:any,roleCodes:any) =>
  request({
    url: `/merchant/my/staffs?tenantId=${UserModule.tenantId}&roleCodes=${roleCodes}`,
    method: 'put',
    data
  })

  //在某商户下创建员工和账号
  export const createMember = (data:any,roleCodes:any) =>
  request({
    url: `/merchant/my/staffs?tenantId=${UserModule.tenantId}&roleCodes=${roleCodes}`,
    method: 'post',
    data
  })

  //在某商户下新增门店，并设置管理员
  export const createStore = (data:any,staffIds:any) =>
  request({
    url: `/merchant/my/stores?tenantId=${UserModule.tenantId}&staffIds=${staffIds}`,
    method: 'post',
    data
  })
//查询某租户下角色（不分页，不包含权限）
export const getRole = () =>
request({
  url:`/merchant/my/roles/tenants/${UserModule.tenantId}`,
  method:'get'
})
