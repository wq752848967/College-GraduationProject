app.controller("RepairListController",["RepairListService",function(RepairListService){
  var self = this;

  //define date
  self.curRepair;
  self.repairList = [];
  self.pageNow  = 1;
  self.maxPage  = 1;
  self.pageSize = 10;
  self.pageNum =  [];
 //init data
getAllRepairByDate(self.pageNow,self.pageSize);


  //define out interface
  self.changePage = function(pageNow){
    self.pageNow = pageNow;
    getAllRepairByDate(self.pageNow,self.pageSize);
  }
  self.repairDetialShow = function(index)
	{


    //self.curOrder =  self.workList[index];

		$('#repairDetialPanel').modal('show')

	}



  //define inter function
  function getAllRepairByDate(pageNow,pageSize){
    var promise = RepairListService.getAllRepairByDate(pageNow,pageSize);
    promise.success(function(data,status,config,headers){
      console.log("RepairListController.getAllRepairByDate() success");
      console.log(data.data);
      self.repairList = data.data;
      self.PageNow = data.pageNow;
      self.maxPage = data.pageMax;

      self.pageNum = [];
      for(i=0;i<self.maxPage;i++){
        self.pageNum.push(i);
      }
    });
    promise.error(function(data,status,config,headers){
      alert("internet error,get data fail!");
    });

  }
}]);
