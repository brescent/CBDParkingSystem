

//使用post发送ajax时需要设置
Vue.http.options.emulateJSON = true;

const  app = new Vue({
     el:"#app",
    data:{
        contact:"",
        contactPhone:"",
        companyLoginName:"",
        pwd:""

    },
    // created:function(options){
    //      /*获取参数stuId*/
    //     let requestObj = GetRequest();
    //      this.stuId=requestObj['stuId'];
    //    //查询学生详细信息
    //      this. getStudentInfo(this.stuId);
    //     /*当vue实例化后加载下拉菜单的值*/
    //     this.getClasses();
    // },
    methods:{
         // /*查询学生详细信息*/
         // getStudentInfo:function(stuId) {
         //     this.$http.post("../ShowStudentInfoDetailServlet",{
         //         stuId:stuId
         //     }).then(function(result){
         //         /*设置输入框的值*/
         //
         //     });
         // },
        /*修改按钮事件*/
        update:function(){
            this.$http.post("../UpdateStudentInfoServlet",{

            }).then(function(result){
                if(result.body==1){
                    this.$alert('修改数据成功',{
                        title:"消息提示",
                        confirmButtonText: '确定',
                        type:'success',
                        center: true
                    });
                    window.location.href="studentList.html";
                }else{
                    this.$alert('修改数据失败', {
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
            window.location.href="publicServiceMain.html"
        },
        // /*获取所有班级数据*/
        // getClasses:function(){
        //     this.$http.post("../GetAllClassesServlet")
        //         .then(function(result){
        //             this.classesData=result.body;
        //         });
        // }
    }

});
