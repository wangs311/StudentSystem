package com.nenu.software.controller.front;

import com.nenu.software.common.dto.ElectiveDto;
import com.nenu.software.common.dto.StuScore;
import com.nenu.software.common.entity.Course;
import com.nenu.software.common.entity.Elective;
import com.nenu.software.common.entity.Student;
import com.nenu.software.common.util.Pages;
import com.nenu.software.service.ElectiveService;
import net.sf.json.JSON;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author shanjz
 * @since 2018/6/22 9:35
 */
@Controller
@RequestMapping("/elective")
public class ElectiveController {

    @Autowired
    ElectiveService electiveService;


    @RequestMapping(value = "/toElective")
    public String toElective() {
        return Pages.ELECTIVECOURSE;
    }

    /**
     * 添加选课
     * @param
     * @param courseId 课程ID
     * @return 是否成功添加 1正常0异常
     */
    @RequestMapping(value = "/elect",method = RequestMethod.GET)
    @ResponseBody
    public void electCourse(HttpSession session, @RequestParam("courseId")int courseId) {
        long stuId = ((Student)session.getAttribute("student")).getId();
        Elective elective = new Elective();
        elective.setCourseId(courseId);
        elective.setStuId(stuId);
        try {
            electiveService.newElective(elective);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    /**
     * 查询某学生未选课程
     * @param
     * @return 未选课程列表
     */
    @RequestMapping(value = "/unelected/list",method = RequestMethod.GET)
    @ResponseBody
    public List<Course> listUnelectedCourses(HttpSession session) {
        int stuId = (int)((Student)session.getAttribute("student")).getId();
        try {
            List<Course> a = electiveService.listUnelectedCourses(stuId);
            return a;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    /**
     * 跳转到查询自己课程情况页面
     * @return
     */
    @RequestMapping("/toCourseScore")
    public String toCourseScore() {
        return Pages.COURSESCORE;
    }


    /**
     * 查询自己课程和成绩
     * @param session
     * @return
     */
    @RequestMapping("/getCourseScore")
    @ResponseBody
    public List<ElectiveDto> getCourseScore(HttpSession session) {
        int stuId = (int)((Student)session.getAttribute("student")).getId();
        try {
            List<ElectiveDto> list = electiveService.queryCourseAndScore(stuId);
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }






}
