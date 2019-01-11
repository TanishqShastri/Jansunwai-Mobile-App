package com.example.tanishqshastri_mppolice.jansunwai;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class login extends AppCompatActivity {

    EditText applicantKeyET, applicationIdET;

    //Keys for Sharedpreferences
    //This would be the name of our shared preferences
    public static final String SHARED_PREF_NAME = "jansunwaiapp";

    //This would be used to store the id of current logged in user
    public static final String ID_SHARED_PREF = "id";

    //This would be used to store the key of current logged in user
    public static final String KEY_SHARED_PREF = "key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        applicantKeyET = findViewById(R.id.ETapplicationKey);
        applicationIdET = findViewById(R.id.ETapplicationid);


    }

    public void onLogin(View view) throws NoSuchAlgorithmException {

        String applicantKey = applicantKeyET.getText().toString();
        String applicantionId = applicationIdET.getText().toString();

        MessageDigest md = MessageDigest.getInstance("SHA-512");
        md.update(applicantKey.getBytes());

        byte byteData[] = md.digest();

        //convert the byte to hex format method 2
        StringBuffer KeyhexString = new StringBuffer();
        for (byte aByteData : byteData) {
            String hex = Integer.toHexString(0xff & aByteData);
            if (hex.length() == 1) KeyhexString.append('0');
            KeyhexString.append(hex);
        }

        String keyHex = KeyhexString.toString();

        //Creating a shared preference
        SharedPreferences sharedPreferences = login.this.getSharedPreferences(sharedpreferences.SHARED_PREF_NAME, Context.MODE_PRIVATE);

        //Creating editor to store values to shared preferences
        SharedPreferences.Editor editor = sharedPreferences.edit();

        //Adding values to editor
        editor.putString(sharedpreferences.ID_SHARED_PREF, applicantionId);
        editor.putString(sharedpreferences.KEY_SHARED_PREF, keyHex);

        //Saving values to editor
        editor.apply();

        String type = "login";
        BackgroundWorker backgroundWorker = new BackgroundWorker(this);
        backgroundWorker.execute(type, keyHex, applicantionId);

    }
}