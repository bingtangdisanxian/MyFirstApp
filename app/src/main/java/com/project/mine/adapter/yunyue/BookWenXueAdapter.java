package com.project.mine.adapter.yunyue;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.project.mine.R;
import com.project.mine.bean.yunyue.book.BookBean;

import java.util.List;

/**
 * Created by chenqi on 2017/4/27.
 * 描述:
 */
public class BookWenXueAdapter extends BaseQuickAdapter<BookBean,BaseViewHolder> {

    public BookWenXueAdapter(int layoutResId, List<BookBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, BookBean item) {
        helper.setText(R.id.tv_book_name,item.title);
        helper.setText(R.id.tv_book_rate,"评分: "+item.rating.average);
        Glide.with(mContext).load(item.images.large).crossFade().into((ImageView) helper.getView(R.id.iv_book_photo));
    }
}
