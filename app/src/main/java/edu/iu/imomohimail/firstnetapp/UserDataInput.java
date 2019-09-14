package edu.iu.imomohimail.firstnetapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class UserDataInput extends AppCompatActivity {

    String driverLicenseNum, allergies, medications, preferredHospital;
    int age, emergencyContactNumm;

    userInformation user;


    Button submitButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_data_input);



        Button submitButton = findViewById(R.id.addButton);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText driverLicenseNumInfo = findViewById(R.id.driverLicenseNumber);
                EditText ageInfo = findViewById(R.id.ageInput);
                EditText allergiesInfo = findViewById(R.id.allergiesInput);
                EditText medicationsInfo = findViewById(R.id.medicationInput);
                EditText medicalConditionsInfo = findViewById(R.id.conditionsInput);
                EditText emergencyContactInfo = findViewById(R.id.emergencyContactInput);

                user = new userInformation();

                user.setUser_driver_license_number(String.valueOf(driverLicenseNumInfo.getText()));
                user.setAge(String.valueOf(ageInfo));
                user.setAllergies(allergiesInfo.toString());
                user.setMedications(String.valueOf(medicationsInfo));
                user.setMedidcal_conditions(String.valueOf(medicalConditionsInfo));
                user.setEmergency_contact_phone_number(String.valueOf(emergencyContactInfo));


                startActivity(new Intent(UserDataInput.this, consentForm.class));
            }
        });
    }
}
