app.controller("AdminController",["AdminService","$window",function(AdminService,$window){

  var self = this;
  //define data
  self.adminName;
  self.adminPsw;



  //define outer interface
  self.login = function(){
    login(self.adminName,self.adminPsw);
  }


  //define inter methods
  function login(adminName,adminPsw){
    var promise  = AdminService.login(adminName,adminPsw);
    promise.success(function(data,status,config,headers){
        console.log("login:net ok");
        var login_success = data.success;
        if(login_success==true){
            $window.location.href="index.html";
        }
        else{
          var fail_msg = data.message;
          alert("登录失败："+fail_msg);
        }
    });
    promise.error(function(data,status,config,headers){

    });
  }
}]);
app.controller("AdminManageController",["AdminService",function(AdminService){
  var self = this;


  //define data
  self.adminList;
  self.addName;
  self.addAdminAcount;
  self.addPsw;
  self.curAdmin;
  self.filterName;



  //init data
  getAllAdmin();



  //define outer interface
  self.addAdmin  = function(){
    addAdmin(self.addName,self.addAdminAcount,self.addPsw);
  }
  self.orderDetialShow = function(index)
  {
    self.curAdmin =  self.adminList[index];

    $('#orderDetialPanel').modal('show')

  }
  self.updateAdmin = function(type){

      var promise  = AdminService.updateAdminStstus(self.curAdmin.uid,type);
      promise.success(function(data,status,config,headers){
          console.log("updateAdmin  :net ok");
            $('#orderDetialPanel').modal('hide')
          var login_success = data.success;
          if(login_success==true){
              alert("修改成功");

              getAllAdmin();
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

  //define inter methods
  function addAdmin(name,acount,psw){
    var promise  = AdminService.addAdmin(name,acount,psw);
    promise.success(function(data,status,config,headers){
        console.log("add admin :net ok");
        var login_success = data.success;
        if(login_success==true){
            alert("添加成功");
            getAllAdmin();
        }
        else{
          var fail_msg = data.message;
          alert("获取失败："+fail_msg);
        }
    });
    promise.error(function(data,status,config,headers){
        console.log("get admin :net error");
        alert("获取失败 net error");
    });
  }
  function getAllAdmin(){
    var promise  = AdminService.getAllAdmin();
    promise.success(function(data,status,config,headers){
        console.log("get admin :net ok");
        var login_success = data.success;
        if(login_success==true){
            self.adminList = data.data;
        }
        else{
          var fail_msg = data.message;
          alert("获取失败："+fail_msg);
        }
    });
    promise.error(function(data,status,config,headers){
        console.log("get admin :net error");
        alert("获取失败 net error");
    });
  }

}])
