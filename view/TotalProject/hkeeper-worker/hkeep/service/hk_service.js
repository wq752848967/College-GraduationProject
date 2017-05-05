app.service('HworksService',['$http',function($http){
    this.dataList;
    this.curDetialId;
    this.hwId;
    this.userId = "USER133";
    this.getHworks = function()
    {

      var postCfg = {
                         headers: { 'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'}
                    };
      return $http({url:serverAddress+'/hwork/getHworkList',method: 'post'});
    }
    this.getDetial =  function(hwId)
    {

        var curHwork;
        this.hwId = hwId;
        return $http({ url:serverAddress+'/hworkapply/getApplyHworkDetial',
                method: 'post',
                headers: {'Content-Type': 'multipart/form-data'},
                params:{ 'hwId':hwId}});

    }
    //申请订单
    this.applyHwork = function(){
      return $http({ url:serverAddress+'/hworkapply/applyHwork',
              method: 'post',
              headers: {'Content-Type': 'multipart/form-data'},
              params:{ 'hwId':this.hwId,'UId':this.userId}});
    }
    //完成订单
    this.completeHwork = function(){
      return $http({ url:serverAddress+'/orders/completeHwork',
              method: 'post',
              headers: {'Content-Type': 'multipart/form-data'},
              params:{ 'hwId':this.hwId}});
    }



    //收藏
    this.collectHkwork = function(){
      return $http({ url:serverAddress+'/hkCollection/collect',
              method: 'post',
              headers: {'Content-Type': 'multipart/form-data'},
              params:{ 'hwId':this.hwId,'UId':this.userId}});
    }
    this.getOrderList  = function(){
      return $http({ url:serverAddress+'/hwork/getHworkByOrder',
              method: 'post',
              headers: {'Content-Type': 'multipart/form-data'}
              });
    }

}]);
