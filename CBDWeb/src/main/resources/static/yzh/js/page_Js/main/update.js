

//使用post发送ajax时需要设置
Vue.http.options.emulateJSON = true;

const  app = new Vue({
     el:"#app",

    data:{
         /*学生编号*/
        jobInfo:"",
        /*姓名输入框*/
        homeAddress:"",
        /*年龄输入框*/
        email:"",
        /*性别输入框*/
         phone:"",

        pwd:null,

    },
    created:function(){
         this.getDatas()
    },
    methods:{
        getDatas:function(){
            let pw=this.$set;
            axios.get("../../../../getUserInfo", {

            }).then(function (result) {
                this.jobInfo= result.data.jobInfo;
                this.homeAddress=result.data.homeAddress;
                this.email=result.data.email;
                this.phone=result.data.phone;
                //bind表示绑定，绑定到当前的vue对象
            }.bind(this))
        },
        /*修改按钮事件*/
        update:function(){
            let vm=this;
            axios.post("../../../../updateUser",{
               jobInfo:this.jobInfo,
               homeAddress:this.homeAddress,
               email:this.email,
               phone:this.phone,
               pwd:this.pwd,

           }).then(function(result){
                if(result.data=="1"){
                    vm.$alert('修改数据成功',{
                        title:"消息提示",
                        confirmButtonText: '确定',
                        type:'success',
                        center: true,
                    })
                    window.location.href="publicServiceMain.html";
                }else{
                    vm.$alert('修改数据失败', {
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
