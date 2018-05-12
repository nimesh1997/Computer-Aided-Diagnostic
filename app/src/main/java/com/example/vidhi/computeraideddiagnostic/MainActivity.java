package com.example.vidhi.computeraideddiagnostic;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import com.example.vidhi.computeraideddiagnostic.Fragments.allergy_history;
import com.example.vidhi.computeraideddiagnostic.Fragments.chief_complaints;
import com.example.vidhi.computeraideddiagnostic.Fragments.drugs_history;
import com.example.vidhi.computeraideddiagnostic.Fragments.family_history;
import com.example.vidhi.computeraideddiagnostic.Fragments.gyaneco_history;
import com.example.vidhi.computeraideddiagnostic.Fragments.history_past_illness;
import com.example.vidhi.computeraideddiagnostic.Fragments.investigations;
import com.example.vidhi.computeraideddiagnostic.Fragments.personal_biodata;
import com.example.vidhi.computeraideddiagnostic.Fragments.personal_social_history;
import com.example.vidhi.computeraideddiagnostic.Fragments.symptoms_present_illness;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    TabLayout tablayout;
    ViewPager viewPager = null;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private DatabaseReference mUserDatabase;
    private FirebaseUser mCurrentUser;
    private TextView txt;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // myDb = new DatabaseHelper(this);
        if (!isTaskRoot()) {
            finish();
            return;
        }
        mAuth = FirebaseAuth.getInstance();
        if (android.os.Build.VERSION.SDK_INT >= 11) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_HARDWARE_ACCELERATED, WindowManager.LayoutParams.FLAG_HARDWARE_ACCELERATED);
        }
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);
       /* txt=(TextView) findViewById(R.id.user_id);
        mCurrentUser = FirebaseAuth.getInstance().getCurrentUser();

        String current_id = mCurrentUser.getUid();
        mUserDatabase = FirebaseDatabase.getInstance().getReference().child("Users").child(current_id);
        mUserDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {


                    String name = dataSnapshot.child("name").getValue().toString();
                    // Long age = (Long) messageSnapshot.child("age").getValue();
                    txt.setText(name);

                }






            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

*/

        ViewFlipper view = (ViewFlipper) findViewById(R.id.viewflip);
        Animation fadeIn = AnimationUtils.loadAnimation(this, R.anim.slide_in_right);
        Animation fadeOut = AnimationUtils.loadAnimation(this, R.anim.slide_out_left);
        view.setAutoStart(true);
        view.setInAnimation(fadeIn);
        view.setOutAnimation(fadeOut);
        view.setFlipInterval(3500);
        view.startFlipping();

        FragmentManager manager = getSupportFragmentManager();
        viewPager = (ViewPager) findViewById(R.id.pages);
        tablayout = (TabLayout) findViewById(R.id.tabs);
        tablayout.setupWithViewPager(viewPager);
        //reference to viewPager
        viewPager.setAdapter(new TabAdapter(manager));

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

    }



    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")

    public void SendToStart() {
        startActivity(new Intent(MainActivity.this, LOGIN.class));
    }

    public boolean onNavigationItemSelected(final MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                switch (item.getItemId()) {

                    case R.id.image:
                        Intent intent2 = new Intent(MainActivity.this, ImageActivity.class);
                        startActivity(intent2);

                        break;
                    case R.id.nav_about:
                        Intent intent = new Intent(MainActivity.this, AboutUs.class);
                        startActivity(intent);
                        break;



                    case R.id.nav_logout:
                        FirebaseAuth.getInstance().signOut();
                        SendToStart();
                        break;



                }
            }
        }, 400);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


}

//create own Adapter to swiping the pages
class TabAdapter extends FragmentPagerAdapter {

    public TabAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        if (position == 0) {
            fragment = new personal_biodata();
        }
        if (position == 1) {
            fragment = new chief_complaints();
        }
        if (position == 2) {
            fragment = new symptoms_present_illness();
        }
        if (position == 3) {
            fragment = new history_past_illness();
        }
        if (position == 4) {
            fragment = new family_history();
        }
        if (position == 5) {
            fragment = new allergy_history();
        }
        if (position == 6) {
            fragment = new gyaneco_history();
        }
        if (position == 7) {
            fragment = new drugs_history();
        }
        if (position == 8) {
            fragment = new personal_social_history();
        }
        if (position == 9) {
            fragment = new investigations();
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 10;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String title = null;
        Log.d("Nimesh", "getPageTitle is called");

        switch (position) {
            case 0:
                title = "PATIENT BIODATA";
                break;
            case 1:
                title = "CHIEF COMPLAINTS";
                break;
            case 2:
                title = "HISTORY OF PRESENT ILLNESS";
                break;
            case 3:
                title = "HISTORY OF PAST ILLNESS";
                break;
            case 4:
                title = "FAMILY HISTORY";
                break;
            case 5:
                title = "ALLERGIES HISTORY";
                break;
            case 6:
                title = "GYNAECOLOGICAL HISTORY";
                break;
            case 7:
                title = "DRUGS HISTORY";
                break;
            case 8:
                title = "PERSONAL AND SOCIAL HISTORY";
                break;
            case 9:
                title = "INVESTIGATIONS";
                break;
        }
        return title;

    }
}
