package com.project.mine.ui.yunyue.shuaishuai.book;

import android.support.v4.view.ViewPager;

import com.project.mine.R;
import com.project.mine.adapter.yunyue.BookAdapter;
import com.project.mine.base.mvp.BaseNetFragment;
import com.project.mine.wedgit.tablayout.DachshundIndicator;
import com.project.mine.wedgit.tablayout.DachshundTabLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by chenqi on 2017/4/25.
 * 描述:
 */
public class BookFragment extends BaseNetFragment<BookContract.Presenter>
        implements BookContract.View {

    @BindView(R.id.tab_layout)
    DachshundTabLayout mTabLayout;
    @BindView(R.id.view_pager)
    ViewPager mViewPager;

    private List<String> mTiletName ;   //顶部导航栏



    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_book;
    }

    @Override
    protected void initData() {
        mTiletName = new ArrayList<>();
        mTiletName.add("文学");
        mTiletName.add("文化");
        mTiletName.add("生活");
        mViewPager.setAdapter(new BookAdapter(getActivity().getSupportFragmentManager(), mTiletName));
        mTabLayout.setupWithViewPager(mViewPager);
        mTabLayout.setAnimatedIndicator(new DachshundIndicator(mTabLayout));
    }

    @Override
    protected void initialize() {

    }

    @Override
    protected void requestPermissionSucceed() {

    }

    @Override
    protected void resetRequest() {

    }

    public static BookFragment newInstance() {
        BookFragment bookFragment = new BookFragment();
        new BookPresenter(bookFragment);
        return bookFragment;

    }
}
