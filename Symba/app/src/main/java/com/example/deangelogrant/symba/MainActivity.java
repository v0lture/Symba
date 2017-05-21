package com.example.deangelogrant.symba;

import android.app.Fragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.CardView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    public Fragment guestevents;
    public Fragment guestdirect;
    public Fragment guestinfo;
    public Fragment guestcontact;
    public Fragment mainfrag;
    public Fragment classfrag;
    public Fragment class2frag;
    public LinearLayout removebox;
    public android.app.FragmentTransaction ft;
    public CheckBox checkbox1;
    public CheckBox checkbox2;
    public CheckBox checkbox3;
    public CheckBox checkbox4;
    public TextView class1;
    public TextView class1sub;
    public TextView class2;
    public TextView class2sub;
    public TextView class3;
    public TextView class3sub;
    public TextView class4;
    public TextView class4sub;
    public Fragment searchfrag;
    public LinearLayout csclayout;
    public TextView cscHeader;

    public int boxes = 0;

    public int cscNY = 0;
    public int engNY = 0;
    public int sciNY = 0;

    public static int class1int = 0;
    public static int class2int = 0;
    public static int class3int = 0;
    public static int class4int = 0;
    public static int class5int = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
            mainfrag = new MainFrag();
            ft = getFragmentManager().beginTransaction();
            ft.add(R.id.fragcontainer, mainfrag);
            ft.commit();
        } else {
            mainfrag = new MainFrag();
            ft = getFragmentManager().beginTransaction();
            ft.replace(R.id.fragcontainer, mainfrag);
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
        getMenuInflater().inflate(R.menu.main, menu);
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
            AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
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
        } else if (id == R.id.action_logout) {
            AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
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
        }else if( id == R.id.action_help){
            AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
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
        } else if (id == R.id.nav_directory){
            Intent intent = new Intent(this, DirectFrag.class);
            startActivity(intent);
        } else if (id == R.id.nav_info) {
            guestinfo = new InfoFrag();
            ft = getFragmentManager().beginTransaction();
            ft.replace(R.id.fragcontainer, guestinfo);
            ft.addToBackStack(null);
            ft.commit();
        }else if (id == R.id.nav_classes) {
            classfrag = new ClassFrag();
            ft = getFragmentManager().beginTransaction();
            ft.replace(R.id.fragcontainer, classfrag);
            ft.addToBackStack(null);
            ft.commit();
        } else if (id == R.id.nav_help) {
            AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
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
        } else if (id == R.id.nav_logout) {
            AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
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
        } else if (id == R.id.nav_exit) {
            AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
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

    public void floatbtn (View view) {
        AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
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

    public void academicDialog(View view){
        AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
        alertDialog.setTitle("Academic Event");
        alertDialog.setMessage("This event is happening in Trustees Room 212");
        alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "Back",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "Directory",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
    }

    public void culturalDialog(View view){
        AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
        alertDialog.setTitle("Cultural Event");
        alertDialog.setMessage("This event is happening in the Green and Gold Dining Hall");
        alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "Back",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "Directory",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
    }

    public void sportDialog(View view){
        AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
        alertDialog.setTitle("Sports Event");
        alertDialog.setMessage("This event is happening in Monarch Stadium");
        alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "Back",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "Directory",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
    }

    public void generalPhone(View view) {
        AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
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
        AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
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
        AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
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
                        callIntent.setData(Uri.parse("tel:(910)-630-6132"));
                        startActivity(callIntent);
                    }
                });
        alertDialog.show();
    }

    public void searchbtn(View view){
        searchfrag = new SearchFrag();
        ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.fragcontainer, searchfrag);
        ft.addToBackStack(null);
        ft.commit();
    }

    public void returnbtn(View view){

        AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
        alertDialog.setTitle("Confirm");
        alertDialog.setMessage("Return to Student Menu? ");
        alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "No",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "Yes",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {


                        class2frag = new Class2Frag();
                        ft = getFragmentManager().beginTransaction();
                        ft.replace(R.id.fragcontainer, class2frag);
                        ft.addToBackStack(null);
                        ft.commit();
                    }
                });
        alertDialog.show();
    }

    public void addclass (View view){

        AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
        alertDialog.setTitle("Confirm");
        alertDialog.setMessage("Add the selected course(s) ");
        alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "No",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "Yes",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
    }


    public void filterEventShowM (View view){
        EventFrag.cvFilter = (CardView)findViewById(R.id.card_filter);
        EventFrag.cvFilter.setVisibility(View.VISIBLE);
    }

    public void filterEventGoneM (View view){
        EventFrag.cvFilter = (CardView)findViewById(R.id.card_filter);
        EventFrag.cvFilter.setVisibility(View.GONE);
    }

    public void removeClass(View view){
        ClassFrag.class1 = (CardView)findViewById(R.id.card_class1);
        ClassFrag.class2 = (CardView)findViewById(R.id.card_class2);
        ClassFrag.class3 = (CardView)findViewById(R.id.card_class3);
        ClassFrag.class4 = (CardView)findViewById(R.id.card_class4);

        ClassFrag.chkClass1B = (CheckBox) findViewById(R.id.chkClass1);
        ClassFrag.chkClass2B = (CheckBox) findViewById(R.id.chkClass2);
        ClassFrag.chkClass3B = (CheckBox) findViewById(R.id.chkClass3);
        ClassFrag.chkClass4B = (CheckBox) findViewById(R.id.chkClass4);

        ClassFrag.minHours = (TextView)findViewById(R.id.minHoursTV);

        if(boxes == 0){

            ClassFrag.chkClass1B.setVisibility(View.VISIBLE);
            ClassFrag.chkClass2B.setVisibility(View.VISIBLE);
            ClassFrag.chkClass3B.setVisibility(View.VISIBLE);
            ClassFrag.chkClass4B.setVisibility(View.VISIBLE);

            boxes +=1;
        }
        else if (boxes == 1){

                AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
                alertDialog.setTitle("Confirm");
                alertDialog.setMessage("Are you sure you want to remove the selected course(s)? ");
                alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "No",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "Confirm",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                ClassFrag.minHours.setVisibility(View.VISIBLE);

                                if(ClassFrag.chkClass1B.isChecked()){
                                    ClassFrag.class1.setVisibility(View.GONE);
                                    class1int =1;
                                }

                                if(ClassFrag.chkClass2B.isChecked()){
                                    ClassFrag.class2.setVisibility(View.GONE);
                                    class2int =1;
                                }

                                if(ClassFrag.chkClass3B.isChecked()){
                                    ClassFrag.class3.setVisibility(View.GONE);
                                    class3int =1;
                                }

                                if(ClassFrag.chkClass4B.isChecked()){
                                    ClassFrag.class4.setVisibility(View.GONE);
                                    class4int =1;
                                }
                            }
                        });
                alertDialog.show();




            ClassFrag.chkClass1B.setVisibility(View.GONE);
            ClassFrag.chkClass2B.setVisibility(View.GONE);
            ClassFrag.chkClass3B.setVisibility(View.GONE);
            ClassFrag.chkClass4B.setVisibility(View.GONE);


            boxes -=1;
        }
    }

    public void cscClass (View view ){
        SearchFrag.cscTV = (TextView)findViewById(R.id.cscTV);
        SearchFrag.cscScroll = (ScrollView)findViewById(R.id.cscScroll);

        if (cscNY == 0){
            cscNY +=1;

            SearchFrag.cscTV.setText("Computer Science V");

            SearchFrag.cscScroll.setVisibility(View.VISIBLE);
        }
        else if (cscNY == 1){
            cscNY -=1;


            SearchFrag.cscTV.setText("Computer Science >");

            SearchFrag.cscScroll.setVisibility(View.GONE);
        }
    }

    public void engClass (View view ){
        SearchFrag.engTV = (TextView)findViewById(R.id.engTV);
        SearchFrag.engScroll = (ScrollView)findViewById(R.id.engScroll);

        if (engNY == 0){
            engNY +=1;

            SearchFrag.engTV.setText("English V");

            SearchFrag.engScroll.setVisibility(View.VISIBLE);
        }
        else if (engNY == 1){
            engNY -=1;


            SearchFrag.engTV.setText("English >");

            SearchFrag.engScroll.setVisibility(View.GONE);
        }
    }

    public void sciClass (View view ){
        SearchFrag.sciTV = (TextView)findViewById(R.id.sciTV);
        SearchFrag.sciScroll = (ScrollView)findViewById(R.id.sciScroll);

        if (sciNY == 0){
            sciNY +=1;

            SearchFrag.sciTV.setText("Science V");

            SearchFrag.sciScroll.setVisibility(View.VISIBLE);
        }
        else if (sciNY == 1){
            sciNY -=1;


            SearchFrag.sciTV.setText("Science >");

            SearchFrag.sciScroll.setVisibility(View.GONE);
        }
    }

}
