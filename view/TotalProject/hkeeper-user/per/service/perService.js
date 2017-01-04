app.service('workService',['$http',function($http){
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
}]);
