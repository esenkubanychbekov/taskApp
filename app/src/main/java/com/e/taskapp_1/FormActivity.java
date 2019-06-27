package com.e.taskapp_1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class FormActivity extends AppCompatActivity {

    public static String RESULT_KEY = "text_key";

    EditText editTitle;
    EditText editDesc;
    Button cancel;
    Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        if (getSupportActionBar() != null)
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

      editTitle = findViewById(R.id.editTitle);
      editDesc = findViewById(R.id.editDesc);
      cancel = findViewById(R.id.cancel);
      save = findViewById(R.id.save);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }

    public  void onClickCancel(View view){
        finish();
    }

    public  void onClickSave(View view){
        Intent intent = new Intent();
        String title = editTitle.getText().toString();
        String desc = editDesc.getText().toString();
        intent.putExtra(RESULT_KEY,title+"\n"+desc);
        setResult(RESULT_OK,intent);
        finish();

    }
}
