package com.project.mine.adapter.yunyue;

import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.project.mine.R;
import com.project.mine.bean.yunyue.music.BigAndroidBean;
import com.project.mine.util.UIUtils;

import java.util.List;


/**
 * @author 钟教授
 * @time 2017/4/27  14:09
 * @desc ${TODD}
 */

public class BigAndroidAdapter extends RecyclerView.Adapter<BigAndroidAdapter.MyViewHolder> {

    private BigAndroidBean mAndroidBean;
    private List<BigAndroidBean.ResultsBean> mResults;

    public BigAndroidAdapter(BigAndroidBean bigAndroidBean) {
        mAndroidBean = bigAndroidBean;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_big_android, parent
                , false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        mResults = mAndroidBean.getResults();
        BigAndroidBean.ResultsBean resultsBean = mResults.get(position);
        holder.mTitleTv.setText(resultsBean.getDesc());
        if (TextUtils.isEmpty(resultsBean.getWho())) {
            holder.mWhoTv.setText("佚名");
        } else {
            holder.mWhoTv.setText(resultsBean.getWho());
        }
        List<String> images = resultsBean.getImages();

        Glide.with(UIUtils.getContext()).load(images.get(0)).into(holder.mImags);
        String createdAt = resultsBean.getCreatedAt();
        String publishedAt = resultsBean.getPublishedAt();
        holder.mTimeTv.setText(createdAt);
    }

    @Override
    public int getItemCount() {
        return mResults != null ? mResults.size() : 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private final TextView mTitleTv;
        private final ImageView mImags;
        private final TextView mWhoTv;
        private final TextView mTimeTv;

        public MyViewHolder(View itemView) {
            super(itemView);
            mTitleTv = (TextView) itemView.findViewById(R.id.title_tv);
            mWhoTv = (TextView) itemView.findViewById(R.id.who_tv);
            mImags = (ImageView) itemView.findViewById(R.id.imags);
            mTimeTv = (TextView) itemView.findViewById(R.id.time_tv);
        }
    }
}
