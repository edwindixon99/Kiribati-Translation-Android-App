package com.example.myfirstapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.speech.tts.TextToSpeech;

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
    public static String name;
    public static String TABLE_NAME = name + "_TABLE";

    public DBHelper(@Nullable Context context, String name) {
        super(context, name, null, 1);
        this.name = name;
        this.TABLE_NAME = TABLE_NAME = name + "_TABLE";
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String createTableStatement = "CREATE TABLE " + TABLE_NAME + " (" + ID_COLUMN + " INTEGER PRIMARY KEY AUTOINCREMENT, " + ENGLISH_COLUMN + " TEXT, " + KIRIBATI_COLUMN + " TEXT)";
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

        long insert = db.insert(TABLE_NAME, null, cv);

        return true;
    }

    public Deque<String> getProccessedPhrases() {
        Deque<String> returnList = new LinkedList<String>();

        String queryString = "SELECT " + ENGLISH_COLUMN + " FROM " + TABLE_NAME;

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


    public Deque<String> getQueriedEngPhrases(String query) {
        Deque<String> returnList = new LinkedList<String>();

        String queryString = "SELECT " + KIRIBATI_COLUMN + "," + ENGLISH_COLUMN + " FROM " + "null_TABLE" + " WHERE " + ENGLISH_COLUMN + " LIKE '% " + query.toLowerCase() + " %'";
        queryString += " OR " + ENGLISH_COLUMN + " LIKE '" + query.toLowerCase() + "'";
        queryString += " OR " + ENGLISH_COLUMN + " LIKE '" + query.toLowerCase() + " %'";
        queryString += " OR " + ENGLISH_COLUMN + " LIKE '% " + query.toLowerCase() + "'";
//        String queryString = "SELECT ?, ? FROM null_TABLE WHERE ? LIKE '%" + query.toLowerCase() + "%'";

        SQLiteDatabase db = this.getReadableDatabase();

//        Cursor cursor = db.rawQuery(queryString, new String[] {KIRIBATI_COLUMN, ENGLISH_COLUMN, ENGLISH_COLUMN});
        Cursor cursor = db.rawQuery(queryString, null);


        if (cursor.moveToFirst()) {
            do {
                String kiriPhrase = cursor.getString(1);
                kiriPhrase += " : " + cursor.getString(0);
                returnList.add(kiriPhrase);
            } while (cursor.moveToNext());
        } else {


        }
        cursor.close();
        db.close();
        return returnList;
    }

    public Deque<String> getQueriedKirPhrases(String query) {
        Deque<String> returnList = new LinkedList<String>();

        String queryString = "SELECT " + KIRIBATI_COLUMN + "," + ENGLISH_COLUMN + " FROM " + "null_TABLE" + " WHERE " + KIRIBATI_COLUMN + " LIKE '% " + query.toLowerCase() + " %'";
        queryString += " OR " + KIRIBATI_COLUMN + " LIKE '" + query.toLowerCase() + "'";
        queryString += " OR " + KIRIBATI_COLUMN + " LIKE '" + query.toLowerCase() + " %'";
        queryString += " OR " + KIRIBATI_COLUMN + " LIKE '% " + query.toLowerCase() + "'";
//        String queryString = "SELECT ?, ? FROM null_TABLE WHERE ? LIKE '%" + query.toLowerCase() + "%'";

        SQLiteDatabase db = this.getReadableDatabase();

//        Cursor cursor = db.rawQuery(queryString, new String[] {KIRIBATI_COLUMN, ENGLISH_COLUMN, ENGLISH_COLUMN});
        Cursor cursor = db.rawQuery(queryString, null);


        if (cursor.moveToFirst()) {
            do {
                String kiriPhrase = cursor.getString(0);
                kiriPhrase += " : " + cursor.getString(1);
                returnList.add(kiriPhrase);
            } while (cursor.moveToNext());
        } else {


        }
        cursor.close();
        db.close();
        return returnList;
    }


}
