package com.lv.infrastructure.invoke.dao;


import com.lv.domain.invoke.ClassNameDo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 类名信息表(ClassName)表数据库访问层
 * @author makejava
 * @since 2023-08-07 01:29:41
 */
public interface ClassNameDao extends InvokeInsertBaseDao<ClassNameDo>{

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ClassNameDo queryById(Long id);

    /**
     * 统计总行数
     *
     * @param classNameDo 查询条件
     * @return 总行数
     */
    long count(ClassNameDo classNameDo);

    /**
     * 新增数据
     *
     * @param classNameDo 实例对象
     * @return 影响行数
     */
    int insert(ClassNameDo classNameDo);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<ClassName> 实例对象列表
     * @return 影响行数
     */
    @Override
    int insertBatch(@Param("entities") List<ClassNameDo> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<ClassName> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<ClassNameDo> entities);

    /**
     * 修改数据
     *
     * @param classNameDo 实例对象
     * @return 影响行数
     */
    int update(ClassNameDo classNameDo);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}
