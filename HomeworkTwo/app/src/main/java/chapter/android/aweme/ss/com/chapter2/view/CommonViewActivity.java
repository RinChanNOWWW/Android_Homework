package chapter.android.aweme.ss.com.chapter2.view;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import chapter.android.aweme.ss.com.chapter2.R;

public class CommonViewActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_commonview);
        LinearLayout rootView = findViewById(R.id.root_view);
        findViewById(R.id.btn_linearlayout).setOnClickListener(this);
        findViewById(R.id.btn_releatelayout).setOnClickListener(this);
        findViewById(R.id.btn_framelayout).setOnClickListener(this);
        findViewById(R.id.btn_touchEvent).setOnClickListener(this);

        TextView textView = new TextView(this);
        textView.setTextSize(18.0f);
        textView.setText("Hello World");
        textView.setTextColor(Color.RED);
        rootView.addView(textView);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(CommonViewActivity.this, "this text!", Toast.LENGTH_SHORT).show();
            }
        });


        EditText editText = new EditText(this);
        editText.setTextSize(18.0f);
        editText.setHint("请输入您的名字");
        rootView.addView(editText);


        final ImageView imageView=new ImageView(this);
        imageView.setImageResource(R.drawable.icon_micro_game_comment);
        rootView.addView(imageView,new LinearLayout.LayoutParams(400,400));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_linearlayout:
                startActivity(new Intent(this, LinearLayoutActivity.class));
                break;
            case R.id.btn_releatelayout:
                startActivity(new Intent(this, RelativeLayoutActivity.class));
                break;
            case R.id.btn_framelayout:
                startActivity(new Intent(this, FrameLayoutActivity.class));
                break;
            case R.id.btn_touchEvent:
                startActivity(new Intent(this, TouchEventActivity.class));
                break;
        }
    }
}
