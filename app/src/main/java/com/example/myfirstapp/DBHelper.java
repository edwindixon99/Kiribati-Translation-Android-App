package com.example.myfirstapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

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

    public Deque<String> getProccessedPhrases() {
        Deque<String> returnList = new LinkedList<String>();

        String queryString = "SELECT " + ENGLISH_COLUMN + " FROM " + TRANSLATIONS_TABLE;

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(queryString, null);


        if (cursor.moveToFirst()) {
            do {
                String englishPhrase = cursor.getString(0);
                returnList.add(englishPhrase);
            } while (cursor.moveToNext());
        } else {


        }
        cursor.close();
        db.close();
        return returnList;
    }
}
