/*
 * Copyright (c) 2015-present, Parse, LLC.
 * All rights reserved.
 *
 * This source code is licensed under the BSD-style license found in the
 * LICENSE file in the root directory of this source tree. An additional grant
 * of patent rights can be found in the PATENTS file in the same directory.
 */
package edu.iu.imomohimail.firstnetapp;

import android.app.Application;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;
import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseInstallation;

import androidx.annotation.NonNull;

import static androidx.constraintlayout.widget.Constraints.TAG;


public class StarterApplication extends Application {

  @Override
  public void onCreate() {
    super.onCreate();
    FirebaseInstanceId.getInstance().getInstanceId()
            .addOnCompleteListener(new OnCompleteListener<InstanceIdResult>() {
              @Override
              public void onComplete(@NonNull Task<InstanceIdResult> task) {
                if (!task.isSuccessful()) {
                  Log.w(TAG, "getInstanceId failed", task.getException());
                  return;
                }
                String token = task.getResult().getToken();
                Intent i = new Intent();
                i.setAction("com.google.android.c2dm.intent.REGISTRATION");
                i.putExtra("registration_id", token);
                sendBroadcast(i);
                // Get new Instance ID token

                ParseInstallation installation = ParseInstallation.getCurrentInstallation();
                installation.put("GCMSenderId", "1056181869133");
                //installation.put("deviceToken", token);
                installation.saveInBackground();
                Parse.setLogLevel(Parse.LOG_LEVEL_VERBOSE);


              }
            });


    // Enable Local Datastore.
    Parse.enableLocalDatastore(this);

    // Add your initialization code here
    Parse.initialize(new Parse.Configuration.Builder(getApplicationContext())
            .applicationId("9ihSKAzkxT3by7Q8KCdITyQFpL1LxGK3haGKGejE")
            .clientKey( "rMzfsfWIb5V2lUitNdRg7lAzpv9v5u5veBrgRkiJ")
            .server( "https://parseapi.back4app.com/")
            .enableLocalDataStore()
            .build()
    );

    ParseACL defaultACL = new ParseACL();
    defaultACL.setPublicReadAccess(true);
    defaultACL.setPublicWriteAccess(true);
    ParseACL.setDefaultACL(defaultACL, true);


  }
}
