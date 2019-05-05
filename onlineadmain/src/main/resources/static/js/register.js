$(function () {
    var obj = $('input[name="admainEmail"]');
    $("#register").submit(function () {
        var password = $("#password").val();
        var repassword = $("#repassword").val();
        if (password != repassword) {
            alert("两次密码不一致");
            return;
        }
        if (String(password).length < 6) {
            alert("密码小于六位");
            return;
        }
        obj.removeAttr("disabled");
        $.ajax({
            type: "get",
            url: "/onlineAdmain/registerApi",
            data: $("form").serialize(),
            success: function (data) {
                if (data["status"] == "400") {
                    alert(data["msg"]);
                }
                if (data["status"] == "200"){
                    alert(data["msg"]);
                    window.location.href="/onlineAdmain/login";
                }

            }
        })
    });
    $("#获取验证码").click(function () {
        var reg = new RegExp("^[a-z0-9]+([._\\-]*[a-z0-9])*@([a-z0-9]+[-a-z0-9]*[a-z0-9]+.){1,63}[a-z0-9]+$");
        var ie = $("label[for='email']");
        var obj = $('input[name="admainEmail"]');
        if (obj.val() === "") { //输入不能为空
            ie.text("邮箱输入为空");
            ie.attr("class", "text-danger label-material");
            return false;
        } else if (!reg.test(obj.val())) { //正则验证不通过，格式不对
            ie.text("邮箱格式不对！");
            ie.attr("class", "text-danger label-material");
            return false;
        }

        $.ajax({
            type: "get",
            url: "/onlineAdmain/getEmailCode",
            data: $("form").serialize(),
            success: function (data) {
                if (data["status"] == "400") {
                    alert(data["msg"]);
                }
                if (data["status"] == "200") {
                    alert(data["msg"]);
                    obj.attr("disabled", true);
                    time();
                }

            }
        })

    });
    var wait = 60;

    function time() {
        var btn=$("#获取验证码");
        var obj = $('input[name="admainEmail"]');
        if (wait == 0) {
            btn.attr("disabled", false);
            btn.val("获取验证码");
            obj.attr("disabled", false);
            wait = 60;
        } else {
            btn.attr("disabled", true);
            btn.val("重新发送(" + wait + ")");
            wait--;
            setTimeout(function () {
                    time(btn)
                },
                1000)
        }
    }
});
