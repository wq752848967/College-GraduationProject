angular.module('hkeep_user')
.service('RepairService',['$http',function($http){
    this.submit = function(title,addr,desc,userId,level){
      //返回可级联调用方法体promise
      var data = {'RTitle':title,'RAddr':addr,'RDes':desc,'UId':userId,'RLevel':level};
      var transFn = function(data) {
          return $.param(data);
      };
      var postCfg = {
                headers: { 'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'},
                transformRequest: transFn
            };
      return $http({url:serverAddress+'/repair/submitRepair',method: 'post',data,postCfg});
    };
    //获取历史订单
    this.getOrderHistory = function(){
      return $http({ url:serverAddress+'/repair/getRepairOrder',
              method: 'post',
              headers: {'Content-Type': 'multipart/form-data'}
              });
    };
}])
