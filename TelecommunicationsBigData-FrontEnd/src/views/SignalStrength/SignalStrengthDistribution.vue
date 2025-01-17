<template>
    <div>
        <div id="main" style="height: 700px; width: 80%;"></div>
    </div>
</template>


<script setup>

    import * as echarts from 'echarts';
    import 'echarts/extension/bmap/bmap';
    import { onMounted , ref} from 'vue';


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