package com.example.vidhi.computeraideddiagnostic.Fragments;


import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.vidhi.computeraideddiagnostic.Client;
import com.example.vidhi.computeraideddiagnostic.R;
import com.example.vidhi.computeraideddiagnostic.form_thyroid;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * A simple {@link Fragment} subclass.
 */
/*
public class form_thy_frag extends Fragment {
    private TextView t1;
    Button btn_algo;

//    public form_thy_frag() {
//        // Required empty public constructor
//    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.activity_form_thyroid, container, false);
        t1 = v.findViewById(R.id.tee);
        btn_algo = (Button) v.findViewById(R.id.thy_result);
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //lv = (ListView) v.findViewById(R.id.lv);

//
        btn_algo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

              //  new form_thyroid.SendItem.execute("sdf");
                new form_thy_frag.SendItem().execute();

                //   applyalgo();
            }
        });


        */
/*public void applyalgo() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("hi i am vidh ");
        Client myClient = new Client("192.168.1.15", 6781, buffer.toString());
        myClient.execute();
//        try {
//            Thread.sleep(4000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }*//*


    }

    private class SendItem extends AsyncTask<String, Void, String> {

        private Exception exception;


        @Override
        protected String doInBackground(String... params) {
            try {
                try {
                    Socket s = new Socket("192.168.1.15", 6782);
                    //DataOutputStream dout=new DataOutputStream(s.getOutputStream());
                    String strr = "Bla bla bla";
                    // String str=params[0];
                    PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(s.getOutputStream()));
                    printWriter.print(strr);

                   */
/* StringBuffer buffer = new StringBuffer();
                    buffer.append("hi i am vidh");
                    Client myClient = new Client("192.168.1.15", 6781, buffer.toString());
                    myClient.execute();*//*


                    printWriter.print(strr.substring(0, 127));
                    printWriter.flush();

                    DataInputStream dis = new DataInputStream(s.getInputStream());
                    String strrr = (String) dis.readLine();
                    dis.close();
                    s.close();

                    return strr;

                } catch (IOException e) {
                    e.printStackTrace();
                }

            } catch (Exception e) {
                this.exception = e;
                return null;
            }
            return null;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            if (s != null) {
                //  progressBar.setVisibility(View.GONE);
                // tv_spam.setVisibility(View.VISIBLE);
                //tv_spam.setText(s.toUpperCase());
                //Toast.makeText(getContext(),"NOT A SPAM", Toast.LENGTH_SHORT).show();

                t1.setText(s);
            }
        }
    }

}
*/
