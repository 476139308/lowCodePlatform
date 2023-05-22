package com.yj.lowcodeplatform.common.entity;

import com.yj.lowcodeplatform.system.exception.ResultCodeInfoInterface;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author YuJin
 * @version 1.0.0
 * @apiNote this class make for
 * @since 2023/5/21 16:09
 */
@Data
@AllArgsConstructor
public class ResultResponse<T> {

    private String code;

    private String message;

    private T data;


    public static <T> ResultResponse<T> success() {
        return success(null);
    }


    public static <T> ResultResponse<T> success(T t) {
        return new ResultResponse<>("0", "Success", t);
    }

    public static <T> ResultResponse<T> error(T t) {
        return new ResultResponse<>("1", "Failed", t);
    }

    public static <T> ResultResponse<T> error(ResultCodeInfoInterface resultCodeInfo, T t) {
        return new ResultResponse<>(resultCodeInfo.getResultCode(), resultCodeInfo.getResultMsg(), t);
    }
}
