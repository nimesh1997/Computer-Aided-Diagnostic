package com.example.vidhi.computeraideddiagnostic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class Doc extends AppCompatActivity {


    private Button pbtn,rbtn,lbtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doc);

        pbtn=(Button)findViewById(R.id.Patient);
        rbtn=(Button)findViewById(R.id.Reports);
        lbtn=(Button)findViewById(R.id.Logoutbtn);

        rbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = (new Intent(Doc.this, List.class));
                startActivity(intent);
            }
        });

        pbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent rintent=(new Intent(Doc.this,Patientfirelist.class));
                startActivity(rintent);
            }
        });

        lbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                SendToStart();
            }
        });


    }

    private void SendToStart() {
        Intent intent = (new Intent(Doc.this, LOGIN.class));

        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);;
        startActivity(intent);


    }
}
