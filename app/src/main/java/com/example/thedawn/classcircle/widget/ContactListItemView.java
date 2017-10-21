package com.example.thedawn.classcircle.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;

import com.example.thedawn.classcircle.R;

/**
 * Created by The dawn on 2017/10/20.
 */

public class ContactListItemView extends RelativeLayout{

    public ContactListItemView(Context context) {
        this(context,null);
    }

    public ContactListItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.view_contact_list_item,this);
    }
}
