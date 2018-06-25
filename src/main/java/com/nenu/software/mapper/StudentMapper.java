package com.nenu.software.mapper;

import com.nenu.software.common.dto.StuScore;
import com.nenu.software.common.entity.Student;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 学生Mapper
 * @author shanjz
 * @since 2018/6/20 10:23
 */
@Repository
public interface StudentMapper {

    /**
     * 新增学生
     * @param student 学生实体类
     * @throws Exception 异常
     */
    public void newStudent(@Param("student") Student student) throws Exception;

    /**
     * 根据id删除学生
     * @param id
     * @throws Exception
     */
    public void deleteStudentById(@Param("id") Integer id) throws Exception;

    /**
     * 根据学号删除学生
     * @param stuNum 学号
     * @throws Exception
     */
    public void deleteStudentByStuNum(@Param("stuNum") long stuNum) throws Exception;

    /**
     * 修改学生属性
     * @param student
     * @throws Exception
     */
    public void updateStudent(@Param("student") Student student) throws Exception;

    /**
     * 根据id查找学生
     * @param id
     * @return
     * @throws Exception
     */
    public Student selectStudentById(@Param("id") Integer id) throws Exception;

    /**
     * 根据学号查找学生
     * @param stuNum
     * @return
     * @throws Exception
     */
    public Student selectStudentByStuNum(@Param("stuNum") long stuNum) throws Exception;

    public List<Student> listStudentByConditions(@Param("stuName") String stuName,
                                                 @Param("stuNum") long StuNum,
                                                 @Param("classId") Integer classId) throws Exception;


    /**
     * 学生登陆
     * @param stuNum
     * @param password
     * @return
     * @throws Exception
     */
    public Student checkLogin(@Param("stuNum") long stuNum, @Param("password") String password) throws Exception;


    public List<StuScore> query() throws Exception;
}
