package com.rinchannow.homeworkone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button ask_button = findViewById(R.id.ask_button);
        final TextView test_view = findViewById(R.id.text_view);
        final RadioButton ask_name = findViewById(R.id.ask_name), ask_id = findViewById(R.id.ask_id);
        Switch wear_mask = findViewById(R.id.wear_mask);
        final ImageView icon = findViewById(R.id.icon);


        ask_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 根据选了哪个 Radio Button 来设置不同的文本
                if (ask_name.isChecked()) {
                    test_view.setText("I am 何哲宇");
                    Log.d("MainActivity", "Print name");
                } else if (ask_id.isChecked()) {
                    test_view.setText("My id is 2017211613");
                    Log.d("MainActivity", "Print id");
                }
            }
        });

        wear_mask.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    icon.setImageResource(R.mipmap.kano_with_mask);
                    Log.d("MainActivity", "Change to mask image");
                } else {
                    icon.setImageResource(R.mipmap.kano_without_mask);
                    Log.d("MainActivity", "Change to no mask image");
                }
            }
        });
    }
}
