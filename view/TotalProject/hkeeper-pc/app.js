
var serverAddress="http://127.0.0.1:8080/HkPlatform-pc";
var app  = angular.module('hkeeper-pc',['ui.router']);

app.config(function($stateProvider,$urlRouterProvider){
  $urlRouterProvider.when("", "/total");
  $stateProvider
        .state("hkOrderList", {
            url: "/hkOrderList",
            templateUrl: "component/Hwork/hworkList.html",
            controller:"OrderListController as orderListCon"
        })
        .state("repairList",{
          url:"/repairList",
          templateUrl:"component/Repair/repairList.html",
          controller:"RepairListController as repairListCon"
        })
        .state("repairPartManage",{
          url:"/repairPartManage",
          templateUrl:"component/Repair/repairPartManage.html",
          controller:"RepairListController as repairListCon"
        })
});
