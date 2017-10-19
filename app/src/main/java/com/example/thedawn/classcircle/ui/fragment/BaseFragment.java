package com.example.thedawn.classcircle.ui.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by The dawn on 2017/10/19.
 */

public abstract class BaseFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(getlayoutRes(),null);
        init();
        return root;
    }

    public abstract int getlayoutRes();
    /*初始化*/
    protected  void init(){

    };
}
