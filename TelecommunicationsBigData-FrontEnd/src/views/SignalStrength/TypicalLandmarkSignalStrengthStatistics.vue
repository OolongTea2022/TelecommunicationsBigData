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


    <el-form-item>
        <div class="demo-date-picker">
            <div class="block">
                <span class="demonstration" style="margin-right: 10px;">时间范围</span>
                <el-date-picker
                v-model="value2"
                type="daterange"
                start-placeholder="开始日期"
                end-placeholder="结束日期"
                :default-value="[new Date(2010, 9, 1), new Date(2010, 10, 1)]"
                />
            </div>
        </div>

    </el-form-item>

    <el-form-item>
    <el-button type="primary" @click="onSubmit">Query</el-button>
    </el-form-item>
</el-form>



<div id="TypicalLandmarkSignalStrengthStatistics" style="background-color: #FFFFFF; height: 95%; width:95%; margin:.1rem; position: relative;">
        <!-- <div style="position: absolute; top: 0; left: 0; font-size: 12px; color: black;">网络速率(下行)</div> -->
    

</div>
    
</template>

<script setup>
import * as echarts from 'echarts';
import { onMounted } from "vue";

function showImg() {
    const myChart = echarts.init(document.getElementById('TypicalLandmarkSignalStrengthStatistics'));
    const option = {
        legend: {},
        tooltip: {},
        dataset: {
            source: [
                ['product', '4G', '3G', '2G'],
                ['商业区', -100,-200,-300],
                ['大学', -100,-200,-300],
                ['其它', -100,-200,-300]
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

</script>

<style>
.demo-form-inline .el-input {
--el-input-width: 150px;
}

.demo-form-inline .el-select {
--el-select-width: 150px;
}
</style>
