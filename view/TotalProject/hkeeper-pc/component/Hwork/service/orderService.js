app.service("OrderService",["$http",function($http){
  this.getHworkListByStatusAndDate = function(pageNow,pageSize){
    return   $http({url:serverAddress+'/hwork/getHworkListByStatusAndDate',
     method: 'post',
     headers: {'Content-Type': 'multipart/form-data'},
      params:{
                'status':213,
                'pageNow':pageNow,
                'pageSize':pageSize
             }});
  }

}]);
