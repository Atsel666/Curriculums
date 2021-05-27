package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.myapp.models.CurriculumVitae;
import com.google.gson.Gson;

public class Axel extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_axel);

        TextView txtName = findViewById(R.id.textNameA);
        TextView txtBio = findViewById(R.id.textBioA);
        TextView txtPrepa = findViewById(R.id.textPrepaA);
        TextView txtUni = findViewById(R.id.textUniA);
        TextView txtIngles = findViewById(R.id.textInglesA);
        TextView txtSkills = findViewById(R.id.textSkillsA);
        Button btnBack = findViewById(R.id.btnBackA);

        RequestQueue queue = Volley.newRequestQueue(this);
        String url;

        StringRequest sr = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                CurriculumVitae cv = new Gson().fromJson(response.toString(), CurriculumVitae.class);
                txtName.setText(cv.name);
                txtBio.setText(cv.bio);
                txtPrepa.setText(cv.prepa);
                txtUni.setText(cv.uni);
                txtIngles.setText(cv.ingles);
                txtSkills.setText(cv.Skills);
                btnBack.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(Axel.this, MainActivity.class));
                    }
                });

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("weather-request-error,",error.getMessage());
            }
        });
        queue.add(sr);
    }
}