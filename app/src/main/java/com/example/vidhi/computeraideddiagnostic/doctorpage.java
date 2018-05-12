package com.example.vidhi.computeraideddiagnostic;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.Map;

import de.hdodenhof.circleimageview.CircleImageView;

public class doctorpage extends AppCompatActivity {

    TextView inv,invv;
    String TAG="vamp";
    private DatabaseReference mdatabase,reference;

    private RecyclerView mUsersList;
    private DatabaseReference mUsersDatabase;
    private LinearLayoutManager mLayoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctorpage);
        inv=findViewById(R.id.investans);
        invv=findViewById(R.id.investansans);
        vieww();

        mLayoutManager = new LinearLayoutManager(this);


        mUsersList = (RecyclerView) findViewById(R.id.user_list11);
        mUsersList.setHasFixedSize(true);
        mUsersList.setLayoutManager(mLayoutManager);
        mUsersDatabase = FirebaseDatabase.getInstance().getReference().child("Users");
    }


    protected void onStart() {
        super.onStart();
        FirebaseRecyclerAdapter<Users, List.UsersViewHolder> freebaseRecyclerAdapter = new FirebaseRecyclerAdapter<Users, List.UsersViewHolder>(

                Users.class,

                R.layout.user_single_layout,
                List.UsersViewHolder.class,
                mUsersDatabase

        ) {
            @Override
            protected void populateViewHolder(List.UsersViewHolder usersViewHolder, Users users, int position) {

                usersViewHolder.setDisplayName(users.getName());

                usersViewHolder.setUserImage(users.getThumb_image(), getApplicationContext());
                final String user_id = getRef(position).getKey();

                usersViewHolder.mView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Intent profileIntent = new Intent(doctorpage.this,doctor_patient.class);
                        profileIntent.putExtra("user_id", user_id);
                        startActivity(profileIntent);

                    }
                });

            }
        };


        mUsersList.setAdapter(freebaseRecyclerAdapter);

    }


    public static class UsersViewHolder extends RecyclerView.ViewHolder {

        View mView;

        public UsersViewHolder(View itemView) {
            super(itemView);

            mView = itemView;

        }

        public void setDisplayName(String name) {

            TextView userNameView = (TextView) mView.findViewById(R.id.user_single_name);
            userNameView.setText(name);

        }
        public void setUserImage(String thumb_image, Context ctx){

            CircleImageView userImageView = (CircleImageView) mView.findViewById(R.id.user_single_image);

            Picasso.with(ctx).load(thumb_image).placeholder(R.drawable.user).into(userImageView);

        }
    }

    public void vieww()
    {

        final FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();

        final String Registered = currentUser.getEmail().replace(".",",");
        reference= FirebaseDatabase.getInstance().getReference("Investigation");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                //   if(Registered.compareTo(dataSnapshot.getValue().toString())==0)
                //   {
                Map<String, Object> map = (Map<String, Object>)dataSnapshot.getValue();
                String invest=map.get(Registered).toString();

                Log.e(TAG,"invest="+invest);
                inv.setText(Registered);
                invv.setText(invest);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

}
