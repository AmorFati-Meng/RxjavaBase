package com.amor.dell.rxjavabase.interfaces;

import java.util.Map;

import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

/**
 * 类名称：NetService
 * 创建人：amor_fait
 * 创建时间： 2017/3/5.
 * 类描述：
 */

public interface NetService {
    //POST请求
    @FormUrlEncoded
    @POST("")
    Observable<String> getVerfcationCodePost(@Field("tel") String tel, @Field("password") String pass);

    //POST请求
    @FormUrlEncoded
    @POST("")
    Observable<String> getVerfcationCodePostMap(@FieldMap Map<String, String> map);
}
