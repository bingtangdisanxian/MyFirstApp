package com.project.mine.ui.home.live.impl;

import android.content.Context;
import android.media.AudioManager;
import android.os.PowerManager;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.pili.pldroid.player.AVOptions;
import com.pili.pldroid.player.PLMediaPlayer;
import com.project.mine.util.LogUtils;
import com.project.mine.util.UIUtils;

import static com.bumptech.glide.gifdecoder.GifHeaderParser.TAG;

/**
 * Created by chenqi on 2017/4/20.
 * 描述:
 */
public class LivePlayerHolder {

    private Integer codec;
    private LivePlayerActivity mActivity;
//    private LivePlayerActivity mActivity;
    private AVOptions mAVOptions;
    public int mSurfaceWidth;
    public int mSurfaceHeight;
    public SurfaceView mSurfaceView;
    public PLMediaPlayer mMediaPlayer;
    private String mVideoPath;
    private boolean mIsStopped = false;

    public LivePlayerHolder(LivePlayerActivity mActivity, SurfaceView surfaceView, Integer codec, String mVideoPath) {
        this.mActivity = mActivity;
        this.codec = codec;
        this.mVideoPath = mVideoPath;
        this.mSurfaceView = surfaceView;

        mSurfaceView.getHolder().addCallback(mCallback);
        mAVOptions = new AVOptions();
        mAVOptions.setInteger(AVOptions.KEY_PREPARE_TIMEOUT, 10 * 1000);
        mAVOptions.setInteger(AVOptions.KEY_GET_AV_FRAME_TIMEOUT, 10 * 1000);
        mAVOptions.setInteger(AVOptions.KEY_LIVE_STREAMING, 1);
        mAVOptions.setInteger(AVOptions.KEY_DELAY_OPTIMIZATION, 1);
        mAVOptions.setInteger(AVOptions.KEY_MEDIACODEC, codec);

        mAVOptions.setInteger(AVOptions.KEY_START_ON_PREPARED, 0);
        AudioManager audioManager = (AudioManager) UIUtils.getContext().getSystemService(Context.AUDIO_SERVICE);
        audioManager.requestAudioFocus(null, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN);
    }

    private SurfaceHolder.Callback mCallback = new SurfaceHolder.Callback() {

        @Override
        public void surfaceCreated(SurfaceHolder holder) {
            prepare();
        }

        @Override
        public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
            mSurfaceWidth = width;
            mSurfaceHeight = height;
        }

