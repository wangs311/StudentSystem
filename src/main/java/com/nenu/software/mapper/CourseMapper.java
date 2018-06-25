package com.nenu.software.mapper;

import com.nenu.software.common.entity.Course;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 课程Mapper
 * @author shanjz
 * @since 2018/6/20 20:43
 */
@Repository
public interface CourseMapper {

    /**
     * 新增课程
     */
    public void newCourse(@Param("course") Course course) throws Exception;

    /**
     * 根据id删除课程
     */
    public void deleteCourseById(@Param("id") Integer id) throws Exception;

    /**
     * 修改课程信息
     */
    public void updateCourse(@Param("course") Course course) throws Exception;

    /**
     * 根据id选择课程
     */
    public Course selectCourseById(@Param("id") Integer id) throws Exception;

    /**
     * 根据课程名筛选课程列表
     */
    public List<Course> listCourseByName(@Param("courseName") String courseName) throws Exception;


    /**
     * 查询所有的课程
     * @return
     * @throws Exception
     */
    public List<Course> queryAllCourse() throws Exception;


}
