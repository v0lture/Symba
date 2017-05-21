package com.example.deangelogrant.symba;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.elvin.projectapp1.R;

/**
 * Created by Elvin on 12/1/2016.
 */

public class Class2Frag extends Fragment {

    public static CardView class1B;
    public static CardView class2B;
    public static CardView class3B;
    public static CardView class4B;

    public static CheckBox chkClass1BC;
    public static CheckBox chkClass2BC;
    public static CheckBox chkClass3BC;
    public static CheckBox chkClass4BC;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.class2layout, container, false);
    }

}