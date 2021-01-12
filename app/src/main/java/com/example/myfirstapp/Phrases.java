package com.example.myfirstapp;

import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Phrases {

    public Phrases() {}

    public String getFullPath(String filename) {
        String path = System.getProperty("user.dir");
        String whole_path = path + "/src/file/" + filename;
//        System.out.println(whole_path);
//        System.out.println("/home/cosc/student/ejd83/IdeaProjects/Kiri_subtitles/src/file" + "/pop_phrases.txt");
        return whole_path;
    }

    public Deque<String> getNewPhrases(DBHelper dbHelper, InputStream ins) {
        Boolean alreadyProccessed;
        String str = "";
        Deque<String> deque
                = new LinkedList<String>();
//        Deque<String> blacklisted =  getFinishedPhrases("bl_phrases");
//        DBHelper dbHelper = new DBHelper(MainActivity.this);
        Deque<String> donelisted = dbHelper.getProccessedPhrases();
//        List<String> donelisted = new;
//        Deque<String> donelisted =  getFinishedPhrases("new_phrases");
//        InputStream ins = getResources().openRawResource(
//                getResources().getIdentifier("pop_phrases",
//                        "raw", getPackageName()));

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

                    for (String i : donelisted) {
                        if (i != null) {
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
//            e.printStackTrace();
            Log.e("asdas", e.getMessage());
        } finally {
            try {
                ins.close();
            } catch (Throwable ignore) {
            }
        }
        return deque;
    }

    public Deque<String> fillDictionary(DBHelper dbHelper, InputStream ins) {
        String[] parts;
        TranslationModel translationModel;
        String str = "";
        Deque<String> deque
                = new LinkedList<String>();
//        Deque<String> blacklisted =  getFinishedPhrases("bl_phrases");
//        DBHelper dbHelper = new DBHelper(MainActivity.this);
        Deque<String> donelisted = dbHelper.getProccessedPhrases();
//        List<String> donelisted = new;
//        Deque<String> donelisted =  getFinishedPhrases("new_phrases");
//        InputStream ins = getResources().openRawResource(
//                getResources().getIdentifier("pop_phrases",
//                        "raw", getPackageName()));

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(ins));
            if (ins != null) {
                while ((str = reader.readLine()) != null) {


                    if (!str.equals("")) {
                        try {
                            parts = str.split(":");

                            translationModel = new TranslationModel(parts[0], parts[1]);
                            dbHelper.addOne(translationModel);

                        } catch(Exception e) {}
                    }
                }
            }     } catch (IOException e) {
//            e.printStackTrace();
            Log.e("asdas", e.getMessage());
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
}
