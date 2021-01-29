$(function () {

    //点击跳转登录页
    $("#login").click(function(){
        location.href = "login.html"
    })


    //判断缓存中是否有值，有值则显示用户信息
    var username = window.localStorage.getItem("username");
    if (username){
        $(".login-top").css("display","none");
        $(".success-login").css("display","block");
        $(".success-login img").css("display","display");

        $("#username").css("fontSize",".4rem");
        $("#username").css("color","white");
        $("#username").html(username);
        $("#exit").css("fontSize",".4rem");
        $("#exit").css("color","white");


        //点击退出登录
        $("#exit").click(function () {
            $(".login-top").css("display","block");
            $(".success-login").css("display","none");
            $(".success-login img").css("display","none");
            localStorage.removeItem("username");
            location.reload();
        })
    }else {

    }
})