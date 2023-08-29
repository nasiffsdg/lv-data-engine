package com.lv.infrastructure.invoke.dao;


import com.lv.domain.invoke.MethodReturnGenericsTypeDo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 方法返回泛型类型(MethodReturnGenericsType)表数据库访问层
 * @author makejava
 * @since 2023-08-07 01:29:41
 */
public interface MethodReturnGenericsTypeDao extends InvokeInsertBaseDao<MethodReturnGenericsTypeDo>{

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    MethodReturnGenericsTypeDo queryById(Long id);

    /**
     * 统计总行数
     *
     * @param methodReturnGenericsTypeDo 查询条件
     * @return 总行数
     */
    long count(MethodReturnGenericsTypeDo methodReturnGenericsTypeDo);

    /**
     * 新增数据
     *
     * @param methodReturnGenericsTypeDo 实例对象
     * @return 影响行数
     */
    int insert(MethodReturnGenericsTypeDo methodReturnGenericsTypeDo);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<MethodReturnGenericsType> 实例对象列表
     * @return 影响行数
     */
    @Override
    int insertBatch(@Param("entities") List<MethodReturnGenericsTypeDo> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<MethodReturnGenericsType> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<MethodReturnGenericsTypeDo> entities);

    /**
     * 修改数据
     *
     * @param methodReturnGenericsTypeDo 实例对象
     * @return 影响行数
     */
    int update(MethodReturnGenericsTypeDo methodReturnGenericsTypeDo);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}

