import { RouteConfig } from 'vue-router'
import Layout from '@/layout/index.vue'

const firmRoutes: RouteConfig = {
  path: '/firm',
  component: Layout,
  redirect: '/firm/index',
  meta: {
    code: 'P004',
    title: '企业管理',
    icon: 'form'
  },
  children: [
    {
      path: 'index',
      component: () => import('@/views/firm/index.vue'),
      meta: {
        code: 'P004001',
        title: '企业管理',
        icon: 'table'
      }
    },
    {
      path: 'aduit',
      component: () => import('@/views/firm/aduit.vue'),
      meta: {
        code: 'P004002',
        title: '审核管理',
        icon: 'table'
      }
    },
    {
      path: 'member',
      component: () => import('@/views/firm/member.vue'),
      meta: {
        code: 'P004003',
        title: '会员管理',
        icon: 'table'
      }
    }
  ]
}

export default firmRoutes
