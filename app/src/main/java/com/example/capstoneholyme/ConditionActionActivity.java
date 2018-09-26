package com.example.capstoneholyme;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;

public class ConditionActionActivity extends AppCompatActivity {
    private ArrayList<String> nativeFunctionList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_condition_action);

        final Spinner nativeFunctionSpinner = findViewById(R.id.nativeFunctionSpinner);
        final ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, nativeFunctionList);

        final Button addButton = findViewById(R.id.addButton);
        final Button finishButton = findViewById(R.id.finishButton);

        nativeFunctionList.add("집에서 나갈 때");
        nativeFunctionList.add("집에 들어올 때");
        nativeFunctionList.add("회사에 출근했을 때");
        adapter.notifyDataSetChanged();

        nativeFunctionSpinner.setAdapter(adapter);
    }
}
