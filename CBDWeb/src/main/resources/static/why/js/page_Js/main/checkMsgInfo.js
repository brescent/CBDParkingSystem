//使用post发送ajax时需要设置
Vue.http.options.emulateJSON = true;

const app = new Vue({
    el: "#app",
    data: {
        /*出租信息的id*/
        id: '',
        /*出租人*/
        renter: '小白',
        /*职业*/
        job: '魔法少男',
        /*车位地址*/
        carAddress: '太阳南',
        /*车位编号*/
        carNumber: '124',
        /*出售价格*/
        price: '244575',
        /*信誉度*/
        sound: '良好',
        /*图片路径*/
        url: 'https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg',
        /*预览路径*/
        srcList: ['https://fuss10.elemecdn.com/8/27/f01c15bb73e1ef3793e64e6b7bbccjpeg.jpeg',
            'https://fuss10.elemecdn.com/1/8e/aeffeb4de74e2fde4bd74fc7b4486jpeg.jpeg'],

    },
    created: function (options) {
        /*获取招租信息的Id*/
        let requestObj = GetRequest();
        this.id = requestObj['id'];
        //查询学生详细信息
        this.getMsgById(this.id);

    },
    methods: {
        /*查询招租详细信息*/
        getMsgById: function (id) {
            axios.get("../../getMsgById", {
                params: {
                    id: id
                }
            }).then(function (result) {


                /*出租人*/
                this.renter = result.data.userName,
                    /*车位地址*/
                    this.carAddress = result.data.stallAddress,
                    /*车位编号*/
                    this.carNumber = result.data.stallId,
                    /*出售价格*/
                    this.price = result.data.dealPrice,
                    /*信誉度*/
                    this.sound = result.data.complaintNum,
                    /*出租人id*/
                    this.userId = result.data.userId;

                /*出租人职业*/
                this.job = result.data.userProfession
                /*出租信息id*/
                this.id = result.data.pk_id
            }.bind(this));
        },
        /*修改按钮事件*/
        update: function () {
            this.$http.get("../../udpMsgType", {
                params: {
                    id: this.id,
                    state: 1,
                    userId: this.userId
                }
            }).then(function (result) {
                if (result.body == "1") {
                    this.$alert('审核完成...', {
                        title: "消息提示",
                        confirmButtonText: '确定',
                        type: 'success',
                        center: true
                    });
                    window.location.href = "checkAllMsg.html";
                } else {
                    this.$alert('审核失败,请重试...', {
                        title: "消息提示",
                        confirmButtonText: '确定',
                        type: 'error',
                        center: true
                    });
                }
            });
        },
        /*取消按钮事件*/
        cancle: function () {
            this.$http.get("../../udpMsgType", {
                params: {
                    id: this.id,
                    state: 1,
                    userId: this.userId
                }
            }).then(function (result) {
                if (result.data == "1") {
                    this.$alert('该申请已拒绝', {
                        title: "消息提示",
                        confirmButtonText: '确定',
                        type: 'success',
                        center: true
                    });
                    window.location.href = "checkAllMsg.html";
                } else {
                    this.$alert('系统错误', {
                        title: "消息提示",
                        confirmButtonText: '确定',
                        type: 'error',
                        center: true
                    });
                }
            });
        },
    }

});