        @Override
        public void surfaceDestroyed(SurfaceHolder holder) {
            release();
        }
    };

    private PLMediaPlayer.OnVideoSizeChangedListener mOnVideoSizeChangedListener = new PLMediaPlayer.OnVideoSizeChangedListener() {
        public void onVideoSizeChanged(PLMediaPlayer mp, int width, int height) {
            if (width != 0 && height != 0) {
                float ratioW = (float) width / (float) mSurfaceWidth;
                float ratioH = (float) height / (float) mSurfaceHeight;
                float ratio = Math.max(ratioW, ratioH);
                width = (int) Math.ceil((float) width / ratio);
                height = (int) Math.ceil((float) height / ratio);
            }
        }
    };

    private PLMediaPlayer.OnPreparedListener mOnPreparedListener = new PLMediaPlayer.OnPreparedListener() {
        @Override
        public void onPrepared(PLMediaPlayer mp) {
            startPlayer();
            mIsStopped = false;
        }
    };

    public void startPlayer() {

        if (mIsStopped || mMediaPlayer == null) {
            prepare();
        } else {
            mMediaPlayer.start();
            mActivity.onPlayerStart();
        }
    }

    private PLMediaPlayer.OnInfoListener mOnInfoListener = new PLMediaPlayer.OnInfoListener() {
        @Override
        public boolean onInfo(PLMediaPlayer mp, int what, int extra) {
            switch (what) {
                case PLMediaPlayer.MEDIA_INFO_BUFFERING_START:
                    mActivity.initialize();
                    break;
                case PLMediaPlayer.MEDIA_INFO_BUFFERING_END:
                case PLMediaPlayer.MEDIA_INFO_VIDEO_RENDERING_START:
                    mActivity.onConnectSuccess();
                    break;
            }
            return true;
        }
    };

    private PLMediaPlayer.OnCompletionListener mOnCompletionListener = new PLMediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(PLMediaPlayer mp) {
            mActivity.finish(); //// TODO: 2016/11/27 播放完成
        }
    };

    private PLMediaPlayer.OnErrorListener mOnErrorListener = new PLMediaPlayer.OnErrorListener() {
        @Override
        public boolean onError(PLMediaPlayer mp, int errorCode) {
            boolean isNeedReconnect = false;
            switch (errorCode) {
                case PLMediaPlayer.ERROR_CODE_INVALID_URI:
                    showToastTips("Invalid URL !");
                    break;
                case PLMediaPlayer.ERROR_CODE_404_NOT_FOUND:
                    showToastTips("404 resource not found !");
                    break;
                case PLMediaPlayer.ERROR_CODE_CONNECTION_REFUSED:
                    showToastTips("Connection refused !");
                    break;
                case PLMediaPlayer.ERROR_CODE_CONNECTION_TIMEOUT:
                    showToastTips("Connection timeout !");
                    isNeedReconnect = true;
                    break;
                case PLMediaPlayer.ERROR_CODE_EMPTY_PLAYLIST:
                    showToastTips("Empty playlist !");
                    break;
                case PLMediaPlayer.ERROR_CODE_STREAM_DISCONNECTED:
                    showToastTips("Stream disconnected !");
                    isNeedReconnect = true;
                    break;
                case PLMediaPlayer.ERROR_CODE_IO_ERROR:
                    showToastTips("Network IO Error !");
                    isNeedReconnect = true;
                    break;
                case PLMediaPlayer.ERROR_CODE_UNAUTHORIZED:
                    showToastTips("Unauthorized Error !");
                    break;
                case PLMediaPlayer.ERROR_CODE_PREPARE_TIMEOUT:
                    showToastTips("Prepare timeout !");
                    isNeedReconnect = true;
                    break;
                case PLMediaPlayer.ERROR_CODE_READ_FRAME_TIMEOUT:
                    showToastTips("Read frame timeout !");
                    isNeedReconnect = true;
                    break;
                case PLMediaPlayer.MEDIA_ERROR_UNKNOWN:
                    break;
                default:
                    showToastTips("unknown error !");
                    break;
            }
            release();
            if (isNeedReconnect) {
                mActivity.onReConnecting();
                prepare();
            } else {
                mActivity.finish();
            }
            return true;
        }
    };

    private void showToastTips(String msg) {
        LogUtils.i(TAG + msg);
    }

    public void prepare() {

        if (mMediaPlayer != null) {
            mMediaPlayer.setDisplay(mSurfaceView.getHolder());
            return;
        }
        try {
            mMediaPlayer = new PLMediaPlayer(mActivity, mAVOptions);
            mMediaPlayer.setOnPreparedListener(mOnPreparedListener);
            mMediaPlayer.setOnVideoSizeChangedListener(mOnVideoSizeChangedListener);
            mMediaPlayer.setOnCompletionListener(mOnCompletionListener);
            mMediaPlayer.setOnErrorListener(mOnErrorListener);
            mMediaPlayer.setOnInfoListener(mOnInfoListener);
            mMediaPlayer.setOnBufferingUpdateListener(mOnBufferingUpdateListener);
            mMediaPlayer.setWakeMode(mActivity, PowerManager.PARTIAL_WAKE_LOCK);
            mMediaPlayer.setDataSource(mVideoPath);
            mMediaPlayer.setDisplay(mSurfaceView.getHolder());
            mMediaPlayer.prepareAsync();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private PLMediaPlayer.OnBufferingUpdateListener mOnBufferingUpdateListener = new PLMediaPlayer.OnBufferingUpdateListener() {
        @Override
        public void onBufferingUpdate(PLMediaPlayer mp, int percent) {
        }
    };

    public void pausePlayer() {
        if (mMediaPlayer != null)
            mMediaPlayer.pause();
    }

    public void stopPlayer() {
        if (mMediaPlayer != null) {
            mIsStopped = true;
            mMediaPlayer.stop();
            mMediaPlayer.reset();
        }

        mMediaPlayer = null;
    }

    public void releaseWithoutStop() {
        if (mMediaPlayer != null) {
            mMediaPlayer.setDisplay(null);
        }
    }

    public void onResume() {
        mSurfaceView.getHolder().addCallback(mCallback);
        startPlayer();
    }

    public void onPause() {
        pausePlayer();
    }

    public void release() {
        if (mMediaPlayer != null) {
            mMediaPlayer.stop();
            mMediaPlayer.release();
            mMediaPlayer = null;
        }
        if (mSurfaceView.getHolder() != null) {
            mSurfaceView.getHolder().removeCallback(mCallback);
        }
        AudioManager audioManager = (AudioManager) UIUtils.getContext().getSystemService(Context.AUDIO_SERVICE);
        audioManager.abandonAudioFocus(null);
    }
}
