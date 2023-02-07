import request from '@/utils/request'
import { UserModule } from '@/store/modules/user'


//新建管理员
export const createAdmin = (data:any) =>
  request({
    url: `/operation/m/administrators?tenantId=${UserModule.tenantId}`,
    method: 'post',
    data
  })

  //修改管理员
export const updataAdmin = (data:any) =>
request({
  url: `/operation/m/administrators?tenantId=${UserModule.tenantId}`,
  method: 'put',
  data
})

//分页查询管理员信息
export const getAdminList = (pageNo:number,pageSize:number) =>
  request({
    url: `/operation/m/administrators/page?pageNo=${pageNo}&pageSize=${pageSize}&tenantId=${UserModule.tenantId}`,
    method: 'get'
  })

  //查询某个管理员信息
export const searchAdmin = (username:string) =>
request({
  url: `/operation/m/administrators/${username}?tenantId=${UserModule.tenantId}`,
  method: 'post'
})

//删除某管理员
export const delAdmin = (username:string) =>
  request({
    url: `/operation/m/administrators/${username}?tenantId=${UserModule.tenantId}`,
    method: 'post'
  })

  //新建角色
export const createRoles = (data:any) =>
request({
  url: `/operation/m/roles?tenantId=${UserModule.tenantId}`,
  method: 'post',
  data
})

//修改角色
export const updataRoles= (data:any) =>
request({
url: `/operation/m/roles?tenantId=${UserModule.tenantId}`,
method: 'put',
data
})

//分页查询角色信息
export const getRolesList = (pageNo:number,pageSize:number) =>
request({
  url: `/operation/m/roles/page?pageNo=${pageNo}&pageSize=${pageSize}&tenantId=${UserModule.tenantId}`,
  method: 'get'
})

//为角色分配权限
export const searchRoles = () =>
request({
url: `/operation/m/roles/privileges?tenantId=${UserModule.tenantId}`,
method: 'post'
})

//删除某角色
export const delRoles = (roleCode:string) =>
request({
  url: `/operation/m/roles/${roleCode}?tenantId=${UserModule.tenantId}`,
  method: 'post'
})