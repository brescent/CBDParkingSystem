
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
        this.getDatas(this.currentPage,this.pageSize);
    },
    methods:{
         /*查找按钮事件*/
         seach:function(){
             this.getDatas(this.currentPage,this.pageSize);
         },
        /*处理编辑按钮*/
        handleEdit:function(index,row){
            window.location.href="checkMsgInfo.html?Id="+row.id;
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
        // getDatas:function(currentPage,pageSize){
        //      //发送ajax
        //   this.$http.post("../showStudentInfo",{
        //          stuName:this.stuName,
        //          stuGender:this.stuGender,
        //          className:this.className,
        //          currentPage:currentPage,
        //          pageSize:pageSize
        //     }).then(function(result){
        //        console.log(result.body);
        //        //设置分页控件的值
        //          this.tableData=result.body.list;
        //          this.pageSize=result.body.pageSize;
        //          this.currentPage=result.body.pageNum;
        //          this.total =result.body.total;
        //          console.log(this.total+"----total")
        //
        //     });
        //
        //       /* axios.post("../showStudentInfo",{
        //            currentPage:this.currentPage,
        //            pageSize:this.pageSize
        //        }).then(function(result){
        //            console.log(result+"-->>>")
        //        });*/
        //
        //     //测试对象包含对象的数据
        //    /*this.tableData=[
        //        {id:1,age:18,name:"张三",gender:"男",classBean:{id:1,name:"1班",teacherBean:{id:1,name:"张老师"}}},
        //        {id:1,age:18,name:"张三",gender:"男",classBean:{id:2,name:"2班",teacherBean:{id:1,name:"张老师"}}},
        //        {id:1,age:18,name:"张三",gender:"男",classBean:{id:3,name:"3班",teacherBean:{id:1,name:"张老师"}}},
        //        {id:1,age:18,name:"张三",gender:"男",classBean:{id:4,name:"4班",teacherBean:{id:1,name:"张老师"}}}
        //        ];*/
        //
        // }
    }
});
