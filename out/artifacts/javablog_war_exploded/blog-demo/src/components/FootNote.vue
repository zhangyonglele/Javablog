<template>
    <div class="foot-note">
      <span>{{text}}</span>
    </div>
</template>

<script>
    export default {
        name: "FootNote",
      props:{
          text:{
            type:String,
            default:'...'
          }
      }
    }
</script>

<style scoped>
  .foot-note{
    width: 100%;
    margin-top: 20px;
    font-size: 14px;
    text-align: center;
    color: #CCCCCC;
    background-color: rgba(36,36,36,0.8);
    border-radius: 5px;
  }
  .foot-note span:hover{
    color: white;
  }
</style>
