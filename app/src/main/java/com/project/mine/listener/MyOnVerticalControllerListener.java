package com.project.mine.listener;

import com.project.mine.ui.home.live.impl.LivePlayerActivity;
import com.project.mine.ui.home.live.impl.LivePlayerHolder;
import com.project.mine.wedgit.media.VerticalMediaControllerView;

/**
 * Created by chenqi on 2017/4/17.
 * 描述:
 */
public class MyOnVerticalControllerListener implements VerticalMediaControllerView.OnVerticalControllListener{

    private LivePlayerActivity activity;
    private LivePlayerHolder playerHolder;

    public MyOnVerticalControllerListener(LivePlayerActivity activity, LivePlayerHolder playerHolder) {
        this.activity = activity;
        this.playerHolder = playerHolder;
    }

    @Override
    public void onVerticalClickPause() {
        if (playerHolder!=null)
            playerHolder.pausePlayer();
    }

    @Override
    public void onVerticalClickStart() {
        if (playerHolder!=null)
            playerHolder.startPlayer();
    }

    @Override
    public void onVerticalClickBack() {
        activity.onBackPressed();
    }
}
