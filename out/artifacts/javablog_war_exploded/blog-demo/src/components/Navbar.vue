<template>
    <div class="navbar-contain">
      <div class="contain-top">Welcome</div>
      <ul class="contain-wrap">
        <router-link class="wrap-items" v-for="(tag,index) in tags" :key="index" tag="li" :to="tag.url">
          <img :src="tag.icon">
          <span>{{tag.title}}</span>
          <img :src="dotUrl"class="icon-dot">
        </router-link>
      </ul>
    </div>
</template>

<script>
    export default {
        name: "Navbar",
      data(){
          return{
            tags:[
              {icon:'../static/images/homepage.svg',title:'首页',url:"/home/in"},
              {icon:'../static/images/mine.svg',title:'成长',url:"/home/grow"},
              {icon:'../static/images/tags.svg',title:'标签',url:"/home/tag"},
              {icon:'../static/images/askIcon.svg',title:'有料',url:"/home/something"},
              {icon:'../static/images/writedown.svg',title:'写博客',url:'/home/write'}
            ],
            dotUrl:'../static/images/dots.svg'
          }
      }
    }
</script>

<style scoped>
  .navbar-contain{
    width: 100%;
    display: flex;
    flex-direction: column;
    justify-content: flex-start;
    align-items: center;
  }
  .navbar-contain .contain-top{
    width: 100%;
    height: 86px;
    background-color: #222;
    color: white;
    line-height: 86px;
    text-align: center;
    font-size: 20px;
    font-weight: normal;
    transition: font-size 0.5s;
  }
  .navbar-contain .contain-top:hover{
    font-size: 22px;
  }
  .contain-wrap{
    width: 100%;
  }
  .contain-wrap .wrap-items{
    width: 100%;
    height: 36px;
    display: flex;
    position: relative;
    flex-direction: row;
    justify-content: flex-start;
    align-items: center;
    padding-left: 10px;
    box-sizing: border-box;
    font-size: 13px;
  }
  .contain-wrap .wrap-items:hover{
    background-color: rgba(249,249,249,1);
  }
  .contain-wrap .wrap-items span{
    margin-left: 10px;
    color: grey;
  }
  .contain-wrap .wrap-items img{
    width: 14px;
    height: 14px;
  }
  .contain-wrap .wrap-items .icon-dot{
    position: absolute;
    right: 10px;
    display: none;
  }
  li.router-link-active{
    background-color: rgba(249,249,249,1);
  }
  .wrap-items.icon-dot{
    display: none;
  }
  .wrap-items:hover .icon-dot{
    display: block;
  }
</style>
