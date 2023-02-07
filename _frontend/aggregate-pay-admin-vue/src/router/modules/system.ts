import { RouteConfig } from 'vue-router'
import Layout from '@/layout/index.vue'

const systemRoutes: RouteConfig = {
  path: '/system',
  component: Layout,
  redirect: '/system/index',
  meta: {
    code: 'P006',
    title: '系统管理',
    icon: 'form'
  },
  children: [
    {
      path: 'index',
      component: () => import('@/views/system/index.vue'),
      meta: {
        code: 'P006001',
        title: '角色管理',
        icon: 'table'
      }
    },
    {
      path: 'serve',
      component: () => import('@/views/system/serve.vue'),
      meta: {
        code: 'P006002',
        title: '管理员管理',
        icon: 'table'
      }
    }
  ]
}

export default systemRoutes
