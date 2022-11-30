package kth.etka.weather.list;

import java.util.ArrayList;
import java.util.List;

public class WeatherList {
    public static List<WeatherInfo> weatherInfoList;
    public static boolean isReady;
<<<<<<< HEAD
    public static String apprDate;
    public static String apprTime;
=======
>>>>>>> f67ccaa4af99852ee979ee656d674507339401f3

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

<<<<<<< HEAD
    public static void setApprDate(String date) {
        apprDate = date;
    }

    public static String getApprDate() {
        return apprDate;
    }

    public static void setApprTime(String time) {
        apprTime = time;
    }

    public static String getApprTime() {
        return apprTime;
    }

    public static int listIsReady() {
        if (isReady) {
            return 1;
        } else {
            return 0;
        }
    }
=======
    public static boolean listIsReady() {
        if (isReady) {
            return true;
        } else {
            return false;
        }
    }

    public void addWeather(WeatherInfo weather) {

    }
>>>>>>> f67ccaa4af99852ee979ee656d674507339401f3
}
