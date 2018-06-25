package com.nenu.software.controller.front;

import com.nenu.software.common.entity.Course;
import com.nenu.software.service.ClassService;
import com.nenu.software.service.CourseService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 课程相关控制器
 * code1正常 0异常
 * @author shanjz
 * @since 2018/6/21 19:00
 */
@Controller
@RequestMapping("/course")
public class CourseController {


    @Autowired
    private CourseService courseService;


    /**
     * 查询所有课程
     * @return 课程列表JSON对象
     */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    @ResponseBody
    public JSONObject queryAllCourse() {
        JSONObject jsonObject = new JSONObject();
        try {
            List<Course> courseList = courseService.queryAllCourse();
            jsonObject.put("courseList",courseList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonObject;
    }

//    /**
//     * 新增课程（处理表单）
//     * @param course 课程实体类
//     * @return 处理成功页面
//     */
//    @RequestMapping(value = "/new",method = RequestMethod.POST)
//    public String newCourse(Course course) {
//        try {
//            courseService.newCourse(course);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return "添加成功页面";
//    }
//
//    /**
//     * 删除某课程
//     * @return 课程列表JSON对象
//     */
//    @RequestMapping(value = "/delete",method = RequestMethod.GET)
//    @ResponseBody
//    public JSONObject deleteCourse(@RequestParam("id")int id) {
//        JSONObject jsonObject = new JSONObject();
//        try {
//            courseService.deleteCourseById(id);
//            jsonObject.put("code",1);
//        } catch (Exception e) {
//            e.printStackTrace();
//            jsonObject.put("code",0);
//        }
//        return jsonObject;
//    }
}
