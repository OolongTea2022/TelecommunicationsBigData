<template lang="html">
    <el-form :inline="true" :model="formInline" class="demo-form-inline">
        <el-form-item label="网络质量">
            <el-select
                v-model="formInline.speedType"
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
                v-model="formInline.nwOperator"
                placeholder=" "
                clearable
            >
                <el-option label="CMCC" value="CMCC" />
                <el-option label="CUCC" value="CUCC" />
                <el-option label="CTCC" value="CTCC" />
            </el-select>
        </el-form-item>
        <el-form-item label="网络制式">
            <el-select
                v-model="formInline.nwType"
                placeholder=" "
                clearable
            >
                <el-option label="4G" value="4G" />
                <el-option label="3G" value="3G" />
                <el-option label="2G" value="2G" />
            </el-select>
        </el-form-item>
        <el-form-item>
            <div class="demo-date-picker">
                <div class="block">
                    <span class="demonstration">时间范围</span>
                    <!-- 给时间选择器添加一个类名用于样式调整 -->
                    <el-date-picker
                        class="date-picker-offset"
                        v-model="formInline.Date"
                        type="daterange"
                        start-placeholder="Start Date"
                        end-placeholder="End Date"
                        format="YYYY/MM/DD/HH"
                        value-format="YYYYMMDDHH"
                        :default-value="[new Date(2010, 9, 1), new Date(2010, 10, 1)]"
                    />
                </div>
            </div>
        </el-form-item>
        <el-form-item>
            <el-button type="primary" @click="onSubmit">Query</el-button>
        </el-form-item>
    </el-form>

    <div id="TypicalLandmarkNetworkQualityStatistics" style="background-color: #FFFFFF; height: 95%; width:98%; margin:.1rem; position: relative;">
        <div style="position: absolute; top: 0; left: 0; font-size: 12px; color: black;">网络速率(下行)</div>
    </div>
</template>

<script setup>
import * as echarts from 'echarts';
import { onMounted , ref } from "vue";

import  { getQualityStatistics } from '../../api/network_quality'
var a = 0;
var b = 0;
var c = 0;
function showImg() {
    const myChart = echarts.init(document.getElementById('TypicalLandmarkNetworkQualityStatistics'));
    const option = {
        legend: {},
        tooltip: {},
        dataset: {
            source: [
                ['product', ''],
                ['CMCC', a],
                ['CTCC', b],
                ['CUCC', c]
            ]
        },
        xAxis: [
            // 只保留一个 x 轴
            { type: 'category', gridIndex: 0 }
        ],
        yAxis: [
            // 只保留一个 y 轴
            { gridIndex: 0 }
        ],
        grid: [
            // 只保留一个网格
            {}
        ],
        series: [
            // 只保留在第一个网格中的系列
            { type: 'bar', seriesLayoutBy: 'row' },
            { type: 'bar', seriesLayoutBy: 'row' },
            { type: 'bar', seriesLayoutBy: 'row' }
        ]
    };
    myChart.setOption(option);
}

onMounted(() => {
    showImg();
})


const formInline = ref({
    speedType: '',
    nwType: '',
    nwOperator:'',
    Date:[],
})

const onSubmit = async () => {
        const params = {
            speedType:formInline.value.speedType,
            nwType: formInline.value.nwType,
            nwOperator: formInline.value.nwOperator,
            startDate: formInline.value.Date[0],
            endDate: formInline.value.Date[1]
        };
        console.log("发送前",params);
        // Call the searchMistakeList function to get the data
        const res = await getQualityStatistics(params);

        console.log("接受" , res);

        if (res.data.code == '200') {
            //     // 提取 userLon 和 userLat 并更新 points
            //     points.value = res.data.data.map(item => [
            //     parseFloat(item.userLon), // 经度
            //     parseFloat(item.userLat), // 纬度
            //     1 // 固定值
            // ]);
            a = 
            b = 
            c = 

            showImg();
            
        } else {
            console.error("获取出错记录失败", res.message);
        }
    };


</script>

<style lang="css">
.demo-form-inline.el-input {
    --el-input-width: 150px; /* 减小输入框宽度 */
}

.demo-form-inline.el-select {
    --el-select-width: 150px; /* 减小选择框宽度 */
}

/* 新添加的样式类，用于调整时间选择器位置 */
.date-picker-offset {
    margin-left: 10px; /* 可根据需要调整这个值 */
}

/* 调整表单的整体宽度 */
.demo-form-inline {
    width: 60%; /* 减小表单整体宽度 */
}

/* 调整显示图表的 div 的大小 */
#NetworkSpeedRank {
    height: 500px; /* 可根据需要调整这个值 */
    width: 98%; /* 可根据需要调整这个值 */
    margin: 0.1rem;
    position: relative;
}
</style>