package com.yj.lowcodeplatform.system.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author YuJin
 * @version 1.0.0
 * @apiNote this class make for
 * @since 2023/5/22 12:41
 */
@Getter
@AllArgsConstructor
public enum ResultCodeInfoEnum implements ResultCodeInfoInterface {
    SUCCESS("0", "Success"),
    EMPTY_TOKEN("1001", "Token不能为空"),
    TOKEN_EXPIRED("1002", "Token已过期"),
    INVALID_TOKEN("1003", "无效的Token"),
    BODY_NOT_MATCH("4000", "请求的数据格式不符!"),
    SIGNATURE_NOT_MATCH("4001", "请求的数字签名不匹配!"),
    NOT_FOUND("4004", "未找到该资源!"),
    INTERNAL_SERVER_ERROR("5000", "服务器内部错误!"),
    SERVER_BUSY("5003", "服务器正忙，请稍后再试!");

    /**
     * 错误码
     */
    private final String resultCode;
    /**
     * 错误描述
     */
    private final String resultMsg;

    @Override
    public String getResultCode() {
        return resultCode;
    }

    @Override
    public String getResultMsg() {
        return resultMsg;
    }
}
