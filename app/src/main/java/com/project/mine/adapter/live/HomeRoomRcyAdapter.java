package com.project.mine.adapter.live;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.project.mine.R;
import com.project.mine.bean.home.module.ListBean;

import java.util.List;

/**
 * Created by chenqi on 2017/4/15.
 * 描述:
 */
public class HomeRoomRcyAdapter extends BaseQuickAdapter<ListBean, BaseViewHolder> {

    public HomeRoomRcyAdapter(int ResId, List<ListBean> data) {
        super(ResId, data);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, ListBean listBean) {
        baseViewHolder.setText(R.id.tv_number, listBean.view)
                .setText(R.id.nick_name, listBean.title)
                .setText(R.id.room_title, listBean.nick);
        Glide.with(mContext).load(listBean.thumb).crossFade().into((ImageView) baseViewHolder.getView(R.id.iv_thumb));
        Glide.with(mContext).load(listBean.avatar).crossFade().into((ImageView) baseViewHolder.getView(R.id.icon_head));
    }
}
