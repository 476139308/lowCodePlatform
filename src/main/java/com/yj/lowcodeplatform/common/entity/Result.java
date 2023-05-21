package com.yj.lowcodeplatform.common.entity;

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
public class Result<T> {

    private Integer code;

    private String message;

    private T data;


    public static <T> Result<T> success(T t) {
        return new Result<T>(0, "Success", t);
    }

    public static <T> Result<T> error(T t) {
        return new Result<T>(1, "Failed", t);
    }


}
