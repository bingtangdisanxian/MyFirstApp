package com.project.mine.ui.home.home;

import com.project.mine.base.mvp.BaseContract;
import com.project.mine.bean.home.tablayout.LiveCategory;

import java.util.List;

/**
 * Created by chenqi on 2017/4/9.
 * 描述:
 */
public interface HomeContract  {

    interface View extends BaseContract.View {
        void showTabLayout(List<LiveCategory> mList);
    }

    interface Presenter extends BaseContract.Presenter{

    }
}
