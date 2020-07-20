/**
 * 
 */
//书名验证
//失去焦点事件
$("#bname").blur (function(){
	//获取书名
	var bname = $("#bname").val();
	
	//判空
	if(bname == '' ){
		console.log("书本名称不能为空");
		//给当前对象的下一个标签设值
		$("#bname").next().html("书本名称不能为空");
		//未设值前该标签是隐藏的  此时就必须显示来
		$("#bname").next().show();
	}
});

//聚焦事件
$("#bname").focus(function(){
	//隐藏
	$(this).next().hide();
})

//价格验证
//失去焦点事件
$("#price").blur (function(){
	//获取价格
	var price = $("#price").val();
	console.log(price);
	//判空
	if(price == '' ){
		//给当前对象的下一个标签设值
		$(this).next().html("价格不能为空");
		//未设值前该标签是隐藏的  此时就必须显示来
		$(this).next().show();
		return;
	}
	//浮点数的正则表达式
	var reg = /^[+-]?\d+(\.\d+)?$|^$|^(\d+|\-){7,}$/;
	if( !reg.test(price)){
		//给当前对象的下一个标签设值
		$(this).next().html("价格必须是数字");
		//未设值前该标签是隐藏的  此时就必须显示来
		$(this).next().show();
	}	
});

//聚焦事件
$("#price").focus(function(){
	//隐藏
	$(this).next().hide();
})

//作者验证
//失去焦点事件
$("#author").blur (function(){
	//获取作者
	var author = $("#author").val();
	
	//判空
	if(author == '' ){

		//给当前对象的下一个标签设值
		$(this).next().html("作者名称不能为空");
		//未设值前该标签是隐藏的  此时就必须显示来
		$(this).next().show();
	}
});

//聚焦事件
$("#author").focus(function(){
	//隐藏
	$(this).next().hide();
})