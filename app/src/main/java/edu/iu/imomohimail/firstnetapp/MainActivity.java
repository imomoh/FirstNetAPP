package edu.iu.imomohimail.firstnetapp;

import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {
    public static boolean isUser= false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initiate a Switch
        final ConstraintLayout  mainvIEW = (ConstraintLayout) findViewById(R.id.screen1back);
        Switch simpleSwitch = (Switch) findViewById(R.id.usersettings);
        mainvIEW.setBackgroundColor(getResources().getColor(R.color.blue));
// check current state of a Switch (true or false).
        Boolean switchState = simpleSwitch.isChecked();
        simpleSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if(b){
                        mainvIEW.setBackgroundColor(getResources().getColor(R.color.red));
                }else {
                    mainvIEW.setBackgroundColor(getResources().getColor(R.color.blue));
                }
            }
        });
    }
}
