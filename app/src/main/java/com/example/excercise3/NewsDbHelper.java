package com.example.excercise3;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class NewsDbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "news.db";
    private static final int DATABASE_VERSION = 1;

    public static final String TABLE_NAME = "news";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_TITLE = "title";
    public static final String COLUMN_CONTENT = "content";

    public NewsDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_TITLE + " TEXT NOT NULL, " +
                COLUMN_CONTENT + " TEXT NOT NULL);";
        db.execSQL(CREATE_TABLE);

        // Insert sample data
        db.execSQL("INSERT INTO " + TABLE_NAME + " (title, content) VALUES ('Article 1', 'This is the content for article 1');");
        db.execSQL("INSERT INTO " + TABLE_NAME + " (title, content) VALUES ('Article 2', 'This is the content for article 2');");
        db.execSQL("INSERT INTO " + TABLE_NAME + " (title, content) VALUES ('Article 3', 'This is the content for article 3');");
        db.execSQL("INSERT INTO " + TABLE_NAME + " (title, content) VALUES ('Article 4', 'This is the content for article 4');");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
