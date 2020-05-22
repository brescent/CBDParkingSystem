
//使用post发送ajax时需要设置
Vue.http.options.emulateJSON = true;

const app = new Vue({
    el: "#app",
    data: {
        totalData: [],
        billData: [],
        pageSize: 3,
        total: 0,
        pageNum: 1,
        startDateStr: "",
        endDateStr:""
    },
    //在vue被实例化之后
    created: function () {
        this.findBill();
    },
    methods: {
        /*改变当前页数*/
        currentChange: function (curNum) {
            this.pageNum = curNum;
            this.findBill();
        },
        /*改变每页显示条数*/
        sizeChange: function (pSize) {
            this.pageSize = pSize;
            this.getDatas();
        },
        /*查询数据*/
        findBill: function () {
            //发送ajax
            axios.get("../../../../findBillList", {
                params:{
                    startDateStr:this.startDateStr,
                    endDateStr:this.endDateStr,
                    pageNum: this.pageNum,
                    pageSize: this.pageSize
                }
            }).then(function (result) {
                console.log(result.data);
                //设置分页控件的值
                this.billData = result.data.list;
                this.pageSize = result.data.pageSize;
                this.pageNum = result.data.pageNum;
                this.total = result.data.list.count;
                console.log(this.total + "----total")
            }.bind(this));

            //测试对象包含对象的数据
            // this.totalData = [
            //     {totalReceive: "2000", totalPaid: "2000", totalCount: "4"}
            // ];
            //
            // this.billData = [
            //     {tradeDate: "2020-4-10", tradeTime: "13:20:14", receive: "1000", paid: "", tradeInfo: "工资到账"},
            //     {tradeDate: "2020-5-8", tradeTime: "22:14:50", receive: "", paid: "1000", tradeInfo: "游戏充值"},
            //     {tradeDate: "2020-5-9", tradeTime: "14:20:30", receive: "1000", paid: "", tradeInfo: "收取租金"},
            //     {tradeDate: "2020-5-10", tradeTime: "18:43:44", receive: "", paid: "1000", tradeInfo: "租用车位"}
            // ];
        }
    }
});
