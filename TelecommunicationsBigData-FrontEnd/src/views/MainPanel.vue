<template>

    <div id="echarts1" style="background-color: #374C6B; height: 80%; width:80%;        margin:.1rem;"></div>
    
    </template>
    
    <script setup>
    import * as echarts from "echarts";
    // import Grid from "echarts/types/src/coord/cartesian/Grid.js";
    // import Background from "three/src/renderers/common/Background.js";
    // import { each } from "echarts/types/src/export/api/util.js";
    // import { ItemStyleMixin } from "echarts/types/src/model/mixin/itemStyle.js";
    import { onMounted } from "vue";
    
    function showImg(){
    const myChart = echarts.init(document.getElementById("echarts1"));
    const option = {
        title:{
            text: '港口吞吐量总量 Top 5（万吨）',
            
            textStyle: {
                fontSize:"20px",
                //标题颜色
                color: 'white'
            },
        },
        textStyle:{
            color:'white'
        },
    
        legend: {
            right: '10%',
    
            textStyle:{
                color:"white",
            },
        },
        grid:{
            show: false,
            containerLable:true,
            top: '19%',
            bottom: '15%',
    
        },
        tooltip: {},
        dataset: {
        dimensions: ['product', '2015', '2016'],
        source: [
            { product: '111', 2015: 43.3, 2016: 85.8 },
            { product: '222', 2015: 83.1, 2016: 73.4 },
            { product: '333', 2015: 86.4, 2016: 100.2 },
            { product: '444', 2015: 92.4, 2016: 83.9 },
            { product: 'aaa', 2015: 43.1, 2016: 73.4 },
            { product: 'bbb', 2015: 26.4, 2016: 65.2 },
        ]
        },
    
        // color: [
        // '#20ffcb',
        // '#d7d7d7',
        // '#313695',
        // '#4575b4',
        // '#74add1',
        // '#abd9e9',
        // '#e0f3f8',
        // '#ffffbf',
        // '#fee090',
        // '#fdae61',
        // '#f46d43',
        // '#d73027',
        // '#a50026'
        // ],
    
        xAxis: {
            type: 'category' ,
            axisLabel: {
                show: true, //是否显示底下的名称
                rotate: 30
            }
        },
        yAxis: {
                splitLine: {
                lineStyle: {
                type: 'dashed', // 虚线样式
                color: 'rgba(255, 255, 255, 0.15)' // 虚线颜色
                }
        
            },
        },
        // Declare several bar series, each will be mapped
        // to a column of dataset.source by default.
    
        series: [{
            type: 'bar' ,
            
            itemStyle:{
                normal:{
                    color: new echarts.graphic.LinearGradient(
                        0,0,0,1,
                        [
                            { offset: 0, color: '#5ED2D2' },
                            { offset: 1, color: '#324D69' }
                        ]
                    )
                }
            }
        },
        {
    
            type: 'bar' ,
            itemStyle:{
                normal:{
                    color:{
                        type: 'linear', // 渐变类型
                        x: 0, y: 0, // 渐变起始点
                        x2: 0, y2: 1, // 渐变结束点
                        colorStops:[
                            { offset: 0, color: '#CCDAEA' },
                            { offset: 1, color: '#415573' }
                        ],
                        global: false // 默认为false，是否应用为全局渐变色，true表示应用到所有柱子上
                    },
                }
            }
        }]
    };
    
    myChart.setOption(option);
    }
    
    onMounted(()=>{
    showImg();
    })
    
    
    
    </script>
    
    <style>
    
    </style>