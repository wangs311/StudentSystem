package com.nenu.software.service;

import com.nenu.software.common.entity.Class;

import java.util.List;

/**
 * 班级Service
 * @author shanjz
 * @since 2018/6/21 9:02
 */
public interface ClassService {

    /**
     * 新增班级
     */
    public void newClass(Class clazz) throws Exception;

    /**
     * 根据id删除班级
     */
    public void deleteClassById(Integer id) throws Exception;

    /**
     * 更新班级信息
     */
    public void updateClass(Class clazz) throws Exception;

    /**
     * 根据id查询班级
     */
    public Class selectClassById(Integer id) throws Exception;

    /**
     * 根据条件查询班级列表
     */
    public List<Class> listClassByConditions(String grade, String className) throws Exception;

}
