$().ready(function () {
    $.ajaxSetup({
        cache:false
    });

    // 老师名字
    $.ajax({
        type: "GET",
        url: "/StuSystem/backTeacher/getTeacherName", //学生姓名的地址
        dataType: "json",
        success: function (data) {
            console.log(data.teacherName);
            var str = data.teacherName + '<i class="Hui-iconfont">&#xe6d5;</i>';
            $("#name").html(str);
            $("#username").html(str)
        }
    });

    var password;

    $("#submit").click(function () {
        if($("#newpassword").val()){
            var password = $("#newpassword").val();
            console.log(password);
        }

        // 修改个人信息
        $.ajax({
            type: "POST",
            url: "/StuSystem/backTeacher/changePassword", //老师修改信息的地址
            dataType: "json",
            data:{
                password:password
            }
        });

        window.location = "/StuSystem/backTeacher/toIndex";
    });
});