package com.project.mine.adapter.yunyue;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.project.mine.R;
import com.project.mine.bean.yunyue.movie.SubjectsBean;

import java.util.List;

/**
 * Created by chenqi on 2017/4/26.
 * 描述:
 */
public class MovieAdapter extends BaseQuickAdapter<SubjectsBean, BaseViewHolder> {


    public MovieAdapter(int layoutResId, List<SubjectsBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, SubjectsBean item) {
        helper.setText(R.id.tv_movie_name, item.title);
        helper.setText(R.id.tv_movie_point, "评分: " + String.valueOf(item.rating.average));
        switch (item.genres.size()) {
            case 1:
                helper.setText(R.id.tv_movie_kind, item.genres.get(0));
                break;
            case 2:
                helper.setText(R.id.tv_movie_kind, item.genres.get(0) + "/" + item.genres.get(1));
                break;
            case 3:
                helper.setText(R.id.tv_movie_kind, item.genres.get(0) + "/" + item.genres.get(1) + "/" + item.genres.get(2));
                break;
        }
        switch (item.directors.size()) {
            case 1:
                helper.setText(R.id.tv_director_name, "导演：" + item.directors.get(0).name);
                break;
            case 2:
                helper.setText(R.id.tv_director_name, "导演：" + item.directors.get(0).name + "/" + item.directors.get(1).name);
                break;
        }
        switch (item.casts.size()) {
            case 1:
                helper.setText(R.id.tv_actor_name, "主演: " + item.casts.get(0).name);
                break;
            case 2:
                helper.setText(R.id.tv_actor_name, "主演: " + item.casts.get(0).name + "/" + item.casts.get(1).name);
                break;
            case 3:
                helper.setText(R.id.tv_actor_name, "主演: " + item.casts.get(0).name + "/" + item.casts.get(1).name + "/" + item.casts.get(2).name);
                break;
        }
        Glide.with(mContext).load(item.images.large).crossFade().into((ImageView) helper.getView(R.id.iv_movie_logo));
    }
}
