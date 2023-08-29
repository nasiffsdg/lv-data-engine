package com.lv.infrastructure.invoke.dao;


import com.lv.domain.invoke.MybatisMsTableDo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * MyBatis数据库表信息（使用MySQL）(MybatisMsTable)表数据库访问层
 * @author makejava
 * @since 2023-08-07 01:29:41
 */
public interface MybatisMsTableDao extends InvokeInsertBaseDao<MybatisMsTableDo>{

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    MybatisMsTableDo queryById(Long id);

    /**
     * 统计总行数
     *
     * @param mybatisMsTableDo 查询条件
     * @return 总行数
     */
    long count(MybatisMsTableDo mybatisMsTableDo);

    /**
     * 新增数据
     *
     * @param mybatisMsTableDo 实例对象
     * @return 影响行数
     */
    int insert(MybatisMsTableDo mybatisMsTableDo);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<MybatisMsTable> 实例对象列表
     * @return 影响行数
     */
    @Override
    int insertBatch(@Param("entities") List<MybatisMsTableDo> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<MybatisMsTable> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<MybatisMsTableDo> entities);

    /**
     * 修改数据
     *
     * @param mybatisMsTableDo 实例对象
     * @return 影响行数
     */
    int update(MybatisMsTableDo mybatisMsTableDo);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}

