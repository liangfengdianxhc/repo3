$(function(){
	var idValue = getUrlParam("id");
	if (isNaN(idValue)) {
		window.location.href = "index.html"
	}

	$.ajax({
		url:"likeServlet",
		type:"POST",
		success:function (data) {
			var youlikeList = data;
			console.log(youlikeList)
			for (var i = 0; i < youlikeList.length; i++) {
				if (youlikeList[i].id == idValue) {
					$(".detail_img img").prop("src","img/"+youlikeList[i].imgUrl)
					$("#price").html("&yen"+youlikeList[i].price)
					$("#sure-btn").click(function(){
						window.localStorage.setItem("shopDate",JSON.stringify(youlikeList[i]))
						var count = $("#countValue").text();
						window.localStorage.setItem("count",count)
						window.location.href = "shoppingcart.html"
					})
					break
				}
			}
		},
		dataType:"json"
	})
	$("#join-buycar").click(function () {
		$.ajax({
			url:"likeServlet",
			type:"POST",
			success:function (data) {
				var youlikeList = data;
				console.log(youlikeList)
				for (var i = 0; i < youlikeList.length; i++) {
					if (youlikeList[i].id == idValue) {
						console.log(youlikeList[i].imgUrl)
						$("#buyIm").prop("src","img/"+youlikeList[i].imgUrl)
						$("#priceIm").html("&yen"+youlikeList[i].price)
						$("#sure-btn").click(function(){
							window.localStorage.setItem("shopDate",JSON.stringify(youlikeList[i]))
							var count = $("#countValue").text();
							window.localStorage.setItem("count",count)
							window.location.href = "shoppingcart.html"
						})
						break
					}
				}
			},
			dataType:"json"
		})
	})


	
	
	
	
	
	//jquery滑动显示和隐藏，淡出效果
	$("#join-buycar").click(function(){
		$(".mask").css("display","block");
		$(".buy-count").slideDown("normal","swing");
	})
	$(".icon-quxiao").click(function(){
		$(".buy-count").slideUp("normal","swing");
		$(".mask").fadeOut("normal","swing");
	})
	
	var count = 1;
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
	
	
	
	
	
})


function getUrlParam(urlParam){
	var i = "";
	var url = window.location.toString();
	var arr = url.split("?");
	if(arr.length > 1){
		var paramArr = arr[1].split("&");
		for (var i = 0; i < paramArr.length; i++) {
			var paramandvalue = paramArr[i].split("=");
			if (paramandvalue[0] != null && paramandvalue[0] == urlParam) {
				i = paramandvalue[1]
				return i	
			}
		}
		return i
	}
	return i;
}