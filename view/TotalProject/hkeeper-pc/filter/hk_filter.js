app.filter("hworkStatusFilter",function(){
  return function(input){
    var output  =  "";

      switch (input) {
        case 210:
         output = "申请中";
         break;
       case 211:
         output = "服务中";
         break;
       case 212:
         output = "待评价";
         break;
         case 213:
         output = "已完成";
           break;
      case 214:
           output = "已付款";
             break;
        default:
          output = "错误";

      }
      return output;
  };
});
app.filter("hworkTypeFilter",function(){
  return function(input){
    var output  =  "";

      switch (input) {
        case 201:
         output = "清洁";
         break;
       case 202:
         output = "保姆";
         break;
       case 203:
         output = "维修";
         break;
       case 204:
         output = "已完成";
           break;
        default:
          output = "未知";

      }
      return output;
  };
});
