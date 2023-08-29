package com.lv.infrastructure.invoke.dao;


import com.lv.domain.invoke.MethodCallInfoDo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 方法调用信息表(MethodCallInfo)表数据库访问层
 * @author makejava
 * @since 2023-08-07 01:29:41
 */
public interface MethodCallInfoDao extends InvokeInsertBaseDao<MethodCallInfoDo>{

    /**
     * 通过ID查询单条数据
     * @param callId 主键
     * @return 实例对象
     */
    MethodCallInfoDo queryById(Integer callId);


    /**
     * 统计总行数
     *
     * @param methodCallInfoDo 查询条件
     * @return 总行数
     */
    long count(MethodCallInfoDo methodCallInfoDo);

    /**
     * 新增数据
     *
     * @param methodCallInfoDo 实例对象
     * @return 影响行数
     */
    int insert(MethodCallInfoDo methodCallInfoDo);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<MethodCallInfo> 实例对象列表
     * @return 影响行数
     */
    @Override
    int insertBatch(@Param("entities") List<MethodCallInfoDo> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<MethodCallInfo> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<MethodCallInfoDo> entities);

    /**
     * 修改数据
     *
     * @param methodCallInfoDo 实例对象
     * @return 影响行数
     */
    int update(MethodCallInfoDo methodCallInfoDo);

    /**
     * 通过主键删除数据
     *
     * @param callId 主键
     * @return 影响行数
     */
    int deleteById(Integer callId);

}

