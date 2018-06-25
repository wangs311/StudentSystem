package com.nenu.software.service;

import com.nenu.software.common.entity.Teacher;

import java.util.List;

/**
 * 教师Service
 * @author shanjz
 * @since 2018/6/20 10:25
 */
public interface TeacherService {
    /**
     * 新增教师
     * @param teacher 教师实体类
     */
    public void newTeacher(Teacher teacher) throws Exception;

    /**
     * 根据id删除教师
     * @param id 教师id
     */
    public void deleteTeacherById(Integer id) throws Exception;

    /**
     * 根据学号删除教师
     * @param teaNum 教师编号
     * @throws Exception
     */
    public void deleteTeacherByTeaNum(String teaNum) throws Exception;

    /**
     * 更新教师信息
     */
    public void updateTeacher(Teacher teacher) throws Exception;

    /**
     * 根据id查询教师
     */
    public Teacher selectTeacherById(Integer id) throws Exception;

    /**
     * 根据编号查询教师
     */
    public Teacher selectTeacherByTeaNum(String teaNum) throws Exception;

    /**
     * 根据条件查询教师列表
     * @param teaName 姓名
     * @param teNum 学号
     */
    public List<Teacher> listTeacherByConditions(String teaName, String teaNum) throws Exception;



    public Teacher checkTeaLogin(Teacher teacher) throws Exception;

}
