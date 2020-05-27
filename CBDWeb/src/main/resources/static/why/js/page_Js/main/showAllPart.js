//使用post发送ajax时需要设置
Vue.http.options.emulateJSON = true;

const app = new Vue({
    el: "#app",
    data: {
        tableData: [{
            /*卖家*/
            seller: '小白',
            /*买家*/
            buyer: '小青',
            /*车位地址*/
            carAddress: '火星北',
            /*车位编号*/
            carNumber: '124',
            /*出售价格*/
            price: '244575',
            /*审核状态*/
            checkType: '已审核',
            /*签约状态*/
            signType: '已签约',
        }, {
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
            /*审核状态*/
            checkType: '已审核',
            /*签约状态*/
            signType: '未签约',
        }],
        pageSize: 3,
        total: 0,
        currentPage: 1
    },
    //在vue被实例化之后
    created: function () {
        //调用getdatas()方法
        this.getDatas();
    },
    methods: {
        handleEdit: function (index, row) {
            console.log(row);
             window.location.href = "partInfo.html?partId=" + row.pk_id;
        },
        /*查询数据*/
        getDatas: function () {

            axios.get("../../getWebAllPart").
            then(function (result) {

                this.tableData = result.data;
              console.log(this.tableData)

            }.bind(this));
        }
    }
});
