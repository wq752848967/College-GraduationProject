app.service("LoginService",["$http",function($http){

  this.login = function(username,userpsw){
    return   $http({url:serverAddress+'/user/login',
     method: 'post',
     headers: {'Content-Type': 'multipart/form-data'},
      params:{ 'userPhone':username,
                'userPsw':userpsw,
             }});
  }
}]);
app.service("RegisterService",["$http",function($http) {
    //addHouseUser
    this.addHouseUser = function(phone,psw,checkNum){
      return   $http({url:serverAddress+'/user/addHouseUser',
       method: 'post',
       headers: {'Content-Type': 'multipart/form-data'},
        params:{ 'phone':phone,
                  'psw':psw,
                  "checkNum":checkNum
               }});
    }
}])
