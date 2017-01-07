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





app.service("RepairPartManageService",["$http",function($http){
  this.getAllParts = function(){
    return   $http({url:serverAddress+'/repairpart/getAllParts',
     method: 'post',
     headers: {'Content-Type': 'multipart/form-data'}
    });
  };

  this.addPart = function(pName,pParts){

    var data = {'pName':pName,'pParts':pParts};
    var transFn = function(data) {
        return $.param(data);
    };
    var postCfg = {
              headers: { 'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'},
              transformRequest: transFn
          };
    return $http({url:serverAddress+'/repairpart/addPart',method: 'post',data,postCfg});
  };



  this.updatePartProject = function(pId,pName,pParts,pStatus){
  
    var data = {'pId':pId,'pName':pName,'pParts':pParts,'pStatus':pStatus};
    var transFn = function(data) {
        return $.param(data);
    };
    var postCfg = {
              headers: { 'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'},
              transformRequest: transFn
          };
    return $http({url:serverAddress+'/repairpart/updatePartsContent',method: 'post',data,postCfg});
  }
}])
