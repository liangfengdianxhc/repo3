(function(){
	function rem(){
		var html = document.documentElement;
		var htmlW = html.clientWidth;
		var designW = 750;
		if(designW < htmlW){
			html.style.fontSize = "100px";
		}else{
			html.style.fontSize = (htmlW/designW)*100+"px";
		}
	}
	rem();
	window.addEventListener("resize",rem);
})()
