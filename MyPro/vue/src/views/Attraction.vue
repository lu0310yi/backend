<template>
  <div>
    <div style="margin: 10px 0">
      <el-input style="width: 200px;margin-right: 5px" placeholder="请输入名称" v-model="name" suffix-icon="el-icon-search"></el-input>
      <el-input style="width: 200px;margin-right: 5px" placeholder="请输入地址" v-model="location" suffix-icon="el-icon-search"></el-input>
      <el-input style="width: 200px;" placeholder="请输入描述" v-model="description" suffix-icon="el-icon-search"></el-input><el-button style="margin-left: 5px" type="primary" @click="searchAttraction">搜索</el-button>
    </div>
    <div style="margin: 10px 0">
      <el-button type="primary" @click="handleAdd"> 新增<i style="margin-left: 5px;" class="el-icon-circle-plus-outline"/></el-button>
      <el-popconfirm
          style="margin-left: 5px;"
          confirm-button-text='好的'
          cancel-button-text='不用了'
          icon="el-icon-info"
          icon-color="red"
          title="您确定删除吗？"
          @confirm="handleBatchDelete()"
      >
        <el-button type="danger" slot="reference"> 批量删除<i style="margin-left: 5px;" class="el-icon-remove-outline"/></el-button>
      </el-popconfirm>
      <el-button type="primary"> 导入<i style="margin-left: 5px;" class="el-icon-bottom"/></el-button>
      <el-button type="primary"> 导出<i style="margin-left: 5px;" class="el-icon-top"/></el-button>
    </div>
    <el-table :data="tableData" border stripe header-cell-class-name="headBg" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55"></el-table-column>
      <el-table-column prop="attractionId" label="attractionId" width="140"></el-table-column>
      <el-table-column prop="name" label="名称" width="120"></el-table-column>
      <el-table-column prop="location" label="地址" width="120"></el-table-column>
      <el-table-column prop="description" label="描述" width="120"></el-table-column>
      <el-table-column prop="score" label="评分" width="120"></el-table-column>
      <el-table-column prop="cover" label="封面" width="120"></el-table-column>
      <el-table-column>
        <template slot-scope="scope">
          <el-button type="success" @click="handleEdit(scope.row)">编辑<i class="el-icon-edit-outline"></i></el-button>
          <el-popconfirm
              style="margin-left: 5px;"
              confirm-button-text='好的'
              cancel-button-text='不用了'
              icon="el-icon-info"
              icon-color="red"
              title="确定删除吗？"
              @confirm="handleDelete(scope.row.userId)"
          >
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
    </el-pagination>
    <el-dialog title="新增景点" :visible.sync="dialogFormVisible">
      <el-form :model="form" label-width="80px">
        <el-form-item label="名称">
          <el-input v-model="form.name" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="地址">
          <el-input v-model="form.location" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="描述">
          <el-input v-model="form.description" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="封面">
          <el-input v-model="form.cover" autocomplete="off"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible = false">取 消</el-button>
        <el-button type="primary" @click="saveAttraction" >确 定</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import request from "@/utils/request";
export default {
  name: "Attraction",
  data(){
    return{
      tableData: [],
      total: 0,
      pageSize: 2,
      pageNum: 1,
      name: '',
      description: '',
      location: '',
      cover: '',
      dialogFormVisible: false,
      form: {},
      multipleSelection: [],
      ids: [],
      headBg: 'headBg'
    }
  },
  created() {
    this.load()
  },
  methods: {
    load() {
      request.get("http://localhost:8081/attraction/list/find", {
        params: {
          pageSize: this.pageSize,
          pageNum: this.pageNum,
          name: this.name,
          description: this.description,
          location: this.location
        }
      }).then(res => {
        if (res.data != null) {
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
      request.post("/attraction/batchDelete?ids="+ids).then(
          res=> {
            if (res) {
              this.$message.success("删除成功")
              this.dialogFormVisible = false
              load()
            } else {
              this.$message.error("删除失败")
            }
          }
      )
    },
    handleEdit(row){
      this.form=row
      this.dialogFormVisible=true
    },
    handleDelete(id){
      request.delete("/attraction/delete",{
        userId: id
      }).then(res=>{
        if(res){
          this.$message.success("删除成功")
          this.dialogFormVisible = false
        }else{
          this.$message.error("删除失败")
        }
      })
    },
    handleAdd(){
      this.dialogFormVisible = true
    },
    searchAttraction(){
      this.load()
    },
    saveAttraction(){
      request.post("/attraction/save"+this.form).then(
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

<style scoped>
.headBg{
  background-color: aquamarine!important;
}
</style>