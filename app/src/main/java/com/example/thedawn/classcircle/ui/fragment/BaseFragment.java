package com.example.thedawn.classcircle.ui.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

/**
 * Created by The dawn on 2017/10/19.
 */

public abstract class BaseFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(getlayoutRes(),null);
        ButterKnife.bind(this,root);
        init();
        return root;
    }

    public abstract int getlayoutRes();
    /*初始化*/
    protected  void init(){

    };
    public void goTo(Class activity) {
        Intent intent = new Intent(getContext(), activity);
        startActivity(intent);
        getActivity().finish();
    }
}
