package com.software_engineering.supunarunoda.chatwithoutinternet.data.DB;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.software_engineering.supunarunoda.chatwithoutinternet.data.CustomApplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Supun on 6/12/2016.
 */
public class DBAccess {

    // Database Name
    public static final String DATABASE_NAME = "00534D";

    //Database Version
    public static final int DATABASE_VERSION = 1;// started at 1

    //Create User values
    public static final String USER_NAME = "user_name";
    public static final String USER_ID = "user_id";

    //Create Chat values
    public static final String CHAT_TB = "chat";
    public static final String CHAT_ID = "chat_id";
    public static final String CHAT_DATA = "chat_data";
    public static final String CHAT_NAME = "chat_name";


    //Create table syntax
    private static final String USER_CREATE =
            "CREATE TABLE user (user_id INTEGER PRIMARY KEY AUTOINCREMENT,user_name TEXT NOT NULL);";

    private static final String CHAT_CREATE =
            "CREATE TABLE chat (chat_id INTEGER PRIMARY KEY AUTOINCREMENT,chat_name TEXT NOT NULL,chat_data TEXT NOT NULL);";


    private static DBConnect dbConnect = null;
    private DBAccess() {
    }


    public static SQLiteDatabase getWritableDatabase() throws SQLiteException {
        if (dbConnect == null) {
            synchronized (DBAccess.class) {
                dbConnect = new DBConnect();
            }
        }
        return dbConnect.getWritableDatabase();
    }


    public static String getTimeAsString(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        return simpleDateFormat.format(date);
    }


    public static Date getTimeAsValue(String str) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        Date date = new Date();
        try {
            date = dateFormat.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }



    private static class DBConnect extends SQLiteOpenHelper {//Inner class for create only one database Ob using singleton
        public DBConnect() {
            super(CustomApplication.getCustomAppContext(), DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            try {
                //Create the tables
              //  db.execSQL(USER_CREATE);
                db.execSQL(CHAT_CREATE);

            } catch (Exception exception) {
                Log.i("DatabaseHandler", "Exception onCreate() exception : " + exception.getMessage());
            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

            db.execSQL("DROP TABLE IF EXISTS " + CHAT_TB); //On upgrade drop tables
            //db.execSQL("DROP TABLE IF EXISTS " + TRANSACTION_TB);
            onCreate(db);
        }
    }
}
