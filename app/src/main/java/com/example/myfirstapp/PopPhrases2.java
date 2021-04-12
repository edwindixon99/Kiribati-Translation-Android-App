package com.example.myfirstapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.io.InputStream;
import java.util.Deque;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PopPhrases2#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PopPhrases2 extends Fragment {


    public Deque<String> phrases;
    public String engPhrase;
    public final static String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    Button clickhere;
    Button clickhere2;
    Button clickhere3;
    TextView engText;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public PopPhrases2() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PopPhrases2.
     */
    // TODO: Rename and change types and number of parameters
    public static PopPhrases2 newInstance(String param1, String param2) {
        PopPhrases2 fragment = new PopPhrases2();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View fragmentView = inflater.inflate(R.layout.fragment_pop_phrases2, container, false);
        // Inflate the layout for this fragment

        final Phrases ph = new Phrases();
        DBHelper dbHelper = new DBHelper(getActivity(), "DICTIONARY");
        InputStream ins = getResources().openRawResource(
                getResources().getIdentifier("pop_phrases",
                        "raw", getActivity().getPackageName()));
////
//        ph.fillDictionary(dbHelper, ins);
        phrases = ph.getNewPhrases(dbHelper, ins);
//        engPhrase = getPhrase(phrases);
        engPhrase = "hi";
        TextView engText = (TextView) getView().findViewById(R.id.engText);
        engText.setText(engPhrase);

//        BottomNavigationView bottomNavigationView = getView().findViewById(R.id.bottomNavigationView);
//        NavController navController = Navigation.findNavController(getActivity(), R.id.fragment);
//        NavigationUI.setupWithNavController(bottomNavigationView, navController);

        clickhere = (Button) getView().findViewById(R.id.button);
        clickhere2 = (Button) getView().findViewById(R.id.button2);
        clickhere3 = (Button) getView().findViewById(R.id.button3);

        clickhere.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

//                TranslationModel translationModel;
                EditText editText = (EditText) getView().findViewById(R.id.query);
                String kirPhrase = editText.getText().toString().toLowerCase();

                TranslationModel translationModel;
                translationModel = new TranslationModel(engPhrase, kirPhrase);

                DBHelper dbHelper = new DBHelper(getActivity(), "TRANSLATIONS");
                boolean success = dbHelper.addOne(translationModel);

                Phrases ph = new Phrases();

                engPhrase = ph.getPhrase(phrases);

//              engPhrase = "hi";
                TextView engText = (TextView) getView().findViewById(R.id.engText);
                engText.setText(engPhrase);
//                translationModel = new TranslationModel(engPhrase, )



                Toast.makeText(getActivity(), "sucess= " + success, Toast.LENGTH_SHORT).show();
            }
        });

        clickhere2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                TranslationModel translationModel;
                translationModel = new TranslationModel(engPhrase, engPhrase);
                engPhrase = ph.getPhrase(phrases);
                TextView engText = (TextView) getView().findViewById(R.id.engText);
                engText.setText(engPhrase);

                DBHelper dbHelper = new DBHelper(getActivity(), "TRANSLATIONS");
                boolean success = dbHelper.addOne(translationModel);

                Toast.makeText(getActivity(), "sucess= " + success, Toast.LENGTH_SHORT).show();

            }
        });

//        clickhere3.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//
////                TranslationModel translationModel;
////                translationModel = new TranslationModel(engPhrase, engPhrase);
////                engPhrase = ph.getPhrase(phrases);
////                TextView engText = (TextView)findViewById(R.id.engText);
////                engText.setText(engPhrase);
//
////                DBHelper dbHelper = new DBHelper(getActivity(), "DICTIONARY");
////                InputStream dictins = getResources().openRawResource(
////                        getResources().getIdentifier("finaldict",
////                                "raw", getActivity().getPackageName()));
//
////                ph.fillDictionary(dbHelper, dictins);
//
////                boolean success = dbHelper.addOne(translationModel);
//
////                Toast.makeText(MainActivity.this, "sucess= " + success, Toast.LENGTH_SHORT).show();
//
//            }
//        });

        clickhere3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

//                TranslationModel translationModel;
//                translationModel = new TranslationModel(engPhrase, engPhrase);
                engPhrase = ph.getPhrase(phrases);
                TextView engText = (TextView) getView().findViewById(R.id.engText);
                engText.setText(engPhrase);


//                boolean success = dbHelper.addOne(translationModel);

//                Toast.makeText(MainActivity.this, "sucess= " + success, Toast.LENGTH_SHORT).show();

            }
        });

        return fragmentView;
    }
}