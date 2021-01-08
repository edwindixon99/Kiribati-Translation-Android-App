package com.example.myfirstapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public static final String TRANSLATIONS_TABLE = "TRANSLATIONS_TABLE";
    public static final String ENGLISH_COLUMN = "ENGLISH";
    public static final String KIRIBATI_COLUMN = "KIRIBATI";
    public static final String ID_COLUMN = "ID";

    public DBHelper(@Nullable Context context) {
        super(context, "Translations", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String createTableStatement = "CREATE TABLE " + TRANSLATIONS_TABLE + " (" + ID_COLUMN + " INTEGER PRIMARY KEY AUTOINCREMENT, " + ENGLISH_COLUMN + " TEXT, " + KIRIBATI_COLUMN + " TEXT)";
        db.execSQL(createTableStatement);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean addOne(TranslationModel translationModel)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(ENGLISH_COLUMN, translationModel.getEnglishPhrase());
        cv.put(KIRIBATI_COLUMN, translationModel.getKiribatiPhrase());

        long insert = db.insert(TRANSLATIONS_TABLE, null, cv);

        return true;
    }
}
