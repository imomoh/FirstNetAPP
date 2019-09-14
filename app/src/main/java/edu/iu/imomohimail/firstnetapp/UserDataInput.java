package edu.iu.imomohimail.firstnetapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class UserDataInput extends AppCompatActivity {

    String allergies, medications, surgicalHistory, preferredHospital;
    int age, emergencyContactNumm;




    Button submitButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_data_input);

        Button submitButton = findViewById(R.id.addButton);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(UserDataInput.this, consentForm.class));
            }
        });
    }
}
