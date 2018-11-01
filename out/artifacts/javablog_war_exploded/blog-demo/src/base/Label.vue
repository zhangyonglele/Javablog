<template>
    <div class="input">
      <label :for="thread" class="input-title">{{title}}:</label>
      <input :id="thread" :type="type" :placeholder="text" class="input-text" :name="thread"/>
    </div>
</template>

<script>
    export default {
        name: "Label",
      props:{
        thread:{
          type:String
        },
        title:{
          type: String,
          default:'姓名'
        },
        type:{
          type:String,
          default: 'text'
        },
        text:{
          type:String,
          default:'请输入'
        }
      }
    }
</script>

<style scoped>
  .input{
    width: 60%;
    height: 40px;
    display: flex;
    flex-direction: row;
    justify-content: space-around;
    margin-top: 15px;
  }
  .input .input-title{
    width: 20%;
    text-align: center;
    line-height: 40px;
  }
  .input .input-text{
    width: 45%;
    height: 40px;
    border: none;
    border-bottom: 1px solid #000;
    background-color: transparent;
  }
</style>
