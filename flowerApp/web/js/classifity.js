window.onload = function(){
	var back = document.getElementById("back");
	back.onclick = function(){
		window.location.href="javascript:history.go(-1)";
	}
}