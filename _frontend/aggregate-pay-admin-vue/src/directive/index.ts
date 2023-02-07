import Vue from 'vue'
import { UserModule } from '@/store/modules/user'
import { DirectiveBinding } from 'vue/types/options'

// 权限指令
Vue.directive('has', {
  inserted: (el: HTMLElement, binding: DirectiveBinding) => {
    if (!Vue.prototype.$_has(binding.value)) {
      if (el && el.parentNode) {
        el.parentNode.removeChild(el)
      }
    }
  }
})

// 权限检查方法
Vue.prototype.$_has = (value: string) => {
  return UserModule.buttons.includes(value)
}
