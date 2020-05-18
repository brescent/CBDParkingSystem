
const app1 = new Vue({
      el:"#app1",
      data:{
          username:"",
          pwd:"",
          checkCode:""
      },
      methods:{
            //登录事件
            login:function(){
                 //console.log(this.username+"---"+this.pwd);
                if(this.username="abc" && this.pwd=="123"){
                     window.location.href="main.html";
                }else{

                    this.$alert('用户名或则密码错误!', {
                        title:"消息提示",
                        confirmButtonText: '确定',
                        type:'error',
                        center: true
                    });
                    this.username=""
                    this.pwd="";
                }
            },
          //取消事件
          cancle:function(){
               this.username="";
               this.pwd="";
          }
      }
});
