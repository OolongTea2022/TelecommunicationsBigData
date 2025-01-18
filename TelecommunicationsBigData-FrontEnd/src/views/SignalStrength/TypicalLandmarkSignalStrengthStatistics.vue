<template lang="html">
<el-form :inline="true" :model="formInline" class="demo-form-inline">
    <el-form-item label="运营商">
    <el-select
        v-model="formData.nwOperator"
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
                v-model="formData.Date"
                type="daterange"
                start-placeholder="开始日期"
                end-placeholder="结束日期"
                format="YYYY/MM/DD/HH"
                value-format="YYYYMMDDHH"
                :default-value="[new Date(2010, 9, 1), new Date(2020, 10, 1)]"
                />
            </div>
        </div>

    </el-form-item>

    <el-form-item>
    <el-button type="primary" @click="onSubmit">Query</el-button>
    </el-form-item>
</el-form>



<div id="TypicalLandmarkSignalStrengthStatistics" style="background-color: #FFFFFF; height: 95%; width:95%; margin:.1rem; position: relative;">

    

</div>
    
</template>

<script setup>
import * as echarts from 'echarts';
import { onMounted } from "vue";
import { getTypicalSignalStrengthTrackingByLandmark } from '../../api/signal_strength'
var a = 0;
var b = 0;
var c = 0;

function showImg() {
    const myChart = echarts.init(document.getElementById('TypicalLandmarkSignalStrengthStatistics'));
    const option = {
        legend: {},
        tooltip: {},
        dataset: {
            source: [
                ['product', '4G', '3G', '2G'],
                ['商业区', a,b,c],
                
                
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

const formData = reactive({
    nwOperator: '',
    Date:[],
})

const onSubmit = async () => {
        const params = {
            nwOperator: formData.nwOperator,
            startDate: formData.Date[0],
            endDate: formData.Date[1],
            // startDate: 2017070817,
            // endDate: 2018070817
        };
        console.log("发送前",params);
        // Call the searchMistakeList function to get the data
        const res = await getTypicalSignalStrengthTrackingByLandmark(params);

        console.log("接受" , res);

        if (res.data.code == '200') {
            // 提取 userLon 和 userLat 并更新 points
            a = res.data.data[0].rssi;
            b = res.data.data[1].rssi;
            c = res.data.data[2].rssi;
            // console.log(res.data.data.data[0].rssi)
            console.log(res.data.data[0].rssi)
            showImg();
            
        } else {
            console.error("获取出错记录失败", res.message);
        }
    };


</script>

<style>
.demo-form-inline .el-input {
--el-input-width: 150px;
}

.demo-form-inline .el-select {
--el-select-width: 150px;
}
</style>