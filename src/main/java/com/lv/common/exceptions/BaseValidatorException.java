package com.lv.common.exceptions;

import lombok.Data;

/**
 * 自定义参数校验异常
 * @author QiangZai
 * @version 1.0
 * @date 2023/9/27 11:54 PM
 */
@Data
public class BaseValidatorException extends BaseCustomerException{
    // 业务异常信息
    private String message = "您上传的参数有误，请重新上传";
    // 业务异常码
    private Integer code = 50010;

    public BaseValidatorException(String message, Integer code) {
        this.message = message;
        this.code = code;
    }
}
