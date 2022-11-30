package kth.etka.weather.parser;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import kth.etka.weather.MainActivity;
import kth.etka.weather.R;
import kth.etka.weather.list.WeatherAdapter;
import kth.etka.weather.list.WeatherInfo;
import kth.etka.weather.list.WeatherList;;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


//Based on

public class parser {

    private static final String
            approved_t = "approvedTime",
            reference_t = "referenceTime",
            timeseries = "timeSeries",
            valid_t = "validTime",
            param = "parameters",
            names = "name",
            value = "values",
            temperature = "t",
            cloud_cover = "tcc_mean",
            longitude = "Lon",
            latitude = "Lat";


    public static void Weather (JSONObject weather) throws JSONException {

        String approved = weather.getString(approved_t);
        String reference = weather.getString(reference_t);

        String approvedDate = approved.substring(0,10);
        String approvedTime = approved.substring(11,16);

        JSONArray timeSeries = weather.getJSONArray(timeseries);

        List<WeatherInfo> weatherList;
        WeatherList.setApprDate(approvedDate);
        WeatherList.setApprTime(approvedTime);
        weatherList = WeatherList.getInstance();

        for (int i = 0; i < timeSeries.length(); i++) {
            JSONObject timeS = timeSeries.getJSONObject(i);
            String valid = timeS.getString(valid_t);

            JSONArray weatherAtX = timeS.getJSONArray(param);

            String validDate = valid.substring(0, 10);
            String validTime = valid.substring(11, 16);
            System.out.println(validDate + " " + validTime);

            String temper = null;
            String cloudCover = null;
            for (int j = 0; j < weatherAtX.length(); j++) {
                JSONObject parameters = weatherAtX.getJSONObject(j);
                String name = parameters.getString(names);
                JSONArray Values = parameters.getJSONArray(value);

                if (name.equals(temperature)) {
                    System.out.println(temperature);
                    temper = String.valueOf(Values);
                    temper = temper.substring(1, temper.length() - 1) + " °C";
                    System.out.println(temper);
                }
                if (name.equals(cloud_cover)) {
                    System.out.println(cloud_cover);
                    cloudCover = String.valueOf(Values);
                    cloudCover = cloudCover.substring(1, cloudCover.length() - 1) + " Octas";
                    System.out.println(cloudCover);
                }
            }
            weatherList.add(new WeatherInfo(validDate, validTime, temper, cloudCover));
        }

        WeatherList.setReady();

    }

}



