package com.example.vidhi.computeraideddiagnostic;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.sax.StartElementListener;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LOGIN extends AppCompatActivity {

    private Button lgnacnt;
    private EditText lgnEmail;
    private EditText lgnPassword;
    private Button lgnButton;
    private FirebaseAuth firebaseAuth;
    private FirebaseAuth.AuthStateListener authListener;
    private ProgressDialog pd;
    private CheckBox chk;
    private RadioButton chk1,chk2;
    private DatabaseReference jLoginDatabase;
    DatabaseHelper myDb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_login);
        myDb = new DatabaseHelper(this);
        firebaseAuth = FirebaseAuth.getInstance();
        lgnEmail = (EditText) findViewById(R.id.login_emailid);
        lgnPassword = (EditText) findViewById(R.id.login_password);
        lgnButton = (Button) findViewById(R.id.loginBtn);


        TextView text = (TextView) findViewById(R.id.createAccount);
        pd = new ProgressDialog(this);
        firebaseAuth = FirebaseAuth.getInstance();
       /* chk.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(!isChecked){

                    // show password
                    lgnPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());

                    Log.i("checker", "true");
                }

                else{
                    Log.i("checker", "false");

                    // hide password
                    lgnPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }

            }
        });
        */



        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LOGIN.this, SIGNUP.class));
            }
        });

        lgnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Signin();
            }
        });
    }

    private void Signin() {
        final String email, pass;
        email = lgnEmail.getText().toString();
        pass = lgnPassword.getText().toString();
        pd.setTitle("Logging In");
        pd.setMessage("Please wait while we check your credentials");
        pd.show();
        pd.setCanceledOnTouchOutside(false);

        if (TextUtils.isEmpty(email)) {
            Toast.makeText(LOGIN.this, "Enter Email", Toast.LENGTH_LONG).show();
            return;
        }
        if (TextUtils.isEmpty(pass)) {
            Toast.makeText(LOGIN.this, "Enter Password", Toast.LENGTH_LONG).show();
            return;
        }
        firebaseAuth.signInWithEmailAndPassword(email, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
                    String RegisteredUserID = currentUser.getUid();
                    jLoginDatabase = FirebaseDatabase.getInstance().getReference().child("Users").child(RegisteredUserID);
                    jLoginDatabase.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            String userType = dataSnapshot.child("Type").getValue().toString();
                            if (userType.equals("Doctor")) {
                                pd.dismiss();
                                Intent intent = new Intent(LOGIN.this, Doc.class);
                                startActivity(intent);
                                finish();

                            } else if (userType.equals("Patient") ) {
                                pd.dismiss();

                                Intent intent = (new Intent(LOGIN.this, MainActivity.class));
                                startActivity(intent);
                                AlertDialog.Builder d= new AlertDialog.Builder(getApplication());
                                finish();

                            } else {
                                Toast.makeText(LOGIN.this, "Failed Login. Please Try Again", Toast.LENGTH_SHORT).show();
                                return;
                            }
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });
                }
            }
        });
    }}