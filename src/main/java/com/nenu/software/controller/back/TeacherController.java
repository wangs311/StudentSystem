package com.nenu.software.controller.back;

import com.nenu.software.common.entity.Teacher;
import com.nenu.software.common.util.Pages;
import com.nenu.software.service.TeacherService;
import net.sf.json.JSON;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @author shanjz
 * @since 2018/6/23 12:34
 */
@Controller
@RequestMapping("/backTeacher")
public class TeacherController {


    @Autowired
    private TeacherService service;

    @RequestMapping("/login")
    public String teacherLogin(Teacher teacher, HttpSession session) {
        Teacher temp = null;
        try {
            temp = service.checkTeaLogin(teacher);
        } catch (Exception e) {
            e.printStackTrace();
            return Pages.ERROR;
        }
        if(temp != null) {
            session.setAttribute("teacher", temp);
            return Pages.BACKINDEX;
        }
        return "redirect:/loginBack.html";
    }

    @RequestMapping(value = "toChangePassword")
    public String toChangePassword() {
        return "grade/backpages/change-password";
    }

    /**
     * 教师更改密码
     * @return 0 - 更改失败
     *          1 - 更改成功
     */
    @RequestMapping(value = "changePassword", method = RequestMethod.POST)
    @ResponseBody
    public Integer changePassword(@RequestParam(value = "password") String password,
                                    HttpSession session) {
        Teacher teacher = null;
        teacher = (Teacher) session.getAttribute("teacher");
        teacher.setPassword(password);
        try {
            service.updateTeacher(teacher);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @RequestMapping(value = "getTeacherName")
    @ResponseBody
    public JSONObject getTeacherName(HttpSession session) {
        Teacher teacher = null;
        teacher = (Teacher) session.getAttribute("teacher");
        String teacherName = "";
        if (teacher != null) {
            teacherName = teacher.getTeaName();
        }
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("teacherName", teacherName);

        return jsonObject;

    }

    @RequestMapping(value = "toIndex")
    public String toIndex() {
        return "grade/backpages/index";
    }

}
