<template lang="html">
    <el-form :inline="true" :model="formInline" class="demo-form-inline">
        <el-form-item label="地标">
      <el-select
        v-model="formData.landmark"
        placeholder=" "
        clearable
      >
        <el-option label="大学" value="大学" />
        <el-option label="居民区" value="居民区" />
        <el-option label="商业区" value="商业区" />
      </el-select>
    </el-form-item>
    <el-form-item label="网络制式">
      <el-select
        v-model="formData.nwType"
        placeholder=" "
        clearable
      >
        <el-option label="2G" value="2G" />
        <el-option label="3G" value="3G" />
        <el-option label="4G" value="4G" />
      </el-select>
    </el-form-item>
    <el-form-item label="时间粒度">
      <el-select
        v-model="formData.timeGranularity"
        placeholder=" "
        clearable
      >
        <el-option label="月" value="月" />
        <el-option label="天" value="天" />
        <el-option label="时" value="时" />
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
                :default-value="[new Date(2010, 9, 1), new Date(2010, 10, 1)]"
            />
            </div>
        </div>

    </el-form-item>

    <el-form-item>
      <el-button type="primary" @click="handleSearch">Query</el-button>
    </el-form-item>
  </el-form>
    <div id="typicalLandmarkSignalStrengthTracking" style="background-color: #FFFFFF; height: 95%; width:95%; margin:.1rem; position: relative;"></div>
    


</template>

<script setup>
import { ref } from 'vue';


import * as echarts from 'echarts';
import { onMounted } from "vue";

import { getTypicalSignalStrengthTracking } from '../../api/signal_strength';


const cmcc_data = ref([-30, -60, -90, -120, -90, -60, -30, 0, -30, -60, -90, -120, -90, -60, -30, 0, -30, -60, -90, -120, -90, -60, -30, 0, -30, -60, -90, -120, -90, -60
                ])
const cucc_data = ref( [
                    -20, -50, -80, -110, -80, -50, -20, 0, -20, -50, -80, -110, -80, -50, -20, 0, -20, -50, -80, -110, -80, -50, -20, 0, -20, -50, -80, -110, -80, -50
                ])

const ctcc_data = ref([
                    -40, -70, -100, -110, -70, -40, -10, 0, -40, -70, -100, -110, -70, -40, -10, 0, -40, -70, -100, -110, -70, -40, -10, 0, -40, -70, -100, -110, -70, -40
                ])

const formData = ref({
    landmark:'',
    nwType:'',
    timeGranularity:'',
    Date:[],

})

const points = ref([]); // 新增响应式变量用于存储筛选后的数据

