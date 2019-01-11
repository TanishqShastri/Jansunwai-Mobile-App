package com.example.tanishqshastri_mppolice.jansunwai;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class StatusPage extends AppCompatActivity {

    private static final String complaint_URL = "https://tshastri07.000webhostapp.com/statusdata.php";

    RecyclerView recyclerView;
    complaintAdapter adapter;

    List<complaint> complaintList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status_page);

        complaintList = new ArrayList<>();

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        loadcomplaint();

        //Fetching id and key from shared preferences
        SharedPreferences sharedPreferences = getSharedPreferences(sharedpreferences.SHARED_PREF_NAME, Context.MODE_PRIVATE);
        String id = sharedPreferences.getString(sharedpreferences.ID_SHARED_PREF,"Not Available");
        String key = sharedPreferences.getString(sharedpreferences.KEY_SHARED_PREF,"Not Available");

    }

    private void loadcomplaint() {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, complaint_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray complaint = new JSONArray(response);

                    for (int i = 0; i < complaint.length(); i++) {
                        JSONObject complaintobject = complaint.getJSONObject(i);

                        String id = complaintobject.getString("applications.application_id");
                        String name = complaintobject.getString("applications.applicant_name");
                        String aadhaar = complaintobject.getString("applications.applicant_aadhaar");
                        String phone = complaintobject.getString("applications.applicant_phone");
                        String subject = complaintobject.getString("applications.subject");
                        String date = complaintobject.getString("applications.date");
                        String description = complaintobject.getString("applications.description");
                        String chairpersonRemark = complaintobject.getString("applications.chairperson_remark");
                        String ApplicationStatus = complaintobject.getString("applications.status");
                        String officername = complaintobject.getString("officer_accounts.name_of_officer");
                        String officerRemark = complaintobject.getString("applications.officer_remark");
                        String lastupdate = complaintobject.getString("applications.last_update_on");

                        complaint complaint1 = new complaint(id, name, aadhaar, phone, subject, date, description, chairpersonRemark, ApplicationStatus, officername, officerRemark, lastupdate);

                        complaintList.add(complaint1);
                    }
                    adapter = new complaintAdapter(StatusPage.this, complaintList);
                    recyclerView.setAdapter(adapter);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(StatusPage.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

        Volley.newRequestQueue(this).add(stringRequest);
    }

}