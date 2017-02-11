app.controller("OrderListController",["OrderService",function(OrderService){
  var self = this;

  //define date
  self.curOrder;
  self.workList = [];
  self.pageNow  = 1;
  self.maxPage  = 1;
  self.pageSize = 10;
  self.pageNum =  [];
 //init data
getHworkListByStatusAndDate(self.pageNow,self.pageSize);


  //define out interface
  self.changePage = function(pageNow){
    self.pageNow = pageNow;
    getHworkListByStatusAndDate(self.pageNow,self.pageSize);
  }
  self.orderDetialShow = function(index)
	{


    self.curOrder =  self.workList[index];

		$('#orderDetialPanel').modal('show')

	}



  //define inter function
  function getHworkListByStatusAndDate(pageNow,pageSize){
    var promise = OrderService.getHworkListByStatusAndDate(pageNow,pageSize);
    promise.success(function(data,status,config,headers){
      console.log("OrderListController.getHworkListByStatusAndDate() success");
      console.log(data.data);
      self.workList = data.data;
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
