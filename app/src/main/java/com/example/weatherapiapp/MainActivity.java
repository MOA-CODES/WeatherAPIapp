package com.example.weatherapiapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity {
    Button cityId, byId, byName;
    EditText dataInput;
    ListView lvReport;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cityId = findViewById(R.id.btn_getcityid);
        byId = findViewById(R.id.btn_getweatherbycityid);
        byName = findViewById(R.id.btn_getWeatherByCityName);
        dataInput = findViewById(R.id.DataInput);
        lvReport = findViewById(R.id.lv_weatherReport);

        cityId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {//WORKING WITH api
                // Instantiate the RequestQueue.
                RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
                String url = "https://api.openweathermap.org/data/2.5/weather?q=London&appid=d2539c28d2cabd93c3974ad4760320e8";

                // Request a string response from the provided URL.
                StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                Toast.makeText(MainActivity.this, response,Toast.LENGTH_LONG).show();
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this, "ERROR OCCURED",Toast.LENGTH_LONG).show();
                    }
                });
                // Add the request to the RequestQueue.
                queue.add(stringRequest);
            }
        });
        byId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"yes",Toast.LENGTH_SHORT).show();
            }
        });
        byName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"yeet",Toast.LENGTH_SHORT).show();
            }
        });

    }

   /* public void cityID(){
        Button b = findViewById(R.id.btn_getcityid);
    }*/

}