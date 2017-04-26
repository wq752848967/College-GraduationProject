//server ip
var serverAddress="http://127.0.0.1:8080/HkPlatform";

var picAddress="http://127.0.0.1:8080/hkeeper-user/images/repair/"
//test ip
//var serverAddress = "http://192.168.191.1:8080/HkPlatform";


//实例化一个app
var app = angular.module('hkeep_user',['ngFileUpload']);



//全局变量
app.value("wId","123");
//router
