package com.lv.common.exceptions;

/**
 * 通用异常类
 * @author QiangZai
 * @version 1.0
 * @date 2023/9/26 9:32 PM
 */
public class CommonException extends BaseCustomerException{

    /**
     * 通用业务失败处理错误码
     */
    public static final Integer COMMON_FAIL_CODE = 50000;
    public static final String COMMON_FAIL_MESSAGE = "服务器异常，请稍后";
    /**
     * 未授权
     */
    public static final Integer UNAUTHORIZED_CODE = 40001;
    /**
     * 无权限
     */
    public static final Integer FORBIDDEN_CODE = 40003;
}
