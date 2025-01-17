<template>
    <div>
        <el-form :inline="true" :model="formInline" class="demo-form-inline">
            <el-form-item label="网络制式">
                <el-select
                    v-model="formData.nwType"
                    placeholder=""
                    clearable
                >
                    <el-option label="2G" value="2G" />
                    <el-option label="3G" value="3G" />
                    <el-option label="4G" value="4G" />
                </el-select>
            </el-form-item>




            <el-form-item label="运营商">
                <el-select
                    v-model="formData.nwOperator"
                    placeholder=""
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
                            start-placeholder="Start date"
                            end-placeholder="End date"
                            format="YYYY/MM/DD"
                            value-format="YYYYMMDD"
                            unlink-panels
                            >
                            <template #prev-month>
                                <el-icon><CaretLeft /></el-icon>
                            </template>
                            <template #next-month>
                                <el-icon><CaretRight /></el-icon>
                            </template>
                            <template #prev-year>
                                <el-icon>
                                <svg
                                    viewBox="0 0 20 20"
                                    version="1.1"
                                    xmlns="http://www.w3.org/2000/svg"
                                >
                                    <g stroke-width="1" fill-rule="evenodd">
                                    <g fill="currentColor">
                                        <path
                                        d="M8.73171,16.7949 C9.03264,17.0795 9.50733,17.0663 9.79196,16.7654 C10.0766,16.4644 10.0634,15.9897 9.76243,15.7051 L4.52339,10.75 L17.2471,10.75 C17.6613,10.75 17.9971,10.4142 17.9971,10 C17.9971,9.58579 17.6613,9.25 17.2471,9.25 L4.52112,9.25 L9.76243,4.29275 C10.0634,4.00812 10.0766,3.53343 9.79196,3.2325 C9.50733,2.93156 9.03264,2.91834 8.73171,3.20297 L2.31449,9.27241 C2.14819,9.4297 2.04819,9.62981 2.01448,9.8386 C2.00308,9.89058 1.99707,9.94459 1.99707,10 C1.99707,10.0576 2.00356,10.1137 2.01585,10.1675 C2.05084,10.3733 2.15039,10.5702 2.31449,10.7254 L8.73171,16.7949 Z"
                                        />
                                    </g>
                                    </g>
                                </svg>
                                </el-icon>
                            </template>
                            <template #next-year>
                                <el-icon>
                                <svg
                                    viewBox="0 0 20 20"
                                    version="1.1"
                                    xmlns="http://www.w3.org/2000/svg"
                                >
                                    <g stroke-width="1" fill-rule="evenodd">
                                    <g fill="currentColor">
                                        <path
                                        d="M11.2654,3.20511 C10.9644,2.92049 10.4897,2.93371 10.2051,3.23464 C9.92049,3.53558 9.93371,4.01027 10.2346,4.29489 L15.4737,9.25 L2.75,9.25 C2.33579,9.25 2,9.58579 2,10.0000012 C2,10.4142 2.33579,10.75 2.75,10.75 L15.476,10.75 L10.2346,15.7073 C9.93371,15.9919 9.92049,16.4666 10.2051,16.7675 C10.4897,17.0684 10.9644,17.0817 11.2654,16.797 L17.6826,10.7276 C17.8489,10.5703 17.9489,10.3702 17.9826,10.1614 C17.994,10.1094 18,10.0554 18,10.0000012 C18,9.94241 17.9935,9.88633 17.9812,9.83246 C17.9462,9.62667 17.8467,9.42976 17.6826,9.27455 L11.2654,3.20511 Z"
                                        />
                                    </g>
                                    </g>
                                </svg>
                                </el-icon>
                            </template>
                        </el-date-picker>
                    </div>
                </div>

            </el-form-item>

            <el-form-item>
                <el-button type="primary" @click="onSubmit">Query</el-button>
            </el-form-item>
        </el-form>



        <div id="main" style="height: 700px; width: 80%;"></div>
    </div>
</template>


<script setup>

    import * as echarts from 'echarts';
    import 'echarts/extension/bmap/bmap';
    import { onMounted , ref } from 'vue';


    const formData = ref({
        nwType:'',
        nwOperator:'',
        Date:[]//开始和结束日期
    })


    //TODO未编写真正的请求函数
    const onSubmit = () => {
        console.log("此时formdata表单信息为：")
        console.log(formData.value.Date[0]);
        console.log(formData.value.Date[1]);
        console.log(formData);
    }





    function showImg(){

        const chartDom = document.getElementById('main');
        const myChart = echarts.init(chartDom);

        const points = ref([
            [116.404, 39.915, 1],
            [116.404, 39.9151, 1],
            [116.404, 39.9152, 1],
            [116.404, 39.9153, 1],
            [116.404, 39.9154, 1],
            [116.404, 39.9155, 1],
            [116.404, 39.9156, 1],
            [116.404, 39.9157, 1],
            [116.404, 39.9158, 1],
            [116.404, 39.9159, 10]
        ]);

        const option = {
            animation: false,
            bmap: {
                center: [116.404, 39.915],
                zoom: 17,
                roam: true
            },
            visualMap: {
                show: false,
                top: 'top',
                min: 0,
                max: 5,
                seriesIndex: 0,
                calculable: true,
                inRange: {
                    color: ['blue', 'blue', 'green', 'yellow', 'red', 'purple', '']
                }
            },
            series: [
                {
                    type: 'heatmap',
                    coordinateSystem: 'bmap',
                    data: points.value,
                    pointSize: 10,
                    blurSize: 1
                }
            ]
        }

        myChart.setOption(option);

        // 添加百度地图插件
        var bmap = myChart.getModel().getComponent('bmap').getBMap();
        bmap.addControl(new BMap.MapTypeControl());


    }


    onMounted(()=>{
        showImg();
    })

</script>




<style>
    
#container {
    height: 700px;
    width: 100%;
}

.demo-form-inline .el-input {
--el-input-width: 150px;
}

.demo-form-inline .el-select {
--el-select-width: 150px;
}

</style>