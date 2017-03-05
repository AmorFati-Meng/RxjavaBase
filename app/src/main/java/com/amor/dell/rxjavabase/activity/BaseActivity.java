package com.amor.dell.rxjavabase.activity;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;

import com.amor.dell.rxjavabase.R;
import com.amor.dell.rxjavabase.interfaces.ViewInit;

import java.util.ArrayList;
import java.util.List;

/**
 * 类名称：BaseActivity
 * 创建人：amor_fait
 * 创建时间： 2017/3/5.
 * 类描述：
 */

public abstract class BaseActivity  extends FragmentActivity implements View.OnClickListener, ViewInit {

    /**
     * 视图加载容器
     */
    private FrameLayout mFrame;
    /**
     * 上下文
     */
    public static BaseActivity mForegroundActivity = null;

    public static List<Activity> activitieList = new ArrayList<>();

    public Handler mhandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            processMsg(msg);
        }
    };

    private Toolbar toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setMen();
        setContentView(R.layout.activity_base_aty);
        mFrame = (FrameLayout) findViewById(R.id.fly_content);

        addActivity(this);
        initViewFromXML();
    }


    /**
     * 设置需要加载的页面
     */
    public abstract void initView();
    /**
     * 设置需要加载的页面数据
     */
    public abstract void initData();

    @Override
    protected void onResume() {
        super.onResume();
        this.mForegroundActivity = this;
    }

    /**
     * 設置導航欄
     */
    private void setMen() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            //透明状态栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //透明导航栏
            //getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
    }

    /**
     * 解析Message消息
     */
    public abstract void processMsg(Message msg);
    /**
     * 将此Activity加入到活动Activity队列中
     *
     * @param activity
     * @return
     */
    private static boolean addActivity(Activity activity) {
        boolean flag = activitieList.add(activity);
        return flag;
    }
    /**
     * 从活动Activity队列中移除该Activity
     *
     * @param activity
     * @return
     */
    public static boolean removeActivity(Activity activity) {
        boolean flag = activitieList.remove(activity);
        return flag;
    }

    /**
     * 获得所有未关闭的活动（Activity）。
     */
    public static List<Activity> getActivities() {

        List<Activity> copyActivityList = new ArrayList<>(activitieList);

        return copyActivityList;
    }

    public static BaseActivity getForegroundActivity() {
        return mForegroundActivity;
    }

    public void initViewFromXML() {
        // TODO Auto-generated method stub
        try {
            initView();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();

        }

        try {
            initListener();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();

        }

        try {
            initData();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();

        }

    }
    @Override
    public abstract void onClick(View v);

    public void setClick(View... views) {
        for (View view : views) {
            view.setOnClickListener(this);
        }
    }

    public Toolbar getToolbar(){
        return toolbar;
    }
}
