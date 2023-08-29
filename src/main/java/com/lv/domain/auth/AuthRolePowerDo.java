package com.lv.domain.auth;

import lombok.Data;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

/**
 * 用户角色（关系）表
 * @author lvxueqiang
 * @TableName lv_auth_role_power
 */
@Data
@ToString
public class AuthRolePowerDo implements Serializable {
    /**
     * 主键id
     */
    private Long id;

    /**
     * 角色id
     */
    private Long roleId;

    /**
     * 用户id
     */
    private Long powerId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 
     */
    private Integer isDeleted;

    @Serial
    private static final long serialVersionUID = 1L;
}