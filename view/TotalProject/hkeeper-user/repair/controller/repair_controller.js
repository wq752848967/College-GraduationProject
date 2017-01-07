
angular.module('hkeep_user').controller('SubmitRepairController',['RepairService',function(RepairService){
     var self = this;
     self.userId =  "USERid";
     self.level = 1;
     self.title;
     self.addr;
     self.desc;
     self.rpId;
     self.rpName;
     //get param from url
     var url=decodeURI(location.href);
     var temp1 =  url.split("?")[1];
     var temp2Arr = temp1.split("&");
     self.rpId =  temp2Arr[0].split("=")[1];
     self.rpName  = temp2Arr[1].split("=")[1];



     self.submitRepair =  function()
     {
           //check params

           //user service to submit Repair
           var promiseResult = RepairService.submit(self.title,self.addr,self.desc,self.userId,self.level,self.rpId,self.rpName);
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


app.controller("RepairPartController",["RepairService","$window",function(RepairService,$window){
  var self = this;
  //define data
  self.partList = [];
  var curPartClass="";
  var curPartId = "";
  var curPartName = "";
  // init data
  getAllRepairParts();

  //define out   interface
  self.selectPart = function(rpId,index){
    if(curPartClass.length>0){
        $("."+curPartClass+" span").css("background-color","white");
    }

    var className = "part-li-"+rpId+"-"+index;
    curPartClass = className;
    $("."+className+" span").css("background-color","#0c9");
    curPartId = rpId;
    curPartName = $("."+className+" .li-partName").text();
    console.log(curPartName);
  };
  self.submitPart = function(){
    //curPartId+" "+curPartName
    RepairService.setrpId(curPartId);
    RepairService.setPartName(curPartName);

    $window.location.href="repair.html?rpId="+curPartId+"&rpName="+curPartName;
  }

  //define inter function
  function getAllRepairParts(){
    var promise = RepairService.getAllRepairParts();
    promise.success(function(data,status,config,headers){
      console.log("success RepairService.getAllRepairParts");
      console.log(data.data);
      self.partList = data.data;
    });
    promise.error(function(data,status,config,headers){
      console.log("error RepairService.getAllRepairParts");
    });
  }

}]);
