package com.project.mine.ui.yunyue.zhongyuan.recommend;

import com.project.mine.base.mvp.BaseContract;
import com.project.mine.bean.request.RequestParamsBean;
import com.project.mine.bean.yunyue.movie.SubjectsBean;

import java.util.List;

import rx.Subscription;

/**
 * @author 钟教授
 * @time 2017/4/26  13:57
 * @desc ${TODD}
 */

public class DayRecommendedContract {

    interface View extends BaseContract.View {

        void showBanner();

        void showResult(List<SubjectsBean> subjectsBeanList);
    }

    interface Presenter extends BaseContract.Presenter {
        Subscription requestContentData(RequestParamsBean params);
    }
}
