package com.project.mine.base.mvp;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by chenqi on 2017/4/25.
 * 描述:
 */
public abstract class BaseFragment extends Fragment {

    protected Context mContext;
    protected View mView;
    protected Unbinder mUnbinder;
    protected AppCompatActivity mActivity;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
        mActivity = ((AppCompatActivity) getActivity());
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
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initDatas(mActivity);
        initEvents();
    }

    protected void initDatas(AppCompatActivity mActivity) {

    }

    protected void initEvents() {

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mUnbinder != null) {
            mUnbinder.unbind();
        }
    }
}
