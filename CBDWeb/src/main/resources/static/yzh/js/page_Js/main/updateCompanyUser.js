//使用post发送ajax时需要设置
Vue.http.options.emulateJSON = true;

const app = new Vue({
    el: "#app",
    data: {
        contact: "",
        contactPhone: "",
        companyLoginName: "",
        pwd: ""

    },
    created: function () {

        //查询企业用户详细信息
        this.getCompanyByUserId();

    },
    methods: {
        getCompanyByUserId: function () {

            axios.get("../../getCompanyByUserId").
            then(function (res) {
                this.contact = res.data.contact;

                this.contactPhone = res.data.contactPhone;

                this.companyLoginName = res.data.publicUser.loginName;

            }.bind(this))
        },

        /*修改按钮事件*/
        update: function () {
           axios.post("../../updCompany", {
                contact: this.contact,
                contactPhone: this.contactPhone,
                companyLoginName: this.companyLoginName,
                pwd: this.pwd
            }).then(function (result) {
                if (result.data == "1") {
                    this.$alert('修改数据成功', {
                        title: "消息提示",
                        confirmButtonText: '确定',
                        type: 'success',
                        center: true
                    });
                    window.location.href = "../../publicServiceMain.html";
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
            window.location.href = "../../publicServiceMain.html"
        },

    }

});
