package com.example.thedawn.classcircle.ui.fragment;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.thedawn.classcircle.R;
import com.example.thedawn.classcircle.ui.activity.Class_member;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by The dawn on 2017/10/19.
 */

public class DiscoverFragment extends BaseFragment {


    @BindView(R.id.class_bgimg)
    ImageView mClassBgimg;
    @BindView(R.id.class_more)
    ImageView mClassMore;
    @BindView(R.id.class_name)
    TextView mClassName;
    @BindView(R.id.class_id)
    TextView mClassId;
    @BindView(R.id.qr_code)
    ImageView mQrCode;
    @BindView(R.id.classfragment_relativeLayout)
    RelativeLayout mClassfragmentRelativeLayout;
    @BindView(R.id.class_notice)
    LinearLayout mClassNotice;
    @BindView(R.id.class_document)
    LinearLayout mClassDocument;
    @BindView(R.id.class_photo_album)
    LinearLayout mClassPhotoAlbum;
    @BindView(R.id.class_homework)
    LinearLayout mClassHomework;
    @BindView(R.id.class_vote)
    LinearLayout mClassVote;
    @BindView(R.id.class_function_more)
    LinearLayout mClassFunctionMore;
    @BindView(R.id.class_mynickname)
    TextView mClassMynickname;
    @BindView(R.id.class_arrow_right)
    ImageView mClassArrowRight;
    @BindView(R.id.class_my_namecard)
    RelativeLayout mClassMyNamecard;
    @BindView(R.id.class_firstmember_img)
    ImageView mClassFirstmemberImg;
    @BindView(R.id.class_secondmember_img)
    ImageView mClassSecondmemberImg;
    @BindView(R.id.class_countclassmember)
    TextView mClassCountclassmember;
    @BindView(R.id.class_member)
    RelativeLayout mClassMember;
    @BindView(R.id.classfragment_linearLyout)
    LinearLayout mClassfragmentLinearLyout;

    @Override
    public int getlayoutRes() {
        return R.layout.fragment_discover;
    }

    @Override
    protected void init() {
        super.init();


    }




    @OnClick({R.id.class_more, R.id.qr_code, R.id.class_notice, R.id.class_document, R.id.class_photo_album, R.id.class_homework, R.id.class_vote, R.id.class_function_more, R.id.class_my_namecard, R.id.class_member})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.class_more:
                break;
            case R.id.qr_code:
                break;
            case R.id.class_notice:
                break;
            case R.id.class_document:
                break;
            case R.id.class_photo_album:
                break;
            case R.id.class_homework:
                break;
            case R.id.class_vote:
                break;
            case R.id.class_function_more:
                break;
            case R.id.class_my_namecard:
                break;
            case R.id.class_member:
                goTo(Class_member.class);
                break;
        }
    }
}
