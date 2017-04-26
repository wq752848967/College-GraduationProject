app.controller("LoginController",["LoginService","$window",function(LoginService,$window){

    var self = this;
    self.username;
    self.userpsw;




    //定义方法
    self.login = function(){
      self.showWaiting();
    //  $window.location.href="../index.html";

      var promise = LoginService.login(self.username,self.userpsw);
      promise.success(function(data,status,config,headers){
          var result = data.success;
          if(result==true){
            //登录成功
            $window.location.href="../index.html";
          }else{
            //登陆失败
            alert("登录失败");
          }
      })
      promise.error(function(data,status,config,headers){
          console.log("login error");
      })

    }
    self.changeRegister = function(){
      $window.location.href="./registerU.html";
    }
    self.showWaiting = function(){
      var top = ($(window).height() - $(".result-panel").height())/2;
      var left = ($(window).width() - $(".result-panel").width())/2;
      var scrollTop = $(document).scrollTop();
      var scrollLeft = $(document).scrollLeft();
      $(".result-panel").css( { position : 'absolute', 'top' : top + scrollTop, left : left + scrollLeft } ).show();
    }

}]);
app.controller("RegisterController",["RegisterService","$window",function(RegisterService,$window){
    var self = this;
    wait = 60;
    self.waitText = "发验证码";
    self.phone;
    self.psw;
    self.checkNum;
    self.resultInfo = "错误"


    self.next  = function(){
     addHouseUser();
    }
    self.sendCheck = function(){
      btnObject = document.getElementsByClassName('send-check');

      sendCheck(btnObject);
    }
    self.showWaiting = function(){
      var top = ($(window).height() - $(".result-panel").height())/2;
      var left = ($(window).width() - $(".result-panel").width())/2;
      var scrollTop = $(document).scrollTop();
      var scrollLeft = $(document).scrollLeft();
      $(".result-panel").css( { position : 'absolute', 'top' : top + scrollTop, left : left + scrollLeft } ).show();
    }
    self.showInfo = function(){
      var top = ($(window).height() - $(".result-panel").height())/2;
      var left = ($(window).width() - $(".result-panel").width())/2;
      var scrollTop = $(document).scrollTop();
      var scrollLeft = $(document).scrollLeft();
      $(".result-info-panel").css( { position : 'absolute', 'top' : top + scrollTop, left : left + scrollLeft } ).show();
    }
    self.hideWaiting = function(){

      $(".result-panel").hide();
    }
    self.addUser = function(){
      addHouseUser();
    }

    function sendCheck(o){
      if (wait == 0) {
            $("#send-check").html("发验证码");
              $("#send-check").addClass("sended-check");
          wait = 60;
      } else {
          $("#send-check").addClass("sended-check");
          $("#send-check").html("重新发送(" + wait + ")");
          wait--;
          setTimeout(function() {
              sendCheck(o)
          },
          1000)
      }
    }
    function addHouseUser(){
      self.showWaiting();
      var promise = RegisterService.addHkUser(self.phone,self.psw,self.checkNum);
      promise.success(function(data,status,config,headers){
          var result = data.success;
          if(result==true){
            //登录成功
            $window.location.href="./workAuthentication.html?userId="+data.data;
          }else{
            self.hideWaiting();
            //登陆失败
            alert("注册失败："+data.data);

          }
      })
      promise.error(function(data,status,config,headers){
          self.hideWaiting();
          alert("网络错误，注册失败");
      })
    }
}]);
app.controller("WaController",["WaService","$window",function(WaService,$window){
    var self = this;

    self.relName;
    self.relPhone;
    self.workType;
    self.des;
    self.cardNum;
    self.userId;
    self.company;
    self.resultInfo = "错误"
    var reg = new RegExp("(^|&)" + "userId" + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
    var r = window.location.search.substr(1).match(reg);  //匹配目标参数
    self.userId  =  unescape(r[2]);

    self.next  = function(){
     addWa();
    }



    self.showWaiting = function(){
      var top = ($(window).height() - $(".result-panel").height())/2;
      var left = ($(window).width() - $(".result-panel").width())/2;
      var scrollTop = $(document).scrollTop();
      var scrollLeft = $(document).scrollLeft();
      $(".result-panel").css( { position : 'absolute', 'top' : top + scrollTop, left : left + scrollLeft } ).show();
    }

    self.hideWaiting = function(){

      $(".result-panel").hide();
    }


    function addWa(){
      self.showWaiting();
      var promise = WaService.addWa(self.relName,self.relPhone,self.workType,self.cardNum,self.userId,self.des,self.company);
      promise.success(function(data,status,config,headers){
          var result = data.success;
          if(result==true){
            alert("请等待管理员审核");
            $window.location.href="../login/login.html";
          }else{
            self.hideWaiting();
            //登陆失败
            alert("认证失败："+data.data);

          }
      })
      promise.error(function(data,status,config,headers){
          self.hideWaiting();
          alert("网络错误，认证失败");
      })
    }
}]);
