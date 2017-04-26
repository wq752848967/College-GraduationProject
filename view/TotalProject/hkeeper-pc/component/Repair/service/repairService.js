app.service("AddRepairService",["$http",function($http){
  //repair part  sestion
  this.getAllRepairParts = function(){
    return $http({ url:serverAddress+'/repairpart/getAllPartsModels',
            method: 'post',
            headers: {'Content-Type': 'multipart/form-data'}
            });
  };
  this.submit = function(title,addr,desc,userPhone,userName,level,rpId,rpName,rpKind){
    //返回可级联调用方法体promise
    var data = {'RTitle':title,'RAddr':addr,'RDes':desc,'userPhone':userPhone,
                'userName':userName,'RLevel':level,'rpId':rpId,'rpName':rpName,
                 'rpKind':rpKind};
    var transFn = function(data) {
        return $.param(data);
    };
    var postCfg = {
              headers: { 'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'},
              transformRequest: transFn
          };
  //  return $http({url:serverAddress+'/repair/submitRepair',method: 'post',data,postCfg});
    return  $http.post(serverAddress+'/repair/submitRepair', data, postCfg);
  };

}]);
app.service("RepairListService",["$http",function($http){



  //Repair

  this.getAllRepairByDate = function(pageNow,pageSize){
    return   $http({url:serverAddress+'/repair/getAllRepairByDate',
     method: 'post',
     headers: {'Content-Type': 'multipart/form-data'},
      params:{
                'pageNow':pageNow,
                'pageSize':pageSize
             }});
  }


  this.allow = function(rId){
    return   $http({url:serverAddress+'/repair/allowRepairApplication',
     method: 'post',
     headers: {'Content-Type': 'multipart/form-data'},
      params:{
                'rId':rId
             }});
  }
  this.refuse = function(rId){
    return   $http({url:serverAddress+'/repair/refuseRepairApplication',
     method: 'post',
     headers: {'Content-Type': 'multipart/form-data'},
      params:{
                'rId':rId
             }});
  }

this.getRepairServiceInfo = function(rId,uId){
  return   $http({url:serverAddress+'/repair/getRepairServiceInfo',
   method: 'post',
   headers: {'Content-Type': 'multipart/form-data'},
    params:{
              'rId':rId,
              'uId':uId
           }});
}

}]);








//Repair  Part


app.service("RepairPartManageService",["$http",function($http){
  this.getAllParts = function(){
    return   $http({url:serverAddress+'/repairpart/getAllParts',
     method: 'post',
     headers: {'Content-Type': 'multipart/form-data'}
    });
  };

  this.addPart = function(pName,pKind,pParts){

    var data = {'pName':pName,'pKind':pKind,'pParts':pParts};
    console.log(pName+" "+pKind+" "+pParts);
    var transFn = function(data) {
        return $.param(data);
    };
    var postCfg = {
              headers: { 'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'},
              transformRequest: transFn
          };
      return  $http.post(serverAddress+'/repairpart/addPart', data, postCfg);
    //return $http({url:serverAddress+'/repairpart/addPart',method: 'post',data,postCfg});
  };



  this.updatePartProject = function(pId,pName,pKind,pParts,pStatus){
  
    var data = {'pId':pId,'pName':pName,'pKind':pKind,'pParts':pParts,'pStatus':pStatus};
    var transFn = function(data) {
        return $.param(data);
    };
    var postCfg = {
              headers: { 'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'},
              transformRequest: transFn
          };
      return  $http.post(serverAddress+'/repairpart/updatePartsContent', data, postCfg);
    //return $http({url:serverAddress+'/repairpart/updatePartsContent',method: 'post',data,postCfg});
  }
}])



// NOTE:    repair kind  service

app.service("RepairKindService",["$http",function($http){

  // NOTE:  1

  this.getAllKinds = function(){
    return   $http({url:serverAddress+'/repairKind/getAllKinds',
     method: 'post',
     headers: {'Content-Type': 'multipart/form-data'}
    });
  };




  // NOTE: 2

  this.deleteRepairKind = function(kindId){

  var data = {'kindId':kindId};
  var transFn = function(data) {
      return $.param(data);
  };
  var postCfg = {
            headers: { 'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'},
            transformRequest: transFn
        };
  return  $http.post(serverAddress+'/repairKind/deleteRepairKind', data, postCfg);
  //return $http({url:serverAddress+'/repairKind/addRepairKind',method: 'post',data,postCfg});
};



  // NOTE:  3

  this.addKind = function(kindName){

    var data = {'kindName':kindName};
    var transFn = function(data) {
        return $.param(data);
    };
    var postCfg = {
              headers: { 'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'},
              transformRequest: transFn
          };
    return  $http.post(serverAddress+'/repairKind/addRepairKind', data, postCfg);
    //return $http({url:serverAddress+'/repairKind/addRepairKind',method: 'post',data,postCfg});
  };

}]);

// NOTE:   Worker


app.service("RepairWorkService",["$http",function($http){

 // NOTE: 1
  this.addWorker = function(workName,workAcount,workPsw,workType){

    var data = {
                  'workName':workName,
                  'workAcount':workAcount,
                  'workPsw':workPsw,
                  'workType':workType
               };
    var transFn = function(data) {
        return $.param(data);
    };
    var postCfg = {
              headers: { 'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'},
              transformRequest: transFn
          };
    return  $http.post(serverAddress+'/user/addWorker', data, postCfg);
    //return $http({url:serverAddress+'/repairKind/addRepairKind',method: 'post',data,postCfg});
  };

  // NOTE: 2 getAllWorker

  this.getAllWorker = function(){

    var data = {};
    var transFn = function(data) {
        return $.param(data);
    };
    var postCfg = {
              headers: { 'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'},
              transformRequest: transFn
          };
    return  $http.post(serverAddress+'/user/getAllWorker', data, postCfg);
    //return $http({url:serverAddress+'/repairKind/addRepairKind',method: 'post',data,postCfg});
  };

  // NOTE:  3 getRecentService
  this.getRecentService = function(userId){

    var data = {'userId':userId};
    var transFn = function(data) {
        return $.param(data);
    };
    var postCfg = {
              headers: { 'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'},
              transformRequest: transFn
          };
    return  $http.post(serverAddress+'/repair/getRecentWorkInfoByWorker', data, postCfg);
    //return $http({url:serverAddress+'/repairKind/addRepairKind',method: 'post',data,postCfg});
  };

}]);



// NOTE: RepairDispatcherService
app.service("RepairDispatcherService",["$http",function($http){
  this.getRepairWorkInfo = function(){
    return $http({ url:serverAddress+'/repairInfo/getAll',
            method: 'post',
            headers: {'Content-Type': 'multipart/form-data'}
            });
  }


  this.changeRepairLevel = function(repairId,level){


    var data = {
                'repairId':repairId,
                'level':level
               };
    var transFn = function(data) {
        return $.param(data);
    };
    var postCfg = {
              headers: { 'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'},
              transformRequest: transFn
          };
    return  $http.post(serverAddress+'/repair/changeRepairLevel', data, postCfg);


  }
}]);
