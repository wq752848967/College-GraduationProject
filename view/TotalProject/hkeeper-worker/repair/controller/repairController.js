app.controller("GetRepairController",["RepairService","$window",function(RepairService,$window){


  var self = this;
  //定义数据

  self.workType;

  self.totalPerc;
  self.type_01;
  self.perc_01;
  self.compelet_01;
  self.leftCount_01;

  self.type_02;
  self.perc_02;
  self.compelet_02;
  self.leftCount_02;

  self.type_03;
  self.perc_03;
  self.compelet_03;
  self.leftCount_03;

  self.type_04;
  self.perc_04;
  self.compelet_04;
  self.leftCount_04;
  //初始化数据


  //get work info
 var promise =  RepairService.getRepairWorkInfo();
 promise.success(function(data,status,config,headers){
   console.log("success RepairService.getRepairWorkInfo");
   var list = data.data;
    console.log(data.data);
   self.type_01 = list[0].rcTypeName;
   self.perc_01 =  (((list[0].rcDayComplete/list[0].rcUnComplete).toFixed(2))*100)+'%';
   self.leftCount_01 = list[0].rcUnComplete;
   self.compelet_01 = list[0].rcDayComplete;

   self.type_02= list[1].rcTypeName;
   self.perc_02 =  (((list[1].rcDayComplete/list[1].rcUnComplete).toFixed(2))*100)+'%';
   self.leftCount_02 = list[1].rcUnComplete;
   self.compelet_02 = list[1].rcDayComplete;

   self.type_03 = list[2].rcTypeName;
   self.perc_03 =  (((list[2].rcDayComplete/list[2].rcUnComplete).toFixed(2))*100)+'%';
   self.leftCount_03 = list[2].rcUnComplete;
   self.compelet_03 = list[2].rcDayComplete;

   self.type_04 = list[3].rcTypeName;
   self.perc_04 =  (((list[3].rcDayComplete/list[3].rcUnComplete).toFixed(2))*100)+'%';
   self.leftCount_04 = list[3].rcUnComplete;
   self.compelet_04 = list[3].rcDayComplete;


   var totalUnComplete = list[0].rcUnComplete+list[1].rcUnComplete+list[2].rcUnComplete;
   var totalDayComplete = list[0].rcDayComplete+list[1].rcDayComplete+list[2].rcDayComplete;
   //self.totalPerc = (totalDayComplete/totalUnComplete)+'%';
   getWorkType();
 });
 promise.error(function(data,status,config,headers){
   console.log("error RepairService.getRepairWorkInfo");
 });

//定义方法
  self.moveGetPage = function(repairType){

    $window.location =  "./repairDetial.html?repairType="+self.workType.toString()+"&deType=1";
  }

  self.showInfo = function(){

     var top = ($(window).height() - $(".pop-panel").height())/2;
     var left = ($(window).width() - $(".pop-panel").width())/2;
     var scrollTop = $(document).scrollTop();
     var scrollLeft = $(document).scrollLeft();
     $(".pop-panel").css( { position : 'absolute', 'top' : top + scrollTop, left : left + scrollLeft } ).show();

  }
  self.hiddenInfo = function(){
    $(".pop-panel").hide();
  }




  //inter method
  function getWorkType(){
    //获取用户类型
    var promise = RepairService.getWorkType();
    promise.success(function(data,status,config,headers){
       console.log("success RepairService.getWorkType");
       self.workType = data.data;
       console.log(self.workType);
       if(self.workType==3){

         self.totalPerc = self.perc_01;
         console.log(self.totalPerc);
       }
       if(self.workType==2){

        self.totalPerc = self.perc_02;
       }
       if(self.workType==1){

        self.totalPerc = self.perc_03;
       }
       if(self.workType==4){
        self.totalPerc = self.perc_04*100;
       }

    });
    promise.error(function(data,status,config,headers){
      console.log("error RepairService.getWorkType");
    });
  }

}]);




//  repair  详情 controller
app.controller("RepairDetialController",["RepairService","$window",function(RepairService,$window){
  var self = this;
  self.repair;
  var repairType;
  var rId;
  self.picUrl;


  //获取类型
  deType
  var dreg = new RegExp("(^|&)" + "deType" + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
  var dr = window.location.search.substr(1).match(dreg);  //匹配目标参数
  var deType  =  unescape(dr[2]);
  if(deType==1){
    var reg = new RegExp("(^|&)" + "repairType" + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
    var r = window.location.search.substr(1).match(reg);  //匹配目标参数
    repairType  =  unescape(r[2]);
    // 调用service 获取任务
    var promise  =  RepairService.getRepair(repairType);
    promise.success(function(data,status,config,headers){
        console.log("success RepairService.getRepair");
        self.repair  = data.data;
        rId = self.repair.repair.rid;
        if(data.data.repair.rpicUrl1==null){
            self.picUrl = picAddress  +  "rImages/err.png";
        }
        else{
            self.picUrl = picAddress + data.data.repair.rpicUrl1;
        }
        console.log(data);
    });
    promise.error(function(data,status,config,headers){
      console.log("error RepairService.getRepair");
    });
  }else{
    var reg = new RegExp("(^|&)" + "rId" + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
    var r = window.location.search.substr(1).match(reg);  //匹配目标参数
    rId  =  unescape(r[2]);

    var promise  =  RepairService.getRepairServiceInfo(rId);
    promise.success(function(data,status,config,headers){
        console.log("success RepairService.getRepairById");
        self.repair  = data.data;
        rId = self.repair.repair.rid;
        if(data.data.repair.rpicUrl1==null){
            self.picUrl = picAddress  +  "rImages/err.png";
        }
        else{
            self.picUrl = picAddress + data.data.repair.rpicUrl1;
        }
        console.log(data);
        //判断当前状态对按钮进行禁用
        var rStatus  = data.data.repair.rstatusCode;
        if(rStatus==314||rStatus==316){

            document.getElementById('cannot-repair').style.visibility = "hidden"
            document.getElementById('repair-complete').style.visibility = "hidden"

        }
    });
    promise.error(function(data,status,config,headers){
      console.log("error RepairService.getRepairById");
    });
  }








  //define out interface
  self.finishRepair = function() {
    var promise  =  RepairService.finishRepair(rId);
    promise.success(function(data,status,config,headers){
        console.log("success RepairService.cantNotRepair");
          alert("完成成功");
          $window.location =  "./orderList.html";

    });
    promise.error(function(data,status,config,headers){
      console.log("error RepairService.cantNotRepair");
        alert("修改失败");
    });
  }
  self.cantNotRepair = function(){
    var promise  =  RepairService.canNotRepair(rId);
    promise.success(function(data,status,config,headers){
        console.log("success RepairService.cantNotRepair");
        alert("修改成功");
        document.getElementById('cannot-repair').style.visibility = "hidden"
        document.getElementById('repair-complete').style.visibility = "hidden"
    });
    promise.error(function(data,status,config,headers){
      console.log("error RepairService.cantNotRepair");
      alert("修改失败");
    });
  }

}]);



//   work  订单历史
app.controller("RepairOrderListController",["RepairService","$window",function(RepairService,$window){
  var self = this;
  self.orders = [];



  //调用方法进行初始化
  initData();


  //声明外部方法


  self.gotoDetial = function(rId){
    $window.location =  "./repairDetial.html?rId="+rId+"&deType=2";
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
