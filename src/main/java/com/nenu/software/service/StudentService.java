package com.nenu.software.service;

import com.nenu.software.common.dto.StuScore;
import com.nenu.software.common.entity.Student;

import java.util.List;

/**
 * 学生Service
 * @author shanjz
 * @since 2018/6/20 10:25
 */
public interface StudentService {
    /**
     * 新增学生
     * @param student 学生实体类
     * @throws Exception 异常
     */
    public void newStudent(Student student) throws Exception;

    /**
     * 根据id删除学生
     * @param id 学生id
     * @throws Exception
     */
    public void deleteStudentById(Integer id) throws Exception;

    /**
     * 根据学号删除学生
     * @param stuNum 学生学号
     * @throws Exception
     */
    public void deleteStudentByStuNum(long stuNum) throws Exception;

    /**
     * 更新学生信息
     * @param student
     * @throws Exception
     */
    public void updateStudent(Student student) throws Exception;

    /**
     * 根据id查询学生
     * @param id
     * @return
     * @throws Exception
     */
    public Student selectStudentById(Integer id) throws Exception;

    /**
     * 根据学号查询学生
     * @param stuNum
     * @return
     * @throws Exception
     */
    public Student selectStudentByStuNum(long stuNum) throws Exception;

    /**
     * 根据条件查询学生劣币哦
     * @param stuName 姓名
     * @param stuNum 学号
     * @param classId 班级id
     * @return
     * @throws Exception
     */
    public List<Student> listStudentByConditions(String stuName, long stuNum, Integer classId) throws Exception;


    /**
     * 学生登陆-董
     * @param stuNum
     * @param password
     * @return
     * @throws Exception
     */
    public Student checkLogin(long stuNum, String password) throws Exception;


    public List<StuScore> query() throws Exception;
}
