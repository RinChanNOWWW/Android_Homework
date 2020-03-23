package chapter.android.aweme.ss.com.homework;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.LinkedList;

/**
 * 作业2：一个抖音笔试题：统计页面所有view的个数
 * Tips：ViewGroup有两个API
 * {@link android.view.ViewGroup #getChildAt(int) #getChildCount()}
 * 用一个TextView展示出来
 */
public class Exercises2 extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exercise2);

        TextView centerTextView = findViewById(R.id.tv_center);
        ViewGroup allViews = findViewById(R.id.all_views);
        centerTextView.setText(String.valueOf(getAllChildViewCount(allViews)));
    }

    public int getAllChildViewCount(ViewGroup view) {
        // BFS 或者 DFS，我不想递归那就 BFS 吧
        int count = 0;
        if (view == null || view.getChildCount() < 1)
            return 0;
        LinkedList<ViewGroup> queue = new LinkedList<>();
        queue.add(view);
        while (!queue.isEmpty()) {
            ViewGroup cur = queue.removeFirst();
            if (cur != view)
                count += 1;
            for (int i = 0; i < cur.getChildCount(); i++) {
                if (cur.getChildAt(i) instanceof ViewGroup) {
                    queue.addLast((ViewGroup) cur.getChildAt(i));
                } else {
                    count += 1;
                }
            }
        }
        return count;
    }
}
