package edu.iu.imomohimail.firstnetapp;

import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.parse.LogInCallback;
import com.parse.ParseAnonymousUtils;
import com.parse.ParseException;
import com.parse.ParseUser;

public class UserDataInput extends AppCompatActivity {

    String allergies, medications, surgicalHistory, preferredHospital;
    int age, emergencyContactNumm;
    String DLN;




    Button submitButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_data_input);

        Button submitButton = findViewById(R.id.addButton);
        final EditText TEXTDLN =(EditText)findViewById(R.id.driverLicenseNumber);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DLN = String.valueOf(TEXTDLN.getText());

                CreateUser();





            }
        });
    }

    private  void  CreateUser(){

        ParseAnonymousUtils.logIn(new LogInCallback() {
            @Override
            public void done(ParseUser user, ParseException e) {
                if (e != null) {
                    Log.d("MyApp", "Anonymous login failed.");
                } else {

                    startActivity(new Intent(UserDataInput.this, consentForm.class));
                    ParseUser.getCurrentUser().put("type",MainActivity.isUser);
                    ParseUser.getCurrentUser().put("DLN",DLN);
                    ParseUser.getCurrentUser().saveInBackground();

                }
            }
        });

    }
}
