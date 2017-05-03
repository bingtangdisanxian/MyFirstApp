package com.project.mine.wedgit.refresh;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;

import in.srain.cube.views.ptr.PtrClassicFrameLayout;

public class MyPullRefreshFrameLayout extends PtrClassicFrameLayout {

    public MyPullRefreshFrameLayout(Context context) {
        super(context);
    }

    public MyPullRefreshFrameLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    private float mStartX = 0;
    private float mStartY = 0;
    private float mOffsetXOneTouch = 0;
    private float mOffsetYOneTouch = 0;

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        int eventAction = event.getAction();
        switch (eventAction) {
            case MotionEvent.ACTION_DOWN:
                mStartX = event.getX();
                mStartY = event.getY();
                mOffsetXOneTouch = 0;
                mOffsetYOneTouch = 0;
                break;
            case MotionEvent.ACTION_MOVE:
                float newX = event.getX();
                float newY = event.getY();
                float dx = newX - mStartX;
                float dy = newY - mStartY;
                mOffsetXOneTouch += dx;
                mOffsetYOneTouch += dy;
                if (Math.abs(mOffsetXOneTouch) > ViewConfiguration.getTouchSlop()
                        && Math.abs(mOffsetXOneTouch) > Math.abs(mOffsetYOneTouch)) {
                    //认为是主要在x方向上有移动
                    return dispatchTouchEventSupper(event);
                }
                mStartX = newX;
                mStartY = newY;
                break;
            case MotionEvent.ACTION_UP:
                break;
        }
        return super.dispatchTouchEvent(event);//走该方法,这个触摸事件还是会分发到子控件
    }
}
