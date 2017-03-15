
var serverAddress="http://127.0.0.1:8080/HkPlatform-pc";
var app  = angular.module('hkeeper-pc',['ui.router']);

app.config(function($stateProvider,$urlRouterProvider){
  $urlRouterProvider.when("", "/total");
  $stateProvider
        .state("addHkOrder", {        //新建订单
            url: "/addHkOrder",
            templateUrl: "component/Hwork/AddHkOrder.html",
            controller:"AddHkOrderController as addOrderCon"
          })
        .state("hkOrderList", {
            url: "/hkOrderList",
            templateUrl: "component/Hwork/hworkList.html",
            controller:"OrderListController as orderListCon"
        })
        .state("workKind",{     //家政分类
          url:"/workKind",
          templateUrl:"component/Hwork/HkKinds.html",
          controller:"HkKindController as hkKindCon"
        })
        .state("workerAuthentication",{     //员工申请认证
          url:"/workerAuthentication",
          templateUrl:"component/Hwork/workerAuthentication.html",
          controller:"WorkerAuthenticationController as workerAuthenticationCon"
        })
        .state("repairList",{
          url:"/repairList",
          templateUrl:"component/Repair/repairList.html",
          controller:"RepairListController as repairListCon"
        })
        .state("repairKind",{
          url:"/repairKind",
          templateUrl:"component/Repair/repairKind.html",
          controller:"RepairKindController as repairKindCon"
        })
        .state("repairWork",{
          url:"/repairWork",
          templateUrl:"component/Repair/repairWork.html",
          controller:"RepairWorkController as repairWorkCon"
        })
        .state("repairDispatcher",{
          url:"/repairDispatcher",
          templateUrl:"component/Repair/repairDisPatcherManage.html",
          controller:"RepairDispatcherController as repairDispatcherCon"
        })
        .state("repairPartManage",{
          url:"/repairPartManage",
          templateUrl:"component/Repair/repairPartManage.html",
          controller:"RepairPartManageController as repairPartCon"
        })
        .state("adminManage",{
          url:"/adminManage",
          templateUrl:"component/Admin/AdminManage.html",
          controller:"AdminManageController as adminManageCon"
        })
});
