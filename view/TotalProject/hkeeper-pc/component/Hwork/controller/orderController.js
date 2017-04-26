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
          getAllByDate();
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
          getAllByDate();
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


app.controller("AddHkOrderController",["WorkKindService","OrderService",function(WorkKindService,OrderService){
  var self = this;

  //define data
  self.kindList;
  self.dTypeCode;
  self.kindType = 0;
  self.userPhone;
  self.title;
  self.money;
  self.date;
  self.time;
  self.add;
  self.desc;
  //init


  //outer interface
  self.getKindByType = function() {
    if(self.kindType>0){
        getKindByType(self.kindType);
    }

  }
  self.submit =  function(){
    submitOrder(self.userPhone,self.title,self.money,self.date,self.time,self.add,self.desc,self.kindType,self.dTypeCode);
  }

  //interface
  function submitOrder(userPhone,title,money,date,time,add,desc,typeCode,dTypeCode){
    var  promise = OrderService.submit(userPhone,title,money,date,time,add,desc,typeCode,dTypeCode);
    promise.success(function(data,status,config,headers){
      console.log("OrderService.submit: net success");
      //判断 是否成功

      var result = data.success;
      if(result){
        alert("添加成功！");
      }
      else{
        alert("服务器错误，获取种类信息失败，请刷新！"+data.message);
      }

    });
    promise.error(function(data,status,config,headers){

      alert("internet error,get data fail!");
    });
  }
  function getKindByType(kindType){
    var  promise = WorkKindService.getWorkKindByType(kindType);
    promise.success(function(data,status,config,headers){
      console.log("WorkKindService.getWorkKindByType: net success");
      //判断 是否成功

      var result = data.success;
      if(result){
        self.kindList =  data.data;
        console.log(data.data);
      }
      else{
        alert("服务器错误，获取种类信息失败，请刷新！");
      }

    });
    promise.error(function(data,status,config,headers){

      alert("internet error,get data fail!");
    });
  }
}]);
app.controller("WorkerManagerController",["WorkerManagerService","AdminService",function(WorkerManagerService,AdminService){
  var self = this;
  self.workerList;
  self.pageNow = 1;
  self.pageMax;
  self.pageNum = [];
  self.pageSize=10;
  self.isFilter = 1;
  self.wName = "";
  self.bCompany = "";
  self.hwType=0;
  self.curWorker;
  self.workerDetial;
  var wName;
  var bCompany;
  //init data
  getHkWorkersByFilter(self.pageNow,self.pageSize,self.isFilter,self.wName,self.bCompany,self.hwType);

   //define outer interface
   self.workerDetialShow  = function(index){

      self.curWorker = self.workerList[index];
       getWorkerDetial(self.curWorker.user.uid);
      $('#workerPanel').modal('show')
   }
   self.prohibitUser = function(uId){
     updateUserStatus(uId,2);
   }
   self.nomalUser = function(uId){
     updateUserStatus(uId,1);
   }
   self.deleteUser = function(uId,wId){
     deleteHkWorker(uId,wId);
   }
   self.changePage = function(page){
      self.pageNow = page;
       getHkWorkersByFilter(self.pageNow,self.pageSize,self.isFilter,wName,bCompany,self.hwType);
   }
   self.showAllWorker = function(){
     self.pageNow = 1;
     self.isFilter = 1;
     self.wName = "";
     self.bCompany = "";
     self.hwType=0;
     getHkWorkersByFilter(self.pageNow,self.pageSize,self.isFilter,self.wName,self.bCompany,self.hwType);
   }
   self.filterSearch = function(){
     self.pageNow = 1;
     self.isFilter = 2;
     var wName = self.wName;
     var bCompany = self.bCompany;
     if(self.wName.length==0){
       wName = "0";
     }
     if(self.bCompany.length==0){
       bCompany = "0";
     }
     getHkWorkersByFilter(self.pageNow,self.pageSize,self.isFilter,wName,bCompany,self.hwType);
   }



  //define inter method
  function getWorkerDetial(uId){
    var promise = WorkerManagerService.getWorkDetial(uId);

    promise.success(function(data,status,config,headers){
      self.workerDetial = data.data;
        console.log(data.data);
        console.log("success WorkDetialController.getWorkDetial");

    });
    promise.error(function(data,status,config,headers){
       console.log("error WorkDetialController.getWorkDetial");
    });
  }
  function deleteHkWorker(uId,wId){
    var promise  = WorkerManagerService.deleteHkWorker(uId,wId);
    promise.success(function(data,status,config,headers){

        $('#workerPanel').modal('hide')
        var login_success = data.success;
        if(login_success==true){
            alert("删除成功");
             getHkWorkersByFilter(self.pageNow,self.pageSize,self.isFilter,wName,bCompany,self.hwType);
        }
        else{
          var fail_msg = data.message;
          alert("获取失败："+fail_msg);
        }
    });
    promise.error(function(data,status,config,headers){
        $('#orderDetialPanel').modal('hide')
        console.log("get admin :net error");
        alert("获取失败 net error");
    });
  }
  function updateUserStatus(uId,type){
    var promise  = AdminService.updateAdminStstus(uId,type);
    promise.success(function(data,status,config,headers){

        $('#workerPanel').modal('hide')
        var login_success = data.success;
        if(login_success==true){
            alert("修改成功");
             getHkWorkersByFilter(self.pageNow,self.pageSize,self.isFilter,wName,bCompany,self.hwType);

        }
        else{
          var fail_msg = data.message;
          alert("获取失败："+fail_msg);
        }
    });
    promise.error(function(data,status,config,headers){
        $('#orderDetialPanel').modal('hide')
        console.log("get admin :net error");
        alert("获取失败 net error");
    });
  }
  function getHkWorkersByFilter(pageNow,pageSize,isFilter,wName,bCompany,hwType){
    var  promise = WorkerManagerService.getHkWorkersByFilter(pageNow,pageSize,isFilter,wName,bCompany,hwType);
    promise.success(function(data,status,config,headers){
      console.log("WorkerManagerService.getHkWorkersByFilter: net success");
      //判断 是否成功
      console.log(data.data);
      var result = data.success;
      if(result){
        self.workerList =  data.data;
        self.pageNow = data.pageNow;
        self.pageMax = data.pageMax;

        self.pageNum = [];
        for(i=0;i<self.pageMax;i++){
          self.pageNum.push(i);
        }
      }
      else{
        alert("服务器错误，获取种类信息失败，请重试！");
      }

    });
    promise.error(function(data,status,config,headers){
      alert("internet error,get data fail!");
    });
  }
}]);
