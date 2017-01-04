app.service("RepairService",["$http",function($http){

  this.getRepairWorkInfo = function(){
    return $http({ url:serverAddress+'/repairInfo/getAll',
            method: 'post',
            headers: {'Content-Type': 'multipart/form-data'}
            });
  }
  this.getRepair = function(repairType){
    return $http({ url:serverAddress+'/repair/getRepair',
            method: 'post',
            headers: {'Content-Type': 'multipart/form-data'},
            params:{ 'repairType':repairType}
            });
  }
  //获取用户类型  用来判断获取任务的类型
  this.getWorkType = function(){
    return $http({ url:serverAddress+'/user/getUserType',
            method: 'post',
            headers: {'Content-Type': 'multipart/form-data'}
            });
  }
  //获取历史订单
  this.getOrderHistory = function(){
    return $http({ url:serverAddress+'/repair/getRepairOrder',
            method: 'post',
            headers: {'Content-Type': 'multipart/form-data'}
            });
  };
}])
