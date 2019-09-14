package edu.iu.imomohimail.firstnetapp;

import android.graphics.Color;
import android.os.Build;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static boolean isUser= false;
    ConstraintLayout  mainvIEW;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initiate a Switch
        mainvIEW = (ConstraintLayout) findViewById(R.id.screen1back);
        CardView cardView = findViewById(R.id.findoption);
        Switch simpleSwitch = (Switch) findViewById(R.id.usersettings);
        mainvIEW.setBackgroundColor(getResources().getColor(R.color.blue));
        final TextView UserType = (TextView) findViewById(R.id.usertypetextview);
        UserType.setText("Citizen");
// check current state of a Switch (true or false).
        Boolean switchState = simpleSwitch.isChecked();
        simpleSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if(b){
                        mainvIEW.setBackgroundColor(getResources().getColor(R.color.red));
                    UserType.setText("First Responder");

                }else {
                    mainvIEW.setBackgroundColor(getResources().getColor(R.color.blue));

                    UserType.setText("Citizen");
                }
            }
        });
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            cardView.setOnContextClickListener(new View.OnContextClickListener() {
                @Override
                public boolean onContextClick(View view) {

                    return false;
                }
            });
        }
    }
}
