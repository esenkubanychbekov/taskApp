package com.e.taskapp_1;

import android.content.DialogInterface;
import android.content.SharedPreferences;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FormActivity extends AppCompatActivity {

    public static String RESULT_KEY = "text_key";

    private EditText editTitle;
    private EditText editDesc;
    private SharedPreferences pref;
    private Button buttonSize;
    Task task;
    AlertDialog alertDialog;
    CharSequence[] values = {"20sp", "30sp", "40sp"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        editTitle = findViewById(R.id.editTitle);
        editDesc = findViewById(R.id.editDesc);
        buttonSize = findViewById(R.id.buttonSize);
        pref = getSharedPreferences("MY_DATA", MODE_PRIVATE);

        task = (Task) getIntent().getSerializableExtra("task");

        if (task!=null){
            editTitle.setText(task.getTitle());
            editDesc.setText(task.getDesc());
        }

        buttonSize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialogWarning();

            }
        });
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

        if (task !=null){
            task.setTitle(sTitle);
            task.setDesc(sDesc);
            App.getInstance().getDataBase().taskDao().update(task);
        } else
        {
            Task task = new Task();
            task.setTitle(sTitle);
            task.setDesc(sDesc);
            App.getInstance().getDataBase().taskDao().insert(task);
        }

        if (sTitle.matches("")){
            Toast.makeText(this, "Поле не должно быть пустым, Заполните поля Title и Descriptiom", Toast.LENGTH_SHORT).show();
            return;
        }
        finish();

    }

    public void AlertDialogWarning() {
        AlertDialog.Builder builder = new AlertDialog.Builder(FormActivity.this);
        builder.setTitle("Выберите размер текста");
        builder.setSingleChoiceItems(values, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int item) {
                switch (item) {
                    case 0:
                        editTitle.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
                        editDesc.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
                        break;
                    case 1:
                        editTitle.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30);
                        editDesc.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30);
                        break;
                    case 2:
                        editTitle.setTextSize(TypedValue.COMPLEX_UNIT_SP, 40);
                        editDesc.setTextSize(TypedValue.COMPLEX_UNIT_SP, 40);
                        break;
                }
                alertDialog.dismiss();

            }
        });
        alertDialog = builder.create();
        alertDialog.show();
    }

}
