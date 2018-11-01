import Vue from 'vue'
import Router from 'vue-router'
import Login from '../Login'
import LoginModule from '../base/LoginModule'
import RegisterModule from '../base/RegisterModule'
import Home from '../Home'
import In from '../base/In'
import Grow from '../base/Grow'
import Tag from '../base/Tag'
import Something from '../base/Something'
import Write from '../base/Write'

Vue.use(Router);

export default new Router({
  routes: [
    {
      path: '/',
      name: 'login',
      component: Login
    },
    {
      path:'/login',
      name:'loginModule',
      component:LoginModule
    },
    {
      path:'/regieter',
      name:'registerModule',
      component:RegisterModule
    },
    {
      path:'/home',
      name:'home',
      component:Home,
      redirect:'/home/in',
      children:[
        {path:'in',name:'in',component:In},
        {path:'grow',name:'grow',component:Grow},
        {path:'tag',name:'tag',component:Tag},
        {path:'something',name:'something',component:Something},
        {path:'write',name:'write',component:Write},
      ]
    }
  ]
})
