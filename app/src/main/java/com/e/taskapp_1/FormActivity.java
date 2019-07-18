package com.e.taskapp_1;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class FormActivity extends AppCompatActivity {

    public static String RESULT_KEY = "text_key";

    private EditText editTitle;
    private EditText editDesc;
    private Button cancel;
    private Button save;
    private SharedPreferences pref;
    EditText textSize;
    Task task;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        pref = getSharedPreferences("MY_DATA", MODE_PRIVATE);
        String sTitle = pref.getString("Title", "");
        String sDesc = pref.getString("Desc", "");

        if (getSupportActionBar() != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        task = (Task) getIntent().getSerializableExtra("task");

        if (task!=null){
            editTitle.setText(task.getTitle());
            editDesc.setText(task.getDesc());
        }

        editTitle = findViewById(R.id.editTitle);
        editDesc = findViewById(R.id.editDesc);
        cancel = findViewById(R.id.cancel);
        save = findViewById(R.id.save);
        textSize = findViewById(R.id.editTextSize);

        editTitle.setText(sTitle);
        editDesc.setText(sDesc);
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(FormActivity.this);
        SharedPreferences.Editor editor = preferences.edit();

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }

    public void onClickCancel(View view) {
        finish();
    }

    public void onClickSave(View view) {

        String sTitle = editTitle.getText().toString().trim();
        String sDesc = editDesc.getText().toString().trim();
        Task task = new Task(sTitle, sDesc);
        App.getDataBase().taskDao().insert(task);
        finish();

    }

}
