package com.project.mine.ui.yunyue.shuaishuai.detail;

import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.project.mine.R;
import com.project.mine.base.activity.BaseActivity;
import com.project.mine.bean.yunyue.book.BookDataBean;

import butterknife.BindView;

/**
 * Created by Gnices on 2017/4/27.
 */

public class BookDetailActivity extends BaseActivity {


    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.book_detail)
    WebView mBookDetail;
    public static final String BOOKBEAN = "bean";
    public static final String POSITION = "position";

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_book_detail;
    }

    //初始化窗口参数
    @Override
    protected void initWindowParams() {
        super.initWindowParams();
        requestImmersion();
    }

    @Override
    protected void initView() {
        setSupportActionBar(mToolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowTitleEnabled(false);//设置标题不可见
        actionBar.setDisplayHomeAsUpEnabled(true);//左上角图标可以被点击
        actionBar.setHomeAsUpIndicator(R.drawable.ic_back);//引导图标
    }

    @Override
    protected void initData() {
        BookDataBean bookDataBean = (BookDataBean) getIntent().getSerializableExtra(BOOKBEAN);
        int position = getIntent().getIntExtra(POSITION, 0);
        mBookDetail.getSettings().setJavaScriptEnabled(true);
        mBookDetail.setWebViewClient(new WebViewClient());
        mBookDetail.loadUrl(bookDataBean.books.get(position).alt);
    }
}
