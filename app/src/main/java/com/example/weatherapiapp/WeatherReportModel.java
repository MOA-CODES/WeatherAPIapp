package com.example.weatherapiapp;

import org.json.JSONArray;
import org.json.JSONObject;

public class WeatherReportModel {
//    "coord":{"lon":3.75,"lat":6.5833}, //JSON OBJECT
//            "weather":[{"id":804,"main":"Clouds","description":"overcast clouds","icon":"04n"}],//JSON array
//            "base":"stations",//string
//            "main":{"temp":297.33,"feels_like":298.02,"temp_min":297.33,"temp_max":297.33,"pressure":1013,"humidity":85,"sea_level":1013,"grnd_level":1013},
//            "visibility":10000,//JSON int
//            "wind":{"speed":2.65,"deg":216,"gust":5.95},
//            "clouds":{"all":88},
//            "dt":1657649596,
//            "sys":{"type":1,"id":1185,"country":"NG","sunrise":1657604166,"sunset":1657649081},
//            "timezone":3600,
//            "id":2332453,
//            "name":"Lagos",
//            "cod":200
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

    @Override
    public String toString() {

        return "name="+name;
// calm down      return "WeatherReportModel{" +
//                "coord=" + coord +
//                ", weather=" + weather +
//                ", base='" + base + '\'' +
//                ", main=" + main +
//                ", visibility=" + visibility +
//                ", wind=" + wind +
//                ", clouds=" + clouds +
//                ", dt=" + dt +
//                ", sys=" + sys +
//                ", timezone=" + timezone +
//                ", id=" + id +
//                ", name='" + name + '\'' +
//                ", cod=" + cod +
//                '}';
    }

    public JSONObject getCoord() {
        return coord;
    }

    public void setCoord(JSONObject coord) {
        this.coord = coord;
    }

    public JSONArray getWeather() {
        return weather;
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
