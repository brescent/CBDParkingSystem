
//使用post发送ajax时需要设置
Vue.http.options.emulateJSON = true;

const app = new Vue({
    el:"#app",
    data:{
        messageId:0,
        messageInfo:"",
        messageType:"",
        receiveDate:"",
        tableData:[],
        pageSize:3,
        total:0,
        pageNum:1,
        messageIdDiv:false
    },
    //在vue被实例化之后
    created:function(){
        //调用getdatas()方法
        this.getDatas(this.pageNum,this.pageSize);
    },
    methods:{
        /*标记已读按钮*/
        readMessage:function(index,row){
            var vm = this;
            axios.get("../../../../readMessage",{
                params:{
                    //tableData:this.tableData,
                    messageId:row.messageId
                }
            }).then(function (result) {
                vm.getDatas(this.pageNum,this.pageSize);
            });
        },
        /*删除消息按钮*/
        deleteMessage:function(index,row){
            var vm = this;
            // row 对象其实就是一个消息对象
            //console.log(index+"----"+row.id+"==="+row.name+"----");
                axios.get("../../../../deleteMessage",{
                    params:{
                        messageId:row.messageId
                    }
                }).then(function(result){
                    //console.log(result+" === "+result.body);
                        vm.getDatas(this.pageNum,this.pageSize);
        });
        },
        /*改变当前页数*/
        currentChange:function(curNum){
            this.getDatas(curNum,this.pageSize);
        },
        /*改变每页显示条数*/
        sizeChange:function(pSize){
            this.getDatas(this.pageNum,pSize);
        },
        /*查询数据*/
        getDatas:function(pageNum,pageSize){
            //发送ajax
            this.$http.get("../../../../showMessageList",{
                params:{
                    pageNum:pageNum,
                    pageSize:pageSize
                }
            }).then(function(result){
                console.log(result.data);
                //设置分页控件的值
                this.tableData=result.data.list;
                this.pageSize=result.data.pageSize;
                this.pageNum=result.data.pageNum;
                this.total =result.data.total;
                console.log(this.total+"----total")

            });

            //测试对象包含对象的数据
            // this.tableData=[
            //             //     {messageId:1,messageInfo:"张三",messageTypeStr:"系统消息",messageStatusStr:"未读",receiveDate:"2020-5-9 16:02:01"},
            //             //     {messageId:2,messageInfo:"张三2",messageTypeStr:"系统消息",messageStatusStr:"未读",receiveDate:"2020-5-9 16:02:01"},
            //             //     {messageId:3,messageInfo:"张三3",messageTypeStr:"系统消息",messageStatusStr:"未读",receiveDate:"2020-5-9 16:02:01"},
            //             //     {messageId:4,messageInfo:"张三4",messageTypeStr:"系统消息",messageStatusStr:"未读",receiveDate:"2020-5-9 16:02:01"},
            //             //     {messageId:5,messageInfo:"张三5",messageTypeStr:"系统消息",messageStatusStr:"未读",receiveDate:"2020-5-9 16:02:01"},
            //             //     {messageId:6,messageInfo:"张三6",messageTypeStr:"系统消息",messageStatusStr:"未读",receiveDate:"2020-5-9 16:02:01"},
            //             //     {messageId:7,messageInfo:"张三7",messageTypeStr:"系统消息",messageStatusStr:"未读",receiveDate:"2020-5-9 16:02:01"}
            //             // ];

        }
    }
});
