package com.project.mine.ui.yunyue.shuaishuai.wenxue;

import com.project.mine.base.mvp.BaseContract;
import com.project.mine.bean.yunyue.book.BookDataBean;

/**
 * Created by Gnices on 2017/4/26.
 */

public interface WenXueContract {

    interface View extends BaseContract.View {

        void showBookContent(BookDataBean dataBean);
    }

    interface Presenter extends BaseContract.Presenter {


    }
}
