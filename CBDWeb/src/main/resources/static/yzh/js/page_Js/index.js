
const app1 = new Vue({
      el:"#app1",
      data:{
          userName:"",
          pwd:"",
          /*验证码输入框*/
          code:'',
          checkCode:'',
          inputCode:'',
      },
    created(){
        this.createdCode()
    },
      methods: {
          createdCode(){
              // 先清空验证码输入
              this.code = ""
              this.checkCode = ""
              this.inputCode = ""
              // 验证码长度
              const codeLength = 4
              // 随机数
              const random = new Array(0,1,2,3,4,5,6,7,8,9,'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z')
              for(let i = 0;i < codeLength;i++){
                  // 取得随机数的索引(0~35)
                  let index = Math.floor(Math.random() * 36)
                  // 根据索引取得随机数加到code上
                  this.code += random[index]
              }
              // 把code值赋给验证码
              this.checkCode = this.code
          },
          //登录事件
          login: function () {
              let vm=this;

                if(this.username==""||this.pwd==""){
                   // alert("用户名，密码不能为空")
                    vm.$alert('用户名或者密码不能为空!', {
                        title: "消息提示",
                        confirmButtonText: '确定',
                        type: 'error',
                        center: true
                    })
                }else if(this.checkCode!=this.inputCode){
                    vm.$alert('验证码错误，请重新输入（注意大小写）!', {
                        title: "消息提示",
                        confirmButtonText: '确定',
                        type: 'error',
                        center: true
                    })
                }

                else {
                    axios.get("../../../login", {
                        params: {
                            userName: this.userName,
                            pwd: this.pwd,
                        }
                    }).then(function (result) {

                        if (result.data == "1") {
                             window.location.href = "main.html";
                        } else {
                           // alert("用户或者密码错误，请重新输入！！！")
                            vm.$alert('用户名或者密码错误!', {
                                title: "消息提示",
                                confirmButtonText: '确定',
                                type: 'error',
                                center: true
                            });
                        }
                    })

                }

              }
              //console.log(this.username+"---"+this.pwd);

          },




});
