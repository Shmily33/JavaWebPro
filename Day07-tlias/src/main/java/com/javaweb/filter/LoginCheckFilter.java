package com.javaweb.filter;

import com.alibaba.fastjson.JSONObject;
import com.javaweb.pojo.Result;
import com.javaweb.utils.JwtUtils;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.io.IOException;

/**
 * @Author: gs_wang
 * @Date: 2024/07/03/下午3:36
 * @Description: 获取请求url。
 * 判断请求url中是否包含login，如果包含，说明是登录操作，放行。
 * 获取请求头中的令牌（token）。
 * 判断令牌是否存在，如果不存在，返回错误结果（未登录）。
 * 解析token，如果解析失败，返回错误结果（未登录）。
 * 放行。
 */
@Slf4j
//@WebFilter(urlPatterns = "/*")
public class LoginCheckFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        String url = req.getRequestURI();
        log.info("请求的url：" + url);

        if (url.contains("login")) {
            log.info("登录操作，放行");
            chain.doFilter(request, response);
            return;
        }

        String jwt = req.getHeader("token");
        if (!StringUtils.hasLength(jwt)) {
            log.info("未登录");
            Result error = Result.error("NOT_LOGIN");
            // 转json -> alibaba fastjson
            String jsonString = JSONObject.toJSONString(error);
            resp.getWriter().write(jsonString);
            return;
        }

        try {
            JwtUtils.parseJWT(jwt);
        } catch (Exception e) {
//            e.printStackTrace();
            log.info("解析令牌失败");
            Result error = Result.error("NOT_LOGIN");
            // 转json -> alibaba fastjson
            String jsonString = JSONObject.toJSONString(error);
            resp.getWriter().write(jsonString);
            return;
        }

        log.info("令牌合法，放行");
        chain.doFilter(request, response);
    }


}
