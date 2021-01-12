package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.InputStream;
import java.util.Deque;

public class GetQueries extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_queries);
        final Phrases ph = new Phrases();
        final DBHelper dbHelper = new DBHelper(GetQueries.this, "DICTIONARY");

        TextView engText = (TextView) findViewById(R.id.engText);
//        engText.setText(engPhrase);

        clickhere = (Button) findViewById(R.id.button);
//        clickhere2 = (Button) findViewById(R.id.button2);
//        clickhere3 = (Button) findViewById(R.id.button3);

        clickhere.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

//                TranslationModel translationModel;
                EditText editText = (EditText) findViewById(R.id.editText);
                TextView engText = (TextView) findViewById(R.id.engText);
                String query = editText.getText().toString().toLowerCase();

                if (!query.equals("")) {

                    Deque<String> queriedPhrases = dbHelper.getQueriedPhrases(query);
//                    engText.setText(queriedPhrases);
                }


            }

        });
    }
}