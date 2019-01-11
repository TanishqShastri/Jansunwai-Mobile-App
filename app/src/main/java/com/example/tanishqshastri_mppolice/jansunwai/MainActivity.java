package com.example.tanishqshastri_mppolice.jansunwai;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;



import java.util.Locale;

import io.paperdb.Paper;

import static android.content.Context.MODE_PRIVATE;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }


    public void openlogin(View view) {
        Intent i = new Intent(this, login.class);
        startActivity(i);
    }

    public void openhelpline(View view) {
        Intent i = new Intent(this, helpline.class);
        startActivity(i);
    }

    public void openaboutus(View view) {
        Intent i = new Intent(this, AboutUs.class);
        startActivity(i);
    }
}
