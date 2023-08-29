package com.lv.infrastructure.invoke.dao;


import com.lv.domain.invoke.MethodAnnotationDo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 方法上的注解信息表(MethodAnnotation)表数据库访问层
 * @author makejava
 * @since 2023-08-07 01:29:41
 */
public interface MethodAnnotationDao extends InvokeInsertBaseDao<MethodAnnotationDo>{

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    MethodAnnotationDo queryById(Long id);

    /**
     * 统计总行数
     *
     * @param methodAnnotationDo 查询条件
     * @return 总行数
     */
    long count(MethodAnnotationDo methodAnnotationDo);

    /**
     * 新增数据
     *
     * @param methodAnnotationDo 实例对象
     * @return 影响行数
     */
    int insert(MethodAnnotationDo methodAnnotationDo);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<MethodAnnotation> 实例对象列表
     * @return 影响行数
     */
    @Override
    int insertBatch(@Param("entities") List<MethodAnnotationDo> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<MethodAnnotation> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<MethodAnnotationDo> entities);

    /**
     * 修改数据
     *
     * @param methodAnnotationDo 实例对象
     * @return 影响行数
     */
    int update(MethodAnnotationDo methodAnnotationDo);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}

