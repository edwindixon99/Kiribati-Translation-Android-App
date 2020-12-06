package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;  // Import the IOException class to handle errors
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.*;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainActivity extends AppCompatActivity {
    public Deque<String> phrases;
    public String engPhrase;
    public final static String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    Button clickhere;
    Button clickhere2;
    TextView engText;


    public String getFullPath(String filename) {
        String path = System.getProperty("user.dir");
        String whole_path = path + "/src/file/" + filename;
//        System.out.println(whole_path);
//        System.out.println("/home/cosc/student/ejd83/IdeaProjects/Kiri_subtitles/src/file" + "/pop_phrases.txt");
        return whole_path;
    }

    public Deque<String> getFinishedPhrases(String filename) {
        String str;
        String[] splitted;
        Deque<String> deque
                = new LinkedList<String>();
        InputStream ins = getResources().openRawResource(
                getResources().getIdentifier(filename,
                        "raw", getPackageName()));
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(ins));
            if (ins != null) {
                while ((str = reader.readLine()) != null) {
                    if (!str.equals("")) {
                        splitted = str.split(":");

                        deque.add(splitted[0]);
                    }
                }
            }     } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                ins.close();
            } catch (Throwable ignore) {
            }
        }
        return deque;
    }


    public Deque<String> getNewPhrases() {
        Boolean alreadyProccessed;
        String str = "";
        Deque<String> deque
                = new LinkedList<String>();
        Deque<String> blacklisted =  getFinishedPhrases("bl_phrases");
        Deque<String> donelisted =  getFinishedPhrases("new_phrases");
        InputStream ins = getResources().openRawResource(
                getResources().getIdentifier("pop_phrases",
                        "raw", getPackageName()));

        try {
//            File myObj = new File(whole_path);
//            Scanner myReader = new Scanner(myObj);
//            while (myReader.hasNextLine()) {
//                String data = myReader.nextLine();
//                    System.out.println(data);
//                if (!data.equals("")) {
//                    deque.add(data);
//                }
//            }
            //                System.out.println(deque);
//            myReader.close();

            BufferedReader reader = new BufferedReader(new InputStreamReader(ins));
            if (ins != null) {
                while ((str = reader.readLine()) != null) {
                    alreadyProccessed = Boolean.FALSE;

                    for (String i : blacklisted) {
                        if (i.equals(str)) {
                            alreadyProccessed = Boolean.TRUE;
                            break;
                        }
                    }
                    if (!alreadyProccessed) {
                        for (String i : donelisted) {
                            if (i.equals(str)) {
                                alreadyProccessed = Boolean.TRUE;
                                break;
                            }
                        }
                    }
                    if (!alreadyProccessed && !str.equals("")) {
                        deque.add(str);
                    }
                }
            }     } catch (IOException e) {
            e.printStackTrace();
        } finally {
                try {
                    ins.close();
                } catch (Throwable ignore) {
                }
            }
            return deque;
        }

    public String getPhrase(Deque<String> phrases) {
        return phrases.pop();
    }

    public void writePhraseToCorrect(View view) {
        try {
            EditText editText = (EditText) findViewById(R.id.editText);
            String kirPhrase = editText.getText().toString();
            String filepath = getFullPath("new_phrases.txt");

            FileWriter myWriter = new FileWriter(filepath, true);
            if (kirPhrase.length() > 0) myWriter.write(engPhrase + " : " + kirPhrase + "\n\n");
            myWriter.close();
//            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
//            System.out.println("An error occurred.");
            e.printStackTrace();

        }

    }

    public void writePhraseToIgnore(View view) {
        try {
            EditText editText = (EditText) findViewById(R.id.editText);
            String kirPhrase = editText.getText().toString();
            String filepath = getFullPath("bl_phrases.txt");
//            if (newPhrase) filepath = getFullPath("new_phrases.txt");

            FileWriter myWriter = new FileWriter(filepath, true);
            myWriter.write(engPhrase + "\n\n");
            myWriter.close();
//            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
//            System.out.println("An error occurred.");
            e.printStackTrace();

        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        phrases = getNewPhrases();
//        engPhrase = getPhrase(phrases);
//        engPhrase = "hi";
        TextView engText = (TextView)findViewById(R.id.engText);
//        engText.setText(engPhrase);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        clickhere = (Button) findViewById(R.id.button);
        clickhere2 = (Button) findViewById(R.id.button2);

        clickhere.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                engPhrase = getPhrase(phrases);
//             engPhrase = "hi";
                 TextView engText = (TextView)findViewById(R.id.engText);
                 engText.setText(engPhrase);
         }
        });

        clickhere2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                engPhrase = getPhrase(phrases);
                TextView engText = (TextView)findViewById(R.id.engText);
                engText.setText(engPhrase);
            }
        });
    }

    /** Called when the user taps the Send button */
//    public void sendMessage(View view) {
//        EditText editText = (EditText) findViewById(R.id.editText);
//        String message = editText.getText().toString();
//    }

}
