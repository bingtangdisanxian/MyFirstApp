package com.project.mine.bean.request;

import com.project.mine.constant.RequestConstant;
import com.project.mine.wedgit.refresh.MyPullRefreshFrameLayout;

/**
 * Created by chenqi on 2017/4/8.
 * 描述:网络请求的参数类
 */

public class RequestParamsBean {

    //登陆账号
    public String username;

    //登陆密码
    public String pwd;

    //界面刷新的布局参数
    public MyPullRefreshFrameLayout mLayout;

    //是否是第一次请求
    public boolean theFirstRequest;

    //请求相关的id
    public long id;

    //music界面相关
    public int requestPages;//请求的页数

    public int dataCount;//请求条数

    public String type;//请求类型

    //book界面相关
    public String tag = "";//界面类型

    public int start = 0;//请求开始的索引

    public int count = RequestConstant.REQUEST_COUNTS;


}
