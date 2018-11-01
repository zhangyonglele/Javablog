<template>
    <ul class="write-contain">
      <li v-for="(article,index) in articles" :key="index">
        <div class="write-title">
          {{article.title}}
        </div>
        <div class="write-slider"></div>
        <div class="write-data">
          <img src="../../static/images/data-icon.svg"/>
          <span>文章发表于{{article.data}}</span></div>
        <div class="write-text"><span>{{article.text}}</span></div>
      </li>
    </ul>
</template>

<script>
    export default {
        name: "Message",
      data(){
        return{
          articles:[
            {title: 'vue-cli填坑第一天',data:'2018.02.15',text:'今天第一次见面，你就让我深踩一坑马车内乘客的基础上才能从基础开始v打开v宁静的时刻v是v房价肯定是v开始的vv打开少女可能日俄v额v健康v那肯定是v你是VS看v那是肯定军v打开v你上课v'},
            {title: 'vue-cli填坑第一天',data:'2018.02.15',text:'今天第一次见面，你就让我深踩一坑'},
            {title: 'vue-cli填坑第一天',data:'2018.02.15',text:'今天第一次见面，你就让我深踩一坑'},
            {title: 'vue-cli填坑第一天',data:'2018.02.15',text:'今天第一次见面，你就让我深踩一坑'},
            {title: 'vue-cli填坑第一天',data:'2018.02.15',text:'今天第一次见面，你就让我深踩一坑'},
            {title: 'vue-cli填坑第一天',data:'2018.02.15',text:'今天第一次见面，你就让我深踩一坑'},
            {title: 'vue-cli填坑第一天',data:'2018.02.15',text:'今天第一次见面，你就让我深踩一坑'},
            {title: 'vue-cli填坑第一天',data:'2018.02.15',text:'今天第一次见面，你就让我深踩一坑'},
            {title: 'vue-cli填坑第一天',data:'2018.02.15',text:'今天第一次见面，你就让我深踩一坑'},
            {title: 'vue-cli填坑第一天',data:'2018.02.15',text:'今天第一次见面，你就让我深踩一坑'}
          ]
        }
      },
      created(){
          this.$http.get("./aaa.json").then(res=>{
            this.articles=res.data;
          },err=>{
            console.log(err)
          })
      }
    }
</script>

<style scoped>
  .write-contain{
    padding-top: 5px;
    box-sizing: border-box;
  }
  .write-contain li{
    width: 100%;
    display: flex;
    flex-direction: column;
    align-items: center;
    margin-top: 50px;
  }
  .write-contain .write-title{
    text-align: center;
    font-size: 20px;
    font-weight: 500;
  }
  .write-title:hover +.write-slider{
    width: 150px;
  }
  .write-contain .write-slider{
    width: 0;
    height: 2px;
    background-color: #000;
    transition: width 0.5s;
  }
  .write-contain .write-data{
    display: flex;
    justify-content: flex-start;
    align-items: center;
    margin-top: 5px;
  }
  .write-data img{
    width: 22px;
    height: 22px;
  }
  .write-data span{
    font-size: 12px;
    color: #BBBBBB;
  }
  .write-contain .write-text{
    width: 90%;
    margin-top: 40px;
    margin-bottom: 20px;
    text-align: left;
    font-size: 14px;
    line-height: 20px;
  }
</style>
