<template>
<div>
  <div style="margin: 10px 0">
    <el-input style="width: 200px;margin-right: 5px" placeholder="请输入昵称" v-model="nickname" suffix-icon="el-icon-search"></el-input>
    <el-input style="width: 200px;margin-right: 5px" placeholder="请输入手机号" v-model="mobile" suffix-icon="el-icon-search"></el-input>
    <el-input style="width: 200px;" placeholder="请输入签名" v-model="signature" suffix-icon="el-icon-search"></el-input><el-button style="margin-left: 5px" type="primary" @click="searchUser">搜索</el-button>
  </div>
  <div style="margin: 10px 0">
    <el-button type="primary" @click="handleAdd"> 新增<i style="margin-left: 5px;" class="el-icon-circle-plus-outline"/></el-button>
    <el-popconfirm style="margin-left: 5px;" confirm-button-text='好的' cancel-button-text='不用了' icon="el-icon-info" icon-color="red"
        title="您确定删除吗？" @confirm="handleBatchDelete()">
      <el-button type="danger" slot="reference"> 批量删除<i style="margin-left: 5px;" class="el-icon-remove-outline"/></el-button>
    </el-popconfirm>
    <el-button type="primary"> 导入<i style="margin-left: 5px;" class="el-icon-bottom"/></el-button>
    <el-button type="primary"> 导出<i style="margin-left: 5px;" class="el-icon-top"/></el-button>
  </div>
  <el-table :data="tableData" border stripe header-cell-class-name="headBg" @selection-change="handleSelectionChange">
    <el-table-column type="selection" width="55"></el-table-column>
    <el-table-column prop="userId" label="userId" width="140"></el-table-column>
    <el-table-column prop="nickname" label="昵称" width="120"></el-table-column>
    <el-table-column prop="password" label="密码" width="120"></el-table-column>
    <el-table-column prop="gender" label="性别" width="120"></el-table-column>
    <el-table-column prop="mobile" label="手机号" width="120"></el-table-column>
    <el-table-column prop="signature" label="签名" width="120"></el-table-column>
<!--    <el-table-column prop="posts" label="帖子" width="120"></el-table-column>-->
<!--    <el-table-column prop="articles" label="文章" width="120"></el-table-column>-->
    <el-table-column>
      <template slot-scope="scope">
<!--        router-link to="/userInfo" >查看详情</router-link>-->
        <el-button type="info" @click="info(scope.row)">查看详情<i class="el-icon-edit-outline"></i></el-button>
        <el-button type="success" @click="handleEdit(scope.row)">编辑<i class="el-icon-edit-outline"></i></el-button>
        <el-popconfirm style="margin-left: 5px;" confirm-button-text='好的' cancel-button-text='不用了' icon="el-icon-info" icon-color="red"
            title="这是一段内容确定删除吗？" @confirm="handleDelete(scope.row.userId)">
          <el-button type="danger" slot="reference">删除<i class="el-icon-delete"></i></el-button>
        </el-popconfirm>
      </template>
    </el-table-column>

  </el-table>
  <el-pagination
      @size-change="handleSizeChange"
      @current-change="handleCurrentChange"
      :current-page="pageNum"
      :page-sizes="[2, 10, 15, 20]"
      :page-size="pageSize"
      layout="total, sizes, prev, pager, next, jumper"
      :total="total">
    <!--            @size-change="handleSizeChange"-->
    <!--            @current-change="handleCurrentChange"-->
    <!--            :current-page="currentPage4"-->
  </el-pagination>

  <el-dialog title="新增用户" :visible.sync="dialogAddFormVisible">
    <el-form :model="addForm" label-width="80px">
      <el-form-item label="昵称">
        <el-input v-model="addForm.nickname" autocomplete="off"></el-input>
      </el-form-item>
      <el-form-item label="密码">
        <el-input v-model="addForm.password" autocomplete="off"></el-input>
      </el-form-item>
      <el-form-item label="性别">
<!--        <el-input v-model="addForm.gender" autocomplete="off"></el-input>-->
        <template>
          <el-radio v-model="addForm.gender" label="男">男</el-radio>
          <el-radio v-model="addForm.gender" label="女">女</el-radio>
        </template>
      </el-form-item>
      <el-form-item label="手机号">
        <el-input v-model="addForm.mobile" autocomplete="off"></el-input>
      </el-form-item>
      <el-form-item label="生日">
        <el-date-picker
            v-model="addForm.gmtBirth"
            type="date"
            placeholder="选择日期">
        </el-date-picker>
