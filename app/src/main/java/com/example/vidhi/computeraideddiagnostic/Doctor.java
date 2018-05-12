package com.example.vidhi.computeraideddiagnostic;

import android.app.SearchManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static java.security.AccessController.getContext;

public class Doctor extends AppCompatActivity {

    DatabaseHelper myDb;
    Cursor cursor;
    public static final String TAG = "vidhi1";
    ArrayAdapter<String> adapter;
    ArrayList<String> namelist;
    SearchView searchname;
    TextView j11;

    private DatabaseReference mRootRef,reference;

    private FirebaseUser mCurrent_user;

    private DatabaseReference mUsersDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor);

        mRootRef = FirebaseDatabase.getInstance().getReference();
        mCurrent_user = FirebaseAuth.getInstance().getCurrentUser();
        j11 = (TextView) findViewById(R.id.j1);

        // myDb = new DatabaseHelper(this);

        //searchname=(SearchView) findViewById(R.id.searchname);

        final ListView listView = (ListView) findViewById(R.id.patient_name);
        namelist = new ArrayList<String>();
    //    Cursor data = myDb.getName();

//        if (data.getCount() == 0) {
//            Toast.makeText(this, "No data found!!", Toast.LENGTH_SHORT).show();
//        } else {
//            while (data.moveToNext()) {
//                namelist.add(data.getString(0));

                /*ListAdapter listAdapter = new Array
                Adapter<>(this,android.R.layout.simple_list_item_1,namelist);
                listView.setAdapter(listAdapter);*/
         //   }
//            adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, namelist);
//            listView.setAdapter(adapter);
//
//
//
//            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//                @Override
//                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//
//                        Intent intent = new Intent(Doctor.this, DetailActivity.class );
//                        intent.putExtra("EXTRA_FIND",position);
//                        Log.d(TAG,String.valueOf(position));
//                        startActivity(intent);
//                    //}
//            }

        mUsersDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                final FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();

                final String Registered = mUsersDatabase.child("Investigation").toString();
                reference= FirebaseDatabase.getInstance().getReference("Investigation");

                String display_name = dataSnapshot.child("name").getValue().toString();
                Map<String, Object> map = (Map<String, Object>)dataSnapshot.getValue();
                String invest=map.get(Registered).toString();
                j11.setText(invest);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }

}






    /*public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        SearchManager manager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = (SearchView) menu.findItem(R.id.searchname).getActionView();
        ComponentName componentName = new ComponentName(this, Doctor.class);
        searchView.setSearchableInfo(manager.getSearchableInfo(getComponentName()));
        return true;
        /*searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            public boolean onQueryTextChange(String newText) {
                //adapter.getFilter().filter(newText);

                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
        }*/

