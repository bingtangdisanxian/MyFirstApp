package com.project.mine.base.mvp;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.project.mine.R;
import com.project.mine.bean.request.RequestParamsBean;
import com.project.mine.util.ToastUtils;
import com.project.mine.util.UIUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import rx.Subscription;

/**
 * Created by chenqi on 2017/4/9.
 * 描述:和数据加载相关的Fragment的基类
 */
public abstract class BaseNetFragment<T extends BaseContract.Presenter>
        extends Fragment implements BaseContract.View {

    @BindView(R.id.rl_loading)
    protected RelativeLayout mRlLoading;
    @BindView(R.id.rl_load_error)
    protected RelativeLayout mRlLoadError;
    @BindView(R.id.load_error)
    protected LinearLayout mLoadErrorRetry;

    //请求数据成功的Fragment的容器id须为content_container
    @BindView(R.id.content_container)
    protected FrameLayout mContentContainer;

    protected RequestParamsBean mParams;
    private static final int GRAND = PackageManager.PERMISSION_GRANTED;
    protected Subscription mSubscription;
    protected T mPresenter;
    protected Context mContext;
    protected View mView;
    protected Unbinder mUnbinder;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {
        if (mView == null) {
            mView = inflater.inflate(getLayoutResId(), container, false);
            mUnbinder = ButterKnife.bind(this, mView);
        }
        return mView;
    }

    protected abstract int getLayoutResId();

    @Override
    public void initPresenter(BaseContract.Presenter presenter) {
        mPresenter = (T) presenter;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initData();//初始化网络请求的参数
        initialize();//开始请求

        requestPermissions();
    }

    protected abstract void initData();

    protected abstract void initialize();

    /*请求权限*/
    private void requestPermissions() {
        // 获得权限字符串数组
        final String[] permissions = UIUtils.getStringArr(getPermissionArrId());

        // 判断系统是不是大于等于M
        //        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        if (Build.VERSION.SDK_INT >= 100) {
            boolean result = true;
            for (String permission : permissions) {
                if (GRAND != ActivityCompat.checkSelfPermission(getActivity(), permission)) {
                    result = false;
                    break;
                }
            }
            if (result) {
                requestPermissionSucceed();
            } else {
                new Handler().post(new Runnable() {
                    @Override
                    public void run() {
                        ActivityCompat.requestPermissions(getActivity(), permissions, 0);
                    }
                });
            }
        } else {
            requestPermissionSucceed();
        }
    }

    protected int getPermissionArrId() {
        return R.array.basic_permissions;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        List<String> failed = new ArrayList<>();

        // 检查权限请求结果
        for (int i = 0; i < permissions.length; i++) {
            if (grantResults[i] != GRAND)
                failed.add(permissions[i]);
        }
        // 报告每个请求失败的权限
        if (!failed.isEmpty()) {
            requestPermissionFailed(failed);
            return;
        }
        // 权限请求成功
        requestPermissionSucceed();
    }

    /**
     * 权限请求成功时调用
     */
    protected abstract void requestPermissionSucceed();

    /**
     * 权限请求失败时调用
     */
    protected void requestPermissionFailed(List<String> failedPermissions) {
        ToastUtils.showShortToast(failedPermissions.toString());
    }

    @Override
    public void onLoading() {
        mRlLoading.setVisibility(View.VISIBLE);
        mContentContainer.setVisibility(View.GONE);
        mRlLoadError.setVisibility(View.GONE);
    }

    @Override
    public void onLoadError(String msg, Throwable e) {
        mRlLoading.setVisibility(View.GONE);
        mRlLoadError.setVisibility(View.VISIBLE);
        mContentContainer.setVisibility(View.GONE);
        e.printStackTrace();
        mLoadErrorRetry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetRequest();
            }
        });
    }

    //重新请求
    protected abstract void resetRequest();

    @Override
    public void onLoadSuccess() {
        if (mRlLoading != null) {
            mRlLoading.setVisibility(View.GONE);
        }
        mRlLoadError.setVisibility(View.GONE);
        mContentContainer.setVisibility(View.VISIBLE);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        if (mPresenter != null) {
            mPresenter = null;
        }
        if (mUnbinder != null) {
            mUnbinder.unbind();
        }
        if (mSubscription != null) {
            mSubscription.unsubscribe();
            mSubscription = null;
        }
    }
}
