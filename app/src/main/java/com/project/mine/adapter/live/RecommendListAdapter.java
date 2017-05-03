package com.project.mine.adapter.live;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.project.mine.R;
import com.project.mine.bean.home.module.RoomBean;
import com.project.mine.ui.home.live.impl.LivePlayerActivity;
import com.zhy.adapter.abslistview.CommonAdapter;
import com.zhy.adapter.abslistview.ViewHolder;

import java.util.List;

/**
 * Created by chenqi on 2017/4/20.
 * 描述:
 */
public class RecommendListAdapter extends CommonAdapter<RoomBean> {

    public RecommendListAdapter(Context context, int layoutId, List<RoomBean> datas) {
        super(context, layoutId, datas);
    }

    @Override
    protected void convert(ViewHolder viewHolder, RoomBean item, int position) {
        viewHolder.setText(R.id.tv_column_name, item.name);
        RecyclerView mRecyclerView = (RecyclerView) viewHolder.getConvertView().findViewById(R.id.rcl_room);
        GridLayoutManager myLayoutManager = new GridLayoutManager(mContext, 2);
        mRecyclerView.setLayoutManager(myLayoutManager);
        HomeRoomRcyAdapter homeRoomRcyAdapter = new HomeRoomRcyAdapter(R.layout.recycler_item_room, item.list);
        mRecyclerView.setAdapter(homeRoomRcyAdapter);
        initEvent(homeRoomRcyAdapter, item);
    }

    private void initEvent(HomeRoomRcyAdapter homeRoomRcyAdapter, final RoomBean item) {

        homeRoomRcyAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent =new Intent(mContext, LivePlayerActivity.class);
                intent.putExtra("listBean",item.list.get(position));
                mContext.startActivity(intent);
            }
        });
    }
}
