//使用post发送ajax时需要设置
Vue.http.options.emulateJSON = true;

const app = new Vue({
    el: "#app",
    data: {
        /*买家id*/
        customerId:'',
        /*买家id*/
        userId:'',
        /*合同id*/
        partId:'',
        /*卖家*/
        seller: '小白',
        /*买家*/
        buyer: '小红',
        /*车位地址*/
        carAddress: '太阳南',
        /*车位编号*/
        carNumber: '124',
        /*出售价格*/
        price: '244575',
        /*图片路径*/
        url: 'https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg',
        /*预览路径*/
        srcList: ['https://fuss10.elemecdn.com/8/27/f01c15bb73e1ef3793e64e6b7bbccjpeg.jpeg',
            'https://fuss10.elemecdn.com/1/8e/aeffeb4de74e2fde4bd74fc7b4486jpeg.jpeg'],

    },
    created: function (options) {
        /*获取参数partId*/
        let requestObj = GetRequest();
        this.partId = requestObj['partId'];
        //查询学生详细信息
       this. getPartById(this.partId);

    },
    methods: {
        /*查询合同的详细信息*/
        getPartById: function (partId) {
            axios.get("../../getPartById", {
                params: {
                    partId: partId
                },
            }).then(function (result) {

                /*卖家*/
                seller: result.data[0].userName;
                    /*买家*/
                    this.buyer =result.data[0].customerName;
                    /*车位地址*/
                    this.carAddress = result.data[0].stallAddress;
                    /*车位编号*/
                    this.carNumber = result.data[0].stallId;
                    /*出售价格*/
                    this.price = result.data[0].dealPrice;
                    this.customerId = result.data[0].customerId;
                this.userId = result.data[0].userId;



            }.bind(this));
        },
        /*修改按钮事件*/
        update: function () {
            this.$http.get("../../updCheckType",{
                params: {
                    partId:this.partId,
                    state:1,
                    customerId:this.customerId,
                    userId:this.userId
                }
            }).then(function (result) {
                if (result.data == "1") {
                    this.$alert('该合同已通过审核', {
                        title: "消息提示",
                        confirmButtonText: '确定',
                        type: 'success',
                        center: true
                    });
                    window.location.href = "showAllpart.html";
                } else {
                    this.$alert('修改数据失败', {
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
            this.$http.post("../../updCheckType", {
                params:{
                    partId:this.partId,
                    state:2,
                    customerId:this.customerId,
                    userId:this.userId

                }
            }).then(function (result) {
                if (result.data == "1") {
                    this.$alert('已拒绝该合同!', {
                        title: "消息提示",
                        confirmButtonText: '确定',
                        type: 'success',
                        center: true
                    });
                    window.location.href = "showAllpart.html";
                } else {
                    this.$alert('请求失败!请重试...', {
                        title: "消息提示",
                        confirmButtonText: '确定',
                        type: 'error',
                        center: true
                    });
                }
            });
        },
        /*获取所有班级数据*/
        // getClasses:function(){
        //     this.$http.post("../GetAllClassesServlet")
        //         .then(function(result){
        //             this.classesData=result.body;
        //         });
        // }
    }

});
