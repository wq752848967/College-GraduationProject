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



//add part controller
app.controller("RepairPartManageController",["RepairPartManageService",function(RepairPartManageService){

  var self = this;
  //define data;
  self.partList = [];
  self.pName="";
  self.pPart="";
  self.addPartValue="";
  self.curParts = [];



  //init data
  getAllParts();


  //define out interface


  //显示 添加新报修项目面板
  self.addPanelShow = function()
  {
    //self.curOrder =  self.workList[index];
    self.pName="";
    self.pPart="";

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
    self.pPart=self.partList[index].rpParts;

    //划分part
    self.curParts = [];
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

      //提交数据
      saveRepairProject(self.pName,addPartList);
  }


  //define inter function


  function getAllParts(){
    var  promise = RepairPartManageService.getAllParts();
    promise.success(function(data,status,config,headers){
      console.log("RepairPartManageService.getAllParts success");
      console.log(data.data);
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
      $(".new-part").toggle();
      if(result){
        alert("添加成功");
      }
      else{
        alert("添加失败");
      }

    });
    promise.error(function(data,status,config,headers){
      alert("internet error,get data fail!");
    });
  };

  function updatePartProject(index,pId,pName,pParts,pStatus){
    var  promise = RepairPartManageService.updatePartProject(pId,pName,pParts,pStatus);
    promise.success(function(data,status,config,headers){
      console.log("RepairPartManageService.updatePartProject success");
      //判断 是否成功
      var result = data.success;

      if(result){
        alert("删除成功");

        //更新数据
        self.partList.splice(index,1);
      }
      else{
        alert("删除失败");
      }

    });
    promise.error(function(data,status,config,headers){
      alert("internet error,get data fail!");
    });
  }



}]);
