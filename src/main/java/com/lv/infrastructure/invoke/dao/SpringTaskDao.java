package com.lv.infrastructure.invoke.dao;

import com.lv.domain.invoke.SpringTaskDo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Spring定时任务信息表(SpringTask)表数据库访问层
 * @author makejava
 * @since 2023-08-07 01:29:41
 */
public interface SpringTaskDao extends InvokeInsertBaseDao<SpringTaskDo>{

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SpringTaskDo queryById(Long id);

    /**
     * 统计总行数
     *
     * @param springTaskDo 查询条件
     * @return 总行数
     */
    long count(SpringTaskDo springTaskDo);

    /**
     * 新增数据
     *
     * @param springTaskDo 实例对象
     * @return 影响行数
     */
    int insert(SpringTaskDo springTaskDo);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<SpringTask> 实例对象列表
     * @return 影响行数
     */
    @Override
    int insertBatch(@Param("entities") List<SpringTaskDo> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<SpringTask> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<SpringTaskDo> entities);

    /**
     * 修改数据
     *
     * @param springTaskDo 实例对象
     * @return 影响行数
     */
    int update(SpringTaskDo springTaskDo);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}

