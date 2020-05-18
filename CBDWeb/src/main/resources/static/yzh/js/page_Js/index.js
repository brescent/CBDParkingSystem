
const app1 = new Vue({
      el:"#app1",
      data:{
          userName:"",
          pwd:"",
      },
      methods: {

          //登录事件
          login: function (userName,pwd) {
              if(this.userName==""&&this.pwd== ""){
                  // this.$alert('用户名和密码不能为空!', {
                  //     title: "消息提示",
                  //     confirmButtonText: '确定',
                  //     type: 'error',
                  //     center: true
                  // })
              }else{
                  axios.get("../../../login",{
                      param:{
                          userName:userName,
                          pwd:pwd,
                      }

                  }).then(function (result) {
                      if (result.body=="1") {
                          window.location.href = "main.html";
                      }   else {
                          // this.$alert('用户名或则密码错误!', {
                          //     title: "消息提示",
                          //     confirmButtonText: '确定',
                          //     type: 'error',
                          //     center: true
                          // });

                      }
                  })



              }
              //console.log(this.username+"---"+this.pwd);

          },
          //取消事件
          cancle: function () {

          },
      }


});
