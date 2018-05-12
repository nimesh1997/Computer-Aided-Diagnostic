package com.example.vidhi.computeraideddiagnostic;

import android.app.Fragment;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;


public class form_thyroid extends AppCompatActivity {
    private TextView t1;
    Button btn_algo;
    String s;
    Button buttonOutput,buttonConnect;
    String TAG = "vidhi";
    EditText name,age,tsh,t3,tt4,t4u,fti,tbg;
    RadioButton sex_male,sex_female,thyrox_yes,thyrox_no,qthyrox_yes,qthyrox_no,antthyrox_yes,antthyrox_no,sick_yes,sick_no
            ,preg_yes,preg_no,thysur_yes,thysur_no,i3_yes,i3_no,qhypo_yes,qhypo_no,qhyper_yes,qhyper_no,li_yes,li_no,goi_yes,goi_no
            ,tum_yes,tum_no,hypopit_yes,hypopit_no,psy_yes,psy_no,tshmeas_yes,tshmeas_no,t3meas_yes,t3meas_no,tt4meas_yes,tt4meas_no
            ,t4umeas_yes,t4umeas_no,ftumeas_yes,ftumeas_no,tbgmeas_yes,tbgmeas_no,r1,r2,r3,r4,r5,r6;
    StringBuilder s1;
    String x1,x2,x3;
    Float y1,y2,y3;
    int err1 = 0,err2 = 0,err3 = 0;
    private DatabaseReference mdatabase,reference;
    private FirebaseApp mref;
    String RegisteredUserID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_thyroid);

        btn_algo = (Button) findViewById(R.id.thy_result);
        buttonOutput = (Button) findViewById(R.id.thy_result);
        buttonConnect = (Button) findViewById(R.id.send22);
        name=findViewById(R.id.f_t2);
        age=findViewById(R.id.f_t4);
        sex_male=findViewById(R.id.f_t6m);
        sex_female=findViewById(R.id.f_t6f);
        thyrox_yes=findViewById(R.id.f_t8t);
        thyrox_no=findViewById(R.id.f_t8f);
        qthyrox_yes=findViewById(R.id.f_t10t);
        qthyrox_no=findViewById(R.id.f_t10f);
        antthyrox_yes=findViewById(R.id.f_t12t);
        antthyrox_no=findViewById(R.id.f_t12f);
        sick_yes=findViewById(R.id.f_t14t);
        sick_no=findViewById(R.id.f_t14f);
        preg_yes=findViewById(R.id.f_t18t);
        preg_no=findViewById(R.id.f_t18f);
        thysur_yes=findViewById(R.id.f_t20t);
        thysur_no=findViewById(R.id.f_t20f);
        i3_yes=findViewById(R.id.f_t22t);
        i3_no=findViewById(R.id.f_t22f);
        qhypo_yes=findViewById(R.id.f_t24t);
        qhypo_no=findViewById(R.id.f_t24f);
        qhyper_yes=findViewById(R.id.f_t26t);
        qhyper_no=findViewById(R.id.f_t26f);
        li_yes=findViewById(R.id.f_t28t);
        li_no=findViewById(R.id.f_t28f);
        goi_yes=findViewById(R.id.f_t30t);
        goi_no=findViewById(R.id.f_t30f);
        tum_yes=findViewById(R.id.f_t32t);
        tum_no=findViewById(R.id.f_t32f);
        hypopit_yes=findViewById(R.id.f_t34t);
        hypopit_no=findViewById(R.id.f_t34f);
        psy_yes=findViewById(R.id.f_t36t);
        psy_no=findViewById(R.id.f_t36f);
        tshmeas_yes=findViewById(R.id.f_t38t);
        tshmeas_no=findViewById(R.id.f_t38f);
        tsh=findViewById(R.id.f_t40);
        t3meas_yes=findViewById(R.id.f_t42t);
        t3meas_no=findViewById(R.id.f_t42f);
        t3=findViewById(R.id.f_t44);
        tt4meas_yes=findViewById(R.id.f_t46t);
        tt4meas_no=findViewById(R.id.f_t46f);
        tt4=findViewById(R.id.f_t48);
        t4umeas_yes=findViewById(R.id.f_t50t);
        t4umeas_no=findViewById(R.id.f_t50f);
        t4u=findViewById(R.id.f_t52);
        ftumeas_yes=findViewById(R.id.f_t54t);
        ftumeas_no=findViewById(R.id.f_t54f);
        fti=findViewById(R.id.f_t56);
        tbgmeas_yes=findViewById(R.id.f_t58t);
        tbgmeas_no=findViewById(R.id.f_t58f);
        tbg=findViewById(R.id.f_t60);
        r1=findViewById(R.id.f_t621);
        r2=findViewById(R.id.f_t622);
        r3=findViewById(R.id.f_t623);
        r4=findViewById(R.id.f_t624);
        r5=findViewById(R.id.f_t625);
        r6=findViewById(R.id.f_t626);

        s1=new StringBuilder();

        btn_algo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e(TAG," 11");
                thy_form();
                Log.e(TAG," 22");
                dsp();
                Log.e(TAG," 33");
            }
        });
        buttonConnect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                se();
            }
        });

    }

   /* public void send_to_server(View v) {

        Client myClient = new Client("192.168.1.15", 7000, "hii");
        myClient.execute();
    }*/

    public void thy_form()
    {

        if (name.getText()!= null)
        {
            s1.append(name.getText());
            s1.append(",");
        }
        else if (name.getText()== null)
        {

            s1.append("?");
            s1.append(",");
        }

        // Toast.makeText(this, " "+s1, Toast.LENGTH_LONG).show();

        if (age.getText()!= null)
        {

            s1.append(age.getText());
            s1.append(",");
        }
        else if (age.getText()== null)
        {

            s1.append("?");
            s1.append(",");
        }

        //Toast.makeText(this, " "+s1, Toast.LENGTH_LONG).show();

        if (sex_male.isChecked())
        {

            s1.append("11");
            s1.append(",");
        }
        else if (sex_female.isChecked())
        {

            s1.append("00");
            s1.append(",");
        }
        else
        {

            s1.append("?");
            s1.append(",");
        }



        if (thyrox_yes.isChecked())
        {

            s1.append("1");
            s1.append(",");
        }
        else if (thyrox_no.isChecked())
        {

            s1.append("0");
            s1.append(",");
        }
        else
        {
            s1.append("?");
            s1.append(",");
        }



        if (qthyrox_yes.isChecked())
        {

            s1.append("1");
            s1.append(",");
        }
        else if (qthyrox_no.isChecked())
        {

            s1.append("0");
            s1.append(",");
        }
        else
        {

            s1.append("?");
            s1.append(",");
        }



        if (antthyrox_yes.isChecked())
        {

            s1.append("1");
            s1.append(",");
        }
        else if (antthyrox_no.isChecked())
        {

            s1.append("0");
            s1.append(",");
        }
        else
        {

            s1.append("?");
            s1.append(",");
        }



        if (sick_yes.isChecked())
        {

            s1.append("1");
            s1.append(",");
        }
        else if (sick_no.isChecked())
        {
            s1.append("0");
            s1.append(",");
        }
        else
        {

            s1.append("?");
            s1.append(",");
        }



        if (preg_yes.isChecked())
        {

            s1.append("1");
            s1.append(",");
        }
        else if (preg_no.isChecked())
        {

            s1.append("0");
            s1.append(",");
        }
        else
        {

            s1.append("?");
            s1.append(",");
        }



        if (thysur_yes.isChecked())
        {
            s1.append("1");
            s1.append(",");
        }
        else if(thysur_no.isChecked())
        {
            s1.append("0");
            s1.append(",");
        }
        else
        {
            s1.append("?");
            s1.append(",");
        }


        if (i3_yes.isChecked())
        {
            s1.append("1");
            s1.append(",");
        }
        else if(i3_no.isChecked())
        {
            s1.append("0");
            s1.append(",");
        }
        else
        {
            s1.append("?");
            s1.append(",");
        }



        if (qhypo_yes.isChecked())
        {
            s1.append("1");
            s1.append(",");
        }
        else if(qhypo_no.isChecked())
        {
            s1.append("0");
            s1.append(",");
        }
        else
        {
            s1.append("?");
            s1.append(",");
        }



        if (qhyper_yes.isChecked())
        {
            s1.append("1");
            s1.append(",");
        }
        else if(qhyper_no.isChecked())
        {
            s1.append("0");
            s1.append(",");
        }
        else
        {
            s1.append("?");
            s1.append(",");
        }



        if (li_yes.isChecked())
        {
            s1.append("1");
            s1.append(",");
        }
        else if(li_no.isChecked())
        {
            s1.append("0");
            s1.append(",");
        }
        else
        {
            s1.append("?");
            s1.append(",");
        }


        if (goi_yes.isChecked())
        {
            s1.append("1");
            s1.append(",");
        }
        else if(goi_no.isChecked())
        {
            s1.append("0");
            s1.append(",");
        }
        else
        {
            s1.append("?");
            s1.append(",");
        }

        if (tum_yes.isChecked())
        {
            s1.append("1");
            s1.append(",");
        }
        else if(tum_no.isChecked())
        {
            s1.append("0");
            s1.append(",");
        }
        else
        {
            s1.append("?");
            s1.append(",");
        }


        if (hypopit_yes.isChecked())
        {
            s1.append("1");
            s1.append(",");
        }
        else if(hypopit_no.isChecked())
        {
            s1.append("0");
            s1.append(",");
        }
        else
        {
            s1.append("?");
            s1.append(",");
        }



        if (psy_yes.isChecked())
        {
            s1.append("1");
            s1.append(",");
        }
        else if(psy_no.isChecked())
        {
            s1.append("0");
            s1.append(",");
        }
        else
        {
            s1.append("?");
            s1.append(",");
        }



        if (tshmeas_yes.isChecked())
        {
            s1.append("1");
            s1.append(",");
        }
        else if(tshmeas_no.isChecked())
        {
            s1.append("0");
            s1.append(",");
        }
        else
        {
            s1.append("?");
            s1.append(",");
        }



        if (tsh.getText()!= null)
        {
            s1.append(tsh.getText());
            s1.append(",");
        }
        else
        {
            s1.append("?");
            s1.append(",");
        }


        if (t3meas_yes.isChecked())
        {
            s1.append("1");
            s1.append(",");
        }
        else if(t3meas_no.isChecked())
        {
            s1.append("0");
            s1.append(",");
        }
        else
        {
            s1.append("?");
            s1.append(",");
        }




        if (t3.getText()!= null)
        {
//            y1=Float.parseFloat(t3.getText().toString());
//            if (y1>=60 && y1<=200) {
                s1.append(t3.getText());
                s1.append(",");
//                err1=1;
//            }
//            else
//            {
//                t3.setError("Please enter valid value!!");
//            }
        }
        else
        {
            s1.append("?");
            s1.append(",");
        }
        Log.e(TAG,"Rajnikanth is great. "+s1);
        if (tt4meas_yes.isChecked())
        {
            s1.append("1");
            s1.append(",");
        }
        else if(tt4meas_no.isChecked())
        {
            s1.append("0");
            s1.append(",");
        }
        else
        {
            s1.append("?");
            s1.append(",");
        }

        if (tt4.getText()!= null)
        {
//            y2=Float.parseFloat(tt4.getText().toString());
//            if (y2>=5 && y2<=12) {
                s1.append(tt4.getText());
                s1.append(",");
//                err2=1;
//            }
//            else
//            {
//                tt4.setError("Please enter valid value!!");
//            }

        }
        else
        {
            s1.append("?");
            s1.append(",");
        }

        if (t4umeas_yes.isChecked())
        {
            s1.append("1");
            s1.append(",");
        }
        else if(t4umeas_no.isChecked())
        {
            s1.append("0");
            s1.append(",");
        }
        else
        {
            s1.append("?");
            s1.append(",");
        }

        if (t4u.getText()!= null)
        {
            s1.append(t4u.getText());
            s1.append(",");
        }
        else
        {
            s1.append("?");
            s1.append(",");
        }


        if (ftumeas_yes.isChecked())
        {
            s1.append("1");
            s1.append(",");
        }
        else if(ftumeas_no.isChecked())
        {
            s1.append("0");
            s1.append(",");
        }
        else
        {
            s1.append("?");
            s1.append(",");
        }

        if (fti.getText()!= null)
        {
//            y3=Float.parseFloat(fti.getText().toString());
//            if (y3>=0.7 && y3<=1.8) {
                s1.append(fti.getText());
                s1.append(",");
//                err3=1;
//            }
//            else
//            {
//                fti.setError("Please enter valid value!!");
//            }
//
//
       }
        else
        {
            s1.append("?");
            s1.append(",");
        }


        if (tbgmeas_yes.isChecked())
        {
            s1.append("1");
            s1.append(",");
        }
        else if(tbgmeas_no.isChecked())
        {
            s1.append("0");
            s1.append(",");
        }
        else
        {
            s1.append("?");
            s1.append(",");
        }



        if (tbg.getText()!= null)
        {
            s1.append(tbg.getText());
            s1.append(",");
        }
        else
        {
            s1.append("?");
            s1.append(",");
        }

        if (r1.isChecked())
        {
            s1.append("1");
            s1.append(",");
        }
        else if(r2.isChecked())
        {
            s1.append("2");
            s1.append(",");
        }
        else if(r3.isChecked())
        {
            s1.append("3");
            s1.append(",");
        }
        else if(r4.isChecked())
        {
            s1.append("4");
            s1.append(",");
        }
        else if(r5.isChecked())
        {
            s1.append("5");
            s1.append(",");
        }
        else if(r6.isChecked())
        {
            s1.append("6");
            s1.append(",");
        }
        else
        {
            s1.append("?");
            s1.append(",");
        }


        // Toast.makeText(this, " "+s1, Toast.LENGTH_LONG).show();
    }
    public void dsp()
    {
//        if(err1==1 && err2==1 && err3==1)
//        {
        AlertDialog.Builder d = new AlertDialog.Builder( this);
        d.setTitle("FORM IS SAVED");
        d.setMessage(s1);

        Client myClient = new Client("192.168.43.35", 7000,s1.toString());
        myClient.execute();

        d.show();
        s1.setLength(0);
 //       }
//        else {
//            Toast.makeText(this, "Please fill all details in the form.", Toast.LENGTH_SHORT).show();
//        }

       /* FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
        RegisteredUserID=currentUser.getUid();
        mdatabase = FirebaseDatabase.getInstance().getReference().child("Thyroid_Form");
        mdatabase.child(RegisteredUserID).setValue(s1);*/
    }
    public void se()
    {
        Log.e(TAG,"a");
        s=Client.message;
        Log.e(TAG,"b");
        Intent i = new Intent(form_thyroid.this,second.class);
        Log.e(TAG,"c");
        i.putExtra("a",s);
        Log.e(TAG,"d");
        startActivity(i);
        Log.e(TAG,"e");
}
}