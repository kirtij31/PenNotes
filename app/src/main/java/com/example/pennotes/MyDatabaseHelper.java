package com.example.pennotes;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MyDatabaseHelper extends SQLiteOpenHelper {

    private Context context;
    public static final String DATABASE_NAME = "Notes.db";
    public static final int VERSION = 1;

    public static final String TABLE_NAME = "my_notes";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_TITLE = "title";
    public static final String COLUMN_DESCRIPTION = "description";

    public MyDatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, VERSION);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_TITLE + " TEXT," + COLUMN_DESCRIPTION + " TEXT)";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
      db.execSQL("DROP TABLE "+ TABLE_NAME);
      onCreate(db);
    }

    void add_note(String title, String description){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_TITLE,title);
        cv.put(COLUMN_DESCRIPTION,description);
        long result =db.insert(TABLE_NAME,null,cv);

        if(result==-1)
            Toast.makeText(context,"failed",Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(context,"Success",Toast.LENGTH_SHORT).show();

    }

    Cursor readNote(){
        String query = "SELECT * FROM "+TABLE_NAME;
        SQLiteDatabase db  = this.getReadableDatabase();

        Cursor cursor = null;
        if(db!=null){
            cursor = db.rawQuery(query,null);
        }

        return cursor;
    }
}
