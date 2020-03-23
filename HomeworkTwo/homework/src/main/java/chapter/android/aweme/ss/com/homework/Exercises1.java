package chapter.android.aweme.ss.com.homework;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * 作业1：
 * Logcat在屏幕旋转的时候 #onStop() #onDestroy()会展示出来
 * 但我们的 mLifecycleDisplay 由于生命周期的原因(Tips:执行#onStop()之后，UI界面我们是看不到的)并没有展示
 * 在原有@see Exercises1 基础上如何补全它，让其跟logcat的展示一样?
 * <p>
 * Tips：思考用比Activity的生命周期要长的来存储？  （比如：application、static变量）
 */
public class Exercises1 extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

}
