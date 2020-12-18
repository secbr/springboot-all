package com.secbro2.resolver;

import com.secbro2.annotation.CurrentUser;
import com.secbro2.entity.User;
import com.secbro2.util.TokenUtil;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

/**
 * 有@CurrentUserId注解的方法参数，注入当前登录用户
 *
 * @author zzs
 */
@Component
public class LoginUserHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.hasParameterAnnotation(CurrentUser.class) &&
                parameter.getParameterType().isAssignableFrom(User.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer container,
                                  NativeWebRequest request, WebDataBinderFactory factory) {
        // header中获取用户token
        String token = request.getHeader("token");
        Integer userId = TokenUtil.getUserIdByToken(token);
        // TODO 根据userId获取User信息，这里省略，直接创建一个User对象。
        User user = new User();
        user.setName("Tom");
        user.setUserId(userId);
        return user;
    }
}
