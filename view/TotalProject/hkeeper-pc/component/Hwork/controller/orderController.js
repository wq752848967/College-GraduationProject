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


// NOTE:  wa


app.controller("WorkerAuthenticationController",["WaService",function(WaService){
  var self = this;

  //define data
  self.waList;
  self.curWa;
  self.curUserInfo;
  //init
  getAllByDate();

  //define outer interface
  self.waDetialShow = function(index)
	{
    self.curWa =  self.waList[index];
    getWorkDetial(self.curWa.waUser);

		$('#waDetialPanel').modal('show')

	}
  self.refuseWorkerAu = function() {
      refuseWorkerAu(self.curWa.waId);
  }
  self.allowWorkerAu = function() {
      allowWorkerAu(self.curWa.waId);
  }



  //define inter function
  function getAllByDate(){
    var promise = WaService.getAllByDate();
    promise.success(function(data,status,config,headers){
      console.log("workerAuthentication.getAllByDate() success");
      self.waList = data.data;
      console.log(data.data);
    });
    promise.error(function(data,status,config,headers){
      alert("internet error,get data fail!");
    });

  }
  function getWorkDetial(wId){
    var  promise = WaService.getWorkDetial(wId);
    promise.success(function(data,status,config,headers){
      console.log("WaService.getWorkDetial: net success");
      //判断 是否成功
      var result = data.success;

      if(result){
        self.curUserInfo = data.data;
        console.log(data.data);
      }
      else{
        alert("服务器错误，获取信息失败");
      }

    });
    promise.error(function(data,status,config,headers){
      alert("internet error,get data fail!");
    });
  };

  function allowWorkerAu(waId){
    var  promise = WaService.allowWorkerAu(waId);
    promise.success(function(data,status,config,headers){
      console.log("WaService.allowWorkerAu: net success");
      //判断 是否成功
        var result = data.success;
        waDetialHide();
      if(result){
          alert("通过成功");

      }
      else{
        alert("服务器错误，获取信息失败");
      }

    });
    promise.error(function(data,status,config,headers){
      waDetialHide();
      alert("internet error,get data fail!");
    });
  };

  function refuseWorkerAu(waId){
    var  promise = WaService.refuseWorkerAu(waId);
    promise.success(function(data,status,config,headers){
      console.log("WaService.allowWorkerAu: net success");
      //判断 是否成功
        var result = data.success;
        waDetialHide();
      if(result){
          alert("拒绝成功");

      }
      else{
        alert("服务器错误，获取信息失败");
      }

    });
    promise.error(function(data,status,config,headers){
      waDetialHide();
      alert("internet error,get data fail!");
    });
  };
  function waDetialHide()
  {
    $('#waDetialPanel').modal('hide');

  }


}]);

app.controller("HkKindController",["WorkKindService",function(WorkKindService){
  var self = this;

  //define data
  self.KindsList;
  self.curData;
  self.curName;
  self.curType;
  //init

  getAllWorkKind();


  //outer interface
  self.addPanelShow = function(type){
    self.curType = type;
    $('#addPartPanel').modal('show');
  }

  self.addPanelHide = function(index){
    $('#addPartPanel').modal('hide');
  }
  self.deleteKind = function(kindId){
        deleteWorkKind(kindId);
  }
  self.addKind  = function(){
      addWorkKind(self.curType,self.curName);
  }


  //inter methods
  function getAllWorkKind(){
    var  promise = WorkKindService.getAllWorkKind();
    promise.success(function(data,status,config,headers){
      console.log("WorkKindService.getAllWorkKind: net success");
      //判断 是否成功
      var result = data.success;
      if(result){
          self.KindsList = data.data;
      }
      else{
        alert("服务器错误，获取信息失败");
      }

    });
    promise.error(function(data,status,config,headers){
      alert("internet error,get data fail!");
    });
  }

  function addWorkKind(kindType,kindName){
    var  promise = WorkKindService.addWorkKind(kindType,kindName);
    promise.success(function(data,status,config,headers){
      console.log("WorkKindService.getAllWorkKind: net success");
      //判断 是否成功
      addPanelHide();
      var result = data.success;
      if(result){
          alert("添加成功");
          getAllWorkKind();
      }
      else{
        alert("服务器错误，获取信息失败");
      }

    });
    promise.error(function(data,status,config,headers){
      addPanelHide();
      alert("internet error,get data fail!");
    });
  }


  function deleteWorkKind(kindId){
    var  promise = WorkKindService.deleteWorkKind(kindId);
    promise.success(function(data,status,config,headers){
      console.log("WorkKindService.deleteWorkKind: net success");
      //判断 是否成功

      var result = data.success;
      if(result){
          alert("删除成功");
          getAllWorkKind();
      }
      else{
        alert("服务器错误，获取信息失败");
      }

    });
    promise.error(function(data,status,config,headers){

      alert("internet error,get data fail!");
    });
  }

  function addPanelHide(){
    $('#addPartPanel').modal('hide');
  }
}]);
