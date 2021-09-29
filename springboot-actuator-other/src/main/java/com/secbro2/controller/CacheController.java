package com.secbro2.controller;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sec
 * @version 1.0
 * @date 2021/7/13
 **/
@RestController
public class CacheController {

    @RequestMapping("/queryAll")
    @Cacheable(value = "queryAll")
    public Map<String, String> queryAll() {
        Map<String, String> map = new HashMap<>();
        map.put("1", "Tom");
        map.put("2", "Steven");
        return map;
    }
}
