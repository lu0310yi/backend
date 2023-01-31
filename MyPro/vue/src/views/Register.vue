<template>
  <div class="wrapper">
    <div style="margin: 200px auto;background-color:#fff;width:350px;height: 300px;padding: 20px;border-radius: 10px">
    <el-form :model="user" :rules="rules" ref="userForm" >
      <div style="margin:20px 0;text-align: center;font-size: 24px"><b>注册</b></div>
      <el-form-item prop="mobile">
        <el-input placeholder="请输入手机号" size="medium" style="margin:10px 0"prefix-icon="el-icon-user" v-model="user.mobile"></el-input>
      </el-form-item>
      <el-form-item prop="password">
        <el-input placeholder="请输入密码" size="medium" style="margin:10px 0"prefix-icon="el-icon-lock" show-password v-model="user.password"></el-input>
      </el-form-item>
      <el-form-item prop="confirmPassword">
        <el-input placeholder="请确认密码" size="medium" style="margin:10px 0"prefix-icon="el-icon-lock" show-password v-model="user.confirmPassword"></el-input>
      </el-form-item>
      <el-form-item style="margin:10px 0;text-align: right">
        <el-button type="primary" size="small" autocomplete="off" @click="register">注册</el-button>
        <el-button type="warning" size="small" autocomplete="off" @click="$router.push('/login')">返回登陆</el-button>
      </el-form-item>
    </el-form>
    </div>
  </div>
</template>

<script>
export default {
  name: "Register",
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
        confirmPassword: [
          {required: true, message: '请输入密码', trigger: 'blur'},
          {min: 1, message: '长度在1-50 个字符', trigger: 'blur'}
        ],
      }
    }
  },
  methods: {
    register(){
      this.$refs['userForm'].validate((valid) => {
        if (valid) {
          this.request.post("/user/auth/signup", this.user).then(res => {
            if (res.code == 200) {
              this.$message.success("注册成功")
            } else {
              this.$message.error(res.msg)
            }
          })
        }
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