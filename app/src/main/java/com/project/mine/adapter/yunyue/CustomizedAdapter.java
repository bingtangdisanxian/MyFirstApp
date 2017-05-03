package com.project.mine.adapter.yunyue;

import android.text.TextUtils;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.project.mine.R;
import com.project.mine.bean.yunyue.music.CustomizedBean;

import java.util.List;

/**
 * Created by chenqi on 2017/4/27.
 * 描述:
 */
public class CustomizedAdapter extends BaseQuickAdapter<CustomizedBean.ResultsBean, BaseViewHolder> {

    public CustomizedAdapter(int item_big_android, List<CustomizedBean.ResultsBean> results) {
        super(item_big_android, results);
    }

    @Override
    protected void convert(BaseViewHolder helper, CustomizedBean.ResultsBean item) {
        helper.setText(R.id.title_tv, item.getDesc());
        if (TextUtils.isEmpty(item.getWho())) {
            helper.setText(R.id.who_tv, "佚名" +">"+ item.getType());
        } else {
            helper.setText(R.id.who_tv, item.getWho() +">"+ item.getType());
        }
        List<String> images = item.getImages();
        if (images != null && images.size() != 0) {
            Glide.with(mContext).load(images.get(0)).crossFade().into((ImageView) helper.getView(R.id.imags));
        }
        helper.setText(R.id.time_tv, item.getCreatedAt());
    }
}
