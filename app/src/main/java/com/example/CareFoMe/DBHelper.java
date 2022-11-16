package com.example.CareFoMe;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import com.example.CareFoMe.LoginActivity;

import java.util.ArrayList;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper

{	private static final String DATABASE_NAME = "CareForMe.db";
    private static final int DATABASE_VERSION = 1;
    public static final String Table_name="Login_table";
    public static final String Table_name2="Appointment_table";
    public static final String Table_name3="Doctors";
    public static final String Table_name4="Favorite";

    SQLiteDatabase db;
    private static final String TAG = "DbHelper";

    public static final String col1="Patient_id";
    public static final String col2="full_Name";
    public static final String col3="Phone_Number";
    public static final String col4="Password";
    public static final String col5="Email_Id";

    public static final String col6="Appointment_id ";
    public static final String col7="full_Name ";
    public static final String col9="Doc_name ";
    public static final String col12="ATime ";
    public static final String col8="Phone_Number";

    public static final String col10="Email_Id";


    public static final String col11="ADate";

    private static final String DOC_ID = "doc_id";
    private static final String NAME = "name";
    private static final String SPECIAL = "speciality";
    private static final String PHONE = "phone";

    private static final String DOC_Fav_ID = "doc_fav_id";
    private static final String NAME_F = "name_f";
    private static final String EMAIIL = "email";

    public DBHelper(Context context) {
        super(context,DATABASE_NAME , null, DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL("create table "+ Table_name+"(Patient_id INTEGER PRIMARY KEY ,full_name TEXT ,Phone_Number Text,password TEXT,Email_Id TEXT )");
        sqLiteDatabase.execSQL("create table "+ Table_name2+"(Appointment_id INTEGER PRIMARY KEY ,full_name TEXT ,Phone_Number Text,Doc_name TEXT,Email_Id TEXT ,ADate TEXT,ATime TEXT)");
        sqLiteDatabase.execSQL("CREATE TABLE "+Table_name3+"(doc_id INTEGER PRIMARY KEY,name TEXT NOT NULL,speciality TEXT NOT NULL,phone TEXT NOT NULL)");
        sqLiteDatabase.execSQL("CREATE TABLE "+Table_name4+"(doc_fav_id INTEGER PRIMARY KEY ,name_f TEXT NOT NULL, email TEXT NOT NULL)");
        String CREATE_FAVORITE_TABLE = "CREATE TABLE " + Table_name4 + "(" + DOC_Fav_ID + " INTEGER PRIMARY KEY," + NAME_F + " TEXT ," + EMAIIL + " TEXT " +")";
        db.execSQL(CREATE_FAVORITE_TABLE);


    }

    public void deleteAll()
    {

        db.delete(Table_name4, null, null);
        db.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE "+Table_name);
        sqLiteDatabase.execSQL("DROP TABLE "+Table_name2);
        db.execSQL("DROP TABLE IF EXISTS " +Table_name3);
        //db.execSQL("DROP TABLE IF EXISTS " +Table_name4);
        onCreate(sqLiteDatabase);

    }

    public void create() {
        SQLiteDatabase sqLiteDatabase= this.getWritableDatabase();
        sqLiteDatabase.execSQL("CREATE TABLE "+Table_name3+"(doc_id INTEGER PRIMARY KEY,name TEXT NOT NULL,speciality TEXT NOT NULL,phone TEXT NOT NULL)");

    }



    public void vider() {
        SQLiteDatabase sqLiteDatabase= this.getWritableDatabase();
        sqLiteDatabase.execSQL("DROP TABLE "+Table_name3);
    }

    /* public String getusername(String Email,String Password){
            Cursor userget;
            String username;

            String getusername= "select full_name from Login_table where" +
                    "Emailid =? and password= ?,

            return username;
        }*/
    public void DataInsert(String name,String phone,String pass,String Email_Id){

        SQLiteDatabase dbA= this.getWritableDatabase();
        ContentValues SignIn= new ContentValues();
        SignIn.put(col2,name);
        SignIn.put(col3,phone);
        SignIn.put(col4,pass);
        SignIn.put(col5,Email_Id);
        dbA.insert(Table_name,null,SignIn);



    }
    public void DataInsert2(String Pname,String phNumber,String Dname,String emailA,String date,String time){

        SQLiteDatabase sqLiteDatabase= this.getWritableDatabase();
        ContentValues Appointment= new ContentValues();
        Appointment.put(col7,Pname);
        Appointment.put(col8,phNumber);
        Appointment.put(col9,Dname);
        Appointment.put(col10,emailA);
        Appointment.put(col11,date);
        Appointment.put(col12,time);
        sqLiteDatabase.insert(Table_name2,null,Appointment);
    }


    public boolean checkUser(String email,String password) {

        // array of columns to fetch
        String[] columns = {
                col1
        };
        SQLiteDatabase db = this.getReadableDatabase();
        // selection criteria
        String selection = col5 + " = ?" + " AND " + col4 + " = ?";

        // selection arguments
        String[] selectionArgs = {email, password};


        Cursor cursor = db.query(Table_name,
                columns,
                selection,
                selectionArgs,
                null,
                null,
                null);

        int cursorCount = cursor.getCount();

        cursor.close();
        db.close();
        if (cursorCount > 0) {
            return true;
        }

        return false;

    }
    public boolean checkUser(String email) {


        String[] columns = {col1,col4,col5};
        SQLiteDatabase db = this.getReadableDatabase();


        String selection = col5 + " = ?";


        String[] selectionArgs = {email};


        String sortOrder =
                col2 + " ASC";
        Cursor cursor = db.query(Table_name, //Table to query
                columns,                    //columns to return
                selection,                  //columns for the WHERE clause
                selectionArgs,              //The values for the WHERE clause
                null,                       //group the rows
                null,                      //filter by row groups
                sortOrder);
        int cursorCount = cursor.getCount();



        if (cursorCount > 0) {
            return true;
        }

        return false;
    }


    public Cursor UserData(String Email,SQLiteDatabase sqLiteDatabase){ // to get user data from database
        String [] Info={col2,col5,col3};
        String selection = col5 + " = ?";
        String[] selectionArgs = {Email};

        // String[] selectionArgs = {email};
        Cursor cursor=sqLiteDatabase.query(Table_name,Info,selection,selectionArgs,null,null,null);
        return cursor;
    }

    public boolean checkUserAppointment(String dateAppointment,String time,String DoctorName) {


        String[] columns = {col6};
        SQLiteDatabase db = this.getReadableDatabase();


        String selection = col11 + " = ?"+ " AND " + col12 + " = ?"+ " AND " + col9 + " = ?";


        String[] selectionArgs = {dateAppointment,time,DoctorName};



        Cursor cursor = db.query(Table_name2, //Table to query
                columns,                    //columns to return
                selection,                  //columns for the WHERE clause
                selectionArgs,              //The values for the WHERE clause
                null,                       //group the rows
                null,                      //filter by row groups
                null);
        int cursorCount = cursor.getCount();



        if (cursorCount > 0) {
            return true;
        }

        return false;
    }

    public void insertDocDetail(UserData userData) {

        db = this.getWritableDatabase();
        db.beginTransaction();
        try{
            ContentValues values = new ContentValues();
            values.put(DOC_ID, userData.id);
            values.put(NAME, userData.name);
            values.put(SPECIAL, userData.speciality);
            values.put(PHONE, userData.phone);



            db.insert(Table_name3, null, values);
            db.setTransactionSuccessful();
        }
        catch (SQLException e) {
            e.printStackTrace();
            Log.d(TAG, "Error while trying to add post to database");
        } finally {

            db.endTransaction();
        }


    }

    public void insertfavorite(DoctorData userData) {

        db = this.getWritableDatabase();
        db.beginTransaction();
        try{
            ContentValues values = new ContentValues();
            values.put(DOC_Fav_ID, userData.doc_fav_id);
            values.put(NAME_F, userData.name_f);
            values.put(EMAIIL, userData.email);




            db.insert(Table_name4, null, values);
            db.setTransactionSuccessful();
        }
        catch (SQLException e) {
            e.printStackTrace();
            Log.d(TAG, "Error while trying to add post to database");
        } finally {

            db.endTransaction();
        }


    }

    public void insertFavDocDetail(DoctorData userData) {

        db = this.getWritableDatabase();
        db.beginTransaction();
        try{
            ContentValues values = new ContentValues();
            values.put(DOC_Fav_ID, userData.doc_fav_id);
            values.put(NAME_F, userData.name_f);
            values.put(EMAIIL, userData.email);



            db.insert(Table_name4, null, values);
            db.setTransactionSuccessful();
        }
        catch (SQLException e) {
            e.printStackTrace();
            Log.d(TAG, "Error while trying to add post to database");
        } finally {

            db.endTransaction();
        }


    }



    public List<UserData> getAllDoc()
    {

        List<UserData> usersdetail = new ArrayList<>();

        String SELECT_QUERY = "SELECT * FROM " + Table_name3;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(SELECT_QUERY, null);

        try {
            if (cursor!=null) {
                cursor.moveToFirst();

                while(!cursor.isAfterLast()){
                    UserData userData = new UserData();

                    userData.id = cursor.getInt(0);
                    userData.name = cursor.getString(1);
                    userData.speciality = cursor.getString(2);
                    userData.phone = cursor.getString(3);


                    usersdetail.add(userData);
                    cursor.moveToNext();

                }
            }
        } catch (Exception e)
        {
            Log.d(TAG, "Error while trying to get posts from database"+ e.getMessage());
        }

        return usersdetail;

    }

    // insert in favorite
    long addHandler(DoctorData d) {
        long id;
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!"+d);
        ContentValues values = new ContentValues();
        values.put(DOC_Fav_ID, d.getDoc_fav_id());
        values.put(NAME_F, d.getName_f());
        values.put(EMAIIL, d.getEmail());
        SQLiteDatabase db = this.getWritableDatabase();

        id = db.insert(Table_name4, null, values);
        db.close();
        return id;
    }

    String loadHandler() {
        String result = "";
        String query = "Select*FROM " + Table_name4;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        while (cursor.moveToNext()) {
            int result_0 = cursor.getInt(0);
            String result_1 = cursor.getString(1);
            String result_2 = cursor.getString(2);
            result += String.valueOf(result_0) + " " + result_1 + " " + result_2 +
                    System.getProperty("line.separator");
        }
        cursor.close();
        db.close();
        if(result.equals(""))
            result="No Record Found";
        return result;
    }



    public List<DoctorData> getAllFavDoc()
    {

        List<DoctorData> doctorsdetail = new ArrayList<>();

        String SELECT_QUERY = "SELECT * FROM Favorite";

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(SELECT_QUERY, null);

        try {
            if (cursor!=null) {
                cursor.moveToFirst();

                while(!cursor.isAfterLast()){
                    DoctorData doctorData = new DoctorData();

                    doctorData.doc_fav_id = cursor.getInt(0);
                    doctorData.name_f = cursor.getString(1);
                    doctorData.email = cursor.getString(2);

                    doctorsdetail.add(doctorData);
                    System.out.println(doctorData);
                    cursor.moveToNext();

                }
            }
        } catch (Exception e)
        {
            Log.d(TAG, "Error while trying to get posts from database"+ e.getMessage());
        }

        return doctorsdetail;

    }


    public List<AppointementData> getAllAppointements()
    {

        List<AppointementData> appdetail = new ArrayList<>();

        String SELECT_QUERY = "SELECT * FROM Appointment_table";

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(SELECT_QUERY, null);

        try {
            if (cursor!=null) {
                cursor.moveToFirst();

                while(!cursor.isAfterLast()){
                    AppointementData appData = new AppointementData();
                    //full_name TEXT ,Phone_Number Text,Doc_name TEXT,Email_Id TEXT ,ADate TEXT,ATime TEXT

                    //Dname
                    //emailA
                    //date
                    //time
                    appData.Appointment_id = cursor.getInt(0);
                    appData.Pname = cursor.getString(1);
                    appData.phNumber = cursor.getString(2);
                    appData.Dname = cursor.getString(3);
                    appData.emailA = cursor.getString(4);
                    appData.date = cursor.getString(5);
                    appData.time = cursor.getString(6);

                    appdetail.add(appData);
                    System.out.println(appData);
                    cursor.moveToNext();

                }
            }
        } catch (Exception e)
        {
            Log.d(TAG, "Error while trying to get posts from database"+ e.getMessage());
        }

        return appdetail;

    }


}