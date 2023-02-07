import Vue from 'vue'
import moment from 'moment'

moment.locale('zh-cn')
Vue.filter('dateTimeFormat', function(value: string) {
  return moment(value).format('YYYY-MM-DD HH:mm:ss')
})
