<template>
    <div>
      <div v-for="(logo, index) in logos" :key="index">
        <img :src="logo.src" :alt="logo.alt" class="logo-img">
      </div>
    </div>
  </template>
  
  <script setup>

  import { ref } from "vue";
  
  // 更新图片路径
  const logos = ref([
    { src: '/logo1.png', alt: 'Logo 1' },
    { src: '/logo2.png', alt: 'Logo 2' }
  ]);
  
  </script>
  
  <style>
  .logo-img {
    width: 1500px;   /* 设置宽度为200px */
    height: auto;   /* 高度自动，保持比例 */
    margin: 10px;
    object-fit: contain;  /* 保持原始比例 */
  }
  </style>
  