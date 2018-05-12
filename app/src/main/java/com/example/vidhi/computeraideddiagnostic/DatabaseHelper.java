package com.example.vidhi.computeraideddiagnostic;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.vidhi.computeraideddiagnostic.Models.History_past;
import com.example.vidhi.computeraideddiagnostic.Models.PatientBioData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nimesh on 17/9/17.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    //private static final String TAG="nimesh";

    private static final String DB_NAME="todo.db";
    private static final int DB_VERSION=1;

    private static final String TABLE_NAME1= "form1";
    private static final String TABLE_NAME2= "form2";
    private static final String TABLE_NAME3= "form3";
     private static final String TABLE_NAME4= "form4";
    private static final String TABLE_NAME5= "form5";
    private static final String TABLE_NAME6= "form6";
    private static final String TABLE_NAME7= "form7";
    private static final String TABLE_NAME8= "form8";
    private static final String TABLE_NAME9= "form9";
    private static final String TABLE_NAME10= "form10";

    private static final String NAME = "name";
    private static final String OCCUP = "occupation";
    private static final String AGE= "age";
    private static final String GENDER= "gender";
    private static final String HEIGHT= "height";
    private static final String WEIGHT= "weight";
    private static final String DOB= "birth";
    private static final String MARITAL= "maritalstatus";
    private static final String ADDRESS1= "add1";
    private static final String CONTACT= "contact";
    private static final String EMAIL= "emailid";
    private static final String BLOOD= "blood";


    private static final String HEAD = "head";
    private static final String LEG = "leg";
    private static final String EYE= "eye";
    private static final String CHEST= "chest";
    private static final String OTHERS= "others";
    private static final String OTHERSEDIT = "othersedit";
    private static final String MEDICALHISTORY = "medical_history";

    private static final String DIA_F = "dia_father";
    private static final String DIA_M = "dia_mother";
    private static final String DIA_S= "dia_sibling";
    private static final String THY_F= "thy_father";
    private static final String THY_M= "thy_mother";
    private static final String THY_S = "thy_sibling";
    private static final String HYP_F = "hyp_father";
    private static final String HYP_M= "hyp_mother";
    private static final String HYP_S= "hyp_sibling";
    private static final String OTHERS_F= "other_father";
    private static final String OTHERS_M= "other_mother";
    private static final String OTHERS_S= "other_sibling";
    private static final String OTHERS_F_DISEASE= "father_other_disease";
    private static final String OTHERS_M_DISEASE= "mother_other_disease";
    private static final String OTHERS_S_DISEASE= "sibling_other_disease";

    private static final String ALLERGY="allergies";

    private static final String PAST_MED="past_medicine";
    private static final String CURR_MED="current_medicine";

    private static final String n_s1="normal_s";
    private static final String l_s1="less_s";
    private static final String m_s1="more_s";
    private static final String n_a1="normal_a";
    private static final String l_a1="less_a";
    private static final String m_a1="more_a";
    private static final String n_m1="normal_m";
    private static final String b_m1="burning_m";
    private static final String l_m1="less_m";
    private static final String m_m1="more_m";
    private static final String d_m1="dis_m";
    private static final String n_b1="normal_b";
    private static final String c_b1="cont_b";
    private static final String d_b1="dia_b";

    private static final String YES="yes";
    private static final String NO="no";

    private static final String DIABETES="diabetes";
    private static final String THYROID="thyroid";
    private static final String HYPERTENSION="hypertension";

    private static final String LOWER_ABDOMEN = "lower_abdomen_pain";
    private static final String UPPER_ABDOMEN = "upper_abdomen_pain";
    private static final String NONE_PAIN= "none_pain";
    private static final String YES_FEVER= "yes_fever";
    private static final String NO_FEVER= "no_fever";
    private static final String YES_COLD = "yes_cold";
    private static final String NO_COLD = "no_cold";
    private static final String HIGH_BP = "high_bp";
    private static final String LOW_BP = "low_bp";
    private static final String NORMAL_BP = "normal_bp";

    private static final String YES_FEVER_MORE= "yes_fever_more1week";
    private static final String YES_FEVER_LESS= "yes_fever_less1week";

    private static final String AGE_MENARCHE = "age_menarche";
    private static final String LAST_MENS = "last_mens";
    private static final String REGULAR= "regular";
    private static final String IRREGULAR= "irregular";
    private static final String DAY1= "day1";
    private static final String DAY2 = "day2";
    private static final String DAY3 = "day3";
    private static final String PAIN1 = "lower_abdomen";
    private static final String PAIN2 = "upper_abdomen";
    private static final String PAIN3 = "none";
    private static final String DISCHARGE_COLORWHITE = "discharge_colorwhite";
    private static final String DISCHARGE_COLORYELLOW = "discharge_coloryellow";
    private static final String CONSISTENCY_THICK = "consistency_thick";
    private static final String CONSISTENCY_THIN = "consistency_thin";
    private static final String CONSISTENCY_NORMAL = "consistency_normal";
    private static final String AMOUNT_EXCESS = "amount_excess";
    private static final String AMOUNT_LESS = "amount_less";
    private static final String DURATION = "duration";
    private static final String INFER_YES = "infer_yes";
    private static final String INFER_NO = "infer_no";
    private static final String PAIN_YES = "pain_yes";
    private static final String PAIN_NO = "pain_no";
    private static final String BLOOD_YES = "blood_yes";
    private static final String BLOOD_NO = "blood_no";



    SQLiteDatabase db;

    public DatabaseHelper(Context context){
        super(context,DB_NAME,null,DB_VERSION);
    }



    @Override
    public void onCreate(SQLiteDatabase db) {


        String CREATE_TABLE1 ="CREATE TABLE " + TABLE_NAME1 + "(s_id INTEGER PRIMARY KEY AUTOINCREMENT , name text , occupation text , age text , gender text , height text , weight text , birth text , maritalstatus text , add1 text , contact text , emailid text , blood text)";
        String CREATE_TABLE2="CREATE TABLE " + TABLE_NAME2 + "(s_id INTEGER PRIMARY KEY AUTOINCREMENT , lower_abdomen_pain text, upper_abdomen_pain text, none_pain text, yes_fever text, no_fever text, yes_cold text, no_cold text, high_bp text, low_bp text, normal_bp text, yes_fever_more1week text, yes_fever_less1week text)";
        String CREATE_TABLE3="CREATE TABLE " + TABLE_NAME3 + "(s_id INTEGER PRIMARY KEY AUTOINCREMENT , diabetes text, thyroid text, hypertension text)";
        String CREATE_TABLE4="CREATE TABLE " + TABLE_NAME4 + "(s_id INTEGER PRIMARY KEY AUTOINCREMENT , head text , leg text , eye text , chest text , others text , othersedit text , medical_history text)";
        String CREATE_TABLE5="CREATE TABLE " + TABLE_NAME5 + "(s_id INTEGER PRIMARY KEY AUTOINCREMENT , dia_father text , dia_mother text , dia_sibling text , thy_father text , thy_mother text , thy_sibling text , hyp_father text , hyp_mother text , hyp_sibling text , other_father text , other_mother text , other_sibling text , father_other_disease text , mother_other_disease text , sibling_other_disease text)";
        String CREATE_TABLE6="CREATE TABLE " + TABLE_NAME6 + "(s_id INTEGER PRIMARY KEY AUTOINCREMENT , allergies text)";
        String CREATE_TABLE7="CREATE TABLE " + TABLE_NAME7 + "(s_id INTEGER PRIMARY KEY AUTOINCREMENT , age_menarche text , last_mens text , regular text , irregular text , day1 text , day2 text , day3 text , lower_abdomen text , upper_abdomen text , none text , discharge_colorwhite text , discharge_coloryellow text , consistency_thick text , consistency_thin text , consistency_normal text , amount_excess text , amount_less text , duration text , infer_yes text , infer_no text , pain_yes text , pain_no text , blood_yes text , blood_no text)";
        String CREATE_TABLE8="CREATE TABLE " + TABLE_NAME8 + "(s_id INTEGER PRIMARY KEY AUTOINCREMENT , past_medicine text, current_medicine text)";
        String CREATE_TABLE9="CREATE TABLE " + TABLE_NAME9 + "(s_id INTEGER PRIMARY KEY AUTOINCREMENT , normal_s text , less_s text , more_s text , normal_a text , less_a text , more_a text , normal_m text , burning_m text , less_m text , more_m text , dis_m text , normal_b text , cont_b text , dia_b text )";
        String CREATE_TABLE10="CREATE TABLE " + TABLE_NAME10 + "(s_id INTEGER PRIMARY KEY AUTOINCREMENT , yes text, no text)";

        db.execSQL(CREATE_TABLE1);
        db.execSQL(CREATE_TABLE2);
        db.execSQL(CREATE_TABLE3);
        db.execSQL(CREATE_TABLE4);
        db.execSQL(CREATE_TABLE5);
        db.execSQL(CREATE_TABLE6);
        db.execSQL(CREATE_TABLE7);
        db.execSQL(CREATE_TABLE8);
        db.execSQL(CREATE_TABLE9);
        db.execSQL(CREATE_TABLE10);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME1);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME2);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME3);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME4);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME5);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME6);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME7);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME8);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME9);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME10);
        onCreate(db);
    }


   public boolean insertData(String name,String occup,String age,String gender,String height, String weight,String dob, String marital,String add1,String contact,String email,String blood)
    {

        SQLiteDatabase db =this.getWritableDatabase();

        ContentValues contentValues=new ContentValues();
        contentValues.put(NAME,name);
        contentValues.put(OCCUP,occup);
        contentValues.put(AGE,age);
        contentValues.put(GENDER,gender);
        contentValues.put(HEIGHT,height);
        contentValues.put(WEIGHT,weight);
        contentValues.put(DOB,dob);
        contentValues.put(MARITAL,marital);
        contentValues.put(ADDRESS1,add1);
        contentValues.put(CONTACT,contact);
        contentValues.put(EMAIL,email);
        contentValues.put(BLOOD,blood);

        long result=db.insert(TABLE_NAME1,null,contentValues);
        db.close();
        if(result==-1)
        {
            return false;
        }
        else
        {
            return true;
        }
    }

