$(function () {
    $("tbody").empty();
    $.ajaxSetup({
        cache:false
    });
    // 老师名字
    $.ajax({
        type: "GET",
        url: "/StuSystem/backTeacher/getTeacherName", //老师姓名的地址
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
        url: "/StuSystem/backCourse/all", //老师查课程的地址
        dataType: "json",
        success: function (data) {
            // console.log(data.courseList[0].id);
            for(var i = 0;i < data.courseList.length;i++){
                $("tbody").append('<tr><td>'+data.courseList[i].id+'</td><td>'+data.courseList[i].courseName+'</td><td><button class=\"btn btn-danger radius delete\" id="'+data.courseList[i].id+'">删除</button><button class="btn btn-secondary  radius manage" "><a href="/StuSystem/backElective/manage?id='+data.courseList[i].id+'">管理</a></button></td></tr>>')
            }

            //删除
            $(".delete").click(function () {
                $(this).parents("tr").remove();
                var id = $(this).attr("id");
                console.log(id);
                $.ajax({
                    type: "GET", //请求方式
                    url: "/StuSystem/backCourse/delete", //删除课程的地址
                    data: {
                        id:id
                    }
                });
            });
        //    管理
            $(".manage").click(function () {
                var id = $(this).siblings(".delete").attr("id");
                console.log(id);
                $.ajax({
                    type: "GET", //请求方式
                    url: "/StuSystem/backElective/manage", //管理课程的地址
                    data: {
                        id:id
                    }
                });
            });
        }
    });

    $("#submit-add").click(function(){
        var tmp = $("#new-course").val()
        $.ajax({
            type: "POST", //请求方式
            url: "/StuSystem/backCourse/new", //删除课程的地址
            data: {
                courseName:tmp
            }
        });
        location.reload();
    });
});
