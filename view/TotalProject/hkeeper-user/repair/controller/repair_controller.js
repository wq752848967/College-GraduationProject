
angular.module('hkeep_user').controller('SubmitRepairController',['RepairService',function(RepairService){
     var self = this;
     self.userId =  "USERid";
     self.level = 1;
     self.title;
     self.addr;
     self.desc;
     self.submitRepair =  function()
     {
           //check params

           //user service to submit Repair
           var promiseResult = RepairService.submit(self.title,self.addr,self.desc,self.userId,self.level);
           promiseResult.success(function(data,status,config,headers){
              console.log("submit ok"+data.message);
           });
           promiseResult.error(function(data,status,config,headers){
              console.log("submit error"+data.message);
           });
     }
}]);
//   work  订单历史
app.controller("RepairOrderListController",["RepairService",function(RepairService){
  var self = this;
  self.orders = [];



  //调用方法进行初始化
  initData();




  //声明内部方法
  function initData(){
    var promise = RepairService.getOrderHistory();
    promise.success(function(data,status,config,headers){
      console.log("success RepairService.getOrderHistory");
      console.log(data.data);
      self.orders = data.data;
    });
    promise.error(function(data,status,config,headers){
      console.log("error RepairService.getOrderHistory");
    });
  };



}])
