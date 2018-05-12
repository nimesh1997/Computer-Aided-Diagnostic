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
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.vidhi.computeraideddiagnostic.DatabaseHelper;
import com.example.vidhi.computeraideddiagnostic.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class personal_social_history extends Fragment {

    DatabaseHelper myDb;
    RadioButton n_s,l_s,m_s,n_a,l_a,m_a,n_m,b_m,l_m,m_m,d_m,n_b,c_b,d_b;
    int n_s1=0,l_s1=0,m_s1=0,n_a1=0,l_a1=0,m_a1=0,n_m1=0,b_m1=0,l_m1=0,m_m1=0,d_m1=0,n_b1=0,c_b1=0,d_b1=0;
    Button btn,btn_view;
    int flag=0;
    ImageView img8;
    private DatabaseReference mdatabase;
    String RegisteredUserID;
    String sleep="No Information",appetite="No Information",micturation="No Information",bowel="No Information";
    public personal_social_history() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        myDb = new DatabaseHelper(getContext());
        View v=inflater.inflate(R.layout.fragment_personal_social_history, container, false);
        n_s=v.findViewById(R.id.normal_s);
        l_s=v.findViewById(R.id.less_s);
        m_s=v.findViewById(R.id.more_s);
        n_a=v.findViewById(R.id.normal_a);
        l_a=v.findViewById(R.id.less_a);
        m_a=v.findViewById(R.id.more_a);
        n_m=v.findViewById(R.id.normal_m);
        b_m=v.findViewById(R.id.burning_m);
        l_m=v.findViewById(R.id.less_m);
        m_m=v.findViewById(R.id.more_m);
        d_m=v.findViewById(R.id.dys_m);
        n_b=v.findViewById(R.id.normal_b);
        c_b=v.findViewById(R.id.constipation_b);
        d_b=v.findViewById(R.id.diarrhea_b);
        btn=v.findViewById(R.id.btn_per_soc_history);
        img8=v.findViewById(R.id.nextimg8);
      //  btn_view=v.findViewById(R.id.btn_per_soc_history_view);

        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
        RegisteredUserID=currentUser.getUid();
        mdatabase = FirebaseDatabase.getInstance().getReference().child("Personal and social history");
        mdatabase.child(RegisteredUserID).child("Sleep").setValue(sleep);
        mdatabase.child(RegisteredUserID).child("Appetite").setValue(appetite);
        mdatabase.child(RegisteredUserID).child("Micturation").setValue(micturation);
        mdatabase.child(RegisteredUserID).child("Bowel habits").setValue(bowel);

        per_soc();

        return v;
    }

    public void per_soc()
    {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (flag == 0) {

                    if (n_s.isChecked()) {
                        n_s1 = 1;
                        sleep="Normal";
                    }
                    if (l_s.isChecked()) {
                        l_s1 = 1;
                        sleep="Less";
                    }
                    if (m_s.isChecked()) {
                        m_s1 = 1;
                        sleep="More";
                    }
                    if (n_a.isChecked()) {
                        n_a1 = 1;
                        appetite="Normal";
                    }
                    if (l_a.isChecked()) {
                        l_a1 = 1;
                        appetite="Less";
                    }
                    if (m_a.isChecked()) {
                        m_a1 = 1;
                        appetite="More";
                    }
                    if (n_m.isChecked()) {
                        n_m1 = 1;
                        micturation="Normal";
                    }
                    if (b_m.isChecked()) {
                        b_m1 = 1;
                        micturation="Burning";
                    }
                    if (l_m.isChecked()) {
                        l_m1 = 1;
                        micturation="Less";
                    }

                    if (m_m.isChecked()) {
                        m_m1 = 1;
                        micturation="More";
                    }
                    if (d_m.isChecked()) {
                        d_m1 = 1;
                        micturation="Dysuria";
                    }
                    if (n_b.isChecked()) {
                        n_b1 = 1;
                        bowel="Normal";
                    }

                    if (c_b.isChecked()) {
                        c_b1 = 1;
                        bowel="Constipation";
                    }

                    if (d_b.isChecked()) {
                        d_b1 = 1;
                        bowel="Diarrhea";
                    }
//
//                    boolean isInserted = myDb.insert5(n_s1, l_s1, m_s1, n_a1, l_a1, m_a1, n_m1, b_m1, l_m1, m_m1, d_m1, n_b1, c_b1, d_b1);
//
//                    if (isInserted == true) {
                        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
                        RegisteredUserID=currentUser.getUid();
                        mdatabase = FirebaseDatabase.getInstance().getReference().child("Personal and social history");
                        mdatabase.child(RegisteredUserID).child("Sleep").setValue(sleep);
                        mdatabase.child(RegisteredUserID).child("Appetite").setValue(appetite);
                        mdatabase.child(RegisteredUserID).child("Micturation").setValue(micturation);
                        mdatabase.child(RegisteredUserID).child("Bowel habits").setValue(bowel);

                        Toast.makeText(getContext(), "data inserted", Toast.LENGTH_SHORT).show();
                        flag = 1;
                        btn.setBackgroundColor(Color.BLUE);
                        btn.setTextColor(Color.WHITE);
                        btn.setText("Data is SAVED");
                        img8.setVisibility(View.VISIBLE);
                        img8.setFocusable(true);
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
//                Cursor res = myDb.getalldata_personal_social();
//
//                if (res.getCount() == 0) {
//                    Toast.makeText(getContext(), "No data found!!", Toast.LENGTH_SHORT).show();
//                }
//
//                StringBuffer buffer1 = new StringBuffer();
//
//                while (res.moveToNext()) {
//                    buffer1.append("Sleep_normal:" + res.getInt(1) + "\n");
//                    buffer1.append("Sleep_less:" + res.getInt(2) + "\n");
//                    buffer1.append("Sleep_more:" + res.getInt(3) + "\n");
//                    buffer1.append("Appetite_more:" + res.getInt(4) + "\n");
//                    buffer1.append("Appetite_less:" + res.getInt(5) + "\n");
//                    buffer1.append("Appetite_more:" + res.getInt(6) + "\n");
//                    buffer1.append("Micturation_normal:" + res.getInt(7) + "\n");
//                    buffer1.append("Micturation_burning:" + res.getInt(8) + "\n");
//                    buffer1.append("Micturation_less" + res.getInt(9) + "\n");
//                    buffer1.append("Micturation_more" + res.getInt(10) + "\n");
//                    buffer1.append("Micturation_dysuria:" + res.getInt(11) + "\n");
//                    buffer1.append("Bowel_normal" + res.getInt(12) + "\n");
//                    buffer1.append("Bowel_constipation" + res.getInt(13) + "\n");
//                    buffer1.append("Bowel_diarrhea" + res.getInt(14) + "\n\n\n");
//
//                }
//
//
//                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
//                builder.setCancelable(true);
//                builder.setTitle("PERSONAL & SOCIAL HISTORY:");
//                builder.setMessage(buffer1);
//                builder.show();
//            }
//        });
//    }



}
