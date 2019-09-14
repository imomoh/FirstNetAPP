package edu.iu.imomohimail.firstnetapp;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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
                myDao = new UserInformationDao() {
                    @Override
                    public void addUser(userInformation user) {

                    }
                };


                user.setUser_driver_license_number(String.valueOf(driverLicenseNumInfo.getText()));
                user.setAge(String.valueOf(ageInfo.getText()));
                user.setAllergies(String.valueOf(allergiesInfo.getText()));
                user.setMedications(String.valueOf(medicationsInfo.getText()));
                user.setMedidcal_conditions(String.valueOf(medicalConditionsInfo.getText()));
                user.setEmergency_contact_phone_number(String.valueOf(emergencyContactInfo.getText()));

                if (myDao != null){
                    myDao.addUser(user);
                }



                CharSequence text = user.getUser_driver_license_number();
                CharSequence licenseNumToast = user.getUser_driver_license_number().toString();
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(getApplicationContext(), user.getAllergies(), duration);
                toast.show();

//                Toast toast1 = Toast.makeText(getApplicationContext(), user.getAge(), duration);
//                toast.show();

                driverLicenseNumInfo.setText("");
                ageInfo.setText("");
                allergiesInfo.setText("");
                medicationsInfo.setText("");
                medicalConditionsInfo.setText("");
                emergencyContactInfo.setText("");

                String informationList = user.getUser_driver_license_number().toString() + user.getAge().toString();

//                Log.d("Working", "Log is working");
//                Log.d("Driver License", user.getUser_driver_license_number());
//                Log.d("Working", user.getAge().toString());
//                Log.d("Allergies", user.getAllergies());
//                Log.d("Medications", user.getMedications());
//                Log.d("Medical Conditions", user.getMedidcal_conditions());
//                Log.d("Preferred Hospital", user.getPreferred_hospital());
//                Log.d("Emergency Contact", user.getEmergency_contact_phone_number());
                //startActivity(new Intent(UserDataInput.this, consentForm.class));
            }
        });
    }
}
