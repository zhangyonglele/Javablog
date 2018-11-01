<template>
  <div id="app">
    <router-view/>
  </div>
</template>

<script>
  import Navbar from './components/Navbar'
export default {
  name: 'App'
}
</script>

<style>
  @import "./style/common.css";
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}
</style>
