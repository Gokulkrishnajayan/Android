package com.example.sqlitelistview;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class ControllerDB extends SQLiteOpenHelper {
    private static final String LOGCAT = "DB_LOG";

    public ControllerDB(Context applicationContext) {
        super(applicationContext, "Companies.db", null, 1);
        Log.d(LOGCAT, "Database created");
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        String query = "CREATE TABLE IF NOT EXISTS tblCompanies ( _id INTEGER PRIMARY KEY, CompanyName TEXT)";
        database.execSQL(query);
    }

    public String insertData(String companyName) {
        try {
            SQLiteDatabase database = this.getWritableDatabase();
            String query = "INSERT INTO tblCompanies (CompanyName) VALUES ('" + companyName + "')";
            database.execSQL(query);
            database.close();
            return "Added Successfully";
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {
        String query = "DROP TABLE IF EXISTS tblCompanies";
        database.execSQL(query);
        onCreate(database);
    }

    public Cursor getCompanies() {
        try {
            String selectQuery = "SELECT * FROM tblCompanies ORDER BY _id DESC";
            SQLiteDatabase database = this.getWritableDatabase();
            return database.rawQuery(selectQuery, null);
        } catch (Exception ex) {
            return null;
        }
    }
}
