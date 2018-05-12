package com.example.vidhi.computeraideddiagnostic.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.vidhi.computeraideddiagnostic.DataStore;
import com.example.vidhi.computeraideddiagnostic.DatabaseHelper;
import com.example.vidhi.computeraideddiagnostic.R;

import java.util.List;

public class FragmentA extends Fragment {

    private static final String TAG = "nimesh";
    DatabaseHelper helper;
    DataStore dataStore;
    Button btn;
    EditText ed, ed2;
    String n1, n2;
    ViewPager viewPager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_a, container, false);
       // helper =new DatabaseHelper(getActivity());
 //       viewPager =(ViewPager) getActivity().findViewById(R.id.pages);
      //  Log.i(TAG,"onCreate");
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

//        ed=(EditText) getActivity().findViewById(R.id.edit1);
//        ed2=(EditText) getActivity().findViewById(R.id.edit2);
//        btn = (Button) getActivity().findViewById(R.id.button);
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Log.d(TAG, "100");
//                Context context = getActivity().getApplicationContext();
//                n1 = ed.getText().toString();
//                n2 = ed2.getText().toString();
//                //viewPager= (ViewPager) getActivity().findViewById(R.id.pages);
//                helper.insertData(new DataStore(n1, n2));
//                Toast.makeText(context, "data saved", Toast.LENGTH_LONG).show();
//            }
//        });
//        Log.i(TAG,"onActivitycreate");
//        List<DataStore> infos = helper.getAll();
//        //List<DataStoreB> info = helper.getAllinfo();
//
//        StringBuffer buffer = new StringBuffer();
//        for (DataStore da : infos){
//            String cat = "Id: "+da.getId()+" ,Name: "+da.getText1()+ " ,some: "+da.getText2();
//            Log.i(TAG, cat);
//        }
  }

}
