package com.lv.infrastructure.invoke.dao;


import com.lv.domain.invoke.MybatisMsWriteTableDo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * MyBatis写数据库表信息（使用MySQL）(MybatisMsWriteTable)表数据库访问层
 * @author makejava
 * @since 2023-08-07 01:29:41
 */
public interface MybatisMsWriteTableDao extends InvokeInsertBaseDao<MybatisMsWriteTableDo>{

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    MybatisMsWriteTableDo queryById(Long id);

    /**
     * 统计总行数
     *
     * @param mybatisMsWriteTableDo 查询条件
     * @return 总行数
     */
    long count(MybatisMsWriteTableDo mybatisMsWriteTableDo);

    /**
     * 新增数据
     *
     * @param mybatisMsWriteTableDo 实例对象
     * @return 影响行数
     */
    int insert(MybatisMsWriteTableDo mybatisMsWriteTableDo);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<MybatisMsWriteTable> 实例对象列表
     * @return 影响行数
     */
    @Override
    int insertBatch(@Param("entities") List<MybatisMsWriteTableDo> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<MybatisMsWriteTable> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<MybatisMsWriteTableDo> entities);

    /**
     * 修改数据
     *
     * @param mybatisMsWriteTableDo 实例对象
     * @return 影响行数
     */
    int update(MybatisMsWriteTableDo mybatisMsWriteTableDo);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}

