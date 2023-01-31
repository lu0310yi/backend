<template>
<div style="font-size: 12px;display:flex">
    <div style="flex: 1; font-size:18px">
      <span :class="collapseBtnClass" style="cursor: pointer" @click="collapse"></span>
        <el-breadcrumb separator="/" style="display: inline-block; margin-left: 10px">
          <el-breadcrumb-item :to="{ path:'/' } ">首页</el-breadcrumb-item>
          <el-breadcrumb-item>用户管理</el-breadcrumb-item>
        </el-breadcrumb>
    </div>
    <el-dropdown style="width: 100px;cursor: pointer">
      <div style="display: inline-block">
        <img :src="user.avatar"  style="width:30px;border-radius: 50%;position:relative;top:10px;right:5px">
        <span>{{user.nickname}}</span><i class="el-icon-arrow-down" style="margin-right: 15px"></i>
      </div>

      <el-dropdown-menu slot="dropdown">
        <el-dropdown-item>
          <router-link to="/person" >个人信息</router-link>
        </el-dropdown-item>
        <el-dropdown-item><span @click="logout">退出</span></el-dropdown-item>
      </el-dropdown-menu>
    </el-dropdown>
</div>
</template>

<script>
export default {
  name: "Header",
  props: {
    collapseBtnClass: String,
    collapse: Function
  },
  created() {
  },
  data(){
    return{
      user: (localStorage.getItem("user") ? JSON.parse(localStorage.getItem("user")) : {})
    }
  },
  methods:{
    logout(){
      localStorage.removeItem('user');
      this.$router.push('/login');
    }
  }
}
</script>

<style scoped>

</style>