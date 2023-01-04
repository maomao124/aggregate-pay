import Vue from 'vue'
import ElementUi from 'element-ui'
import NProgress from 'nprogress'
import 'nprogress/nprogress.css'
import { sync } from 'vuex-router-sync'
import mcommon from '@hanyk/mcommon'
import App from './App.vue'
import './registerServiceWorker'
import router from './router'
import store from './store'
import Vcomp from '@/components/common/index'
import api from '@/api'
import Toast from '@/components/common/toast/index.js'
import Cookies from 'js-cookie'

Vue.config.productionTip = false
Vue.prototype.$api = api

Vue.use(ElementUi, { size: 'small', zIndex: 3000 })
Vue.use(mcommon)
Vue.use(Vcomp)
sync(store, router)
Vue.prototype.$Toast = Toast


router.beforeEach((to, from, next) => {
  NProgress.start()
  if (Cookies.get('sessionToken')) {
    next()
  } else {
    if (!to.meta.notNeedAuth) next('/login')
    else next()
  }
})
router.afterEach(() => {
  NProgress.done()
})

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
