// JavaScript Document
//初始化操作
app.controller('submitOrderController',['HKeepService',function(HKeepService){
	var self = this;
	//初始化数据
	self.hwTitle="";
	self.hwMoney;
	self.hwDate;
	self.hwTime;
	self.hwAddr;
	self.hwDesc;
	self.hwTypeCode;
	self.hwDTypeCode;
	self.hwPubUId = "USERtest";

	console.log("test:"+wId);
	//获取一下url中的数据
	var reg = new RegExp("(^|&)" + "type" + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
	var r = window.location.search.substr(1).match(reg);  //匹配目标参数
	var type  =  unescape(r[2]);
	self.hwTypeCode = type;
	var dreg = new RegExp("(^|&)" + "dtype" + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
	var dr = window.location.search.substr(1).match(dreg);  //匹配目标参数
	var dtype  =  unescape(dr[2]);
	self.hwDTypeCode = dtype;

	self.submitHwork = function()
	{
	    self.hwDate = $("#orderTime").val();
			var promiseResult = HKeepService.submit(self.hwPubUId,self.hwTitle,self.hwMoney,self.hwDate,	self.hwTime,	self.hwAddr,self.hwDesc,	self.hwTypeCode,self.hwDTypeCode);
			promiseResult.success(function(data,status,config,headers){
					console.log("submit ok");
			});
			promiseResult.error(function(data,status,config,headers){
					 console.log("submit error");
			});
	}
}])




//   订单历史 详情 controller
app.controller('HworksHistoryController',['HKeepApplyService','$window',function(HKeepApplyService,$window){
	var self = this;
	self.Uid = "USER12345678121212";
	self.dataList;
	var promise = HKeepApplyService.getList(self.Uid);
	promise.success(function(data,status,config,headers){
		self.dataList = data.data;
	});
	promise.error(function(data,status,config,headers){
		   console.log("HKeepApplyService.getList(Uid) error");
	});



	//定义相关方法
	self.historyDetial = function(hwId){
		  $window.location.href="hk_order_Detial.html?hwId="+hwId;
	}

}]);


//历史订单详情
app.controller('HworksDetialController',['HKeepApplyService','$window',function(HKeepApplyService,$window){


	var self = this;
	self.detial;
	//获取wid
	var reg = new RegExp("(^|&)" + "hwId" + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
	var r = window.location.search.substr(1).match(reg);  //匹配目标参数
	var hwId  =  unescape(r[2]);

	//调用service 获取相关信息
	var promise = HKeepApplyService.getDetial(hwId);
	promise.success(function(data,status,config,headers){
			console.log("HKeepApplyService.getdetial success");
			self.detial = data.data;
	});
	promise.error(function(data,status,config,headers){
			console.log("HKeepApplyService.getdetial error");
	});

  //定制方法
	self.workDetial  = function(wId){
		$window.location.href="../per/works.html?wId="+wId+"&hwId="+hwId;
	}

}]);
