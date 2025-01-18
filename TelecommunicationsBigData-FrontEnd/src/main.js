import { createApp } from 'vue'
import './style.css'
// import './utils/rem'


//引入element-icon
import * as ElementPlusIconsVue from '@element-plus/icons-vue'

//引入element-plus
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'


// 引入echarts
import Echarts from 'vue-echarts'
import * as echarts from 'echarts'


import App from './App.vue'

import router from './router'


const app = createApp(App);

//挂载element-icon
for (const [key, component] of Object.entries(ElementPlusIconsVue)) {
    app.component(key, component)
}

// 使用组件
app.component('e-charts',Echarts)
// 全局挂载 echarts
app.config.globalProperties.$echarts = echarts


app.use(router).use(ElementPlus)
app.mount('#app')
