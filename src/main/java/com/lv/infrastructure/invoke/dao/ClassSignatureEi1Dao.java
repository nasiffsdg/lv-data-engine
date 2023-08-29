package com.lv.infrastructure.invoke.dao;


import com.lv.domain.invoke.ClassSignatureEi1Do;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 类的签名中涉及继承与实现的信息表1(ClassSignatureEi1)表数据库访问层
 * @author makejava
 * @since 2023-08-07 01:29:41
 */
public interface ClassSignatureEi1Dao extends InvokeInsertBaseDao<ClassSignatureEi1Do>{

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ClassSignatureEi1Do queryById(Long id);

    /**
     * 统计总行数
     *
     * @param classSignatureEi1Do 查询条件
     * @return 总行数
     */
    long count(ClassSignatureEi1Do classSignatureEi1Do);

    /**
     * 新增数据
     *
     * @param classSignatureEi1Do 实例对象
     * @return 影响行数
     */
    int insert(ClassSignatureEi1Do classSignatureEi1Do);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<ClassSignatureEi1> 实例对象列表
     * @return 影响行数
     */
    @Override
    int insertBatch(@Param("entities") List<ClassSignatureEi1Do> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<ClassSignatureEi1> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<ClassSignatureEi1Do> entities);

    /**
     * 修改数据
     *
     * @param classSignatureEi1Do 实例对象
     * @return 影响行数
     */
    int update(ClassSignatureEi1Do classSignatureEi1Do);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}

