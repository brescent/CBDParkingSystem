

const  app = new Vue({
    el:"#app",

    // created:function(){
    //     /*当vue实例化后加载下拉菜单的值*/
    //     this.getClasses();
    // },
    data:{
         username:""
    },


    created: function () {
        this.getDatas();
    },


    methods:{
        getDatas:function(){
            axios.get("../../../../getLoginUserName", {

            }).then(function (result) {

                this.username= result.data;

            }.bind(this));
        },
        /*取消按钮事件*/
        news:function(){
            window.location.href="../../bwk/page/ShowMessageList.html";
        },

    }

});
