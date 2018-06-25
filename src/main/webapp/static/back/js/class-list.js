$(function () {
    $("tbody").empty();
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
        }
    });
    // 接收有哪些课程的数据
    $.ajax({
        type: "GET",
        url: "/StuSystem/backClass/all", //老师查班级的地址
        dataType: "json",
        success: function (data) {
            // console.log(data.courseList[0].id);
            for(var i = 0;i < data.list.length;i++){
                var str = data.list[i].grade + data.list[i].className;
                var classname = data.list[i].className;
                $("tbody").append('<tr><td>'+data.list[i].id+'</td><td>'+str+'</td><td><button class=\"btn btn-danger radius delete\" id="'+data.list[i].id+'">删除</button><button class="btn btn-secondary radius mangage" id="'+data.list[i].id+'"><a href="/StuSystem/back/student/toClassStudentList?className='+classname+'">管理</a></button></td></tr>>')
            }

            //删除
            $(".delete").click(function () {
                $(this).parents("tr").remove();
                var id = $(this).attr("id");
                console.log(id);
                $.ajax({
                    type: "GET", //请求方式
                    url: "/StuSystem/backClass/delete", //删除课程的地址
                    data: {
                        id:id
                    }
                });
            });
        }
    });
    $("#submit-add").click(function(){
        var grade = $("#new-grade").val();
        var name = $("#new-class").val();
        $.ajax({
            type: "POST", //请求方式
            url: "/StuSystem/backClass/new", //删除课程的地址
            data: {
                grade:grade,
                class:name
            }
        });
        location.reload();
    });
});
