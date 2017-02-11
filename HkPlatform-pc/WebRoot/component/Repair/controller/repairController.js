app.controller("RepairListController",["RepairListService",function(RepairListService){
  var self = this;

  //define date
  self.curRepair;
  self.repairList = [];
  self.pageNow  = 1;
  self.maxPage  = 1;
  self.pageSize = 10;
  self.pageNum =  [];
  self.curRepairService;
 //init data
getAllRepairByDate(self.pageNow,self.pageSize);


  //define out interface
  self.changePage = function(pageNow){
    self.pageNow = pageNow;
    getAllRepairByDate(self.pageNow,self.pageSize);
  }
  self.repairDetialShow = function(index)
	{
    self.curRepair =  self.repairList[index];
    if(self.curRepair.rstatusCode>=313){
      //请求其他数据
      getRepairServiceInfo(self.curRepair.rid,self.curRepair.uid);
    }
		$('#repairDetialPanel').modal('show');

	}
  self.allow = function(){
    allow(self.curRepair.rid);
  }
  self.refuse = function(){
    refuse(self.curRepair.rid);
  }



  //define inter function
  function getAllRepairByDate(pageNow,pageSize){
    var promise = RepairListService.getAllRepairByDate(pageNow,pageSize);
    promise.success(function(data,status,config,headers){
      console.log("RepairListController.getAllRepairByDate() success");

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

  function allow(rId){
    var promise = RepairListService.allow(rId);
    promise.success(function(data,status,config,headers){
      console.log("RepairListController.allow() success");
      alert("更改成功");
      $('#repairDetialPanel').modal('hide');
      getAllRepairByDate(self.pageNow,self.pageSize);
    });
    promise.error(function(data,status,config,headers){
      $('#repairDetialPanel').modal('hide');
      alert("internet error,get data fail!");

    });
  }

  function refuse(rId){
    var promise = RepairListService.refuse(rId);
    promise.success(function(data,status,config,headers){
      console.log("RepairListController.allow() success");
      alert("更改成功");
      $('#repairDetialPanel').modal('hide');
      getAllRepairByDate(self.pageNow,self.pageSize);
    });
    promise.error(function(data,status,config,headers){
      $('#repairDetialPanel').modal('hide');
      alert("internet error,get data fail!");

    });
  }
  function getRepairServiceInfo(rId,uId){
    var promise = RepairListService.getRepairServiceInfo(rId,uId);
    promise.success(function(data,status,config,headers){
      console.log("RepairListController.getRepairServiceInfo() success");
      self.curRepairService = data.data;
      console.log(data.data);

    });
    promise.error(function(data,status,config,headers){

      alert("internet error,get data fail!");

    });
  }


}]);



//add part controller
app.controller("RepairPartManageController",["RepairPartManageService",function(RepairPartManageService){

  var self = this;
  //define data;
  self.partList = [];
  self.pName="";
  self.pPart="";
  self.addPartValue="";
  self.curParts = [];
  self.addFlag =  false;
  self.curIndex  = 0;

  //init data
  getAllParts();


  //define out interface


  //显示 添加新报修项目面板
  self.addPanelShow = function()
  {
    //self.curOrder =  self.workList[index];
    self.pName="";
    self.pPart="";
    self.addFlag = true;
    self.curParts = [];
    $('#addPartPanel').modal('show');

  }
  //显示 隐藏 添加新报修项目输入框
  self.addPartInputShow = function(){
    $(".new-part").toggle();
  }
   //添加一个新的报修部位
  self.addPerPart = function(){

    self.curParts.push(self.addPartValue);
    $(".new-part").toggle();
    self.addPartValue="";
  }

  //删除 partProject
  self.deletePartProject = function(index){
    updatePartProject(index,self.partList[index].rpId,self.partList[index].rpName,self.partList[index].rpParts,2);
  }

  //编辑 partProject
  self.editPartProject = function(index){
    self.pName=self.partList[index].rpName;
    self.addFlag = false;
    self.curIndex = index;

    //划分part
    self.curParts = [];
    var partArr = self.partList[index].rpParts.split("、");
    self.curParts = partArr;
    $('#addPartPanel').modal('show');
  }


  //提交数据
  self.saveAddPart = function(){
      //验证数据
      var addPartList = "";
      var isFirst = true;
      $(".perPart").each(function(){
        if(isFirst){
          addPartList = addPartList+$(this).text();
          isFirst = false;
        }
        else{
          addPartList = addPartList+"、"+ $(this).text();
        }


      });

      if(self.addFlag){
        //提交数据
        saveRepairProject(self.pName,addPartList);

      }
      else{
        //更新数据
        updatePartProject(self.curIndex,self.partList[self.curIndex].rpId,self.pName,addPartList,1);
      }

  }


  //define inter function


  function getAllParts(){
    var  promise = RepairPartManageService.getAllParts();
    promise.success(function(data,status,config,headers){
      console.log("RepairPartManageService.getAllParts success");

      self.partList = data.data;

    });
    promise.error(function(data,status,config,headers){
      alert("internet error,get data fail!");
    });
  };


  function saveRepairProject(pName,pParts){
    var  promise = RepairPartManageService.addPart(pName,pParts);
    promise.success(function(data,status,config,headers){
      console.log("RepairPartManageService.addPart success");
      //判断 是否成功
      var result = data.success;
      $('#addPartPanel').modal('hide');
      if(result){
        alert("添加成功");
      }
      else{
        alert("添加失败");
      }
      getAllParts();
    });
    promise.error(function(data,status,config,headers){
      $('#addPartPanel').modal('hide');
      alert("internet error,get data fail!");
    });
  };

  function updatePartProject(index,pId,pName,pParts,pStatus){
    var  promise = RepairPartManageService.updatePartProject(pId,pName,pParts,pStatus);
    promise.success(function(data,status,config,headers){
      console.log("RepairPartManageService.updatePartProject success");
      //判断 是否成功
      var result = data.success;
      $('#addPartPanel').modal('hide');
      if(result){
        alert("修改成功");

        //更新数据
        self.partList.splice(index,1);
      }
      else{
        alert("修改失败");
      }
      getAllParts();
    });
    promise.error(function(data,status,config,headers){
      alert("修改失败，网络错误!");
    });
  }



}]);
