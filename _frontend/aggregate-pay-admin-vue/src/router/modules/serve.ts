import { RouteConfig } from 'vue-router'
import Layout from '@/layout/index.vue'

const serveRoutes: RouteConfig = {
  path: '/serve',
  component: Layout,
  redirect: '/serve/index',
  meta: {
    code: 'P005',
    title: '服务类型管理',
    icon: 'form'
  },
  children: [
    {
      path: 'serve',
      component: () => import('@/views/serve/serve.vue'),
      meta: {
        code: 'P005001',
        title: '服务类型管理',
        icon: 'table'
      }
    },
    {
      path: 'index',
      component: () => import('@/views/serve/index.vue')
    }
  ]
}

export default serveRoutes
