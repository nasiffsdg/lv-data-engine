package com.lv.infrastructure.invoke.dao;

import com.lv.domain.invoke.ClassAnnotationDo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 类上的注解信息表(ClassAnnotation)表数据库访问层
 * @author makejava
 * @since 2023-08-07 01:29:41
 */
public interface ClassAnnotationDao extends InvokeInsertBaseDao<ClassAnnotationDo>{

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ClassAnnotationDo queryById(Long id);


    /**
     * 统计总行数
     *
     * @param classAnnotationDo 查询条件
     * @return 总行数
     */
    long count(ClassAnnotationDo classAnnotationDo);

    /**
     * 新增数据
     *
     * @param classAnnotationDo 实例对象
     * @return 影响行数
     */
    int insert(ClassAnnotationDo classAnnotationDo);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<ClassAnnotation> 实例对象列表
     * @return 影响行数
     */
    @Override
    int insertBatch(@Param("entities") List<ClassAnnotationDo> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<ClassAnnotation> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<ClassAnnotationDo> entities);

    /**
     * 修改数据
     *
     * @param classAnnotationDo 实例对象
     * @return 影响行数
     */
    int update(ClassAnnotationDo classAnnotationDo);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}

