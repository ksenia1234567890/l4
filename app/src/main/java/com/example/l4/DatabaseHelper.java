package com.example.l4;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "Megabytes.db"; // название бд
    public static int SCHEMA = 1; // версия базы данных
    public static final String TABLE = "songs"; // название таблицы в бд
    // названия столбцов
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_MUSICIAN = "musician";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_TIMEADD = "timeAdd";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, SCHEMA);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
            //Создание таблицы
            db.execSQL("CREATE TABLE IF NOT EXISTS songs ("
                    + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + COLUMN_MUSICIAN + " TEXT, "
                    + COLUMN_NAME + " TEXT, "
                    + COLUMN_TIMEADD + " TEXT);"
            );
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion,  int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE);
        onCreate(db);
    }
}

