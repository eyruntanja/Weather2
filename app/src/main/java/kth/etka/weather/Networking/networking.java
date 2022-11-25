package kth.etka.weather.Networking;

import static kth.etka.weather.R.*;
import static kth.etka.weather.R.string.netw_connection;

import android.annotation.SuppressLint;
import android.content.Context;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import kth.etka.weather.R;

public class networking {

    static TextView textView;

    //RequestQueue queue = Volley.newRequestQueue(this);

    /* TESTING LINK */
    static String url = "https://maceo.sth.kth.se/weather/forecast?lonLat=lon/14.333/lat/60.383";

    static JSONObject json;

    public static JSONObject getJson() {

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @SuppressLint("SetTextI18n")
                    @Override
                    public void onResponse(JSONObject response) {
                        textView.setText("Response: " + response.toString());
                        json = response;
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO: Handle error
                        Context context = null;
                        CharSequence text = "Hello toast!";
                        int duration = Toast.LENGTH_SHORT;

                        Toast toast = Toast.makeText(context, text, duration);
                        toast.show();
                    }
                });

        return json;
    }
}
