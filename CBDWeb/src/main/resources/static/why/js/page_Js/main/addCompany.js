
//使用post发送ajax时需要设置
Vue.http.options.emulateJSON = true;

const  app = new Vue({
    el:"#app",
    data:{
        /*企业名称*/
        companyName:"",
        /*企业登录名*/
        companyLoginName:"",
        /*企业登录密码*/
        companyLoginPwd:"",
        /*楼层位置*/
        companyAddress:"",
        /*企业联系人*/
        cpmpanyLinkMan:'',
        /*企业联系电话*/
        companyPhone:'',
    },
    // created:function(){
    //     /*当vue实例化后加载下拉菜单的值*/
    //     this.getClasses();
    // },

    methods:{
        /*添加按钮事件*/
         add:function(){

             axios.post("../../addCompany",{
                 /*后台传参数*/
                 companyName:this.companyName,
                 companyLoginName:this.companyLoginName,
                 companyLoginPwd: this.companyLoginPwd,
                 companyAddress:this.companyAddress,
                 contact:this.cpmpanyLinkMan,
                 contactPhone:this.companyPhone
             }).then(function(result){
            // console.log(result.body+"***");
                 if(result.data==1){
                     this.$alert('添加数据成功',{
                         title:"消息提示",
                         confirmButtonText: '确定',
                         type:'success',
                         center: true
                     });
                     window.location.href="showAllCompany.html";
                 }else{
                     this.$alert('添加失败', {
                         title:"消息提示",
                         confirmButtonText: '确定',
                         type:'error',
                         center: true
                     });
                 }
                 }.bind(this));
         },
        /*取消按钮事件*/
        cancle:function(){
             window.history.go(-1);
        },

    }

});
