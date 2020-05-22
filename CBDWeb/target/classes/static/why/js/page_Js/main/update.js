

//使用post发送ajax时需要设置
Vue.http.options.emulateJSON = true;

const  app = new Vue({
     el:"#app",
    data:{
         /*学生编号*/
         stuId:0,
        /*姓名输入框*/
        stuName:"",
        /*年龄输入框*/
        stuAge:"",
        /*性别输入框*/
        stuGender:"",
        /*保存返回后的json数据*/
        classesData:"",
        /*下拉菜单选中的value*/
        classId:"",
    },
    created:function(options){
         /*获取参数stuId*/
        let requestObj = GetRequest();
         this.stuId=requestObj['stuId'];
       //查询学生详细信息
         this. getStudentInfo(this.stuId);
        /*当vue实例化后加载下拉菜单的值*/
        this.getClasses();
    },
    methods:{
         /*查询学生详细信息*/
         getStudentInfo:function(stuId) {
             this.$http.post("../ShowStudentInfoDetailServlet",{
                 stuId:stuId
             }).then(function(result){
                 /*设置输入框的值*/
                  this.stuName=result.body.name;
                  this.stuAge=result.body.age;
                  this.stuGender=result.body.gender;
                  this.classId=result.body.classBean.id;
             });
         },
        /*修改按钮事件*/
        update:function(){
            this.$http.post("../UpdateStudentInfoServlet",{
                stuId :this.stuId,
                stuName:this.stuName,
                stuAge:this.stuAge,
                stuGender: this.stuGender,
                classId:this.classId
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
            window.history.go(-1);
        },
        /*获取所有班级数据*/
        // getClasses:function(){
        //     this.$http.post("../GetAllClassesServlet")
        //         .then(function(result){
        //             this.classesData=result.body;
        //         });
        // }
    }

});
