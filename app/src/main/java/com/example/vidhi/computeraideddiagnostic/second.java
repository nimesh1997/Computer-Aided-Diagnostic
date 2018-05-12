package com.example.vidhi.computeraideddiagnostic;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import org.w3c.dom.Text;

public class second extends Activity {

    TextView textView;
    String newStr = null;
    String nstr = null;
    String TAG="vidhi";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Log.e(TAG,"aa");
        textView = (TextView) findViewById(R.id.tb);
        Log.e(TAG,"bb");
        textView.setText(" ");
        Bundle bundle = getIntent().getExtras();
        Log.e(TAG,"cc");
        newStr = bundle.getString("a");
        Log.e(TAG,"dd");
        textView.setText(newStr);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.finish();
    }
}