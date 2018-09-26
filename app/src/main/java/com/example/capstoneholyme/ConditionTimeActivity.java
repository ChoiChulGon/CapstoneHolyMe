package com.example.capstoneholyme;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class ConditionTimeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_condition_time);

        final Button addButton = findViewById(R.id.addButton);
        final Button finishButton = findViewById(R.id.finishButton);
    }
}
