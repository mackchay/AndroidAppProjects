package com.example.firststep;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.format.DateUtils;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;


public class MainActivity extends AppCompatActivity {
    Button userDate;
    Calendar date = Calendar.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText userName = findViewById(R.id.userName);
        EditText userSurname = findViewById(R.id.userSurname);
        userDate = findViewById(R.id.userDate);
        EditText userPassword = findViewById(R.id.userPassword);
        EditText userRePassword = findViewById(R.id.userRePassword);

        setInitialDateTime();

        Button register = findViewById(R.id.register);

        TextView userNameWarning = findViewById(R.id.userNameWarning);
        TextView userSurnameWarning = findViewById(R.id.userSurnameWarning);
        TextView userDateWarning = findViewById(R.id.userDateWarning);
        TextView userPasswordWarning = findViewById(R.id.userPasswordWarning);
        TextView userRePasswordWarning = findViewById(R.id.userRePasswordWarning);


        RegisterWarnings userWarning = new RegisterWarnings(userNameWarning, userSurnameWarning,
                userDateWarning, userPasswordWarning, userRePasswordWarning);
        User userFirst = new User(userName, userSurname, userDate, userPassword, userRePassword,
                userWarning);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Menu_Activity.class);
                if (userFirst.getInfo()) {
                    intent.putExtra("userName", userFirst.getUserName().getText().toString());
                    startActivity(intent);
                }
            }
        });

    }

    public void setDate(View v) {
        new DatePickerDialog(MainActivity.this, d,
                date.get(Calendar.YEAR),
                date.get(Calendar.MONTH),
                date.get(Calendar.DAY_OF_MONTH)).show();
    }

    private void setInitialDateTime() {

        userDate.setText(DateUtils.formatDateTime(this,
                date.getTimeInMillis(),
                DateUtils.FORMAT_SHOW_DATE | DateUtils.FORMAT_SHOW_YEAR
                        | DateUtils.FORMAT_SHOW_TIME));
    }

    DatePickerDialog.OnDateSetListener d = new DatePickerDialog.OnDateSetListener() {
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            date.set(Calendar.YEAR, year);
            date.set(Calendar.MONTH, monthOfYear);
            date.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            setInitialDateTime();
        }
    };
}