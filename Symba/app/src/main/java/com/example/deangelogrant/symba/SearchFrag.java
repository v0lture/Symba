package com.example.deangelogrant.symba;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;

/**
 * Created by Elvin on 12/1/2016.
 */

public class SearchFrag extends Fragment {

    public static TextView cscTV;
    public static TextView engTV;
    public static TextView sciTV;

    public static ScrollView cscScroll;
    public static ScrollView engScroll;
    public static ScrollView sciScroll;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.searchlayout, container, false);
    }

}
