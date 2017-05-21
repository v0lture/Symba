package com.example.deangelogrant.symba;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;

/**
 * Created by Elvin on 3/28/2017.
 */

public class loading extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loading);

    }

    public void next (View view){
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
    public void guestNext(View view) {
        Intent intent = new Intent(this, GuestActivity.class);
        startActivity(intent);
    }
}
