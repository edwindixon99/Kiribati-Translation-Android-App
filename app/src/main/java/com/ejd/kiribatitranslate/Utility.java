package com.ejd.kiribatitranslate;

import android.app.Activity;
import android.content.Context;
import android.text.Html;
import android.text.method.LinkMovementMethod;
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
            searchResults.setText(Html.fromHtml("No results found for '" + queryString + "'. \n\ne aki reke te taeka anne '" + queryString +"'.\n\nCheck out <a href='http://kiribatitranslate.com'>kiribatitranslate.com</a> for more translations and log in to contribute to the dictionary"));
            searchResults.setMovementMethod(LinkMovementMethod.getInstance());
        } else {
            for (String translation : queriedPhrases) {
                builder.append(translation);

                builder.append("\n");
            }
            searchResults.setText(builder.toString());
        }

    }

}
