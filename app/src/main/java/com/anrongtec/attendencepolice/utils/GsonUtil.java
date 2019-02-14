package com.anrongtec.attendencepolice.utils;

import com.google.gson.Gson;

/**
 * @author Created by huiliu on 2019/1/18.
 * @email liu594545591@126.com
 * @introduce
 */
public class GsonUtil {

    /**
     * 将Json数据解析成相应的映射对象
     */
    public static <T> T parseJsonWithGson(String jsonData, Class<T> tClass) {
        Gson gson = new Gson();
        return gson.fromJson(jsonData, tClass);
    }
}
