package com.amor.dell.rxjavabase.interfaces;

import com.amor.dell.rxjavabase.activity.BaseActivity;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;

import java.io.InterruptedIOException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import rx.Subscriber;

/**
 * 类名称：UIObserver
 * 创建人：amor_fait
 * 创建时间： 2017/3/5.
 * 类描述：重寫Subscriber簡化類
 */

public abstract class UIObserver<T> extends Subscriber<T> {
    private BaseActivity activity;
    public UIObserver(BaseActivity activity){
        this.activity=activity;
    }
    @Override
    public abstract void onCompleted();

    @Override
    public void onError(Throwable e) {
        String tip="错误";
        if(e instanceof UnknownHostException){
            tip="网络连接失败";
        }else if(e instanceof SocketException){
            tip="网络连接失败";
        }else if(e.getCause() instanceof SocketTimeoutException){
            tip="网络连接超时";
        }else if(e.getCause() instanceof IllegalArgumentException){
            tip="数据格式错误";
        }else if(e instanceof InterruptedIOException){
            tip="网络连接中断";
        }else if(e.getCause() instanceof JsonSyntaxException ||e.getCause() instanceof JsonParseException){
            tip="服务器数据格式错误";
        }
    }

    @Override
    public abstract void onNext(T t);
}
