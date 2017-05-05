app.service('userService',['$http',function($http){
  this.getWorkDetial = function(wId){
    return   $http({url:serverAddress+'/user/getworkInfo',
     method: 'post',
     headers: {'Content-Type': 'multipart/form-data'},
      params:{ userId:wId}});
  }
  this.userWork = function(workId,hworkId){
    return   $http({url:serverAddress+'/orders/createOrder',
     method: 'post',
     headers: {'Content-Type': 'multipart/form-data'},
      params:{
                workId:workId,
                hworkId:hworkId}});
  }
  this.getUserInfo = function(wId){
    return   $http({url:serverAddress+'/user/getUserInfo',
     method: 'post',
     headers: {'Content-Type': 'multipart/form-data'}});
  }





  this.updateUserInfo = function(uname,uemail,upsw,uaddr){
    //返回可级联调用方法体promise
    var data = {'uname':uname,
               'uemail':uemail,
               'upsw':upsw,
               "uaddr":uaddr};
    var transFn = function(data) {
        return $.param(data);
    };
    var postCfg = {
              headers: { 'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'},
              transformRequest: transFn
          };
  //  return $http({url:serverAddress+'/repair/submitRepair',method: 'post',data,postCfg});
    return  $http.post(serverAddress+'/user/updateUserInfo', data, postCfg);
  }




  this.uploadUserPic = function(file){

      return $http({
          method:'POST',
          url: serverAddress+'/user/uploadUserPic',
          headers: {
              'Content-Type': undefined
          },
          data: {
              "file":file
          },
          transformRequest: function(data,headersGetter){
                     var formData = new FormData();
                            angular.forEach(data, function (value, key) {
                            formData.append(key, value);
                     });
             return formData;
          }
        })
    }

}]);
