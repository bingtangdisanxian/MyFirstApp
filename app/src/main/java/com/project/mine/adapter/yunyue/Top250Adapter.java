package com.project.mine.adapter.yunyue;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.project.mine.R;
import com.project.mine.bean.yunyue.movie.SubjectsBean;

import java.util.List;

/**
 * Created by chenqi on 2017/4/27.
 * 描述:
 */
public class Top250Adapter extends BaseQuickAdapter<SubjectsBean,BaseViewHolder> {


    public Top250Adapter(int layoutResId, List<SubjectsBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, SubjectsBean item) {
        helper.setText(R.id.tv_book_name,item.title);
        helper.setText(R.id.tv_book_rate,"评分: "+item.rating.average);
        Glide.with(mContext).load(item.images.large).crossFade().into((ImageView) helper.getView(R.id.iv_book_photo));
    }
}
