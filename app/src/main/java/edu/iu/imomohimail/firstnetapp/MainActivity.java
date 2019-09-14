package edu.iu.imomohimail.firstnetapp;

import android.content.Intent;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import com.parse.ParseInstallation;
import com.parse.ParseUser;

public class MainActivity extends AppCompatActivity {
    public static boolean isUser= true;
    ConstraintLayout  mainvIEW;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        if (ParseUser.getCurrentUser()!=null){
            Boolean type = (Boolean) ParseUser.getCurrentUser().get("type");
            if (type!=null) {
                if (type) {
                    Intent intent = new Intent(getApplicationContext(), UserDataInput.class);
                    startActivity(intent);
                } else {
                    Intent intent2 = new Intent(getApplicationContext(), FirstResponderInput.class);
                    startActivity(intent2);
                }
            }
        }

        mainvIEW = (ConstraintLayout) findViewById(R.id.screen1back);
        Button cardView = findViewById(R.id.findoption);
        Switch simpleSwitch = (Switch) findViewById(R.id.usersettings);
        mainvIEW.setBackgroundColor(getResources().getColor(R.color.blue));
        final TextView UserType = (TextView) findViewById(R.id.usertypetextview);
        UserType.setText("Citizen");
        // Save the current Installation to Back4App
        ParseInstallation.getCurrentInstallation().saveInBackground();
        Boolean switchState = simpleSwitch.isChecked();
        simpleSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if(b){
                        mainvIEW.setBackgroundColor(getResources().getColor(R.color.red));
                    UserType.setText("First Responder");
                    isUser=false;

                }else {
                    mainvIEW.setBackgroundColor(getResources().getColor(R.color.blue));

                    UserType.setText("Citizen");
                    isUser=true;
                }
            }
        });

            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (isUser){
                        Intent intent = new Intent(getApplicationContext(), UserDataInput.class);
                        startActivity(intent);
                    }else {
                        Intent intent2 = new Intent(getApplicationContext(), FirstResponderInput.class);
                        startActivity(intent2);
                    }

                }
            });



    }
}
