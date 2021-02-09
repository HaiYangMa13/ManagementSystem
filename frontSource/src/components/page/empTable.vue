<template>
    <div>
        <div class="crumbs">
            <el-breadcrumb separator="/">
                <el-breadcrumb-item>
                    <i class="el-icon-lx-cascades"></i> 基础表格
                </el-breadcrumb-item>
            </el-breadcrumb>
        </div>
        <div class="container">
            <div class="handle-box">
                <el-button
                    type="primary"
                    icon="el-icon-delete"
                    class="handle-del mr10"
                    @click="delAllSelection"
                >批量删除</el-button>
                <el-input v-model="query.name" placeholder="用户名" class="handle-input mr10"></el-input>
                <el-button type="primary" icon="el-icon-search" @click="handleSearch">搜索</el-button>
            </div>
            <el-table
                :data="tableData"
                border
                class="table"
                ref="multipleTable"
                header-cell-class-name="table-header"
                @selection-change="handleSelectionChange"
            >
                <el-table-column type="selection" width="55" align="center"></el-table-column>
                <el-table-column prop="id" label="ID" width="55" align="center"></el-table-column>
                <el-table-column prop="name" label="名称"></el-table-column>
				<el-table-column prop="empno" label="编号"></el-table-column>
                <el-table-column prop="sex" label="性别"></el-table-column> 
				<el-table-column prop="sal" label="工资"></el-table-column> 
				<el-table-column prop="birth" label="生日"></el-table-column> 
				<el-table-column prop="photoname" label="照片">
					<template slot-scope="scope">
						<img :src="'http://localhost:9999/images/'+scope.row.photoname" min-width="50" height="40" />
					</template>
				</el-table-column> 
				<el-table-column prop="dept.name" label="部门"></el-table-column> 
                <el-table-column label="操作" width="180" align="center" v-if="show">
                    <template slot-scope="scope">
                        <el-button
                            type="text"
                            icon="el-icon-edit"
                            @click="handleEdit(scope.$index, scope.row)"
                        >编辑</el-button>
                        <el-button
                            type="text"
                            icon="el-icon-delete"
                            class="red"
                            @click="handleDelete(scope.$index, scope.row)"
                        >删除</el-button>
                    </template>
                </el-table-column>
            </el-table>
            <div class="pagination">
                <el-pagination
                    background
                    layout="total, prev, pager, next"
                    :current-page="query.pageIndex"
                    :page-size="query.pageSize"
                    :total="pageTotal"
                    @current-change="handlePageChange"
                ></el-pagination>
            </div>
        </div>

        <!-- 编辑弹出框 -->
        <el-dialog title="编辑" :visible.sync="editVisible" width="30%">
            <el-form ref="form" :model="form" label-width="70px">
                <el-form-item label="名称">
                    <el-input v-model="form.name"></el-input>
                </el-form-item>
                <el-form-item label="编号">
                    <el-input v-model="form.empno"></el-input>
                </el-form-item>
				<el-form-item label="性别">
					<el-select v-model="form.sex" placeholder="请选择">
						<el-option key="男" label="男" value="男"></el-option>
						<el-option key="女" label="女" value="女"></el-option>
					</el-select>
				</el-form-item>
				<el-form-item label="工资">
				    <el-input v-model="form.sal"></el-input>
				</el-form-item>
				<el-form-item label="生日">
				      <el-col :span="11">
				          <el-date-picker
				              type="date"
				              placeholder="选择日期"
				              v-model="form.birth"
				              value-format="yyyy-MM-dd"
				              style="width: 100%;"
				          ></el-date-picker>
						  </el-col>
				</el-form-item>
				<el-form-item label="密码">
				    <el-input v-model="form.pwd"></el-input>
				</el-form-item>
				<el-form-item label="照片">
				    <input type="file" id="savePhoto" name="myPhoto"  ref="new_Photo"/>
				</el-form-item>
		     <el-form-item label="部门">
		            <el-select v-model="form.deptid" placeholder="请选择">
		                <el-option :label="dept.name" :value="dept.id" v-for="dept in depts"></el-option>
		            </el-select>
		        </el-form-item>
				<el-form-item label="职位" v-show="roleshow">
				       <el-select v-model="form.roleid" placeholder="请选择">
				           <el-option :label="role.name" :value="role.id" v-for="role in roles"></el-option>
				       </el-select>
				   </el-form-item>
            </el-form>
            <span slot="footer" class="dialog-footer">
                <el-button @click="editVisible = false">取 消</el-button>
                <el-button type="primary" @click="saveEdit">确 定</el-button>
            </span>
        </el-dialog>
    </div>
</template>

