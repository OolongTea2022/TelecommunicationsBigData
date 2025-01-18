<template>

  <div id="PopularAppTrafficTracking" style=" height: 500px; width:800px;"></div>
</template>

<script setup>
import * as echarts from "echarts";
import { onMounted } from "vue";

function showImg(){
  const myChart = echarts.init(document.getElementById("PopularAppTrafficTracking"));


  const option = {
    title: {
      text: '热门APP流量跟踪图'
    },
    tooltip: {
      trigger: 'axis'
    },
    legend: {
      data: ['手机网速测试', 'PPTV聚力', '腾讯视频', '优酷视频', '看片神器']
    },
    grid: {
      left: '3%',
      right: '4%',
      bottom: '3%',
      containLabel: true
    },
    xAxis: {
      type: 'category',
      name: '单位(小时)',
      boundaryGap: false,
      data: ['01', '02', '03', '04', '05', '06', '07','08','09','10','11','12','13','14','15','16','17','18','19','20','21','22','23','24']
    },
    yAxis: {
      type: 'value',
      scale: true,
      name: '单位(GB)',
      max: 4000,
      min: 0,
    },
    series: [
      {
        name: '手机网速测试',
        type: 'line',
        data: [267, 431, 120, 88, 197, 312, 247, 485, 908, 719, 567, 949, 683, 1023, 813, 1024, 759, 530, 707, 810, 900, 621, 846, 0],
        areaStyle: {}
      },
      {
        name: 'PPTV聚力',
        type: 'line',
        data: [2851, 3809, 3367, 3698, 2132, 1503, 396, 362, 90, 304, 123, 726, 342, 0, 95, 61, 0, 0, 249, 119, 550, 1153, 1793,0],
        areaStyle: {}
      },
      {
        name: '腾讯视频',
        type: 'line',
        data: [98, 0, 0, 0, 0, 234, 132, 196, 0, 1, 0, 98, 501, 163, 612, 547, 293, 0, 10, 671, 478, 276, 535, 0],
        areaStyle: {}
      },
      {
        name: '优酷视频',
        type: 'line',
        data: [0, 0, 0, 0, 0, 269, 30, 0, 0, 1, 35, 24, 0, 0, 0, 0, 0, 0, 0, 38, 363, 2301, 0, 0],
        areaStyle: {}
      },
      {
        name: '看片神器',
        type: 'line',
        data: [265, 1308, 162, 368, 587, 0, 0, 0, 0, 0, 0, 36, 338, 15, 0, 0, 0, 0, 0, 0, 0, 66, 150, 0],
        areaStyle: {}
      }
    ]
  };

  option && myChart.setOption(option);
}

onMounted(()=>{
  showImg();
})



</script>

<style scoped>

</style>
