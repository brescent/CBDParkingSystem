
const app1 = new Vue({
      el:"#app1",
      data:{
          userName:"",
          pwd:"",
      },
      methods: {
          //登录事件
          login: function () {
              let vm=this;
                if(this.username==""||this.pwd==""){
                   // alert("用户名，密码不能为空")
                    vm.$alert('用户名或则密码不能为空!', {
                        title: "消息提示",
                        confirmButtonText: '确定',
                        type: 'error',
                        center: true
                    })
                }else {
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
                            this.$message('用户名或则密码错误!', {
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
