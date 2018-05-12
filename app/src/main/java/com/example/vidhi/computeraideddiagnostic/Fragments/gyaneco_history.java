package com.example.vidhi.computeraideddiagnostic.Fragments;

import android.app.DatePickerDialog;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.vidhi.computeraideddiagnostic.DatabaseHelper;
import com.example.vidhi.computeraideddiagnostic.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;

public class gyaneco_history extends Fragment {

    private DatabaseReference mdatabase;
    String RegisteredUserID;
    DatabaseHelper myDb;
    EditText age_menarche,last_mens,duration;
    Button btn,btn_view;
    int flag=0;
    ImageView img4;
    int day,month,year;
    RadioButton reg,irreg,flo1,flo2,flo3,pain1,pain2,pain3,dis_white,dis_yellow,cons_thick,cons_thin,cons_normal,amount_excess,amount_less,infer_yes, infer_no,pain_yes,pain_no,blood_yes,blood_no;
    int regxx=0,irregxx=0,flo1xx=0,flo2xx=0,flo3xx=0,pain1xx=0,pain2xx=0,pain3xx=0,dis_whitexx=0,dis_yellowxx=0,cons_thickxx=0,cons_thinxx=0,cons_normalxx=0,amount_excessxx=0,amount_lessxx=0,infer_yesxx=0, infer_noxx=0,pain_yesxx=0,pain_noxx=0,blood_yesxx=0,blood_noxx=0;
    String regularity="No Information",flow="No Information",pain="No Information",color="No Information",consistency="No Information",amount="No Information",infertility="No Information",pain_urine="No Information",blood="No Information";
    String age="No Information" ,last="No Information",duration1="No Information";
    public gyaneco_history() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        myDb = new DatabaseHelper(getContext());
        View v=inflater.inflate(R.layout.fragment_gyaneco_history, container, false);
        age_menarche=v.findViewById(R.id.editText);
        last_mens=v.findViewById(R.id.editText2);
        reg=v.findViewById(R.id.regular);
        irreg=v.findViewById(R.id.irregular);
        flo1=v.findViewById(R.id.day1);
        flo2=v.findViewById(R.id.day2);
        flo3=v.findViewById(R.id.day3);
        pain1=v.findViewById(R.id.lower_abdomen);
        pain2=v.findViewById(R.id.upperabdomen);
        pain3=v.findViewById(R.id.none);
        duration=v.findViewById(R.id.duration_enter);
        dis_white=v.findViewById(R.id.discharge_colorwhite);
        dis_yellow=v.findViewById(R.id.discharge_coloryellow);
        cons_thick=v.findViewById(R.id.cons_thick);
        cons_thin=v.findViewById(R.id.cons_thin);
        cons_normal=v.findViewById(R.id.cons_normal);
        amount_excess=v.findViewById(R.id.amount_excess);
        amount_less=v.findViewById(R.id.amount_less);
        infer_yes=v.findViewById(R.id.infer_yes);
        infer_no=v.findViewById(R.id.infer_no);
        pain_yes=v.findViewById(R.id.urine_pain_yes);
        pain_no=v.findViewById(R.id.urine_pain_no);
        blood_yes=v.findViewById(R.id.urine_blood_yes);
        blood_no=v.findViewById(R.id.urine_blood_no);
        btn=v.findViewById(R.id.btn_gyno);
      //  btn_view=v.findViewById(R.id.btn_gyno_view);
        img4=v.findViewById(R.id.nextimg4);

        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
        RegisteredUserID=currentUser.getUid();
        mdatabase = FirebaseDatabase.getInstance().getReference().child("Gynaecological History");
        mdatabase.child(RegisteredUserID).child("Age").setValue(age);
        mdatabase.child(RegisteredUserID).child("Last Menstrual Period").setValue(last);
        mdatabase.child(RegisteredUserID).child("Regularity of cycle").setValue(regularity);
        mdatabase.child(RegisteredUserID).child("Flow").setValue(flow);
        mdatabase.child(RegisteredUserID).child("Pain").setValue(pain_urine);
        mdatabase.child(RegisteredUserID).child("Discharge Colour").setValue(color);
        mdatabase.child(RegisteredUserID).child("Discharge Consistency").setValue(consistency);
        mdatabase.child(RegisteredUserID).child("Discharge Amount").setValue(amount);
        mdatabase.child(RegisteredUserID).child("Discharge Duration").setValue(duration1);
        mdatabase.child(RegisteredUserID).child("Infertility").setValue(infertility);
        mdatabase.child(RegisteredUserID).child("Urination Pain").setValue(pain_urine);
        mdatabase.child(RegisteredUserID).child("Urination blood").setValue(blood);


