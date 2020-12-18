package com.secbro2.filter;

import com.secbro2.util.JsonUtils;
import com.secbro2.util.TokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StreamUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.*;

/**
 * 第三种（Level3）形式的filter
 *
 * @author sec
 * @version 1.0
 * @date 2020/12/18
 **/
@Slf4j
@Component
public class ArgumentParamFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        String token = httpRequest.getHeader("token");
        Integer userId = TokenUtil.getUserIdByToken(token);
        log.info("filter获取用户Id={}", userId);
        HttpServletRequestWrapper requestWrapper = new HttpServletRequestWrapper(httpRequest) {
            @Override
            public String[] getParameterValues(String name) {
                if ("userId".equals(name)) {
                    return new String[]{userId.toString()};
                }
                return super.getParameterValues(name);
            }

            @Override
            public Enumeration<String> getParameterNames() {
                Set<String> paramNames = new LinkedHashSet<>();
                paramNames.add("userId");
                Enumeration<String> names = super.getParameterNames();
                while (names.hasMoreElements()) {
                    paramNames.add(names.nextElement());
                }
                return Collections.enumeration(paramNames);
            }

            @Override
            public ServletInputStream getInputStream() {
                byte[] requestBody;
                try {
                    requestBody = StreamUtils.copyToByteArray(request.getInputStream());
                    Map map = JsonUtils.toObject(Map.class, new String(requestBody));
                    map.put("userId", userId);
                    requestBody = JsonUtils.toJson(map).getBytes();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

                final ByteArrayInputStream bais = new ByteArrayInputStream(requestBody);
                return new ServletInputStream() {
                    @Override
                    public int read() {
                        return bais.read();
                    }

                    @Override
                    public boolean isFinished() {
                        return false;
                    }

                    @Override
                    public boolean isReady() {
                        return true;
                    }

                    @Override
                    public void setReadListener(ReadListener readListener) {

                    }
                };
            }
        };
        filterChain.doFilter(requestWrapper, httpResponse);
    }
}
