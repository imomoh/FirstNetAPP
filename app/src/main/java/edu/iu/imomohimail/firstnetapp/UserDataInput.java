package edu.iu.imomohimail.firstnetapp;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.room.Room;

public class UserDataInput extends AppCompatActivity {

    String driverLicenseNum, allergies, medications, preferredHospital;
    int age, emergencyContactNumm;

    public static AppDataBase myAppDataBase;
    userInformation user;
    UserInformationDao myDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_data_input);

        myAppDataBase = Room.databaseBuilder(getApplicationContext(), AppDataBase.class,  "health_infodb").allowMainThreadQueries().build();

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


                myDao.addUser(user);


                CharSequence text = "Info Stored!";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(getApplicationContext(), text, duration);
                toast.show();

                driverLicenseNumInfo.setText("");
                ageInfo.setText("");
                allergiesInfo.setText("");
                medicationsInfo.setText("");
                medicalConditionsInfo.setText("");
                emergencyContactInfo.setText("");


                startActivity(new Intent(UserDataInput.this, consentForm.class));
            }
        });
    }
}
