package com.yj.lowcodeplatform.system.filter;

import com.yj.lowcodeplatform.common.utils.JwtUtils;
import com.yj.lowcodeplatform.system.dao.UserDao;
import com.yj.lowcodeplatform.system.entity.User;
import com.yj.lowcodeplatform.system.entity.constants.GlobalConstant;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author YuJin
 * @version 1.0.0
 * @apiNote this class make for
 * @since 2023/5/21 17:16
 */
@Component
public class JwtAuthenticateFilter extends OncePerRequestFilter {
    @Resource
    private UserDao userDao;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = request.getHeader(GlobalConstant.LOGIN_AUTHENTICATE_TOKEN);
//        1.想确定是否携带token，2.携带了token是否是一个token，有效则放行，3.该token是否过期了，如已过期则放行
//        上述情况的相反情况，均要进入校验token的过程
        if (StringUtils.isEmpty(token) || !JwtUtils.checkToken(token) || !JwtUtils.isExpire(token)) {
            filterChain.doFilter(request, response);
            return;
        }

        String username = JwtUtils.getUsernameByJwtToken(token);

        User user = userDao.findByUsername(username);

        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user, JwtUtils.getPasswordByToken(token), null);
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);

        filterChain.doFilter(request, response);

    }
}
