<template>
  <div>
    <div class="contain">
      <div class="pull-left"></div>
      <div class="pull-mid">
        <div class="router-text">
          <div><router-view/></div>
        </div>
        <div class="foot-note">
          <foot-note text="青志网络技术工作室提供技术支持|@sugarhaining.github.io"/>
        </div>
      </div>
      <div class="pull-right">
        <div class="nav-bar"><Navbar/></div>
        <div class="msg-show"><Person/></div>
      </div>
    </div>
  </div>
</template>

<script>
  import Navbar from './components/Navbar'
  import Person from './components/Person'
  import FootNote from './components/FootNote'
    export default {
        name: "Home",
      components:{
        Navbar,Person,FootNote
      }
    }
</script>

<style scoped>
  .contain{
    margin-left: 100px;
    display: flex;
    flex-direction: row;
    justify-content: flex-start;
  }
  .pull-left {
    width: 240px;
  }
  .pull-mid{
    display: flex;
    flex-direction: column;
  }
  .router-text{
    width: 700px;
    height: 680px;
    background-color: rgba(212,212,212,0.3);
    padding: 10px 5px;
    padding-bottom: 5px;
    box-sizing: border-box;
    overflow-x: hidden;
    overflow-y: scroll;
  }
  .router-text::-webkit-scrollbar {
    width: 0 !important
  }
  .router-text div{
    background-color: white;
    border-radius: 10px;
  }
  .pull-right{
    width: 240px;
    display: flex;
    flex-direction: column;
    justify-content: flex-start;
  }
</style>
