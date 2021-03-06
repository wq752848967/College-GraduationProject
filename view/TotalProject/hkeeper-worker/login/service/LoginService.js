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
  this.addHouseUser = function(phone,uname,psw,checkNum){
    //返回可级联调用方法体promise
    var data = {'phone':phone,
               'uname':uname,
               'psw':psw,
               "checkNum":checkNum};
    var transFn = function(data) {
        return $.param(data);
    };
    var postCfg = {
              headers: { 'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'},
              transformRequest: transFn
          };
  //  return $http({url:serverAddress+'/repair/submitRepair',method: 'post',data,postCfg});
    return  $http.post(serverAddress+'/user/addHouseUser', data, postCfg);
  }





    //ADD hk worker
    this.addHkUser = function(phone,uname,psw,checkNum){
      var data = {'phone':phone,
                 'uname':uname,
                 'psw':psw,
                 "checkNum":checkNum};
      var transFn = function(data) {
          return $.param(data);
      };
      var postCfg = {
                headers: { 'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'},
                transformRequest: transFn
            };
    //  return $http({url:serverAddress+'/repair/submitRepair',method: 'post',data,postCfg});
      return  $http.post(serverAddress+'/user/addHkUser', data, postCfg);
    }
}]);
app.service("WaService",["$http",function($http) {

    this.addWa = function(relName,relPhone,workType,cardNum,userId,des,company){
      var data = {
                  'relName':relName,
                  'relPhone':relPhone,
                  "workType":workType,
                  "cardNum":cardNum,
                  "userId":userId,
                  'des':des,
                  'company':company
      };
      var transFn = function(data) {
          return $.param(data);
      };
      var postCfg = {
                headers: { 'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'},
                transformRequest: transFn
            };
    //  return $http({url:serverAddress+'/repair/submitRepair',method: 'post',data,postCfg});
      return  $http.post(serverAddress+'/wa/submitAuthentication', data, postCfg);
    }
}]);
