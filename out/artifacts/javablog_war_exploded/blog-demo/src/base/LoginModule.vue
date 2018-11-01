<template>
    <div class="login">
      <form method="post" action="/ajaxurl/LoginServlet">
        <Label thread="name" title="登录名" type="text" text="请输入账号"/>
        <Label thread="password" title="密码" type="text" text="请输入密码"/>
        <ButtonSub text="点击登陆" color="blue"/>
      </form>
      <span>还没有账号，点击<router-link :to="{name:'registerModule'}" tag="a">去注册</router-link></span>
    </div>
</template>

<script>
  import ButtonSub from './ButtonSub'
  import Label from './Label'
    export default {
        name: "LoginModule",
      components:{
        ButtonSub,Label
      }
    }
</script>

<style scoped>
  form{
    width: 60%;
    margin: 200px auto;
    margin-bottom: 0;
    display: flex;
    flex-direction: column;
    justify-content: flex-start;
    align-items: center;
    background-color: rgba(255,255,255,0.7);
  }
  .login span{
    display: block;
    margin-top: 50px;
    color: white;
  }
  .login a{
    color: red;
  }
</style>
