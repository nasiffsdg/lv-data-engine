package com.lv.infrastructure.invoke.dao;


import com.lv.domain.invoke.MethodLineNumberDo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 方法代码行号信息表(MethodLineNumber)表数据库访问层
 *
 * @author makejava
 * @since 2023-08-07 01:29:41
 */
public interface MethodLineNumberDao extends InvokeInsertBaseDao<MethodLineNumberDo>{

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    MethodLineNumberDo queryById(Long id);

    /**
     * 统计总行数
     *
     * @param methodLineNumberDo 查询条件
     * @return 总行数
     */
    long count(MethodLineNumberDo methodLineNumberDo);

    /**
     * 新增数据
     *
     * @param methodLineNumberDo 实例对象
     * @return 影响行数
     */
    int insert(MethodLineNumberDo methodLineNumberDo);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<MethodLineNumber> 实例对象列表
     * @return 影响行数
     */
    @Override
    int insertBatch(@Param("entities") List<MethodLineNumberDo> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<MethodLineNumber> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<MethodLineNumberDo> entities);

    /**
     * 修改数据
     *
     * @param methodLineNumberDo 实例对象
     * @return 影响行数
     */
    int update(MethodLineNumberDo methodLineNumberDo);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}

