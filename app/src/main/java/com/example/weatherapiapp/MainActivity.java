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
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    EditText dataInput;
    ListView lvReport;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getcityID();setById();setByName();
        dataInput = findViewById(R.id.DataInput);
    }

    public void getcityID(){
        Button b = findViewById(R.id.btn_getcityid);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {//WORKING WITH api
                        /* Instantiate the RequestQueue.
                       RequestQueue queue = Volley.newRequestQueue(MainActivity.this);*/
                        String url = "https://api.openweathermap.org/data/2.5/weather?q="+dataInput.getText().toString()+"&appid=d2539c28d2cabd93c3974ad4760320e8";

                        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {

                                String ci = "";

                                try {
                                   //JSONObject cityInfo = response.getJSONObject("coord");
                                   //   ci = cityInfo.getString("lat");

                                    // JSONObject cityInfo = response.getJSONObject("main");
                                    // ci = cityInfo.getString("temp");

                                    //JSONArray CTI = response.getJSONArray("weather");
                                    //ci = CTI.toString();
                                    //Integer CTI = response.getInt("cod");
                                   // ci = CTI.toString();
                                    String CTI = response.getString("id");
                                    ci = CTI.toString();
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }

                                Toast.makeText(MainActivity.this, "city id = "+ci,Toast.LENGTH_LONG).show();

                                // Toast.makeText(MainActivity.this, response.toString(),Toast.LENGTH_LONG).show();

                            }
                        }, new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Toast.makeText(MainActivity.this, "Something Wrong",Toast.LENGTH_LONG).show();
                            }
                        });
                        MySingleton.getInstance(MainActivity.this).addToRequestQueue(request);
                        //the singleton handles multiple things happening at the same time in sequential order
                        //i think this gets every request in order from a class and adds it to a queue
                        //queue.add(request);
//                // Request a string response from the provided URL.
//                StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
//                        new Response.Listener<String>() {
//                            @Override
//                            public void onResponse(String response) {
//                                Toast.makeText(MainActivity.this, response,Toast.LENGTH_LONG).show();
//                            }
//                        }, new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//                        Toast.makeText(MainActivity.this, "ERROR OCCURED",Toast.LENGTH_LONG).show();
//                    }
//                });
                        // Add the request to the RequestQueue.
                        //queue.add(stringRequest);
                    }
                });
    }
    public void setById(){
        Button b = findViewById(R.id.btn_getweatherbycityid);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"yes",Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void setByName(){
        Button b = findViewById(R.id.btn_getWeatherByCityName);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"yeP",Toast.LENGTH_SHORT).show();
            }
        });
    }

}