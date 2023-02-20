<template>
  <div class="wrapper">
    <div style="margin: 200px auto;background-color:#fff;width:350px;height: 300px;padding: 20px;border-radius: 10px">
    <el-form :model="user" :rules="rules" ref="userForm" >
      <div style="margin:20px 0;text-align: center;font-size: 24px"><b>登录</b></div>
      <el-form-item prop="mobile">
        <el-input size="medium" style="margin:10px 0"prefix-icon="el-icon-user" v-model="user.mobile"></el-input>
      </el-form-item>
      <el-form-item prop="password">
        <el-input size="medium" style="margin:10px 0"prefix-icon="el-icon-lock" show-password v-model="user.password"></el-input>
      </el-form-item>
      <el-form-item style="margin:10px 0;text-align: right">
        <el-button type="primary" size="small" autocomplete="off" @click="login">登录</el-button>
        <el-button type="warning" size="small" autocomplete="off" @click="$router.push('/register')">注册</el-button>
      </el-form-item>
    </el-form>
    </div>
  </div>
</template>

<script>
export default {
  name: "Login",
  data(){
    return {
      user:{},
      rules: {
        mobile: [
          {required: true, message: '请输入手机号', trigger: 'blur'},
          {min: 1, message: '长度在 1-11 个字符', trigger: 'blur'}
        ],
        password: [
          {required: true, message: '请输入密码', trigger: 'blur'},
          {min: 1, message: '长度在1-50 个字符', trigger: 'blur'}
        ],
      }
    }
  },
  methods: {
    login(){
      this.$refs['userForm'].validate((valid) => {
        if (valid) {
          this.request.post("/user/auth/login", this.user).then(res => {
            if (res.code == 200) {
              localStorage.setItem("user",JSON.stringify(res.data))
              // console.log(res.data)
              // console.log(JSON.parse(localStorage.getItem("user")))
              this.$router.push("/")
              this.$message.success("登陆成功")
            } else {
              this.$message.error(res.msg)
            }
          })
        }
        // console.log(this.request.get("/setting/info/1"))
      });
    }
  }

}
</script>

<style>
  .wrapper{
    height: 100vh;
    background-image: linear-gradient(to bottom right,#FC4668,#3F5EF8);
    overflow: hidden;
  }
</style>