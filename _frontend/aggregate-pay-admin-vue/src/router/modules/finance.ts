import { RouteConfig } from 'vue-router'
import Layout from '@/layout/index.vue'

const financeRoutes: RouteConfig = {
  path: '/finance',
  component: Layout,
  redirect: '/finance/index',
  meta: {
    code: 'P001',
    title: '账户管理',
    icon: 'form'
  },
  children: [
    {
      path: 'index',
      component: () => import('@/views/finance/index.vue'),
      meta: {
        code: 'P001001',
        title: '账户中心',
        icon: 'table'
      }
    },
    {
      path: 'approve',
      component: () => import('@/views/finance/approve.vue'),
      meta: {
        code: 'P001002',
        title: '资质申请',
        icon: 'table'
      }
    }
    // {
    //   path: 'list',
    //   component: () => import('@/views/house/list.vue'),
    //   meta: {
    //     title: '房源列表',
    //     icon: 'table'
    //   }
    // }
  ]
}

export default financeRoutes
