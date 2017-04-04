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
					alert("发布成功");
					document.location="../index.html";
			});
			promiseResult.error(function(data,status,config,headers){
					alert("发布失败");
					document.location="../index.html";
			});
	}
}])




//   订单历史 详情 controller
app.controller('HworksHistoryController',['HKeepApplyService','$window',function(HKeepApplyService,$window){
	var self = this;
	self.Uid = "USER12345678121212";
	self.dataList;
	self.curOrderId="";
	self.commentContent="";

	//初始化
	var promise = HKeepApplyService.getList(self.Uid);
	promise.success(function(data,status,config,headers){
		self.dataList = data.data;
		console.log(data.data);
	});
	promise.error(function(data,status,config,headers){
		   console.log("HKeepApplyService.getList(Uid) error");
	});
	//初始化评论面板
	var num=finalnum = tempnum= 0;
	var lis = $('.star-ul').children();

	for (var i = 1; i <= lis.length; i++) {
	 lis[i - 1].index = i;
	 lis[i - 1].onmouseover = function() { //鼠标经过点亮星星。
	  fnShow(this.index);//传入的值为正，就是finalnum
	 }
	 lis[i - 1].onmouseout = function() { //鼠标离开时星星变暗
	  fnShow(0);//传入值为0，finalnum为tempnum,初始为0
	 }
	 lis[i - 1].onclick = function() { //鼠标点击,同时会调用onmouseout,改变tempnum值点亮星星
	  tempnum= this.index;
	 }
	}






	//定义相关方法
	self.historyDetial = function(hwId){
		  $window.location.href="hk_order_Detial.html?hwId="+hwId;
	}
	self.showCommentPanel = function(orderId){
		self.curOrderId = orderId;
		showCommentPanel(1);
	}
	self.submitComment = function(){
		//finalnum self.curOrderId self.commentContent
		var promise = HKeepApplyService.submitComment(self.curOrderId,self.commentContent,finalnum);
		promise.success(function(data,status,config,headers){
			showCommentPanel(1);
			finalnum = 0;
			fnShow(0);
			self.commentContent = "";
			var result = data.success;
			if(result){
					alert("提交成功");
			}
			else{
					alert("数据错误，提交失败");
			}

		});
		promise.error(function(data,status,config,headers){
			showCommentPanel(1);
			alert("网络错误，提交失败");
		});

	}


  //定义内部方法
	function showCommentPanel(flag){
		$('.commentPanel').toggleClass('showComment');
	}
	//num:传入点亮星星的个数
	//finalnum:最终点亮星星的个数
	//tempnum:一个中间值
	function fnShow(num) {
	 finalnum= num || tempnum;//如果传入的num为0，则finalnum取tempnum的值
	 for (var i = 0; i < lis.length; i++) {
		lis[i].className = i < finalnum? "light" : "";//点亮星星就是加class为light的样式
	 }
	}

}]);





//历史订单详情
app.controller('HworksDetialController',['HKeepApplyService','$window',function(HKeepApplyService,$window){


	var self = this;
	self.detial;
	self.curOrderId;
	//获取wid
	var reg = new RegExp("(^|&)" + "hwId" + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
	var r = window.location.search.substr(1).match(reg);  //匹配目标参数
	var hwId  =  unescape(r[2]);


	//初始化操作
	//调用service 获取相关信息
	var promise = HKeepApplyService.getDetial(hwId);
	promise.success(function(data,status,config,headers){
			console.log("HKeepApplyService.getdetial success");
			self.detial = data.data;
			console.log(data.data);
	});
	promise.error(function(data,status,config,headers){
			console.log("HKeepApplyService.getdetial error");
	});
	//初始化评论面板
	var num=finalnum = tempnum= 0;
	var lis = $('.star-ul').children();

	for (var i = 1; i <= lis.length; i++) {
	 lis[i - 1].index = i;
	 lis[i - 1].onmouseover = function() { //鼠标经过点亮星星。
	  fnShow(this.index);//传入的值为正，就是finalnum
	 }
	 lis[i - 1].onmouseout = function() { //鼠标离开时星星变暗
	  fnShow(0);//传入值为0，finalnum为tempnum,初始为0
	 }
	 lis[i - 1].onclick = function() { //鼠标点击,同时会调用onmouseout,改变tempnum值点亮星星
	  tempnum= this.index;
	 }
	}








  //定制方法
	self.workDetial  = function(wId){
		$window.location.href="../per/works.html?wId="+wId+"&hwId="+hwId;
	}
	self.showCommentPanel = function(orderId){
		self.curOrderId = orderId;
		showCommentPanel(1);
	}
	self.submitComment = function(){
		//finalnum self.curOrderId self.commentContent
		var promise = HKeepApplyService.submitComment(self.curOrderId,self.commentContent,finalnum);
		promise.success(function(data,status,config,headers){
			showCommentPanel(1);
			finalnum = 0;
			fnShow(0);
			self.commentContent = "";
			var result = data.success;
			if(result){
					alert("提交成功");
			}
			else{
					alert("数据错误，提交失败");
			}

		});
		promise.error(function(data,status,config,headers){
			showCommentPanel(1);
			alert("网络错误，提交失败");
		});

	}





	//定义内部方法

	function showCommentPanel(flag){
		$('.commentPanel').toggleClass('showComment');
		$('#commentBtn').toggle();
	}
	//num:传入点亮星星的个数
	//finalnum:最终点亮星星的个数
	//tempnum:一个中间值
	function fnShow(num) {
	 finalnum= num || tempnum;//如果传入的num为0，则finalnum取tempnum的值
	 for (var i = 0; i < lis.length; i++) {
		lis[i].className = i < finalnum? "light" : "";//点亮星星就是加class为light的样式
	 }
	}

}]);


app.controller("HwKindController",['WorkKindService','$window',function(WorkKindService,$window){

  var self = this;
  self.sweapList = [];
	self.careList = [];
	self.repairList = [];
	self.otherList= [];
  self.index;
	initKind();


	self.selectKind = function(kind,dkind){
			$window.location.href="./hk_order.html?type="+kind+"&dtype="+dkind;
	}

	function initKind(){
		var promise = WorkKindService.getAllWorkKind();
		promise.success(function(data,status,config,headers){

			var result = data.success;
			if(result){
					self.sweapList = data.data.sweapList;
					self.careList = data.data.careList;
					self.repairList  = data.data.repairList;
					self.otherList = data.data.otherList;
					console.log(data.data);
			}
			else{
					alert("数据错误");
			}

		});
		promise.error(function(data,status,config,headers){
			showCommentPanel(1);
			alert("网络错误，提交失败");
		});
	}



}]);
