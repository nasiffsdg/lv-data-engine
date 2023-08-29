package com.lv.infrastructure.invoke.dao;

import com.lv.domain.invoke.ClassInfoDo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 类的信息表(ClassInfo)表数据库访问层
 * @author QiangZai
 * @since 2023-08-07 01:29:41
 */
public interface ClassInfoDao extends InvokeInsertBaseDao<ClassInfoDo>{

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ClassInfoDo queryById(Long id);


    /**
     * 统计总行数
     *
     * @param classInfoDo 查询条件
     * @return 总行数
     */
    long count(ClassInfoDo classInfoDo);

    /**
     * 新增数据
     *
     * @param classInfoDo 实例对象
     * @return 影响行数
     */
    int insert(ClassInfoDo classInfoDo);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<ClassInfo> 实例对象列表
     * @return 影响行数
     */
    @Override
    int insertBatch(@Param("entities") List<ClassInfoDo> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     * @param entities List<ClassInfo> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<ClassInfoDo> entities);

    /**
     * 修改数据
     *
     * @param classInfoDo 实例对象
     * @return 影响行数
     */
    int update(ClassInfoDo classInfoDo);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}

