
const app = new Vue({

     el:"#app",
     data:{
          /**个人信息更新*/
          showPersonalUpdate:false,
          /**企业信息更新*/
          showCompanyUpdate:false,
          /**展示后台信息*/
          showBack:false,
          /**展示前端信息*/
          showFront:false,
          /**超级管理员专属操作权限管理*/
          showSuperAdmin:false,
          /**个人用户管理*/
          showUserPower:false,
          /**车位管理*/
          showCar:false,
          /**投诉管理*/
          showComplaints:false,
          /**合约管理*/
          showContract:false,
          /**前台展示企业用户*/
          showFrontCompany:false,
          /**前台展示个人用户*/
          showFrontUser:false,

     },
     created:function () {
          this.getUserInfo();
     },

     methods:{
          getUserInfo:function(){
               let pw=this;
               axios.get("../../../../getLoginUserPower", {

               }).then(function (result) {


                    if(result.data.userType=="个人用户"){
                         pw.showPersonalUpdate=true;
                         pw.showFront=true;
                         pw.showFrontUser=true;
                    }
                    else if(result.data.userType=="企业用户"){
                         pw.showCompanyUpdate=true;
                         pw.showFront=true;
                         pw.showFrontCompany=true;
                    }
                    else if(result.data.userType=="超级管理员"){
                         pw.showBack=true;
                         pw.showUserPower=true;
                         pw.showCar=true;
                         pw.showSuperAdmin=true;
                         pw.showContract=true;
                         pw.showComplaints=true;
                    }
                    else if(result.data.userType=="管理员"){

                         let list=result.data.powerList

                         for (var i = 0; i <list.length ; i++) {

                              if( list[i].powerName=="用户管理"){
                                   pw.showBack=true;
                                   pw.showUserPower=true;
                              }
                              if(list[i].powerName=="车位管理"){
                                   pw.showBack=true;
                                   pw.showCar=true;
                              }
                              if(list[i].powerName=="合约管理"){
                                   pw.showBack=true;
                                   pw.showContract=true;
                              }
                              if(list[i].powerName=="投诉管理"){
                                   pw.showBack=true;
                                   pw.showComplaints=true;
                              }
                         }
                    }

               });
          },
          userExit:function(){
               axios.get("../../../../userExit", {

               }).then(function (result) {
                    if(result.data=="1"){
                         window.location.href="login.html";
                    }


               });
          },
     }






});
