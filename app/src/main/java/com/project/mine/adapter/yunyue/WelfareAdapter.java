package com.project.mine.adapter.yunyue;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.project.mine.R;
import com.project.mine.bean.yunyue.music.WelfareBean;
import com.project.mine.listener.WelfareClickListener;
import com.project.mine.util.UIUtils;

import java.util.List;

/**
 * @author 钟教授
 * @time 2017/4/26  23:22
 * @desc ${TODD}
 */

public class WelfareAdapter extends RecyclerView.Adapter<WelfareAdapter.MyViewHolder> {

    private List<WelfareBean.ResultsBean> mDatas;

    public WelfareAdapter(List<WelfareBean.ResultsBean> results) {
        mDatas = results;
    }

    private WelfareClickListener mListener;

    public void setWelfareClickListener(WelfareClickListener listener) {
        mListener = listener;
    }

    @Override
    public WelfareAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.welfare_item, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(WelfareAdapter.MyViewHolder holder, final int position) {

        Glide.with(UIUtils.getContext()).load(mDatas.get(position).getUrl()).into(holder.mItemPIc);
        holder.mItemPIc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.OnClickListener(position);
            }
        });
    }


    @Override
    public int getItemCount() {
        return mDatas != null ? mDatas.size() : 0;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        private final ImageView mItemPIc;

        public MyViewHolder(View itemView) {
            super(itemView);
            mItemPIc = (ImageView) itemView.findViewById(R.id.iv);
        }
    }


}
