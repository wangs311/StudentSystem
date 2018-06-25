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
            // console.log(data.teacherName);
            var str = data.teacherName + '<i class="Hui-iconfont">&#xe6d5;</i>';
            $("#name").html(str);
        }
    });
    var tmp;
    function GetRequest() {
        var url = location.search; //获取url中"?"符后的字串
        if (url.indexOf("?") != -1) {    //判断是否有参数
            var str = url.substr(1); //从第一个字符开始 因为第0个是?号 获取所有除问号的所有符串
            strs = str.split("=");   //用等号进行分隔 （因为知道只有一个参数 所以直接用等号进分隔 如果有多个参数 要用&号分隔 再用等号进行分隔）
            tmp = strs[1];          //直接弹出第一个参数 （如果有多个参数 还要进行循环的）
        }
    }
    GetRequest();

    var urlstr = "/StuSystem/backElective/list?courseId=" + tmp;
    // 接收有哪些课程的数据
    $.ajax({
        type: "GET",
        url: urlstr, //查课程成绩的地址
        dataType: "json",
        success: function (data) {
            //最高分最低分
            var maxscore = 0;
            var minscore = 100;
            for(var j = 0;j < data.studentList.length;j++){
                if(data.studentList[j].score > maxscore){
                    maxscore = data.studentList[j].score;
                }
                if(data.studentList[j].score < minscore){
                    minscore = data.studentList[j].score;
                }
            }
            console.log(minscore);
            console.log(maxscore);
            // /放到页面显示
            for(var i = 0;i < data.studentList.length;i++){
                var classgrade = data.studentList[i].grade + data.studentList[i].className;
                var scorestr = data.studentList[i].score;
                if(data.studentList[i].score == 0){
                    scorestr = "暂无成绩";
                }
                $("tbody").append('<tr><td>'+data.studentList[i].stuNum+'</td><td>'+classgrade+'</td><td>'+data.studentList[i].stuName+'</td><td>'+data.studentList[i].course+'</td><td>'+scorestr+'</td><td><button class=\"btn btn-secondary radius score\" id="'+data.studentList[i].stuId+'" index="'+data.studentList[i].courseId+'" eleid="'+data.studentList[i].eleId+'">打分</button></td></tr>>');

                if(data.studentList[i].score == maxscore){
                    var strh = data.studentList[i].stuNum+" "+data.studentList[i].stuName+" "+maxscore;
                    $("#high").append('<li>'+strh+'</li>');
                }
                if(data.studentList[i].score == minscore){
                    var strl = data.studentList[i].stuNum+" "+data.studentList[i].stuName+" "+minscore;
                    $("#low").append('<li>'+strl+'</li>');
                }
            }

            //打分
            $(".score").click(function () {
                var stuid = $(this).attr("id");
                var courseid = $(this).attr("index");
                var eleid = $(this).attr("eleid");
                var score;
                console.log("学生id"+stuid);
                console.log("课程id"+courseid);
                console.log("eleid"+eleid);
                layer.prompt({
                        title: '请输入成绩'
                    },
                    function (text, index) {
                        layer.close(index);
                        score = text;
                        console.log(score);
                    });

                $(".layui-layer-btn0").click(function () {
                    $.ajax({
                        type: "GET", //请求方式
                        url: "/StuSystem/backElective/score", //打分的地址
                        data: {
                            stuId:stuid,
                            courseId:courseid,
                            score:score,
                            id:eleid
                        }
                    });
                    location.reload();
                });
            });
        }
    });
});
