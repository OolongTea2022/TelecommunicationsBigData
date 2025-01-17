<template>
    <div>
        <div id="container" ref="dom"></div>
        <div id="main" style="height: 700px; width: 100%;"></div>
    </div>
</template>


<script setup>

    import * as echarts from 'echarts';
import 'echarts/extension/bmap/bmap';
import { onMounted, ref } from 'vue';

    const dom = ref();
    let map;
    let myChart;

    onMounted(() => {
        map = new window.BMapGL.Map(dom.value);
        var point = new window.BMapGL.Point(116.404, 39.915);
        map.centerAndZoom(point, 15);
        map.enableScrollWheelZoom(true);
        
        var chartDom = document.getElementById('main');
        myChart = echarts.init(chartDom);
        
        var option;
        fetch('https://echarts.apache.org/examples/data/asset/data/hangzhou-tracks.json')
            .then(response => response.json())
            .then(data => {
                var points = [].concat.apply(
                    [],
                    data.map(function (track) {
                        return track.map(function (seg) {
                            return seg.coord.concat([1]);
                        });
                    })
                );
                myChart.setOption(
                    (option = {
                        animation: false,
                        bmap: {
                            center: [116.404, 39.915],
                            zoom: 15,
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
                                color: ['blue', 'blue', 'green', 'yellow', 'red']
                            }
                        },
                        series: [
                            {
                                type: 'heatmap',
                                coordinateSystem: 'bmap',
                                data: points,
                                pointSize: 5,
                                blurSize: 6
                            }
                        ]
                    })
                );
                var bmap = myChart.getModel().getComponent('bmap').getBMap();
                bmap.addControl(new BMap.MapTypeControl());
            })
            .catch(error => console.error('Error fetching data:', error));

        option && myChart.setOption(option);
    })

</script>




<style>
    
#container {
    height: 700px;
    width: 100%;
}
</style>