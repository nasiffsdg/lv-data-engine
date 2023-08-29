package com.lv.infrastructure.invoke.dao;


import com.lv.domain.invoke.JarInfoDo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * jar包信息表(JarInfo)表数据库访问层
 * @author makejava
 * @since 2023-08-07 01:29:41
 */
public interface JarInfoDao extends InvokeInsertBaseDao<JarInfoDo>{

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    JarInfoDo queryById(Long id);


    /**
     * 统计总行数
     *
     * @param jarInfoDo 查询条件
     * @return 总行数
     */
    long count(JarInfoDo jarInfoDo);

    /**
     * 新增数据
     *
     * @param jarInfoDo 实例对象
     * @return 影响行数
     */
    int insert(JarInfoDo jarInfoDo);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<JarInfo> 实例对象列表
     * @return 影响行数
     */
    @Override
    int insertBatch(@Param("entities") List<JarInfoDo> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<JarInfo> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<JarInfoDo> entities);

    /**
     * 修改数据
     *
     * @param jarInfoDo 实例对象
     * @return 影响行数
     */
    int update(JarInfoDo jarInfoDo);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}

