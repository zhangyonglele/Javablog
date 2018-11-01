<template>
    <div class="login">
      <img src="../static/images/home.svg">
      <span>随时随地发现新事物</span>
      <div class="login-bar">
        <router-link :to="{name:'registerModule'}" class="login-res" tag="div">去注册</router-link>
        <router-link :to="{name:'loginModule'}" class="login-log" tag="div">去登陆</router-link>
      </div>
    </div>
</template>

<script>
    export default {
        name: "Login"
    }
</script>

<style scoped>
  .login{
    display: flex;
    flex-direction: column;
    justify-content: flex-start;
    align-items: center;
    padding-top: 200px;
    box-sizing: border-box;
  }
  .login img{
    filter: blur(1px);
  }
  .login span{
    color: white;
  }
  .login .login-bar{
    width: 60%;
    display: flex;
    flex-direction: row;
    justify-content: space-around;
  }
  .login-res,.login-log{
    width: 300px;
    height: 50px;
    margin-top: 100px;
    color: white;
    background-color: skyblue;
    border: none;
    border-radius: 50px;
    text-align: center;
    line-height: 50px;
    transition: all 0.5s;
    opacity: 0.8;
  }
  .login-res:hover{
    font-size: 17px;
    color: #000;
    opacity: 1;
  }
  .login-log:hover{
    font-size: 17px;
    color: #000;
    opacity: 1;
  }
</style>
