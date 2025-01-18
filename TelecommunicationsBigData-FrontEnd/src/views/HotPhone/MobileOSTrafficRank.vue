<template>


  <el-row :gutter="20">
    <el-col :span="10"><div class="grid-content ep-bg-purple" />
      <div id="MobileOSTrafficRank1" style=" height: 500px; width:500px;"></div>
    </el-col>
    <el-col :span="10"><div class="grid-content ep-bg-purple" />
      <div id="MobileOSTrafficRank2" style=" height: 500px; width:500px; "></div>
    </el-col>
  </el-row>
</template>

<script setup>
import * as echarts from "echarts";
import { onMounted } from "vue";

function showImg(){
  const myChart1 = echarts.init(document.getElementById("MobileOSTrafficRank1"));
  const myChart2 = echarts.init(document.getElementById("MobileOSTrafficRank2"));


  const option1 = {
    title: {
      text: '手机OS流量排名'
    },
    legend: {},
    tooltip: {},
    dataset: {
      source: [
        ['product','All', '3G', '2G'],
        ['android4.1.2', 3628, 3512,115],
        ['android4.3', 1141, 0, 1141],
        ['android2.3.7', 46, 46, 0],
        ['android4.1.1',28, 21,7]
      ]
    },
    xAxis: { type: 'category' },
    yAxis: {
      type: 'value',
      scale: true,
      name: '单位(GB)',
      max: 4000,
      min: 0,
      boundaryGap: [0.2, 0.2]
    },
    // Declare several bar series, each will be mapped
    // to a column of dataset.source by default.
    series: [{ type: 'bar' }, { type: 'bar' }, { type: 'bar' }]
  };

  const option2 = {
    tooltip: {
      trigger: 'item'
    },
    legend: {
      orient: 'vertical',
      left: 'left'
    },
    series: [
      {
        name: 'Access From',
        type: 'pie',
        radius: '50%',
        data: [//饼图数据
          {value: 3683361116, name: 'android4.1.2'},
          {value: 1197264914, name: 'android4.3'},
          {value: 48440870, name: 'android2.3.7'},
          {value: 30327545, name: 'android4.1.1'},
          {value: 110376497520,name: '其他'}
        ],
        emphasis: {
          itemStyle: {
            shadowBlur: 10,
            shadowOffsetX: 0,
            shadowColor: 'rgba(0, 0, 0, 0.5)'
          }
        }
      }
    ]
  };

  myChart1.setOption(option1);
  myChart2.setOption(option2);
}

onMounted(()=>{
  showImg();
})



</script>

<style scoped>
.el-row {
  margin-bottom: 20px;
}
.el-row:last-child {
  margin-bottom: 0;
}
.el-col {
  border-radius: 4px;
}

.grid-content {
  border-radius: 4px;
  min-height: 36px;
}

.demo-form-inline .el-input {
  --el-input-width: 150px;
}

.demo-form-inline .el-select {
  --el-select-width: 150px;
}

</style>