public boolean insert1(int head1, int leg1, int eye1, int chest1, int others_surgical1, String others_edit, String medical_history)
{
    SQLiteDatabase db =this.getWritableDatabase();

    ContentValues contentValues=new ContentValues();
    contentValues.put(HEAD,head1);
    contentValues.put(LEG,leg1);
    contentValues.put(EYE,eye1);
    contentValues.put(CHEST,chest1);
    contentValues.put(OTHERS,others_surgical1);
    contentValues.put(OTHERSEDIT,others_edit);
    contentValues.put(MEDICALHISTORY,medical_history);
    long result=db.insert(TABLE_NAME4,null,contentValues);
    db.close();
    if(result==-1)
    {
        return false;
    }
    else
    {
        return true;
    }
}

    public boolean insert2(int dia_f1, int dia_m1, int dia_s1, int thy_f1, int thy_m1, int thy_s1, int hyp_f1, int hyp_m1, int hyp_s1, int others_f1, int others_m1, int others_s1, String s, String toString, String string)
    {
        SQLiteDatabase db =this.getWritableDatabase();

        ContentValues contentValues=new ContentValues();
        contentValues.put(DIA_F,dia_f1);
        contentValues.put(DIA_M,dia_m1);
        contentValues.put(DIA_S,dia_s1);
        contentValues.put(THY_F,thy_f1);
        contentValues.put(THY_M,thy_m1);
        contentValues.put(THY_S,thy_s1);
        contentValues.put(HYP_F,hyp_f1);
        contentValues.put(HYP_M,hyp_m1);
        contentValues.put(HYP_S,hyp_s1);
       contentValues.put(OTHERS_F,others_f1);
        contentValues.put(OTHERS_M,others_m1);
        contentValues.put(OTHERS_S,others_s1);
        contentValues.put(OTHERS_F_DISEASE,s);
        contentValues.put(OTHERS_M_DISEASE,toString);
        contentValues.put(OTHERS_S_DISEASE,string);
        long result=db.insert(TABLE_NAME5,null,contentValues);
        db.close();
        if(result==-1)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    public boolean insert3(String all)
    {
        SQLiteDatabase db =this.getWritableDatabase();

        ContentValues contentValues=new ContentValues();
        contentValues.put(ALLERGY,all);
        long result=db.insert(TABLE_NAME6,null,contentValues);
        db.close();
        if(result==-1)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    public boolean insert4(String s, String s1) {
        SQLiteDatabase db =this.getWritableDatabase();

        ContentValues contentValues=new ContentValues();
        contentValues.put(PAST_MED,s);
        contentValues.put(CURR_MED,s1);
        long result=db.insert(TABLE_NAME8,null,contentValues);
        db.close();
        if(result==-1)
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    public boolean insert5(int n_s, int l_s, int m_s, int n_a, int l_a, int m_a, int n_m, int b_m, int l_m, int m_m, int d_m, int n_b, int c_b, int d_b) {
        SQLiteDatabase db =this.getWritableDatabase();

        ContentValues contentValues=new ContentValues();
        contentValues.put(n_s1,n_s);
        contentValues.put(l_s1,l_s);
        contentValues.put(m_s1,m_s);
        contentValues.put(n_a1,n_a);
        contentValues.put(l_a1,l_a);
        contentValues.put(m_a1,m_a);
        contentValues.put(n_m1,n_m);
        contentValues.put(b_m1,b_m);
        contentValues.put(l_m1,l_m);
        contentValues.put(m_m1,m_m);
        contentValues.put(d_m1,d_m);
        contentValues.put(n_b1,n_b);
        contentValues.put(c_b1,c_b);
        contentValues.put(d_b1,d_b);
        long result=db.insert(TABLE_NAME9,null,contentValues);
        db.close();
        if(result==-1)
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    public boolean insert6(int yes1, int no1) {
        SQLiteDatabase db =this.getWritableDatabase();

        ContentValues contentValues=new ContentValues();
        contentValues.put(YES,yes1);
        contentValues.put(NO,no1);
        long result=db.insert(TABLE_NAME10,null,contentValues);
        db.close();
        if(result==-1)
        {
            return false;
        }
        else
        {
            return true;
        }

    }

    public boolean insert7(int dia1, int thy1, int hyp1) {
        SQLiteDatabase db =this.getWritableDatabase();

        ContentValues contentValues=new ContentValues();
        contentValues.put(DIABETES,dia1);
        contentValues.put(THYROID,thy1);
        contentValues.put(HYPERTENSION,hyp1);
        long result=db.insert(TABLE_NAME3,null,contentValues);
        db.close();
        if(result==-1)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    public boolean insert8(int low_pain1, int upp_pain1, int none_pain1, int yes_fever1, int no_fever1, int yes_cold1, int no_cold1, int high_bp1, int low_bp1, int normal_bp1, int fever_duration_less11, int fever_duration_more11) {

        Log.e("TAG", "in db" );
        SQLiteDatabase db =this.getWritableDatabase();

        ContentValues contentValues=new ContentValues();
        contentValues.put(LOWER_ABDOMEN,low_pain1);
        contentValues.put(UPPER_ABDOMEN,upp_pain1);
        contentValues.put(NONE_PAIN,none_pain1);
        contentValues.put(YES_FEVER,yes_fever1);
        contentValues.put(NO_FEVER,no_fever1);
        contentValues.put(YES_COLD,yes_cold1);
        contentValues.put(NO_COLD,no_cold1);
        contentValues.put(HIGH_BP,high_bp1);
        contentValues.put(LOW_BP,low_bp1);
        contentValues.put(NORMAL_BP,normal_bp1);
        contentValues.put(YES_FEVER_LESS,fever_duration_less11);
        contentValues.put(YES_FEVER_MORE,fever_duration_more11);
        long result=db.insert(TABLE_NAME2,null,contentValues);
        Log.e("TAG", "before close" );
        db.close();
        if(result==-1)
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    public boolean insert9(String s, String s1, int regxx, int irregxx, int flo1xx, int flo2xx, int flo3xx, int pain1xx, int pain2xx, int pain3xx, int dis_whitexx, int dis_yellowxx, int cons_thickxx, int cons_thinxx, int cons_normalxx, int amount_excessxx, int amount_lessxx, String d,int infer_yesxx, int infer_noxx, int pain_yesxx, int pain_noxx, int blood_yesxx, int blood_noxx) {
        SQLiteDatabase db =this.getWritableDatabase();

        ContentValues contentValues=new ContentValues();
        contentValues.put(AGE_MENARCHE,s);
        contentValues.put(LAST_MENS,s1);
        contentValues.put(REGULAR,regxx);
        contentValues.put(IRREGULAR,irregxx);
        contentValues.put(DAY1,flo1xx);
        contentValues.put(DAY2,flo2xx);
        contentValues.put(DAY3,flo3xx);
        contentValues.put(PAIN1,pain1xx);
        contentValues.put(PAIN2,pain2xx);
        contentValues.put(PAIN3,pain3xx);
        contentValues.put(DISCHARGE_COLORWHITE,dis_whitexx);
        contentValues.put(DISCHARGE_COLORYELLOW,dis_yellowxx);
        contentValues.put(CONSISTENCY_THICK,cons_thickxx);
        contentValues.put(CONSISTENCY_THIN,cons_thinxx);
        contentValues.put(CONSISTENCY_NORMAL,cons_normalxx);
        contentValues.put(AMOUNT_EXCESS,amount_excessxx);
        contentValues.put(AMOUNT_LESS,amount_lessxx);
        contentValues.put(DURATION,d);
        contentValues.put(INFER_YES,infer_yesxx);
        contentValues.put(INFER_NO,infer_noxx);
        contentValues.put(PAIN_YES,pain_yesxx);
        contentValues.put(PAIN_NO,pain_noxx);
        contentValues.put(BLOOD_YES,blood_yesxx);
        contentValues.put(BLOOD_NO,blood_noxx);

        long result=db.insert(TABLE_NAME7,null,contentValues);
        Log.e("TAG", "before close" );
        db.close();
        if(result==-1)
        {
            return false;
        }
        else
        {
            return true;
        }
    }



    public Cursor getalldata()
    {
        String query1 = "SELECT * FROM " + TABLE_NAME1;
        SQLiteDatabase db = getReadableDatabase();
        Cursor res = db.rawQuery(query1, null );
        return res;
    }


    public Cursor getalldata_chief()
    {
        String query2 = "SELECT * FROM " + TABLE_NAME2;
        SQLiteDatabase db = getReadableDatabase();
        Cursor res = db.rawQuery(query2, null );
        return res;
    }

    public Cursor getalldata_present()
    {
        String query3 = "SELECT * FROM " + TABLE_NAME3;
        SQLiteDatabase db = getReadableDatabase();
        Cursor res = db.rawQuery(query3, null );
        return res;
    }

    public Cursor getalldata_past()
    {
        String query4 = "SELECT * FROM " + TABLE_NAME4;
        SQLiteDatabase db = getReadableDatabase();
        Cursor res = db.rawQuery(query4, null );
        return res;
    }

    public Cursor getalldata_family()
    {
        String query5 = "SELECT * FROM " + TABLE_NAME5;
        SQLiteDatabase db = getReadableDatabase();
        Cursor res = db.rawQuery(query5,null );
        return res;
    }

    public Cursor getalldata_allergy()
    {
        String query6 = "SELECT * FROM " + TABLE_NAME6;
        SQLiteDatabase db = getReadableDatabase();
        Cursor res = db.rawQuery(query6,null );
        return res;
    }

    public Cursor getalldata_gynae()
    {
        String query7 = "SELECT * FROM " + TABLE_NAME7;
        SQLiteDatabase db = getReadableDatabase();
        Cursor res = db.rawQuery(query7,null );
        return res;
    }

    public Cursor getalldata_drug()
    {
        String query8 = "SELECT * FROM " + TABLE_NAME8;
        SQLiteDatabase db = getReadableDatabase();
        Cursor res = db.rawQuery(query8,null );
        return res;
    }

    public Cursor getalldata_personal_social()
    {
        String query9 = "SELECT * FROM " + TABLE_NAME9;
        SQLiteDatabase db = getReadableDatabase();
        Cursor res = db.rawQuery(query9,null );
        return res;
    }

    public Cursor getalldata_personal_investigation()
    {
        String query10 = "SELECT * FROM " + TABLE_NAME10;
        SQLiteDatabase db = getReadableDatabase();
        Cursor res = db.rawQuery(query10,null );
        return res;
    }

    public Cursor getName()
    {
        String names =" SELECT " + NAME + " FROM " + TABLE_NAME1;
        SQLiteDatabase db = getWritableDatabase();
        Cursor data =db.rawQuery(names,null);
        return data;
    }

    public Cursor getallp_data(int id)
    {
        String query1 = "SELECT * FROM " + TABLE_NAME1 + " WHERE s_id = " + id;
        SQLiteDatabase db = getReadableDatabase();
        Cursor res = db.rawQuery(query1, null );
        return res;
    }

    public Cursor getallcc_data(int id)
    {
        String query1 = "SELECT * FROM " + TABLE_NAME2 + " WHERE s_id = " + id;
        SQLiteDatabase db = getReadableDatabase();
        Cursor res = db.rawQuery(query1, null );
        return res;
    }

    public Cursor getallhpril_data(int id)
    {
        String query1 = "SELECT * FROM " + TABLE_NAME3 + " WHERE s_id = " + id;
        SQLiteDatabase db = getReadableDatabase();
        Cursor res = db.rawQuery(query1, null );
        return res;
    }

    public Cursor getallhpail_data(int id)
    {
        String query1 = "SELECT * FROM " + TABLE_NAME4 + " WHERE s_id = " + id;
        SQLiteDatabase db = getReadableDatabase();
        Cursor res = db.rawQuery(query1, null );
        return res;
    }

    public Cursor getallfh_data(int id)
    {
        String query1 = "SELECT * FROM " + TABLE_NAME5 + " WHERE s_id = " + id;
        SQLiteDatabase db = getReadableDatabase();
        Cursor res = db.rawQuery(query1, null );
        return res;
    }

    public Cursor getallah_data(int id)
    {
        String query1 = "SELECT * FROM " + TABLE_NAME6 + " WHERE s_id = " + id;
        SQLiteDatabase db = getReadableDatabase();
        Cursor res = db.rawQuery(query1, null );
        return res;
    }

    public Cursor getallgh_data(int id)
    {
        String query1 = "SELECT * FROM " + TABLE_NAME7 + " WHERE s_id = " + id;
        SQLiteDatabase db = getReadableDatabase();
        Cursor res = db.rawQuery(query1, null );
        return res;
    }

    public Cursor getalldh_data(int id)
    {
        String query1 = "SELECT * FROM " + TABLE_NAME8 + " WHERE s_id = " + id;
        SQLiteDatabase db = getReadableDatabase();
        Cursor res = db.rawQuery(query1, null );
        return res;
    }

    public Cursor getallpsh_data(int id)
    {
        String query1 = "SELECT * FROM " + TABLE_NAME9 + " WHERE s_id = " + id;
        SQLiteDatabase db = getReadableDatabase();
        Cursor res = db.rawQuery(query1, null );
        return res;
    }

    public Cursor getallih_data(int id)
    {
        String query1 = "SELECT * FROM " + TABLE_NAME10 + " WHERE s_id = " + id;
        SQLiteDatabase db = getReadableDatabase();
        Cursor res = db.rawQuery(query1, null );
        return res;
    }

    /*public List<String> getData(){
        String[] columns = new String[] { NAME };
        Cursor data =
    }*/


   /* public ArrayList<String> getname(){
        ArrayList<String> names = new ArrayList<>();
        String columns[] = new String[] {NAME};
        Cursor c =db.query(TABLE_NAME1,columns,null,null,null,null,null);
        String result;
        int iName = c.getColumnIndex(NAME);
        for(c.moveToFirst();!c.isAfterLast();c.moveToNext()){
            result = c.getString(iName);
            names.add(result);
        }
        return result;
    }*/
   public Cursor getYourTableContents() {
       SQLiteDatabase db = this.getWritableDatabase();

       Cursor data = db.rawQuery("SELECT * FROM " + TABLE_NAME1, null);

       return data;
   }
    public void closeDB(){
        db = this.getReadableDatabase();
        if(db!= null && db.isOpen())
            db.close();
    }



}