package com.javaweb.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.javaweb.pojo.Result;
import com.javaweb.utils.JwtUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Author: gs_wang
 * @Date: 2024/07/03/下午4:26
 * @Description:
 */

@Slf4j
@Component
public class LoginCheckInterceptor implements HandlerInterceptor {
    @Override // 目标资源方法运行前运行，返回true放行，false不放行
    public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object handler) throws Exception {


        String url = req.getRequestURI();
        log.info("请求的url：" + url);

        if (url.contains("login")) {
            log.info("登录操作，放行");
            return true;
        }

        String jwt = req.getHeader("token");
        if (!StringUtils.hasLength(jwt)) {
            log.info("未登录");
            Result error = Result.error("NOT_LOGIN");
            // 转json -> alibaba fastjson
            String jsonString = JSONObject.toJSONString(error);
            resp.getWriter().write(jsonString);
            return false;
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
            return false;
        }

        log.info("令牌合法，放行");
        return true;

    }

    @Override // 目前资源方法运行后放行
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
        System.out.println("postHandle");
    }

    @Override // 视图渲染完成后运行，最后运行
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
        System.out.println("afterCompletion");
    }

}
