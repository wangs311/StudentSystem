$().ready(function () {
    $("tbody").empty();
    $.ajaxSetup({
        cache:false
    })
    // 接收有哪些课程的数据
    $.ajax({
        type: "GET",
        url: "/StuSystem/elective/unelected/list", //学生成绩的地址
        dataType: "json",
        success: function (data) {
            console.log(data.length)
            if(data.length > 0){
                console.log(data[0].courseName);
                for (var i = 0; i < data.length; i++) {
                    $("tbody").append('<tr><td>'+data[i].courseName+'</td><td><button id="'+data[i].id+'" class="btn btn-secondary radius chose">选课</button></tr>');
                }
            }
            else {
                $("tbody").append('<tr><td>无</td><td><button class="btn btn-secondary radius chose disabled">无法选课</button></tr>');
            }

            //给后台传送确认选中的课程
            $(".chose").click(function () {
                var courseId = $(this).attr("id");
                $(this).parents("tr").remove();
                console.log(courseId);
                $.ajax({
                    type: "GET", //请求方式
                    url: "/StuSystem/elective/elect", //选中课程的接收的地址
                    data: {
                        courseId:courseId
                    }
                });

            });
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