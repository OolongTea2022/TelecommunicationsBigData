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

    <div id="NetworkSpeedRank" style="background-color: #FFFFFF; height: 95%; width:98%; margin:.1rem; position: relative;">
        <div style="position: absolute; top: 0; left: 0; font-size: 12px; color: black;">网络速率(下行)</div>
    </div>
</template>

<script setup>
import * as echarts from 'echarts';
import { onMounted } from "vue";

function showImg() {
    const myChart = echarts.init(document.getElementById('NetworkSpeedRank'));
    const option = {
        legend: {},
        tooltip: {},
        dataset: {
            source: [
                ['product', '2012', '2013', '2014', '2015'],
                ['Matcha Latte', 41.1, 30.4, 65.1, 53.3],
                ['Milk Tea', 86.5, 92.1, 85.7, 83.1],
                ['Cheese Cocoa', 24.1, 67.2, 79.5, 86.4]
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
    --el-input-width: 250px; /* 增加输入框宽度 */
}

.demo-form-inline.el-select {
    --el-select-width: 250px; /* 增加选择框宽度 */
}

/* 新添加的样式类，用于调整时间选择器位置 */
.date-picker-offset {
    margin-left: 10px; /* 可根据需要调整这个值 */
}

/* 调整表单的整体宽度 */
.demo-form-inline {
    width: 80%; /* 可根据需要调整这个值 */
}

/* 调整显示图表的 div 的大小 */
#NetworkSpeedRank {
    height: 500px; /* 可根据需要调整这个值 */
    width: 98%; /* 可根据需要调整这个值 */
    margin: 0.1rem;
    position: relative;
}
</style>