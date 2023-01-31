//package com.mypro.config;
//
//
//import org.springframework.boot.web.servlet.FilterRegistrationBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.Ordered;
//import org.springframework.web.cors.CorsConfiguration;
//import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
//import org.springframework.web.filter.CorsFilter;
//
//import java.util.Arrays;
//
///**
// * @author ZhuYouBin
// * @version 1.0.0
// * @Date: 2022/10/31 23:18
// * @Description 通过 CorsFilter 解决跨域问题
// */
////@Configuration
//public class CorsFilterConfig {
//
////    @Bean
//    public FilterRegistrationBean<CorsFilter> corsFilter() {
//        // 创建 Cors 配置对象
//        CorsConfiguration corsConfig = new CorsConfiguration();
//        // 设置允许哪些跨域
//        corsConfig.addAllowedOrigin("*");
//        // 设置允许cookie跨域
////        corsConfig.setAllowCredentials(true);
//        // 设置响应头
//        corsConfig.addAllowedMethod("*");
//        // 设置允许的跨域请求方式
//        corsConfig.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE"));
//        // 设置 OPTIONS 请求的缓存时间
//        corsConfig.setMaxAge(3600L);
//
//        // 创建url配置资源
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        // 注册 CORS 跨域配置
//        source.registerCorsConfiguration("/**", corsConfig);
//
//        // 创建 CorsFilter 过滤器
//        CorsFilter corsFilter = new CorsFilter(source);
//
//        // 创建注册过滤器的Bean对象
//        FilterRegistrationBean<CorsFilter> registrationBean = new FilterRegistrationBean<>(corsFilter);
//        // 设置 CorsFilter 过滤器最先执行
//        registrationBean.setOrder(Ordered.LOWEST_PRECEDENCE);
//        return registrationBean;
//    }
//}
//
