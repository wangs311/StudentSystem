$(function(){
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
            $("#username").html(str)
        }
    });
    // 接收有哪些学生的数据
    $.ajax({
        type: "GET",
        url: "/StuSystem/back/student/listStudentByConditions", //查班级学生的地址
        dataType: "json",
        data:{
            stuName: "",
            stuNum: -1,
            className: ""
        },
        success: function (data) {
            for(var i = 0;i < data.json.length;i++){
                $("tbody").append('<tr><td>'+data.json[i].stuNum+'</td><td>'+data.json[i].stuName+'</td><td>'+data.json[i].className+'</td><td><button class=\"btn btn-danger radius delete\" id="'+data.json[i].id+'" >删除</button><button class="btn btn-secondary radius update" index="'+data.json[i].id+'" >修改</button></td></tr>>')
            }

            //删除
            $(".delete").click(function () {
                var stuid = $(this).attr("id");
                $(this).parents("tr").remove();
                console.log("学生id"+stuid);
                $.ajax({
                    type: "GET", //请求方式
                    url: "/StuSystem/back/student/deleteStudentById", //删除的地址
                    data: {
                        id:stuid
                    }
                });
            });

            //更新
            $(".update").click(function(){
                var tmp = $(this).attr("index");
                console.log(tmp)
                $('#myModal').modal('show')
                $(".submit").click(function(){
                    $('#myModal').modal('hide')
                    var sname = $(".student-name").val()
                    var sclass = $(".student-class").val()
                    console.log(sname,sclass);
                    $.ajax({
                        type: "POST", //请求方式
                        url: "/StuSystem/back/student/updateStudentById", //修改的地址
                        data: {
                            id:tmp,
                            stuName:sname,
                            className:sclass
                        }
                    });
                });
            });
        }
    });


    $("#require").click(function(){
        var student_id = $("#student-id").val()
        var student_name = $("#student-name").val()
        var student_class = $("#student-class").val()
        console.log(student_id,student_name,student_class);
        $.ajax({
            type: "GET", //请求方式
            url: "/StuSystem/back/student/listStudentByConditions", //修改的地址
            data: {
                stuNum:student_id,
                stuName:student_name,
                className:student_class
            },
            success:function (data) {
                $("tbody").empty();
                for(var i = 0;i < data.json.length;i++){
                    $("tbody").append('<tr><td>'+data.json[i].stuNum+'</td><td>'+data.json[i].stuName+'</td><td>'+data.json[i].className+'</td><td><button class=\"btn btn-danger radius delete\" id="'+data.json[i].id+'" >删除</button><button class="btn btn-secondary radius update" index="'+data.json[i].id+'" >修改</button></td></tr>>')
                }
            }
        });
    });
});