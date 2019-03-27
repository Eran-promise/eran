//JavaScript代码区域
  var i = 0;
  //左侧导航栏收缩功能动画效果
  $('#LAY_app_flexible').click(function(){
  	//这里定义一个全局变量来方便判断动画收缩的效果,也就是放在最外面
  	if(i==0){
  		$(".layui-side").animate({width:0});
  		$(".layui-logo").animate({width:0}).html("");
  		$(".layui-body").animate({left:'0px'});			
  		$(".layui-footer").animate({left:'0px'});
  		$(".temp").animate({left:'0px'});
  		$(this).addClass("layui-icon-spread-left").removeClass("layui-icon-shrink-right");
  		i++;
  	}else{
  		$(".layui-side").animate({width:200});
  		$(".layui-logo").animate({width:200}).html("Layui Admin");
  		$(".layui-body").animate({left:'200px'});
  		$(".layui-footer").animate({left:'200px'});
  		$(".temp").animate({left:'200px'});
  		$(this).removeClass("layui-icon-spread-left").addClass("layui-icon-shrink-right");
  		i--;
  	}
  });
