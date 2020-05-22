
//使用post发送ajax时需要设置
Vue.http.options.emulateJSON = true;

const app = new Vue({
    el:"#app",
    data:{
        messageId:"",
        messageInfo:"",
        messageType:"",
        receiveDate:"",
        tableData:[],
        pageSize:3,
        total:0,
        currentPage:1
    },
    //在vue被实例化之后
    created:function(){
        //调用getdatas()方法
        this.getDatas(this.currentPage,this.pageSize);
    },
    methods:{
        /*查看详情按钮*/
        lookInfo:function(index,row){
            window.location.href="shoMessageInfo.html?messageId="+row.id;
        },
        /*删除消息按钮*/
        deleteMessage:function(index,row){
            // row 对象其实就是一个消息对象
            //console.log(index+"----"+row.id+"==="+row.name+"----");
            this.$confirm('此操作将永久删除该条数据, 是否继续?', '提示', {
                confirmButtonText: '确定',
                cancelButtonText: '取消',
                type: 'warning'
            }).then(()=>{
                this.$http.post("../deleteMessage",{
                    stuId:row.id
                }).then(function(result){
                    //console.log(result+" === "+result.body);
                    if(result.body==1){
                        this.$message({
                            type: 'success',
                            message: '删除成功!'
                        });

                        // this.getDatas(this.currentPage,this.pageSize);
                        //直接操作表格的数据，删除表格中的数据，不需要在发ajax查询
                        this.tableData.splice(index,1);
                    }else{
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
        currentChange:function(curNum){
            this.getDatas(curNum,this.pageSize);
        },
        /*改变每页显示条数*/
        sizeChange:function(pSize){
            this.getDatas(this.currentPage,pSize);
        },
        /*查询数据*/
        getDatas:function(currentPage,pageSize){
            //发送ajax
            this.$http.post("../showStudentInfo",{
                stuName:this.stuName,
                stuGender:this.stuGender,
                className:this.className,
                currentPage:currentPage,
                pageSize:pageSize
            }).then(function(result){
                console.log(result.body);
                //设置分页控件的值
                this.tableData=result.body.list;
                this.pageSize=result.body.pageSize;
                this.currentPage=result.body.pageNum;
                this.total =result.body.total;
                console.log(this.total+"----total")

            });

            //测试对象包含对象的数据
            this.tableData=[
                {logDate:"2020-5-9 16:02:01",logInfo:"张三登录"},
                {logDate:"2020-5-9 16:02:01",logInfo:"李四登录"},
                {logDate:"2020-5-9 16:02:01",logInfo:"王五登录"},
                {logDate:"2020-5-9 16:02:01",logInfo:"赵六登录"},
                {logDate:"2020-5-9 16:02:01",logInfo:"钱七登录"},
                {logDate:"2020-5-9 16:02:01",logInfo:"孙八登录"},
                {logDate:"2020-5-9 16:02:01",logInfo:"李九登录"}
            ];

        }
    }
});
