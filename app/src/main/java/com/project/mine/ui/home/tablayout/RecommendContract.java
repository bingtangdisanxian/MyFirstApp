package com.project.mine.ui.home.tablayout;

import com.project.mine.base.mvp.BaseContract;
import com.project.mine.bean.home.banner.BannerBean;
import com.project.mine.bean.home.module.RoomBean;

import java.util.List;

import rx.Subscription;

/**
 * Created by chenqi on 2017/4/13.
 * 描述:
 */
public interface RecommendContract {

    interface View extends BaseContract.View {

        void showListModule(List<RoomBean> roomBeen);

        void showBanner(List<BannerBean> bannerBeen);
    }

    interface Presenter extends BaseContract.Presenter {

        Subscription requestBannerData();
    }
}
