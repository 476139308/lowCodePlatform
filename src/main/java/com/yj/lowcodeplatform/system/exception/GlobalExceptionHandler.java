package com.yj.lowcodeplatform.system.exception;

import com.yj.lowcodeplatform.common.entity.ResultResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * @author YuJin
 * @version 1.0.0
 * @apiNote this class is a global exception handler, deal with exception for this system when is in runtime
 * @since 2023/5/22 12:54
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(BusinessException.class)
    @ResponseBody
    public ResultResponse handlerBusinessException(HttpServletRequest request, BusinessException e) {
        logger.error("{}发生了业务异常，错误码是:{}，错误信息是:{}", Arrays.stream(e.getStackTrace()).findFirst().orElse(null),e.getResultCode(), e.getResultMsg());
        return ResultResponse.error(e);
    }


    /**
     * 处理空指针的异常
     *
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(value = NullPointerException.class)
    @ResponseBody
    public ResultResponse exceptionHandler(HttpServletRequest req, NullPointerException e) {
        logger.error("发生空指针异常！原因是:", e);
        return ResultResponse.error(ResultCodeInfoEnum.BODY_NOT_MATCH);
    }

    /**
     * 处理其他异常
     *
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResultResponse exceptionHandler(HttpServletRequest req, Exception e) {
        logger.error("未知异常！原因是:", e);
        return ResultResponse.error(ResultCodeInfoEnum.INTERNAL_SERVER_ERROR);
    }

}
