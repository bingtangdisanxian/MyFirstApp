package com.project.mine.ui.yunyue.chenqi.detail;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.project.mine.R;
import com.project.mine.adapter.yunyue.MovieDetailAdapter;
import com.project.mine.base.activity.BaseHeaderActivity;
import com.project.mine.bean.yunyue.movie.MovieDetailBean;
import com.project.mine.bean.yunyue.movie.SubjectsBean;
import com.project.mine.data.net.AppManager;
import com.project.mine.util.CommonUtils;
import com.project.mine.util.JsonUtil;
import com.project.mine.util.StringFormatUtil;
import com.project.mine.wedgit.floatBar.AnimationUtils;
import com.project.mine.wedgit.floatBar.FloatingDraftButton;
import com.project.mine.wedgit.toast.CustomToast;

import java.io.IOException;

import butterknife.BindView;
import okhttp3.ResponseBody;
import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by chenqi on 2017/4/27.
 * 描述:
 */
public class DetailActivity extends BaseHeaderActivity {

    public static final String BEAN = "bean";
    private SubjectsBean mSubjectsBean;
    private String mMoreUrl;
    private WebView mWebView;
    @BindView(R.id.floatingActionButton_main)
    FloatingDraftButton mFloatingActionButtonMain;
    @BindView(R.id.floatingActionButton_1)
    FloatingActionButton mFloatingActionButton1;
    //    @BindView(R.id.floatingActionButton_2)
    //    FloatingActionButton mFloatingActionButton2;
    @BindView(R.id.floatingActionButton_3)
    FloatingActionButton mFloatingActionButton3;
    //    @BindView(R.id.floatingActionButton_4)
    //    FloatingActionButton mFloatingActionButton4;
    @BindView(R.id.floatingActionButton_5)
    FloatingActionButton mFloatingActionButton5;

    //    private Handler mHandler, uiHandler;
    //    private RelativeLayout mRelativeLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_movie_detail);
        mWebView = (WebView) findViewById(R.id.wv_detail);
        mSubjectsBean = (SubjectsBean) getIntent().getSerializableExtra(BEAN);
        setFloatingActionButton();
        initSlideShapeTheme(setHeaderImgUrl(), setHeaderImageView());
        setTitle(mSubjectsBean.title);
        setSubTitle(String.format("主演：%s", StringFormatUtil.formatName(mSubjectsBean.casts)));
        loadMovieDetail();

