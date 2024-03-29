package com.ejd.kiribatitranslate;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Deque;

import static com.ejd.kiribatitranslate.Utility.hideKeyboardFrom;
import static com.ejd.kiribatitranslate.Utility.updateTextview;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link GoogleTranslateKtoE#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GoogleTranslateKtoE extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private Button clickhere;
    private EditText editText;
    private TextView searchResults;
    private String queryString;

    public GoogleTranslateKtoE() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment GetQueries2.
     */
    // TODO: Rename and change types and number of parameters
    public static GetQueries2 newInstance(String param1, String param2) {
        GetQueries2 fragment = new GetQueries2();
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

        View fragmentView =  inflater.inflate(R.layout.fragment_get_queries2, container , false);
        // Inflate the layout for this fragment

        final DBHelper dbHelper = new DBHelper(getActivity(), "DICTIONARY");


        clickhere = (Button) fragmentView.findViewById(R.id.search);
        final EditText editText = (EditText) fragmentView.findViewById(R.id.query);
        final TextView searchResults = (TextView) fragmentView.findViewById(R.id.results);
        queryString = editText.getText().toString();

        StringBuilder builder = new StringBuilder();


        clickhere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                StringBuilder builder = new StringBuilder();

                queryString = editText.getText().toString().toLowerCase();

                if (!queryString.equals("") && !queryString.contains("'")) {

                    updateTextview(queryString, searchResults, dbHelper, true);
                }
                hideKeyboardFrom(getContext(), view);
            }
        });



        return fragmentView;
    }

}