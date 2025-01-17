
<template>

<div id="app">
    
    <el-container>
        <el-header style="background-color: #333333;">
            <img src="../assets/data.svg" alt="图标" style="position: relative;top: 10px; ">
            <span style="font-size: 20px;margin-left: 15px;color: white;">BIGDATA
            </span>
        </el-header>

    </el-container>
    

    <el-container>
        <el-aside style="overflow: hidden;min-height: 100vh;background-color: #555555;  width: 250px;">
            <el-menu
        router
        active-text-color="#ffd04b"
        background-color="#555555"
        class="el-menu-vertical-demo"
        :default-active="$router.path"
        text-color="#fff"
        @open="handleOpen"
        @close="handleClose"
        >

        <el-menu-item index="/">
            <el-icon><HomeFilled  /></el-icon>
            <span>仪表盘</span>
        </el-menu-item>

        <el-sub-menu index="1">
            <template #title>
            <el-icon><Menu /></el-icon>
            <span>信号覆盖</span>
            </template>
            <el-menu-item-group title="信息表 ">
                <!-- TODO改映射 -->
            <el-menu-item index="/SignalStrengthDistribution">信号强度分布图</el-menu-item>
            <el-menu-item index="/TypicalLandmarkSignalStrengthTracking">典型地标信号强度跟踪图</el-menu-item>
            <el-menu-item index="/TypicalLandmarkSignalStrengthStatistics">典型地标信号强度统计图</el-menu-item>
            </el-menu-item-group>

        </el-sub-menu>

        <el-sub-menu index="2">
            <template #title>
            <el-icon><Menu /></el-icon>
            <span>网络质量</span>
            </template>
            <el-menu-item-group title="信息表">
                <!-- TODO改映射 -->
            <el-menu-item index="/NetworkQualityDistribution">网络质量分布图</el-menu-item>
            <el-menu-item index="/NetworkQualityStatistics">网络质量统计图</el-menu-item>
            <el-menu-item index="/NetworkSpeedRank">网络速率排名</el-menu-item>
            <el-menu-item index="/TypicalLandmarkNetworkQualityTracking">典型地标网络质量跟踪图</el-menu-item>
            <el-menu-item index="/TypicalLandmarkNetworkQualityStatistics">典型地标网路质量统计图</el-menu-item>
            </el-menu-item-group>

        </el-sub-menu>

        <el-sub-menu index="3">
            <template #title>
            <el-icon><Menu /></el-icon>
            <span>数据连接</span>
            </template>
            <el-menu-item-group title="信息表 ">
                <!-- TODO改映射 -->
            <el-menu-item index="/DataConnectionRateDistribution">数据连接率分布图</el-menu-item>
            <el-menu-item index="/DataConnectionRateStatistics">数据连接率统计图</el-menu-item>
            </el-menu-item-group>

        </el-sub-menu>
        
        <el-sub-menu index="4">
            <template #title>
            <el-icon><Menu /></el-icon>
            <span>热门APP</span>
            </template>
            <el-menu-item-group title="信息表 ">
                <!-- TODO改映射 -->
            <el-menu-item index="/PopularAppTrafficDistribution">热门APP流量分布图</el-menu-item>
            <el-menu-item index="/PopularAppMap">热门APP地图</el-menu-item>
            <el-menu-item index="/PopularAppTrafficRank">热门APP流量排名</el-menu-item>
            <el-menu-item index="/PopularAppTrafficTracking">热门APP流量跟踪图</el-menu-item>
            <el-menu-item index="/TypicalLandmarkPopularAppTrafficRank">典型地标热门APP流量排名</el-menu-item>
            </el-menu-item-group>

        </el-sub-menu>

        <el-sub-menu index="5">
            <template #title>
            <el-icon><Menu /></el-icon>
            <span>热门手机</span>
            </template>
            <el-menu-item-group title="信息表 ">
                <!-- TODO改映射 -->
            <el-menu-item index="/PopularMobilePhoneTrafficDistribution">热门手机流量分布图</el-menu-item>
            <el-menu-item index="/PopularMobileNetworkQualityRank">热门手机网络质量排名</el-menu-item>
            <el-menu-item index="/PopularMobileTrafficRank">热门手机流量排名</el-menu-item>
            <el-menu-item index="/MobileOSTrafficRank">手机OS流量排名</el-menu-item>
            <el-menu-item index="/PopularMobilePhonesDistribution">热门手机分布图</el-menu-item>
            <el-menu-item index="/MobileOSDistribution">手机OS分布图</el-menu-item>
            </el-menu-item-group>

        </el-sub-menu>

        <el-sub-menu index="6">
            <template #title>
            <el-icon><Menu /></el-icon>
            <span>连接点</span>
            </template>
            <el-menu-item-group title="信息表 ">
                <!-- TODO改映射 -->
            <el-menu-item index="/ConnectionPointsRank">连接点数排名</el-menu-item>
            <el-menu-item index="/ConnectionPointsGeographicalDistribution">连接点地理分布</el-menu-item>
            </el-menu-item-group>

        </el-sub-menu>

        <el-sub-menu index="7">
            <template #title>
            <el-icon><Menu /></el-icon>
            <span>个人用户</span>
            </template>
            <el-menu-item-group title="信息表 ">
                <!-- TODO改映射 -->
            <el-menu-item index="/NetworkQuality">网络质量</el-menu-item>
            <el-menu-item index="/AppStreetView">APP街景图</el-menu-item>
            <el-menu-item index="/OSStreetView">OS街景图</el-menu-item>
            <el-menu-item index="/SignalCoverage">信号覆盖</el-menu-item>
            </el-menu-item-group>

        </el-sub-menu>


        <el-menu-item index="/temp1">
            <el-icon><Menu /></el-icon>
            <span>用户管理</span>
        </el-menu-item>






<!-- 
        <el-menu-item index="3" disabled>
            <el-icon><document /></el-icon>
            <span>Navigator Three</span>
        </el-menu-item>
        <el-menu-item index="4">
            <el-icon><setting /></el-icon>
            <span>Navigator Four</span>
        </el-menu-item>
    -->

        </el-menu>
        </el-aside>




        <!-- TODO 主页面设计 -->
        <el-main>
            <router-view/>
        </el-main>
    </el-container>



</div>

</template>
    
<script>
    export default {
    
    }
</script>
    
<style scoped>
.el-menu{
    border-right: none !important;
}
#app{
    height: 100%;
    width: 100%;
}
</style>