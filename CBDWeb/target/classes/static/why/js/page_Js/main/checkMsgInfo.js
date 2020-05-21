

//使用post发送ajax时需要设置
Vue.http.options.emulateJSON = true;

const  app = new Vue({
     el:"#app",
    data:{
        /*出租人*/
        renter: '小白',
        /*买家*/
        job: '魔法少男',
        /*车位地址*/
        carAddress: '太阳南',
        /*车位编号*/
        carNumber: '124',
        /*出售价格*/
        price: '244575',
        /*信誉度*/
        sound:'良好',
        /*图片路径*/
        url:'https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg',
        /*预览路径*/
        srcList:['https://fuss10.elemecdn.com/8/27/f01c15bb73e1ef3793e64e6b7bbccjpeg.jpeg',
            'https://fuss10.elemecdn.com/1/8e/aeffeb4de74e2fde4bd74fc7b4486jpeg.jpeg'],

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
         /*查询学生详细信息*/
         // getStudentInfo:function(stuId) {
         //     this.$http.post("../ShowStudentInfoDetailServlet",{
         //         stuId:stuId
         //     }).then(function(result){
         //
         //     });
         // },
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