function showImg() {
    const myChart = echarts.init(document.getElementById('typicalLandmarkSignalStrengthTracking'));
    const colors = ['#5470C6', '#EE6666', '#90EE90', '#FFA500', '#87CEFA']; // 曲线颜色保持不变
    const option = {
        color: colors,
        tooltip: {
            trigger: 'none',
            axisPointer: {
                type: 'cross'
            }
        },
        legend: {
            data: ['CMCC', 'CUCC', 'CTCC']
        },
        grid: {
            top: 50,
            bottom: 80,
            left: 80,   // 扩大图表的显示区域
            right: 80,  // 扩大图表的显示区域
        },
        xAxis: [
            {
                type: 'category',
                axisTick: {
                    alignWithLabel: true
                },
                axisLine: {
                    onZero: false,
                    lineStyle: {
                        color: 'red' // 横坐标轴线颜色改为红色
                    }
                },
                axisPointer: {
                    label: {
                        formatter: function (params) {
                            return (
                                'Precipitation  ' +
                                params.value +
                                (params.seriesData.length? '：' + params.seriesData[0].data : '')
                            );
                        }
                    }
                },
                data: Array.from({length: 30}, (_, i) => (i + 1).toString().padStart(2, '0')),
                position: 'top',
                axisLabel: {
                    interval: 0,
                    formatter: function (value) {
                        return `${value}`;
                    },
                    textStyle: {
                        color: 'red' // 横坐标标签颜色改为红色
                    }
                }
            }
        ],
        yAxis: [
            {
                type: 'value',
                min: -120,
                max: 0,
        interval: 30,
                axisLabel: {
                    formatter: '{value}',
                    textStyle: {
                        color: 'red' // 纵坐标标签颜色改为红色
                    }
                },
                splitLine: {  // 调整竖线的颜色
                    lineStyle: {
                        color: '#B0B0B0', // 竖线颜色淡一点
                    }
                },
                axisLine: {
                    lineStyle: {
                        color: 'red' // 纵坐标轴线颜色改为红色
                    }
                }
            }
        ],
        series: [
            {
                name: 'CMCC',
                type: 'line',
                xAxisIndex: 0,
                smooth: true,
                emphasis: {
                    focus: 'series'
                },
                symbol: 'circle', // 使用圆形表示 CMCC
                symbolSize: 8, // 增大标记大小
                clipPath: {
                    type: 'rect',
                    x: '5%',
                    y: '15%',
                    width: '90%',
                    height: '80%'
                },
                data:cmcc_data.value,
                markLine: {
                    symbol: 'none', // 去掉箭头
                    symbolSize: [0, 0], // 去掉箭头尺寸
                    data: Array.from({length: 30}, (_, i) => ({
                        xAxis: (i + 1).toString().padStart(2, '0'),
                        lineStyle: {
                            color: '#ccc',
                            type: 'solid',
                            width: 1
                        },
                        label: { show: false }
                    }))
                }
            },
            {
                name: 'CUCC',
                type: 'line',
                xAxisIndex: 0,
                smooth: true,
                emphasis: {
                    focus: 'series'
                },
                symbol: 'rect', // 使用正方形表示 CUCC
                symbolSize: 8, // 增大标记大小
                clipPath: {
                    type: 'rect',
                    x: '5%',
                    y: '15%',
                    width: '90%',
                    height: '80%'
                },
                data:cucc_data.value,
                markLine: {
                    symbol: 'none', // 去掉箭头
                    symbolSize: [0, 0], // 去掉箭头尺寸
                    data: Array.from({length: 30}, (_, i) => ({
                        xAxis: (i + 1).toString().padStart(2, '0'),
                        lineStyle: {
                            color: '#ccc',
                            type: 'solid',
                            width: 1
                        },
                        label: { show: false }
                    }))
                }
            },
            {
                name: 'CTCC',
                type: 'line',
                xAxisIndex: 0,
                smooth: true,
                emphasis: {
                    focus: 'series'
                },
                symbol: 'triangle', // 使用三角形表示 CTCC
                symbolSize: 8, // 增大标记大小
                clipPath: {
                    type: 'rect',
                    x: '5%',
                    y: '15%',
                    width: '90%',
                    height: '80%'
                },
                data: ctcc_data.value,
                markLine: {
                    symbol: 'none', // 去掉箭头
                    symbolSize: [0, 0], // 去掉箭头尺寸
                    data: Array.from({length: 30}, (_, i) => ({
                        xAxis: (i + 1).toString().padStart(2, '0'),
                        lineStyle: {
                            color: '#ccc',
                            type: 'solid',
                            width: 1
                        },
                        label: { show: false }
                    }))
                }
            }
        ],
        graphic: [
            {
                type: 'text',
                left: '5%',
                top: '1%',
                style: {
                    text: '典型地表信号强度跟踪图   单位(dBm)',
                    fontSize: 18,
                    fontWeight: 'bold'
                }
            }
        ]
    };

    // // 调整图的比例
    // option.grid.containLabel = true;

    myChart.setOption(option);
}

onMounted(() => {
    showImg();
})


const handleSearch = async () => {
    // const params = {
    //     landmark: formData.value.landmark,
    //     timeGranularity: formData.value.timeGranularity,
    //     nwType: formData.value.nwType,
    //     startDate: formData.value.Date[0],
    //     endDate: formData.value.Date[1]
    // };

    const params = {};

    console.log("发送前", params);
    const res = await getTypicalSignalStrengthTracking(params);
    console.log("接受", res);

    if (res.data.code == '200') {
        // 筛选出 networkName 为 'CMCC', 'CUCC', 'CTCC' 的数据
        const filteredData = res.data.data.filter(item => 
            ['CMCC', 'CUCC', 'CTCC'].includes(item.networkName)
        ).slice(0, 30); // 取前30个数据

        // 更新 points 变量
        points.value = filteredData.map(item => ({
            rssi: item.rssi,
            networkName: item.networkName,
            xrate: item.xrate
        }));

        // 更新 ECharts 数据
        const seriesData = {
            CMCC: filteredData.filter(item => item.networkName === 'CMCC').map(item => item.rssi),
            CUCC: filteredData.filter(item => item.networkName === 'CUCC').map(item => item.rssi),
            CTCC: filteredData.filter(item => item.networkName === 'CTCC').map(item => item.rssi),
        };

        //TODO并未完成对横坐标的统一！！！
        cmcc_data.value = seriesData.CMCC
        cucc_data.value = seriesData.CUCC
        ctcc_data.value = seriesData.CTCC

        console.log(cmcc_data.value);

        console.log(cucc_data.value);
        
        console.log(ctcc_data.value);

        // 更新 ECharts 图表数据
        // myChart.setOption({
        //     series: [
        //         { data: seriesData.CMCC },
        //         { data: seriesData.CUCC },
        //         { data: seriesData.CTCC }
        //     ]
        // });

        showImg();
    } else {
        console.error("获取出错记录失败", res.message);
    }
};

</script>

<style lang="css">
.demo-form-inline .el-input {
  --el-input-width: 150px;
}

.demo-form-inline .el-select {
  --el-select-width: 150px;
}
.demo-date-picker.block {
  border-right: solid 1px var(--el-border-color);
  flex: 1;
}
.demo-date-picker.demonstration {
  color: var(--el-text-color-secondary);
  font-size: 14px;
}
</style>