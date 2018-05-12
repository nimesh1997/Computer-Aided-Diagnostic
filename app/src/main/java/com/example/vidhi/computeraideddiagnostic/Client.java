package com.example.vidhi.computeraideddiagnostic;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class Client extends AsyncTask<Void, Void, Void> {

    String dstAddress;
    int dstPort;
    String sendText;
    static final int BUFFER_SIZE = 2048;
    public static String message = "";

    Client(String addr, int port,String mainText) {
        dstAddress = addr;
        dstPort = port;
        sendText = mainText;
    }

    @Override
    protected Void doInBackground(Void... arg0) {

        Socket socket = null;


        try {
            socket = new Socket(dstAddress, dstPort);
            PrintWriter out = new PrintWriter(new BufferedWriter(
                    new OutputStreamWriter(socket.getOutputStream())), true);
            out.println(sendText);
            out.flush();

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            try {
                int charsRead = 0;
                char[] buffer = new char[BUFFER_SIZE];

                while ((charsRead = in.read(buffer)) != -1) {
                    message += new String(buffer).substring(0, charsRead);
                }} catch (IOException e) {
                e.printStackTrace();
            }

        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();

        } finally {
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

}






















































































































































/*
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

public class Client extends AsyncTask<String, Void, String> {

    String dstAddress;
    int dstPort;
    TextView tb1;
    String sendText;
    static final int BUFFER_SIZE = 2048;
    public static String message = "";
    public interface AsyncResponse {
        void processFinish(String output);
    }
    public AsyncResponse delegate = null;
    public Client(AsyncResponse delegate){
        this.delegate = delegate;
    }
    Client(String addr, int port, String mainText) {
        dstAddress = addr;
        dstPort = port;
        sendText = mainText;
    }


    @Override
    protected String doInBackground(String... strings) {
        Socket socket = null;

        try {
            socket = new Socket(dstAddress, dstPort);
            PrintWriter out = new PrintWriter(new BufferedWriter(
                    new OutputStreamWriter(socket.getOutputStream())), true);
            out.println(sendText);
            out.flush();

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            try {
                int charsRead = 0;
                char[] buffer = new char[BUFFER_SIZE];

                while ((charsRead = in.read(buffer)) != -1) {
                    message += new String(buffer).substring(0, charsRead);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();

        } finally {
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
    @Override
    protected void onPostExecute(String result) {
        //delegate.processFinish(result);
        super.onPostExecute(result);
        if (result != null) {
            Log.e("ads",result);
            //tb1.setText(s);
        }
    }
}*/
