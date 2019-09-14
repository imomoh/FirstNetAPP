package edu.iu.imomohimail.firstnetapp;


import android.graphics.Color;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.List;

import bolts.Continuation;
import bolts.Task;
import xyz.schwaab.avvylib.AvatarView;


/**
 * A simple {@link Fragment} subclass.
 */
public class FirstResponderProfile extends Fragment {
AvatarView mAvatarView;
String getUsersID;
    TextView prompt;

    public FirstResponderProfile() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view= inflater.inflate(R.layout.fragment_first_responder_profile, container, false);
       mAvatarView= view.findViewById(R.id.avatarView);

        final EditText patientIDnumber = view.findViewById(R.id.PatientID);
         prompt = view.findViewById(R.id.checkpromte);
        Button performSearch = view.findViewById(R.id.performSearch);
        mAvatarView.setAnimating(false);
        mAvatarView.setBorderThickness(18);
        mAvatarView.setHighlightBorderColor(Color.RED);
        mAvatarView.setHighlightBorderColorEnd(Color.BLUE);
        mAvatarView.setNumberOfArches(0);
        mAvatarView.setTotalArchesDegreeArea(80);
        prompt.setVisibility(View.INVISIBLE);
        performSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String ID = String.valueOf(patientIDnumber.getText());
                searchforPatient(ID);
            }
        });
       return view;
    }

    private void searchforPatient(String id){
        ParseQuery query = new ParseQuery("Pati");


        query.whereEqualTo("userID", id);
        mAvatarView.setAnimating(true);

       // query.setLimit(displaylimit);
       // query.setSkip(currentPage * displaylimit);
        query.fromNetwork();
        query.findInBackground().continueWithTask(new Continuation<List<ParseObject>, Task<List<ParseObject>>>() {
            @Override
            public Task<List<ParseObject>> then(Task<List<ParseObject>> task) throws Exception {
                List<ParseObject> objects = task.getResult();
                Exception error = task.getError();
                mAvatarView.setAnimating(false);
                if (error == null) {
                    if (objects.size() > 0) {

                        prompt.setVisibility(View.VISIBLE);

                    }else {

                    }
                }else {

                }

                return null;
            }
        });

    }

}
