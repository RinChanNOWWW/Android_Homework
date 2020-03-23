package chapter.android.aweme.ss.com.chapter2.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;

public class CustomLinearLayout extends LinearLayout {

    private static final String TAG = "TouchEvent";

    public CustomLinearLayout(Context context) {
        super(context);
    }

    public CustomLinearLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomLinearLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public CustomLinearLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.d(TAG, "dispatchTouchEvent Custom: ACTION_DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.d(TAG, "dispatchTouchEvent Custom: ACTION_MOVE");
                break;
            case MotionEvent.ACTION_UP:
                Log.d(TAG, "dispatchTouchEvent Custom: ACTION_UP");
                break;
            case MotionEvent.ACTION_CANCEL:
                Log.d(TAG, "dispatchTouchEvent Custom: ACTION_CANCEL");
                break;
        }
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.d(TAG, "Custom onInterceptTouchEvent");
        return super.onInterceptTouchEvent(ev);//默认都是false
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.d(TAG, "onTouchEvent Custom: ACTION_DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.d(TAG, "onTouchEvent Custom: ACTION_MOVE");
                break;
            case MotionEvent.ACTION_UP:
                Log.d(TAG, "onTouchEvent Custom: ACTION_UP");
                break;
            case MotionEvent.ACTION_CANCEL:
                Log.d(TAG, "onTouchEvent Custom: ACTION_CANCEL");
                break;
        }
        return super.onTouchEvent(event);//默认也是FALSE
    }
}