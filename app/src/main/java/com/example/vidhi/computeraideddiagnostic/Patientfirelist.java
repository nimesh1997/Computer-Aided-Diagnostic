package com.example.vidhi.computeraideddiagnostic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Patientfirelist extends AppCompatActivity {

    private RecyclerView mUsersList;
    private DatabaseReference mUsersDatabase;
    private LinearLayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patientfirelist);

        mLayoutManager = new LinearLayoutManager(this);


        mUsersList = (RecyclerView) findViewById(R.id.user_list_fire);
        mUsersList.setHasFixedSize(true);
        mUsersList.setLayoutManager(mLayoutManager);
        mUsersDatabase = FirebaseDatabase.getInstance().getReference().child("Users");
    }

    protected void onStart() {
        super.onStart();
        FirebaseRecyclerAdapter<Users, List.UsersViewHolder> freebaseRecyclerAdapter = new FirebaseRecyclerAdapter<Users, List.UsersViewHolder>(

                Users.class,

                R.layout.user_sigle_fireeee_layout,
                List.UsersViewHolder.class,
                mUsersDatabase

        ) {
            @Override
            protected void populateViewHolder(List.UsersViewHolder usersViewHolder, Users users, int position) {

                usersViewHolder.setDisplayName1(users.getName());

                //  usersViewHolder.setUserImage(users.getThumb_image(), getApplicationContext());
                final String user_id = getRef(position).getKey();

                usersViewHolder.mView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Intent profileIntent = new Intent(Patientfirelist.this, Patientdetails_firee.class);
                        profileIntent.putExtra("user_id1", user_id);
                        startActivity(profileIntent);

                    }
                });

            }
        };


        mUsersList.setAdapter(freebaseRecyclerAdapter);

    }



}

