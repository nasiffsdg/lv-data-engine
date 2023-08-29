package com.lv.infrastructure.invoke.dao;


import com.lv.domain.invoke.MethodInfoDo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 方法的信息表(MethodInfo)表数据库访问层
 * @author makejava
 * @since 2023-08-07 01:29:41
 */
public interface MethodInfoDao extends InvokeInsertBaseDao<MethodInfoDo>{

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    MethodInfoDo queryById(Long id);

    /**
     * 统计总行数
     *
     * @param methodInfoDo 查询条件
     * @return 总行数
     */
    long count(MethodInfoDo methodInfoDo);

    /**
     * 新增数据
     *
     * @param methodInfoDo 实例对象
     * @return 影响行数
     */
    int insert(MethodInfoDo methodInfoDo);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<MethodInfo> 实例对象列表
     * @return 影响行数
     */
    @Override
    int insertBatch(@Param("entities") List<MethodInfoDo> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<MethodInfo> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<MethodInfoDo> entities);

    /**
     * 修改数据
     *
     * @param methodInfoDo 实例对象
     * @return 影响行数
     */
    int update(MethodInfoDo methodInfoDo);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}

