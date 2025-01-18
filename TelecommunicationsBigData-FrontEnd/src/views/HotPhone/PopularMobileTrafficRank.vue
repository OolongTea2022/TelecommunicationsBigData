<template>


  <el-row :gutter="20">
    <el-col :span="10"><div class="grid-content ep-bg-purple" />
      <div id="PopularMobileTrafficRank1" style=" height: 500px; width:500px;"></div>
    </el-col>
    <el-col :span="10"><div class="grid-content ep-bg-purple" />
      <div id="PopularMobileTrafficRank2" style=" height: 500px; width:500px; "></div>
    </el-col>
  </el-row>
</template>

<script setup>
import * as echarts from "echarts";
import { onMounted } from "vue";

function showImg(){
  const myChart1 = echarts.init(document.getElementById("PopularMobileTrafficRank1"));
  const myChart2 = echarts.init(document.getElementById("PopularMobileTrafficRank2"));


  const option1 = {
    title: {
      text: '热门手机流量排名'
    },
    legend: {},
    tooltip: {},
    dataset: {
      source: [
        ['product','All', '3G', '2G'],
        ['samsung GT-N7100', 22, 22,0],
        ['samsung SM-N9006', 9, 0, 9],
        ['samsung SCH-I535', 6, 6, 0],
        ['YuLong Coolpad 5879',4, 3,1],
        ['samsung GT-N7108',2,1,0]
      ]
    },
    xAxis: { type: 'category' },
    yAxis: {
      type: 'value',
      scale: true,
      name: '单位(GB)',
      max: 25,
      min: 0,
      boundaryGap: [0.2, 0.2]
    },
    // Declare several bar series, each will be mapped
    // to a column of dataset.source by default.
    series: [{ type: 'bar' }, { type: 'bar' }, { type: 'bar' }]
  };

  const option2 = {
    title: {
      text: '热门手机排名',
      left: 'center'
    },
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
          {value: 2768654262, name: 'samsung GT-N7100'},
          {value: 1217856114, name: 'samsung SM-N9006'},
          {value: 763334820, name: 'samsung SCH-I535'},
          {value: 417043906, name: 'YuLong Coolpad 5879'},
          {value: 245843099, name: 'samsung GT-N7108'},
          {value: 619828344,name: '其他'}
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

</style>
