app.filter("UserStstusFilter",function(){
  return function(input){
    var output  =  "";

      switch (input) {
        case 11:
          output = "正常";
          break;
        case 12:
          output = "冻结";
          break;
        case 13:
          output = "删除";
          break;
        default:
          output = "错误";

      }
      return output;
  };
})
app.filter("UserTypeFilter",function(){
  return function(input){
    var output  =  "";

      switch (input) {
        case 1:
          output = "普通用户";
          break;
        case 2:
          output = "物业维修工";
          break;
        case 3:
          output = "家政工";
          break;
        default:
          output = "错误";

      }
      return output;
  };
})
