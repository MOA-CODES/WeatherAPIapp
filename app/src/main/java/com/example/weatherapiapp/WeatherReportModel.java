package com.example.weatherapiapp;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class WeatherReportModel {
    private JSONObject coord;
    private JSONArray weather;
    private String base;
    private JSONObject main;
    private int visibility;
    private JSONObject wind;
    private JSONObject clouds;
    private int dt;
    private JSONObject sys;
    private int timezone;
    private int id;
    private String name;
    private int cod;

    public WeatherReportModel() {
    }

    public WeatherReportModel(JSONObject coord, JSONArray weather, String base, JSONObject main, int visibility, JSONObject wind, JSONObject clouds, int dt, JSONObject sys, int timezone, int id, String name, int cod) {
        this.coord = coord;
        this.weather = weather;
        this.base = base;
        this.main = main;
        this.visibility = visibility;
        this.wind = wind;
        this.clouds = clouds;
        this.dt = dt;
        this.sys = sys;
        this.timezone = timezone;
        this.id = id;
        this.name = name;
        this.cod = cod;
    }


    public String toString() {

      //  return "name="+name;
 /*calm down */
       try {
            return "WeatherReport for "+name+"\n" +
                          "\nID = " + id +
                          "\nCountry = " + sys.getString("country") +
                          "\nTimezone = " + timezone +
                          "\nTemperature = " + main.getString("temp") +
                       "\nVisibility = " + visibility +
                          "\nWeather Main = " +getWeather().getString("main")+
                        "\nWeather Description = " +getWeather().getString("description")+
                          "\nWind = " + wind +
                          "\nCoordinates = " + coord +
                           '\n';
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return "null";
    }

    public JSONObject getCoord() {
        return coord;
    }

    public void setCoord(JSONObject coord) {
        this.coord = coord;
    }

    public JSONObject getWeather() throws JSONException {
        return weather.getJSONObject(0);
    }

    public void setWeather(JSONArray weather) {
        this.weather = weather;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public JSONObject getMain() {
        return main;
    }

    public void setMain(JSONObject main) {
        this.main = main;
    }

    public int getVisibility() {
        return visibility;
    }

    public void setVisibility(int visibility) {
        this.visibility = visibility;
    }

    public JSONObject getWind() {
        return wind;
    }

    public void setWind(JSONObject wind) {
        this.wind = wind;
    }

    public JSONObject getClouds() {
        return clouds;
    }

    public void setClouds(JSONObject clouds) {
        this.clouds = clouds;
    }

    public int getDt() {
        return dt;
    }

    public void setDt(int dt) {
        this.dt = dt;
    }

    public JSONObject getSys() {
        return sys;
    }

    public void setSys(JSONObject sys) {
        this.sys = sys;
    }

    public int getTimezone() {
        return timezone;
    }

    public void setTimezone(int timezone) {
        this.timezone = timezone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }
}
