package com.nenu.software.service.impl;

import com.nenu.software.common.dto.ElectiveDto;
import com.nenu.software.common.dto.StuScore;
import com.nenu.software.common.entity.Course;
import com.nenu.software.common.entity.Elective;
import com.nenu.software.common.entity.Student;
import com.nenu.software.mapper.ElectiveMapper;
import com.nenu.software.service.ElectiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 选修信息Service实现类
 * @author shanjz
 * @since 2018/6/21 9:32
 */
@Service("electiveService")
public class ElectiveServiceImpl implements ElectiveService {

    @Autowired
    private ElectiveMapper electiveMapper;

    public void newElective(Elective elective) throws Exception {
        electiveMapper.newElective(elective);
    }

    public void deleteElectiveByConditions(Integer id, Integer stuId, Integer courseId) throws Exception {
        electiveMapper.deleteElectiveByConditions(id, stuId, courseId);
    }

    public void updateElective(Elective elective) throws Exception {
        electiveMapper.updateElective(elective);
    }

    public Elective selectElectiveById(Integer id) throws Exception {
        return electiveMapper.selectElectiveById(id);
    }

    public List<Elective> listElectiveByConditions(Integer stuId, Integer courseId) throws Exception {
        return electiveMapper.listElectiveByConditions(stuId, courseId);
    }

    public List<StuScore> listElectiveStudents(int courseId) throws Exception {
        return electiveMapper.listElectiveStudents(courseId);
    }

    public List<Course> listElectedCourses(int stuId) throws Exception {
        return electiveMapper.listElectedCourses(stuId);
    }

    public List<Course> listUnelectedCourses(int stuId) throws Exception {
        return electiveMapper.listUnelectedCourses(stuId);
    }

    public List<ElectiveDto> queryCourseAndScore(int stuId) throws Exception {
        return electiveMapper.queryCourseAndScore(stuId);
    }
}
