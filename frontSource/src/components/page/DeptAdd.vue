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
                    <el-form-item label="部门">
                        <el-input v-model="form.name"></el-input>
                    </el-form-item>
					<el-form-item label="部门主管">
					    <el-input v-model="form.manager"></el-input>
					</el-form-item>
                    <el-form-item>
                        <el-button type="primary" @click="onSubmit">添加</el-button>
                        <el-button>取消</el-button>
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
                name: '',
                manager:''
            }
        };
    },
    methods: {
		verify(){
			alert("hello");
		},
        onSubmit() {
            this.$http.post("http://localhost:8890/manager/dept/add",this.form).then(function(){
				this.$message.success("添加成功")
				this.$router.push({path:"/dept"})
			});
        }
    }
};
</script>