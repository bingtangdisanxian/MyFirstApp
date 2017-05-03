package com.project.mine.listener;

import com.project.mine.ui.home.live.impl.LivePlayerActivity;
import com.project.mine.ui.home.live.impl.LivePlayerHolder;
import com.project.mine.wedgit.media.HorMediaControllerView;

/**
 * Created by chenqi on 2017/4/17.
 * 描述:
 */
public class MyOnHorControllListener implements HorMediaControllerView.OnHorControllerListener{

    private LivePlayerActivity activity;
    private LivePlayerHolder playerHolder;

    public MyOnHorControllListener(LivePlayerActivity activity, LivePlayerHolder playerHolder) {
        this.activity = activity;
        this.playerHolder = playerHolder;

    }

    @Override
    public void onHorClickPause() {
        playerHolder.onPause();
    }

    @Override
    public void onHorClickStart() {
        activity.onPlayerStart();
    }

    @Override
    public void onHorClickBack() {
        activity.onBackPressed();
    }
}
