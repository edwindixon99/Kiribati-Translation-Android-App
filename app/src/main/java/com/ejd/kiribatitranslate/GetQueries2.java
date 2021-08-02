package com.ejd.kiribatitranslate;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Deque;

import static com.ejd.kiribatitranslate.Utility.hideSoftKeyboard;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link GetQueries2#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GetQueries2 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private Button clickhere;
    private EditText editText;
    private TextView searchResults;
    private String queryString;

    public GetQueries2() {
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

        View fragmentView =  inflater.inflate(R.layout.fragment_google_translate_kto_e, container , false);
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

                    Deque<String> queriedPhrases = dbHelper.getQueriedKirPhrases(queryString);
                    for (String translation : queriedPhrases) {
                        builder.append(translation);
//                        builder.append(",");
                        builder.append("\n");
                    }
                    searchResults.setText(builder.toString());
                }
            }
        });
        return fragmentView;
    }

    public void setupUI(View view) {

        // Set up touch listener for non-text box views to hide keyboard.
        if (!(view instanceof EditText)) {
            view.setOnTouchListener(new View.OnTouchListener() {
                public boolean onTouch(View v, MotionEvent event) {
                    hideSoftKeyboard();
                    return false;
                }
            });
        }

        //If a layout container, iterate over children and seed recursion.
        if (view instanceof ViewGroup) {
            for (int i = 0; i < ((ViewGroup) view).getChildCount(); i++) {
                View innerView = ((ViewGroup) view).getChildAt(i);
                setupUI(innerView);
            }
        }
    }

}