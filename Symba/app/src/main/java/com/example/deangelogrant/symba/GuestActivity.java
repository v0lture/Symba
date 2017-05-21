package com.example.deangelogrant.symba;

import android.app.Fragment;
import android.app.usage.UsageEvents;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.CardView;
import android.view.Gravity;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.EditText;

import com.google.android.gms.ads.identifier.AdvertisingIdClient;

public class GuestActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    public Fragment guestmain;
    public Fragment guestevents;
    public Fragment guestdirect;
    public Fragment guestinfo;
    public Fragment guestcontact;
    public android.app.FragmentTransaction ft;

    public int ny = 0;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guest);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        if (findViewById(R.id.fragcontainer) != null) {
            if (savedInstanceState != null) {
                return;
            }

            guestmain = new GuestMainFrag();
            ft = getFragmentManager().beginTransaction();
            ft.add(R.id.fragcontainer, guestmain);
            ft.commit();
        } else {
            guestmain = new GuestMainFrag();
            ft = getFragmentManager().beginTransaction();
            ft.replace(R.id.fragcontainer, guestmain);
            ft.addToBackStack(null);
            ft.commit();
        }


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.guest, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement


        if (id == R.id.action_exit) {
            AlertDialog alertDialog = new AlertDialog.Builder(GuestActivity.this).create();
            alertDialog.setTitle("Confirm");
            alertDialog.setMessage("Are you sure you want to exit the application?");
            alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "Cancel",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
            alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "Confirm",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                            System.exit(0);
                        }
                    });
            alertDialog.show();
            return true;
        } else if (id == R.id.action_help) {
            AlertDialog alertDialog = new AlertDialog.Builder(GuestActivity.this).create();
            alertDialog.setTitle("Help");
            alertDialog.setMessage("The 'EVENTS' button will show you all of the current or upcoming events around campus.\n\n" +
                    "The 'DIRECTORY' button will provide you with a map of the campus\n\n" +
                    "The 'INFORMATION' button will give you information of the campus");
            alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "Okay",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
            alertDialog.show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_events) {
            guestevents = new EventFrag();
            ft = getFragmentManager().beginTransaction();
            ft.replace(R.id.fragcontainer, guestevents);
            ft.addToBackStack(null);
            ft.commit();
        } else if (id == R.id.nav_directory) {
            DirectFrag.showRiddle = true;
            DirectFrag.showNimmocks = true;
            DirectFrag.showAllison = true;
            DirectFrag.showBerns = true;
            DirectFrag.showTrusted = true;
            DirectFrag.showCVO = true;
            DirectFrag.showSand = true;
            DirectFrag.showGarber= true;
            DirectFrag.showWeave = true;
            DirectFrag.showNorth= true;
            DirectFrag.showStadium = true;
            DirectFrag.showNurse = true;
            DirectFrag.showClark = true;
            DirectFrag.showHendricks = true;

            Intent intent = new Intent(this, DirectFrag.class);
            startActivity(intent);
        } else if (id == R.id.nav_info) {
            guestinfo = new InfoFrag();
            ft = getFragmentManager().beginTransaction();
            ft.replace(R.id.fragcontainer, guestinfo);
            ft.addToBackStack(null);
            ft.commit();
        } else if (id == R.id.nav_logout) {
            AlertDialog alertDialog = new AlertDialog.Builder(GuestActivity.this).create();
            alertDialog.setTitle("Confirm");
            alertDialog.setMessage("Are you sure you want to logout?");
            alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "Cancel",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
            alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "Confirm",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                            System.exit(0);
                        }
                    });
            alertDialog.show();
            return true;
        } else if (id == R.id.nav_help) {
            guestcontact = new ContactFrag();
            ft = getFragmentManager().beginTransaction();
            ft.replace(R.id.fragcontainer, guestcontact);
            ft.addToBackStack(null);
            ft.commit();
        } else if (id == R.id.nav_exit) {
            AlertDialog alertDialog = new AlertDialog.Builder(GuestActivity.this).create();
            alertDialog.setTitle("Confirm");
            alertDialog.setMessage("Are you sure you want to exit the application?");
            alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "Cancel",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
            alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "Confirm",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                            System.exit(0);
                        }
                    });
            alertDialog.show();
            return true;

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


        public void eventTrans(View view) {
        guestevents = new EventFrag();
        ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.fragcontainer, guestevents);
        ft.addToBackStack(null);
        ft.commit();
    }

    public void directTrans(View view) {
        DirectFrag.showRiddle = true;
        DirectFrag.showNimmocks = true;
        DirectFrag.showAllison = true;
        DirectFrag.showBerns = true;
        DirectFrag.showTrusted = true;
        DirectFrag.showCVO = true;
        DirectFrag.showSand = true;
        DirectFrag.showGarber= true;
        DirectFrag.showWeave = true;
        DirectFrag.showNorth= true;
        DirectFrag.showStadium = true;
        DirectFrag.showNurse = true;
        DirectFrag.showClark = true;
        DirectFrag.showHendricks = true;

        Intent intent = new Intent(this, DirectFrag.class);
        startActivity(intent);
    }

    public void infoTrans(View view) {
        guestinfo = new InfoFrag();
        ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.fragcontainer, guestinfo);
        ft.addToBackStack(null);
        ft.commit();
    }

    public void floatbtn(View view) {
        AlertDialog alertDialog = new AlertDialog.Builder(GuestActivity.this).create();
        alertDialog.setTitle("Need help?");
        alertDialog.setMessage("Contact us for help!");
        alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "Cancel",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "Continue",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        guestcontact = new ContactFrag();
                        ft = getFragmentManager().beginTransaction();
                        ft.replace(R.id.fragcontainer, guestcontact);
                        ft.addToBackStack(null);
                        ft.commit();
                    }
                });
        alertDialog.show();
    }



    public void generalPhone(View view) {
        AlertDialog alertDialog = new AlertDialog.Builder(GuestActivity.this).create();
        alertDialog.setTitle("Confirm");
        alertDialog.setMessage("Call (910)-630-4256 ?");
        alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "Cancel",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "Call",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Intent callIntent = new Intent(Intent.ACTION_CALL);
                        callIntent.setData(Uri.parse("tel:(910)-630-4256"));
                        startActivity(callIntent);
                    }
                });
        alertDialog.show();
    }

    public void bussPhone(View view) {
        AlertDialog alertDialog = new AlertDialog.Builder(GuestActivity.this).create();
        alertDialog.setTitle("Confirm");
        alertDialog.setMessage("Call (910)-630-1866 ?");
        alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "Cancel",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "Call",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Intent callIntent = new Intent(Intent.ACTION_CALL);
                        callIntent.setData(Uri.parse("tel:(910)-630-1866"));
                        startActivity(callIntent);
                    }
                });
        alertDialog.show();
    }

    public void safePhone(View view) {
        AlertDialog alertDialog = new AlertDialog.Builder(GuestActivity.this).create();
        alertDialog.setTitle("Confirm");
        alertDialog.setMessage("Call (910)-630-6132 ?");
        alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "Cancel",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "Call",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Intent callIntent = new Intent(Intent.ACTION_CALL);
                        callIntent.setData(Uri.parse("tel:910-630-6132"));
                        startActivity(callIntent);
                    }
                });
        alertDialog.show();
    }

    public void event1G (View view){
        AlertDialog alertDialog = new AlertDialog.Builder(GuestActivity.this).create();
        alertDialog.setTitle("Lacrosse Game");
        alertDialog.setMessage("Methodist University vs Ferrum\n\nThis event is located at Monarch Stadium");
        alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "Return",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "Directory",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                        DirectFrag.showRiddle = false;
                        DirectFrag.showNimmocks = false;
                        DirectFrag.showAllison = false;
                        DirectFrag.showBerns = false;
                        DirectFrag.showTrusted = false;
                        DirectFrag.showCVO = false;
                        DirectFrag.showSand = false;
                        DirectFrag.showGarber= false;
                        DirectFrag.showWeave = false;
                        DirectFrag.showNorth= false;
                        DirectFrag.showStadium = true;
                        DirectFrag.showNurse = false;
                        DirectFrag.showClark = false;
                        DirectFrag.showHendricks = false;

                        Intent intent = new Intent(GuestActivity.this,DirectFrag.class);
                        startActivity(intent);

                    }
                });
        alertDialog.show();

    }

    public void event2G (View view){
        AlertDialog alertDialog = new AlertDialog.Builder(GuestActivity.this).create();
        alertDialog.setTitle("Artificial Intelligence Lecture");
        alertDialog.setMessage("Learn the basic applications of A.I\n\nThis event is located at Monarch Stadium");
        alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "Return",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "Directory",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                        DirectFrag.showRiddle = false;
                        DirectFrag.showNimmocks = false;
                        DirectFrag.showAllison = false;
                        DirectFrag.showBerns = false;
                        DirectFrag.showTrusted = false;
                        DirectFrag.showCVO = false;
                        DirectFrag.showSand = false;
                        DirectFrag.showGarber= false;
                        DirectFrag.showWeave = false;
                        DirectFrag.showNorth= false;
                        DirectFrag.showStadium = false;
                        DirectFrag.showNurse = false;
                        DirectFrag.showClark = true;
                        DirectFrag.showHendricks = false;

                        Intent intent = new Intent(GuestActivity.this, DirectFrag.class);
                        startActivity(intent);

                    }
                });
        alertDialog.show();

    }

    public void event3G (View view){
        AlertDialog alertDialog = new AlertDialog.Builder(GuestActivity.this).create();
        alertDialog.setTitle("6th Annual CURC Symposium");
        alertDialog.setMessage("Come support the Methodist University undergraduates with their reasearch" +
                "and creativity!\n\nThis event is located in the Hendricks Science Complex and the Nursing Building");
        alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "Return",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "Directory",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                        DirectFrag.showRiddle = false;
                        DirectFrag.showNimmocks = false;
                        DirectFrag.showAllison = false;
                        DirectFrag.showBerns = false;
                        DirectFrag.showTrusted = false;
                        DirectFrag.showCVO = false;
                        DirectFrag.showSand = false;
                        DirectFrag.showGarber= false;
                        DirectFrag.showWeave = false;
                        DirectFrag.showNorth= false;
                        DirectFrag.showStadium = false;
                        DirectFrag.showNurse = true;
                        DirectFrag.showClark = false;
                        DirectFrag.showHendricks = true;

                        Intent intent = new Intent(GuestActivity.this, DirectFrag.class);
                        startActivity(intent);

                    }
                });
        alertDialog.show();

    }

    public void event4G (View view){
        AlertDialog alertDialog = new AlertDialog.Builder(GuestActivity.this).create();
        alertDialog.setTitle("Basketball Game");
        alertDialog.setMessage("Methodist University vs Greensboro\n\n" +
                "This event is located in the Riddle Athletic Center");
        alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "Return",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "Directory",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                        DirectFrag.showRiddle = true;
                        DirectFrag.showNimmocks = false;
                        DirectFrag.showAllison = false;
                        DirectFrag.showBerns = false;
                        DirectFrag.showTrusted = false;
                        DirectFrag.showCVO = false;
                        DirectFrag.showSand = false;
                        DirectFrag.showGarber= false;
                        DirectFrag.showWeave = false;
                        DirectFrag.showNorth= false;
                        DirectFrag.showStadium = false;
                        DirectFrag.showNurse = false;
                        DirectFrag.showClark = false;
                        DirectFrag.showHendricks = false;

                        Intent intent = new Intent(GuestActivity.this, DirectFrag.class);
                        startActivity(intent);

                    }
                });
        alertDialog.show();

    }

    public void event5G (View view){
        AlertDialog alertDialog = new AlertDialog.Builder(GuestActivity.this).create();
        alertDialog.setTitle("Poetry Night");
        alertDialog.setMessage("While words may not fully describe how you feel. Poetry night is a good start!\n\n" +
                "This event is located in the Berns Student Center");
        alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "Return",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "Directory",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                        DirectFrag.showRiddle = false;
                        DirectFrag.showNimmocks = false;
                        DirectFrag.showAllison = false;
                        DirectFrag.showBerns = false;
                        DirectFrag.showTrusted = false;
                        DirectFrag.showCVO = false;
                        DirectFrag.showSand = false;
                        DirectFrag.showGarber= false;
                        DirectFrag.showWeave = false;
                        DirectFrag.showNorth= false;
                        DirectFrag.showStadium = false;
                        DirectFrag.showNurse = true;
                        DirectFrag.showClark = false;
                        DirectFrag.showHendricks = true;

                        Intent intent = new Intent(GuestActivity.this, DirectFrag.class);
                        startActivity(intent);
                    }
                });
        alertDialog.show();

    }

    public void filterEventShow (View view){
        EventFrag.cvFilter = (CardView)findViewById(R.id.card_filter);

        if(ny == 0){
            EventFrag.cvFilter.setVisibility(View.VISIBLE);
            ny +=1;
        }
        else if (ny == 1){
            EventFrag.cvFilter.setVisibility(View.GONE);
            ny -=1;
        }

    }

    public void filterEventGone (View view){
        EventFrag.cvFilter = (CardView)findViewById(R.id.card_filter);
        EventFrag.cvFilter.setVisibility(View.GONE);
    }

    public void filterEventG (View view){
        EventFrag.chkAcaG = (CheckBox)findViewById(R.id.chkAcaG);
        EventFrag.chkFestG = (CheckBox)findViewById(R.id.chkFestG);
        EventFrag.chkOtherG = (CheckBox)findViewById(R.id.chkOtherG);
        EventFrag.chkSportG = (CheckBox)findViewById(R.id.chkSportG);

        EventFrag.cv1G = (CardView) findViewById(R.id.card_view1G);
        EventFrag.cv2G = (CardView) findViewById(R.id.card_view2G);
        EventFrag.cv3G = (CardView) findViewById(R.id.card_view3G);
        EventFrag.cv4G = (CardView) findViewById(R.id.card_view4G);
        EventFrag.cv5G = (CardView) findViewById(R.id.card_view5G);

        EventFrag.searchG = (EditText)findViewById(R.id.searchG);

        if(EventFrag.chkAcaG.isChecked()||EventFrag.chkFestG.isChecked()||
                EventFrag.chkOtherG.isChecked()||EventFrag.chkSportG.isChecked()){
            EventFrag.cv1G.setVisibility(View.GONE);
            EventFrag.cv2G.setVisibility(View.GONE);
            EventFrag.cv3G.setVisibility(View.GONE);
            EventFrag.cv4G.setVisibility(View.GONE);
            EventFrag.cv5G.setVisibility(View.GONE);
        }else {
            EventFrag.cv1G.setVisibility(View.VISIBLE);
            EventFrag.cv2G.setVisibility(View.VISIBLE);
            EventFrag.cv3G.setVisibility(View.VISIBLE);
            EventFrag.cv4G.setVisibility(View.VISIBLE);
            EventFrag.cv5G.setVisibility(View.VISIBLE);
        }

        if(EventFrag.chkSportG.isChecked()){
            EventFrag.cv1G.setVisibility(View.VISIBLE);
            EventFrag.cv4G.setVisibility(View.VISIBLE);
        }

        if(EventFrag.chkFestG.isChecked()){

        }

        if(EventFrag.chkAcaG.isChecked()){
            EventFrag.cv2G.setVisibility(View.VISIBLE);
            EventFrag.cv3G.setVisibility(View.VISIBLE);
            EventFrag.cv5G.setVisibility(View.VISIBLE);
        }

        if(EventFrag.chkOtherG.isChecked()){

        }


        if(EventFrag.searchG.getText().toString()=="Clark"){
            EventFrag.cv3G.setVisibility(View.VISIBLE);
        }


        EventFrag.cvFilter = (CardView)findViewById(R.id.card_filter);
        EventFrag.cvFilter.setVisibility(View.GONE);

    }

}
