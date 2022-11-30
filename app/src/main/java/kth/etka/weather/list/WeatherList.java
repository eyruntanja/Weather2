package kth.etka.weather.list;

import java.util.ArrayList;
import java.util.List;

public class WeatherList {
    public static List<WeatherInfo> weatherInfoList;
    public static boolean isReady;

    // private constructor to force the use of getInstance() to get an/the object
    private WeatherList() {
    }

    public static List<WeatherInfo> getInstance() {
        if (weatherInfoList == null)
            weatherInfoList = new ArrayList<>();
        return weatherInfoList;
    }

    public static void setReady() {
        isReady = true;
    }

    public static boolean listIsReady() {
        if (isReady) {
            return true;
        } else {
            return false;
        }
    }

    public void addWeather(WeatherInfo weather) {

    }
}
