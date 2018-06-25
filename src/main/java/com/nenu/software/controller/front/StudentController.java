package com.nenu.software.controller.front;

import com.nenu.software.common.entity.Student;
import com.nenu.software.common.util.Pages;
import com.nenu.software.service.StudentService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @author shanjz
 * @since 2018/6/20 10:46
 */
@Controller
@RequestMapping(value = "/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/getStuName")
    @ResponseBody
    public JSONObject getStuName(HttpSession session) {

        Student student = (Student)session.getAttribute("student");
        String stuName = student.getStuName();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("stuName", stuName);
        return jsonObject;
    }


    /**
     * 学生登陆
     * @param student
     * @param session
     * @return
     */
    @RequestMapping("/login")
    public String login(Student student, HttpSession session) {
        Student temp = null;
        try {
            temp = studentService.checkLogin(student.getStuNum(), student.getPassword());
        } catch (Exception e) {
            return Pages.ERROR;
        }
        if(temp != null) {
            session.setAttribute("student", temp);
            return Pages.ELECTIVECOURSE;
        }
        return "redirect:/login.html";
    }


    /**
     * 退出登录
     * @param session
     * @return
     */
    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("student");
        return "redirect:/login.html";
    }


    /**
     * 前往个人中心
     * @return
     */
    @RequestMapping("/toPerson")
    public String toPerson() {
        return Pages.TOPERSION;
    }


    /**
     * 获得个人信息
     * @param session
     * @return
     */
    @RequestMapping("/getPersion")
    @ResponseBody
    public Student getPersion(HttpSession session) {
        Student student = (Student)session.getAttribute("student");
        return student;
    }



//    /**
//     * 前往修改资料页面
//     * @return
//     */
//    @RequestMapping("/toUpdateMyself")
//    public String toUpdateMyself() {
//        return Pages.UPDATEMYSELF;
//    }


    /**
     * 修改自己的密码和生日
     * @param student
     * @param session
     * @return
     */
    @RequestMapping("/updateMyself")
    public String updateMyself(String password, String birthday, HttpSession session) {
        Student student = new Student();
        student.setPassword(password);
        student.setBirthday(birthday);
        int stuId = (int)((Student)session.getAttribute("student")).getId();
        student.setId(stuId);
        try {
            studentService.updateStudent(student);
            return Pages.TOPERSION;
        } catch (Exception e) {
            return Pages.ERROR;
        }
    }


//    /**
//     * 进入选课页面
//     * @return
//     */
//    @RequestMapping("/toElectiveCourse")
//    public String toElectiveCourse() {
//        return Pages.ELECTIVECOURSE;
//    }







}
