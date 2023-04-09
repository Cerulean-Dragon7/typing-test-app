package com.example.typing_test_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class AboutusActivity extends AppCompatActivity {

    ImageButton backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aboutus);

        backButton = findViewById(R.id.back_button_about_us);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(AboutusActivity.this,MainScreenActivity.class);
                startActivity(i);
            }
        });
    }
}
//HI