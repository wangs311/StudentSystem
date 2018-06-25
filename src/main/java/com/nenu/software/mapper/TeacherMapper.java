package com.nenu.software.mapper;

import com.nenu.software.common.entity.Teacher;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 教师mapper
 * @author shanjz
 * @since 2018/6/20 19:56
 */
@Repository
public interface TeacherMapper {

    /**
     * 新增教师
     */
    public void newTeacher(@Param("teacher") Teacher teacher) throws Exception;

    /**
     * 根据id删除教师
     */
    public void deleteTeacherById(@Param("id") Integer id) throws Exception;

    /**
     * 根据教师编号删除教师
     */
    public void deleteTeacherByTeaNum(@Param("teaNum") String teaNum) throws Exception;

    /**
     * 更新教师信息
     */
    public void updateTeacher(@Param("teacher") Teacher teacher) throws Exception;

    /**
     * 根据id查询教师
     */
    public Teacher selectTeacherById(@Param("id") Integer id) throws Exception;

    /**
     * 根据教师编号查询教师
     */
    public Teacher selectTeacherByTeaNum(@Param("teaNum") String teaNum) throws Exception;

    /**
     * 根据条件查询教师列表
     * @param teaName 教师姓名
     * @param teaNum 教师编号
     */
    public List<Teacher> listTeacherByConditions(@Param("teaName") String teaName,
                                                 @Param("teaNum") String teaNum) throws Exception;


    public Teacher checkTeaLogin(Teacher teacher) throws Exception;


}
