
//使用post发送ajax时需要设置
Vue.http.options.emulateJSON = true;

const  app = new Vue({
    el:"#app",

    // created:function(){
    //     /*当vue实例化后加载下拉菜单的值*/
    //     this.getClasses();
    // },

    methods:{

        /*取消按钮事件*/
        news:function(){
            window.location.href="updateCompanyUser.html"
        },

    }

});
