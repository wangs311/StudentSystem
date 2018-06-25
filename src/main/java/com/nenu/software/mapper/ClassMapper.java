package com.nenu.software.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import com.nenu.software.common.entity.Class;

import java.util.List;

/**
 * 班级Mapper
 * @author shanjz
 * @since 2018/6/21 8:50
 */
@Repository
public interface ClassMapper {

    /**
     * 新增班级
     */
    public void newClass(@Param("clazz") Class clazz) throws Exception;

    /**
     * 通过id删除班级
     */
    public void deleteClassById(@Param("id") Integer id) throws Exception;

    /**
     * 更新班级信息
     */
    public void updateClass(@Param("clazz") Class clazz) throws Exception;

    /**
     * 通过id查找班级
     */
    public Class selectClassById(@Param("id") Integer id) throws Exception;

    /**
     * 根据条件查找班级列表
     */
    public List<Class> listClassByConditions(@Param("grade") String grade,
                                             @Param("className") String className) throws Exception;

}
