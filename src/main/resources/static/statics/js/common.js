  //=======================================================================================
  //============================项目框架需要的方法=========================================
  //=======================================================================================
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
  
  /**
   * 显示当前页面对应的导航栏以及左侧菜单
   * @param link
   * @returns
   */
  function showSideAndNav(link){
	  var nav_link = link.substring(0,3);
	  //选中当前导航栏
	  $(".layui-header ."+nav_link).addClass("layui-this");
	  //显示当前导航栏对应的左侧菜单栏
	  $(".layui-side ."+nav_link).removeClass("layui-hide");
	  $(".layui-side ul").not("."+nav_link).addClass("layui-hide");
	  $("."+link).parent().parent().addClass("layui-nav-itemed");
	  $("."+link).addClass("layui-this");
  }  
  
  
  //=======================================================================================
  //============================定义项目需要的格式化对象===================================
  //=======================================================================================
  var lockedTemplet = {"0":"未锁定","1":"已锁定"};
