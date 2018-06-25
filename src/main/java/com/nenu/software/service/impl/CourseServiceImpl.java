package com.nenu.software.service.impl;

import com.nenu.software.common.entity.Course;
import com.nenu.software.mapper.CourseMapper;
import com.nenu.software.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 课程service实现类
 * @author shanjz
 * @since 2018/6/20 21:00
 */
@Service("courseService")
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseMapper courseMapper;

    public void newCourse(Course course) throws Exception {
        courseMapper.newCourse(course);
    }

    public void deleteCourseById(Integer id) throws Exception {
        courseMapper.deleteCourseById(id);
    }

    public void updateCourse(Course course) throws Exception {
        courseMapper.updateCourse(course);
    }

    public Course selectCourseById(Integer id) throws Exception {
        return courseMapper.selectCourseById(id);
    }

    public List<Course> listCourseByName(String courseName) throws Exception {
        return courseMapper.listCourseByName(courseName);
    }

    public List<Course> queryAllCourse() throws Exception {
        return courseMapper.queryAllCourse();
    }

}
