
//使用post发送ajax时需要设置
Vue.http.options.emulateJSON = true;

const  app = new Vue({
    el:"#app",
    data:{
        /*姓名输入框*/
        userName:"",
        /*密码输入框*/
        pwd:"",
        /*密码确认框*/
        pwd2:"",
        /*用户真实姓名框*/
        userRealName:"",
        /*职业描述输入框*/
        jobInfo:"",
        /*身份证号码输入框*/
        IDCardNum:"",
        /*邮件输入框*/
        email:"",
        /*家庭住址输入框*/
        homeAddress:"",
        /*电话输入框*/
        phone:"",
        /*验证码输入框*/
        checkCode:"",

    },
    // created:function(){
    //     /*当vue实例化后加载下拉菜单的值*/
    //     this.getClasses();
    // },

    methods:{
        /*添加按钮事件*/
         add:function(){

            // console.log(+this.pwd+"---"+this.pwd2);
            //前后输入密码进行验证，一致再执行添加方法，不一致弹出消息提示
             if(this.pwd==this.pwd2){
                 window.location.href="main.html";
                 this.$http.post("../AddUser",{
                     /*后台传参数*/
                     userName:this.userName,
                     pwd:this.pwd,
                     jobInfo:this.jobInfo,
                     email: this.email


                 }).then(function(result){
                     // console.log(result.body+"***");
                     if(result.body==1){
                         this.$alert('添加数据成功',{
                             title:"消息提示",
                             confirmButtonText: '确定',
                             type:'success',
                             center: true
                         });
                         window.location.href="studentList.html";
                     }else{
                         this.$alert('添加失败', {
                             title:"消息提示",
                             confirmButtonText: '确定',
                             type:'error',
                             center: true
                         });
                     }
                 });
             }else{

                 this.$alert('前后密码不一致', {
                     title:"消息提示",
                     confirmButtonText: '确定',
                     type:'error',
                     center: true
                 });

              }


         },
        /*取消按钮事件*/
        cancle:function(){
             window.history.go(-1);
        },

    }

});
