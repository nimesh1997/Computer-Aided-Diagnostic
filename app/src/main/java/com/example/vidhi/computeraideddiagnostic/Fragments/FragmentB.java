package com.example.vidhi.computeraideddiagnostic.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.vidhi.computeraideddiagnostic.DataStoreB;
import com.example.vidhi.computeraideddiagnostic.DatabaseHelper;
import com.example.vidhi.computeraideddiagnostic.R;

public class FragmentB extends Fragment {
    DatabaseHelper helper;
    DataStoreB dataStore;
    Button btn;
    EditText ed, ed2;
    String n1, n2;
    ViewPager viewPager;
    private static final String TAG = "sachan";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_b, container, false);
        helper =new DatabaseHelper(getActivity());
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ed=(EditText) getActivity().findViewById(R.id.edit3);
        ed2=(EditText) getActivity().findViewById(R.id.edit4);
        btn = (Button) getActivity().findViewById(R.id.butto);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Log.d(TAG, "100");
                Context context = getActivity().getApplicationContext();
                n1 = ed.getText().toString();
                n2 = ed2.getText().toString();
                //viewPager= (ViewPager) getActivity().findViewById(R.id.pages);
                //helper.insertDatas(new DataStoreB(n1, n2));
                //viewPager.setCurrentItem(2);
                Toast.makeText(context, "data saved", Toast.LENGTH_LONG).show();
            }
        });
       // List<DataStoreB> info = helper.getAllinfo();
        /*for(DataStoreB db_ : info){
            String cd = "id: "+ db_.getId() +" ,cont: "+db_.getText1() + ", zxc: "+db_.getText2();
            //Log.i(TAG, cd);
        }*/

    }
}
