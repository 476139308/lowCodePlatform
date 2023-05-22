package com.yj.lowcodeplatform.system.exception;

import lombok.Data;

/**
 * @author YuJin
 * @version 1.0.0
 * @apiNote this class make for
 * @since 2023/5/22 12:35
 */
@Data
public class BusinessException extends RuntimeException {

    protected String resultCode;

    protected String resultMsg;

    public BusinessException(ResultCodeInfoInterface resultCodeInfoInterface) {
        this.resultCode = resultCodeInfoInterface.getResultCode();
        this.resultMsg = resultCodeInfoInterface.getResultMsg();
    }

    public BusinessException(ResultCodeInfoInterface resultCodeInfoInterface, Throwable cause) {
        super(resultCodeInfoInterface.getResultCode(), cause);
        this.resultCode = resultCodeInfoInterface.getResultCode();
        this.resultMsg = resultCodeInfoInterface.getResultMsg();
    }

    public BusinessException(String errorMsg) {
        super(errorMsg);
        this.resultMsg = errorMsg;
    }

    public BusinessException(String errorCode, String errorMsg) {
        super(errorCode);
        this.resultCode = errorCode;
        this.resultMsg = errorMsg;
    }

    public BusinessException(String errorCode, String errorMsg, Throwable cause) {
        super(errorCode, cause);
        this.resultCode = errorCode;
        this.resultMsg = errorMsg;
    }


}
