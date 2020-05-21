
//使用post发送ajax时需要设置
Vue.http.options.emulateJSON = true;

const  app = new Vue({
    el:"#app",
    data:{
        /*管理员工号*/
        jobNum:"",
        /*管理员姓名*/
        realName:"",
        /*管理员密码*/
        pwd:"",
        /*联系电话*/
        phone:"",
        /*权限集合*/
        powerList:[],
    },
    methods:{
        /*添加按钮事件*/
         add:function(){
             axios.post("../../addAdmin",{
                 /*后台传参数*/
                 jobNum:this.jobNum,
                 realName:this.realName,
                 pwd:this.pwd,
                 phone: this.phone,
                 powerList:this.powerList
             }).then(function(result){
            // console.log(result.body+"***");
                 if(result.data=="1"){
                     this.$alert('添加数据成功',{
                         title:"消息提示",
                         confirmButtonText: '确定',
                         type:'success',
                         center: true
                     });
                     window.location.href="showAllAdmin.html";
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
