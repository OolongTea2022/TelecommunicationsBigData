// 引入需要的模块
import { createRouter, createWebHistory } from "vue-router";

// import component from "element-plus/es/components/tree-select/src/tree-select-option.mjs";


// 下面使用了es6的对象增强写法，命名必须是routes
const routes = [

  {
    //默认展示，这是主页面路由必须加斜杠 /
    path: "/",
    component: () => import("../views/MainPanel.vue"),
  },

  // {
  //   //默认展示，这是主页面路由必须加斜杠 /
  //   path: "/",
  //   component: () => import("../views/HomeView.vue"),
  // },

  

  {
    path: "/PathBookView",
    //路由懒加载
    component: () => import("../views/PathBookView.vue"),
  },

  


  // {
  //   path: "/UserList",
  //   //路由懒加载
  //   component: () => import("../views/UserList.vue"),
  // },
  // {
  //   path: "/Signup",
  //   //路由懒加载
  //   component: () => import("../views/Signup.vue"),
  // },
  // {
  //   path: "/Signup",
  //   //路由懒加载
  //   component: () => import("../views/Signup.vue"),
  // },
  // {
  //   path: "/Signup",
  //   //路由懒加载
  //   component: () => import("../views/Signup.vue"),
  // },



];

// 创建路由
const router = createRouter({
  history: createWebHistory(),
  routes,
});

// 导出路由
export default router;