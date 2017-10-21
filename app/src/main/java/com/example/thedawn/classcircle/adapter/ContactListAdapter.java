package com.example.thedawn.classcircle.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

/**
 * Created by The dawn on 2017/10/20.
 */

public class ContactListAdapter extends RecyclerView.Adapter{
    private Context mContext;
    public ContactListAdapter(Context context){
        mContext = context;
    }

    /*
    * 创建一个viewHolder
    * */
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    /*
    * 绑定viewHolder，拿到对应position位置的数据来渲染holder hold住的view
    * */
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }
    //返回item 的个数
    @Override
    public int getItemCount() {
        return 0;
    }
}
