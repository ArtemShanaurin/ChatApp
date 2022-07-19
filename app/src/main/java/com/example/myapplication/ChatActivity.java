package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ChatActivity extends AppCompatActivity {
    private TextView titleOfScreen;
    private TextView textViewChat;
    private EditText message;
    private Button buttonMsg;
    private String textInChatView = "";
    private static final String EXTRA_NICK = "nickName";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        initView();

        message.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(b){
                    message.setHint("");
                }
                message.setText("");
                Log.i("MyRest", message.getText().toString());
            }
        });

        Intent intent = getIntent();
        intent.getStringExtra(EXTRA_NICK);

        String nickName = getIntent().getStringExtra(EXTRA_NICK);
        String title = getString(R.string.write_your_name_s, nickName);
        titleOfScreen.setText(title);

        buttonMsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String resultMsg = message.getText().toString();
                textInChatView += resultMsg +"\n";
                textViewChat.setText(textInChatView);
                message.setText("");


            }
        });

    }

    public static Intent newIntent(Context context, String nickName){
        Intent intent = new Intent(context, ChatActivity.class);
        intent.putExtra(EXTRA_NICK, nickName);
        Log.i("MyResName", nickName);
        return intent;
    }

    private void initView(){
        titleOfScreen = findViewById(R.id.textViewTitleOfScreen);
        textViewChat = findViewById(R.id.textViewChat);
        message = findViewById(R.id.editTextMessage);
        buttonMsg = findViewById(R.id.buttonSendMsg);
    }
}