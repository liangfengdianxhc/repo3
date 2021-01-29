
$(function(){
	var shopData = ""
	$.ajax({
		url: "countTypesServlet"
	})
	$.ajax({
		url:"buyCarServlet",
		type:"post",
		success:function (data) {
			shopData = data
			var htmls = "";
			// 这里需要根据后台数据循环添加
			console.log(data[0].price)
			htmls += '<div class="shopdiv">';
			htmls += '<span class="iconfont icon-weixuanzhong-01" id="shopdiv-xuanzhong"></span>';
			htmls += '<figure>';
			htmls += '<img src="img/'+shopData[0].imgUrl+'" >';
			htmls += '<figcaption>';
			htmls += '<p>'+shopData[0]["name"]+'</p>';
			htmls += '<div class="sprice">'
			htmls += '<span>'+"&yen"+'<strong>'+shopData[0]["price"]+'</strong></span>'
			htmls += '<span class="iconfont icon-icon--" style="color: #9A9999;"></span>'
			htmls += '</div>';
			htmls += '<div class="controllercount">'
			htmls += '<span id="reduce">-</span>'
			htmls += '<span id="countValue">'+shopData[0]["count"]+'</span>'
			htmls += '<span id="add">+</span>'
			htmls += '</div>'
			htmls += '</figcaption>'
			htmls += '</figure>'
			htmls += '</div>'
			$(".haveshop").html(htmls)
		},
		dataType:"json"
	})






	//点击增加数量
	
	$("#add").click(function(){
		count = count + 1;
		$("#countValue").html(count);
	})
	$("#reduce").click(function(){
		if(count > 1){
			
			count = count - 1;
			$("#countValue").html(count);
			
		}else{
			$("#countValue").html("1");
		}
		
	})

	//选中效果切换
	var countMoney =  0;
	var number = 1
	$("#selectall").click(function(){
		$("span[id='shopdiv-xuanzhong']").toggleClass("icon-xz");	
		$(this).toggleClass("icon-xz")
		$(".sprice span strong").each(function(){
			var str_price = $(this).html();
			var price = parseInt(str_price);
			
			countMoney = countMoney + price
		})
		// alert(countMoney)
		$("#countMoney").html(countMoney);
	})

	$("span[id='shopdiv-xuanzhong']").click(function(){
		$(this).toggleClass("icon-xz");
	})
	
	$("#countMoney").html(countMoney)
})