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
//hmm
public class MainActivity extends AppCompatActivity {
    EditText dataInput;
    ListView lvReport;
   final WeatherDataService WDS = new WeatherDataService(MainActivity.this);

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
            public void onClick(View view) {


                //this doesnt return anything
               WDS.getCityID(dataInput.getText().toString(), new WeatherDataService.VolleyResponseListener() {
                   //the volleyresponse listener is an interface with two functions that have one parameter each, so they get those
                   //values from the weatherdataservice classes and we use them here
                   @Override
                   public void onError(String message) {
                       Toast.makeText(MainActivity.this, message,Toast.LENGTH_LONG).show();
                   }

                   @Override
                   public void onResponse(String cityID) {
                       Toast.makeText(MainActivity.this, "returned an id of= "+cityID,Toast.LENGTH_LONG).show();
                   }
               });


            }
                });
    }
    public void setById(){
        Button b = findViewById(R.id.btn_getweatherbycityid);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WDS.getCityForecastByID(dataInput.getText().toString(), new WeatherDataService.VRL_FORECAST_BY_ID() {
                    @Override
                    public void onError(String message) {
                        Toast.makeText(MainActivity.this,message,Toast.LENGTH_LONG).show();

                    }

                    @Override
                    public void onResponse(WeatherReportModel wrm) {
                        Toast.makeText(MainActivity.this, wrm.getName().toString(),Toast.LENGTH_LONG).show();
                    }
                });


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