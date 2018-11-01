<template>
    <form action="" method="get" class="write">
      <Label thread="title" title="标题" type="text" text="请输入标题"/>
      <text-area title="内容" text="输入博客内容..."/>
      <check-box/>
      <div class="write-but"><button-sub text="发布" color="blue"/></div>
    </form>
</template>

<script>
  import Label from './Label'
  import TextArea from './TextArea'
  import ButtonSub from './ButtonSub'
  import CheckBox from './CheckBox'
    export default {
        name: "Write",
      components:{
          Label,TextArea,ButtonSub,CheckBox
      }
    }
</script>

<style scoped>
  .write{
    width: 90%;
    display: flex;
    flex-direction: column;
    justify-content: flex-start;
    align-items: stretch;
  }
  .write .write-but{
    width: 100%;
    text-align: center;
  }
</style>
