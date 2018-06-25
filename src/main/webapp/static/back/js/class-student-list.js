$(function () {
    $("tbody").empty();
    $.ajaxSetup({
        cache:false
    })
    var tmp;
    function GetRequest() {
        var url = location.search; //获取url中"?"符后的字串
        if (url.indexOf("?") != -1) {    //判断是否有参数
            var str = url.substr(1); //从第一个字符开始 因为第0个是?号 获取所有除问号的所有符串
            strs = str.split("=");   //用等号进行分隔 （因为知道只有一个参数 所以直接用等号进分隔 如果有多个参数 要用&号分隔 再用等号进行分隔）
            tmp = decodeURI(strs[1]);          //直接弹出第一个参数 （如果有多个参数 还要进行循环的）
        }
    }
    GetRequest();
    console.log(tmp);
    var urlstr = "/StuSystem/back/student/listStudentByConditions?className=" + tmp;
    // 接收有哪些学生的数据
    $.ajax({
        type: "GET",
        url: urlstr, //查班级学生的地址
        dataType: "json",
        success: function (data) {
            for(var i = 0;i < data.json.length;i++){
                $("tbody").append('<tr><td>'+data.json[i].stuNum+'</td><td>'+data.json[i].stuName+'</td><td>'+tmp+'</td><td><button class=\"btn btn-danger radius delete\" id="'+data.json[i].id+'" >删除</button></td></tr>>')
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

        }
    });

    $("#submit-add").click(function(){
        var sname = $("#new-student-name").val();
        var sid = $("#new-student-id").val();
        var sbir = $("#new-student-birthday").val();
        $.ajax({
            type: "POST", //请求方式
            url: "/StuSystem/back/student/newStudent", //添加学生的地址
            data: {
                stuName:sname,
                stuNum:sid,
                birthday:sbir,
                className:tmp
            }
        });
        location.reload();
    });
});
