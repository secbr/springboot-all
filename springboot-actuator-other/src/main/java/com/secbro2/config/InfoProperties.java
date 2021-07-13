package com.secbro2.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author sec
 * @version 1.0
 * @date 2021/7/13
 **/
@Component
@ConfigurationProperties(prefix = "info")
public class InfoProperties {

    private String type;

    private String name;

    private String wechat;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat;
    }
}
