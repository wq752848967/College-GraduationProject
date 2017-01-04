app.service("RepairListService",["$http",function($http){
  this.getAllRepairByDate = function(pageNow,pageSize){
    return   $http({url:serverAddress+'/repair/getAllRepairByDate',
     method: 'post',
     headers: {'Content-Type': 'multipart/form-data'},
      params:{
                'pageNow':pageNow,
                'pageSize':pageSize
             }});
  }
}]);
