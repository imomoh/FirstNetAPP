package edu.iu.imomohimail.firstnetapp;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.parse.LogInCallback;
import com.parse.ParseAnonymousUtils;
import com.parse.ParseException;
import com.parse.ParseUser;

public class FirstResponderInput extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_responder_input);

        TextView service = findViewById(R.id.serviceprovider);
        final Button button = findViewById(R.id.startsaving);
        final EditText badgenumber = findViewById(R.id.badgnumber);


        TelephonyManager manager = (TelephonyManager)getSystemService(Context.TELEPHONY_SERVICE);
        if (manager!=null) {
            String carrierName = manager.getNetworkOperatorName();
            service.setText(carrierName);
        }
        if (ParseUser.getCurrentUser()!=null){
            Boolean type = (Boolean) ParseUser.getCurrentUser().get("type");
            if (type!=null) {
                if (type) {

                } else {
                    Fragment fragment = new FirstResponderProfile();
                    // FragmentManager fm = getFragmentManager();
                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.container, fragment);
                    transaction.commit();
                    button.setVisibility(View.INVISIBLE);
                    badgenumber.setVisibility(View.INVISIBLE);

                }
            }
        }



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ParseAnonymousUtils.logIn(new LogInCallback() {
                    @Override
                    public void done(ParseUser user, ParseException e) {
                        if (e != null) {
                            Log.d("MyApp", "Anonymous login failed.");
                        } else {
                            Fragment fragment = new FirstResponderProfile();

                            // FragmentManager fm = getFragmentManager();
                            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                            transaction.replace(R.id.container, fragment);
                            transaction.commit();
                            button.setVisibility(View.INVISIBLE);
                            badgenumber.setVisibility(View.INVISIBLE);

                            ParseUser.getCurrentUser().put("type",MainActivity.isUser);
                            ParseUser.getCurrentUser().saveInBackground();

                        }
                    }
                });


            }
        });


    }
}
