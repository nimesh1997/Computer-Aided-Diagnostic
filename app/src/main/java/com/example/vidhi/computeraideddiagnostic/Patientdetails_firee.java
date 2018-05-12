package com.example.vidhi.computeraideddiagnostic;

import android.app.PendingIntent;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Patientdetails_firee extends AppCompatActivity {


    private DatabaseReference mUsersDatabase;

    private ProgressDialog mProgressDialog;
    private DatabaseReference mRootRef;

    private FirebaseUser mCurrent_user;
    private static final int PERMISSION_SEND_SMS = 1;
    private String mCurrent_state;
    TextView inv,p_name,p_occ,p_age,p_gender,p_height,p_weight,p_dob,p_marital,p_add,p_contact,p_email,p_bg,c_pain,c_fever,c_cold,c_bp;
    TextView pr_dia,pr_thy,pr_hyp,pa_head,pa_leg,pa_eye,pa_chest,pa_others,pa_medical,allr,d_past,d_present,ps_sleep,ps_app,ps_mic,ps_bowel;
    TextView fam_fat,fam_mot,fam_sib,gyn_age,gyn_last,gyn_reg,gyn_flow,gyn_pain,gyn_colour,gyn_cons,gyn_amount,gyn_dur,gyn_infer,gyn_pain_urine,gyn_blood;
    Button btn_sms, btn_upload,btn_algo;
    EditText test1;
    String TAG="vidhi";
    String personal_height,personal_weight,chief_bp,g11,chief_fever,g3,chief_cold,p3,g12,g13;
    int flag=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patientdetails_firee);

        test1=findViewById(R.id.test_pres);
        btn_sms = (Button) findViewById(R.id.button_sms);
        btn_sms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendsms();

            }
        });
        btn_upload = findViewById(R.id.button_uploadserver1);
        btn_upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                upload();
            }
        });

//
 //       btn_algo = (Button) findViewById(R.id.button_algo);
