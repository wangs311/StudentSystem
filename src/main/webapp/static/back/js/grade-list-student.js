$().ready(function () {
    $("tbody").empty();
    $.ajaxSetup({
        cache:false
    });

    // 接收有哪些课程及成绩
    $.ajax({
        type: "GET",
        url: "/StuSystem/elective/getCourseScore", //学生成绩的地址
        dataType: "json",
        success: function (data) {
            console.log(data.length)
            for (var i = 0; i < data.length; i++) {
                if(data[i].score != 0){
                    $("tbody").append('<tr><td>'+data[i].courseName+'</td><td>'+data[i].score+'</td></tr>');
                }
                else {
                    $("tbody").append('<tr><td>'+data[i].courseName+'</td><td>暂无成绩</td></tr>');
                }
            }

        }
    });

    // 用户名字
    $.ajax({
        type: "GET",
        url: "/StuSystem/student/getStuName", //学生姓名的地址
        dataType: "json",
        success: function (data) {
            var str = data.stuName + '<i class="Hui-iconfont">&#xe6d5;</i>';
            $("#name").html(str);
        }
    });
});