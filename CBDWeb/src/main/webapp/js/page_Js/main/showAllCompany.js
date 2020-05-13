
//使用post发送ajax时需要设置
Vue.http.options.emulateJSON = true;

const app = new Vue({
     el:"#app",
     data:{
         companyName:"",
         companyAddress:"",
         companyLinkMan:"",
         companyPhone:"",
         tableData:[{
             companyName:"中国石油",
             companyAddress:"火星",
             companyLinkMan:"小白",
             companyPhone:"158451"
         },{companyName:"中国航天",
             companyAddress:"太阳",
             companyLinkMan:"小黑",
             companyPhone:"1254871"}],
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
            window.location.href="updAdminMsg.html?stuId="+row.id;
         },
        /*处理删除按钮*/
        handleDelete:function(index,row){
               // row 对象其实就是一个学生对象
             //console.log(index+"----"+row.id+"==="+row.name+"----");
            this.$confirm('此操作将永久删除该条数据, 是否继续?', '提示', {
                confirmButtonText: '确定',
                cancelButtonText: '取消',
                type: 'warning'
            }).then(()=>{
                  this.$http.post("../deleteStudentinfoServlet",{
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
