angular.module('hkeep_user')
.service('RepairService',['$http',function($http){

    //define data
    this.rpId;
    this.partName;











    //define out interface
    this.getRepairServiceInfo  = function(rId){
      return $http({ url:serverAddress+'/repair/getRepairServiceInfo',
            method: 'post',
            headers: {'Content-Type': 'multipart/form-data'},
            params:{ 'rId':rId}
            });
      }
    this.submit = function(title,addr,desc,userId,level,rpId,rpName,rpKind){
      //返回可级联调用方法体promise
      var data = {'RTitle':title,'RAddr':addr,'RDes':desc,
                  'UId':userId,'RLevel':level,'rpId':rpId,'rpName':rpName,
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
    //获取历史订单
    this.getOrderHistory = function(){
      return $http({ url:serverAddress+'/repair/getRepairOrder',
              method: 'post',
              headers: {'Content-Type': 'multipart/form-data'}
              });
    };

    this.uploadFile = function(rId,file){

        return $http({
            method:'POST',
            url: serverAddress+'/repair/uploadPic',
            headers: {
                'Content-Type': undefined
            },
            data: {
                "rId":rId,
                "file":file
            },
            transformRequest: function(data,headersGetter){
                       var formData = new FormData();
                              angular.forEach(data, function (value, key) {
                              formData.append(key, value);
                       });
               return formData;
            }
          })
      }





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
