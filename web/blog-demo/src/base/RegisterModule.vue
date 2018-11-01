<template>
    <div class="login">
      <form method="post" action="/ajaxurl/RegisterServlet">
        <Label thread="name" title="登录名" type="text" text="请选择登录名"/>
        <Label thread="pass" title="密码" type="text" text="请设置密码"/>
        <Label thread="sex" title="性别" type="text" text="请告诉我你的性别"/>
        <Label thread="age" title="年龄" type="text" text="请告诉我你的年龄"/>
        <ButtonSub text="点击注册" color="blue"/>
      </form>
      <span>已有账号，点击<router-link :to="{name:'loginModule'}" tag="a">去登陆</router-link></span>
    </div>
</template>

<script>
  import ButtonSub from './ButtonSub'
  import Label from './Label'
    export default {
        name: "RegisterModule",
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
    color: white;
    margin-top: 50px;
    display: block;
  }
  .login a{
    color: red;
  }
</style>
