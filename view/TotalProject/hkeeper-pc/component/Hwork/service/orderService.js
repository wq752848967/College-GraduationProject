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
  this.submit = function(userPhone,title,money,date,time,add,desc,typeCode,dTypeCode)
  {
      console.log(userPhone);
      console.log(title);


     //返回可级联调用方法体promise
     var data = { 'userPhone':userPhone,
       'hwTitle':title,
       'hwMoney':money,
       'hwDate':date,
       'hwTime':time,
       'hwAddr':add,
       'hwDesc':desc,
       'hwTypeCode':typeCode,
       'hwDTypeCode':dTypeCode};
     var transFn = function(data) {
         return $.param(data);
     };
     var postCfg = {
               headers: { 'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'},
               transformRequest: transFn
           };
     //return $http({url:serverAddress+'/hwork/submitHwork',method: 'post',data,postCfg});
     return  $http.post(serverAddress+'/hwork/submitPcHwork', data, postCfg);
   }


}]);
app.service("WaService",["$http",function($http){
  this.getAllByDate = function(){
    return   $http({url:serverAddress+'/wa/getAllByDate',
     method: 'post',
     headers: {'Content-Type': 'multipart/form-data'},
      params:{
             }});
  }
  this.getWorkDetial = function(wId){
    return   $http({url:serverAddress+'/user/getUserInfo',
     method: 'post',
     headers: {'Content-Type': 'multipart/form-data'},
      params:{ userId:wId}});
  }
  this.allowWorkerAu = function(waId){
    return   $http({url:serverAddress+'/hkworker/allowWorkerAu',
     method: 'post',
     headers: {'Content-Type': 'multipart/form-data'},
      params:{ userId:wId}});
  }
  this.refuseWorkerAu = function(waId){
    return   $http({url:serverAddress+'/hkworker/refuseWorkerAu',
     method: 'post',
     headers: {'Content-Type': 'multipart/form-data'},
      params:{ userId:wId}});
  }

}]);

app.service("WorkKindService",["$http",function($http){

  this.getAllWorkKind = function(){
    return   $http({url:serverAddress+'/hworkKind/getAllWorkKind',
     method: 'post',
     headers: {'Content-Type': 'multipart/form-data'},
      params:{
             }});
  }
  this.getWorkKindByType = function(kindType){
    return   $http({url:serverAddress+'/hworkKind/getHkKindByType',
     method: 'post',
     headers: {'Content-Type': 'multipart/form-data'},
      params:{
          'kindType':kindType
             }});
  }

  this.addWorkKind = function(kindType,kindName){
    var data = {
      'kindType':kindType,
      'kindName':kindName
    };
    var transFn = function(data) {
        return $.param(data);
    };
    var postCfg = {
              headers: { 'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'},
              transformRequest: transFn
          };
    return  $http.post(serverAddress+'/hworkKind/addWorkKind', data, postCfg);
  }

  this.deleteWorkKind = function(kindId){
    return   $http({url:serverAddress+'/hworkKind/deleteWorkKind',
     method: 'post',
     headers: {'Content-Type': 'multipart/form-data'},
      params:{
              'kindId':kindId
             }});
  }



}]);
