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

//ConnectPoint
  {
    //默认展示，这是主页面路由必须加斜杠 /
    path: "/ConnectionPointsGeographicalDistribution",
    component: () => import("../views/ConnectPoint/ConnectionPointsGeographicalDistribution.vue"),
  },
  {
    
    path: "/ConnectionPointsRank",
    component: () => import("../views/ConnectPoint/ConnectionPointsRank.vue"),
  },

//DataConnection
  {
    
    path: "/DataConnectionRateDistribution",
    component: () => import("../views/DataConnection/DataConnectionRateDistribution.vue"),
  },
  {
    
    path: "/DataConnectionRateStatistics",
    component: () => import("../views/DataConnection/DataConnectionRateStatistics.vue"),
  },

//HotAPP
  {
    
    path: "/PopularAppMap",
    component: () => import("../views/HotAPP/PopularAppMap.vue"),
  },
  {
    
    path: "/PopularAppTrafficDistribution",
    component: () => import("../views/HotAPP/PopularAppTrafficDistribution.vue"),
  },
  {
    
    path: "/PopularAppTrafficRank",
    component: () => import("../views/HotAPP/PopularAppTrafficRank.vue"),
  },
  {
    
    path: "/PopularAppTrafficTracking",
    component: () => import("../views/HotAPP/PopularAppTrafficTracking.vue"),
  },
  {
    
    path: "/TypicalLandmarkPopularAppTrafficRank",
    component: () => import("../views/HotAPP/TypicalLandmarkPopularAppTrafficRank.vue"),
  },

//HotPhone
  {
    
    path: "/MobileOSDistribution",
    component: () => import("../views/HotPhone/MobileOSDistribution.vue"),
  },
  {
    
    path: "/MobileOSTrafficRank",
    component: () => import("../views/HotPhone/MobileOSTrafficRank.vue"),
  },
  {
    
    path: "/PopularMobileNetworkQualityRank",
    component: () => import("../views/HotPhone/PopularMobileNetworkQualityRank.vue"),
  },
  {
    
    path: "/PopularMobilePhoneTrafficDistribution",
    component: () => import("../views/HotPhone/PopularMobilePhoneTrafficDistribution.vue"),
  },
  {
    
    path: "/PopularMobilePhonesDistribution",
    component: () => import("../views/HotPhone/PopularMobilePhonesDistribution.vue"),
  },
  {
    
    path: "/PopularMobileTrafficRank",
    component: () => import("../views/HotPhone/PopularMobileTrafficRank.vue"),
  },


//NWQuality
  {
    
    path: "/NetworkQualityDistribution",
    component: () => import("../views/NWQuality/NetworkQualityDistribution.vue"),
  },
  {
    
    path: "/NetworkQualityStatistics",
    component: () => import("../views/NWQuality/NetworkQualityStatistics.vue"),
  },
  {
    
    path: "/NetworkSpeedRank",
    component: () => import("../views/NWQuality/NetworkSpeedRank.vue"),
  },
  {
    
    path: "/TypicalLandmarkNetworkQualityStatistics",
    component: () => import("../views/NWQuality/TypicalLandmarkNetworkQualityStatistics.vue"),
  },
  {
    
    path: "/TypicalLandmarkNetworkQualityTracking",
    component: () => import("../views/NWQuality/TypicalLandmarkNetworkQualityTracking.vue"),
  },

//PersonalPart
  {
    
    path: "/AppStreetView",
    component: () => import("../views/PersonalPart/AppStreetView.vue"),
  },
  {
    
    path: "/NetworkQuality",
    component: () => import("../views/PersonalPart/NetworkQuality.vue"),
  },
  {
    
    path: "/OSStreetView",
    component: () => import("../views/PersonalPart/OSStreetView.vue"),
  },
  {
    
    path: "/SignalCoverage",
    component: () => import("../views/PersonalPart/SignalCoverage.vue"),
  },


//SignalStrength
  {
    
    path: "/SignalStrengthDistribution",
    component: () => import("../views/SignalStrength/SignalStrengthDistribution.vue"),
  },
  {
    
    path: "/TypicalLandmarkSignalStrengthStatistics",
    component: () => import("../views/SignalStrength/TypicalLandmarkSignalStrengthStatistics.vue"),
  },
  {
    
    path: "/TypicalLandmarkSignalStrengthTracking",
    component: () => import("../views/SignalStrength/TypicalLandmarkSignalStrengthTracking.vue"),
  },


//测试
  {
    path: "/PathBookView",
    //路由懒加载
    component: () => import("../views/PathBookView.vue"),
  },
  {
    path: "/temp1",
    //路由懒加载
    component: () => import("../views/temp1.vue"),
  },


];

// 创建路由
const router = createRouter({
  history: createWebHistory(),
  routes,
});

// 导出路由
export default router;