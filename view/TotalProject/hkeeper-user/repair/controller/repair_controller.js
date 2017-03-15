
angular.module('hkeep_user').controller('SubmitRepairController',['RepairService',"$window",function(RepairService,$window){
     var self = this;
     self.userId =  "USERid";
     self.level = 1;
     self.title;
     self.addr;
     self.desc;
     self.rpId;
     self.rpName;
     self.rpKind;
     //get param from url
     var url=decodeURI(location.href);
     var temp1 =  url.split("?")[1];
     var temp2Arr = temp1.split("&");
     self.rpId =  temp2Arr[0].split("=")[1];
     self.rpName  = temp2Arr[1].split("=")[1];
     self.rpKind =  temp2Arr[2].split("=")[1];
     console.log("Kind:"+self.rpKind);

     self.submitRepair =  function()
     {
           //check params

           //user service to submit Repair
           var promiseResult = RepairService.submit(self.title,self.addr,self.desc,self.userId,self.level,self.rpId,self.rpName,self.rpKind);
           promiseResult.success(function(data,status,config,headers){
              console.log("submit ok"+data.message);
              alert("提交成功");
              $window.location =  "../index.html";

           });
           promiseResult.error(function(data,status,config,headers){
              console.log("submit error"+data.message);
           });
     }
}]);
//   work  订单历史
app.controller("RepairOrderListController",["RepairService","$window",function(RepairService,$window){
  var self = this;
  self.orders = [];



  //调用方法进行初始化
  initData();

  self.gotoDetial = function(rId){
    $window.location =  "./repairDetial.html?rId="+rId;
  }


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
  var curPartKind = "";
  // init data
  getAllRepairParts();

  //define out   interface
  self.selectPart = function(rpId,index,kind){
    if(curPartClass.length>0){
        $("."+curPartClass+" span").css("background-color","white");
    }

    var className = "part-li-"+rpId+"-"+index;
    curPartClass = className;
    curPartKind = kind;
    $("."+className+" span").css("background-color","#0c9");
    curPartId = rpId;
    curPartName = $("."+className+" .li-partName").text();
    console.log(curPartName);
  };
  self.submitPart = function(){
    //curPartId+" "+curPartName
    RepairService.setrpId(curPartId);
    RepairService.setPartName(curPartName);

    $window.location.href="repair.html?rpId="+curPartId+"&rpName="+curPartName+"&rpKind="+curPartKind;
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

//  repair  详情 controller
app.controller("RepairDetialController",["RepairService","$window",function(RepairService,$window){
  var self = this;
  self.repair;
  self.status;
  var repairType;
  var rId;
  //获取类型

    var reg = new RegExp("(^|&)" + "rId" + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
    var r = window.location.search.substr(1).match(reg);  //匹配目标参数
    rId  =  unescape(r[2]);

    var promise  =  RepairService.getRepairServiceInfo(rId);
    promise.success(function(data,status,config,headers){
        console.log("success RepairService.getRepairServiceInfo");
        self.repair  = data.data;
        console.log(data);
        //判断当前状态对按钮进行禁用
        var rStatus  = data.data.repair.rstatusCode;
        console.log(rStatus);
        self.status = rStatus;
        if(rStatus==314||rStatus==316){
            $(".mik-comment").attr('disabled',true);
        }
    });
    promise.error(function(data,status,config,headers){
      console.log("error RepairService.getRepairById");
    });









  //define out interface


}]);
