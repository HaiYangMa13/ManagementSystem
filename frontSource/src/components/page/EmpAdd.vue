<template>
    <div>
        <div class="crumbs">
            <el-breadcrumb separator="/">
                <el-breadcrumb-item>
                    <i class="el-icon-lx-calendar"></i> 表单
                </el-breadcrumb-item>
                <el-breadcrumb-item>基本表单</el-breadcrumb-item>
            </el-breadcrumb>
        </div>
        <div class="container">
            <div class="form-box">
                <el-form ref="form" :model="form" label-width="80px">
                    <el-form-item label="名称">
                        <el-input v-model="form.name"></el-input>
                    </el-form-item>
					<el-form-item label="编号">
					    <el-input v-model="form.empno"></el-input>
					</el-form-item>
					<el-form-item label="性别">
					       <el-select v-model="form.sex" placeholder="请选择">
					           <el-option label="男" value="男"></el-option>
							   <el-option label="女" value="女"></el-option>
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
				<el-form-item label="照片">
					    <input type="file" ref="photo"  id="savePhoto" name="myPhoto"/>
					</el-form-item> 
				<el-form-item label="部门">
				       <el-select v-model="form.deptid" placeholder="请选择">
				           <el-option :label="dept.name" :value="dept.id" v-for="dept in depts"></el-option>
				       </el-select>
				   </el-form-item>
					
					<el-form-item label="职位" placeholder="请选择">
					   <el-select v-model="form.roleid">
						   <el-option :label="role.name" :value="role.id" v-for="role in roles"></el-option>
					   </el-select>
					</el-form-item>
                    <el-form-item>
                        <el-button type="primary" @click="onSubmit">添加</el-button>
                        <el-button @click="backhome">取消</el-button>
                    </el-form-item>
                </el-form>
            </div>
        </div>
    </div>
</template>

<script>
export default {
    name: 'baseform',
    data() {
        return {
            form: {
            },
			depts:[],
			roles:[]
        };
    },
	created() {
	this.getDept();
	this.getRole();
	},
	
    methods: {
		backhome(){
			this.$router.push({path:"/emp"})
		},
		getDept(){
			this.$http.get(
			"http://localhost:8890/manager/emp/loadDept"
			).then(function(res){
			    console.log(res.data.name);
				this.depts=res.body;
			});
		},
		getRole(){
			this.$http.get(
				"http://localhost:8890/manager/emp/loadRole"
			).then(function(res){
				this.roles=res.body;
			});
		},
        onSubmit() {
			let self = this;
			if(self.$refs.photo.files.length !== 0){
				var formData = new FormData();
				formData.append("photo",this.$refs.photo.files[0]);
				
				let params={
					name:this.form.name,
					empno:this.form.empno,
					sex:this.form.sex,
					sal:this.form.sal,
					birth:this.form.birth,
					deptid:this.form.deptid,
					roleid:this.form.roleid
				}
				
				formData.append("name",params.name);
				formData.append("empno",params.empno);
				formData.append("sex",params.sex);
				formData.append("sal",params.sal);
				formData.append("birth",params.birth);
				formData.append("deptid",params.deptid);
				formData.append("roleid",params.roleid);
				this.$http.post("http://localhost:8890/manager/emp/add",formData,{emulateJSON:true},{
					headers:{'Content-Type':'multipart/form-data'}
				}).then(function(){
					this.$message.success("添加成功")
					this.$router.push({path:"/emp"})
				});
			};
        }
    }
};
</script>