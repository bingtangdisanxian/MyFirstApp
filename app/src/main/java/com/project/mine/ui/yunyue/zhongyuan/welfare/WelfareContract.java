package com.project.mine.ui.yunyue.zhongyuan.welfare;

import com.project.mine.base.mvp.BaseContract;
import com.project.mine.bean.yunyue.music.WelfareBean;

/**
 * @author 钟教授
 * @time 2017/4/26  22:48
 * @desc ${TODD}
 */

public class WelfareContract {
    interface View extends BaseContract.View {

        void showPic(WelfareBean welfareBean);
    }

    interface Presenter extends BaseContract.Presenter {

    }
}
