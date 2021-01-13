package com.example.myfirstapp;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationMenuView;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {
//    public Deque<String> phrases;
//    public String engPhrase;
//    public final static String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
//    Button clickhere;
//    Button clickhere2;
//    Button clickhere3;
//    TextView engText;

//    public Deque<String> getNewPhrases(DBHelper dbHelper) {
//        Boolean alreadyProccessed;
//        String str = "";
//        Deque<String> deque
//                = new LinkedList<String>();
////        Deque<String> blacklisted =  getFinishedPhrases("bl_phrases");
////        DBHelper dbHelper = new DBHelper(MainActivity.this);
//        Deque<String> donelisted = dbHelper.getProccessedPhrases();
////        List<String> donelisted = new;
////        Deque<String> donelisted =  getFinishedPhrases("new_phrases");
//        InputStream ins = getResources().openRawResource(
//                getResources().getIdentifier("pop_phrases",
//                        "raw", getPackageName()));
//
//        try {
////            File myObj = new File(whole_path);
////            Scanner myReader = new Scanner(myObj);
////            while (myReader.hasNextLine()) {
////                String data = myReader.nextLine();
////                    System.out.println(data);
////                if (!data.equals("")) {
////                    deque.add(data);
////                }
////            }
//            //                System.out.println(deque);
////            myReader.close();
//
//            BufferedReader reader = new BufferedReader(new InputStreamReader(ins));
//            if (ins != null) {
//                while ((str = reader.readLine()) != null) {
//                    alreadyProccessed = Boolean.FALSE;
//
//                    for (String i : donelisted) {
//                        if (i != null) {
//                            if (i.equals(str)) {
//                                alreadyProccessed = Boolean.TRUE;
//                                break;
//                            }
//                        }
//                    }
//
//                    if (!alreadyProccessed && !str.equals("")) {
//                        deque.add(str);
//                    }
//                }
//            }     } catch (IOException e) {
////            e.printStackTrace();
//            Log.e("asdas", e.getMessage());
//        } finally {
//            try {
//                ins.close();
//            } catch (Throwable ignore) {
//            }
//        }
//        return deque;
//    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        final Phrases ph = new Phrases();
//        DBHelper dbHelper = new DBHelper(MainActivity.this, "TRANSLATIONS");
//        InputStream ins = getResources().openRawResource(
//                getResources().getIdentifier("pop_phrases",
//                        "raw", getPackageName()));
//
//        phrases = ph.getNewPhrases(dbHelper, ins);
////        engPhrase = getPhrase(phrases);
////        engPhrase = "hi";
//        TextView engText = (TextView)findViewById(R.id.engText);
////        engText.setText(engPhrase);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
//        NavController navController = Navigation.findNavController(MainActivity.this, R.id.fragment);
//        NavigationUI.setupWithNavController(bottomNavigationView, navController);

//        clickhere = (Button) findViewById(R.id.button);
//        clickhere2 = (Button) findViewById(R.id.button2);
//        clickhere3 = (Button) findViewById(R.id.button3);
//
//        clickhere.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//
////                TranslationModel translationModel;
//                EditText editText = (EditText) findViewById(R.id.editText);
//                String kirPhrase = editText.getText().toString().toLowerCase();
//
//                TranslationModel translationModel;
//                translationModel = new TranslationModel(engPhrase, kirPhrase);
//
//                DBHelper dbHelper = new DBHelper(MainActivity.this, "TRANSLATIONS");
//                boolean success = dbHelper.addOne(translationModel);
//
//                Phrases ph = new Phrases();
//
//                engPhrase = ph.getPhrase(phrases);
//
////              engPhrase = "hi";
//                TextView engText = (TextView)findViewById(R.id.engText);
//                engText.setText(engPhrase);
////                translationModel = new TranslationModel(engPhrase, )
//
//
//
//                Toast.makeText(MainActivity.this, "sucess= " + success, Toast.LENGTH_SHORT).show();
//         }
//        });
//
//        clickhere2.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//
//                TranslationModel translationModel;
//                translationModel = new TranslationModel(engPhrase, engPhrase);
//                engPhrase = ph.getPhrase(phrases);
//                TextView engText = (TextView)findViewById(R.id.engText);
//                engText.setText(engPhrase);
//
//                DBHelper dbHelper = new DBHelper(MainActivity.this, "TRANSLATIONS");
//                boolean success = dbHelper.addOne(translationModel);
//
//                Toast.makeText(MainActivity.this, "sucess= " + success, Toast.LENGTH_SHORT).show();
//
//            }
//        });
//
////        clickhere3.setOnClickListener(new View.OnClickListener() {
////            public void onClick(View v) {
////
//////                TranslationModel translationModel;
//////                translationModel = new TranslationModel(engPhrase, engPhrase);
//////                engPhrase = ph.getPhrase(phrases);
//////                TextView engText = (TextView)findViewById(R.id.engText);
//////                engText.setText(engPhrase);
////
////                DBHelper dbHelper = new DBHelper(MainActivity.this, "DICTIONARY");
////                InputStream dictins = getResources().openRawResource(
////                        getResources().getIdentifier("dictionary",
////                                "raw", getPackageName()));
////
////                ph.fillDictionary(dbHelper, dictins);
////
//////                boolean success = dbHelper.addOne(translationModel);
////
//////                Toast.makeText(MainActivity.this, "sucess= " + success, Toast.LENGTH_SHORT).show();
////
////            }
////        });
//
//        clickhere3.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//
////                TranslationModel translationModel;
////                translationModel = new TranslationModel(engPhrase, engPhrase);
//                engPhrase = ph.getPhrase(phrases);
//                TextView engText = (TextView)findViewById(R.id.engText);
//                engText.setText(engPhrase);
//
//
////                boolean success = dbHelper.addOne(translationModel);
//
////                Toast.makeText(MainActivity.this, "sucess= " + success, Toast.LENGTH_SHORT).show();
//
//            }
//        });
//
    }

    /** Called when the user taps the Send button */
//    public void sendMessage(View view) {
//        EditText editText = (EditText) findViewById(R.id.editText);
//        String message = editText.getText().toString();
//    }

}
