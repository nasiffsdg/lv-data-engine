package com.lv.common.domain;

import com.lv.common.constants.ResponseCode;
import lombok.Builder;
import lombok.Data;


/**
 * 统一的返回数据
 * @author QiangZai
 * @version 1.0
 * @date 2023/7/14 1:04 AM
 */
@Data
@Builder
public class ResponseInfo {

    /**
     * 状态码
     */
    private Integer code;

    /**
     * 信息
     */
    private String msg ;

    /**
     * 数据
     */
    private Object data;


    /**
     * 成功响应
     * @return 返回 json
     */
    public static ResponseInfo success() {
        return ResponseInfo.builder().code(ResponseCode.SUCCESS).build();
    }
    /**
     * 响应成功
     * @param data 数据
     * @return 返回 json
     */
    public static ResponseInfo success(Object data) {
        return ResponseInfo.builder().code(ResponseCode.SUCCESS).data(data).build();
    }

    /**
     *
     * @param data 数据
     * @param msg 信息
     * @return 返回 json
     */
    public static ResponseInfo success(Object data, String msg) {
        return ResponseInfo.builder().code(ResponseCode.SUCCESS).msg(msg).data(data).build();
    }
    /**
     *
     * @param msg 信息
     * @return 返回 json
     */
    public static ResponseInfo success(String msg) {
        return ResponseInfo.builder().code(ResponseCode.SUCCESS).msg(msg).build();
    }


    /**
     * 前端显示失败消息
     * @param msg 失败消息
     */
    public static ResponseInfo fail(String msg) {
        return ResponseInfo.builder().code(ResponseCode.ERROR).msg(msg).build();
    }

    /**
     * 响应失败
     * @param code 失败码
     * @param msg 消息
     */
    public static ResponseInfo fail(Integer code, String msg) {
        return ResponseInfo.builder().code(code).msg(msg).build();
    }

    /**
     * 转换
     * @param responseInfo 源结果
     * @param code 响应码
     * @param msg 响应信息
     * @param data 响应数据
     */
    public static void transfer(ResponseInfo responseInfo, Integer code, String msg, Object data){
        responseInfo.code = code;
        responseInfo.msg = msg;
        responseInfo.data = data;
    }
}
