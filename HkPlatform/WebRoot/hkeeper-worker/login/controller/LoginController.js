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
    self.showWaiting = function(){
      var top = ($(window).height() - $(".result-panel").height())/2;
      var left = ($(window).width() - $(".result-panel").width())/2;
      var scrollTop = $(document).scrollTop();
      var scrollLeft = $(document).scrollLeft();
      $(".result-panel").css( { position : 'absolute', 'top' : top + scrollTop, left : left + scrollLeft } ).show();
    }

}]);
