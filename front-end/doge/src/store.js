import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    user: undefined,
    dogId: '',
    latestDogId: '',
    articleId: '',
    latestArticleId: '',
    otherUserId: ''
  },
  mutations: {
    login (state, user) {
      state.user = user
    },
    logout (state) {
      state.user = undefined
    },
    getDogById (state, dogId) {
      state.dogId = dogId
    },
    getLatestDogId (state, latestDogId) {
      state.latestDogId = latestDogId
    },
    getArticleById (state, articleId) {
      state.articleId = articleId
    },
    getLatestArticleId (state, latestArticleId) {
      state.latestArticleId = latestArticleId
    },
    getOtherUserId (state, otherUserId) {
      state.otherUserId = otherUserId
    }

  },
  actions: {
    login (context, user) {
      context.commit('login', user)
    },
    logout (context) {
      context.commit('logout')
    },
    getDogById (context, dogId) {
      context.commit('getDogById', dogId)
    },
    getLatestDogId (context, latestDogId) {
      context.commit('getLatestDogId', latestDogId)
    },
    getArticleById (context, articleId) {
      context.commit('getArticleById', articleId)
    },
    getLatestArticleId (context, latestArticleId) {
      context.commit('getLatestArticleId', latestArticleId)
    },
    getOtherUserId (context, otherUserId) {
      context.commit('getOtherUserId', otherUserId)
    }
  }
})
