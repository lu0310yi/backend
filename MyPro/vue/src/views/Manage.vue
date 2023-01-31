<template>
  <div class="home" style="min-height:100%">
    <el-container style="min-height: 100%">
      <el-aside :width="sideWith+'px'" style="background-color: rgb(238, 241, 246); min-height: 100%">
      <Aside :isCollapsed="isCollapsed" :logoTextShow="logoTextShow"/>
      </el-aside>

      <el-container>
        <el-header  >
        <Header :collapse="collapse" :collapseBtnClass="collapseBtnClass"/>
        </el-header>
        <el-main>
         <router-view/>
        </el-main>

      </el-container>
    </el-container>
  </div>
</template>

<script>

import request from "@/utils/request";
import Aside from "@/components/Aside";
import Header from "@/components/Header";

export default {
  name: 'Manage',
  components: {Header, Aside},
  data(){
    return{
      collapseBtnClass: 'el-icon-s-fold',
      isCollapsed: false,
      sideWith: 200,
      logoTextShow: true,
    }
  },

  methods: {

    collapse(){
      this.isCollapsed = !this.isCollapsed
      if(this.isCollapsed){
        this.sideWith = 56
        this.collapseBtnClass='el-icon-s-unfold'
        this.logoTextShow = false
      }else{
        this.sideWith=200
        this.collapseBtnClass='el-icon-s-fold'
        this.logoTextShow=true
      }
    },

  }
}
</script>

