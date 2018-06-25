package com.nenu.software.controller.back;

import com.nenu.software.common.dto.StuScore;
import com.nenu.software.common.entity.Course;
import com.nenu.software.common.entity.Elective;
import com.nenu.software.common.entity.Student;
import com.nenu.software.service.ElectiveService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author shanjz
 * @since 2018/6/22 9:35
 */
@Controller
@RequestMapping("/backElective")
public class ElectiveBackController {

    @Autowired
    ElectiveService electiveService;

    /**
     * 添加选课
     * @param stuId 学生ID
     * @param courseId 课程ID
     * @return 是否成功添加 1正常0异常
     */
    @RequestMapping(value = "/elect",method = RequestMethod.GET)
    @ResponseBody
    public JSONObject electCourse(@RequestParam("stuId")int stuId, @RequestParam("courseId")int courseId) {
        JSONObject jsonObject = new JSONObject();
        Elective elective = new Elective();
        elective.setCourseId(courseId);
        elective.setStuId(stuId);
        try {
            electiveService.newElective(elective);
            jsonObject.put("code",1);
        } catch (Exception e) {
            e.printStackTrace();
            jsonObject.put("code",1);
        }
        return jsonObject;
    }

    /**
     * 给某学生某课程打分
     * @param id 选课ID
     * @param score 课程成绩
     * @return 是否成功打分 1正常0异常
     */
    @RequestMapping(value = "/score",method = RequestMethod.GET)
    @ResponseBody
    public JSONObject score(@RequestParam("id") int id, @RequestParam("score") double score) {
        JSONObject jsonObject = new JSONObject();
        try {
            Elective elective = electiveService.selectElectiveById(id);
            elective.setScore(score);
            electiveService.updateElective(elective);
            jsonObject.put("code",1);
        } catch (Exception e) {
            e.printStackTrace();
            jsonObject.put("code",0);
        }
        return jsonObject;
    }

    @RequestMapping(value = "/manage",method = RequestMethod.GET)
    public String toList() {
        return "grade/backpages/course-grade-list";
    }

    /**
     * 查询某课程所有选课的同学
     * @param courseId 课程ID
     * @return 选课的同学的列表
     */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    @ResponseBody
    public JSONObject listStudents(@RequestParam("courseId") int courseId) {
        JSONObject jsonObject = new JSONObject();
        try {
            List<StuScore> studentList = electiveService.listElectiveStudents(courseId);
            jsonObject.put("studentList",studentList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonObject;
    }

    /**
     * 查询某学生已选课程
     * @param stuId 学生ID
     * @return 已选课程列表
     */
    @RequestMapping(value = "/elected/list",method = RequestMethod.GET)
    @ResponseBody
    public JSONObject listElectedCourses(int stuId) {
        JSONObject jsonObject = new JSONObject();
        try {
            List<Course> courseList = electiveService.listElectedCourses(stuId);
            jsonObject.put("courseList",courseList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonObject;
    }

    /**
     * 查询某学生未选课程
     * @param stuId 学生ID
     * @return 未选课程列表
     */
    @RequestMapping(value = "/unelected/list",method = RequestMethod.GET)
    @ResponseBody
    public JSONObject listUnelectedCourses(int stuId) {
        JSONObject jsonObject = new JSONObject();
        try {
            List<Course> courseList = electiveService.listUnelectedCourses(stuId);
            jsonObject.put("courseList",courseList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonObject;
    }
}
