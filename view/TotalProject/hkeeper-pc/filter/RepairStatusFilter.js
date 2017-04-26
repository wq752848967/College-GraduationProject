app.filter("RepairStatusFilter",function(){
  return function(input){
    var output  =  "";

      switch (input) {
        case 311:
          output = "待审核";
          break;
        case 312:
          output = "待服务";
          break;
        case 313:
          output = "维修中";
          break;
        case 314:
          output = "维修完毕";
            break;
        case 315:
          output = "物业拒绝维修";
            break;
        case 316:
          output = "维修人员拒绝维修";
                break;
        default:
          output = "错误";

      }
      return output;
  };
})

app.filter("RepairLevelFilter",function(){
  return function(input){
    var output  =  "";

      switch (input) {
        case 1:
          output = "正常";
          break;
        case 2:
          output = "稍高";
          break;
        case 3:
          output = "较高";
          break;
        case 0:
          output = "停止";
            break;
        default:
          output = "错误";

      }
      return output;
  };
})


app.filter("RepairRTypeFilter",function(){
  return function(input){
    var output  =  "";

      switch (input) {
        case 1:
          output = "保洁";
          break;
        case 2:
          output = "电工";
          break;
        case 3:
          output = "管道";
          break;
        default:
          output = "错误";

      }
      return output;
  };
})


app.filter("RepairStatusFilter_short",function(){
  return function(input){
    var output  =  "";

      switch (input) {
        case 311:
          output = "待审核";
          break;
        case 312:
          output = "服务中";
          break;
        case 313:
          output = "维修中";
          break;
        case 314:
          output = "维修完";
            break;
        case 315:
          output = "拒绝";
            break;
        case 316:
          output = "拒绝";
                break;
        default:
          output = "错误";

      }
      return output;
  };
})
