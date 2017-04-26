// JavaScript Document




app.service('HKeepService',['$http',function($http){

    this.submit = function(userId,title,money,date,time,add,desc,typeCode,dTypeCode,phone)
    {


       //返回可级联调用方法体promise
       var data = { 'hwPubUId':userId,
         'hwTitle':title,
         'hwMoney':money,
         'hwDate':date,
         'hwTime':time,
         'hwAddr':add,
         'hwDesc':desc,
         'hwTypeCode':typeCode,
         'hwDTypeCode':dTypeCode,
         'userPhone':phone};
       var transFn = function(data) {
           return $.param(data);
       };
       var postCfg = {
                 headers: { 'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'},
                 transformRequest: transFn
             };
       //return $http({url:serverAddress+'/hwork/submitHwork',method: 'post',data,postCfg});
       return  $http.post(serverAddress+'/hwork/submitHwork', data, postCfg);






   }
}]);





app.service('HKeepApplyService',['$http',function($http){

    this.getList = function(userId)
    {

       //返回可级联调用方法体promise
       return $http({url:serverAddress+'/hwork/getHworkListByUId',
       method: 'post',
       headers: {'Content-Type': 'multipart/form-data'},
        params:{ UId:userId}});
   }
   this.getDetial = function(hwId){
      //返回可级联调用方法体promise
      return $http({url:serverAddress+'/hworkapply/getApplyHworkDetial',
      method: 'post',
      headers: {'Content-Type': 'multipart/form-data'},
      params:{ 'hwId':hwId}});
   }
   this.submitComment = function(hwId,cContent,cPoint){
     //返回可级联调用方法体promise
     var data = {
       'hwId':hwId,
       'cContent':cContent,
       'cPoint':cPoint
      };
     var transFn = function(data) {
         return $.param(data);
     };
     var postCfg = {
               headers: { 'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'},
               transformRequest: transFn
           };

     return  $http.post(serverAddress+'/comment/addComment', data, postCfg);
   }
}]);


// NOTE: hw kind
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




}]);
