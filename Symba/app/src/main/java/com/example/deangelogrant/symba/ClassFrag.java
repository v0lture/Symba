package com.example.deangelogrant.symba;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;/**
 * Created by Elvin on 12/1/2016.
 */

public class ClassFrag extends Fragment {

    public static CardView class1;
    public static CardView class2;
    public static CardView class3;
    public static CardView class4;

    public static CheckBox chkClass1B;
    public static CheckBox chkClass2B;
    public static CheckBox chkClass3B;
    public static CheckBox chkClass4B;

    public static TextView minHours;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.classfraglayout, container, false);
    }

}


