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
//hmm
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

    public interface VRL_FORECAST_BY_ID {//call back
        void onError(String message);

        void onResponse(WeatherReportModel wrm);
    }

    public void getCityForecastByID(String cityID, VRL_FORECAST_BY_ID VRL){
        String url = QUERY_FOR_FORECAST_BY_ID_1+cityID+QUERY_FOR_FORECAST_BY_ID_2;

        List<WeatherReportModel> report= new ArrayList<> ();
        //get the json object
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
              //  Toast.makeText(context, response.toString(),Toast.LENGTH_LONG).show();

                try {
                    //JSONObject weather = response.getJSONObject("weather");
                    WeatherReportModel model1 = new WeatherReportModel();

                    model1.setCoord(response.getJSONObject("coord"));
                    model1.setWeather(response.getJSONArray("weather"));
                    model1.setBase(response.getString("base"));
                    model1.setVisibility(response.getInt("visibility"));
                    model1.setWind(response.getJSONObject("wind"));
                    model1.setClouds(response.getJSONObject("clouds"));
                    model1.setDt(response.getInt("dt"));
                    model1.setSys(response.getJSONObject("sys"));
                    model1.setTimezone(response.getInt("timezone"));
                    model1.setId(response.getInt("id"));
                    model1.setName(response.getString("name"));
                    model1.setCod(response.getInt("cod"));

                    VRL.onResponse(model1);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VRL.onError("SOMETHING WRONG");
            }
        });

        MySingleton.getInstance(context).addToRequestQueue(request);

        //get each property and assign to a weather report object


    }



//    public List<WeatherReportModel> getCityForecastByName(String cityName){
//
//    }

}
