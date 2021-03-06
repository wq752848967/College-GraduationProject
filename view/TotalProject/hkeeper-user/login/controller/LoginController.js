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
            self.hideWaiting();
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
    self.hideWaiting = function(){

      $(".result-panel").hide();
    }

}]);
app.controller("RegisterController",["RegisterService","$window",function(RegisterService,$window){
    var self = this;
    wait = 60;
    self.waitText = "发验证码";
    self.phone;
    self.uname;
    self.uaddr;
    self.psw;
    self.checkNum;
    self.resultInfo = "错误"
    self.next  = function(){
        self.showWaiting();
        checkSms(self.checkNum,self.phone);
        //addHouseUser();
    }
    self.sendCheck = function(){

      btnObject = document.getElementsByClassName('send-check');
      sendCheckSms(self.phone);
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

    // send sms
    function sendCheckSms(phone_Num)
	{

	  		 AV.Cloud.requestSmsCode({
        	 mobilePhoneNumber: phone_Num,
      		 name: '贤得家家政',
      		 op: '短信验证',
      		 ttl: 1
    	  }).then(function(){
    	     //hideLoader();
    	  	 //addCookie("secondsremained",60,60);//添加cookie记录,有效时间60s
        	 //settime();//开始倒计时


		}, function(err){
 		     alert("发送失败");
		});
	}
    function checkSms(s_check_Num,b_phone_Num){
      AV.Cloud.verifySmsCode(s_check_Num, b_phone_Num).then(function(){
  		      addHouseUser();
			}, function(err){
        self.hideWaiting();
   			 alert("验证错误，请稍后再试");
			});
    }

    function addHouseUser(){
      self.showWaiting();
      var promise = RegisterService.addHouseUser(self.phone,self.uname,self.psw,self.checkNum,self.uaddr);
      promise.success(function(data,status,config,headers){
          var result = data.success;
          if(result==true){
            //登录成功
            $window.location.href="./login.html";
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
}])