<script>
import { fetchData } from '../../api/index';
export default {
    name: 'basetable',
    data() {
        return {
            query: {
                name: '',
                pageIndex: 1,
                pageSize: 5
            },
			depts:[],
			roles:[],
			records:[],
			show:true,
			roleshow:false,
            tableData: [],
            multipleSelection: [],
            delList: [],
            editVisible: false,
            pageTotal: 0,
            form: {},
            idx: -1,
            id: -1
        };
    },
    created() {
		if(this.getData()==null){
			this.getData();
		}  
    },
    methods: {
        // 获取 easy-mock 的模拟数据
        getData() {
			if(localStorage.getItem("user")==="员工"){
				this.show=false;
			}
			this.$http({
				method:'Get',
				url:'http://localhost:8890/manager/emp/count'
			}).then(function(res){
				this.pageTotal=res.body.length;
			});
          this.$http({
			  method:'Get',
	          url:'http://localhost:8890/manager/emp/pager?pageNo='+this.query.pageIndex+'&pageSize='+this.query.pageSize
		  }).then(function(res){
			  this.tableData=res.body;
		  });
        },
        // 触发搜索按钮
        handleSearch() {
			this.$http({
				method:'Get',
				url:'http://localhost:8890/manager/emp/'+this.query.name+'/search',
			}).then(function(res){
				console.log(res);
				this.tableData=res.body;
			})
        },
        // 删除操作
        handleDelete(index, row) {
            // 二次确认删除
            this.$confirm('确定要删除吗？', '提示', {
                type: 'warning'
            })
                .then(() => {
                    this.$message.success('删除成功');
                    this.tableData.splice(index, 1);
					this.$http({
						method:'post',
						url:'http://localhost:8890/manager/emp/'+row.id+'/del'
					}).then(function(){
						this.getData();
					});
                }).catch(() => {});
        },
        // 多选操作
        handleSelectionChange(val) {
            this.multipleSelection = val;
        },
        delAllSelection() {
            const length = this.multipleSelection.length;
            let str = '';
            this.delList = this.delList.concat(this.multipleSelection);
            for (let i = 0; i < length; i++) {
                str += this.multipleSelection[i].name + ' ';
            }
			for(let i=0;i<length;i++){
				this.records[i] = this.multipleSelection[i].id;
			}
            this.$message.error(`删除了${str}`);
            this.multipleSelection = [];
			alert(this.records[0])
			this.$http({
				method:'post',
				url:'http://localhost:8890/manager/emp/delAll?records='+this.records
			}).then(function(){
				this.getData();
			})
        },
        // 编辑操作
        handleEdit(index, row) {
			if(localStorage.getItem("role")=="管理员"){
				this.roleshow=true;
					this.$http.get(
						"http://localhost:8890/manager/emp/loadRole"
					).then(function(res){
						this.roles=res.body;
					});
					this.$http({
						method:'Get',
						url:'http://localhost:8890/manager/emp/loadDept'
					}).then(function(res){
						this.depts=res.body;
					});
			}else{
			this.$http({
				method:'Get',
				url:'http://localhost:8890/manager/emp/loadDept'
			}).then(function(res){
				this.depts=res.body;
			});	
			}
            this.idx = index;
            this.form = row;
            this.editVisible = true;
			
        },
        // 保存编辑
        saveEdit() {
			this.editVisible = false;
			this.$message.success(`修改第 ${this.idx + 1} 行成功`);
			let self = this;
			if(self.$refs.new_Photo.files.length!==0){
				var formData = new FormData();
				formData.append("photo",self.$refs.new_Photo.files[0]);
				let params={
				id:this.form.id,
				roleid:this.form.roleid,
				name:this.form.name,
				empno:this.form.empno,
				sex:this.form.sex,
				sal:this.form.sal,
				pwd:this.form.pwd,
				birth:this.form.birth,
				deptid:this.form.deptid,
				}
				alert(params.pwd);
				formData.append("id",params.id);
				formData.append("roleid",params.roleid);
				formData.append("name",params.name);
				formData.append("empno",params.empno);
				formData.append("sex",params.sex);
				formData.append("sal",params.sal);
				formData.append("pwd",params.pwd);
				formData.append("birth",params.birth);
				formData.append("deptid",params.deptid);
				this.$http.post('http://localhost:8890/manager/emp/update',formData,{emulateJSON:true},{
					headers:{'Content-Type':'multipart/form-data'}
				}).then(reponse => {
					console.log(response.data);
					this.$router.push("/emp");
				})
			}else{
				this.$router.push("/emp");
				this.$message.error("请选择图片！")
			}
        },
        // 分页导航
        handlePageChange(val) {
            this.$set(this.query, 'pageIndex', val);
            this.getData();
        }
    }
};
</script>

<style scoped>
.handle-box {
    margin-bottom: 20px;
}

.handle-select {
    width: 120px;
}

.handle-input {
    width: 300px;
    display: inline-block;
}
.table {
    width: 100%;
    font-size: 14px;
}
.red {
    color: #ff0000;
}
.mr10 {
    margin-right: 10px;
}
.table-td-thumb {
    display: block;
    margin: auto;
    width: 40px;
    height: 40px;
}
</style>
