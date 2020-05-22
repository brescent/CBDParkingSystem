//使用post发送ajax时需要设置
// Vue.http.options.emulateJSON = true;

const app = new Vue({
    el: "#app",
    data: {
        address:'',
        no:'',
        state:0,
        tableData:[],
        pageSize:3,
        total:0,
        currentPage:1,
    },
    //在vue被实例化之后
    created: function () {
        //调用getdatas()方法
        this.getDatas(this.currentPage, this.pageSize);
    },
    methods: {
        /*查找按钮事件*/
        seach: function () {
            this.getDatas(this.currentPage, this.pageSize);
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

            axios.post("../../stall/findByItems",{
                    address:this.address,
                    no:this.no,
                    currentPage:currentPage,
                    pageSize:pageSize,
            }
            ).then(function (result) {
                console.log(result + "-->>>")
                this.tableData = result.data.dataList;
                this.pageSize = result.data.pageSize;
                this.currentPage = result.data.currentPage;
                this.total = result.data.count;
            }.bind(this));

        }, add(){

                        window.location.href="addStall.html";

                   },

    }
});
