package com.lv.common.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 业务异常处理基类
 * @author QiangZai
 * @version 1.0
 * @date 2023/8/26 12:37 AM
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class BaseCustomerException extends RuntimeException{

    // 业务异常信息
    protected String message;
    // 业务异常码
    protected Integer code;
    // 异常原因
    protected Throwable cause;
}
