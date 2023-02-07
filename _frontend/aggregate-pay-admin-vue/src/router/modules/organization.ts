import { RouteConfig } from 'vue-router'
import Layout from '@/layout/index.vue'

const organizationRoutes: RouteConfig = {
  path: '/organization',
  component: Layout,
  redirect: '/organization/index',
  meta: {
    code: 'P003',
    title: '组织管理',
    icon: 'form'
  },
  children: [
    {
      path: 'index',
      component: () => import('@/views/organization/index.vue'),
      meta: {
        code: 'P003001',
        title: '门店管理',
        icon: 'table'
      }
    },
    {
      path: 'member',
      component: () => import('@/views/organization/member.vue'),
      meta: {
        code: 'P003002',
        title: '成员管理',
        icon: 'table'
      }
    }
  ]
}

export default organizationRoutes
