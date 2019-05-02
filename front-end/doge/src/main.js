import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'

import axios from 'axios'
import VueAxios from 'vue-axios'
import iView from 'iview' // iView依赖
import 'iview/dist/styles/iview.css' // 引入iView css样式
Vue.use(VueAxios, axios)
Vue.use(iView) // 使用iView组件

Vue.config.productionTip = false

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
