package com.mypro.interceptor;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.mypro.beans.User;
import com.mypro.exception.ServiceException;
import com.mypro.resultHandle.ReturnCode;
import com.mypro.service.UserService;
import com.mypro.utils.Encrypt;
import com.mysql.cj.util.StringUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


public class JwtInterceptor implements HandlerInterceptor {
    @Autowired
    UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//        HttpServletResponse response = servletRequestAttributes.getResponse();
//        response.setHeader("Access-Control-Allow-Origin", "*");

//        response.addHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
//        if ("OPTIONS".equals(request.getMethod())) {
//            String requestHeader = request.getHeader("Access-Control-Request-Headers");
//            if(requestHeader !=null) {
//                response.addHeader("Access-Control-Allow-Headers", requestHeader );
//            }
//            response.addHeader("Access-Control-Allow-Origin", "*");
//            return true ;
//        }
        if(request.getMethod().toUpperCase().equals("OPTIONS")){
            return true;//通过所有OPTION请求
        }
        if(!(handler instanceof HandlerMethod)){
            return true;
        }
        String token = request.getHeader("token");
        if(StringUtils.isNullOrEmpty(token)){
            throw new ServiceException(ReturnCode.RC401.getCode(), "无token，请重新登录");
        }
        Long userId;
        try{
            userId = Long.valueOf(JWT.decode(token).getAudience().get(0));
        }catch (JWTDecodeException j){
            throw new ServiceException(ReturnCode.RC401.getCode(), "token验证失败，请重新登录");
        }
        User user = userService.getInfoById(userId);
        if(user==null){
            throw new ServiceException(ReturnCode.RC401.getCode(), "用户不存在，请重新登录");
        }
        String password = user.getPassword();
//        String dePassword = Encrypt.decrypt(Ipassword);
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(password)).build();
        try{
            jwtVerifier.verify(token);
        }catch(JWTVerificationException e){
            throw new ServiceException(ReturnCode.RC401.getCode(), "token验证失败，请重新登录");
        }
        return true;
    }
}
