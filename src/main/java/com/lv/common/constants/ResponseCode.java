package com.lv.common.constants;

import com.lv.common.exceptions.BaseCustomerException;
import com.lv.common.exceptions.CommonException;

/**
 * 响应状态码
 * @author QiangZai
 * @version 1.0
 * @date 2023/7/14 1:12 AM
 */
public interface ResponseCode {

    /**
     * 响应成功
     */
    Integer SUCCESS = 20000;
    /**
     * 默认响应失败
     */
    Integer ERROR = CommonException.COMMON_FAIL_CODE;
    /**
     * 未授权
     */
    Integer UNAUTHORIZED = CommonException.UNAUTHORIZED_CODE;
    /**
     * 无权限
     */
    Integer FORBIDDEN = CommonException.FORBIDDEN_CODE;
}
