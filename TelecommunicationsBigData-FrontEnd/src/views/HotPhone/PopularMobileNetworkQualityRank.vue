<template>

  <div id="PopularMobileNetworkQualityRank" style=" height: 500px; width:800px;"></div>
</template>

<script setup>
import * as echarts from "echarts";
import { onMounted } from "vue";

function showImg(){
  const myChart = echarts.init(document.getElementById("PopularMobileNetworkQualityRank"));


  const option = {
    title: {
      text: '热门手机网络质量排名'
    },
    legend: {},
    tooltip: {},
    xAxis: {
      type: 'category',
      data: ['HTC Desire','Samsung Nexus S','Lenovo A798t','ZTE N880F','ZTE N5L','samsung GT-N7100']
    },
    yAxis: {
      type: 'value',
      scale: true,
      name: '单位(KB/s)',
      max: 25.0,
      min: 0,
      boundaryGap: [0.2, 0.2]
    },
    // Declare several bar series, each will be mapped
    // to a column of dataset.source by default.
    series: [{
      data: [23,21,14,11,11,12],
      type: 'bar'
    }]
  };

  myChart.setOption(option);
}

onMounted(()=>{
  showImg();
})



</script>

<style scoped>
.demo-form-inline .el-input {
  --el-input-width: 150px;
}

.demo-form-inline .el-select {
  --el-select-width: 150px;
}

</style>
