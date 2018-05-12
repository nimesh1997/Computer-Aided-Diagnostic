package com.example.vidhi.computeraideddiagnostic;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
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
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class PatientActivity extends AppCompatActivity {

    private static final int PERMISSION_SEND_SMS = 1;
    private ImageView mProfileImage;
    private TextView mProfileName, mProfileStatus, mProfileFriendsCount;
    private Button mProfileSendReqBtn, mDeclineBtn,btn_sendsmsfinal;
    EditText send_sms;
    String display_name;

    private DatabaseReference mUsersDatabase;

    private ProgressDialog mProgressDialog;

    private DatabaseReference mFriendReqDatabase;
    private DatabaseReference mFriendDatabase;
    private DatabaseReference mNotificationDatabase;

    private DatabaseReference mRootRef;

    private FirebaseUser mCurrent_user;

    private String mCurrent_state;
    String TAG="vidhi";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient);

       // send_sms=findViewById(R.id.send_final_sms);
        btn_sendsmsfinal=findViewById(R.id.btn_send_smsfinal);

        final String user_id = getIntent().getStringExtra("user_id");

        mRootRef = FirebaseDatabase.getInstance().getReference();

        mUsersDatabase = FirebaseDatabase.getInstance().getReference().child("Users").child(user_id);

        mCurrent_user = FirebaseAuth.getInstance().getCurrentUser();

        mProfileImage = (ImageView) findViewById(R.id.profile_image);
        mProfileName = (TextView) findViewById(R.id.profile_displayName);




        mProgressDialog = new ProgressDialog(this);
        mProgressDialog.setTitle("Loading User Data");
        mProgressDialog.setMessage("Please wait while we load the user data.");
        mProgressDialog.setCanceledOnTouchOutside(false);
        mProgressDialog.show();



        mUsersDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                display_name = dataSnapshot.child("phone no").getValue().toString();

                String image = dataSnapshot.child("image").getValue().toString();

                mProfileName.setText(display_name);


                Picasso.with(PatientActivity.this).load(image).placeholder(R.drawable.user2).into(mProfileImage);

                mProgressDialog.dismiss();





            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        btn_sendsmsfinal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //sendsms();
                form();

            }
        });

    }

    public void form()
    {
        try {
            Intent form = new Intent(PatientActivity.this, form_thyroid.class);
            //  form.putExtra("user_id1", );
            startActivity(form);
//            android.support.v4.app.FragmentManager fragmentManager=getSupportFragmentManager();
//            android.support.v4.app.FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
//            //fragmentTransaction.add(R.id.l1,new form_thyroid());
//            fragmentTransaction.replace(R.id.l1,new form_thy_frag());
//            fragmentTransaction.commit();
        }
        catch (Exception e)
        {
            Log.e(TAG, "form: "+ e );
        }

    }
    public void sendsms()
    {
        String message=send_sms.getText().toString();
        String phoneNumber=mProfileName.getText().toString();

        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.SEND_SMS}, PERMISSION_SEND_SMS);
        } else {
//            SmsManager smsManager = SmsManager.getDefault();
//            smsManager.sendTextMessage(phoneNumber, null, message , null, null);
//            send_sms.setText("");
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
            send_sms.setText(" ");
            Toast.makeText(this, "MESSAGE HAS BEEN SENT TO THE PATIENT", Toast.LENGTH_SHORT).show();

        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case PERMISSION_SEND_SMS:
                if (grantResults != null && grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    //do send or read sms

                    String message=send_sms.getText().toString();
                    String phoneNumber=mProfileName.getText().toString();

                    SmsManager smsManager =     SmsManager.getDefault();
                    smsManager.sendTextMessage(phoneNumber, null, message, null, null);

                }
                break;
        }
    }
}

