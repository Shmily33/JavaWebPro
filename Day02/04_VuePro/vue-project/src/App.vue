<template>
  <div>
    <!-- <h1>{{message}}</h1> -->
    <!-- 增加ele-ui <e 回车 自动导入 -->
    <!-- <element-view></element-view> -->

    <!-- 员工管理 -->
    <!-- <emp-view></emp-view> -->
    <router-view></router-view>

  </div>
  <!-- <div id="app">
    <nav>
      <router-link to="/">Home</router-link> |
      <router-link to="/about">About</router-link>
    </nav>
    <router-view />
  </div> -->
</template>

<script>
// import EmpView from './views/tlias/EmpView.vue';
// import ElementView from './views/element/ElementView.vue';
export default {
  components: { /*EmpView,ElementView*/ }, // 组件这里是import后内容
  data() {
    return {
      message:"Hello vue222"
    }
  },
  methods: {
    
  },
};
</script>

<style>
/* #app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

nav {
  padding: 30px;
}

nav a {
  font-weight: bold;
  color: #2c3e50;
}

nav a.router-link-exact-active {
  color: #42b983;
} */
</style>
