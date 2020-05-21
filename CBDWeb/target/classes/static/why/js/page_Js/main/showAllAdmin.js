//使用post发送ajax时需要设置
Vue.http.options.emulateJSON = true;

const app = new Vue({
    el: "#app",
    data: {
        jobNum: "",
        realName: "",
        phone: "",
        // tableData: [{
        //     jobNumber: '1',
        //     name: '小白',
        //     phone: '1582541512'
        // }, {
        //     jobNumber: '2',
        //     name: '小黑',
        //     phone:'2541715415'
        // }],
        tableData: [],
        pageSize: 3,
        total: 0,
        pageNum: 1
    },
    //在vue被实例化之后
    created: function () {
        //调用getdatas()方法

        this.getDatas(this.pageNum, this.pageSize);
    },
    methods: {
        /*查找按钮事件*/
        seach: function () {
            this.getDatas(this.pageNum, this.pageSize);
        },
        /*处理编辑按钮*/
        handleEdit: function (index, row) {
            window.location.href = "updPower.html?adminId=" + row.id;
        },
        /*处理删除按钮*/
        handleDelete: function (index, row) {
            // row 对象其实就是一个管理员
            //console.log(index+"----"+row.id+"==="+row.name+"----");
            this.$confirm('此操作将永久删除该条数据, 是否继续?', '提示', {
                confirmButtonText: '确定',
                cancelButtonText: '取消',
                type: 'warning'
            }).then(() => {
                this.$http.get("../../delAdmin", {
                    params: {
                        adminId:row.id
                    }
                }).then(function (result) {
                    //console.log(result+" === "+result.body);
                    if (result.body == "1") {
                        this.$message({
                            type: 'success',
                            message: '删除成功!'
                        });
                        //直接操作表格的数据，删除表格中的数据，不需要在发ajax查询
                        this.getDatas(this.pageNum, this.pageSize);
                        //this.tableData.splice(index, 1);
                    } else {
                        this.$message({
                            type: 'error',
                            message: '删除失败!'
                        });
                    }
                });
            }).catch(() => {
                this.$message({
                    type: 'info',
                    message: '已取消删除'
                });
            })
        },
        /*改变当前页数*/
        currentChange: function (curNum) {
            this.getDatas(curNum, this.pageSize);
        },
        /*改变每页显示条数*/
        sizeChange: function (pSize) {
            this.getDatas(this.pageNum, pSize);
        },
        /*查询数据*/
        getDatas: function (pageNum, pageSize) {

            axios.get("../../getAllAdmin", {
                params: {
                    pageNum: pageNum,
                    pageSize: pageSize
                }
            }).then(function (result) {
                console.log(result + "-->>>")
                this.tableData = result.data.list;
                this.pageSize = result.data.pageSize;
                this.currentPage = result.data.pageNum;
                this.total = result.data.count;
            }.bind(this));

        }
    }
});
