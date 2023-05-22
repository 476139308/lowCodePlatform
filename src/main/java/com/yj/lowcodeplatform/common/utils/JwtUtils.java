package com.yj.lowcodeplatform.common.utils;

import com.yj.lowcodeplatform.system.entity.constants.GlobalConstant;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @author akaTom
 * @since 2022/8/5
 */
public class JwtUtils {

    //常量
    public static final long EXPIRE = 1000 * 60 * 60 * 24; //token过期时间
    public static final String APP_SECRET = "ukc8BDbRigUDaY6pZFfWus2jZWLPHO"; //秘钥

    //生成token字符串的方法
    public static String generateToken(String id, String username) {
        String JwtToken = Jwts.builder()
                .setHeaderParam("typ", "JWT")
                .setHeaderParam("alg", "HS256")

                .setSubject("guli-user")
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE))

                .claim("id", id)  //设置token主体部分 ，存储用户信息
                .claim("nickname", username)

                .signWith(SignatureAlgorithm.HS256, APP_SECRET)
                .compact();

        return JwtToken;
    }

    public static String generateToken(Long id, String username) {
        return generateToken(id.toString(), username);
    }

    /**
     * 判断token是否存在与有效
     *
     * @param jwtToken
     * @return
     */
    public static boolean checkToken(String jwtToken) {
        if (StringUtils.isEmpty(jwtToken)) {
            return false;
        }
        try {
            Jwts.parser().setSigningKey(APP_SECRET).parseClaimsJws(jwtToken);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * 判断token是否存在与有效
     *
     * @param request
     * @return
     */
    public static boolean checkToken(HttpServletRequest request) {
        try {
            String jwtToken = request.getHeader(GlobalConstant.LOGIN_AUTHENTICATE_TOKEN);
            if (StringUtils.isEmpty(jwtToken)) {
                return false;
            }
            Jwts.parser().setSigningKey(APP_SECRET).parseClaimsJws(jwtToken);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * 判断token是否过期了
     *
     * @param token 用户携带的token
     * @return
     */
    public static boolean isExpire(String token) {
        try {
            if (StringUtils.isEmpty(token)) {
                return false;
            }
            Jws<Claims> claimsJws = Jwts.parser().setSigningKey(APP_SECRET).parseClaimsJws(token);
            Date expiration = claimsJws.getBody().getExpiration();
            return expiration.before(new Date());
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    /**
     * 根据token字符串获取会员id
     *
     * @param request
     * @return
     */
    public static String getMemberIdByJwtToken(HttpServletRequest request) {
        String jwtToken = request.getHeader(GlobalConstant.LOGIN_AUTHENTICATE_TOKEN);
        return getMemberIdByJwtToken(jwtToken);
    }


    public static String getPropertyByToken(String token, String propertyName) {
        if (StringUtils.isEmpty(token)) {
            return "";
        }
        Jws<Claims> claimsJws = Jwts.parser().setSigningKey(APP_SECRET).parseClaimsJws(token);
        Claims claims = claimsJws.getBody();
        return (String) claims.get(propertyName);
    }

    /**
     * 根据token字符串获取会员id
     *
     * @param token
     * @return
     */
    public static String getMemberIdByJwtToken(String token) {
        return getPropertyByToken(token, "id");
    }


    public static String getUsernameByJwtToken(String token) {
        return getPropertyByToken(token, "username");
    }


    public static String getPasswordByToken(String token) {
        return getPropertyByToken(token, "password");
    }

}