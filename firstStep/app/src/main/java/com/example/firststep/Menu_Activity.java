package com.example.firststep;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Menu_Activity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        String message = getIntent().getStringExtra("userName");
        TextView userMessage = findViewById(R.id.userMessage);
        Button greetings = findViewById(R.id.greetings);

        greetings.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                userMessage.setText("");
                userMessage.setText(userMessage.getText() + " Привет, " + message + ". Добро " +
                        "в Газуслуги.");
                }
            }
        );

    }
}