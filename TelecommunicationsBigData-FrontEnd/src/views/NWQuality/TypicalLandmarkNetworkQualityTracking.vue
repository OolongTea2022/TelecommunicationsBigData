<template lang="html">
    <el-form :inline="true" :model="formInline" class="demo-form-inline">
    
    <el-form-item label="运营商">
      <el-select
        v-model="formInline.region"
        placeholder=" "
        clearable
      >
        <el-option label="CMCC" value="CMCC" />
        <el-option label="CUCC" value="CUCC" />
        <el-option label="CTCC" value="CTCC" />
      </el-select>
    </el-form-item>
    <el-form-item label="网络质量">
      <el-select
        v-model="formInline.network"
        placeholder=" "
        clearable
      >
        <el-option label="Zone one" value="shanghai" />
        <el-option label="Zone two" value="beijing" />
      </el-select>
    </el-form-item>
    <el-form-item label="地标">
      <el-select
        v-model="formInline.landmark"
        placeholder=" "
        clearable
      >
        <el-option label="大学" value="大学" />
        <el-option label="居民区" value="居民区" />
        <el-option label="商业区" value="商业区" />
      </el-select>
    </el-form-item>
    <el-form-item label="网络制式">
      <el-select
        v-model="formInline.zhishi"
        placeholder=" "
        clearable
      >
        <el-option label="Zone one" value="shanghai" />
        <el-option label="Zone two" value="beijing" />
      </el-select>
    </el-form-item>
    <el-form-item label="时间颗粒度">
      <el-select
        v-model="formInline.time"
        placeholder=" "
        clearable
      >
        <el-option label="月" value="月" />
        <el-option label="日" value="日" />
        <el-option label="时" value="时" />
      </el-select>
    </el-form-item>
    <el-form-item>
      <div class="demo-date-picker">
        <div class="block">
          <span class="demonstration">时间范围</span>
          <!-- 给时间选择器添加一个类名用于样式调整 -->
          <el-date-picker
            class="date-picker-offset"
            v-model="value2"
            type="daterange"
            start-placeholder="Start Date"
            end-placeholder="End Date"
            :default-value="[new Date(2010, 9, 1), new Date(2010, 10, 1)]"
          />
        </div>
      </div>
    </el-form-item>
    <el-form-item>
      <el-button type="primary" @click="onSubmit">Query</el-button>
    </el-form-item>
  </el-form>
    
    <div id="TypicalLandmarkNetworkQualityTracking" style="background-color: #FFFFFF; height: 95%; width:95%; margin:.1rem; position: relative;">
        <div style="position: absolute; top: 0; left: 0; font-size: 12px; color: black;">典型地标网络质量跟踪图</div>
    </div>
    
</template>

<script setup>
import * as echarts from 'echarts';
import { onMounted } from "vue";

function showImg() {
    const myChart = echarts.init(document.getElementById('TypicalLandmarkNetworkQualityTracking'));
    const option = {
        title: {
            text: '典型地标网络质量跟踪图'
        },
        tooltip: {
            trigger: 'axis',
            axisPointer: {
                type: 'cross',
                label: {
                    backgroundColor: '#6a7985'
                }
            }
        },
        legend: {
            data: ['CMCC'] // 只保留 Email 的图例
        },
        toolbox: {
            feature: {
                saveAsImage: {}
            }
        },
        grid: {
            left: '3%',
            right: '4%',
            bottom: '3%',
            containLabel: true
        },
        xAxis: [
            {
                type: 'category',
                boundaryGap: false,
                axisLine: {
                    lineStyle: {
                        color: 'red', // 将 x 轴的轴线颜色修改为红色
                        width: 2 // 将 x 轴的轴线宽度修改为 2px
                    }
                },
                data: ['01', '02', '03', '04', '05', '06', '07', '08', '09', '10', '11', '12', '13', '14', '15', '16', '17', '18', '19', '20', '21', '22', '23', '24', '25', '26', '27', '28', '29', '30', '31']
            }
        ],
        yAxis: [
            {
                type: 'value',
                axisLine: {
                    lineStyle: {
                        color: 'red', // 将 y 轴的轴线颜色修改为红色
                        width: 2 // 将 y 轴的轴线宽度修改为 2px
                    }
                }
            }
        ],
        series: [
            {
                name: 'CMCC',
                type: 'line',
                stack: 'Total',
                areaStyle: {},
                emphasis: {
                    focus: 'series'
                },
                data: [120, 130, 140, 150, 160, 170, 180, 190, 200, 210, 220, 230, 240, 250, 260, 270, 280, 290, 300, 310, 320, 330, 340, 350, 360, 370, 380, 390, 400, 410, 420, 430, 440, 450, 460, 470, 480, 490, 500]
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