package com.example.deangelogrant.symba;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;


import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

public class DirectFrag extends FragmentActivity implements OnMapReadyCallback,
        GoogleMap.OnMarkerClickListener{

    public static GoogleMap mMap;
    public double latitude = 35.135525;
    public double longitude = -78.871735;

    public boolean routeInfo = false;

    public static Marker Rid;
    public static Marker Hen;
    public static Marker Bern;
    public static Marker Tee;
    public static Marker Alli;
    public static Marker Nim;
    public static Marker MyLoc;
    public static Marker Nurse;
    public static Marker NorthD;
    public static Marker CVOD;
    public static Marker SandD;
    public static Marker WeaveD;
    public static Marker GarberD;
    public static Marker StadiumM;
    public static Marker ClarkM;

    public Polyline route;

    public static filterMap fm;

    public static boolean showHendricks = true;
    public static boolean showRiddle = true;
    public static boolean showNimmocks = true;
    public static boolean showAllison = true;
    public static boolean showBerns = true;
    public static boolean showTrusted = true;
    public static boolean showCVO = true;
    public static boolean showSand = true;
    public static boolean showGarber= true;
    public static boolean showWeave = true;
    public static boolean showNorth= true;
    public static boolean showStadium = true;
    public static boolean showNurse = true;
    public static boolean showClark = true;

    public static CheckBox chkF1 ;
    public static CheckBox chkF2 ;
    public static CheckBox chkF3 ;
    public static CheckBox chkF4 ;





    public  LatLngBounds Methodist = new LatLngBounds(
            new LatLng(35.131662, -78.877319), new LatLng(35.136628,-78.869573));



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.directfraglayout);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        fm = new filterMap(DirectFrag.this);

        chkF1 = (CheckBox)findViewById(R.id.chkFilter1);
        chkF2 = (CheckBox)findViewById(R.id.chkFilter2);
        chkF3 = (CheckBox)findViewById(R.id.chkFilter3);
        chkF4 = (CheckBox)findViewById(R.id.chkFilter4);

    }




    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setMinZoomPreference(17.0f);
        mMap.setMaxZoomPreference(18.0f);


        // Add a marker in Sydney and move the camera
        //LatLng mu = new LatLng(35.133462, -78.872675);
        LatLng you = new LatLng(latitude, longitude);
        LatLng Nimmocks = new LatLng(35.135964, -78.870780);
        LatLng Riddle = new LatLng(35.134069, -78.870512);
        LatLng Hendricks = new LatLng(35.135525, -78.871735);
        LatLng Allison = new LatLng(35.135753, -78.872797);
        LatLng Trusted = new LatLng(35.134481, -78.873934);
        LatLng Berns = new LatLng(35.134367, -78.872121);
        LatLng NurseL = new LatLng(35.133408, -78.873375);

        LatLng North = new LatLng(35.137842, -78.872615);
        LatLng CVO = new LatLng(35.134539, -78.868943);
        LatLng Weave = new LatLng(35.136444, -78.869608);
        LatLng Sand = new LatLng(35.135513, -78.868696);
        LatLng Garber = new LatLng(35.135774, -78.869914);

        LatLng Stadium = new LatLng(35.133176,-78.871708);
        LatLng Clark = new LatLng(35.133443,-78.874210);

        MyLoc = mMap.addMarker(new MarkerOptions().position(you).title("Your Current Location").
                icon(BitmapDescriptorFactory.fromResource(R.drawable.star)));
        MyLoc.setTag(1);

        Rid = mMap.addMarker(new MarkerOptions().position(Riddle).title("Riddle Athletic Center"));

        Nim = mMap.addMarker(new MarkerOptions().position(Nimmocks).title("Nimmocks Fitness Center"));

        Hen = mMap.addMarker(new MarkerOptions().position(Hendricks).title("Hendricks Science Complex"));

        Alli = mMap.addMarker(new MarkerOptions().position(Allison).title("Allison Computer Science and Math Hall"));

        Tee = mMap.addMarker(new MarkerOptions().position(Trusted).title("Trustees Building"));

        Bern = mMap.addMarker(new MarkerOptions().position(Berns).title("Berns Student Center"));

        Nurse = mMap.addMarker(new MarkerOptions().position(NurseL).title("Nursing Building"));

        CVOD = mMap.addMarker(new MarkerOptions().position(CVO).title("Cumberland Hall"));

        GarberD = mMap.addMarker(new MarkerOptions().position(Garber).title("Garber Hall"));

        NorthD = mMap.addMarker(new MarkerOptions().position(North).title("North Hall"));

        WeaveD = mMap.addMarker(new MarkerOptions().position(Weave).title("Weaver Hall"));

        SandD = mMap.addMarker(new MarkerOptions().position(Sand).title("Sanford Hall"));

        StadiumM = mMap.addMarker(new MarkerOptions().position(Stadium).title("Monarch Stadium"));

        ClarkM = mMap.addMarker(new MarkerOptions().position(Clark).title("Clark Hall"));


        if (showRiddle == true){
            Rid.setTag(2);
        }
        else{
            Rid.remove();
        }

        if (showNimmocks == true){
            Nim.setTag(3);
        }
        else{
            Nim.remove();
        }

        if (showHendricks == true){
            Hen.setTag(4);
        }
        else{
            Hen.remove();
        }

        if (showAllison== true){
           Alli.setTag(5);
        }
        else{
            Alli.remove();
        }

        if (showTrusted == true){
            Tee.setTag(6);
        }
        else{
            Tee.remove();
        }

        if (showBerns == true){
            Bern.setTag(7);
        }
        else{
            Bern.remove();
        }

        if (showNorth == true){

        }
        else{
            NorthD.remove();
        }

        if (showCVO == true){

        }
        else{
            CVOD.remove();
        }

        if (showSand == true){

        }
        else{
            SandD.remove();
        }

        if (showWeave == true){

        }
        else{
            WeaveD.remove();
        }

        if (showGarber == true){

        }
        else{
            GarberD.remove();
        }

        if(showStadium == true){

        }
        else{
            StadiumM.remove();
        }

        if(showNurse == true){

        }
        else{
            Nurse.remove();
        }


        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(you,17));
        mMap.setLatLngBoundsForCameraTarget(Methodist);

        mMap.setOnMarkerClickListener(this);
    }

    @Override
    public boolean onMarkerClick(final Marker marker) {

        if(route != null){
            route.remove();
        }

        if (marker.equals(StadiumM))
        {
            StadiumM.showInfoWindow();

            route = mMap.addPolyline(new PolylineOptions()

                    .add(
                            new LatLng(latitude, longitude),
                            new LatLng(35.135301,-78.871891),
                            new LatLng(35.135237,-78.871530),
                            new LatLng(35.134091,-78.872038),
                            new LatLng(35.133176,-78.871708)
                    )

            );

        }
        else if (marker.equals(Alli)){

            Alli.showInfoWindow();

            if(routeInfo == true){
              customDialog cd = new customDialog(DirectFrag.this);
                cd.show();
            }
            else {
                routeInfo = true;
            }

            route = mMap.addPolyline(new PolylineOptions()

                    .add(
                            new LatLng(latitude, longitude),
                            new LatLng(35.135753,-78.872797))

            );

        }
        else if (marker.equals(Bern)){

        }
        else if(marker.equals(Nim)){

        }
        else if(marker.equals(Tee)){

        }
        else if (marker.equals(ClarkM)){

            ClarkM.showInfoWindow();

            if(routeInfo == true){
                customDialog cd = new customDialog(DirectFrag.this);
                cd.show();
            }
            else {
                routeInfo = true;
            }

            route = mMap.addPolyline(new PolylineOptions()

                    .add(
                            new LatLng(latitude, longitude),
                            new LatLng(35.135300,-78.871891),
                            new LatLng(35.135058,-78.872467),
                            new LatLng(35.134620,-78.872662),
                            new LatLng(35.134677,-78.872894),
                            new LatLng(35.134324,-78.873045),
                            new LatLng(35.134369,-78.873214),
                            new LatLng(35.133868,-78.873427),
                            new LatLng(35.133942,-78.873668),
                            new LatLng(35.133700,-78.873793),
                            new LatLng(35.133791,-78.874098),
                            new LatLng(35.133443,-78.874210)
                    )

            );
        }

        return true;
    }


    public void filterMapShow (View view) {

        fm.show();
    }



}
