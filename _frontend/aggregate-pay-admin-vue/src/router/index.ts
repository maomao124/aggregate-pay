import Vue from 'vue'
import Router, { RouteConfig } from 'vue-router'

import Layout from '@/layout/index.vue'
import financeRouter from './modules/finance'
import payRouter from './modules/pay'
import organizationRouter from './modules/organization'
import firmRouter from './modules/firm'
import serveRouter from './modules/serve'
import systemRouter from './modules/system'

Vue.use(Router)

/**
 * 静态路由
 */
export const constantRoutes: RouteConfig[] = [
  {
    path: '/login',
    component: () =>
             import(/* webpackChunkName: "login" */ '@/views/login/index.vue'),
    meta: { hidden: true, title: '聚合支付' }
  },
  {
    path: '/operationLogin',
    component: () =>
             import(/* webpackChunkName: "login" */ '@/views/backlogin/index.vue'),
    meta: { hidden: true, title: '聚合支付' }
  },
  {
    path: '/404',
    component: () =>
             import(/* webpackChunkName: "404" */ '@/views/404.vue'),
    meta: { hidden: true }
  },
  // {
  //   path: '/',
  //   component: () =>
  //            import(
  //              /* webpackChunkName: "404" */ '@/views/workbench/index.vue'
  //            ),
  //   meta: { hidden: true }
  // },
  {
    path: '/',
    component: () => import('@/views/workbench/index.vue'),
    meta: { hidden: true, title: '工作台' }


  }
]

/**
 * 动态路由
 */
export const asyncRoutes: RouteConfig[] = [
  financeRouter,
  payRouter,
  organizationRouter,
  firmRouter,
  serveRouter,
  systemRouter,
  {
    path: '*',
    redirect: '/404',
    meta: { hidden: true }
  }
]

/**
 * 生成路由
 */
const createRouter = () =>
  new Router({
    // mode: 'history',  // Disabled due to Github Pages doesn't support this, enable this if you need.
    scrollBehavior: (to, from, savedPosition) => {
      if (savedPosition) {
        return savedPosition
      } else {
        return { x: 0, y: 0 }
      }
    },
    base: process.env.BASE_URL,
    routes: constantRoutes
  })

const router = createRouter()

/**
 * 重置路由
 */
export function resetRouter() {
  const newRouter = createRouter();
  (router as any).matcher = (newRouter as any).matcher // reset router
}

/**
 * 导出路由
 */
export default router
