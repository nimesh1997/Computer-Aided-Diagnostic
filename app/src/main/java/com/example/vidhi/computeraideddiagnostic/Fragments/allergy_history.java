package com.example.vidhi.computeraideddiagnostic.Fragments;

import android.database.Cursor;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
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
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class allergy_history extends Fragment {
    DatabaseHelper myDb;
    Button btn;
    Button btn_view;
    EditText allergy;
    ImageView img;
    int flag=0;
    private DatabaseReference mdatabase;
    String RegisteredUserID;
    private FirebaseApp mref;
    String aller="No Information";
    public allergy_history() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_allergy_history, container, false);
        allergy=v.findViewById(R.id.allergy_text);
        btn=v.findViewById(R.id.btn_allergy);
        //btn_view=v.findViewById(R.id.btn_allergy_view);
        img=v.findViewById(R.id.nextimg);
        myDb = new DatabaseHelper(getContext());

        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
        RegisteredUserID=currentUser.getUid();
        mdatabase = FirebaseDatabase.getInstance().getReference().child("Allergy History");
        mdatabase.child(RegisteredUserID).setValue(aller);


        allergy();
        //vieww();
        return v;

    }



    public void allergy()
    {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (flag == 0) {
                    aller = allergy.getText().toString();
                    if (aller.trim().equals("")) {
                        aller = "No Information.";
                    }
                    //boolean isInserted = myDb.insert3(allergy.getText().toString());
//                    boolean isInserted = myDb.insert3(aller);
//                    if (isInserted == true) {

                        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
                        RegisteredUserID=currentUser.getUid();
                        mdatabase = FirebaseDatabase.getInstance().getReference().child("Allergy History");
                        mdatabase.child(RegisteredUserID).setValue(aller);

                        Toast.makeText(getContext(), "data inserted", Toast.LENGTH_SHORT).show();
                        flag = 1;
                        btn.setBackgroundColor(Color.BLUE);
                        btn.setTextColor(Color.WHITE);
                        btn.setText("Data is SAVED");
                        img.setVisibility(View.VISIBLE);
                        img.setFocusable(true);

//                    } else {
//                        Toast.makeText(getContext(), "data not inserted", Toast.LENGTH_SHORT).show();
//                    }
                }
                else {
                    Toast.makeText(getContext(), "One User can submit details only 1 time \n For another details, try with different login.", Toast.LENGTH_SHORT).show();
                     }
            }
        });
    }

//    public void vieww() {
//
//            btn_view.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    Cursor res = myDb.getalldata_allergy();
//
//                    if (res.getCount() == 0) {
//                        Toast.makeText(getContext(), "No data found!!", Toast.LENGTH_SHORT).show();
//                    }
//
//                    StringBuffer buffer1 = new StringBuffer();
//
//                    while (res.moveToNext()) {
//
//                        buffer1.append(res.getString(1) + "\n\n\n");
//
//                    }
//
//
//                    AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
//                    builder.setCancelable(true);
//                    builder.setTitle("ALLERGY HISTORY:");
//                    builder.setMessage(buffer1);
//                    builder.show();
//
//                }
//            });
//        }

    }



