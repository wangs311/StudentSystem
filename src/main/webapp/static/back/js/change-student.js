$().ready(function () {
    $.ajaxSetup({
        cache:false
    });
    var id;
    var password;
    var birthday;
    // 用户信息
    $.ajax({
        type: "GET",
        url: "/StuSystem/student/getPersion", //学生姓名的地址
        dataType: "json",
        success: function (data) {
            var str = data.stuName + '<i class="Hui-iconfont">&#xe6d5;</i>';
            $("#name").html(str);
            $("#namea").html(data.stuName);
            $("#stu-num").html(data.stuNum);
            $("#class-id").html(data.classId);
            $("#birthday").val(data.birthday);
            id = data.id;
        }
    });

    $("#submit").click(function () {
        if($("#newpassword").val()){
            password = $("#newpassword").val();
            console.log(password);
        }
        birthday = $("#birthday").val();
        console.log(birthday);

        // 修改个人信息
        $.ajax({
            type: "GET",
            url: "/StuSystem/student/updateMyself", //学生修改信息的地址
            dataType: "json",
            data:{
                password:password,
                birthday:birthday
            }
        });

        window.location = "/StuSystem/elective/toElective";
    });
});