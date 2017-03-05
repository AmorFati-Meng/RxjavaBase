package com.amor.dell.rxjavabase.fragment;

import java.util.HashMap;

/**
 * 类名：
 * <p/>
 * 描述：
 *
 * @author：NIU Date：2016/7/18
 */
public class FragmentFactory {
    private static  BaseFragment fragment;

    public static HashMap<Integer,BaseFragment> mHashMapFragments=new HashMap<Integer,BaseFragment>();




    public static  BaseFragment createFragment(int position){
        fragment=mHashMapFragments.get(position);
        if(fragment==null){
            switch (position){

            }

            mHashMapFragments.put(position,fragment);
        }
        return  fragment;
    }
}
