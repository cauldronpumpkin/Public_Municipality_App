import Vue from 'vue'
import App from './App.vue'
import './registerServiceWorker'
import router from './router'
import store from './store'
import Vuetify from 'vuetify'
import vuetify from './plugins/vuetify';
import 'vuetify/dist/vuetify.min.css'
import axios from 'axios'
import VueSession from 'vue-session'
import VueGoogleCharts from 'vue-google-charts'
 
Vue.use(VueGoogleCharts)

Vue.use(VueSession)

Vue.use(Vuetify)


Vue.config.productionTip = false
const base = axios.create({
  baseURL: 'http://localhost:8000'
})
Vue.prototype.$http = base
new Vue({
  router,
  vuetify,
  store,
  render: h => h(App)
}).$mount('#app')
