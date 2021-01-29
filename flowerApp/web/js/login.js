window.onload = function(){
	var username = window.localStorage.getItem("username");
	if (username){
		location.href = "my.html"
		$(".login-top").css("display","none");
		$(".success-login").css("display","block");
		$(".success-login img").css("display","display");

		$("#username").css("fontSize",".4rem");
		$("#username").css("color","white");
		$("#username").html(username);
		$("#exit").css("fontSize",".4rem");
		$("#exit").css("color","white");
	}


	var back = document.getElementById("back");
	back.onclick = function(){
		window.location.href="javascript:history.go(-1)";
	}
	$("#loginbtn").click(function () {
		var username = $("#username").val();
		var password = $("#pwd").val();
		$.ajax({
			url:"loginServlet",
			type:"post",
			data:{"username":username,"password":password},
			success:function (data){
				console.log(typeof (data))
				if (data == "true"){
					window.localStorage.setItem("username",username);
					window.location.href= "my.html";

				}else {
					$("#li1").css("border-bottom","0.01rem solid red")
					$("#li2").css("border-bottom","0.01rem solid red")
					$("#tip").text("用户名或密码错误！")
				}
			},

		})
	})
}