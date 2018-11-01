<template>
    <div class="person">
      <img src="../../static/images/google.png">
      <span class="person-name">{{name}}</span>
      <span class="person-text">{{text}}</span>
      <div class="person-nav">
        <div class="nav-log">日志：{{length}}</div>
        <div class="nav-line"></div>
        <div class="nav-tags">标签：{{length}}</div>
      </div>
      <iframe frameborder="no" border="0" marginwidth="0" marginheight="0" height=86 src="//music.163.com/outchain/player?type=2&id=442869498&auto=1&height=66"></iframe>
    </div>
</template>

<script>
    export default {
        name: "Person",
      data(){
        return{
          name:'HaiNing',
          text:'谁不曾孤单行走',
          length:5
        }
      }
    }
</script>

<style scoped>
  *{
    margin: 10px;
  }
  .person{
    width: 100%;
    display: flex;
    flex-direction: column;
    justify-content: flex-start;
    align-items: center;
    border-top: 0.5px solid #CCC;
    box-sizing: border-box;
    padding-top: 20px;
    margin: 0;
  }
  .person img{
    width: 126px;
    height: 74px;
    border-radius: 50px;
    box-shadow: 0 0 1px 1.5px #CCCCCC;
    transition: transform 1s;
  }
  .person img:hover{
    transform: rotate(360deg);
  }
  .person .person-name{
    font-size: 16px;
    font-weight: 600;
  }
  .person .person-text{
    font-size: 12px;
    color: grey;
  }
  .person .person-nav{
    display: flex;
    flex-direction: row;
    justify-content: center;
    font-size: 14px;
  }
  .person iframe{
    width: 250px;
  }
  .person-nav .nav-line{
    width: 0;
    height: 20px;
    border: 0.5px solid #BBBBBB;
  }
</style>