//        btn_algo.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//               applyalgo();
//            }
//        });
        p_name = (TextView) findViewById(R.id.af2);
        p_occ = (TextView) findViewById(R.id.af4);
        p_age = (TextView) findViewById(R.id.af6);
        p_gender = (TextView) findViewById(R.id.af8);
        p_height = (TextView) findViewById(R.id.af10);
        p_weight = (TextView) findViewById(R.id.af12);
        p_dob = (TextView) findViewById(R.id.af14);
        p_marital = (TextView) findViewById(R.id.af16);
        p_add = (TextView) findViewById(R.id.af18);
        p_contact = (TextView) findViewById(R.id.af20);
        p_email = (TextView) findViewById(R.id.af22);
        p_bg = (TextView) findViewById(R.id.af24);

        c_pain = (TextView) findViewById(R.id.b4);
        c_fever = (TextView) findViewById(R.id.b6);
        c_cold = (TextView) findViewById(R.id.b8);
        c_bp = (TextView) findViewById(R.id.b10);

        pr_dia=(TextView) findViewById(R.id.c2);
        pr_thy=(TextView) findViewById(R.id.c4);
        pr_hyp=(TextView) findViewById(R.id.c6);

        pa_head= (TextView) findViewById(R.id.d2);
        pa_leg= (TextView) findViewById(R.id.d4);
        pa_eye= (TextView) findViewById(R.id.d6);
        pa_chest= (TextView) findViewById(R.id.d8);
        pa_others= (TextView) findViewById(R.id.d10);
        pa_medical= (TextView) findViewById(R.id.d11);

        allr= (TextView) findViewById(R.id.f1);

        d_past= (TextView) findViewById(R.id.h2);
        d_present= (TextView) findViewById(R.id.h4);

        inv = (TextView) findViewById(R.id.j1);

        ps_sleep= (TextView) findViewById(R.id.i2);
        ps_app= (TextView) findViewById(R.id.i4);
        ps_mic= (TextView) findViewById(R.id.i6);
        ps_bowel= (TextView) findViewById(R.id.i8);

        fam_fat= (TextView) findViewById(R.id.e2);
        fam_mot= (TextView) findViewById(R.id.e4);
        fam_sib= (TextView) findViewById(R.id.e6);

        gyn_age= (TextView) findViewById(R.id.g2);
        gyn_last= (TextView) findViewById(R.id.g4);
        gyn_reg= (TextView) findViewById(R.id.g6);
        gyn_flow= (TextView) findViewById(R.id.g8);
        gyn_pain= (TextView) findViewById(R.id.g10);
        gyn_colour= (TextView) findViewById(R.id.g12);
        gyn_cons= (TextView) findViewById(R.id.g14);
        gyn_amount= (TextView) findViewById(R.id.g16);
        gyn_dur= (TextView) findViewById(R.id.g18);
        gyn_infer= (TextView) findViewById(R.id.g20);
        gyn_pain_urine= (TextView) findViewById(R.id.g22);
        gyn_blood= (TextView) findViewById(R.id.g24);


        final String user_id = getIntent().getStringExtra("user_id1");

        mRootRef = FirebaseDatabase.getInstance().getReference();

        mUsersDatabase = FirebaseDatabase.getInstance().getReference();

        mCurrent_user = FirebaseAuth.getInstance().getCurrentUser();

        p_name.setText("No Information");
        p_occ.setText("No Information");
        p_age.setText("No Information");
        p_gender.setText("No Information");
        p_height.setText("No Information");
        p_weight.setText("No Information");
        p_dob.setText("No Information");
        p_marital.setText("No Information");
        p_add.setText("No Information");
        p_contact.setText("No Information");
        p_email.setText("No Information");
        p_bg.setText("No Information");

        c_pain.setText("No Information");
        c_fever.setText("No Information");
        c_cold.setText("No Information");
        c_bp.setText("No Information");

        pr_dia.setText("No Information");
        pr_thy.setText("No Information");
        pr_hyp.setText("No Information");

        pa_head.setText("No Information");
        pa_leg.setText("No Information");
        pa_eye.setText("No Information");
        pa_chest.setText("No Information");
        pa_others.setText("No Information");
        pa_medical.setText("No Information");

        allr.setText("No Information");

        d_past.setText("No Information");
        d_present.setText("No Information");

        inv.setText("No Information");

        ps_sleep.setText("No Information");
        ps_app.setText("No Information");
        ps_mic.setText("No Information");
        ps_bowel.setText("No Information");

        fam_fat.setText("No Information");
        fam_mot.setText("No Information");
        fam_sib.setText("No Information");

        gyn_age.setText("No Information");
        gyn_last.setText("No Information");
        gyn_reg.setText("No Information");
        gyn_flow.setText("No Information");
        gyn_pain.setText("No Information");
        gyn_colour.setText("No Information");
        gyn_cons.setText("No Information");
        gyn_amount.setText("No Information");
        gyn_dur.setText("No Information");
        gyn_infer.setText("No Information");
        gyn_pain_urine.setText("No Information");
        gyn_blood.setText("No Information");



        // mProfileName = (TextView) findViewById(R.id.profile_displayName);
        mProgressDialog = new ProgressDialog(this);
        mProgressDialog.setTitle("Loading User Data");
        mProgressDialog.setMessage("Please wait while we load the user data.");
        mProgressDialog.setCanceledOnTouchOutside(false);
        mProgressDialog.show();



        mUsersDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                String personal_name = dataSnapshot.child("Personal BioData").child(user_id).child("Name").getValue().toString();
                String personal_occ = dataSnapshot.child("Personal BioData").child(user_id).child("Occupation").getValue().toString();
                String personal_age = dataSnapshot.child("Personal BioData").child(user_id).child("Age").getValue().toString();
                String personal_gender = dataSnapshot.child("Personal BioData").child(user_id).child("Gender").getValue().toString();
                personal_height = dataSnapshot.child("Personal BioData").child(user_id).child("Height").getValue().toString();
                personal_weight = dataSnapshot.child("Personal BioData").child(user_id).child("Weight").getValue().toString();
                String personal_dob = dataSnapshot.child("Personal BioData").child(user_id).child("DOB").getValue().toString();
                String personal_marital = dataSnapshot.child("Personal BioData").child(user_id).child("marital status").getValue().toString();
                String personal_add = dataSnapshot.child("Personal BioData").child(user_id).child("Address").getValue().toString();
                String personal_contact = dataSnapshot.child("Personal BioData").child(user_id).child("Contact").getValue().toString();
                String personal_email = dataSnapshot.child("Personal BioData").child(user_id).child("E-Mail").getValue().toString();
                String personal_bg = dataSnapshot.child("Personal BioData").child(user_id).child("Blood Group").getValue().toString();

                String chief_pain = dataSnapshot.child("Chief Complaints").child(user_id).child("Pain").getValue().toString();
                chief_fever = dataSnapshot.child("Chief Complaints").child(user_id).child("Fever").getValue().toString();
                chief_cold = dataSnapshot.child("Chief Complaints").child(user_id).child("Cold-Cough").getValue().toString();
                chief_bp = dataSnapshot.child("Chief Complaints").child(user_id).child("Blood Pressure").getValue().toString();

                String present_dia = dataSnapshot.child("Present Illness").child(user_id).child("Diabetes").getValue().toString();
                String present_thy = dataSnapshot.child("Present Illness").child(user_id).child("Thyroid").getValue().toString();
                String present_hyp = dataSnapshot.child("Present Illness").child(user_id).child("Hypertension").getValue().toString();

                String past_head = dataSnapshot.child("Past Illness").child(user_id).child("Head").getValue().toString();
                String past_leg = dataSnapshot.child("Past Illness").child(user_id).child("Leg").getValue().toString();
                String past_eye = dataSnapshot.child("Past Illness").child(user_id).child("Eye").getValue().toString();
                String past_chest = dataSnapshot.child("Past Illness").child(user_id).child("Chest").getValue().toString();
                String past_other = dataSnapshot.child("Past Illness").child(user_id).child("Others").getValue().toString();
                String past_medical = dataSnapshot.child("Past Illness").child(user_id).child("MEDICAL HISTORY").getValue().toString();

                String allergy = dataSnapshot.child("Allergy History").child(user_id).getValue().toString();

                String drug_past = dataSnapshot.child("Drugs History").child(user_id).child("Past Medicines Used").getValue().toString();
                String drug_present = dataSnapshot.child("Drugs History").child(user_id).child("Current Medicines Taking").getValue().toString();

                String invest = dataSnapshot.child("Investigation").child(user_id).getValue().toString();

                String p1 = dataSnapshot.child("Personal and social history").child(user_id).child("Sleep").getValue().toString();
                String p2 = dataSnapshot.child("Personal and social history").child(user_id).child("Appetite").getValue().toString();
                p3 = dataSnapshot.child("Personal and social history").child(user_id).child("Micturation").getValue().toString();
                String p4 = dataSnapshot.child("Personal and social history").child(user_id).child("Bowel habits").getValue().toString();

                String f1 = dataSnapshot.child("Family History").child(user_id).child("Father").getValue().toString();
                String f2 = dataSnapshot.child("Family History").child(user_id).child("Mother").getValue().toString();
                String f3 = dataSnapshot.child("Family History").child(user_id).child("Siblings").getValue().toString();

                String g1 = dataSnapshot.child("Gynaecological History").child(user_id).child("Age").getValue().toString();
                String g2 = dataSnapshot.child("Gynaecological History").child(user_id).child("Last Menstrual Period").getValue().toString();
                g3 = dataSnapshot.child("Gynaecological History").child(user_id).child("Regularity of cycle").getValue().toString();
                String g4 = dataSnapshot.child("Gynaecological History").child(user_id).child("Flow").getValue().toString();
                String g5 = dataSnapshot.child("Gynaecological History").child(user_id).child("Pain").getValue().toString();
                String g6 = dataSnapshot.child("Gynaecological History").child(user_id).child("Discharge Colour").getValue().toString();
                String g7 = dataSnapshot.child("Gynaecological History").child(user_id).child("Discharge Consistency").getValue().toString();
                String g9 = dataSnapshot.child("Gynaecological History").child(user_id).child("Discharge Amount").getValue().toString();
                String g10 = dataSnapshot.child("Gynaecological History").child(user_id).child("Discharge Duration").getValue().toString();
                g11 = dataSnapshot.child("Gynaecological History").child(user_id).child("Infertility").getValue().toString();
                g12 = dataSnapshot.child("Gynaecological History").child(user_id).child("Urination Pain").getValue().toString();
                g13 = dataSnapshot.child("Gynaecological History").child(user_id).child("Urination blood").getValue().toString();

                p_name.setText(personal_name);
                p_occ.setText(personal_occ);
                p_age.setText(personal_age);
                p_gender.setText(personal_gender);
                p_height.setText(personal_height);
                p_weight.setText(personal_weight);
                p_dob.setText(personal_dob);
                p_marital.setText(personal_marital);
                p_add.setText(personal_add);
                p_contact.setText(personal_contact);
                p_email.setText(personal_email);
                p_bg.setText(personal_bg);

                c_pain.setText(chief_pain);
                c_fever.setText(chief_fever);
                c_cold.setText(chief_cold);
                c_bp.setText(chief_bp);

                pr_dia.setText(present_dia);
                pr_thy.setText(present_thy);
                pr_hyp.setText(present_hyp);

                pa_head.setText(past_head);
                pa_leg.setText(past_leg);
                pa_eye.setText(past_eye);
                pa_chest.setText(past_chest);
                pa_others.setText(past_other);
                pa_medical.setText(past_medical);

                allr.setText(allergy);

                d_past.setText(drug_past);
                d_present.setText(drug_present);

                inv.setText(invest);

                ps_sleep.setText(p1);
                ps_app.setText(p2);;
                ps_mic.setText(p3);;
                ps_bowel.setText(p4);

                fam_fat.setText(f1);
                fam_mot.setText(f2);
                fam_sib.setText(f3);

                gyn_age.setText(g1);
                gyn_last.setText(g2);
                gyn_reg.setText(g3);
                gyn_flow.setText(g4);
                gyn_pain.setText(g5);
                gyn_colour.setText(g6);
                gyn_cons.setText(g7);
                gyn_amount.setText(g9);
                gyn_dur.setText(g10);
                gyn_infer.setText(g11);
                gyn_pain_urine.setText(g12);
                gyn_blood.setText(g13);

                mProgressDialog.dismiss();





            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });



    }

    public void sendsms() {
        String phoneNumber = p_contact.getText().toString();
        String message = test1.getText().toString();
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.SEND_SMS}, PERMISSION_SEND_SMS);
        } else {
//            SmsManager smsManager = SmsManager.getDefault();
//            smsManager.sendTextMessage(phoneNumber, null, message , null, null);
//            test_pres.setText("");
//            Toast.makeText(this, "MESSAGE HAS BEEN SENT TO THE PATIENT", Toast.LENGTH_SHORT).show();
            SmsManager sm = SmsManager.getDefault();
            ArrayList<String> parts =sm.divideMessage(message);
            int numParts = parts.size();

            ArrayList<PendingIntent> sentIntents = new ArrayList<PendingIntent>();
            ArrayList<PendingIntent> deliveryIntents = new ArrayList<PendingIntent>();

            for (int i = 0; i < numParts; i++) {
                Intent msentIntent = new Intent();
                Intent mDeliveryIntent = new Intent();
                sentIntents.add(PendingIntent.getBroadcast(this,0,msentIntent,0));
                deliveryIntents.add(PendingIntent.getBroadcast(this, 0, mDeliveryIntent, 0));
            }

            sm.sendMultipartTextMessage(phoneNumber,null, parts, sentIntents, deliveryIntents);
            test1.setText("");
            Toast.makeText(this, "MESSAGE HAS BEEN SENT TO THE PATIENT", Toast.LENGTH_SHORT).show();

        }

    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        String phoneNumber = p_contact.getText().toString();
        String message = test1.getText().toString();

        switch (requestCode) {
            case PERMISSION_SEND_SMS:
                if (grantResults != null && grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    //do send or read sms
                    SmsManager smsManager =     SmsManager.getDefault();
                    smsManager.sendTextMessage(phoneNumber, null, message, null, null);
                }
                break;
        }
    }

    public void upload()  {
        //  String test;
        float bmi1;
       // float height=Float.parseFloat(p_height.getText().toString());
        float height1=Float.parseFloat(personal_height.toString());
       // float weight=Float.parseFloat(p_weight.getText().toString());
        float weight1=Float.parseFloat(personal_weight.toString());
        bmi1=(weight1/(height1*height1));
        bmi1=bmi1*10000;

        String bp1 = chief_bp.toString();
        String infertility1= g11.toString();
        String fever1=chief_fever.toString();
        String period1= g3.toString();
        String cough1=chief_cold.toString();
        String micturation1=p3.toString();
        String pain_urine1= g12.toString();
        String blood_in_urine1= g13.toString();
        StringBuffer test = new StringBuffer();
        StringBuffer test_new = new StringBuffer();
        StringBuilder testt=new StringBuilder();

        Log.e(TAG,"bmi="+bmi1);
        Log.e(TAG,"wt="+weight1);
        Log.e(TAG,"ht="+height1);
        Log.e(TAG,"bp="+bp1);
        Log.e(TAG,"infertility="+infertility1);
        Log.e(TAG,"fever="+fever1);
        Log.e(TAG,"period="+period1);
        Log.e(TAG,"cough="+cough1);
        Log.e(TAG,"micturation="+micturation1);
        Log.e(TAG,"pain-urine="+pain_urine1);
        Log.e(TAG,"blood-urine="+blood_in_urine1);



        if(flag==0)
        {
            Log.e(TAG,"flag is 0");

            if ((bmi1<18.5 || bmi1>24.9) && bp1.equals("high"))
            {
                test_new.append("TSH test \n " +" T3,T4 Test \n " +" LIPID TEST\n");
            testt.append("1");
                Log.e(TAG, "1 " );
                flag=1;
            }
            if ((bmi1<18.5 || bmi1>24.9 )&& bp1.equals("low"))
            {
                test_new.append("TSH test \n " +" T3,T4 Test \n " +" LIPID TEST\n");
                testt.append("2");
                Log.e(TAG, "2 " );
                flag=1;
            }

            if (infertility1.equals("Yes"))
            {
                test_new.append("USG Test \n " +"  PAPSMEAR TEST \n " +"  MANTAX Test \n " +"  FBS Test \n " +" URINE-INFECTION Test \n");
                testt.append("3");
            Log.e(TAG, "3" );
                flag=1;
            }

            if (cough1.equals("yes") && fever1.equals(" Yes.More than 1 week"))
            {
                test_new.append("X-Ray\n");
                Log.e(TAG, "4" );
                testt.append("4");
                flag=1;
            }
            else if (cough1.equals("yes") && fever1.equals(" Yes.Less than 1 week"))
            {test_new.append("Take D-cold Cough Syrup and take rest.If fever continues for more than 1 week , then consult to me again.\n");
                testt.append("5");
                Log.e(TAG, "5" );
                flag=1;
            }
            else if (fever1.equals(" Yes.Less than 1 week"))
            {test_new.append("Take Paracetamol(1 tablet per day) and consult to me after 1 week\n");
                testt.append("6");
            Log.e(TAG, "6" );
                flag=1;
            }
            else if (fever1.equals(" Yes.More than 1 week"))
            {test_new.append("CBC and ESR Test \n " +"  NS-1 Antigen Test \n  "+"Malaria/Dengue Test \n"+" Chikungunya Test\n");
                testt.append("7");
            Log.e(TAG, "7" );
                flag=1;
            }


            if (micturation1.equals("Burning") || micturation1.equals("More") || micturation1.equals("Dysuria"))
            { test_new.append("Urine Test\n");
                testt.append("8");
            Log.e(TAG, "8" );
                flag=1;
            }

            if (pain_urine1.equals("Yes") && blood_in_urine1.equals("Yes"))
            { test_new.append("ERCP Test \n " +"  Bladder MRI Test \n");
                testt.append("9");
                Log.e(TAG, "9" );
                flag=1;
            }
            else if (pain_urine1.equals("Yes") && blood_in_urine1.equals("No"))
            { test_new.append("ERCP Test \n ");
                testt.append("10");
            Log.e(TAG, "10 " );
                flag=1;
            }
            else if (pain_urine1.equals("No") && blood_in_urine1.equals("Yes"))
            { test_new.append( " Bladder MRI Test \n");
                testt.append("11");
                Log.e(TAG, "11" );
                flag=1;
            }

            if (fever1.equals(" Yes.More than 1 week") && period1.equals("irregular"))
            { test_new.append("Mantaux Test\n");
                testt.append("12");
            Log.e(TAG, "12" );
                flag=1;
            }
            else if( period1.equals("irregular"))
            {
                test_new.append("Mantaux Test\n");
                testt.append("13");
                Log.e(TAG, "13" );
                flag=1;
            }
            else if(fever1.equals(" Yes.Less than 1 week") && period1.equals("irregular"))
            {
                test_new.append("Mantaux Test\n");
                testt.append("14");
                Log.e(TAG, "14" );
                flag=1;
            }

        }
        if(flag==0) {
            test_new.append("No Test\n");
            testt.append("nono");
        }




        test1.setText(test_new);



    }

    public void applyalgo()
    {
        StringBuffer buffer = new StringBuffer();
        buffer.append("hi i am Ravi ");
        Client myClient = new Client("192.168.1.15", 6781, buffer.toString());
        myClient.execute();
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}

