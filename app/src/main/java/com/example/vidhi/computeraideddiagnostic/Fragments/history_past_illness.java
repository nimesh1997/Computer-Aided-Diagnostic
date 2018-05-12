package com.example.vidhi.computeraideddiagnostic.Fragments;

import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.vidhi.computeraideddiagnostic.DatabaseHelper;
import com.example.vidhi.computeraideddiagnostic.Models.History_past;
import com.example.vidhi.computeraideddiagnostic.Models.PatientBioData;
import com.example.vidhi.computeraideddiagnostic.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;


public class history_past_illness extends Fragment {

    CheckBox others_surgical,head,leg,eye,chest;
    EditText others_surgical_history,medical_history;
    private static final String TAG1="vidhi2";
    DatabaseHelper myDb;
    Button btn;
    Button btn_view;
    int flag=0;
    int head1=0,leg1=0,eye1=0,chest1=0,others_surgical1=0;
    ImageView img5;
    private DatabaseReference mdatabase;
    String RegisteredUserID;
    String headd="No",legg="No",eyee="No",chestt="No",others="No Information",medical="No Information";


    public history_past_illness() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        myDb = new DatabaseHelper(getContext());
        View v = inflater.inflate(R.layout.fragment_history_past_illness, container, false);
        others_surgical =(CheckBox) v.findViewById(R.id.others_surgical);
        others_surgical_history=(EditText) v.findViewById(R.id.others_surgical_history);
        btn=v.findViewById(R.id.btn_pasthistory);
        head=v.findViewById(R.id.head);
        leg=v.findViewById(R.id.leg);
        eye=v.findViewById(R.id.eye);
        chest=v.findViewById(R.id.chest);
        medical_history=v.findViewById(R.id.others_medical_history);
    //    btn_view=v.findViewById(R.id.btn_pasthistory_view);
        img5=v.findViewById(R.id.nextimg5);

        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
        RegisteredUserID=currentUser.getUid();
        mdatabase = FirebaseDatabase.getInstance().getReference().child("Past Illness");
        mdatabase.child(RegisteredUserID).child("Head").setValue(headd);
        mdatabase.child(RegisteredUserID).child("Leg").setValue(legg);
        mdatabase.child(RegisteredUserID).child("Eye").setValue(eyee);
        mdatabase.child(RegisteredUserID).child("Chest").setValue(chestt);
        mdatabase.child(RegisteredUserID).child("Others").setValue(others);
        mdatabase.child(RegisteredUserID).child("MEDICAL HISTORY").setValue(medical);

        click();
       // viewpast();
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        others_surgical.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(others_surgical.isChecked()) {
                    others_surgical_history.setVisibility(View.VISIBLE);
                }
                else {
                    others_surgical_history.setVisibility(View.GONE);
                }

            }
        });

    }



    public void click()
    {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (flag == 0) {
                    if (head.isChecked()) {
                        head1 = 1;
                        headd="Yes";
                    }
                    if (leg.isChecked()) {
                        leg1 = 1;
                        legg="Yes";
                    }
                    if (eye.isChecked()) {
                        eye1 = 1;
                        eyee="Yes";
                    }
                    if (chest.isChecked()) {
                        chest1 = 1;
                        chestt="Yes";
                    }
                    if (others_surgical.isChecked()) {
                        others_surgical1 = 1;
                    }
                    others = others_surgical_history.getText().toString();
                    medical = medical_history.getText().toString();
                    if (others.trim().equals("")) {
                        others = "No Information.";
                    }
                    if (medical.trim().equals("")) {
                        medical = "No Information";
                    }
                    //boolean isInserted = myDb.insert1(head1,leg1,eye1,chest1,others_surgical1,others_surgical_history.getText().toString(),medical_history.getText().toString());
//                    boolean isInserted = myDb.insert1(head1, leg1, eye1, chest1, others_surgical1, others, medical);
//                    if (isInserted == true) {

                        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
                        RegisteredUserID=currentUser.getUid();
                        mdatabase = FirebaseDatabase.getInstance().getReference().child("Past Illness");
                        mdatabase.child(RegisteredUserID).child("Head").setValue(headd);
                        mdatabase.child(RegisteredUserID).child("Leg").setValue(legg);
                        mdatabase.child(RegisteredUserID).child("Eye").setValue(eyee);
                        mdatabase.child(RegisteredUserID).child("Chest").setValue(chestt);
                        mdatabase.child(RegisteredUserID).child("Others").setValue(others);
                        mdatabase.child(RegisteredUserID).child("MEDICAL HISTORY").setValue(medical);

                        Toast.makeText(getContext(), "data inserted", Toast.LENGTH_SHORT).show();
                        flag=1;
                        btn.setBackgroundColor(Color.BLUE);
                        btn.setTextColor(Color.WHITE);
                        btn.setText("Data is SAVED");
                        img5.setVisibility(View.VISIBLE);
                        img5.setFocusable(true);
//                    } else {
//                        Toast.makeText(getContext(), "data not inserted", Toast.LENGTH_SHORT).show();
//                    }

                } else {
                    Toast.makeText(getContext(), "One User can submit details only 1 time \n For another details, try with different login.", Toast.LENGTH_SHORT).show();
                }
            }




        });
    }

//    public void viewpast()
//    {
//        btn_view.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Cursor res = myDb.getalldata_past();
//
//                if (res.getCount() == 0) {
//                    Toast.makeText(getContext(), "No data found!!", Toast.LENGTH_SHORT).show();
//                }
//
//                StringBuffer buffer = new StringBuffer();
//
//                while (res.moveToNext()) {
//                    buffer.append("Head:" + res.getInt(1) + "\n");
//                    buffer.append("Leg:" + res.getInt(2) + "\n");
//                    buffer.append("Eye:" + res.getInt(3) + "\n");
//                    buffer.append("Chest:" + res.getInt(4) + "\n");
//                    buffer.append("Others:" + res.getInt(5) + "\n");
//                    buffer.append("Other Surgical History:" + res.getString(6) + "\n");
//                    buffer.append("Medical History:" + res.getString(7) + "\n\n\n");
//
//                }
//
//
//
//                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
//                builder.setCancelable(true);
//                builder.setTitle("PAST ILLNESS:");
//                builder.setMessage(buffer);
//                builder.show();
//
//            }
//
//
//        });
//    }


}
