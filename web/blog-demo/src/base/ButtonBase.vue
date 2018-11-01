<template>
    <div class="btn" :class="[color]">{{text}}</div>
</template>

<script>
    export default {
        name: "ButtonBase",
      props:{
        text:{
          type:String,
          default:'提交'
        },
        color:{
          type: String,
          default:'white'
        }
      },
      data(){
        return{
          color:color
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
  }
  .blue{
    background-color: skyblue;
  }
  .white{
    background-color: white;
  }
  .btn:hover{
    font-size: 17px;
    color: black;
  }
  .btn:active{
    background-color: #CCC;
  }
</style>
