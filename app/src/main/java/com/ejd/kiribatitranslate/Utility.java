package com.ejd.kiribatitranslate;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;

import java.util.Deque;

public class Utility {


    public static void hideKeyboardFrom(Context context, View view) {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Activity.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public static void updateTextview(String queryString, TextView searchResults, DBHelper dbHelper, boolean english) {

        StringBuilder builder = new StringBuilder();
        Deque<String> queriedPhrases;
        if (english) {
            queriedPhrases = dbHelper.getQueriedEngPhrases(queryString);
        } else {
            queriedPhrases = dbHelper.getQueriedKirPhrases(queryString);
        }


        if (queriedPhrases.size() == 0) {
            searchResults.setText("No results found for '" + queryString + "' \ne aki reke te taeka anne '" + queryString +"'");
        } else {
            for (String translation : queriedPhrases) {
                builder.append(translation);

                builder.append("\n");
            }
            searchResults.setText(builder.toString());
        }

    }

}
