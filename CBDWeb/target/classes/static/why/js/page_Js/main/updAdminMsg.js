

//使用post发送ajax时需要设置
Vue.http.options.emulateJSON = true;

const  app = new Vue({
     el:"#app",
    data:{

         adminId:"",
        /*工号*/
        jobNumber:"001",
        /*姓名*/
        name:"小樱",
        /*密码*/
        pwd:"",
        /*电话*/
        phone:"15784658474",

    },
    created:function(options){
       //查询管理员详细信息
         this. getAdminByid();
    },
    methods:{
         /*查询用户详细信息*/
         getAdminByid:function() {
             axios.get("../../getAdminByUserId").then(function(result){
              this. jobNumber = result.data.jobNum;
              this. name = result.data.realName;
              this.phone = result.data.phone;
              this.adminId = result.data.id;
             }.bind(this));
         },
        /*修改按钮事件*/
        update:function(){
            axios.post("../../updAdminMsg",{
                id:this.adminId,
                /*密码*/
                pwd:this.pwd,
                /*电话*/
                phone:this.phone,
                /*工号*/
                jobNum:this.jobNumber,
                /*姓名*/
                realName:this.name,
            }).then(function(result){
                if(result.data==1){
                    this.$alert('修改数据成功',{
                        title:"消息提示",
                        confirmButtonText: '确定',
                        type:'success',
                        center: true
                    });
                    window.location.href="publicServiceMain.html";
                }else{
                    this.$alert('修改数据失败', {
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
