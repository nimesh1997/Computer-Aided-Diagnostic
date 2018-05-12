package com.example.vidhi.computeraideddiagnostic.Fragments;

import android.app.DatePickerDialog;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.telephony.PhoneNumberUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.vidhi.computeraideddiagnostic.DatabaseHelper;
import com.example.vidhi.computeraideddiagnostic.MainActivity;
import com.example.vidhi.computeraideddiagnostic.Models.PatientBioData;
import com.example.vidhi.computeraideddiagnostic.R;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static android.content.ContentValues.TAG;


public class personal_biodata extends Fragment {
    private static final String TAG = "vidhi1";
    Button btn, savee;
    EditText edit_name, edit_occup, edit_age, edit_gender, edit_height, edit_weight, edit_dob, edit_marital, edit_add, edit_contact, edit_email, edit_blood;
    DatabaseHelper myDb;
    int flag = 0;
    ImageView img7;
    int day,month,year;
    int name1, occup1 = 0, contact1 = 0, gender1 = 0, marital1 = 0, email1 = 0;
    private DatabaseReference mdatabase,mdatabase1,mdatabase2,mdatabase3,mdatabase4,mdatabase5,mdatabase6;
    private FirebaseApp mref;
    String RegisteredUserID;
    String name="No Information",age="No Information",occ="No Information",gender="No Information",height="No Information",add="No Information",blood="No Information",weight="No Information",dob="No Information",marital="No Information",contact="No Information",email="No Information";

    public personal_biodata() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        myDb = new DatabaseHelper(getContext());
        View v = inflater.inflate(R.layout.fragment_personal_biodata, container, false);
        edit_name = v.findViewById(R.id.editText4);
        edit_occup = v.findViewById(R.id.editText5);
        edit_age = v.findViewById(R.id.editText6);
        edit_gender = v.findViewById(R.id.gender);
        edit_height = v.findViewById(R.id.editText8);
        edit_weight = v.findViewById(R.id.editText9);
        edit_dob = v.findViewById(R.id.editText10);
        edit_marital = v.findViewById(R.id.editText11);
        edit_add = v.findViewById(R.id.editText12);
        edit_contact = v.findViewById(R.id.editText13);
        edit_email = v.findViewById(R.id.editText14);
        edit_blood = v.findViewById(R.id.blood);
        btn = v.findViewById(R.id.clicked);
        img7 = v.findViewById(R.id.nextimg7);
        //  savee=v.findViewById(R.id.click_view);
        //edit_add.getText().toString(),
        Log.e("vidhi", "before setonclicklistener: ");

        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
        RegisteredUserID=currentUser.getUid();
        mdatabase = FirebaseDatabase.getInstance().getReference().child("Personal BioData");
        mdatabase.child(RegisteredUserID).child("Name").setValue(name);
        mdatabase.child(RegisteredUserID).child("Occupation").setValue(occ);
        mdatabase.child(RegisteredUserID).child("Age").setValue(age);
        mdatabase.child(RegisteredUserID).child("Gender").setValue(gender);
        mdatabase.child(RegisteredUserID).child("Height").setValue(height);
        mdatabase.child(RegisteredUserID).child("Weight").setValue(weight);
        mdatabase.child(RegisteredUserID).child("DOB").setValue(dob);
        mdatabase.child(RegisteredUserID).child("marital status").setValue(marital);
        mdatabase.child(RegisteredUserID).child("Address").setValue(add);
        mdatabase.child(RegisteredUserID).child("Contact").setValue(contact);
        mdatabase.child(RegisteredUserID).child("E-Mail").setValue(email);
        mdatabase.child(RegisteredUserID).child("Blood Group").setValue(blood);

        personal();
        //viewall();

        Calendar cal = Calendar.getInstance();
         day = cal.get(Calendar.DAY_OF_MONTH);
         month = cal.get(Calendar.MONTH);
         year = cal.get(Calendar.YEAR);

