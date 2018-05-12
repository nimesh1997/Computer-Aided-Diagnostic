package com.example.vidhi.computeraideddiagnostic.Fragments;

import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
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
import com.example.vidhi.computeraideddiagnostic.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class family_history extends Fragment {

    DatabaseHelper myDb;

    CheckBox others_f,others_m,others_s,diabetes_f,thyroid_f,hyp_f,diabetes_m,diabetes_s,thyroid_m,thyroid_s,hyp_m,hyp_s;
    EditText other_father,others_mother,others_siblings;
    Button btn;
    Button btn_view;
    ImageView img3;
    int flag=0;
    int dia_f1=0,dia_m1=0,dia_s1=0,thy_f1=0,thy_m1=0,thy_s1=0,hyp_f1=0,hyp_m1=0,hyp_s1=0,others_f1=0,others_m1=0,others_s1=0;
    StringBuilder stringBuilder,s1,s2;
    private DatabaseReference mdatabase;
    String RegisteredUserID,father="No Information",mother="No Information",siblings="No Information";
    public family_history() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        myDb = new DatabaseHelper(getContext());
        View v= inflater.inflate(R.layout.fragment_family_history, container, false);
        img3=v.findViewById(R.id.nextimg3);
        others_f=(CheckBox) v.findViewById(R.id.others_f);
        others_m=(CheckBox) v.findViewById(R.id.others_m);
        others_s=(CheckBox) v.findViewById(R.id.others_s);
        other_father=(EditText)v.findViewById(R.id.others_father);
        others_mother=(EditText)v.findViewById(R.id.others_mother);
        others_siblings=(EditText)v.findViewById(R.id.others_siblings);
        diabetes_f=(CheckBox) v.findViewById(R.id.diabetes_f);
        diabetes_m=(CheckBox) v.findViewById(R.id.diabetes_m);
        diabetes_s=(CheckBox) v.findViewById(R.id.diabetes_s);
        thyroid_f=(CheckBox)v.findViewById(R.id.thyroid_f);
        thyroid_m=(CheckBox)v.findViewById(R.id.thyroid_m);
        thyroid_s=(CheckBox)v.findViewById(R.id.thyroid_s);
        hyp_f=(CheckBox)v.findViewById(R.id.hypertension_f);
        hyp_m=(CheckBox)v.findViewById(R.id.hypertension_m);
        hyp_s=(CheckBox)v.findViewById(R.id.hypertension_s);
        btn=(Button)v.findViewById(R.id.btn_familyhistory);
      //  btn_view=(Button)v.findViewById(R.id.btn_familyhistory_view);
         stringBuilder=new StringBuilder();
         s1=new StringBuilder();
         s2=new StringBuilder();

        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
        RegisteredUserID=currentUser.getUid();
        mdatabase = FirebaseDatabase.getInstance().getReference().child("Family History");
        mdatabase.child(RegisteredUserID).child("Father").setValue(father);
        mdatabase.child(RegisteredUserID).child("Mother").setValue(mother);
        mdatabase.child(RegisteredUserID).child("Siblings").setValue(siblings);

        family();
       // vieww();
        return v;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        others_f.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(others_f.isChecked()){
                    other_father.setVisibility(View.VISIBLE);
                }
                else
                    other_father.setVisibility(View.GONE);
            }
        });
        others_s.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(others_s.isChecked()){
                    others_siblings.setVisibility(View.VISIBLE);
                }
                else
                    others_siblings.setVisibility(View.GONE);
            }
        });
        others_m.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(others_m.isChecked()){
                    others_mother.setVisibility(View.VISIBLE);
                }
                else
                    others_mother.setVisibility(View.GONE);
            }
        });

    }

    public void family()
    {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (flag == 0) {
                    if (diabetes_f.isChecked()) {
                        dia_f1 = 1;
                        stringBuilder.append("Diabetes");
                    }
                    if (diabetes_m.isChecked()) {
                        dia_m1 = 1;
                        s1.append("Diabetes");
                    }
                    if (diabetes_s.isChecked()) {
                        dia_s1 = 1;
                        s2.append("Diabetes");
                    }
                    if (thyroid_f.isChecked()) {
                        thy_f1 = 1;
                        stringBuilder.append("," + "Thyroid");
                    }
                    if (thyroid_m.isChecked()) {
                        thy_m1 = 1;
                        s1.append("," + "Thyroid");
                    }

                    if (thyroid_s.isChecked()) {
                        thy_s1 = 1;
                        s2.append("," + "Thyroid");
                    }
                    if (hyp_f.isChecked()) {
                        hyp_f1 = 1;
                        stringBuilder.append("," + "Hypertension");
                    }
                    if (hyp_m.isChecked()) {
                        hyp_m1 = 1;
                        s1.append("," + "Hypertension");
                    }
                    if (hyp_s.isChecked()) {
                        hyp_s1 = 1;
                        s2.append("," + "Hypertension");
                    }
                    if (others_f.isChecked()) {
                        others_f1 = 1;
                    }
                    if (others_m.isChecked()) {
                        others_m1 = 1;
                    }
                    if (others_s.isChecked()) {
                        others_s1 = 1;
                    }
//                    boolean isInserted = myDb.insert2(dia_f1, dia_m1, dia_s1, thy_f1, thy_m1, thy_s1, hyp_f1, hyp_m1, hyp_s1, others_f1, others_m1, others_s1
//                            , other_father.getText().toString(), others_mother.getText().toString(), others_siblings.getText().toString()
//                    );
                    stringBuilder.append("," + other_father.getText().toString());
                    s1.append("," + others_mother.getText().toString());
                    s2.append("," + others_siblings.getText().toString());
                    father=stringBuilder.toString();
                    mother=s1.toString();
                    siblings=s2.toString();

//                    if (isInserted == true) {

                        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
                        RegisteredUserID=currentUser.getUid();
                        mdatabase = FirebaseDatabase.getInstance().getReference().child("Family History");
                        mdatabase.child(RegisteredUserID).child("Father").setValue(father);
                        mdatabase.child(RegisteredUserID).child("Mother").setValue(mother);
                        mdatabase.child(RegisteredUserID).child("Siblings").setValue(siblings);

                        Toast.makeText(getContext(), "data inserted", Toast.LENGTH_SHORT).show();
                        flag=1;
                        btn.setBackgroundColor(Color.BLUE);
                        btn.setTextColor(Color.WHITE);
                        btn.setText("Data is SAVED");
                        img3.setVisibility(View.VISIBLE);
                        img3.setFocusable(true);
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
//                Cursor res = myDb.getalldata_family();
//
//                if (res.getCount() == 0) {
//                    Toast.makeText(getContext(), "No data found!!", Toast.LENGTH_SHORT).show();
//                }
//
//                StringBuffer buffer = new StringBuffer();
//
//                while (res.moveToNext()) {
//                    buffer.append("Father_Diabetes:" + res.getInt(1) + "\n");
//                    buffer.append("Father_Thyroid:" + res.getInt(4) + "\n");
//                    buffer.append("Father_Hypertension" + res.getInt(7) + "\n");
//                    buffer.append("Father_Others" + res.getInt(10) + "\n");
//                    buffer.append("Father_others_disease:" + res.getString(13) + "\n");
//                    buffer.append("Mother_Diabetes:" + res.getInt(2) + "\n");
//                    buffer.append("Mother_Thyroid:" + res.getInt(5) + "\n");
//                    buffer.append("Mother_Hypertension" + res.getInt(8) + "\n");
//                    buffer.append("Mother_Others" + res.getInt(11) + "\n");
//                    buffer.append("Mother_others_disease:" + res.getString(14) + "\n");
//                    buffer.append("Siblings_Diabetes:" + res.getInt(3) + "\n");
//                    buffer.append("Siblings_Thyroid:" + res.getInt(6) + "\n");
//                    buffer.append("Siblings_Hypertension" + res.getInt(9) + "\n");
//                    buffer.append("Siblings_Others" + res.getInt(12) + "\n");
//                    buffer.append("Siblings_others_disease:" + res.getString(15) + "\n\n\n");
//                }
//                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
//                builder.setCancelable(true);
//                builder.setTitle("Family History:");
//                builder.setMessage(buffer);
//                builder.show();
//            }
//        });
//    }
}
