package com.lv.infrastructure.invoke.dao;

import com.adrninistrator.jacg.dto.write_db.AbstractWriteDbData;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author QiangZai
 * @version 1.0
 * @date 2023/8/7 3:41 AM
 */
public interface InvokeInsertBaseDao <T extends AbstractWriteDbData> {

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<InnerClass> 实例对象列表
     * @return 影响行数
     */
    default int insertBatch(@Param("entities") List<T> entities) {
        return 0;
    }
}
