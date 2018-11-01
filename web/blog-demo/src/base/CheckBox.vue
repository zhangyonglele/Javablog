<template>
    <div class="checkbox">
      <span>标签:</span>
      <input type="checkbox" value="" name="tags" id="javascript">
      <label for="javascript">javascript</label>
      <input type="checkbox" value="" name="tags" id="css">
      <label for="css">css</label>
      <input type="checkbox" value="" name="tags" id="node">
      <label for="node">node</label>
      <input type="checkbox" value="" name="tags" id="vue">
      <label for="vue">vue</label>
    </div>
</template>

<script>
    export default {
        name: "CheckBox"
    }
</script>

<style scoped>
  .checkbox{
    width: 100%;
    height: 40px;
  }
  .checkbox span{
    display: inline-block;
    width: 100px;
    line-height: 40px;
    font-size: 16px;

  }
</style>
