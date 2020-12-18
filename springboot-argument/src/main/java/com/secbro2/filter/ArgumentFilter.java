package com.secbro2.filter;

import com.secbro2.util.TokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 第二种（Level2）形式的filter
 *
 * @author sec
 * @version 1.0
 * @date 2020/12/18
 **/
@Slf4j
@Component
@Order(1)
public class ArgumentFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        String token = httpRequest.getHeader("token");
        Integer userId = TokenUtil.getUserIdByToken(token);
        log.info("filter获取用户Id={}", userId);
        HttpServletRequestWrapper requestWrapper = new HttpServletRequestWrapper(httpRequest) {
            @Override
            public String getHeader(String name) {
                if ("userId".equals(name)) {
                    return userId + "";
                }
                return super.getHeader(name);
            }
        };
        filterChain.doFilter(requestWrapper, httpResponse);
    }
}
