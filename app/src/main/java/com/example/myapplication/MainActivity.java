package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editTextNick;
    private Button buttonCheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        editTextNick.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(b){
                    editTextNick.setHint("");
                }
                editTextNick.setText("");
            }
        });

        buttonCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!editTextNick.getText().toString().isEmpty()){
                    String nickName = editTextNick.getText().toString().trim();
                    launchNextScreen(nickName);
                } else {
                    Toast.makeText(MainActivity.this, "Fill Nick-name", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    private void launchNextScreen(String nickName){
        Intent intent = ChatActivity.newIntent(MainActivity.this, nickName);
        startActivity(intent);
    }

    private void initViews(){
        editTextNick = findViewById(R.id.editTextNickName);
        buttonCheck = findViewById(R.id.buttonCheck);
    }
}