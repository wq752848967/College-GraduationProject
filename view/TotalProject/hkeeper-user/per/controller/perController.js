app.controller('WorkDetialController',['userService',"$window",function(userService,$window){
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
      console.log(data.data);
      console.log("success WorkDetialController.getWorkDetial");

  });
  promise.error(function(data,status,config,headers){
     console.log("error WorkDetialController.getWorkDetial");
  });



  //定义方法
  self.useWork = function(){
    var promise = userService.userWork(wId,hwId);
    promise.success(function(data,status,config,headers){
      alert("选择成功！");
      $window.location.href="../hkeep/hk_order_Detial.html?hwId="+hwId;
      console.log("success userWork："+data.message);
    });
    promise.error(function(data,status,config,headers){
      console.log("error userWork："+data.message);
    });
  }
}]);



app.controller('UserInfoController',['userService',"$window",function(userService,$window){
  var self = this;
  self.user;
  self.picUrl;
  //init
  getUserInfo();

  //define  outr interface

  self.editInfo = function() {
      $window.location.href="./perEdit.html";
  }
  self.changeToWallet = function(){
      $window.location.href="./perWallet.html?balance="+self.user.wallet.ubalance;
  }


  //define inter methods
  function getUserInfo(){
    var promise = userService.getUserInfo();
    promise.success(function(data,status,config,headers){
      console.log("success getUserInfo");
      if(data.success){
        self.user = data.data;
        console.log(data.data);
        if(data.data.user.ulogo==null){
            self.picUrl =picTotalAddress+"per/"  +  "uImages/default_logo.png";
        }
        else{
            self.picUrl = picTotalAddress+"per/" + data.data.user.ulogo;
        }
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


// NOTE: edit per info
app.controller("PerEditController",["userService","$window",function(userService,$window){

  var self =  this;
  //define
  self.per;
  self.picFile;
  //init
  getUserInfo();


  //outer interface

  self.updateUser = function(){
        if(self.picFile==null){
            updateUserInfo(self.per.uname,self.per.uemail,self.per.upsw,self.per.uaddr);
        }
        else{
          //  /uploadFile
          var promiseResult = userService.uploadUserPic(self.picFile);
          promiseResult.success(function(data,status,config,headers){
             console.log("submit pic ok"+data.message);
             updateUserInfo(self.per.uname,self.per.uemail,self.per.upsw,self.per.uaddr);

          });
          promiseResult.error(function(data,status,config,headers){
             console.log("submit error"+data.message);
             alert("网络错误");
          });
        }
  }


  //inter method
  function getUserInfo(){
    var promise = userService.getUserInfo();
    promise.success(function(data,status,config,headers){
      console.log("success getUserInfo");
      if(data.success){
        self.per = data.data;

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

  function updateUserInfo(uname,uemail,upsw,uaddr){
    var promise = userService.updateUserInfo(uname,uemail,upsw,uaddr);
    promise.success(function(data,status,config,headers){
      console.log("success updateUserInfo");
      if(data.success){
            //change url
            alert("修改成功");
            $window.location.href="./per.html";
      }
      else{
        alert("数据错误");
      }
    });
    promise.error(function(data,status,config,headers){
      console.log("error updateUserInfo");
      alert("网络错误");
    });
  }




}]);
app.controller("UserWalletController",[function(){
    var self = this;
    self.balance;
    var reg = new RegExp("(^|&)" + "balance" + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
    var r = window.location.search.substr(1).match(reg);  //匹配目标参数
    self.balance  =  unescape(r[2]);
}]);
