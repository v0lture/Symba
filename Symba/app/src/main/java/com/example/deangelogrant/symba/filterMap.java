package com.example.deangelogrant.symba;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by Elvin on 3/26/2017.
 */

public class filterMap extends Dialog implements
        android.view.View.OnClickListener {

    public Activity c;
    public Dialog d;
    public Button yes, no;
    public EditText searchBar;
    public String searchText;

    public CheckBox Academic;
    public CheckBox Dining;
    public CheckBox Fitness;
    public CheckBox Residence;


    public filterMap (Activity a) {
        super(a);
        // TODO Auto-generated constructor stub
        this.c = a;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.filter_map);

       searchBar = (EditText)findViewById(R.id.searchET);
        searchBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchBar.setText("");

            }
        });

        Academic = (CheckBox)findViewById(R.id.chkFilter1);
        Dining = (CheckBox) findViewById(R.id.chkFilter2);
        Fitness = (CheckBox) findViewById(R.id.chkFilter3);
        Residence = (CheckBox)findViewById(R.id.chkFilter4);

        Button button = (Button) findViewById(R.id.button7);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DirectFrag.fm.dismiss();
            }
        });

        Button button2 = (Button) findViewById(R.id.button6);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*searchText = searchBar.getText().toString();

                if(searchText=="Berns"||searchText=="berns"){
                    DirectFrag.fm.dismiss();
                }*/

                if(Academic.isChecked()||Dining.isChecked()||Residence.isChecked()||Fitness.isChecked()){


                    DirectFrag.Alli.remove();
                    DirectFrag.Nim.remove();
                    DirectFrag.Rid.remove();
                    DirectFrag.Bern.remove();
                    DirectFrag.Tee.remove();
                    DirectFrag.SandD.remove();
                    DirectFrag.CVOD.remove();
                    DirectFrag.GarberD.remove();
                    DirectFrag.WeaveD.remove();
                    DirectFrag.NorthD.remove();
                    DirectFrag.StadiumM.remove();
                    DirectFrag.Nurse.remove();
                    DirectFrag.ClarkM.remove();

                }

                if(Academic.isChecked()){
                    LatLng Allison = new LatLng(35.135753, -78.872797);
                    DirectFrag.Alli = DirectFrag.mMap.addMarker(new MarkerOptions().position(Allison).
                            title("Allison Computer Science and Math Hall"));

                    LatLng Trusted = new LatLng(35.134481, -78.873934);
                    DirectFrag.Tee = DirectFrag.mMap.addMarker(new MarkerOptions().position(Trusted).
                            title("Trustees Building"));

                    LatLng NurseL = new LatLng(35.133408, -78.873375);
                    DirectFrag.Nurse = DirectFrag.mMap.addMarker(new MarkerOptions().position(NurseL).
                            title("Nursing Building"));

                    LatLng Clark = new LatLng(35.133443,-78.874210);
                    DirectFrag.ClarkM = DirectFrag.mMap.addMarker(new MarkerOptions().position(Clark).
                            title("Clark Hall"));
                }

                DirectFrag.fm.dismiss();

            }
        });
    }



    @Override
    public void onClick(View v) {

    }
}
