app.filter("TypeFilter"function(){
  return function(input){
    var output  =  "";

      switch (input) {
        case "210":
          output = "申请中";
          break;
        case "211":
          output = "服务中";
          break;
        case "212":
          output = "待评价";
          break;
          case "213":
          output = "已完成";
            break;
        default:
          output = "错误";

      }
      return output;
  };
})
