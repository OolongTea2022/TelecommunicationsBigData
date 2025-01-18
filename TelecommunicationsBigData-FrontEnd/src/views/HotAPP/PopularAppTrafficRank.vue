<template lang="html">
  <div>
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
      <el-form-item label="运营商">
        <el-select
          v-model="formInline.region"
          placeholder="运营商"
          clearable
        >
          <el-option label="CMCC" value="CMCC" />
          <el-option label="CUCC" value="CUCC" />
          <el-option label="CTCC" value="CTCC" />
        </el-select>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="onSubmit">Query</el-button>
      </el-form-item>
    </el-form>
    <div class="demo-date-picker">
      <div class="block">
        <span class="demonstration">时间范围</span>
        <el-date-picker
          v-model="value2"
          type="daterange"
          start-placeholder="Start Date"
          end-placeholder="End Date"
          :default-value="[new Date(2010, 9, 1), new Date(2010, 10, 1)]"
        />
      </div>
    </div>
    <div
      id="PopularMobileNetworkQualityRank"
      style="background-color: #FFFFFF; height: 400px; width: 100%; margin:.1rem; position: relative;"
    >
    </div>
    <div
      id="PieChart"
      style="background-color: #FFFFFF; height: 400px; width: 100%; margin:.1rem; position: relative;"
    >
    </div>
  </div>
</template>

<script setup>
import * as echarts from 'echarts';
import { onMounted, reactive, ref } from 'vue';
import { getTrafficRank } from '../../api/hot_app';

const datasetSource = ref([
    { name: 'Matcha Latte', all: 90 },  
    { name: 'Milk Tea', all: 150 },    
    { name: 'Cheese Cocoa', all: 95 },
    { name: 'Walnut Brownie', all: 55 },
    { name: 'Walnut Brodawnie', all: 355 },
    { name: 'Walnut Brodfdfawnie', all: 315 },
    { name: 'Test Item 1', all: 200 },  // 新增数据项
    { name: 'Test Item 2', all: 150 },  // 新增数据项
    // 可以继续添加数据项
  ]);


// 初始化图表并展示数据
function showImg() {
  const myChart = echarts.init(document.getElementById('PopularMobileNetworkQualityRank'));
  const pieChart = echarts.init(document.getElementById('PieChart'));

  // 示例数据源，支持任意多个数据项

  // 按照 ALL 数据进行排序，降序排列
  const datasetWithSortedAll = datasetSource.value.sort((a, b) => b.all - a.all);

  // 获取前5个数据
  const top5Data = datasetWithSortedAll.slice(0, 5);

  const option = {
    dataset: [
      {
        dimensions: ['name', 'all'],
        source: top5Data.map(item => [item.name, item.all]),  // 使用前5个数据
      },
    ],
    xAxis: {
      type: 'category',
      axisLabel: { interval: 0, rotate: 30 }
    },
    yAxis: {},
    series: {
      type: 'bar',
      encode: { x: 'name', y: 'all' },
    }
  };

  // 设置柱状图选项
  myChart.setOption(option);

  // 准备饼状图数据，使用柱状图的前5个数据
  const pieData = top5Data.map(item => ({
    name: item.name,
    value: item.all, // 使用 ALL 作为饼图数据
  }));

  const pieOption = {
    series: [
      {
        name: 'ALL占比',
        type: 'pie',
        radius: '55%',
        center: ['50%', '50%'],
        data: pieData,
        emphasis: {
          itemStyle: {
            shadowBlur: 10,
            shadowOffsetX: 0,
            shadowColor: 'rgba(0, 0, 0, 0.5)',
          },
        },
      },
    ],
  };

  // 设置饼状图的选项
  pieChart.setOption(pieOption);
}

// 在页面加载后渲染图表
onMounted(() => {
  showImg();
});

const formInline = reactive({
  user: '',
  region: '',
  date: '',
});

const onSubmit = async () => {

//TODO偷鸡写法，传递空参数，后端写死回传数据
const params = {};


console.log("发送前",params);
// Call the searchMistakeList function to get the data
const res = await getTrafficRank(params);

console.log("接受" , res);

if (res.data.code == '200') {
    // 提取 userLon 和 userLat 并更新 points
    datasetSource.value = res.data.data.map(item => {
      name: item.appName
      all: item.heat
        // parseFloat(item.userLon), // 经度
        // parseFloat(item.userLat), // 纬度
        // 1 // 固定值
    });
    showImg();
    console.log("zheshi_point",points)
} else {
    console.error("获取出错记录失败", res.message);
}




};

</script>

<style lang="css">
.demo-form-inline.el-input {
  --el-input-width: 220px;
}

.demo-form-inline.el-select {
  --el-input-width: 220px;
}

/* 为了让图表并排显示，使用flex布局 */
.charts-container {
  display: flex;
  justify-content: space-between;
  gap: 1rem;
}
</style>
