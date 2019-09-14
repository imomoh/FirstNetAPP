package edu.iu.imomohimail.firstnetapp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.widget.TextView;

public class FirstResponderInput extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_responder_input);

        TextView service = findViewById(R.id.serviceprovider);

        TelephonyManager manager = (TelephonyManager)getSystemService(Context.TELEPHONY_SERVICE);
        if (manager!=null) {
            String carrierName = manager.getNetworkOperatorName();
            service.setText(carrierName);
        }


    }
}
