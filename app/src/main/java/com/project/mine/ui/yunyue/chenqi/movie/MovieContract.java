package com.project.mine.ui.yunyue.chenqi.movie;

import com.project.mine.base.mvp.BaseContract;
import com.project.mine.bean.yunyue.movie.SubjectsBean;

import java.util.List;

/**
 * Created by chenqi on 2017/4/25.
 * 描述:
 */
public class MovieContract {

    interface View extends BaseContract.View {
        void showResult(List<SubjectsBean> mListSubjectBean);
    }

    interface Presenter extends BaseContract.Presenter {


    }
}
