package com.secbro2.controller;

import com.secbro2.entity.User;
import com.secbro2.util.TokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author zzs
 */
@Slf4j
@RestController
public class ArgumentController {

    /**
     * 直接从header中获取token进行处理
     */
    @GetMapping("/level1")
    public Integer level1(HttpServletRequest request) {
        String token = request.getHeader("token");
        log.info("level1 获得的token为：{}", token);
        Integer userId = TokenUtil.getUserIdByToken(token);
        log.info("userId={}", userId);
        return userId;
    }

    @GetMapping("/level2")
    public Integer level2(HttpServletRequest request) {
        Integer userId = Integer.parseInt(request.getHeader("userId"));
        log.info("userId={}", userId);
        return userId;
    }

    @GetMapping("/level3")
    public Integer level3(Integer userId) {
        log.info("userId={}", userId);
        return userId;
    }

    @PostMapping("/level4")
    public Integer level4(User user) {
        log.info("userId={}", user.getUserId());
        return user.getUserId();
    }

}
