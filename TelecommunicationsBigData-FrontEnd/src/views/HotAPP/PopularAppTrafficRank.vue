<template lang="html">
    <el-form :inline="true" :model="formInline" class="demo-form-inline">
  
  <el-form-item label="Activity zone">
    <el-select
      v-model="formInline.region"
      placeholder="Activity zone"
      clearable
    >
      <el-option label="Zone one" value="shanghai" />
      <el-option label="Zone two" value="beijing" />
    </el-select>
  </el-form-item>
  <el-form-item label="Activity zone">
    <el-select
      v-model="formInline.region"
      placeholder="Activity zone"
      clearable
    >
      <el-option label="Zone one" value="shanghai" />
      <el-option label="Zone two" value="beijing" />
    </el-select>
  </el-form-item>
  
  <el-form-item>
    <el-button type="primary" @click="onSubmit">Query</el-button>
  </el-form-item>
</el-form>
<div class="demo-date-picker">
  <div class="block">
    <span class="demonstration">daterange</span>
    <el-date-picker
      v-model="value2"
      type="daterange"
      start-placeholder="Start Date"
      end-placeholder="End Date"
      :default-value="[new Date(2010, 9, 1), new Date(2010, 10, 1)]"
    />
  </div>
</div>
  <div id="PopularMobileNetworkQualityRank" style="background-color: #FFFFFF; height: 95%; width:95%; margin:.1rem; position: relative;">
      <div style="position: absolute; top: 0; left: 0; font-size: 12px; color: black;">典型地标网络质量跟踪图</div>
  </div>
</template>

<script setup>
import * as echarts from 'echarts';
import { onMounted } from "vue";

function showImg() {
  const myChart = echarts.init(document.getElementById('PopularMobileNetworkQualityRank'));
  const builderJson = {
      all: 10887,
      charts: {
          bar: 7561,
          line: 7778,
          pie: 7355
      }
  };
  const downloadJson = {
      'echarts.min.js': 17365,
      'echarts.js': 14890
  };

  // 假设我们根据下载量和图表类型数量的某种关联逻辑来计算新的数据
  const relatedData = {};
  const chartKeys = Object.keys(builderJson.charts);
  const downloadKeys = Object.keys(downloadJson);
  let totalDownloads = 0;
  for (let key of downloadKeys) {
      totalDownloads += downloadJson[key];
  }
  for (let key of chartKeys) {
      relatedData[key] = (builderJson.charts[key] / totalDownloads) * 100;
  }

  const option = {
      backgroundColor: '#FFFFFF',
      tooltip: {},
      title: [
          {
              text: '在线构建图表类型统计',
              subtext: '总计'+ builderJson.all,
              left: '10%',
              textAlign: 'center'
          },
          {
              text: '图表类型占下载量的比例',
              left: '60%',
              textAlign: 'center'
          }
      ],
      grid: [
          {
              top: 50,
              width: '50%',
              bottom: 50,
              left: 10,
              containLabel: true
          },
          {
              top: 50,
              width: '30%',
              bottom: 50,
              left: '60%',
              containLabel: true
          }
      ],
      xAxis: [
          {
              type: 'category',
              data: chartKeys,
              axisLabel: {
                  interval: 0,
                  rotate: 0
              },
              splitLine: {
                  show: false
              }
          }
      ],
      yAxis: [
          {
              type: 'value',
              splitLine: {
                  show: false
              }
          }
      ],
      series: [
          {
              type: 'bar',
              stack: 'chart',
              z: 3,
              label: {
                  position: 'top',
                  show: true
              },
              data: chartKeys.map(key => relatedData[key] || 0)
          },
          {
              type: 'pie',
              radius: '40%',
              center: ['80%', '50%'],
              data: chartKeys.map(key => ({
                  name: key,
                  value: relatedData[key] || 0
              }))
          }
      ]
  };
  myChart.setOption(option);
}

onMounted(() => {
  showImg();
})

import { reactive } from 'vue'

const formInline = reactive({
user: '',
region: '',
date: '',
})

const onSubmit = () => {
console.log('submit!')
}
import { ref } from 'vue'

const value1 = ref('')
const value2 = ref('')
</script>

<style lang="css">
.demo-form-inline .el-input {
--el-input-width: 220px;
}

.demo-form-inline .el-select {
--el-select-width: 220px;
}
</style>