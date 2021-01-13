package com.example.myfirstapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Deque;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link GetQueriesFrag#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GetQueriesFrag extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    Button clickhere;
    private String mParam1;
    private String mParam2;

    public GetQueriesFrag() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment GetQueriesFrag.
     */
    // TODO: Rename and change types and number of parameters
    public static GetQueriesFrag newInstance(String param1, String param2) {
        GetQueriesFrag fragment = new GetQueriesFrag();
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


//        final Phrases ph = new Phrases();
//        final DBHelper dbHelper = new DBHelper(getActivity(), "DICTIONARY");
//
//        TextView engText = (TextView) getView().findViewById(R.id.engText);
////        engText.setText(engPhrase);
//
//        clickhere = (Button) getView().findViewById(R.id.search);
////        clickhere2 = (Button) findViewById(R.id.button2);
////        clickhere3 = (Button) findViewById(R.id.button3);
//
//        clickhere.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//
////                TranslationModel translationModel;
//                EditText editText = (EditText) getView().findViewById(R.id.query);
//                TextView searchResults = (TextView) getView().findViewById(R.id.results);
//                String query = editText.getText().toString().toLowerCase();
//
//                StringBuilder builder = new StringBuilder();
//
//
//                searchResults.setText(builder.toString());
//
//                if (!query.equals("")) {
//
//                    Deque<String> queriedPhrases = dbHelper.getQueriedPhrases(query);
//                    for (String translation : queriedPhrases) {
//                        builder.append(translation);
//                        builder.append(", ");
//                    }
//                    searchResults.setText(builder.toString());
//                }
//
//            }
//        });


        return inflater.inflate(R.layout.fragment_get_queries, container, false);
    }
}