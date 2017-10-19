package com.example.thedawn.classcircle.factory;


import android.support.v4.app.Fragment;

import com.example.thedawn.classcircle.R;
import com.example.thedawn.classcircle.ui.fragment.ConversationFragment;
import com.example.thedawn.classcircle.ui.fragment.DiscoverFragment;
import com.example.thedawn.classcircle.ui.fragment.HomeFragment;
import com.example.thedawn.classcircle.ui.fragment.MineFragment;

/**
 * Created by The dawn on 2017/10/19.
 */

public class FragmentFactory {

    private  static FragmentFactory sFragmentFactory;
    private Fragment mHomeFragment;
    private Fragment mConversationFragment;
    private Fragment mDiscoverFragment;
    private Fragment mMineFragment;

    private FragmentFactory(){}

    /*
    * 单例模式
    * */

    public static FragmentFactory getInstance(){
        if (sFragmentFactory == null){
            synchronized (FragmentFactory.class){
                if(sFragmentFactory == null){
                    sFragmentFactory = new FragmentFactory();
                }
            }
        }
        return sFragmentFactory;
    }

    /*
    根据不同的tabId来生产不同的fragment
    */

    public Fragment getFragment(int tabId){
        switch (tabId){
            case R.id.tab_home:
                return getHomeFragment();
            case R.id.tab_message:
                return getConversationFragment();
            case R.id.tab_discover:
                return getDiscoverFragment();
            case R.id.tab_mine:
                return getMineFragment();
        }
        return null;
    }

    public Fragment getHomeFragment() {
        if (mHomeFragment == null){
            mHomeFragment = new HomeFragment();
        }
        return mHomeFragment;
    }

    public Fragment getConversationFragment() {
        if (mConversationFragment == null){
            mConversationFragment = new ConversationFragment();
        }
        return mConversationFragment;
    }

    public Fragment getDiscoverFragment() {
        if (mDiscoverFragment == null){
            mDiscoverFragment = new DiscoverFragment();
        }
        return mDiscoverFragment;
    }

    public Fragment getMineFragment() {
        if (mMineFragment == null){
            mMineFragment = new MineFragment();
        }
        return mMineFragment;
    }
}
