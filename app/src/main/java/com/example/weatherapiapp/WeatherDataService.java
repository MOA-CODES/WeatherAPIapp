package com.example.weatherapiapp;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class WeatherDataService {

    public static final String QUERY_FOR_ID_1 = "https://api.openweathermap.org/data/2.5/weather?q=";
    public static final String QUERY_FOR_ID_2 = "&appid=d2539c28d2cabd93c3974ad4760320e8";
    public static final String QUERY_FOR_FORECAST_BY_ID_1 = "https://api.openweathermap.org/data/2.5/weather?id=";
    public static final String QUERY_FOR_FORECAST_BY_ID_2 = "&appid=d2539c28d2cabd93c3974ad4760320e8";

    String cityID;
    Context context;

    public WeatherDataService(Context context) {
        this.context = context;
    }

    public interface VolleyResponseListener {//call back
        void onError(String message);

        void onResponse(String cityID);
    }

    public void getCityID(String cityName,VolleyResponseListener VRl){
        String url = QUERY_FOR_ID_1+cityName+QUERY_FOR_ID_2;

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                cityID = "";

                try {
                    String CTI = response.getString("id");
                    cityID = CTI.toString();
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                //Toast.makeText(context, "city id = "+cityID,Toast.LENGTH_LONG).show();
                VRl.onResponse(cityID);//callback
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
              //  Toast.makeText(context, "Something Wrong",Toast.LENGTH_LONG).show();
                VRl.onError("Something Wrong");//callback
            }
        });
        MySingleton.getInstance(context).addToRequestQueue(request);

        //returned a Null problem
       // return cityID;
    }


    public void getCityForecastByID(String cityID){
        String url = QUERY_FOR_FORECAST_BY_ID_1+cityID+QUERY_FOR_FORECAST_BY_ID_2;

        List<WeatherReportModel> report= new ArrayList<> ();
        //get the json object
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Toast.makeText(context, response.toString(),Toast.LENGTH_LONG).show();

                try {
                    JSONArray weather = response.getJSONArray("weather");
                    WeatherReportModel model1 = new WeatherReportModel();


                   // model1.setCoord();




                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        MySingleton.getInstance(context).addToRequestQueue(request);

        //get each property and assign to a weather report object


    }



//    public List<WeatherReportModel> getCityForecastByName(String cityName){
//
//    }

}
