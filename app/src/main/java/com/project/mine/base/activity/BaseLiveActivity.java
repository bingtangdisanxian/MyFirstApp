package com.project.mine.base.activity;

import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.widget.Toast;

import com.project.mine.R;
import com.project.mine.util.NetworkUtils;
import com.project.mine.util.ToastUtils;
import com.project.mine.util.UIUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenqi on 2017/4/24.
 * 描述:
 */
public abstract class BaseLiveActivity extends BaseActivity {

    private static final int GRAND = PackageManager.PERMISSION_GRANTED;
    protected boolean mIsActivityPaused = true;
    protected Toast mToast = null;
    private static final int MESSAGE_ID_RECONNECTING = 0x01;

    @Override
    protected void initWindowParams() {
        super.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);//强制竖屏
    }

    @Override
    protected void initData() {
        initParams();
        initialize();
        requestPermissions();
    }

    protected abstract void initialize();

    protected abstract void initParams();

    /*请求权限*/
    private void requestPermissions() {
        // 获得权限字符串数组
        final String[] permissions = UIUtils.getStringArr(getPermissionArrId());

        // 判断系统是不是大于等于M
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        if (Build.VERSION.SDK_INT >= 100) {
            boolean result = true;
            for (String permission : permissions) {
                if (GRAND != ActivityCompat.checkSelfPermission(this, permission)) {
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
                        ActivityCompat.requestPermissions(BaseLiveActivity.this, permissions, 0);
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

    protected abstract void requestPermissionSucceed();

    protected void requestPermissionFailed(List<String> failedPermissions) {
        ToastUtils.showShortToast(failedPermissions.toString());
    }

    @Override
    protected void onResume() {
        super.onResume();
        mIsActivityPaused = false;
    }

    @Override
    protected void onPause() {
        super.onPause();
        mIsActivityPaused = true;
    }

    @Override
    public void onBackPressed() {
        if (getRequestedOrientation() == ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
            return;
        }
        super.onBackPressed();
    }

    protected void showToastTips(final String tips) {
        if (mIsActivityPaused) {
            return;
        }
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (mToast != null) {
                    mToast.cancel();
                }
                ToastUtils.showShortToast(tips);
            }
        });
    }

    protected Handler mHandler = new Handler(Looper.getMainLooper()) {
        @Override
        public void handleMessage(Message msg) {
            if (msg.what != MESSAGE_ID_RECONNECTING) {
                return;
            }
            if (mIsActivityPaused) {
                finish();
                return;
            }
            if (!NetworkUtils.isConnected()) {
                sendReconnectMessage();
                return;
            }
            toPrepare();
        }
    };

    protected abstract void toPrepare();

    private void sendReconnectMessage() {
        showToastTips("正在重连...");
        mHandler.removeCallbacksAndMessages(null);
        mHandler.sendMessageDelayed(mHandler.obtainMessage(MESSAGE_ID_RECONNECTING), 500);
    }
}
