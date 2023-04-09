package com.example.typing_test_app;

import static java.sql.DriverManager.println;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainScreenActivity extends AppCompatActivity implements View.OnClickListener{
    Button button_array[] = new Button[6];

    private static final int button_id[] = {R.id.test_char_button, R.id.test_word_button,R.id.history_button,
            R.id.achievement_button, R.id.profile_button, R.id.credit_button};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainscreen);

    for (int i=0; i< button_id.length; i++){
        button_array[i] = findViewById(button_id[i]);
        button_array[i].setOnClickListener(this);
    }

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){

        }
    }
}