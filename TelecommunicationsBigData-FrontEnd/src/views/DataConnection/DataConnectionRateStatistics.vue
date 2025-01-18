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

    <div id="DataConnectionRateStatistics" style="background-color: #FFFFFF; height: 95%; width:98%; margin:.1rem; position: relative;">
        <div style="position: absolute; top: 0; left: 0; font-size: 12px; color: black;">网络速率(下行)</div>
    </div>
</template>

<script setup>
import * as echarts from 'echarts';
import { onMounted } from "vue";

function showImg() {
    const myChart = echarts.init(document.getElementById('DataConnectionRateStatistics'));
    const option = {
  xAxis: {
    type: 'category',
    data: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun']
  },
  yAxis: {
    type: 'value'
  },
  series: [
    {
      data: [120, 200, 150, 80, 70, 110, 130],
      type: 'bar'
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