<template>
    <div class="login-wrap">
        <div class="ms-login">
            <div class="ms-title">后台管理系统</div>
            <el-form :model="param" :rules="rules" ref="login" label-width="0px" class="ms-content">
                <el-form-item prop="name">
                    <el-input v-model="name" placeholder="username">
                        <el-button slot="prepend" icon="el-icon-lx-people"></el-button>
                    </el-input>
                </el-form-item>
                <el-form-item prop="pwd">
                    <el-input
                        type="password"
                        placeholder="password"
                        v-model="pwd"
                        @keyup.enter.native="submit()"
                    >
                        <el-button slot="prepend" icon="el-icon-lx-lock"></el-button>
                    </el-input>
                </el-form-item>
				<el-form-item>
				    <el-radio-group v-model="role" @change="roleChange()"> 
				        <el-radio label="管理员"></el-radio>
				        <el-radio label="员工"></el-radio>
				    </el-radio-group>
				</el-form-item>
                <div class="login-btn">
                    <el-button type="primary" @click="submit()">登录</el-button>
                </div>
                <p class="login-tips" id="roleName" v-show="show">请选择登录角色</p>
            </el-form>
        </div>
    </div>
</template>

<script>
export default {
    data: function() {
        return {
                name: 'admin',
                pwd: '123123',
				role:'',
				show:true,
            rules: {
                username: [{ required: true, message: '请输入用户名', trigger: 'blur' }],
                password: [{ required: true, message: '请输入密码', trigger: 'blur' }],
            },
        };
    },
    methods: {
           submit(){
			   localStorage.clear();
			  if(this.role=='管理员'){
				  this.$http.get("http://localhost:8890/manager/user/login?name="+this.name+"&pwd="+this.pwd+"&role="+this.role).then(function(res){
					  if(res.data!=""){
						  this.$message.success("登录成功");
						  localStorage.setItem("name",res.data.name);
						  localStorage.setItem("pwd",res.data.pwd);
						  localStorage.setItem("role","管理员");
						  this.$router.push({path:'/dashboard'});
					  }else{
						  this.$message.warning("账号或密码错误");
					  }
				  });
			  }else if(this.role=='员工'){
				  this.$http.get("http://localhost:8890/manager/user/login?name="+this.name+"&pwd="+this.pwd+"&role="+this.role).then(function(res){
				  					  if(res.data!=""){
				  						  this.$message.success("登录成功");
				  						  localStorage.setItem("name",res.data.name);
				  						  localStorage.setItem("pwd",res.data.pwd);
				  						  localStorage.setItem("role","员工");
										  localStorage.setItem("user",res.data.roleinfo.name)
										 this.$router.push({path:'/dashboard'});
				  					  }else{
				  						  this.$message.warning("账号或密码错误");
				  					  }
				  });
			  }
            },
			roleChange(){
				this.show=false;
			}
			}
};
</script>

<style scoped>
.login-wrap {
    position: relative;
    width: 100%;
    height: 100%;
    background-image: url(../../assets/img/login-bg.jpg);
    background-size: 100%;
}
.ms-title {
    width: 100%;
    line-height: 50px;
    text-align: center;
    font-size: 20px;
    color: #fff;
    border-bottom: 1px solid #ddd;
}
.ms-login {
    position: absolute;
    left: 50%;
    top: 50%;
    width: 350px;
    margin: -190px 0 0 -175px;
    border-radius: 5px;
    background: rgba(255, 255, 255, 0.3);
    overflow: hidden;
}
.ms-content {
    padding: 30px 30px;
}
.login-btn {
    text-align: center;
}
.login-btn button {
    width: 100%;
    height: 36px;
    margin-bottom: 10px;
}
.login-tips {
    font-size: 12px;
    line-height: 30px;
    color: #fff;
}
</style>