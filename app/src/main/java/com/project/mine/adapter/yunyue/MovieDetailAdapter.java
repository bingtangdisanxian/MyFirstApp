package com.project.mine.adapter.yunyue;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.project.mine.R;
import com.project.mine.bean.yunyue.movie.PersonBean;

import java.util.List;

/**
 * Created by chenqi on 2017/4/28.
 * 描述:
 */
public class MovieDetailAdapter extends BaseQuickAdapter<PersonBean,BaseViewHolder> {


    public MovieDetailAdapter(int layoutResId, List<PersonBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, PersonBean item) {
        helper.setText(R.id.tv_name,item.name);
        Glide.with(mContext).load(item.avatars.small).crossFade().into((ImageView) helper.getView(R.id.iv_icon));
    }
}
