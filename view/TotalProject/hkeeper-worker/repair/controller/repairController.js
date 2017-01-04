app.controller("GetRepairController",["RepairService","$window",function(RepairService,$window){


  var self = this;
  //定义数据

  self.workType;

  self.totalPerc;
  self.type_01;
  self.perc_01;
  self.leftCount_01;

  self.type_02;
  self.perc_02;
  self.leftCount_02;

  self.type_03;
  self.perc_03;
  self.leftCount_03;
  //初始化数据
 var promise =  RepairService.getRepairWorkInfo();
 promise.success(function(data,status,config,headers){
   console.log("success RepairService.getRepairWorkInfo");
   var list = data.data;
   self.type_01 = list[0].rcTypeName;
   self.perc_01 =  (list[0].rcDayComplete/list[0].rcUnComplete)+'%';
   self.leftCount_01 = list[0].rcUnComplete;

   self.type_02= list[1].rcTypeName;
   self.perc_02 =  (list[1].rcDayComplete/list[1].rcUnComplete)+'%';
   self.leftCount_02 = list[1].rcUnComplete;

   self.type_03 = list[2].rcTypeName;
   self.perc_03 =  (list[2].rcDayComplete/list[2].rcUnComplete)+'%';
   self.leftCount_03 = list[2].rcUnComplete;

   var totalUnComplete = list[0].rcUnComplete+list[1].rcUnComplete+list[2].rcUnComplete;
   var totalDayComplete = list[0].rcDayComplete+list[1].rcDayComplete+list[2].rcDayComplete;
   self.totalPerc = (totalDayComplete/totalUnComplete)+'%';

 });
 promise.error(function(data,status,config,headers){
   console.log("error RepairService.getRepairWorkInfo");
 });

//定义方法
  self.moveGetPage = function(repairType){

    $window.location =  "./repairDetial.html?repairType="+self.workType.toString();
  }

  self.showInfo = function(){

     var top = ($(window).height() - $(".pop-panel").height())/2;
     var left = ($(window).width() - $(".pop-panel").width())/2;
     var scrollTop = $(document).scrollTop();
     var scrollLeft = $(document).scrollLeft();
     $(".pop-panel").css( { position : 'absolute', 'top' : top + scrollTop, left : left + scrollLeft } ).show();
     //获取用户类型
     var promise = RepairService.getWorkType();
     promise.success(function(data,status,config,headers){
        console.log("success RepairService.getWorkType");
        self.workType = data.data;
     });
     promise.error(function(data,status,config,headers){
       console.log("error RepairService.getWorkType");
     });
  }
  self.hiddenInfo = function(){
    $(".pop-panel").hide();
  }

}]);




//  repair  详情 controller
app.controller("RepairDetialController",["RepairService",function(RepairService){
  var self = this;
  self.repair;

  //获取类型
  var reg = new RegExp("(^|&)" + "repairType" + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
  var r = window.location.search.substr(1).match(reg);  //匹配目标参数
  var repairType  =  unescape(r[2]);


  // 调用service 获取任务
  var promise  =  RepairService.getRepair(repairType);
  promise.success(function(data,status,config,headers){
      console.log("success RepairService.getRepair");
      self.repair  = data.data;
      console.log(data);
  });
  promise.error(function(data,status,config,headers){
    console.log("error RepairService.getRepair");
  });

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
