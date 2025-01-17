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



        <div id="main" style="height: 700px; width: 80%;"></div>
    </div>
</template>


<script setup>

    import * as echarts from 'echarts';
    import 'echarts/extension/bmap/bmap';
    import { onMounted , ref , reactive} from 'vue';

    // do not use same name with ref
    const formData = reactive({
        nwType:'',
        nwOperator:'',
        startDate:Date(2010, 9, 1),
        endDate:Date(2010, 10, 1),

        // name: '',
        // region: '',
        // date1: '',
        // date2: '',
        // delivery: false,
        // type: [],
        // resource: '',
        // desc: '',
    })


    const onSubmit = () => {
        console.log('submit!')
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



</style>