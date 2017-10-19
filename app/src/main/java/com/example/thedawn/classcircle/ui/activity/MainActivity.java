package com.example.thedawn.classcircle.ui.activity;

import android.support.annotation.IdRes;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.example.thedawn.classcircle.R;
import com.example.thedawn.classcircle.factory.FragmentFactory;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.BottomBarTab;
import com.roughike.bottombar.OnTabSelectListener;

import butterknife.BindView;

public class MainActivity extends BaseActivity {
    @BindView(R.id.bottomBar)
    BottomBar mBottomBar;

    private FragmentManager mFragmentManager;

    /*@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }*/

    @Override
    public int getlayoutRes() {
        return R.layout.activity_main;
    }

    @Override
    protected void init() {
        super.init();
        mFragmentManager = getSupportFragmentManager();
        initBadge();
        mBottomBar.setOnTabSelectListener(mOnTabSelectListener);
    }

    /*
    * 初始化未读消息
    * */
    private void initBadge() {
        BottomBarTab nearby = mBottomBar.getTabWithId(R.id.tab_home);
        nearby.setBadgeCount(5);
    }




    private OnTabSelectListener mOnTabSelectListener = new OnTabSelectListener() {
        @Override
        public void onTabSelected(@IdRes int tabId) {
            //开始事务
            FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container,FragmentFactory.getInstance().getFragment(tabId));
            //提交事务
            fragmentTransaction.commit();
        }
    };


}
