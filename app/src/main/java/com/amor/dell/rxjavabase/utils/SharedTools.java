package com.amor.dell.rxjavabase.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import com.amor.dell.rxjavabase.application.BaseApplication;

import static com.amor.dell.rxjavabase.application.BaseApplication.getApplication;

/**
 * share存储工具类
 * 
 * @author Zhuo
 *
 */
public class SharedTools {
	/**
	 * 存储是否为第一次登陆
	 */
	public static void saveFirst(boolean token){
		SharedPreferences sp = getApplication().getSharedPreferences("login", Context.MODE_PRIVATE);
		Editor ed=sp.edit();
		ed.putBoolean("first",token);
		ed.commit();
	}
	/**
	 * 取出为第一次登陆
	 * @return  true 为自动登录 false 为不是
	 */
	public static boolean getFirst(){
		SharedPreferences sp = getApplication().getSharedPreferences("login", Context.MODE_PRIVATE);
		return sp.getBoolean("first", false);
	}

}
