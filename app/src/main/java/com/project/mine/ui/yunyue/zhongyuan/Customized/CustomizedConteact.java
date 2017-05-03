package com.project.mine.ui.yunyue.zhongyuan.Customized;

import com.project.mine.base.mvp.BaseContract;
import com.project.mine.bean.yunyue.music.CustomizedBean;

/**
 * @author 钟教授
 * @time 2017/4/27  18:30
 * @desc ${TODD}
 */

public class CustomizedConteact {

    interface View extends BaseContract.View {

        void showResult(CustomizedBean bean);
    }

    interface Presenter extends BaseContract.Presenter {

    }
}
