package com.project.mine.base.mvp;

/**
 * Created by chenqi on 2017/4/9.
 * 描述:View层应该实现的基本规范
 */
public interface IBaseView<T> {

    void initPresenter(T presenter);
}
