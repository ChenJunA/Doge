import Vue from 'vue'
import Router from 'vue-router'
import login from './components/login.vue'
import home from './views/home.vue'
import register from './components/register.vue'
import userPage from './views/userPage'
import updateUser from './views/updateUser'
import dogPage from './views/dogPage'
import forumPage from './views/forumPage'
import forumInfoPage from './views/forumInfoPage'
import materialPage from './views/materialPage'
import otherUserPage from './views/otherUserPage'
import background from './views/background'
import userInfo from './components/userInfo'
import dogeInfo from './components/dogeInfo'
import logInfo from './components/logInfo'
import dogeCommentInfo from './components/dogeCommentInfo'
import articleInfo from './components/articleInfo'
import articleCommentInfo from './components/articleCommentInfo'

Vue.use(Router)

export default new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: [
    {
      path: '/',
      name: 'login',
      component: login
    },
    {
      path: '/register',
      name: 'register',
      component: register
    },
    {
      path: '/login',
      name: 'login',
      component: login
    },
    {
      path: '/home',
      name: 'home',
      component: home,
      children: [
        {
          path: 'pageHeader',
          name: 'pageHeader',
          component: () => import(/* webpackChunkName: "pageHeader" */ './components/pageHeader.vue')
        },
        {
          path: 'pageContent',
          name: 'pageContent',
          component: () => import(/* webpackChunkName: "pageContent" */ './components/pageContent.vue')
        }
      ]
    },
    {
      path: '/userPage',
      name: 'userPage',
      component: userPage
    },
    {
      path: '/updateUser',
      name: 'updateUser',
      component: updateUser
    },
    {
      path: '/dogPage',
      name: 'dogPage',
      component: dogPage
    },
    {
      path: '/forum',
      name: 'forum',
      component: forumPage
    },
    {
      path: '/forumInfoPage',
      name: 'forumInfoPage',
      component: forumInfoPage
    },
    {
      path: '/material',
      name: 'material',
      component: materialPage
    },
    {
      path: '/otherUserPage',
      name: 'otherUserPage',
      component: otherUserPage
    },
    {
      path: '/background',
      name: 'background',
      component: background
    },
    {
      path: '/userInfo',
      name: 'userInfo',
      component: userInfo
    },
    {
      path: '/dogeInfo',
      name: 'dogeInfo',
      component: dogeInfo
    },
    {
      path: '/logInfo',
      name: 'logInfo',
      component: logInfo
    },
    {
      path: '/dogeCommentInfo',
      name: 'dogeCommentInfo',
      component: dogeCommentInfo
    },
    {
      path: '/articleInfo',
      name: 'articleInfo',
      component: articleInfo
    },
    {
      path: '/articleCommentInfo',
      name: 'articleCommentInfo',
      component: articleCommentInfo
    }
  ]
})
