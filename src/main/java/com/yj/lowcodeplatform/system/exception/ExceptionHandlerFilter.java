package com.yj.lowcodeplatform.system.exception;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.HandlerExceptionResolver;

import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author YuJin
 * @version 1.0.0
 * @apiNote this class make for deal with the exception in filter ,因为全局异常处理器只能处理controller层面的，filter在controller层面之前和之后
 * @since 2023/5/23 11:49
 */
@Component
public class ExceptionHandlerFilter extends OncePerRequestFilter {

    @Resource(name = "handlerExceptionResolver")
    private HandlerExceptionResolver handlerExceptionResolver;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            filterChain.doFilter(request, response);
        } catch (Exception e) {
            handlerExceptionResolver.resolveException(request, response, null, e);
        }
    }
}
