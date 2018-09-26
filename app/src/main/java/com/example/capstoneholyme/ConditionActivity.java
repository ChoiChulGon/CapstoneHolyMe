package com.example.capstoneholyme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ConditionActivity extends AppCompatActivity {
    private Bundle bundle;
    private MacroData macroData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_condition);
        bundle = getIntent().getExtras();
        macroData = bundle.getParcelable("macroData");

        final TextView conditionPlaceText = findViewById(R.id.conditionPlaceText);
        final Button actionButton = findViewById(R.id.conditionActionButton);
        final Button timeButton = findViewById(R.id.conditionTimeButton);

        conditionPlaceText.setText("장소 : "+macroData.getMacroPlace());

        actionButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) { // action Button
                Intent intent = new Intent(ConditionActivity.this, ConditionActionActivity.class);
                intent.putExtra("macroData", macroData);
                startActivity(intent);
                finish();
            }
        });

        timeButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) { // time Button
                Intent intent = new Intent(ConditionActivity.this, ConditionTimeActivity.class);
                intent.putExtra("macroData", macroData);
                startActivity(intent);
                finish();
            }
        });
    }
}
