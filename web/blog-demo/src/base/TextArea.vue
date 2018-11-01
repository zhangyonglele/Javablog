<template>
  <div class="area">
    <div class="area-title">{{title}}:</div>
    <textarea :placeholder="text" class="area-text" name="introduction"></textarea>
  </div>
</template>

<script>
  export default {
    name: "TextArea",
    props:{
      title:{
        type: String,
        default:'姓名'
      },
      text:{
        type:String,
        default:'请输入'
      }
    }
  }
</script>

<style scoped>
  .area{
    width: 100%;
    display: flex;
    flex-direction: row;
    justify-content: flex-start;
    margin-top: 25px;
    margin-left: 10px;
    margin-bottom: 20px;
  }
  .area .area-title{
    width: 20%;
    text-align: center;
    line-height: 40px;
  }
  .area .area-text{
    width: 80%;
    height: 400px;
    border: 1px solid #BBBBBB;
    background-color: transparent;
    resize: none;
  }
</style>
