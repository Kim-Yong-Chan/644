function loadJQuery() {
    var oScript = document.createElement("script");
    oScript.type = "text/javascript";
    oScript.charset = "utf-8";		  
    oScript.src = "jquery-3.4.1.min.js";	
    document.getElementsByTagName("head")[0].appendChild(oScript);
}
loadJQuery();

$('#signUpBtn').click(function (e) {
    e.preventDefault();
    $('#testModal').modal("show");
});

$(function () {
    $("#alert-success").hide();
    $("#alert-danger").hide();
    $("input").keyup(function () {
        var pwd1 = $("#pwd1").val();
        var pwd2 = $("#pwd2").val();
        if (pwd1 != "" || pwd2 != "") {
            if (pwd1 == pwd2) {
                $("#alert-success").show();
                $("#alert-danger").hide(); $("#submit").removeAttr("disabled");
            } else {
                $("#alert-success").hide(); $("#alert-danger").show();
                $("#submit").attr("disabled", "disabled");
            }
        }
    });
});

$('#loginBtn').click(function () {
    var objID = $("#loginID").val();
    var objPW = $("#loginPW").val();

    if (objID === "") {
        alert("아이디를 입력하세요");
        $("#loginID").focus();
        return;
    }
    else if (objPW === "") {
        alert("비밀번호를 입력하세요");
        $("#loginPW").focus();
        return;
    }

    var loginJson = new Object();

    loginJson.id = objID;
    loginJson.pw = objPW;

    var resultJson = JSON.stringify(loginJson);

    $.ajax({
        type: "POST",
        url: "http://10.21.20.10:8080/users",
        dataType: 'text',
        data: resultJson,
        success: successCall,
        error: errorCall
    })
    function successCall() {
        alert("전송성공");
        window.location.href = "TEST.html";
    }
    function errorCall() {
        alert("전송실패");
    }
});

$("#modalY").click(function () {
    var sName = $("#s_name").val();
    var sID = $("#s_id").val();
    var sPW1 = $("#pwd1").val();
    var sPW2 = $("#pwd2").val();

    if (sName === "") {
        alert("이름을 입력하세요");
        $("s_name").focus();
        return;
    }
    else if (sID === "") {
        alert("아이디를 입력하세요");
        $("#s_id").focus();
        return;
    }
    else if (sPW1 === "") {
        alert("비밀번호를 입력하세요");
        $("#pwd1").focus();
        return;
    }
    else if (sID === "") {
        alert("비밀번호 확인을 입력하세요");
        $("#pwd2").focus();
        return;
    }

    var signupObj = new Object();

    signupObj.name = sName;
    signupObj.userId = sID;
    signupObj.userPw = sPW1;

    $.ajax({
        type: "POST",
        url: "http://10.21.20.10:8080/users/",
        accept: "application/json",
        contentType: "application/json",
        dataType: 'text',
        data: JSON.stringify(signupObj),
        success: successCall,
        error: errorCall
    })
    function successCall() {
        alert("전송성공");
    }
    function errorCall() {
        alert("code:" + request.status + "\n" + "message:" + request.responseText + "\n" + "error:" + error);

        //alert("전송실패");
    }


});