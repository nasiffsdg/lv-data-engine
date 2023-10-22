package com.lv.common.interceptor;

import com.lv.common.domain.ResponseInfo;
import com.lv.common.exceptions.BaseCustomerException;
import com.lv.common.exceptions.BaseValidatorException;
import com.lv.common.exceptions.CommonException;
import lombok.extern.log4j.Log4j2;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 统一异常处理
 * @author QiangZai
 * @version 1.0
 * @date 2023/9/26 9:23 PM
 */
@Log4j2
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 参数校验异常，将校验失败的所有异常组合成一条错误信息
     * @param e 异常
     * @return 异常结果
     */
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseBody
    public ResponseInfo handleValidException(MethodArgumentNotValidException e) {
        log.error("[全局异常捕获]----参数绑定校验异常", e);
        return ResponseInfo.fail("参数绑定校验异常" + wrapperBindingResult(e.getBindingResult()));
    }

    /**
     * 自定义参数校验异常
     * @param e 异常
     * @return 异常结果
     */
    @ExceptionHandler(value = BaseValidatorException.class)
    @ResponseBody
    public ResponseInfo handleValidException(BaseValidatorException e) {
        log.error("[全局异常捕获]----自定义参数绑定校验异常", e);
        return ResponseInfo.fail(e.getCode(), e.getMessage());
    }


    /**
     * 参数绑定异常
     * @param e 异常
     * @return 异常结果
     */
    @ExceptionHandler(value = BindException.class)
    public ResponseInfo handleBindException(BindException e) {
        log.error("[全局异常捕获]----参数绑定校验异常", e);
        return ResponseInfo.fail("参数绑定校验异常");
    }

    /**
     * 处理业务异常
     * @param e 异常
     */
    @ExceptionHandler(value = BaseCustomerException.class)
    public  ResponseInfo handleBaseCustomerException(BaseCustomerException e){
        log.error("[全局异常捕获]----出现业务异常 ", e);
        return ResponseInfo.fail(e.getCode(), e.getMessage());
    }


    /**
     * 捕获全局异常，处理所有不可知的异常
     */
    @ExceptionHandler(value=Exception.class)
    public ResponseInfo handleException(Exception e) {
        log.error("[全局异常捕获]----出现未知异常", e);
        return ResponseInfo.fail(CommonException.COMMON_FAIL_CODE, CommonException.COMMON_FAIL_MESSAGE);
    }

    /**
     * 包装绑定异常结果
     * @param bindingResult 绑定结果
     * @return 异常结果
     */
    private String wrapperBindingResult(BindingResult bindingResult) {
        StringBuilder msg = new StringBuilder();
        for (ObjectError error : bindingResult.getAllErrors()) {
            msg.append(", ");
            if (error instanceof FieldError) {
                msg.append(((FieldError) error).getField()).append(": ");
            }
            msg.append(error.getDefaultMessage() == null ? "" : error.getDefaultMessage());
        }
        return msg.substring(2);
    }
}
