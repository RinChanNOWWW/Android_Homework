package chapter.android.aweme.ss.com.chapter2.listview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import chapter.android.aweme.ss.com.chapter2.R;

public class ListViewActivity extends AppCompatActivity {
    private Toast mToast;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);
        ListView listView = (ListView) findViewById(R.id.list_numbers);
        listView.setAdapter(new ListBaseAdapter());
        listView.setDivider(null);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (mToast != null) {
                    mToast.cancel();
                }
                String toastMessage = "Item #" + position + " clicked.";
                mToast = Toast.makeText(ListViewActivity.this, toastMessage, Toast.LENGTH_LONG);
                mToast.show();
            }
        });
    }
}
