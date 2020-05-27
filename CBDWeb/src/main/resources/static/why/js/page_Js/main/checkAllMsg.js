
//使用post发送ajax时需要设置
Vue.http.options.emulateJSON = true;

const app = new Vue({
     el:"#app",
     data:{
         /*出租人*/
         renter:"",
         /*车位地址*/
         carAddress:"",
         /*车位编号*/
         carNumber:"",
         /*出租价格*/
         price:"",
         /*审核状态*/
         checkType:'',
         tableData:[{
             /*出租人*/
             renter:"小白",
             /*车位地址*/
             carAddress:"月亮",
             /*车位编号*/
             carNumber:"158",
             /*出租价格*/
             price:"18",
             /*审核状态*/
             checkType:'已审核',
         },{ /*出租人*/
             renter:"小七",
             /*车位地址*/
             carAddress:"太阳",
             /*车位编号*/
             carNumber:"158",
             /*出租价格*/
             price:"984",
             /*审核状态*/
             checkType:'已审核',}],
         pageSize:3,
         total:0,
         currentPage:1
    },
    //在vue被实例化之后
    created:function(){
         //调用getdatas()方法
        this.getDatas();
    },
    methods:{
         /*查找按钮事件*/
         seach:function(){
             this.getDatas();
         },
        /*处理编辑按钮*/
        handleEdit:function(index,row){
            window.location.href="checkMsgInfo.html?id="+row.pk_id;
         },
        /*查询数据*/
        getDatas:function(){
               axios.get("../../getAllMsg").
               then(function(result){
                   this.tableData = result.data
               }.bind(this));



        }
    }
});
