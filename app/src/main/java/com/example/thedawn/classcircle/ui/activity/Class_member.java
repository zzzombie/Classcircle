package com.example.thedawn.classcircle.ui.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.thedawn.classcircle.R;
import com.example.thedawn.classcircle.adapter.ContactListAdapter;

import butterknife.BindView;

import static cn.bmob.newim.core.BmobIMClient.getContext;

/**
 * Created by The dawn on 2017/10/21.
 */

public class Class_member extends BaseActivity {
    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;

    @BindView(R.id.title)
    TextView mTitle;

    @BindView(R.id.add)
    ImageView mAdd;

    private ContactListAdapter mContactListAdapter;

    @Override
    public int getlayoutRes() {
        return R.layout.activity_class_members;
    }

    @Override
    protected void init() {
        super.init();
        mTitle.setText(R.string.contacts);
        mAdd.setVisibility(View.VISIBLE);
        initRecyclerView();
    }

    private void initRecyclerView() {
        mContactListAdapter = new ContactListAdapter(getContext());
        mRecyclerView.setHasFixedSize(true);//设置RecyclerView有固定的大小
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setAdapter(mContactListAdapter);
    }

}
