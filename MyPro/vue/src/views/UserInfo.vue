<template>
<div>
<!--  <el-table :data="userInfoData">-->
    <el-form :model="infoForm" :inline="true"  label-width="50px"  class="demo-form-inline">
      <el-form-item label="头像">
        <!--        <el-input v-model="infoForm.avatar" autocomplete="off"></el-input>-->
        <img :src="infoForm.avatar"  style="width:30px;height:30px;border-radius: 50%;position:relative;top:10px;right:5px">
      </el-form-item>
      <el-form-item style="width:50%"  label="昵称" >
        <el-input  v-model="infoForm.nickname" autocomplete="off"></el-input>
      </el-form-item>

      <el-form-item label="文章">
        <!--        <el-input v-model="infoForm.article" autocomplete="off"></el-input>-->
        <el-table :data="userInfoData" stripe style="width: 100%">
          <el-table-column prop="attractionId" label="日期" width="180"></el-table-column>
          <el-table-column prop="title" label="姓名" width="180"></el-table-column>
          <el-table-column prop="content" label="地址"></el-table-column></el-table>
        <!--        <el-button><router-link to="/" >查看</router-link></el-button>-->
      </el-form-item>
      <el-form-item label="帖子">
        <el-input v-model="infoForm.post" autocomplete="off"></el-input>
        <el-button @click="">查看</el-button>
      </el-form-item>
    </el-form>
<!--  </el-table>-->
</div>
</template>

<script>
import request from "@/utils/request";

export default {
  name: "UserInfo",
  data() {
    return {
      infoForm: {},
      userInfoData: [],
    }
  },

  created() {
      let row = JSON.parse(localStorage.getItem("userInfoRow"))
      this.dialogInfoFormVisible = true;
      this.infoForm.nickname = row.nickname;
      this.infoForm.avatar = row.avatar;
      console.log(row);
      request.get("/user/profile/articles/" + row.userId).then(
          res => {
            console.log(res.data);
            this.userInfoData = res.data;
          }
      )
  },
  methods: {
  }
}
</script>

<style scoped>

</style>