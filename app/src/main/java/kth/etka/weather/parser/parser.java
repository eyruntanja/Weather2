package kth.etka.weather.parser;

import android.widget.ArrayAdapter;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

import kth.etka.weather.MainActivity;

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
        //String JSON_STRING = "{\"employee\":{\"name\":\"Abhishek Saini\",\"salary\":65000}}";

        String approved = weather.getString(approved_t);
        String reference = weather.getString(reference_t);

        JSONArray timeSeries = weather.getJSONArray(timeseries);

        for (int i = 0; i < timeSeries.length(); i++){
            JSONObject timeS = timeSeries.getJSONObject(i);
            String valid = timeS.getString(valid_t);

            JSONArray weatherAtX = timeS.getJSONArray(param);

            //TODO: print the time to the array
            String validDate = valid.substring(0,10);
            String validTime = valid.substring(11,16);
            System.out.println(validDate + " " + validTime);

            for (int j = 0; j < weatherAtX.length(); j++){
                JSONObject parameters = weatherAtX.getJSONObject(j);
                String name = parameters.getString(names);
                JSONArray Values = parameters.getJSONArray(value);

                //do we need the if statements?

                String temper;
                String cloudCover;

                if (name.equals(temperature)) {
                    //TODO: print temperature to array
                    System.out.println(temperature);
                    temper = String.valueOf(Values);
                    temper = temper.substring(1,temper.length()-1)+ " °C";
                    System.out.println(temper);
                }else if (name.equals(cloud_cover)){
                    //TODO: print cloud coverage to array
                    System.out.println(cloud_cover);
                    cloudCover = String.valueOf(Values);
                    cloudCover = cloudCover.substring(1,cloudCover.length()-1)+ " Octas";
                    System.out.println(cloudCover);
                }else{
                    //TODO: Something?
                }

            }

            //wheatherList.add(new WeatherInfo(valid,))

        }

    }

}