<!--        <el-input type="" v-model="addForm.gmtBirth" autocomplete="off"></el-input>-->
      </el-form-item>
      <el-form-item label="个性签名">
        <el-input v-model="addForm.signature" autocomplete="off"></el-input>
      </el-form-item>
    </el-form>
    <div slot="footer" class="dialog-footer">
      <el-button @click="dialogAddFormVisible = false">取 消</el-button>
      <el-button type="primary" @click="addUser" >确 定</el-button>
    </div>
  </el-dialog>
  <el-dialog title="编辑用户" :visible.sync="dialogEditFormVisible">
    <el-form :model="editForm" label-width="80px">
      <el-form-item label="昵称">
        <el-input v-model="editForm.nickname" autocomplete="off"></el-input>
      </el-form-item>
      <el-form-item label="密码">
        <el-input v-model="editForm.password" autocomplete="off"></el-input>
      </el-form-item>
      <el-form-item label="性别">
<!--        <el-input v-model="editForm.gender" autocomplete="off"></el-input>-->
        <template>
          <el-radio v-model="editForm.gender" label="男">男</el-radio>
          <el-radio v-model="editForm.gender" label="女">女</el-radio>
        </template>
      </el-form-item>
      <el-form-item label="手机号">
        <el-input v-model="editForm.mobile" autocomplete="off"></el-input>
      </el-form-item>
      <el-form-item label="生日">
        <el-date-picker
            v-model="editForm.gmtBirth"
            type="date"
            placeholder="选择日期">
        </el-date-picker>
        <!--        <el-input type="" v-model="editForm.gmtBirth" autocomplete="off"></el-input>-->
      </el-form-item>
      <el-form-item label="个性签名">
        <el-input v-model="editForm.signature" autocomplete="off"></el-input>
      </el-form-item>
    </el-form>
    <div slot="footer" class="dialog-footer">
      <el-button @click="dialogEditFormVisible = false">取 消</el-button>
      <el-button type="primary" @click="editUser" >确 定</el-button>
    </div>
  </el-dialog>

  <el-dialog title="用户详情" :visible.sync="dialogInfoFormVisible">
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
    <div slot="footer" class="dialog-footer">
      <el-button @click="dialogInfoFormVisible = false">取 消</el-button>
    </div>
  </el-dialog>
</div>
</template>

<script>
import request from "@/utils/request";

export default {
  name: "User",
  data(){
    return{
      tableData: [],
      userInfoData: [],
      total: 0,
      pageSize: 2,
      pageNum: 1,
      nickname: '',
      mobile: '',
      gender: 1,
      signature: '',
      avatar: '',
      post: '',
      article: '',
      dialogEditFormVisible: false,
      dialogInfoFormVisible:false,
      dialogAddFormVisible:false,
      editForm: {},
      addForm: {},
      infoForm: {},
      multipleSelection: [],
      ids: [],
      headBg: 'headBg',
    }
  },
  created() {
    this.load()
  },
  methods: {
    load(){
      request.get("http://localhost:8081/user/list/findUser",{
        params: {
          pageSize: this.pageSize,
          pageNum:  this.pageNum,
          nickname: this.nickname,
          mobile: this.mobile,
          signature: this.signature
        }
      }).then(res =>{
        if(res.data!=null) {
          this.tableData = res.data.list
          this.total = res.data.total
        }
      })
    },
    handleSelectionChange(val){
      this.multipleSelection = val;
    },
    handleBatchDelete(){
      let ids = this.multipleSelection.map(v => v.userId)
      request.post("/user/batchDelete/"+ids).then(
          res=> {
            if (res) {
              this.$message.success("删除成功")
              this.dialogFormVisible = false
              this.load()
            } else {
              this.$message.error("删除失败")
            }
          }
      )
    },
    handleEdit(row){
      this.editForm=row
      this.dialogEditFormVisible=true
    },
    editUser(){
      request.post("/user/save",this.editForm).then(
          res=>{
            if(res){
              this.$message.success("修改成功")
              this.dialogEditFormVisible = false
              this.load()
            }else{
              this.$message.error("修改失败")
            }
          }
      );
    },
    addUser(){
      console.log(this.addForm.gender)
      request.post("/user/save",this.addForm).then(
          res=>{
            if(res){
              this.$message.success("新增成功")
              this.dialogAddFormVisible = false
              this.load()
            }else{
              this.$message.error("新增失败")
            }
          }
      );
      this.addForm={};
    },
    info(row){
      localStorage.setItem("userInfoRow",JSON.stringify(row))
      this.$router.push('/userInfo')
    },
    handleDelete(id){
      request.delete("/user/delete/"+ id).then(res=>{
        if(res){
          this.$message.success("删除成功")
          this.dialogFormVisible = false
          this.load()
        }else{
          this.$message.error("删除失败")
        }
      })
    },
    handleAdd(){
      this.dialogAddFormVisible = true
    },
    searchUser(){
      this.load()
    },

    handleSizeChange(pageSize) {
      console.log(`每页 ${pageSize} 条`);
      this.pageSize = pageSize;
      this.load()
    },
    handleCurrentChange(pageNum) {
      console.log(`当前页: ${pageNum}`);
      this.pageNum = pageNum;
      this.load()
    }
  }
}
</script>

<style>
.headBg{
  background-color: aquamarine!important;
}
</style>