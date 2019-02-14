package com.anrongtec.attendencepolice;

import android.app.Application;
import android.content.Context;

import com.anrongtec.attendencepolice.net.ApiServiceFactory;
import com.anrongtec.attendencepolice.net.DataLayer;
import com.anrongtec.attendencepolice.net.NetInterface;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;

/**
 * @author Created by huiliu on 2019/1/18.
 * @email liu594545591@126.com
 * @introduce 考勤
 */
public class KqApp extends Application {

    public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        DataLayer.init(this);

        Logger.addLogAdapter(new AndroidLogAdapter() {
            @Override
            public boolean isLoggable(int priority, String tag) {
                return BuildConfig.DEBUG;
            }
        });
    }

    public static NetInterface getRetrofit() {
        return ApiServiceFactory.getApi();
    }

    public static Context getContext() {
        return context;
    }
}
