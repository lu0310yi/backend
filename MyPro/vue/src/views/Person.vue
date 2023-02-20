<template>
  <el-card>
    <el-form :model="form" label-width="80px">
      <el-form-item label="昵称">
        <el-input v-model="form.nickname" autocomplete="off"></el-input>
      </el-form-item>
      <el-form-item label="密码">
        <el-input v-model="form.password" autocomplete="off"></el-input>
      </el-form-item>
      <el-form-item label="性别">
        <el-input v-model="form.gender" autocomplete="off"></el-input>
      </el-form-item>
      <el-form-item label="手机号">
        <el-input v-model="form.mobile" autocomplete="off"></el-input>
      </el-form-item>
      <el-form-item label="生日">
        <el-input v-model="form.gmtBirth" autocomplete="off"></el-input>
      </el-form-item>
      <el-form-item label="个性签名">
        <el-input v-model="form.signature" autocomplete="off"></el-input>
      </el-form-item>
    </el-form>
    <div slot="footer" class="dialog-footer">
      <el-button type="primary" @click="saveUser">确 定</el-button>
    </div>
  </el-card>

</template>

<script>

export default {
  name: "Person",
  data(){
    return {
      user: localStorage.getItem('user')?JSON.parse(localStorage.getItem('user')):{},
      form: {}
    }
  },
  created(){
    // console.log("=======");
    // let user = localStorage.getItem('user')?JSON.parse(localStorage.getItem('user')):{};
    // console.log(this.user);
    this.request.get("/user/auth/info/"+this.user.userId).then(res=> {
      if (res.code == '200') {
        console.log(res.data);
      this.form = res.data;
      }
    })
  },
  methods: {
    saveUser(){
      this.request.post("http://localhost:8081/user/save"+this.form).then(
          res=>{
            if(res){
              this.$message.success("新增成功")
              this.dialogFormVisible = false
            }else{
              this.$message.error("新增失败")
            }
          }
      )
    },
  }

}
</script>

<style scoped>

</style>