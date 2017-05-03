package com.project.mine.ui;

import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.KeyEvent;
import android.view.MenuItem;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.project.mine.R;
import com.project.mine.base.activity.BaseActivity;
import com.project.mine.listener.MyBottomNavigationBar;
import com.project.mine.ui.home.home.HomeNetFragment;
import com.project.mine.ui.yunyue.base.YunYueNetFragment;
import com.project.mine.util.ToastUtils;

import butterknife.BindView;

public class MainActivity extends BaseActivity {

    @BindView(R.id.bnb_guide)
    BottomNavigationBar mBnbGuide;
    @BindView(R.id.nv_layout)
    NavigationView mNvLayout;
    @BindView(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;
    private YunYueNetFragment mYunYueFragment;
    private HomeNetFragment mHomeFragment;
    private boolean isClikced;
    private Handler handler = new Handler();

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        requestImmersion();//请求沉浸式
        //添加底部导航栏
        addBottomNavigationBar();
        //添加第一个fragment
        setDefaultFragment();
    }

    private void addBottomNavigationBar() {
        mBnbGuide
                .addItem(new BottomNavigationItem(R.drawable.bottom_navigation_item_home, "阅读"))
                .addItem(new BottomNavigationItem(R.drawable.bottom_navigation_item_live, "游戏"))
                .setMode(BottomNavigationBar.MODE_FIXED)//展示模式
                .setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_RIPPLE)//背景风格
                .setActiveColor(R.color.Bottom_Navigation_Bar_background)//底部导航栏背景
                .setInActiveColor(R.color.Bottom_Navigation_Bar_InActiveColor)//未选中的item的背景
                .setBarBackgroundColor(R.color.Bottom_Navigation_Bar_ActiveColor)//选中的item的背景
                .setFirstSelectedPosition(0)//默认选中的item
                .initialise();
        mBnbGuide.setTabSelectedListener(new MyBottomNavigationBar() {
            @Override
            public void onTabSelected(int position) {
                setTabSelected(position);
            }
        });
    }

    private void setDefaultFragment() {
        FragmentManager manager = getSupportFragmentManager();
        mYunYueFragment = YunYueNetFragment.newInstance();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.fl_fragment_content, mYunYueFragment);
        transaction.commit();
    }

    private void setTabSelected(int position) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        //隐藏所有的fragment
        hideFragment(transaction);
        switch (position) {
            case 0:
                if (mYunYueFragment == null) {
                    mYunYueFragment = YunYueNetFragment.newInstance();
                    transaction.add(R.id.fl_fragment_content, mYunYueFragment);
                } else {
                    transaction.show(mYunYueFragment);
                }
                break;
            case 1:
                if (mHomeFragment == null) {
                    mHomeFragment = HomeNetFragment.newInstance();
                    transaction.add(R.id.fl_fragment_content, mHomeFragment);
                } else {
                    transaction.show(mHomeFragment);
                }
                break;
        }
        transaction.commit();
    }

    private void hideFragment(FragmentTransaction transaction) {
        if (mYunYueFragment != null) {
            transaction.hide(mYunYueFragment);
        }
        if (mHomeFragment != null) {
            transaction.hide(mHomeFragment);
        }
    }

    //点击引导图标弹出侧滑菜单
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            mDrawerLayout.openDrawer(GravityCompat.START);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {

        switch (keyCode) {
            case KeyEvent.KEYCODE_BACK:
                if (isClikced) {
                    finish();
                    return super.onKeyUp(keyCode, event);
                }
                isClikced = true;
                ToastUtils.showShortToast("再按一次退出");
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        isClikced = false;
                    }
                }, 3000);
                break;
        }
        return false;
    }

    @Override
    protected void initEvent() {
        mNvLayout.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.slid_home:
                        mDrawerLayout.closeDrawers();
                        break;
                    case R.id.slid_collect:
                        ToastUtils.showShortToast("扫码");
                    case R.id.slid_question:
                        ToastUtils.showShortToast("问题反馈");
                        break;
                    case R.id.slid_theme:
                        ToastUtils.showShortToast("主题切换");
                        break;
                    case R.id.slid_loading:
                        ToastUtils.showShortToast("登陆");
                        break;
                    case R.id.slid_about:
                        ToastUtils.showShortToast("关于");
                        break;
                    case R.id.slid_exit:
                        ToastUtils.showShortToast("退出");
                        break;
                }
                return true;
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ToastUtils.cancelToast();
        handler.removeCallbacksAndMessages(this);
    }
}
