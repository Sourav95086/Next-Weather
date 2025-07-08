package com.nextgenius.nextweather;

import com.google.gson.annotations.SerializedName;

public class ModalClass {


    @SerializedName("main")
    public Main main;
    @SerializedName("wind")
    public wind wind;
    @SerializedName("weather")
    public Weather[] weathers;

    public wind getWind() {
        return wind;
    }

    public void setWind(wind wind) {
        this.wind = wind;
    }

    @SerializedName("name")
    public String citiname;

    public Weather[] getWeathers() {
        return weathers;
    }


    public void setWeathers(Weather[] weathers) {
        this.weathers = weathers;
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public String getCitiname() {
        return citiname;
    }

    public void setCitiname(String citiname) {
        this.citiname = citiname;
    }


    public ModalClass(Main main, com.nextgenius.nextweather.wind wind, Weather[] weathers, String citiname) {
        this.main = main;
        this.wind = wind;
        this.weathers = weathers;
        this.citiname = citiname;
    }
}
class Main{
    @SerializedName("temp")
    public double temperature;
    @SerializedName("feels_like")
    public double feel_like;
    @SerializedName("temp_min")
    public double min_temp;
    @SerializedName("temp_max")
    public double max_temp;
    @SerializedName("humidity")
    public int humidity;
}
class Weather{
    @SerializedName("description")
    public String description;
}
class wind{

    @SerializedName("speed")
    public double windspeed;
}