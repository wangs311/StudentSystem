package com.nenu.software.service;

import com.nenu.software.common.entity.Course;

import java.util.List;

/**
 * 课程service
 * @author shanjz
 * @since 2018/6/20 20:56
 */
public interface CourseService {

    /**
     * 新增课程
     */
    public void newCourse(Course course) throws Exception;

    /**
     * 根据id删除课程
     */
    public void deleteCourseById(Integer id) throws Exception;

    /**
     * 更新课程信息
     */
    public void updateCourse(Course course) throws Exception;

    /**
     * 根据id查找课程
     */
    public Course selectCourseById(Integer id) throws Exception;

    /**
     * 根据课程名（可以为空）查找课程列表
     */
    public List<Course> listCourseByName(String courseName) throws Exception;


    /**
     * 查询所有课程
     * @return
     * @throws Exception
     */
    public List<Course> queryAllCourse() throws Exception;

}
