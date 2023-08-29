package com.lv.infrastructure.invoke.dao;

import com.lv.domain.invoke.MethodCallDo;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 方法调用关系表(MethodCall)表数据库访问层
 *
 * @author makejava
 * @since 2023-08-07 01:29:41
 */
public interface MethodCallDao extends InvokeInsertBaseDao<MethodCallDo>{

    /**
     * 通过ID查询单条数据
     *
     * @param callId 主键
     * @return 实例对象
     */
    MethodCallDo queryById(Integer callId);


    /**
     * 统计总行数
     *
     * @param methodCallDo 查询条件
     * @return 总行数
     */
    long count(MethodCallDo methodCallDo);

    /**
     * 新增数据
     *
     * @param methodCallDo 实例对象
     * @return 影响行数
     */
    int insert(MethodCallDo methodCallDo);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<MethodCall> 实例对象列表
     * @return 影响行数
     */
    @Override
    int insertBatch(@Param("entities") List<MethodCallDo> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<MethodCall> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<MethodCallDo> entities);

    /**
     * 修改数据
     *
     * @param methodCallDo 实例对象
     * @return 影响行数
     */
    int update(MethodCallDo methodCallDo);

    /**
     * 通过主键删除数据
     *
     * @param callId 主键
     * @return 影响行数
     */
    int deleteById(Integer callId);

}

