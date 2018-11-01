<template>
    <input type="submit" :value="text" class="btn" :class="[color]"/>
</template>

<script>
    export default {
        name: "ButtonSub",
      props:{
          text:{
            type:String,
            default:'提交'
          },
          color:{
              type: String,
              default:'white'
          }
      }
    }
</script>

<style scoped>
  .btn{
    width: 300px;
    height: 50px;
    color: white;
    border: none;
    border-radius: 50px;
    text-align: center;
    line-height: 50px;
    font-size: 16px;
    transition: font-size 0.5s;
    margin-top: 30px;
    margin-bottom: 10px;
  }
  .blue{
    background-color: skyblue;
    opacity: 0.8;
  }
  .white{
    background-color: white;
    opacity: 0.8;
  }
  .btn:hover{
     font-size: 17px;
     color: black;
    opacity: 1;
   }
  .btn:active{
    background-color: #CCC;
  }
</style>
