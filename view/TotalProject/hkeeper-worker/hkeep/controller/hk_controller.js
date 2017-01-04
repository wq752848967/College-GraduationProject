
app.controller('HworksListController',['HworksService','$window',function(HworksService,$window){

          var self = this;
          self.hwList;
          self.type = 1;
          self.typeAll = true;
          //初始化列表
          var promise = HworksService.getHworks();
          promise.success(function(data,status,config,header){
              self.hwList  =  data.data;
              //HworksService.dataList = data.data;
              console.log("get success:"+data.message);
          });
          promise.error(function(data,status,config,header){
              console.log("get error ");
          });



          //定义相关方法
          self.showDetial = function(hwId)
          {
              //HworksService.curDetialId = hwId;
              //alert(HworksService.dataList.length+"  "+  HworksService.curDetialId);
            $window.location.href="w_hk_workerDetial.html?hwId="+hwId+"&type=1";
          }

          //弹出框选择
          self.chengeType = function(typeCode){
              switch (typeCode) {
                case 0:
                  self.typeAll = true;
                  break;

                default:
                self.typeAll = false;
                self.type = typeCode;
              }
               $("#work_kind_panel").popup("close");
          }



}]);
app.controller('HworksDetialController',['HworksService',function(HworksService){

      var self = this;

      self.title;
      self.money;
      self.visitTimes;
      self.pubDate;
      self.date;
      self.time;
      self.type;
      self.desc;
      self.addr;
      self.submitText;
      var reg = new RegExp("(^|&)" + "hwId" + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
      var r = window.location.search.substr(1).match(reg);  //匹配目标参数
      var hwId  =  unescape(r[2]);

      var treg = new RegExp("(^|&)" + "type" + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
      var tr = window.location.search.substr(1).match(treg);  //匹配目标参数
      var viewType  =  unescape(tr[2]);
      if(viewType==1){
          self.submitText = "申请家政";
      }
      else if(viewType==2){
          self.submitText ="完成订单";
      }
      else{
        self.submitText = "未知错误";
      }

      //调用service 获取详情数据
      var primiseResult = HworksService.getDetial(hwId);
      primiseResult.success(function(data,status,config,headers){
              self.title = data.data['hwTitle'];
              self.money = data.data['hwMoney'];
              self.visitTimes = data.data['hwVisitTime'];
              self.pubDate = data.data['hwPubDate'];
              self.date = data.data['hwDate'];
              self.time = data.data['hwTime'];
              self.type = data.data['hwDTypeCode'];
              self.desc = data.data['hwDesc'];
              self.addr = data.data['hwAddr'];
      });

      self.applyHwork = function()
      {
        if(viewType==1){
          var promise = HworksService.applyHwork();
          promise.success(function(){
              alert("申请成功");
              $window.location.href="w_hk_workerList";
          });
          promise.error(function(){
              alert("网络错误，收藏失败");
          });
        }
        if (viewType==2) {
            //完成订单
            self.completeHwork();
        }

      }

      //完成订单
      self.completeHwork()   = function(){
        var promise = HworksService.completeHwork();
        promise.success(function(){
            alert("完成订单成功");
            $window.location.href="w_hk_workerList";
        });
        promise.error(function(){
            alert("网络错误，完成订单失败");
        });
      }

}]);




//历史订单controller
app.controller("OrderListController",['HworksService',function(HworksService){
  var self = this;
  //定义数据
  self.dataList;

   //获取数据
   var promise = HworksService.getOrderList();
   promise.success(function(data,status,config,headers){
      console.log("success HworksService.getOrderList");
      self.dataList = data.data;

   });
   promise.error(function(data,status,config,headers){
      console.log("error HworksService.getOrderList");

   });



  //定义方法
  self.historyDetial = function(hwId){
      $window.location.href="w_hk_workerDetial.html?hwId="+hwId+"&type=2";
  }
}])
