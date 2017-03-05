package com.amor.dell.rxjavabase.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;




/**
 * 类名：Fragment 的抽取父类
 * <p/>
 * 描述：抽取一些常用的属性，方法
 *
 * @author：NIU Date：2016/7/18
 */
public abstract class BaseFragment extends Fragment {


    protected View rootView;
    private Activity mActivity;
    public Handler mhandler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            processMsg(msg);
        }
    };

    public final  static  String UPDATE_DATA="android.intent.action.UPDATE_DATA";

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.mActivity=activity;
    }
    //得到可靠地Activity
    public Activity getMyActivity()
    {
        return mActivity;
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


          rootView=initView();

          initData();
     return rootView;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putString("WORKAROUND_FOR_BUG_19917_KEY",  "WORKAROUND_FOR_BUG_19917_VALUE");
        super.onSaveInstanceState(outState);
       // saveStateToArguments();
    }

    /**
     * 加载获取View
     *
     * @return  view View获取的视图;
     */
    public abstract View initView();
    /**
     * 加载获取页面数据
     *
     */
    public abstract void initData();
    /**
     * 解析Message消息
     *
     */
    public abstract void processMsg(Message msg);

    @Override
    public void onDestroy() {
        super.onDestroy();

       /* if (rootView != null) {
            ViewGroup parent = (ViewGroup) rootView.getParent();
            parent.removeView(rootView);
        }*/
        /*if (updateDataReceiver!=null){
            broadcastManager.unregisterReceiver(updateDataReceiver);
        }*/

    }
    @Override
    public void onDetach() {
        super.onDetach();
    }
}
