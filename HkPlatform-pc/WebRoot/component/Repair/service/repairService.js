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
  this.addPart = function(pName,pParts){
	  data = {
			  'pName': pName,
			  'pParts': pParts
        },
        transFn = function(data) {
            return $.param(data);
        },
        postCfg = {
            headers: { 'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'},
            transformRequest: transFn
        };

	  
        return $http.post(serverAddress+'/repairpart/addPart', data, postCfg);
	    
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
		    //return $http({url:serverAddress+'/repairpart/updatePartsContent',method: 'post',data,postCfg});
		    return $http.post(serverAddress+'/repairpart/updatePartsContent', data, postCfg);
	  }



  
}])
