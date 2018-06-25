package com.nenu.software.controller.back;


import com.nenu.software.common.entity.Class;
import com.nenu.software.service.ClassService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/backClass")
public class ClassController {
    @Autowired
    ClassService classService;

    @RequestMapping("/all")
    @ResponseBody
    public JSONObject list() {
        JSONObject jsonObject = new JSONObject();
        try {
            List<Class> list = classService.listClassByConditions("","");
            jsonObject.put("list",list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonObject;
    }

    @RequestMapping("list")
    public String toList() {
        return "grade/backpages/class-list";
    }


    @RequestMapping("/delete")
    @ResponseBody
    public JSONObject deleteCourse(@RequestParam("id")int id) {
        JSONObject jsonObject = new JSONObject();
        try {
            classService.deleteClassById(id);
            jsonObject.put("code",1);
        } catch (Exception e) {
            e.printStackTrace();
            jsonObject.put("code",0);
        }
        return jsonObject;
    }

    @RequestMapping(value = "/new",method = RequestMethod.POST)
    public String newCourse(@RequestParam("grade") String grade,@RequestParam("class")String name) {
        Class aClass = new Class();
        aClass.setGrade(grade);
        aClass.setClassName(name);
        try {
            classService.newClass(aClass);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this.toList();
    }
}
