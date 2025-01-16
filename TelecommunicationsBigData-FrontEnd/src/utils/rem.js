// 基本大小
const baseSize = 100;
// 设置 rem 函数
function setRem() {
  // 当前页面宽度相对于 1920 宽的缩放比例，可根据自己设计图的宽度修改。
  const scalex = document.documentElement.clientWidth / 1920;
  const scaley = document.documentElement.clientHeight / 1080;

  const scale = Math.min(scalex, scaley);
  document.documentElement.style.fontSize = `${baseSize * Math.min(scale, 2)}px`;

}
// 初始化
setRem();
// 改变窗口大小时重新设置 rem
window.onresize = function () {
  setRem();
};
