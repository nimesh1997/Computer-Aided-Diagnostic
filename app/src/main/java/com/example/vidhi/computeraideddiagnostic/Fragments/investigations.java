package com.example.vidhi.computeraideddiagnostic.Fragments;

import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.vidhi.computeraideddiagnostic.Activity_ocr;
import com.example.vidhi.computeraideddiagnostic.DatabaseHelper;
import com.example.vidhi.computeraideddiagnostic.Image_to_text;
import com.example.vidhi.computeraideddiagnostic.R;
import com.example.vidhi.computeraideddiagnostic.doctorpage;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Map;


public class investigations extends Fragment {

    private DatabaseReference mdatabase,reference;
    private FirebaseApp mref;
    DatabaseHelper myDb;
    RadioButton yes,no;
    Button btn,btn_view,btn_upload;
    int yes1=0,no1=0,flag=0;
    ImageView img6;
    String fireyn="No information";
    String RegisteredUserID,fp;
    String TAG="vamp";

    public investigations() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        myDb = new DatabaseHelper(getContext());
        View v=inflater.inflate(R.layout.fragment_investigations, container, false);
        yes=v.findViewById(R.id.yes);
        no=v.findViewById(R.id.no);
        btn=v.findViewById(R.id.btn_invest);

        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
        RegisteredUserID=currentUser.getUid();
        mdatabase = FirebaseDatabase.getInstance().getReference().child("Investigation");
        mdatabase.child(RegisteredUserID).setValue(fireyn);

        invest();
        mdatabase= FirebaseDatabase.getInstance().getReference();


       // btn_view=v.findViewById(R.id.btn_invest_view);
        btn_upload=v.findViewById(R.id.upload_image);
      //  img6=v.findViewById(R.id.nextimg6);


        //vieww();
       uploadd();
        return v;
    }
    public void invest()
    {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (flag == 0) {
                    if (yes.isChecked()) {
                        yes1 = 1;
                    }
                    if (no.isChecked()) {
                        no1 = 1;
                    }
//                    boolean isInserted = myDb.insert6(yes1, no1);
//
//                    if (isInserted == true) {
                        if(yes1==1)
                        {
                            fireyn="yes";
                        }
                        else
                        {
                            fireyn="no";
                        }

                        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
                        RegisteredUserID=currentUser.getUid();
                        mdatabase = FirebaseDatabase.getInstance().getReference().child("Investigation");
                        mdatabase.child(RegisteredUserID).setValue(fireyn);


                        Toast.makeText(getContext(), "data inserted", Toast.LENGTH_SHORT).show();
                        flag=1;
                        btn.setBackgroundColor(Color.BLUE);
                        btn.setTextColor(Color.WHITE);
                        btn.setText("Data is SAVED");

//                        AlertDialog.Builder d= new AlertDialog.Builder(getContext());
//                        d.setTitle("investigation");
//                        d.setMessage("emailid="+RegisteredUserID+"inestigation="+invest);
//                        d.show();

                        AlertDialog.Builder d= new AlertDialog.Builder(getContext());
                        d.setTitle("FORM IS SAVED");
                        d.setMessage("Your Form has been saved. \n Please wait for Doctor's Reply. \n You will get an SMS shortly.");
                        d.show();

//                    } else {
//                        Toast.makeText(getContext(), "data not inserted", Toast.LENGTH_SHORT).show();
//                    }

                } else {
                    Toast.makeText(getContext(), "One User can submit details only 1 time \n For another details, try with different login.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

  /*  public void vieww()
    {

        final FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();

       // final String Registered = currentUser.getEmail().replace(".",",");
        final String Registered = currentUser.getUid();
        reference= FirebaseDatabase.getInstance().getReference("Investigation");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
            //   if(Registered.compareTo(dataSnapshot.getValue().toString())==0)
            //   {
                   Map<String, Object> map = (Map<String, Object>)dataSnapshot.getValue();
                   Object invest=map.get(Registered);
                   Toast.makeText(getContext(), "email="+currentUser.getEmail(), Toast.LENGTH_SHORT).show();
                   Toast.makeText(getContext(), "invest="+invest, Toast.LENGTH_SHORT).show();
                   Log.e(TAG,"invest="+invest);

             //  }


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }*/

//    public void vieww()
//    {
//        btn_view.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Cursor res = myDb.getalldata_personal_investigation();
//
//                if (res.getCount() == 0) {
//                    Toast.makeText(getContext(), "No data found!!", Toast.LENGTH_SHORT).show();
//                }
//
//                StringBuffer buffer1 = new StringBuffer();
//
//                while (res.moveToNext()) {
//                    buffer1.append("YES:" + res.getInt(1) + "\n");
//                    buffer1.append("NO:" + res.getInt(2) + "\n\n\n");
//
//                }
//
//
//                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
//                builder.setCancelable(true);
//                builder.setTitle("INVESTIGATIONS DONE?:");
//                builder.setMessage(buffer1);
//                builder.show();
//            }
//        });
//    }

    public void uploadd()
    {
        btn_upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_upload.setBackgroundColor(Color.BLUE);
                btn_upload.setTextColor(Color.WHITE);
                Intent i=new Intent(getContext(),doctorpage.class);
                getActivity().startActivity(i);
            }
        });

    }

}
