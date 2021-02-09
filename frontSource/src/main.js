import Vue from 'vue';
import App from './App.vue';
import router from './router';
import ElementUI from 'element-ui';
import VueI18n from 'vue-i18n';
import VueResource from 'vue-resource';
import { messages } from './components/common/i18n';
import 'element-ui/lib/theme-chalk/index.css'; // 默认主题
// import './assets/css/theme-green/index.css'; // 浅绿色主题
import './assets/css/icon.css';
import './components/common/directives';
import 'babel-polyfill';

Vue.config.productionTip = false;
Vue.use(VueI18n);
Vue.use(VueResource)
Vue.use(ElementUI, {
    size: 'small'
});
const i18n = new VueI18n({
    locale: 'zh',
    messages
});

//使用钩子函数对路由进行权限跳转
router.beforeEach((to, from, next) => {  
    console.log(to.fullPath);
		if (to.meta.requireAuth) { 
			if(localStorage.getItem('name')){ 
				next();    
			}else{ 
				 alert("请登录!");
				next({path: '/login',query: {redirect: to.fullPath}});    
			}  
		}else
		{     
			next();  
		} 
	}	
);
new Vue({
    router,
    i18n,
    render: h => h(App)
}).$mount('#app');