        gyno();
        //vieww();

        Calendar cal = Calendar.getInstance();
        day = cal.get(Calendar.DAY_OF_MONTH);
        month = cal.get(Calendar.MONTH);
        year = cal.get(Calendar.YEAR);

        last_mens.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                DateDialog();

            }
        });

        return v;

    }

    public void DateDialog() {

        DatePickerDialog.OnDateSetListener listener = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                last_mens.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);

            }
        };

        DatePickerDialog dpDialog = new DatePickerDialog(getContext(), listener, year, month, day);
        dpDialog.show();

    }





    public void gyno()
    {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (flag == 0) {
                    if (reg.isChecked()) {
                        regxx = 1;
                        regularity="Regular";
                    }
                    if (irreg.isChecked()) {
                        irregxx = 1;
                        regularity="irregular";
                    }
                    if (flo1.isChecked()) {
                        flo1xx = 1;
                        flow="2-3 Days";
                    }
                    if (flo2.isChecked()) {
                        flo2xx = 1;
                        flow="3-5 Days";
                    }
                    if (flo3.isChecked()) {
                        flo3xx = 1;
                        flow="5-7 Days";
                    }
                    if (pain1.isChecked()) {
                        pain1xx = 1;
                        pain="Lower Abdomen";
                    }
                    if (pain2.isChecked()) {
                        pain2xx = 1;
                        pain="Upper Abdomen";
                    }
                    if (pain3.isChecked()) {
                        pain3xx = 1;
                        pain="None";
                    }


                    if (dis_white.isChecked()) {
                        dis_whitexx = 1;
                        color="White";
                    }
                    if (dis_yellow.isChecked()) {
                        dis_yellowxx = 1;
                        color="Yellowish";
                    }
                    if (cons_thick.isChecked()) {
                        cons_thickxx = 1;
                        consistency="Thick";
                    }
                    if (cons_thin.isChecked()) {
                        cons_thinxx = 1;
                        consistency="Thin";
                    }
                    if (cons_normal.isChecked()) {
                        cons_normalxx = 1;
                        consistency="Normal";
                    }
                    if (amount_excess.isChecked()) {
                        amount_excessxx = 1;
                        amount="Excess";
                    }
                    if (amount_less.isChecked()) {
                        amount_lessxx = 1;
                        amount="Less";
                    }
                    if (infer_yes.isChecked()) {
                        infer_yesxx = 1;
                        infertility="Yes";
                    }
                    if (infer_no.isChecked()) {
                        infer_noxx = 1;
                        infertility="No";
                    }
                    if (pain_yes.isChecked()) {
                        pain_yesxx = 1;
                        pain_urine="Yes";
                    }
                    if (pain_no.isChecked()) {
                        pain_noxx = 1;
                        pain_urine="No";
                    }
                    if (blood_yes.isChecked()) {
                        blood_yesxx = 1;
                        blood="Yes";
                    }
                    if (blood_no.isChecked()) {
                        blood_noxx = 1;
                        blood="No";
                    }
                    age = age_menarche.getText().toString();
                    last = last_mens.getText().toString();

                    duration1 = duration.getText().toString();

                    if (age.trim().equals("")) {
                        age = "No Information.";
                    }
                    if (last.trim().equals("")) {
                        last = "No Information.";
                    }
                    if (duration1.trim().equals("")) {
                        duration1 = "No Information.";
                    }
                    //boolean isInserted = myDb.insert9(age_menarche.getText().toString(),last_mens.getText().toString(),regxx,irregxx,flo1xx,flo2xx,flo3xx,pain1xx,pain2xx,pain3xx);
//                    boolean isInserted = myDb.insert9(age, last, regxx, irregxx, flo1xx, flo2xx, flo3xx, pain1xx, pain2xx, pain3xx, dis_whitexx, dis_yellowxx, cons_thickxx, cons_thinxx, cons_normalxx, amount_excessxx, amount_lessxx, duration1, infer_yesxx, infer_noxx, pain_yesxx, pain_noxx, blood_yesxx, blood_noxx);
//                    if (isInserted == true) {

                        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
                        RegisteredUserID=currentUser.getUid();
                        mdatabase = FirebaseDatabase.getInstance().getReference().child("Gynaecological History");
                        mdatabase.child(RegisteredUserID).child("Age").setValue(age);
                        mdatabase.child(RegisteredUserID).child("Last Menstrual Period").setValue(last);
                        mdatabase.child(RegisteredUserID).child("Regularity of cycle").setValue(regularity);
                        mdatabase.child(RegisteredUserID).child("Flow").setValue(flow);
                        mdatabase.child(RegisteredUserID).child("Pain").setValue(pain_urine);
                        mdatabase.child(RegisteredUserID).child("Discharge Colour").setValue(color);
                        mdatabase.child(RegisteredUserID).child("Discharge Consistency").setValue(consistency);
                        mdatabase.child(RegisteredUserID).child("Discharge Amount").setValue(amount);
                        mdatabase.child(RegisteredUserID).child("Discharge Duration").setValue(duration1);
                        mdatabase.child(RegisteredUserID).child("Infertility").setValue(infertility);
                        mdatabase.child(RegisteredUserID).child("Urination Pain").setValue(pain_urine);
                        mdatabase.child(RegisteredUserID).child("Urination blood").setValue(blood);

                        Toast.makeText(getContext(), "Successfully entered ", Toast.LENGTH_SHORT).show();
                        flag=1;
                        btn.setBackgroundColor(Color.BLUE);
                        btn.setTextColor(Color.WHITE);
                        btn.setText("Data is SAVED");
                        img4.setVisibility(View.VISIBLE);
                        img4.setFocusable(true);
//                    } else {
//                        Toast.makeText(getContext(), "unsuccessful", Toast.LENGTH_SHORT).show();
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
//                Cursor res = myDb.getalldata_gynae();
//
//                if (res.getCount() == 0) {
//                    Toast.makeText(getContext(), "No data found!!", Toast.LENGTH_SHORT).show();
//                }
//
//                StringBuffer buffer1 = new StringBuffer();
//
//                while (res.moveToNext()) {
//                    buffer1.append("Age of Menarche:" + res.getString(1) + "\n");
//                    buffer1.append("Last Menstrual Period:" + res.getString(2) + "\n");
//                    buffer1.append("Regular Cycle:" + res.getInt(3) + "\n");
//                    buffer1.append("Irregular Cycle:" + res.getInt(4) + "\n");
//                    buffer1.append("Flow- 2-3 Days:" + res.getInt(5) + "\n");
//                    buffer1.append("Flow- 3-5 Days:" + res.getInt(6) + "\n");
//                    buffer1.append("Flow- 5-7 Days:" + res.getInt(7) + "\n");
//                    buffer1.append("Pain_lower abdomen:" + res.getInt(8) + "\n");
//                    buffer1.append("Pain_upper abdomen" + res.getInt(9) + "\n");
//                    buffer1.append("Pain_none:" + res.getInt(10) + "\n");
//
//                    buffer1.append("Discharge colour_white:" + res.getString(11) + "\n");
//                    buffer1.append("Discharge colour_yellow:" + res.getString(12) + "\n");
//                    buffer1.append("Consistency_thick:" + res.getInt(13) + "\n");
//                    buffer1.append("Consistency_thin:" + res.getInt(14) + "\n");
//                    buffer1.append("Consistency_normal:" + res.getInt(15) + "\n");
//                    buffer1.append("Amount_excess:" + res.getInt(16) + "\n");
//                    buffer1.append("Amount_less:" + res.getInt(17) + "\n");
//                    buffer1.append("Duration:" + res.getInt(18) + "\n");
//                    buffer1.append("Infertility_yes" + res.getInt(19) + "\n");
//                    buffer1.append("Infertility_no:" + res.getInt(20) + "\n");
//                    buffer1.append("Pain in urination_yes:" + res.getInt(21) + "\n");
//                    buffer1.append("Pain in urination_no:" + res.getInt(22) + "\n");
//                    buffer1.append("Blood in urination_yes::" + res.getInt(23) + "\n");
//                    buffer1.append("Blood in urination_no::" + res.getInt(24) + "\n\n\n");
//                }
//
//
//                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
//                builder.setCancelable(true);
//                builder.setTitle("GYNAECOLOGICAL HISTORY:");
//                builder.setMessage(buffer1);
//                builder.show();
//            }
//        });
//    }
}
