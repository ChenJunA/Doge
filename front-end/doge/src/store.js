import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    user: undefined,
    dogId: '',
    latestDogId: ''
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
    }
  }
})
