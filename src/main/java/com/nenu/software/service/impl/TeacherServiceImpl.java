package com.nenu.software.service.impl;

import com.nenu.software.common.entity.Teacher;
import com.nenu.software.mapper.TeacherMapper;
import com.nenu.software.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 教师Service实现
 * @author shanjz
 * @since 2018/6/20 10:26
 */
@Service("teacherService")
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherMapper teacherMapper;

    public void newTeacher(Teacher teacher) throws Exception {
        teacherMapper.newTeacher(teacher);
    }

    public void deleteTeacherById(Integer id) throws Exception {
        teacherMapper.deleteTeacherById(id);
    }

    public void deleteTeacherByTeaNum(String teaNum) throws Exception {
        teacherMapper.deleteTeacherByTeaNum(teaNum);
    }

    public void updateTeacher(Teacher teacher) throws Exception {
        teacherMapper.updateTeacher(teacher);
    }

    public Teacher selectTeacherById(Integer id) throws Exception {
        return teacherMapper.selectTeacherById(id);
    }

    public Teacher selectTeacherByTeaNum(String teaNum) throws Exception {
        return teacherMapper.selectTeacherByTeaNum(teaNum);
    }

    public List<Teacher> listTeacherByConditions(String teaName, String teaNum) throws Exception {
        return teacherMapper.listTeacherByConditions(teaName, teaNum);
    }

    public Teacher checkTeaLogin(Teacher teacher) throws Exception {
        return teacherMapper.checkTeaLogin(teacher);
    }
}
