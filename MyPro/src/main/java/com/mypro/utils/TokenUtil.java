package com.mypro.utils;

import cn.hutool.core.date.DateUtil;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.mypro.beans.User;
import com.mypro.service.UserService;
import com.mysql.cj.util.StringUtils;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


import java.util.Date;

/**
 * token 下发
 */

@Component
public class TokenUtil {
    static UserService staticUserService;
    @Resource
    UserService userService;
    @PostConstruct
    public void setUserService() {
        staticUserService = userService;
    }
    public static String getToken(String userId,String password) {
        return JWT.create().withAudience(userId)//将userId保存到token作为载荷
                .withExpiresAt(DateUtil.offsetHour(new Date(),20))//两小时
                .sign(Algorithm.HMAC256(password));//password为密钥
    }
    public static User getUser(){
        try {
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            String token = request.getHeader("token");
            if(StringUtils.isNullOrEmpty(token)){
                return null;
            }
            Long userId = Long.valueOf(JWT.decode(token).getAudience().get(0));
            return staticUserService.getInfoById(userId);
        }catch(Exception e){
            return null;
        }
    }
    public static Long getUserId(){
        return getUser().getUserId();
    }
}