        edit_dob.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                DateDialog();

            }
        });

        return v;

    }

    public void DateDialog(){

        DatePickerDialog.OnDateSetListener listener=new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,int dayOfMonth)
            {

                edit_dob.setText(dayOfMonth+"/"+(monthOfYear+1)+"/"+year);

            }};

        DatePickerDialog dpDialog=new DatePickerDialog(getContext(), listener, year, month, day);
        dpDialog.show();

    }




    public void personal() {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (flag == 0) {

                    Pattern ps = Pattern.compile("^[a-zA-Z ]+$");
                    Matcher ms = ps.matcher(edit_name.getText().toString());
                    boolean bs = ms.matches();
                    if (bs == false) {
                        edit_name.setError("Please enter correct name");
                    } else {
                        name1 = 1;
                    }

                    Matcher ms1 = ps.matcher(edit_occup.getText().toString());
                    boolean bs1 = ms1.matches();
                    if (bs1 == false) {
                        edit_occup.setError("Please enter right occupation");
                    } else {
                        occup1 = 1;
                    }

                   // boolean x=PhoneNumberUtils.isGlobalPhoneNumber(edit_contact.getText().toString());
                     if ( edit_contact.getText()== null || edit_contact.getText().length() != 13) {
                         edit_contact.setError("Please enter correct Contact number starting with country code");
                    } else {
                         boolean x=android.util.Patterns.PHONE.matcher(edit_contact.getText()).matches();
                         if(x==false)
                         {
                             edit_contact.setError("Please enter correct Contact number starting with country code");
                         }
                         else {
                             contact1=1;
                         }
                    }

                    Pattern ps2 = Pattern.compile("^[a-zA-Z ]+$");
                    Matcher ms2 = ps2.matcher(edit_gender.getText().toString());
                    boolean bs2 = (ms2.matches());
                    if ((bs2 == false)|| edit_gender.getText().toString().isEmpty() || edit_gender.getText().length()!=1 ) {
                        edit_gender.setError("Please enter correct value(M/F/O)");
                    } else {
                        gender1 = 1;
                    }

                    Pattern ps3 = Pattern.compile("^[a-zA-Z ]+$");
                    Matcher ms3 = ps3.matcher(edit_marital.getText().toString());
                    boolean bs3 = ms3.matches();
                    if (bs3 == false) {
                        edit_marital.setError("Please enter correct name");
                    } else {
                        marital1 = 1;
                    }

                    Pattern pattern = Patterns.EMAIL_ADDRESS;
                    boolean x= pattern.matcher(edit_email.getText().toString()).matches();
                    if(x==false)
                    {
                        edit_email.setError("Please enter valid email address");
                    }
                    else {
                        email1=1;
                    }



                    if(name1==1 && occup1==1 && contact1==1 && gender1==1 && marital1==1 && email1==1)  {

                        Log.e("vidhi", "after onclick ");
                        name = edit_name.getText().toString();
                        occ = edit_occup.getText().toString();
                        age = edit_age.getText().toString();
                        gender = edit_gender.getText().toString();
                        height = edit_height.getText().toString();
                        weight = edit_weight.getText().toString();
                        dob = edit_dob.getText().toString();
                        marital = edit_marital.getText().toString();
                        add = edit_add.getText().toString();
                        contact = edit_contact.getText().toString();
                        email = edit_email.getText().toString();
                        blood = edit_blood.getText().toString();
                        if (name.trim().equals("")) {
                            name = "No Information.";
                        }
                        if (occ.trim().equals("")) {
                            occ = "No Information.";
                        }
                        if (age.trim().equals("")) {
                            age = "No Information.";
                        }
                        if (gender.trim().equals("")) {
                            gender = "No Information.";
                        }
                        if (height.trim().equals("")) {
                            height = "No Information.";
                        }
                        if (weight.trim().equals("")) {
                            weight = "No Information.";
                        }
                        if (dob.trim().equals("")) {
                            dob = "No Information.";
                        }
                        if (marital.trim().equals("")) {
                            marital = "No Information.";
                        }
                        if (add.trim().equals("")) {
                            add = "No Information.";
                        }
                        if (contact.trim().equals("")) {
                            contact = "No Information.";
                        }
                        if (email.trim().equals("")) {
                            email = "No Information.";
                        }
                        if (blood.trim().equals("")) {
                            blood = "No Information.";
                        }

//                        boolean isInserted = myDb.insertData(name, occ, age, gender,
//                                height, weight, dob, marital, add, contact,
//                                email, blood);
//                        Log.e("vidhi", "before after inserting ");
//
//
//
//                    if (isInserted == true) {

                        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
                        RegisteredUserID=currentUser.getUid();
                        mdatabase = FirebaseDatabase.getInstance().getReference().child("Personal BioData");
                        mdatabase.child(RegisteredUserID).child("Name").setValue(name);
                        mdatabase.child(RegisteredUserID).child("Occupation").setValue(occ);
                        mdatabase.child(RegisteredUserID).child("Age").setValue(age);
                        mdatabase.child(RegisteredUserID).child("Gender").setValue(gender);
                        mdatabase.child(RegisteredUserID).child("Height").setValue(height);
                        mdatabase.child(RegisteredUserID).child("Weight").setValue(weight);
                        mdatabase.child(RegisteredUserID).child("DOB").setValue(dob);
                        mdatabase.child(RegisteredUserID).child("marital status").setValue(marital);
                        mdatabase.child(RegisteredUserID).child("Address").setValue(add);
                        mdatabase.child(RegisteredUserID).child("Contact").setValue(contact);
                        mdatabase.child(RegisteredUserID).child("E-Mail").setValue(email);
                        mdatabase.child(RegisteredUserID).child("Blood Group").setValue(blood);


                        Toast.makeText(getContext(), "Successfully entered!!!", Toast.LENGTH_SHORT).show();
                        flag = 1;
                        btn.setBackgroundColor(Color.BLUE);
                        btn.setTextColor(Color.WHITE);
                        btn.setText("Data is SAVED");
                        img7.setVisibility(View.VISIBLE);
                        img7.setFocusable(true);
                    }
 //                   } else {
//                        Toast.makeText(getContext(), "data not inserted", Toast.LENGTH_SHORT).show();
//              }


                } else {
                    Toast.makeText(getContext(), "One User can submit details only 1 time \n For another details, try with different login.", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}



//    @Override
//    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
//
//        {
//
//        List<PatientBioData> bioDatas = myDb.getpatientdata();
//        for(PatientBioData patientBioData : bioDatas) {
//            String cat = "\nName: " + patientBioData.getCOLUMN_NAME() + " \nOccupation: " +patientBioData.getCOLUMN_OCCUPATION()+ " \nAge: "+patientBioData.getCOLUMN_AGE()+" \nGender: "+patientBioData.getCOLUMN_GENDER()+" \nHeight: "+patientBioData.getCOLUMN_PATIENT_WEIGHT()+" ,Dob: "+patientBioData.getCOLUMN_DOB()+ " \nBloodGroup: "+patientBioData.getCOLUMN_BLOOD_GROUP()+" \nWeight: "
//                    + patientBioData.getCOLUMN_PATIENT_WEIGHT() + " \nMarital Status: " +patientBioData.getCOLUMN_MARTIAL_STATUS()
//                    + " \nAddress: " +patientBioData.getCOLUMN_ADDRESS() + " \nContact: "+patientBioData.getCOLUMN_CONTACT()
//                    + " \nE-Mail: " +patientBioData.getCOLUMN_EMAIL();
//
//            AlertDialog.Builder builder=new AlertDialog.Builder(getContext());
//            builder.setCancelable(true);
//            builder.setTitle("PATIENT'S PERSONAL BIODATA:");
//            builder.setMessage(cat);
//            builder.show();
//
//            Log.i(TAG, cat);
//        }
//
//
//        super.onActivityCreated(savedInstanceState);
//    }
//}

//public void viewall()
//{
//   savee.setOnClickListener(new View.OnClickListener() {
//        @Override
//        public void onClick(View view) {
//            Cursor res = myDb.getalldata();
//            Cursor yourCursor = myDb.getYourTableContents();
//
//            int i = 0;
//            /*while(i < 1){
//                Toast.makeText(getContext(),"Recheck", Toast.LENGTH_SHORT).show();
//                i++;
//            }*/
//            //Log.d(TAG,String.valueOf(i));
//
//            if (res.getCount() == 0) {
//                Toast.makeText(getContext(), "No data found!!", Toast.LENGTH_SHORT).show();
//            }
//
//            StringBuffer buffer = new StringBuffer();
//
//                while (res.moveToNext()) {
//                    buffer.append("Name:" + res.getString(1) + "\n");
//                    buffer.append("Occupation:" + res.getString(2) + "\n");
//                    buffer.append("Age:" + res.getString(3) + "\n");
//                    buffer.append("Gender:" + res.getString(4) + "\n");
//                    buffer.append("Height:" + res.getString(5) + "\n");
//                    buffer.append("Weight:" + res.getString(6) + "\n");
//                    buffer.append("Marital Status:" + res.getString(7) + "\n");
//                    buffer.append("Address:" + res.getString(8) + "\n");
//                    buffer.append("Contact No.:" + res.getString(9) + "\n");
//                    buffer.append("Email Id:" + res.getString(10) + "\n");
//                    buffer.append("Blood Group:" + res.getString(11) + "\n\n\n");
//                }
//                /*while(res.moveToNext()){
//                    buffer.append("Name:" + res.getString(0) + "\n");
//                }
//                Log.d(TAG, buffer.toString());*/
//
//                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
//                builder.setCancelable(true);
//                builder.setTitle("PATIENT'S PERSONAL BIODATA:");
//                builder.setMessage(buffer);
//                builder.show();
//
//            }
//
//    });
//
//
//
//}




