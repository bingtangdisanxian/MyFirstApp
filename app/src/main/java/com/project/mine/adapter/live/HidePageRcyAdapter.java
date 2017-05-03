package com.project.mine.adapter.live;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.project.mine.R;
import com.project.mine.bean.home.tablayout.LiveCategory;

import java.util.List;

/**
 * Created by chenqi on 2017/4/16.
 * 描述:首页的覆盖页面的数据适配器
 */
public class HidePageRcyAdapter extends BaseMultiItemQuickAdapter<LiveCategory,BaseViewHolder>{

    public HidePageRcyAdapter(List<LiveCategory> data) {
        super(data);
        addItemType(LiveCategory.TEXT, R.layout.item_text_view);
        addItemType(LiveCategory.IMG_TEXT, R.layout.item_iamge_view);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, LiveCategory liveCategory) {
        switch (baseViewHolder.getItemViewType()) {
            case LiveCategory.TEXT:
                baseViewHolder.setText(R.id.tv_other_kind,"其他分类");
                break;
            case LiveCategory.IMG_TEXT:
                baseViewHolder.setText(R.id.tv_game_list,liveCategory.name);
                Glide.with(mContext).load(liveCategory.icon_image).crossFade().into((ImageView) baseViewHolder.getView(R.id.iv_game_list));
                break;
        }
    }
}
