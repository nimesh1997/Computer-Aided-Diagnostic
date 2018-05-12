package com.example.vidhi.computeraideddiagnostic;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.Map;

public class doctor_patient extends AppCompatActivity {

    private static final int PERMISSION_SEND_SMS = 1;
    private ImageView mProfileImage;
    private TextView mProfileName, mProfileStatus, mProfileFriendsCount;
    private Button mProfileSendReqBtn, mDeclineBtn,btn_sendsmsfinal;
    EditText send_sms;
    String display_name;
    private DatabaseReference mRootRef,reference;
    TextView inv,invv,j11;

    private FirebaseUser mCurrent_user;


    private DatabaseReference mUsersDatabase;

    private ProgressDialog mProgressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_patient);
        inv=findViewById(R.id.investans);
        invv=findViewById(R.id.investansans);
        j11 = (TextView) findViewById(R.id.j1);

        final String user_id = getIntent().getStringExtra("user_id");

        mRootRef = FirebaseDatabase.getInstance().getReference();

        mUsersDatabase = FirebaseDatabase.getInstance().getReference().child("Users").child(user_id);

        mCurrent_user = FirebaseAuth.getInstance().getCurrentUser();

        mProgressDialog = new ProgressDialog(this);
        mProgressDialog.setTitle("Loading User Data");
        mProgressDialog.setMessage("Please wait while we load the user data.");
        mProgressDialog.setCanceledOnTouchOutside(false);
        mProgressDialog.show();

        mUsersDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                final FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();

                final String Registered = mUsersDatabase.child("Investigation").toString();
                reference= FirebaseDatabase.getInstance().getReference("Investigation");

                display_name = dataSnapshot.child("name").getValue().toString();
                mProfileName.setText(display_name);
                Map<String, Object> map = (Map<String, Object>)dataSnapshot.getValue();
                String invest=map.get(Registered).toString();


                //Log.e(TAG,"invest="+invest);
                inv.setText(Registered);
                invv.setText(invest);
                j11.setText(invest);

                mProgressDialog.dismiss();





            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }


}
