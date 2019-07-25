package com.e.taskapp_1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class ProfileActivity extends AppCompatActivity {

    public static final String NAME = "name";
    TextView getText;
    EditText name;

    private DocumentReference mDocRef = FirebaseFirestore.getInstance().collection("profileData")
            .document("inspiration");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

    }

    public void onClick(View view) {
        name = findViewById(R.id.editName);
        String profileName = name.getText().toString();
        if (profileName.isEmpty()){
        return;
        }

        Map<String, Object> datatoSave  = new HashMap<String, Object>();
        datatoSave.put(NAME,profileName);
        mDocRef.set(datatoSave).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Log.e("name", "Name has been saved");
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.e("name", "Name was not saved");
            }
        });


    }

    public void fetchCode(View view) {
        mDocRef.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if (documentSnapshot.exists()){
                    String profileName = documentSnapshot.getString(NAME);
                    getText = findViewById(R.id.getText);
                    getText.setText(profileName);
                }
            }
        });
    }
}
