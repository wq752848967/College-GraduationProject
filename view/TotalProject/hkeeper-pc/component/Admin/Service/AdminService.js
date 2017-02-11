app.service("AdminService",["$http",function($http){
  this.login = function(adminName,adminPsw){
    //返回可级联调用方法体promise
    var data = {
                'adminName':adminName,
                'adminPsw':adminPsw
                };
    var transFn = function(data) {
        return $.param(data);
    };
    var postCfg = {
              headers: { 'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'},
              transformRequest: transFn
          };
    //return $http({url:serverAddress+'/hwork/submitHwork',method: 'post',data,postCfg});
    return  $http.post(serverAddress+'/user/login', data, postCfg);
  }


  // NOTE:  admin add




  this.addAdmin = function(adminName,adminAcount,adminPsw){
    //返回可级联调用方法体promise
    var data = {
                'adminName':adminName,
                'adminAcount':adminAcount,
                'adminPsw':adminPsw
                };
    var transFn = function(data) {
        return $.param(data);
    };
    var postCfg = {
              headers: { 'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'},
              transformRequest: transFn
          };
    //return $http({url:serverAddress+'/hwork/submitHwork',method: 'post',data,postCfg});
    return  $http.post(serverAddress+'/user/addAdmin', data, postCfg);
  }




  // NOTE:  admin get


  this.getAllAdmin = function(adminName,adminAcount,adminPsw){
    //返回可级联调用方法体promise
    var data = {
                };
    var transFn = function(data) {
        return $.param(data);
    };
    var postCfg = {
              headers: { 'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'},
              transformRequest: transFn
          };
    //return $http({url:serverAddress+'/hwork/submitHwork',method: 'post',data,postCfg});
    return  $http.post(serverAddress+'/user/getAllAdmin', data, postCfg);
  }



  // NOTE: admin updateAdminStstus



  this.updateAdminStstus = function(adminId,statusType){
    //返回可级联调用方法体promise
    console.log(adminId);
    var data = {
                'adminId':adminId,
                'statusType':statusType
                };
    var transFn = function(data) {
        return $.param(data);
    };
    var postCfg = {
              headers: { 'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'},
              transformRequest: transFn
          };
    //return $http({url:serverAddress+'/hwork/submitHwork',method: 'post',data,postCfg});
    return  $http.post(serverAddress+'/user/updateAdminStstus', data, postCfg);
  }




}]);
