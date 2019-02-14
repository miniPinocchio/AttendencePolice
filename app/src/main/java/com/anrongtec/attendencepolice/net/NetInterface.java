package com.anrongtec.attendencepolice.net;


import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by Administrator on 2016/6/17.
 *
 * @email liu594545591@126.com
 * @introduce
 */
public interface NetInterface {
    //@GET 代表发送的GET请求
    //article/list/text?page=1 请求的路径(并且加上了基地址)
    //Call<T> 代表返回值的类型，ResponseBody 是Retrofit的原生的返回值
    @GET("article/list/text?page=1")
    Call<ResponseBody> getNetData();

    /**
     * 可以通过Retrofit 直接去解析获取到的json 得到的数据可以直接开始使用
     * TestModle 是gson生成的实体类
     *
     * @return
     */
    @GET("article/list/text?page=1")
    Call<ResponseBody> getNetModle();

    /**
     * 如果是get请求的参数 必须是加了@Field("page") 这个注解 括号里面试服务器接收的参数名字
     * 必须和服务器保持统一
     *
     * @param page
     * @return
     */
    @GET("article/list/text?")
    Call<ResponseBody> getNetModleWithParams(@Field("page") String page);

    /**
     * 动态替换地址
     * 需要替换的地址必须要用"{}"包裹起来，然后通过@path 来声明需要替换的参数
     *
     * @param contents
     * @return
     */
    @GET("article/list/{content}?page=1")
    Call<ResponseBody> getNetModleWithPath(@Path("content") String contents);

    @GET("article/{name}/text?")
    Call<ResponseBody> getNetModlePathWithParams(@Path("name") String list,
                                                 @Field("page") String path);

    /**
     * 通过map传递多个参数
     *
     * @param map
     * @return
     */
    @GET("article/list/text?")
    Call<ResponseBody> getNetModleWithMap(@FieldMap Map<String, String> map);

//-----------------------------------------------------------------------------------------------

    /**
     * 获取排行榜
     * @param filters
     * @return
     */
    @FormUrlEncoded
    @POST("/dcojp-api/ajax/selecHxOrgSign.do")
    Call<String> getAttenRank(@Field("filters") String filters);
}