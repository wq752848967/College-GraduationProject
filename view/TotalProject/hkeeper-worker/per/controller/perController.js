app.controller('WorkDetialController',['userService',function(userService){
  //定义数据
  var self = this;
  self.workDetial;
  //获取Url wid
  //获取wid
  var reg = new RegExp("(^|&)" + "wId" + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
  var r = window.location.search.substr(1).match(reg);  //匹配目标参数
  var wId  =  unescape(r[2]);

  var hreg = new RegExp("(^|&)" + "hwId" + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
  var hr = window.location.search.substr(1).match(hreg);  //匹配目标参数
  var hwId  =  unescape(hr[2]);
  //调用service 获取信息
  var promise = userService.getWorkDetial(wId);

  promise.success(function(data,status,config,headers){
      self.workDetial = data.data;

      console.log("success WorkDetialController.getWorkDetial");

  });
  promise.error(function(data,status,config,headers){
     console.log("error WorkDetialController.getWorkDetial");
  });



  //定义方法
  self.useWork = function(){
    var promise = userService.userWork(wId,hwId);
    promise.success(function(data,status,config,headers){
      console.log("success userWork："+data.message);
    });
    promise.error(function(data,status,config,headers){
      console.log("error userWork："+data.message);
    });
  }
}]);



app.controller('UserInfoController',['userService',function(userService){
  var self = this;
  self.user;
 console.log('in');
  //init
  getUserInfo();

  //define  outr interface




  //define inter methods
  function getUserInfo(){
    var promise = userService.getUserInfo();
    promise.success(function(data,status,config,headers){
      console.log("success getUserInfo");
      if(data.success){
        self.user = data.data;
      
      }
      else{
        alert("数据错误");
      }
    });
    promise.error(function(data,status,config,headers){
      console.log("error getUserInfo");
      alert("网络错误");
    });
  }




}]);
