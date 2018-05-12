package com.example.vidhi.computeraideddiagnostic;

import android.app.Dialog;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class DetailActivity extends AppCompatActivity {

    public final String TAG = "sd";
    public static final int EXTRA_FIND = 0;
    private static final int PERMISSION_SEND_SMS = 1;
    public String p1 = "0", p2 = "0", p3 = "0", p4 = "0", p5 = "0", p6 = "0", p7 = "0", p8 = "0", p9 = "0", p10 = "0", p11 = "0", p12 = "0";
    public String r1 = "0", r2 = "0", r3 = "0", r4 = "0", r5 = "0", r6 = "0", r7 = "0", r8 = "0", r9 = "0", r10 = "0", r11 = "0", r12 = "0";
    public String s1 = "0", s2 = "0", s3 = "0";
    public String t1 = "0", t2 = "0", t3 = "0", t4 = "0", t5 = "0", t6 = "0", t7 = "No Information.";
    public String u1 = "0", u2 = "0", u3 = "0", u4 = "0", u5 = "0", u6 = "0", u7 = "0", u8 = "0", u9 = "0", u10 = "0", u11 = "0", u12 = "0", u13 = "0", u14 = "0", u15 = "0";
    public String v1 = "0";
    public String w1 = "0", w2 = "0", w3 = "0", w4 = "0", w5 = "0", w6 = "0", w7 = "0", w8 = "0", w9 = "0", w10 = "0", w11 = "0", w12 = "0", w13 = "0", w14 = "0", w15 = "0", w16 = "0", w17 = "0", w18 = "0", w19 = "0", w20 = "0", w21 = "0", w22 = "0", w23 = "0", w24 = "0";
    public String x1 = "0", x2 = "0";
    public String y1 = "0", y2 = "0", y3 = "0", y4 = "0", y5 = "0", y6 = "0", y7 = "0", y8 = "0", y9 = "0", y10 = "0", y11 = "0", y12 = "0", y13 = "0", y14 = "0";
    public String z1 = "0", z2 = "0";
    TextView a2, a4, a6, a8, a10, a12, a14, a16, a18, a20, a22, a24, b4, b6, b8, b10, c2, c4, c6, d2, d4, d6, d8, d10, d11, e2, e4, e6, f1, g2, g4, g6, g8, g10, g12, g14, g16, g18, g20, g22, g24, h2, h4, i2, i4, i6, i8, j1;
    DatabaseHelper myDb;
    Button btn_sms, btn_upload;
    TextView test_pres;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        myDb = new DatabaseHelper(this);

        a2 = (TextView) findViewById(R.id.a2);
        a4 = (TextView) findViewById(R.id.a4);
        a6 = (TextView) findViewById(R.id.a6);
        a8 = (TextView) findViewById(R.id.a8);
        a10 = (TextView) findViewById(R.id.a10);
        a12 = (TextView) findViewById(R.id.a12);
        a14 = (TextView) findViewById(R.id.a14);
        a16 = (TextView) findViewById(R.id.a16);
        a18 = (TextView) findViewById(R.id.a18);
        a20 = (TextView) findViewById(R.id.a20);
        a22 = (TextView) findViewById(R.id.a22);
        a24 = (TextView) findViewById(R.id.a24);
        b4 = (TextView) findViewById(R.id.b4);
        b6 = (TextView) findViewById(R.id.b6);
        b8 = (TextView) findViewById(R.id.b8);
        b10 = (TextView) findViewById(R.id.b10);
        c2 = (TextView) findViewById(R.id.c2);
        c4 = (TextView) findViewById(R.id.c4);
        c6 = (TextView) findViewById(R.id.c6);
        d2 = (TextView) findViewById(R.id.d2);
        d4 = (TextView) findViewById(R.id.d4);
        d6 = (TextView) findViewById(R.id.d6);
        d8 = (TextView) findViewById(R.id.d8);
        d10 = (TextView) findViewById(R.id.d10);
        d11 = (TextView) findViewById(R.id.d11);
        e2 = (TextView) findViewById(R.id.e2);
        e4 = (TextView) findViewById(R.id.e4);
        e6 = (TextView) findViewById(R.id.e6);
        f1 = (TextView) findViewById(R.id.f1);
        g2 = (TextView) findViewById(R.id.g2);
        g4 = (TextView) findViewById(R.id.g4);
        g6 = (TextView) findViewById(R.id.g6);
        g8 = (TextView) findViewById(R.id.g8);
        g10 = (TextView) findViewById(R.id.g10);
        g12 = (TextView) findViewById(R.id.g12);
        g14 = (TextView) findViewById(R.id.g14);
        g16 = (TextView) findViewById(R.id.g16);
        g18 = (TextView) findViewById(R.id.g18);
        g20 = (TextView) findViewById(R.id.g20);
        g22 = (TextView) findViewById(R.id.g22);
        g24 = (TextView) findViewById(R.id.g24);

        h2 = (TextView) findViewById(R.id.h2);
        h4 = (TextView) findViewById(R.id.h4);
        i2 = (TextView) findViewById(R.id.i2);
        i4 = (TextView) findViewById(R.id.i4);
        i6 = (TextView) findViewById(R.id.i6);
        i8 = (TextView) findViewById(R.id.i8);
      //  j1 = (TextView) findViewById(R.id.j1);
        test_pres = (EditText) findViewById(R.id.test_pres);

        int s = getIntent().getIntExtra("EXTRA_FIND", 0);
        //Log.d(TAG, String.valueOf(s));
        Cursor data1 = myDb.getallp_data(s + 1);
        if (data1.getCount() == 0) {
            //Toast.makeText(this, "No data found!!", Toast.LENGTH_SHORT).show();
            Log.d(TAG, s1);
        } else {
            ArrayList<String> list = new ArrayList<String>();
            if (data1.getCount() > 0 && data1 != null) {
                data1.moveToFirst();
                p1 = data1.getString(1);
                p2 = data1.getString(2);
                p3 = data1.getString(3);
                p4 = data1.getString(4);
                p5 = data1.getString(5);
                p6 = data1.getString(6);
                p7 = data1.getString(7);
                p8 = data1.getString(8);
                p9 = data1.getString(9);
                p10 = data1.getString(10);
                p11 = data1.getString(11);
                p12 = data1.getString(12);
                if (p1 != null) {
                    list.add(p1);
                } else {
                    list.add("No Information.");
                }
                if (p2 != null) {
                    list.add(p2);
                } else {
                    list.add("No Information.");
                }
                if (p3 != null) {
                    list.add(p3);
                } else {
                    list.add("No Information.");
                }
                if (p4 != null) {
                    list.add(p4);
                } else {
                    list.add("No Information.");
                }
                if (p5 != null) {
                    list.add(p5);
                } else {
                    list.add("No Information.");
                }
                if (p6 != null) {
                    list.add(p6);
                } else {
                    list.add("No Information.");
                }
                if (p7 != null) {
                    list.add(p7);
                } else {
                    list.add("No Information.");
                }
                if (p8 != null) {
                    list.add(p8);
                } else {
                    list.add("No Information.");
                }
                if (p9 != null) {
                    list.add(p9);
                } else {
                    list.add("No Information.");
                }
                if (p10 != null) {
                    list.add(p10);
                } else {
                    list.add("No Information.");
                }
                if (p11 != null) {
                    list.add(p11);
                } else {
                    list.add("No Information.");
                }
                if (p12 != null) {
                    list.add(p12);
                } else {
                    list.add("No Information.");
                }
            }//data1.moveToNext();
            /*if(data1.moveToFirst()){
                do{
                    list.add(data1.getString(0));
                }while (data1.moveToNext());
            }*/
            //a2.setText(list.get(1));
            /*Cursor yourCursor = myDb.getYourTableContents();

            int i = 0;

            while (yourCursor.moveToNext() && i <= s-1) {
                i += 1;
            }*/
            //Log.d(TAG, p1);//Log.d(TAG,list.get(2));Log.d(TAG,list.get(3));Log.d(TAG,list.get(4));Log.d(TAG,list.get(5));Log.d(TAG,list.get(6));Log.d(TAG,list.get(7));Log.d(TAG,list.get(8));Log.d(TAG,list.get(9));Log.d(TAG,list.get(10));Log.d(TAG,list.get(11));
            a2.setText(list.get(0));
            a4.setText(list.get(1));
            a6.setText(list.get(2));
            a8.setText(list.get(3));
            a10.setText(list.get(4));
            a12.setText(list.get(5));
            a14.setText(list.get(6));
            a16.setText(list.get(7));
            a18.setText(list.get(8));
            a20.setText(list.get(9));
            a22.setText(list.get(10));
            a24.setText(list.get(11));

            Cursor data2 = myDb.getallcc_data(s + 1);
            ArrayList<String> list2 = new ArrayList<String>();
            if (data2.getCount() > 0 && data2 != null) {
                data2.moveToFirst();
                r1 = data2.getString(1);
                r2 = data2.getString(2);
                r3 = data2.getString(3);
                r4 = data2.getString(4);
                r5 = data2.getString(5);
                r6 = data2.getString(6);
                r7 = data2.getString(7);
                r8 = data2.getString(8);
                r9 = data2.getString(9);
                r10 = data2.getString(10);
                r11 = data2.getString(11);
                r12 = data2.getString(12);
            }
            if (Integer.parseInt(r1) == 1) {
                list2.add("Lower Abdomen");
            } else if (Integer.parseInt(r2) == 1) {
                list2.add("Upper Abdomen");
            } else {
                list2.add("None");
            }
//        if (Integer.parseInt(r4) == 1) {
//            list2.add("Yes");
//        } else {
//            list2.add("No");
//        }
            if (Integer.parseInt(r4) == 1) {
                if (Integer.parseInt(r11) == 1) {
                    list2.add("More than 1 week");
                } else if (Integer.parseInt(r12) == 1) {
                    list2.add("Less than 1 week");
                }
            } else {
                list2.add("No");
            }

            if (Integer.parseInt(r6) == 1) {
                list2.add("Yes");
            } else {
                list2.add("No");
            }
            if (Integer.parseInt(r8) == 1) {
                list2.add("High");
            } else if (Integer.parseInt(r9) == 1) {
                list2.add("Low");
            } else {
                list2.add("Normal");
            }
            //String sd = String.valueOf(data2.getCount());
        /*Log.d(TAG,list2.get(0));Log.d(TAG,list2.get(1));Log.d(TAG,list2.get(2));Log.d(TAG,list2.get(3));/*Log.d(TAG,r5);Log.d(TAG,r6);Log.d(TAG,r7);Log.d(TAG,r8);
        Log.d(TAG,r9);Log.d(TAG,r10);*/
            b4.setText(list2.get(0));
            b6.setText(list2.get(1));
            b8.setText(list2.get(2));
            b10.setText(list2.get(3));

            Cursor data3 = myDb.getallhpril_data(s + 1);
            ArrayList<String> list3 = new ArrayList<String>();
            if (data3.getCount() > 0 && data3 != null) {
                data3.moveToFirst();
                s1 = data3.getString(1);
                s2 = data3.getString(2);
                s3 = data3.getString(3);
            }
            if (Integer.parseInt(s1) == 1) {
                list3.add("Yes.");
            } else {
                list3.add("No.");
            }
            if (Integer.parseInt(s2) == 1) {
                list3.add("Yes.");
            } else {
                list3.add("No.");
            }
            if (Integer.parseInt(s3) == 1) {
                list3.add("Yes.");
            } else {
                list3.add("No.");
            }
            c2.setText(list3.get(0));
            c4.setText(list3.get(1));
            c6.setText(list3.get(2));

            Cursor data4 = myDb.getallhpail_data(s + 1);
            ArrayList<String> list4 = new ArrayList<String>();
            if (data4.getCount() > 0 && data4 != null) {
                data4.moveToFirst();
                t1 = data4.getString(1);
                t2 = data4.getString(2);
                t3 = data4.getString(3);
                t4 = data4.getString(4);
                t5 = data4.getString(5);
                t6 = data4.getString(6);
                t7 = data4.getString(7);
            }
            if (Integer.parseInt(t1) == 1) {
                list4.add("Yes.");
            } else {
                list4.add("No.");
            }
            if (Integer.parseInt(t2) == 1) {
                list4.add("Yes");
            } else {
                list4.add("No.");
            }
            if (Integer.parseInt(t3) == 1) {
                list4.add("Yes");
            } else {
                list4.add("No.");
            }
            if (Integer.parseInt(t4) == 1) {
                list4.add("Yes");
            } else {
                list4.add("No.");
            }
            if (Integer.parseInt(t5) == 1) {
                list4.add(t6);
            } else {
                list4.add("No.");
            }
            list4.add(t7);
            d2.setText(list4.get(0));
            d4.setText(list4.get(1));
            d6.setText(list4.get(2));
            d8.setText(list4.get(3));
            d10.setText(list4.get(4));
            d11.setText(list4.get(5));

            Cursor data5 = myDb.getallfh_data(s + 1);
            ArrayList<String> list5 = new ArrayList<String>();
            if (data5.getCount() > 0 && data5 != null) {
                data5.moveToFirst();
                u1 = data5.getString(1);
                u2 = data5.getString(4);
                u3 = data5.getString(7);
                u4 = data5.getString(10);
                u5 = data5.getString(13);
                u6 = data5.getString(2);
                u7 = data5.getString(5);
                u8 = data5.getString(8);
                u9 = data5.getString(11);
                u10 = data5.getString(14);
                u11 = data5.getString(3);
                u12 = data5.getString(6);
                u13 = data5.getString(9);
                u14 = data5.getString(12);
                u15 = data5.getString(15);
            }

            StringBuilder builder1 = new StringBuilder();
            StringBuilder builder2 = new StringBuilder();
            StringBuilder builder3 = new StringBuilder();
            int tem1 = 0, tem2 = 0, tem3 = 0;
            if (Integer.parseInt(u1) == 1) {
                builder1.append("Diabetes" + ". ");
                tem1++;
            }
            if (Integer.parseInt(u2) == 1) {
                builder1.append("Thyroid" + ". ");
                tem1++;
            }
            if (Integer.parseInt(u3) == 1) {
                builder1.append("Hypertension" + ". ");
                tem1++;
            }
            if (Integer.parseInt(u4) == 1) {
                builder1.append(u5 + ". ");
                tem1++;
            }
            if (tem1 == 0) {
                e2.setText("No Information.");
            } else {
                e2.setText(builder1.toString());
            }

            if (Integer.parseInt(u6) == 1) {
                builder2.append("Diabetes" + ". ");
                tem2++;
            }
            if (Integer.parseInt(u7) == 1) {
                builder2.append("Thyroid" + ". ");
                tem2++;
            }
            if (Integer.parseInt(u8) == 1) {
                builder2.append("Hypertension" + ". ");
                tem2++;
            }
            if (Integer.parseInt(u9) == 1) {
                builder2.append(u10 + ". ");
                tem1++;
            }
            if (tem2 == 0) {
                e4.setText("No Information.");
            } else {
                e4.setText(builder2.toString());
            }
            if (Integer.parseInt(u11) == 1) {
                builder3.append("Diabetes" + ". ");
                tem3++;
            }
            if (Integer.parseInt(u12) == 1) {
                builder3.append("Thyroid" + ". ");
                tem3++;
            }
            if (Integer.parseInt(u13) == 1) {
                builder3.append("Hypertension" + ". ");
                tem3++;
            }
            if (Integer.parseInt(u14) == 1) {
                builder3.append(u15 + ". ");
                tem3++;
            }
            if (tem3 == 0) {
                e6.setText("No Information.");
            } else {
                e6.setText(builder3.toString());
            }

            Cursor data6 = myDb.getallah_data(s + 1);
            ArrayList<String> list6 = new ArrayList<String>();
            if (data6.getCount() > 0 && data6 != null) {
                data6.moveToFirst();
                v1 = data6.getString(1);
                list6.add(v1);
            }
            //Log.d(TAG,list6.get(0));
            f1.setText(list6.get(0));

            /*Cursor data7 = myDb.getallgh_data(s + 1);
            ArrayList<String> list7 = new ArrayList<String>();
            if (data7.getCount() > 0 && data7 != null) {
                data7.moveToFirst();
                w1 = data7.getString(1);
                w2 = data7.getString(2);
                w3 = data7.getString(3);
                w4 = data7.getString(4);
                w5 = data7.getString(5);
                w6 = data7.getString(6);
                w7 = data7.getString(7);
                w8 = data7.getString(8);
                w9 = data7.getString(9);
                w10 = data7.getString(10);

           /* w11 = data7.getString(11);
            w12 = data7.getString(12);
            w13 = data7.getString(13);
            w14 = data7.getString(14);
            w15 = data7.getString(15);
            w16 = data7.getString(16);
            w17 = data7.getString(17);
            w18 = data7.getString(18);
            w19 = data7.getString(19);
            w20 = data7.getString(20);
            w21 = data7.getString(21);
            w22 = data7.getString(22);
            w23 = data7.getString(23);
            w24 = data7.getString(24);*/
            /*list7.add(w1);
            list7.add(w2);
           // list7.add(w18);
        }*/
                /*if (Integer.parseInt(w3) == 1) {
                    list7.add("Regular");
                    tempr1++;
                } else if (Integer.parseInt(w4) == 1) {
                    list7.add("Irregular");
                    tempr2++;
                }
                if (Integer.parseInt(w5) == 1) {
                    list7.add("2-3 days");
                    tempr3++;
                } else if (Integer.parseInt(w6) == 1) {
                    list7.add("3-5 days");
                    tempr4++;
                } else if (Integer.parseInt(w7) == 1) {
                    list7.add("5-7 days");
                    tempr5++;
                }
                if (Integer.parseInt(w8) == 1) {
                    list7.add("Lower Abdomen");
                    tempr6++;
                } else if (Integer.parseInt(w9) == 1) {
                    list7.add("Upper Abdomen");
                    tempr7++;
                } else if (Integer.parseInt(w10) == 1) {
                    list7.add("None");
                    tempr8++;
                }

        if (Integer.parseInt(w11) == 1) {
                list7.add("White");
                tempr9++;
        } else if (Integer.parseInt(w12) == 1) {
                list7.add("Yellowish");
                tempr10++;
        }
        if (Integer.parseInt(w13) == 1) {
                list7.add("Thick");
                tempr11++;
        } else if (Integer.parseInt(w14) == 1) {
                list7.add("Thin");
                tempr12++;
        } else if (Integer.parseInt(w15) == 1) {
                list7.add("Normal");
                tempr13++;
        }
        if (Integer.parseInt(w16) == 1) {
                list7.add("Excess");
                tempr14++;
        } else if (Integer.parseInt(w17) == 1) {
                list7.add("Less");
                tempr15++;
        }
        if (Integer.parseInt(w19) == 1) {
                list7.add("Yes");
                tempr16++;
        } else if (Integer.parseInt(w20) == 1) {
                list7.add("No");
                tempr17++;
        }
        if (Integer.parseInt(w21) == 1) {
                list7.add("Yes");
                tempr18++;
        } else if (Integer.parseInt(w22) == 1) {
                list7.add("No");
                tempr19++;
        }
        if (Integer.parseInt(w23) == 1) {
                list7.add("Yes");
                tempr20++;
        } else if (Integer.parseInt(w24) == 1) {
                list7.add("No");
                tempr21++;
        }
                g2.setText(list7.get(0));
                g4.setText(list7.get(1));
                //g18.setText(list7.get(17));

                if (tempr1 == 0 && tempr2 == 0) {
                    g6.setText("No Information.");
                } else {
                    g6.setText(list7.get(2));
                }
                if ((tempr3 == 0 && tempr4 == 0) && tempr5 == 0) {
                    g8.setText("No Information.");
                } else {
                    g8.setText(list7.get(3));
                    Log.d("vidhi", "g8.settext");
                }
                if ((tempr6 == 0 && tempr7 == 0) && tempr8 == 0) {
                    g10.setText("None");
                } else {
                    g10.setText(list7.get(4));
                }

        if (tempr9 == 0 && tempr10 == 0) {
                g12.setText("No Information.");
        } else {
                g12.setText(list7.get(5));
                Log.d("vidhi", "g12.settext");
        }
       if ((tempr11 == 0 && tempr12 == 0) && tempr13 == 0) {
                g14.setText("No Information.");
        } else {
                g14.setText(list7.get(6));
        }
        if (tempr14 == 0 && tempr15 == 0) {
                g16.setText("No Information");
        } else {
                g16.setText(list7.get(7));
                Log.d("vidhi", "g16.settext");
        }

        if (tempr16 == 0 && tempr17 == 0) {
                g20.setText("No Information.");
        } else {
                g20.setText(list7.get(8));
        }
        if (tempr18 == 0 && tempr19 == 0) {
                g22.setText("No Information.");
        } else {
                g22.setText(list7.get(9));
        }
        if (tempr20 == 0 && tempr21 == 0) {
                g24.setText("No Information");
        } else {
                g24.setText(list7.get(10));
                Log.d("vidhi", "g24.settext");
        }
                /*g6.setText(list7.get(2));
                g8.setText(list7.get(3));
                g10.setText(list7.get(4));*/ /*Toast.makeText(this, list7.get(0), Toast.LENGTH_SHORT).show();
            Toast.makeText(this, list7.get(1), Toast.LENGTH_SHORT).show();
            Toast.makeText(this, list7.get(2), Toast.LENGTH_SHORT).show();
            Toast.makeText(this, list7.get(3), Toast.LENGTH_SHORT).show();
            Toast.makeText(this, list7.get(4), Toast.LENGTH_SHORT).show();
            Toast.makeText(this, list7.get(5), Toast.LENGTH_SHORT).show();
            Toast.makeText(this, list7.get(6), Toast.LENGTH_SHORT).show();
            Toast.makeText(this, list7.get(7), Toast.LENGTH_SHORT).show();
            Toast.makeText(this, list7.get(8), Toast.LENGTH_SHORT).show();
            Toast.makeText(this, list7.get(9), Toast.LENGTH_SHORT).show();
            Toast.makeText(this, list7.get(10), Toast.LENGTH_SHORT).show();*/
           /* Log.e(TAG, list7.get(0));
            Log.e(TAG, list7.get(1));
            Log.e(TAG, list7.get(2));
            Log.e(TAG, list7.get(3));
            Log.e(TAG, list7.get(4));
            Log.e(TAG, list7.get(5));
            Log.e(TAG, list7.get(6));
            Log.e(TAG, list7.get(7));
            Log.e(TAG, list7.get(8));
            Log.e(TAG, list7.get(9));
            Log.e(TAG, list7.get(10));*/
            Cursor data7 = myDb.getallgh_data(s + 1);
            ArrayList<String> list7 = new ArrayList<String>();
            if (data7.getCount() > 0 && data7 != null) {
                data7.moveToFirst();
                w1 = data7.getString(1);
                w2 = data7.getString(2);
                w3 = data7.getString(3);
                w4 = data7.getString(4);
                w5 = data7.getString(5);
                w6 = data7.getString(6);
                w7 = data7.getString(7);
                w8 = data7.getString(8);
                w9 = data7.getString(9);
                w10 = data7.getString(10);
                w11 = data7.getString(11);
                w12 = data7.getString(12);
                w13 = data7.getString(13);
                w14 = data7.getString(14);
                w15 = data7.getString(15);
                w16 = data7.getString(16);
                w17 = data7.getString(17);
                w18 = data7.getString(18);
                w19 = data7.getString(19);
                w20 = data7.getString(20);
                w21 = data7.getString(21);
                w22 = data7.getString(22);
                w23 = data7.getString(23);
                w24 = data7.getString(24);
                Log.d(TAG, w11);
                list7.add(w1);
                list7.add(w2);
            }
            int tempr1 = 0, tempr2 = 0, tempr3 = 0, tempr4 = 0, tempr5 = 0, tempr6 = 0, tempr7 = 0, tempr8 = 0, tempr9 = 0, tempr10 = 0, tempr11 = 0, tempr12 = 0, tempr13 = 0, tempr14 = 0, tempr15 = 0, tempr16 = 0, tempr17 = 0, tempr18 = 0, tempr19 = 0, tempr20 = 0, tempr21 = 0, tempr22 = 0, tempr23 = 0, tempr24 = 0,
                    tempr25 = 0, tempr26 = 0, tempr27 = 0;
            if (Integer.parseInt(w3) == 1) {
                list7.add("Regular");
                tempr1++;
            } else if (Integer.parseInt(w4) == 1) {
                list7.add("Irregular");
                tempr2++;
            }
            if (Integer.parseInt(w5) == 1) {
                list7.add("2-3 days");
                tempr3++;
            } else if (Integer.parseInt(w6) == 1) {
                list7.add("3-5 days");
                tempr4++;
            } else if (Integer.parseInt(w7) == 1) {
                list7.add("5-7 days");
                tempr5++;
            }
            if (Integer.parseInt(w8) == 1) {
                list7.add("Lower Abdomen");
                tempr6++;
            } else if (Integer.parseInt(w9) == 1) {
                list7.add("Upper Abdomen");
                tempr7++;
            } else if (Integer.parseInt(w10) == 1) {
                list7.add("None");
                tempr8++;
            }
            if (Integer.parseInt(w11) == 1) {
                list7.add("White");
                tempr9++;
            } else if (Integer.parseInt(w12) == 1) {
                list7.add("Yellowish");
                tempr10++;
            }
            if (Integer.parseInt(w13) == 1) {
                list7.add("Thick");
                tempr11++;
            } else if (Integer.parseInt(w14) == 1) {
                list7.add("Thin");
                tempr12++;
            } else if (Integer.parseInt(w15) == 1) {
                list7.add("Normal");
                tempr13++;
            }
            if (Integer.parseInt(w16) == 1) {
                list7.add("Excess");
                tempr14++;
            } else if (Integer.parseInt(w17) == 1) {
                list7.add("Less");
                tempr15++;
            }
            if (w18 != null) {//duration
                list7.add(w18);
            } else {
                list7.add("No Information.");
            }

            if (Integer.parseInt(w19) == 1) {
                list7.add("Yes");
                tempr16++;
            } else if (Integer.parseInt(w20) == 1) {
                list7.add("No");
                tempr17++;
            }
            if (Integer.parseInt(w21) == 1) {
                list7.add("Yes");
                tempr18++;
            } else if (Integer.parseInt(w22) == 1) {
                list7.add("No");
                tempr19++;
            }
            if (Integer.parseInt(w23) == 1) {
                list7.add("Yes");
                tempr20++;
            } else if (Integer.parseInt(w24) == 1) {
                list7.add("No");
                tempr21++;
            }
            g2.setText(list7.get(0));
            g4.setText(list7.get(1));
            if (tempr1 == 0 && tempr2 == 0) {
                g6.setText("No Information.");
            } else {
                g6.setText(list7.get(2));
            }
            if ((tempr3 == 0 && tempr4 == 0) && tempr5 == 0) {
                g8.setText("No Information.");
            } else {
                g8.setText(list7.get(3));
            }
            if ((tempr6 == 0 && tempr7 == 0) && tempr8 == 0) {
                g10.setText("None.");
            } else {
                g10.setText(list7.get(4));
            }
            if (tempr9 == 0 && tempr10 == 0) {
                g12.setText("No Information.");
            } else {
                g12.setText(list7.get(5));
            }
            if ((tempr11 == 0 && tempr12 == 0) && tempr13 == 0) {
                g14.setText("No Information.");
            } else {
                g14.setText(list7.get(6));
            }
            if (tempr14 == 0 && tempr15 == 0) {
                g16.setText("No Information.");
            } else {
                g16.setText(list7.get(7));
            }
            g18.setText(list7.get(8));
            if (tempr16 == 0 && tempr17 == 0) {
                g20.setText("No Information.");
            } else {
                g20.setText(list7.get(9));
            }
            if (tempr18 == 0 && tempr19 == 0) {
                g22.setText("No Information.");
            } else {
                g22.setText(list7.get(10));
            }
            if (tempr20 == 0 && tempr21 == 0) {
                g24.setText("No Information.");
            } else {
                g24.setText(list7.get(11));
            }


            Cursor data8 = myDb.getalldh_data(s + 1);
            ArrayList<String> list8 = new ArrayList<String>();
            if (data8.getCount() > 0 && data8 != null) {
                data8.moveToFirst();
                x1 = data8.getString(1);
                x2 = data8.getString(2);
                list8.add(x1);
            }//Log.d(TAG, x1);
            h2.setText(x1);
            h4.setText(x2);

            Cursor data9 = myDb.getallpsh_data(s + 1);
            ArrayList<String> list9 = new ArrayList<String>();
            if (data9.getCount() > 0 && data9 != null) {
                data9.moveToFirst();
                y1 = data9.getString(1);
                y2 = data9.getString(2);
                y3 = data9.getString(3);
                y4 = data9.getString(4);
                y5 = data9.getString(5);
                y6 = data9.getString(6);
                y7 = data9.getString(7);
                y8 = data9.getString(8);
                y9 = data9.getString(9);
                y10 = data9.getString(10);
                y11 = data9.getString(11);
                y12 = data9.getString(12);
                y13 = data9.getString(13);
                y14 = data9.getString(14);
            }
            Log.d(TAG, y1);
            int km = 0, km1 = 0, km2 = 0, km3 = 0;
            if (Integer.parseInt(y1) == 1) {
                list9.add("Normal.");
                km++;
            } else if (Integer.parseInt(y2) == 1) {
                list9.add("Less.");
                km++;
            } else if (Integer.parseInt(y3) == 1) {
                list9.add("More.");
                km++;
            }
            if (Integer.parseInt(y4) == 1) {
                list9.add("Normal.");
                km1++;
            } else if (Integer.parseInt(y5) == 1) {
                list9.add("Less.");
                km1++;
            } else if (Integer.parseInt(y6) == 1) {
                list9.add("More.");
                km1++;
            }
            if (Integer.parseInt(y7) == 1) {
                list9.add("Normal.");
                km2++;
            } else if (Integer.parseInt(y8) == 1) {
                list9.add("Burning.");
                km2++;
            } else if (Integer.parseInt(y9) == 1) {
                list9.add("Less.");
                km2++;
            } else if (Integer.parseInt(y10) == 1) {
                list9.add("More.");
                km2++;
            } else if (Integer.parseInt(y11) == 1) {
                list9.add("Dysuria.");
                km2++;
            }
            if (Integer.parseInt(y12) == 1) {
                list9.add("Normal.");
                km3++;
            } else if (Integer.parseInt(y13) == 1) {
                list9.add("Constipation.");
                km3++;
            } else if (Integer.parseInt(y14) == 1) {
                list9.add("Diarrhea.");
                km3++;
            }

            if (km != 0) {
                i2.setText(list9.get(0));
            } else {
                i2.setText("No information");
            }
            if (km1 != 0) {
                i4.setText(list9.get(1));
            } else {
                i4.setText("No information");
            }
            if (km2 != 0) {
                i6.setText(list9.get(2));
            } else {
                i6.setText("No information");
            }
            if (km3 != 0) {
                i8.setText(list9.get(3));
            } else {
                i8.setText("No information");
            }

            Cursor data10 = myDb.getallih_data(s + 1);
            ArrayList<String> list10 = new ArrayList<String>();
            if (data10.getCount() > 0 && data10 != null) {
                data10.moveToFirst();
                z1 = data10.getString(1);
                z2 = data10.getString(2);
            }
//            int tmp = 0;
//            if (Integer.parseInt(z1) == 1) {
//                list10.add("Yes.");
//                tmp++;
//            } else {
//                list10.add("No.");
//            }
//

//            if (tmp != 0) {
//                j1.setText(list10.get(0));
//            } else {
//                j1.setText("No Investigation.");
//            }


        /*int tmp = 0;
        if (Integer.parseInt(z1) == 1) {
            list10.add("Yes.");
            tmp++;
        } else {
            list10.add("No.");
            tmp++;
        }
        if (tmp != 0) {
            j1.setText(list10.get(0));
        } else {
            j1.setText("No.");
        }*/

            /***********************************************************************************************/
       /*StringBuffer buffer = new StringBuffer(y1 + " ");
        buffer.append(y2 + " ");//less sleep
        buffer.append(y3 + " ");//more sleep
        buffer.append(r1 + " ");//lower abdomen pain
        buffer.append(r2 + " ");//upper abdomen pain
        buffer.append(r3 + " ");//none( for abdomen pain)
        Log.d(TAG,buffer.toString());


        height=p5,weight=p6
        BP=b10
        infertility=infer
        fever persistent=b6
        period irregular = irr
        cough = b8
        micturation = i6
        pain in urine= pain_urine
        blood in urine= blood_urine

        */

            btn_sms = (Button) findViewById(R.id.button_sms);
            btn_sms.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    sendsms();

                }
            });
            btn_upload = findViewById(R.id.button_uploadserver);
            btn_upload.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    upload();
                }
            });

        }
    }

    public void sendsms() {
        String phoneNumber = a20.getText().toString();
        String message = test_pres.getText().toString();
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.SEND_SMS}, PERMISSION_SEND_SMS);
        } else {
//            SmsManager smsManager = SmsManager.getDefault();
//            smsManager.sendTextMessage(phoneNumber, null, message , null, null);
//            test_pres.setText("");
//            Toast.makeText(this, "MESSAGE HAS BEEN SENT TO THE PATIENT", Toast.LENGTH_SHORT).show();
            SmsManager sm = SmsManager.getDefault();
            ArrayList<String> parts =sm.divideMessage(message);
            int numParts = parts.size();

            ArrayList<PendingIntent> sentIntents = new ArrayList<PendingIntent>();
            ArrayList<PendingIntent> deliveryIntents = new ArrayList<PendingIntent>();

            for (int i = 0; i < numParts; i++) {
                Intent msentIntent = new Intent();
                Intent mDeliveryIntent = new Intent();
                sentIntents.add(PendingIntent.getBroadcast(this,0,msentIntent,0));
                deliveryIntents.add(PendingIntent.getBroadcast(this, 0, mDeliveryIntent, 0));
            }

            sm.sendMultipartTextMessage(phoneNumber,null, parts, sentIntents, deliveryIntents);
            test_pres.setText("");
            Toast.makeText(this, "MESSAGE HAS BEEN SENT TO THE PATIENT", Toast.LENGTH_SHORT).show();

        }

    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        String phoneNumber = a20.getText().toString();
        String message = test_pres.getText().toString();

        switch (requestCode) {
            case PERMISSION_SEND_SMS:
                if (grantResults != null && grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    //do send or read sms
                    SmsManager smsManager =     SmsManager.getDefault();
                    smsManager.sendTextMessage(phoneNumber, null, message, null, null);
                }
                break;
        }
    }


    public void upload()  {
        //  String test;
        float bmi;
        float height=Float.parseFloat(p5);
        float weight=Float.parseFloat(p6);
        bmi=(weight/(height*height));
        bmi=bmi*10000;
        Log.e(TAG,"bmi="+bmi);
        Log.e(TAG,"wt="+weight);
        Log.e(TAG,"ht="+height);
        String bp = b10.getText().toString();
        String infertility= g20.getText().toString();
        String fever=b6.getText().toString();
        String period= g6.getText().toString();
        String cough=b8.getText().toString();
        String micturation=i6.getText().toString();
        String pain_urine= g22.getText().toString();
        String blood_in_urine= g24.getText().toString();
        StringBuffer test = new StringBuffer();

        int flag=0;
        if(flag==0)
        {
            if ((bmi<18.5 || bmi>24.9) && bp == "High")
            { test.append("TSH test \n " +" T3,T4 Test \n " +" LIPID TEST\n");
                flag=1;}
            else if ((bmi<18.5 || bmi>24.9 )&& bp == "Low")
            { test.append("TSH test \n " +" T3,T4 Test \n " +" LIPID TEST\n");
                flag=1;}

            if (infertility == "Yes")
            { test.append("USG Test \n " +"  PAPSMEAR TEST \n " +"  MANTAX Test \n " +"  FBS Test \n " +" URINE-INFECTION Test \n");
                flag=1;}

            if (cough == "Yes" && fever == "More than 1 week")
            {test.append("X-Ray\n");flag=1;}
            else if (cough == "Yes" && fever == "Less than 1 week")
            {test.append("Take D-cold Cough Syrup and take rest.If fever continues for more than 1 week , then consult to me again.\n");flag=1;}
            else if (fever == "Less than 1 week")
            {test.append("Take Paracetamol(1 tablet per day) and consult to me after 1 week\n");flag=1;}
            else if (fever == "More than 1 week")
            {test.append("CBC and ESR Test \n " +"  NS-1 Antigen Test \n  "+"Malaria/Dengue Test \n"+" Chikungunya Test\n");flag=1;}


            if (micturation == "Burning." || micturation == "More." || micturation ==  "Dysuria.")
            { test.append("Urine Test\n");flag=1;}

            if (pain_urine == "Yes" && blood_in_urine == "Yes")
            { test.append("ERCP Test \n " +"  Bladder MRI Test \n");flag=1;}
            else if (pain_urine == "Yes" && blood_in_urine == "No")
            { test.append("ERCP Test \n ");flag=1;}
            else if (pain_urine == "No" && blood_in_urine == "Yes")
            { test.append( " Bladder MRI Test \n");flag=1;}

            if (fever == "More than 1 week" && period == "Irregular")
            { test.append("Mantaux Test\n");flag=1;}
            else if( period == "Irregular")
            {
                test.append("Mantaux Test\n");flag=1;
            }
            else if(fever == "Less than 1 week" && period == "Irregular")
            {
                test.append("Mantaux Test\n");flag=1;
            }

        }
        if(flag==0)
        {
            test.append("No Test\n");}
        // test="No Test\n";
        StringBuffer buffer = new StringBuffer();
//        buffer.append(bp.toString() + " ");
//        buffer.append(infertility + " ");
//        buffer.append(fever + " ");
//        buffer.append(period + " ");
//        buffer.append(cough + " ");
//        buffer.append(micturation + " ");
//        buffer.append(pain_urine + " ");
//        buffer.append(blood_in_urine + " ");//call kr
        //buffer me hi pas krva de filhal
        buffer.append("hi ");
        Client myClient = new Client("192.168.1.15", 6781, buffer.toString());
        myClient.execute();
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        test_pres.setText(test);


//cmd khol
    }
}



