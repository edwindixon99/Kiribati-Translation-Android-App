package com.example.myfirstapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link kphrasevalidation#newInstance} factory method to
 * create an instance of this fragment.
 */
public class kphrasevalidation extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private Button clickdiscard;
    private Button clickkeep;

    public kphrasevalidation() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment kphrasevalidation.
     */
    // TODO: Rename and change types and number of parameters
    public static kphrasevalidation newInstance(String param1, String param2) {
        kphrasevalidation fragment = new kphrasevalidation();
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
        // Inflate the layout for this fragment
        View fragmentView =  inflater.inflate(R.layout.fragment_get_queries2, container , false);
        // Inflate the layout for this fragment

//        final Phrases ph = new Phrases();
//        final DBHelper dbHelper = new DBHelper(getActivity(), "DICTIONARY");
//
//        String newString = dbHelper.getUnvalidatedString();
////        TextView engText = (TextView) getView().findViewById(R.id.engText);
////        engText.setText(engPhrase);
////
//        clickkeep = (Button) fragmentView.findViewById(R.id.keep);
//        clickdiscard = (Button) fragmentView.findViewById(R.id.discard);
//        final TextView searchResults = (TextView) fragmentView.findViewById(R.id.results);
//
//        searchResults.setText(newString);



//        clickkeep.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
////                place your action here
////                searchResults.setText("hello");
////                StringBuilder builder = new StringBuilder();
////
////
////                searchResults.setText(builder.toString());
//
////                    searchResults.setText(builder.toString());
////                }
//            }
//        });
////        new View.OnClickListener() {
////            public void onClick(View v) {
////
////                TranslationModel translationModel;
////
////                String query = editText.getText().toString().toLowerCase();
////
////                StringBuilder builder = new StringBuilder();
////
//////                searchResults.setText(builder.toString());
////                searchResults.setText(query);
////
//////                Toast.makeText(, "button works", Toast.LENGTH_SHORT);
////
//////                if (!query.equals("")) {
//////
//////                    Deque<String> queriedPhrases = dbHelper.getQueriedPhrases(query);
//////                    for (String translation : queriedPhrases) {
//////                        builder.append(translation);
//////                        builder.append(", ");
//////                    }
//////                    searchResults.setText(builder.toString());
//////                }
////
////            }
////        });


        return fragmentView;
    }
}