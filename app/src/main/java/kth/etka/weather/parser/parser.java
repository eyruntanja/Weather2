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
            valid_t = "validTime",
            temperature = "t",
            cloud_cover = "tcc_mean",
            longitude = "Lon",
            latitude = "Lat";

    public static void Time (JSONObject time) throws JSONException {
        //String JSON_STRING = "{\"employee\":{\"name\":\"Abhishek Saini\",\"salary\":65000}}";

        String approved = time.getString(approved_t);
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

    public static void parseJsonData(String jsonString) {
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
    }



}



