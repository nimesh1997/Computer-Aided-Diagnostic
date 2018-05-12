package com.example.vidhi.computeraideddiagnostic.Fragments;

import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.vidhi.computeraideddiagnostic.DatabaseHelper;
import com.example.vidhi.computeraideddiagnostic.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class drugs_history extends Fragment {
    DatabaseHelper myDb;
    EditText past_med,curr_med;
    Button btn,btn_view;
    int flag=0;
    ImageView img2;
    private DatabaseReference mdatabase;
    String RegisteredUserID;
    String past="No Information",present="No Information";

    public drugs_history() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        myDb = new DatabaseHelper(getContext());
        View v=inflater.inflate(R.layout.fragment_drugs_history, container, false);
        past_med=v.findViewById(R.id.editText);
        curr_med=v.findViewById(R.id.editText2);
        btn=v.findViewById(R.id.btn_drughistory);
      //  btn_view=v.findViewById(R.id.btn_drughistory_view);
        img2=v.findViewById(R.id.nextimg2);

        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
        RegisteredUserID=currentUser.getUid();
        mdatabase = FirebaseDatabase.getInstance().getReference().child("Drugs History");
        mdatabase.child(RegisteredUserID).child("Past Medicines Used").setValue(past);
        mdatabase.child(RegisteredUserID).child("Current Medicines Taking").setValue(present);

        drug();
        //vieww();
        return v;
    }

    public void drug()
    {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (flag == 0) {
                    past = past_med.getText().toString();
                    present = curr_med.getText().toString();
                    if (past.trim().equals("")) {
                        past = "No Information.";
                    }
                    if (present.trim().equals("")) {
                        present = "No Information.";
                    }
                    //boolean isInserted = myDb.insert4(past_med.getText().toString(),curr_med.getText().toString());
//                    boolean isInserted = myDb.insert4(past, present);
//                    if (isInserted == true) {

                        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
                        RegisteredUserID=currentUser.getUid();
                        mdatabase = FirebaseDatabase.getInstance().getReference().child("Drugs History");
                        mdatabase.child(RegisteredUserID).child("Past Medicines Used").setValue(past);
                        mdatabase.child(RegisteredUserID).child("Current Medicines Taking").setValue(present);


                        Toast.makeText(getContext(), "data inserted", Toast.LENGTH_SHORT).show();
                        flag=1;
                        btn.setBackgroundColor(Color.BLUE);
                        btn.setTextColor(Color.WHITE);
                        btn.setText("Data is SAVED");
                        img2.setVisibility(View.VISIBLE);
                        img2.setFocusable(true);
//                    } else {
//                        Toast.makeText(getContext(), "data not inserted", Toast.LENGTH_SHORT).show();
//                    }
                } else {
                    Toast.makeText(getContext(), "One User can submit details only 1 time \n For another details, try with different login.", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

//    public void vieww()
//    {
//        btn_view.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                    Cursor res = myDb.getalldata_drug();
//
//                    if (res.getCount() == 0) {
//                        Toast.makeText(getContext(), "No data found!!", Toast.LENGTH_SHORT).show();
//                    }
//
//                    StringBuffer buffer1 = new StringBuffer();
//
//                    while (res.moveToNext()) {
//                        buffer1.append("Past Medicines Used:\n" + res.getString(1) + "\n");
//                        buffer1.append("Current Medicines Taking:\n" + res.getString(2) + "\n\n\n");
//
//                    }
//
//
//                    AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
//                    builder.setCancelable(true);
//                    builder.setTitle("CHIEF COMPLAINTS:");
//                    builder.setMessage(buffer1);
//                    builder.show();
//                }
//        });
//    }

}
