package chapter.android.aweme.ss.com.homework;

import android.app.Application;
import android.widget.TextView;

public class MyApplication extends Application {
    private  String mLifecycleDisplay;

    public String getLifecycleDisplay() {
        return mLifecycleDisplay;
    }

    public void setLifecycleDisplay(String t) {
        mLifecycleDisplay = t;
    }

}
