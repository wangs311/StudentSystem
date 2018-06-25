package com.nenu.software.service.impl;

import com.nenu.software.common.dto.StuScore;
import com.nenu.software.common.entity.Student;
import com.nenu.software.mapper.StudentMapper;
import com.nenu.software.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 学生Service实现
 * @author shanjz
 * @since 2018/6/20 10:26
 */
@Service("studentService")
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    public void newStudent(Student student) throws Exception {
        System.out.println("studentMapper = " + studentMapper);
        studentMapper.newStudent(student);
    }

    public void deleteStudentById(Integer id) throws Exception {
        studentMapper.deleteStudentById(id);
    }

    public void deleteStudentByStuNum(long stuNum) throws Exception {
        studentMapper.deleteStudentByStuNum(stuNum);
    }

    public void updateStudent(Student student) throws Exception {
        studentMapper.updateStudent(student);
    }

    public Student selectStudentById(Integer id) throws Exception {
        return studentMapper.selectStudentById(id);
    }

    public Student selectStudentByStuNum(long stuNum) throws Exception {
        return studentMapper.selectStudentByStuNum(stuNum);
    }

    public List<Student> listStudentByConditions(String stuName, long stuNum, Integer classId) throws Exception {
        System.out.println("studentMapper = " + studentMapper);
        return studentMapper.listStudentByConditions(stuName, stuNum, classId);
    }

    public Student checkLogin(long stuNum, String password) throws Exception {
        return studentMapper.checkLogin(stuNum, password);
    }

    @Override
    public List<StuScore> query() throws Exception {
        return studentMapper.query();
    }
}
