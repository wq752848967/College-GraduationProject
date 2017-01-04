app.service("LoginService",["$http",function($http){

  this.login = function(username,userpsw){
    return   $http({url:serverAddress+'/user/login',
     method: 'post',
     headers: {'Content-Type': 'multipart/form-data'},
      params:{ 'userPhone':username,
                'userPsw':userpsw,
             }});
  }
}])
