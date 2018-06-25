package com.nenu.software.service.impl;

import com.nenu.software.common.entity.Class;
import com.nenu.software.mapper.ClassMapper;
import com.nenu.software.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 班级Serice继承类
 * @author shanjz
 * @since 2018/6/21 9:06
 */
@Service("classService")
public class ClassServiceImpl implements ClassService {

    @Autowired
    private ClassMapper classMapper;

    public void newClass(Class clazz) throws Exception {
        classMapper.newClass(clazz);
    }

    public void deleteClassById(Integer id) throws Exception {
        classMapper.deleteClassById(id);
    }

    public void updateClass(Class clazz) throws Exception {
        classMapper.updateClass(clazz);
    }

    public Class selectClassById(Integer id) throws Exception {
        return classMapper.selectClassById(id);
    }

    public List<Class> listClassByConditions(String grade, String className) throws Exception {
        return classMapper.listClassByConditions(grade, className);
    }
}
