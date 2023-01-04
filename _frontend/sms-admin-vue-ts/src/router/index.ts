
import Vue from 'vue'
import VueRouter, { RouteConfig } from 'vue-router'

Vue.use(VueRouter)

  const originalPush = VueRouter.prototype.push
  VueRouter.prototype.push = function push(location: any) {
    return (originalPush as any).call(this, location).catch((err: any) => err)
  }

  const routes: Array<RouteConfig> = [
    {
      path: '/login',
      component: () => import('@/pages/Login.vue'),
      meta: { notNeedAuth: true }
    },
    {
      path: '/403',
      component: () => import('@/pages/error/403.vue'),
      meta: { notNeedAuth: true }

    },
    {
      path: '/404',
      component: () => import('@/pages/error/404.vue'),
      meta: { notNeedAuth: true }
    }
  ]

const router = new VueRouter({
  routes
})

export default router
