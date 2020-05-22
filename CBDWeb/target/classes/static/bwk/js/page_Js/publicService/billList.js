
//使用post发送ajax时需要设置
Vue.http.options.emulateJSON = true;

const app = new Vue({
    el: "#app",
    data: {
        totalData: [],
        billData: [],
        pageSize: 3,
        total: 0,
        currentPage: 1
    },
    //在vue被实例化之后
    created: function () {
        //调用getdatas()方法
        this.getDatas(this.currentPage, this.pageSize);
    },
    methods: {
        /*动态查找账单按钮*/
        findBill: function (startDate, endDate) {
            window.location.href = ".BillList.html?startDate=" + startDate + "&endDate=" + endDate;
        },
        /*改变当前页数*/
        currentChange: function (curNum) {
            this.getDatas(curNum, this.pageSize);
        },
        /*改变每页显示条数*/
        sizeChange: function (pSize) {
            this.getDatas(this.currentPage, pSize);
        },
        /*查询数据*/
        getDatas: function (currentPage, pageSize) {
            //发送ajax
            this.$http.post("../findBillList", {
                startDate: this.startDate,
                endDate: this.endDate,
                currentPage: currentPage,
                pageSize: pageSize
            }).then(function (result) {
                console.log(result.body);
                //设置分页控件的值
                this.billData = result.body.list;
                this.pageSize = result.body.pageSize;
                this.currentPage = result.body.pageNum;
                this.total = result.body.total;
                console.log(this.total + "----total")

            });

            //测试对象包含对象的数据
            this.totalData = [
                {totalReceive: "2000", totalPaid: "2000", totalCount: "4"}
            ];

            this.billData = [
                {tradeDate: "2020-4-10", tradeTime: "13:20:14", receive: "1000", paid: "", tradeInfo: "工资到账"},
                {tradeDate: "2020-5-8", tradeTime: "22:14:50", receive: "", paid: "1000", tradeInfo: "游戏充值"},
                {tradeDate: "2020-5-9", tradeTime: "14:20:30", receive: "1000", paid: "", tradeInfo: "收取租金"},
                {tradeDate: "2020-5-10", tradeTime: "18:43:44", receive: "", paid: "1000", tradeInfo: "租用车位"}
            ];
        }
    }
});
