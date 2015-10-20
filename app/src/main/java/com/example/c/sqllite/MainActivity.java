package com.example.c.sqllite;

import static com.example.c.sqllite.DbConstants.TABLE_NAME;
import static android.provider.BaseColumns._ID;
import static com.example.c.sqllite.DbConstants.NAME;
import static com.example.c.sqllite.DbConstants.TEL;
import static com.example.c.sqllite.DbConstants.EMAIL;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    private DBHelper dbhelper = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        openDatabase();
        add();
    }


    private void openDatabase(){
        dbhelper = new DBHelper(this);
    }

    private void closeDatabase(){
        dbhelper.close();
    }

    private void add(){
        SQLiteDatabase db = dbhelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(NAME, "Denny");
        values.put(TEL, "07-6011000");
        values.put(EMAIL, "u0322806@nkfust.edu.tw");
        db.insert(TABLE_NAME, null, values);

    }

    private Cursor getCursor(){
        SQLiteDatabase db = dbhelper.getReadableDatabase();
        String[] columns = {_ID, NAME, TEL, EMAIL};

        Cursor cursor = db.query(TABLE_NAME, columns, null, null, null, null, null);
        startManagingCursor(cursor);

        return cursor;
    }

    private void update(){
        String id = "0322806";

        ContentValues values = new ContentValues();
        values.put(NAME, "Denny");
        values.put(TEL, "07-6011000");
        values.put(EMAIL, "u0322806@nkfust.edu.tw");

        SQLiteDatabase db = dbhelper.getWritableDatabase();
        db.update(TABLE_NAME, values, _ID + "=" + id, null);

    }
}