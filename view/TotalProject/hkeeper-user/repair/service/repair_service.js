angular.module('hkeep_user')
.service('RepairService',['$http',function($http){

    //define data
    this.rpId;
    this.partName;











    //define out interface
    this.submit = function(title,addr,desc,userId,level,rpId,rpName){
      //返回可级联调用方法体promise
      var data = {'RTitle':title,'RAddr':addr,'RDes':desc,'UId':userId,'RLevel':level,'rpId':rpId,'rpName':rpName};
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






    //repair part  sestion
    this.getAllRepairParts = function(){
      return $http({ url:serverAddress+'/repairpart/getAllParts',
              method: 'post',
              headers: {'Content-Type': 'multipart/form-data'}
              });
    };




    //define setter and getter
    this.setrpId = function(rpId) {
      this.rpId = rpId;
    }
    this.setPartName = function(partName) {
      this.partName = partName;
    }

}])
