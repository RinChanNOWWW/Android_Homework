package chapter.android.aweme.ss.com.homework;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class ChatRoomActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_chatroom);

        Intent intent = getIntent();
        final String title = intent.getStringExtra("title");
        String text = intent.getStringExtra("description");

        final TextView name = findViewById(R.id.tv_with_name);
        final ImageView send = findViewById(R.id.btn_send_info);
        final EditText text_to_send = findViewById(R.id.ed_say);
        final TextView textView = findViewById(R.id.tv_content_info);

        name.setText(String.format(getResources().getString(R.string.chat_room_title), title));
        textView.setText(title + ": " + text + "\n");

        send.setEnabled(false);

        text_to_send.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (TextUtils.isEmpty(text_to_send.getText())) {
                    send.setEnabled(false);
                } else {
                    send.setEnabled(true);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("hezheyu", "Click Send Button");
                textView.append("我: " + text_to_send.getText() + "\n");
                textView.append(title + ": " + text_to_send.getText() + "\n");
                text_to_send.setText("");
            }
        });
    }
}
