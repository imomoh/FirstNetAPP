package edu.iu.imomohimail.firstnetapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
    }
}
