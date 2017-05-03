package com.project.mine.ui.yunyue.zhongyuan.android;

import com.project.mine.base.mvp.BaseContract;
import com.project.mine.bean.yunyue.music.BigAndroidBean;

/**
 * @author 钟教授
 * @time 2017/4/27  13:47
 * @desc ${TODD}
 */

public class BigAndroidContract {
    interface View extends BaseContract.View {

        void showItem(BigAndroidBean bigAndroidBean);
    }

    interface Presenter extends BaseContract.Presenter {

    }
}
