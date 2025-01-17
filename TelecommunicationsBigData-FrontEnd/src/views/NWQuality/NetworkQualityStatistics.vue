<template lang="html">
<el-form :inline="true" :model="formInline" class="demo-form-inline">
    <el-form-item label="网络质量">
    <el-select
        v-model="formInline.region"
        placeholder=" "
        clearable
    >
        <el-option label="上行速度" value="上行速度" />
        <el-option label="下行速度" value="下行速度" />
        <el-option label="延迟" value="延迟" />
    </el-select>
    </el-form-item>
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

<div id="NetworkQualityStatistics" style="background-color: #FFFFFF; height: 95%; width:95%; margin:.1rem; position: relative;">
    <div style="position: absolute; top: 0; left: 0; font-size: 12px; color: black;">网络速率(下行)</div>
</div>
</template>

<script setup>
import * as echarts from 'echarts';
import { onMounted } from "vue";

function showImg() {
    const myChart = echarts.init(document.getElementById('NetworkQualityStatistics'));
    const option = {
        legend: {},
        tooltip: {},
        dataset: {
            source: [
                ['product', 'CMCC', 'CUCC', 'CTCC'],
                ['4G', 43.3, 85.8, 93.7],
                ['3G', 83.1, 73.4, 55.1],
                ['2G', 86.4, 65.2, 82.5]
            ]
        },
        xAxis: {
            type: 'category',
            axisLine: {
                lineStyle: {
                    color: 'blue' // 将 x 轴的线条颜色设置为蓝色
                }
            }
        },
        yAxis: {
            axisLine: {
                lineStyle: {
                    color: 'blue' // 将 y 轴的线条颜色设置为蓝色
                }
            }
        },
        // Declare several bar series, each will be mapped
        // to a column of dataset.source by default.
        series: [{ type: 'bar' }, { type: 'bar' }, { type: 'bar' }]
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
.demo-form-inline.el-input {
--el-input-width: 220px;
}

.demo-form-inline.el-select {
--el-select-width: 220px;
}

/* 新添加的样式类，用于调整时间选择器位置 */
.date-picker-offset {
margin-left: 10px; /* 可根据需要调整这个值 */
}
</style>