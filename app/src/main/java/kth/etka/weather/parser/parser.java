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
            System.out.println(valid);



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
                    temper = J;
                    System.out.println(temper);
                }else if (name.equals(cloud_cover)){
                    //TODO: print cloud coverage to array
                    System.out.println(cloud_cover);
                    System.out.println(Values);
                    cloudCover = (value);
                }else{
                    //TODO: Something?
                }

            }

            //wheatherList.add(new WeatherInfo(valid,))

        }


        //JSONObject object1 = new JSONObject(reference_t);
        //JSONObject valid = timeseries.getString(valid_t);
        //System.out.println(object1);
        System.out.println("object" + approved);

        /*JSONObject employee = object.getJSONObject("employee");

        String name = employee.getString("name");
        String salary = employee.getString("salary");
        System.out.println(name);
        System.out.println(salary);*/

        /*String approve = time.getString(approved_t);
        System.out.println(approve);
        String reference = time.getString(reference_t);
        System.out.println(reference);
        String valid = time.getString(valid_t);
        System.out.println(valid);*/

    }

/*    public static void parseJsonData(String jsonString) {
            try {
                JSONObject object = new JSONObject(jsonString);
                JSONArray paramArray = object.getJSONArray("parameters");
                ArrayList<String> al = new ArrayList<String>();

                for(int i = 0; i < paramArray.length(); i++) {
                    al.add(paramArray.getString(i));
                }

                ArrayAdapter<String> adapter = new ArrayAdapter<String>(null, android.R.layout.simple_list_item_1, al);
            } catch (JSONException e) {
                e.printStackTrace();
            }
    }*/
}



