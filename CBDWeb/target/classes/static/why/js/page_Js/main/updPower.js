//使用post发送ajax时需要设置
Vue.http.options.emulateJSON = true;

Vue.use({
    install(Vue) {
        Object.defineProperty(Vue.prototype, "$qs", {
            writable: false,
            value: window.Qs
        });
    }
});

const app = new Vue(

    {
    el: "#app",

    data: {

        adminId: "",
        /*工号*/
        jobNum: "",
        /*姓名*/
        realName: "",
        /*电话*/
        phone: "",
        //拥有权限
        oldPower: [1, 2, 3, 4],
        /**权限集合*/
        powerList: [],
    },

    created: function () {
        /*获取参数adminId*/
        let requestObj = GetRequest();
        this.adminId = requestObj['adminId'];
        //查询管理员详细信息,展示详细信息并加载复选框的值
        this.getAdminByid(this.adminId);
    },
    methods: {

        /*查询管理员详细信息*/
        getAdminByid: function (adminId) {
            axios.get("../../getAdminById", {
                params: {
                    adminId: adminId
                }
            }).then(function (result) {
                this.adminId = result.data.id;
                this.jobNum = result.data.jobNum;
                this.realName = result.data.realName;
                this.phone = result.data.phone;
                this.powerList = result.data.powerList;

            }.bind(this));
        },
        /*修改按钮事件*/
        update: function () {

            axios.post("../../updAdmin",
                this.$qs.stringify(
                    {powerList: this.powerList,
                    adminId:this.adminId},
                    { indices: false })).
            then(function (result) {
                if (result.data == "1") {
                    this.$alert('修改数据成功', {
                        title: "消息提示",
                        confirmButtonText: '确定',
                        type: 'success',
                        center: true
                    });
                    window.location.href = "showAllAdmin.html";
                } else {
                    this.$alert('修改数据失败', {
                        title: "消息提示",
                        confirmButtonText: '确定',
                        type: 'error',
                        center: true
                    });
                }
            }.bind(this));
        },
        /*取消按钮事件*/
        cancle: function () {
            window.history.go(-1);
        },
    }
});
