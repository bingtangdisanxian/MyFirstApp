package com.project.mine.ui.yunyue.chenqi.rank;

import com.project.mine.base.mvp.BaseContract;
import com.project.mine.bean.yunyue.movie.SubjectsBean;

import java.util.List;

/**
 * Created by chenqi on 2017/4/26.
 * 描述:
 */
public class MovieTopContract {

    interface View extends BaseContract.View {
        void showTop250Movies(List<SubjectsBean> subjectsBeanList);
    }

    interface Presenter extends BaseContract.Presenter {

    }
}
