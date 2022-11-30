package kth.etka.weather;

import android.content.Context;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.HashMap;

public class DBHandler extends SQLiteOpenHelper {
    private static final int DB_VERSION = 1;
    private static final String DATE = "usersdb";
    private static final String TABLE_Users = "userdetails";
    private static final String KEY_ID = "id";
    private static final String ADate = "appDate";
    private static final String ATIME = "appTime";
    private static final String VDATE = "valDate";
    private static final String VTime = "valTime";
    private static final String TEMPERATURE = "designation";
    private static final String CLOUDCOVER = "cloudcoverage";
    public DataHandler(Context context){
        super(context,DATE, null, DB_VERSION);


        @Override
        public void onCreate(SQLiteDatabase db) {
            // Drop older table if exist
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_Users);
            // Create tables again
            onCreate(db);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }
    }
