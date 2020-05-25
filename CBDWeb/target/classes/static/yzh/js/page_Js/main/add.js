
//使用post发送ajax时需要设置
Vue.http.options.emulateJSON = true;

const  app = new Vue({

    el:"#app",
    data:{
        /*姓名输入框*/
        loginName:"",
        /*密码输入框*/
        pwd:"",
        /*密码确认框*/
        pwd2:"",
        /*用户真实姓名框*/
        realName:"",
        /*职业描述输入框*/
        jobInfo:"",
        /*身份证号码输入框*/
        cardNum:"",
        /*邮件输入框*/
        email:"",
        /*家庭住址输入框*/
        homeAddress:"",
        /*电话输入框*/
        phone:"",
        /*验证码输入框*/
        code:'',
        checkCode:'',
        inputCode:'',

    },
    // created:function(){
    //     /*当vue实例化后加载下拉菜单的值*/
    //     this.getClasses();
    // },
    created(){
        this.createdCode()
    },

    methods:{
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

        /*添加按钮事件*/
         add:function(){
             let vm=this;
             if(this.username==""||this.pwd==""){
                 // alert("用户名，密码不能为空")
                 vm.$alert('用户名或者密码不能为空!', {
                     title: "消息提示",
                     confirmButtonText: '确定',
                     type: 'error',
                     center: true
                 })
             }else if(this.pwd!=this.pwd2){
                 vm.$alert('前后输入的密码不一致!', {
                     title: "消息提示",
                     confirmButtonText: '确定',
                     type: 'error',
                     center: true
                 })
             }else if(this.checkCode!=this.inputCode){
                 vm.$alert('验证码错误，请重新输入(注意大小写)!', {
                     title: "消息提示",
                     confirmButtonText: '确定',
                     type: 'error',
                     center: true
                 })
             }
             else {
                 axios.post("../../../../addUser", {
                     /*后台传参数*/
                     loginName:this.loginName,
                     pwd:this.pwd,
                     jobInfo:this.jobInfo,
                     email: this.email,
                     homeAddress: this.homeAddress,
                     phone:this.phone,
                     realName: this.realName,
                     cardNum: this.cardNum

                 }).then(function(result){
                     console.log(result.body+"***");

                     if(result.data==1){
                         window.location.href="main.html";
                     }else{
                         console.log(this)
                         //alert("用户名已存在，请重新输入")
                         vm.$alert('用户名已存在，请重新输入', {
                             title: "消息提示",
                             confirmButtonText: '确定',
                             type: 'error',
                             center: true
                         })

                     }
                 });

             }


         },
        /*取消按钮事件*/
        cancle:function(){
             window.history.go(-1);
        },


    }

});
