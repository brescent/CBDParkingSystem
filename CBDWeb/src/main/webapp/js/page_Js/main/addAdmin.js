
//使用post发送ajax时需要设置
Vue.http.options.emulateJSON = true;

const  app = new Vue({
    el:"#app",
    data:{
        /*管理员工号*/
        jobNumber:"",
        /*管理员姓名*/
        name:"",
        /*管理员密码*/
        pwd:"",
        /*联系电话*/
        phone:"",
        /*权限集合*/
        powerList:[],
    },
    // created:function(){
    //     /*当vue实例化后加载下拉菜单的值*/
    //     this.getClasses();
    // },

    methods:{
        /*添加按钮事件*/
         add:function(){

             alert(this.powerList)
             this.$http.post("../AddStudentServlet",{
                 /*后台传参数*/
                 stuName:this.stuName,
                 stuAge:this.stuAge,
                 stuGender: this.stuGender,
                 classId:this.classId
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
         },
        /*取消按钮事件*/
        cancle:function(){
             window.history.go(-1);
        },
        /*获得所有班级数据*/
        // getClasses:function(){
        //      this.$http.post("../GetAllClassesServlet")
        //           .then(function(result){
        //          console.log(result.body+"---->>");
        //              this.classesData=result.body;
        //           });
        // }
    }

});
