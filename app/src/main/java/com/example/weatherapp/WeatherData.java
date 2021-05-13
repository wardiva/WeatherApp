package com.example.weatherapp;

import org.json.JSONException;
import org.json.JSONObject;

public class WeatherData<Getter> {

    private String mTemperature, mIcon, mCity, mWeatherType;
    private int mCondition;

    public static WeatherData fromJson(JSONObject jsonObject){
        try {
            WeatherData WeatherD= new WeatherData();
            WeatherD.mCity= jsonObject.getString("name");
            WeatherD.mCondition=jsonObject.getJSONArray("weather").getJSONObject(0).getInt("id");
            WeatherD.mWeatherType=jsonObject.getJSONArray("weather").getJSONObject(0).getString("main");
            WeatherD.mIcon=UpdateWeatherIcon(WeatherD.mCondition);
            double tempResult=jsonObject.getJSONObject("main").getDouble("temp")-273.15;
            int roundedValue=(int)Math.rint(tempResult);
            WeatherD.mTemperature= Integer.toString(roundedValue);
            return WeatherD;
        }
        catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static String UpdateWeatherIcon(int condition){
        if (condition>=0 && condition<=300){
            return "thunderstorm";
        }
        else if (condition>=300 && condition<=500){
            return "light_rain";
        }
        else if (condition>=500 && condition<=600){
            return "shower_icon";
        }
        else if (condition>=600 && condition<=700){
            return "snow_icon";
        }
        else if (condition>=701 && condition<=771){
            return "fog_icon";
        }
        else if (condition>=772 && condition<=800){
            return "overcast_icon";
        }
        else if (condition==800){
            return "sunny_icon";
        }
        else if (condition>=801 && condition<=804){
            return "cloudy_icon";
        }
        else if (condition>=900 && condition<=902){
            return "light_thunderstorm";
        }
        else if (condition==903){
            return "light_snow";
        }
        else if (condition==904){
            return "sunny2_icon";
        }
        else if (condition>=905 && condition<=1000){
            return "thunder2_icon";
        }

        return "Don't Know";
    }

    public String getmTemperature() {
        return mTemperature+"°C";
    }

    public String getmIcon() {
        return mIcon;
    }

    public String getmCity() {
        return mCity;
    }

    public String getmWeatherType() {
        return mWeatherType;
    }
}