        //        initHandler();
    }

    //    private void initHandler() {
    //        mHandler = new Handler() {
    //            @Override
    //            public void handleMessage(Message msg) {
    //                //一定是在子线程
    //                changeColor();
    //            }
    //        };
    //        uiHandler = new Handler() {
    //            @Override
    //            public void handleMessage(Message msg) {
    //                int color = msg.arg1;
    //                mRelativeLayout.setBackgroundColor(color);
    //            }
    //        };
    //    }

    private void setFloatingActionButton() {
        Glide.with(this).load(mSubjectsBean.images.large).crossFade().into(mFloatingActionButtonMain);
        mFloatingActionButtonMain.registerButton(mFloatingActionButton1);
        //        mFloatingActionButtonMain.registerButton(mFloatingActionButton2);
        mFloatingActionButtonMain.registerButton(mFloatingActionButton3);
        //        mFloatingActionButtonMain.registerButton(mFloatingActionButton4);
        mFloatingActionButtonMain.registerButton(mFloatingActionButton5);
        initEvent();
    }

    private void initEvent() {
        mFloatingActionButtonMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AnimationUtils.slideButtons(DetailActivity.this, mFloatingActionButtonMain);
            }
        });

        mFloatingActionButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!TextUtils.isEmpty(mMoreUrl)) {
                    goToDetail();
                }
            }
        });

        mFloatingActionButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "查看上一部电影", Snackbar.LENGTH_LONG)
                        .setAction("确定", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                showCustomToast("风好大,你说啥???",R.drawable.ic_custom_toast1);
                            }
                        })
                        .show();
            }
        });

        mFloatingActionButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "不查看下一部电影,留在此页", Snackbar.LENGTH_SHORT)
                        .setAction("确定", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                showCustomToast("哦,好的",R.drawable.ic_custom_toast);
                            }
                        })
                        .show();
            }
        });
    }

    private void showCustomToast(String text ,int resId) {
        CustomToast st = new CustomToast(this, text, Toast.LENGTH_LONG);
        st.setBackgroundColor(Color.parseColor("#ffce3d3a"));
        st.setTextColor(Color.WHITE);
        st.setIcon(resId);
        st.setIcon(resId);
        st.spinIcon();
        st.setMaxAlpha();
        st.show();
    }

    @Override
    protected void setTitleClickMore() {
        goToDetail();
    }

    private void goToDetail() {
        mWebView.setVisibility(View.VISIBLE);
        mWebView.getSettings().setJavaScriptEnabled(true);
        // 避免重定向跳到系统的浏览器中,需要做处理
        mWebView.setWebViewClient(new WebViewClient());
        mWebView.loadUrl(mMoreUrl);
    }

    @Override
    protected int setHeaderLayout() {
        return R.layout.header_slide_shape;
    }

    @Override
    protected String setHeaderImgUrl() {
        if (mSubjectsBean == null) {
            return "";
        }
        return mSubjectsBean.images.medium;
    }

    @Override
    protected ImageView setHeaderImageView() {
        return (ImageView) bindingHeaderView.findViewById(R.id.img_item_bg);
    }

    private void loadMovieDetail() {
        Subscription subscribe = AppManager.getInstance().getDouBanService().getMovieDetail(mSubjectsBean.id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(json2ListData)
                .subscribe(new Observer<MovieDetailBean>() {
                    @Override
                    public void onCompleted() {
                        showContentView();
                    }

                    @Override
                    public void onError(Throwable e) {
                        showError();
                    }

                    @Override
                    public void onNext(final MovieDetailBean movieDetailBean) {
                        showResult(movieDetailBean);
                    }
                });
        addSubscription(subscribe);
    }

    private Func1<ResponseBody, MovieDetailBean> json2ListData = new Func1<ResponseBody, MovieDetailBean>() {
        @Override
        public MovieDetailBean call(ResponseBody response) {
            return parseRequestData(response);
        }
    };

    private MovieDetailBean parseRequestData(ResponseBody response) {
        MovieDetailBean movieBean = null;
        try {
            String string = response.string();
            movieBean = JsonUtil.parseJson(string, MovieDetailBean.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return movieBean;
    }

    private void showResult(final MovieDetailBean movieDetailBean) {

        //        mRelativeLayout = (RelativeLayout) bindingHeaderView.findViewById(R.id.rl_head);

        // 上映日期
        TextView tvOneDay = (TextView) bindingHeaderView.findViewById(R.id.tv_one_day);
        // 制片国家
        TextView tvOneCity = (TextView) bindingHeaderView.findViewById(R.id.tv_one_city);

        TextView actor = (TextView) bindingHeaderView.findViewById(R.id.tv_one_casts);

        TextView directors = (TextView) bindingHeaderView.findViewById(R.id.tv_one_directors);

        TextView genres = (TextView) bindingHeaderView.findViewById(R.id.tv_one_genres);

        TextView rating = (TextView) bindingHeaderView.findViewById(R.id.tv_one_rating_rate);

        ImageView imageView = (ImageView) bindingHeaderView.findViewById(R.id.iv_one_photo);

        Glide.with(this).load(movieDetailBean.images.large).crossFade().into(imageView);

        rating.setText("评分" + movieDetailBean.rating.average);

        switch (movieDetailBean.genres.size()) {
            case 1:
                genres.setText(movieDetailBean.genres.get(0));
                break;
            case 2:
                genres.setText(movieDetailBean.genres.get(0) + "/" + movieDetailBean.genres.get(1));
                break;
            case 3:
                genres.setText(movieDetailBean.genres.get(0) + "/" + movieDetailBean.genres.get(1) + "/" + movieDetailBean.genres.get(2));
                break;
        }

        switch (movieDetailBean.directors.size()) {
            case 1:
                directors.setText("导演：" + movieDetailBean.directors.get(0).name);
                break;
            case 2:
                directors.setText("导演：" + movieDetailBean.directors.get(0).name + "/" + movieDetailBean.directors.get(1).name);
                break;
        }

        switch (movieDetailBean.casts.size()) {
            case 1:
                actor.setText("主演: " + movieDetailBean.casts.get(0).name);
                break;
            case 2:
                actor.setText("主演: " + movieDetailBean.casts.get(0).name + "/" + movieDetailBean.casts.get(1).name);
                break;
            case 3:
                actor.setText("主演: " + movieDetailBean.casts.get(0).name + "/" + movieDetailBean.casts.get(1).name + "/" + movieDetailBean.casts.get(2).name);
                break;
            case 4:
                actor.setText("主演: " + movieDetailBean.casts.get(0).name + "/" + movieDetailBean.casts.get(1).name + "/" + movieDetailBean.casts.get(2).name + "/" + movieDetailBean.casts.get(3).name);
                break;
        }
        tvOneDay.setText(String.format("上映日期：%s", movieDetailBean.year));
        tvOneCity.setText(String.format("制片国家/地区：%s", StringFormatUtil.formatGenres(movieDetailBean.countries)));
        mMoreUrl = movieDetailBean.alt;


        TextView juqing = (TextView) bindingContentView.findViewById(R.id.tv_juqing);

        TextView biecheng = (TextView) bindingContentView.findViewById(R.id.tv_biecheng);

        switch (movieDetailBean.aka.size()) {
            case 1:
                biecheng.setText("别名 : " + movieDetailBean.aka.get(0));
                break;
            case 2:
                biecheng.setText("别名 : " + movieDetailBean.aka.get(0) + "/" + movieDetailBean.aka.get(1));
                break;
            case 3:
                biecheng.setText("别名 : " + movieDetailBean.aka.get(0) + "/" + movieDetailBean.aka.get(1) + "/" + movieDetailBean.aka.get(2));
                break;
            case 4:
                biecheng.setText("别名 : " + movieDetailBean.aka.get(0) + "/" + movieDetailBean.aka.get(1) + "/" + movieDetailBean.aka.get(2) + "/" + movieDetailBean.aka.get(3));
                break;
            case 5:
                biecheng.setText("别名 : " + movieDetailBean.aka.get(0) + "/" + movieDetailBean.aka.get(1) + "/" + movieDetailBean.aka.get(2) + "/" + movieDetailBean.aka.get(3) + "/" + movieDetailBean.aka.get(4));
                break;
        }
        juqing.setText("剧情简介: " + movieDetailBean.summary);


        RecyclerView recyclerView = (RecyclerView) bindingContentView.findViewById(R.id.rcl_cast);
        recyclerView.setVisibility(View.VISIBLE);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        MovieDetailAdapter detailAdapter = new MovieDetailAdapter(R.layout.item_movie_detail_activity, movieDetailBean.casts);
        recyclerView.setAdapter(detailAdapter);
        detailAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                mWebView.setVisibility(View.VISIBLE);
                mWebView.getSettings().setJavaScriptEnabled(true);
                // 避免重定向跳到系统的浏览器中,需要做处理
                mWebView.setWebViewClient(new WebViewClient());
                mWebView.loadUrl(movieDetailBean.casts.get(position).alt);
            }
        });
    }

    public static void start(Activity context, SubjectsBean positionData, ImageView imageView) {
        Intent intent = new Intent(context, DetailActivity.class);
        intent.putExtra(BEAN, positionData);

        ActivityOptionsCompat options =
                ActivityOptionsCompat.makeSceneTransitionAnimation(context,
                        imageView, CommonUtils.getString(R.string.transition_movie_img));//与xml文件对应

        ActivityCompat.startActivity(context, intent, options.toBundle());
    }

    //    public void changeColor() {
    //
    //        Bitmap bm = BitmapFactory.decodeResource(getResources(), R.id.iv_one_photo);
    //        Palette.from(bm).generate(new Palette.PaletteAsyncListener() {
    //            @Override
    //            public void onGenerated(Palette palette) {
    //                if (palette.getDarkMutedSwatch() != null) {
    //
    //                    int color = palette.getDarkMutedSwatch().getRgb();
    //
    //                    Message message = uiHandler.obtainMessage();
    //                    message.arg1 = color;
    //                    uiHandler.sendMessage(message);
    //
    //                } else if (palette.getLightVibrantSwatch() != null) {
    //
    //                    int color = palette.getLightVibrantSwatch().getRgb();
    //
    //                    Message message = uiHandler.obtainMessage();
    //                    message.arg1 = color;
    //                    uiHandler.sendMessage(message);
    //                }
    //            }
    //        });
    //    }
}





