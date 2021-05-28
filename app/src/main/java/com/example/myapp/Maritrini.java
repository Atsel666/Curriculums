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

public class Maritrini extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maritrini);

        TextView txtName = findViewById(R.id.textNameM);
        TextView txtBio = findViewById(R.id.textBioM);
        TextView txtPrepa = findViewById(R.id.textPrepaM);
        TextView txtUni = findViewById(R.id.textUniM);
        TextView txtIngles = findViewById(R.id.textInglesM);
        TextView txtSkills = findViewById(R.id.textSkillsM);
        //Button btnBackM = findViewById(R.id.btnBackM);

        RequestQueue queue = Volley.newRequestQueue(this);
        String url="http://1bbfd736ae81.ngrok.io/329675";

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
                /*btnBackM.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(Maritrini.this, MainActivity.class));
                    }
                });*/

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