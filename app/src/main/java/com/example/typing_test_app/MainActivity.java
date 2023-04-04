package com.example.typing_test_app;

import static java.sql.DriverManager.println;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        println("this is the second commit test");
        println("this is branch change");
        println("i make some change");
    }
}