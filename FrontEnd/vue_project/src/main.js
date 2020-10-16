import Vue from 'vue'
import App from './App.vue'
import router from './router/index.js'
import './assets/css/style.css'
import './assets/css/vendor/bootstrap.min.css'
import './assets/css/vendor/owl.carousel.min.css'
import './assets/css/vendor/owl.theme.default.min.css'
import './assets/css/vendor/magnific-popup.css'
import './assets/css/vendor/animate.min.css' 
import './assets/css/fontawesome.css' 
import './assets/css/brands.css'
import './assets/css/solid.css'
import './assets/fonts/FontAwesome.otf'
import './assets/fonts/fontawesome-webfont.eot'
import './assets/fonts/fontawesome-webfont.svg'
import './assets/fonts/fontawesome-webfont.ttf'
import './assets/fonts/fontawesome-webfont.woff'
import './assets/fonts/fontawesome-webfont.woff2'
import './assets/fonts/sas-webfont.eot'
import './assets/fonts/sas-webfont.svg'
import './assets/fonts/sas-webfont.ttf'
import './assets/fonts/sas-webfont.woff'
import './assets/fonts/sas-webfont.woff2'


Vue.config.productionTip = false

new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>',
  render: h => h(App),
}).$mount('#app')
