package com.example.typing_test_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainScreenActivity extends AppCompatActivity {
    Button testButton, historyButton, boardButton,
            achievementButton, profileButton, aboutUsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainscreen);
        testButton = findViewById(R.id.test_button);
        historyButton = findViewById(R.id.history_button);
        boardButton = findViewById(R.id.scoreboard_button);
        achievementButton = findViewById(R.id.achievement_button);
        profileButton = findViewById(R.id.profile_button);
        aboutUsButton = findViewById(R.id.credit_button);

        profileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(MainScreenActivity.this,ProfileActivity.class);
                startActivity(i);
            }
        });

        historyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(MainScreenActivity.this,TestHistoryActivity.class);
                startActivity(i);
            }
        });
    }
}