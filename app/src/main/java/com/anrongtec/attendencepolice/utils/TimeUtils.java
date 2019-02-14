package com.anrongtec.attendencepolice.utils;

import android.annotation.SuppressLint;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Created by huiliu on 2019/1/18.
 * @email liu594545591@126.com
 * @introduce
 */
public class TimeUtils {
    /**
     * 将时间戳转换为时间
     *
     * @param s 时间戳
     * @return
     */
    public static String timestampToDate(long s) {
        @SuppressLint("SimpleDateFormat")
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return  simpleDateFormat.format(new Date(s));
    }
}
