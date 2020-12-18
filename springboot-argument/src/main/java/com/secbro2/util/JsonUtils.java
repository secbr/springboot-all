package com.secbro2.util;

import com.alibaba.fastjson.JSON;

/**
 * @author sec
 * @version 1.0
 * @date 2020/12/18
 **/
public class JsonUtils {

    /**
     * JAVA对象转换成json字符串
     *
     * @param obj 对象
     * @return json字符串
     */
    public static String toJson(Object obj) {
        if (obj == null) {
            return null;
        }
        return JSON.toJSONString(obj);
    }

    /**
     * json转换成对象
     *
     */
    public static <T> T toObject(Class<T> dest, String json) {
        return JSON.parseObject(json, dest);
    }

}
