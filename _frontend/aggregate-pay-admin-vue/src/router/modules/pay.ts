import { RouteConfig } from 'vue-router'
import Layout from '@/layout/index.vue'

const payRoutes: RouteConfig = {
  path: '/pay',
  component: Layout,
  redirect: '/pay/index',
  meta: {
    code: 'P002',
    title: '支付应用管理',
    icon: 'form'
  },
  children: [
    {
      path: 'index',
      component: () => import('@/views/pay/index.vue'),
      meta: {
        code: 'P002001',
        title: '应用管理',
        icon: 'table'
      }
    },
    {
      path: 'set/:id/:step',
      component: () => import('@/views/pay/set.vue'),
      meta: {
        title: '配置参数',
        hidden:true
      }
    },
    {
      path: 'start',
      component: () => import('@/views/pay/start.vue'),
      meta: {
        code: 'P002002',
        title: '开始支付',
        icon: 'table'
      }
    },
    {
      path: 'bill',
      component: () => import('@/views/pay/bill.vue'),
      meta: {
        code: 'P002003',
        title: '应用财务对账',
        icon: 'table'
      }
    },
    {
      path: 'deal',
      component: () => import('@/views/pay/deal.vue'),
      meta: {
        code: 'P002004',
        title: '应用交易总览',
        icon: 'table'
      }
    }
  ]
}

export default payRoutes
