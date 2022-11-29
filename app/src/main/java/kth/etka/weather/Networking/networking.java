package kth.etka.weather.Networking;

import static kth.etka.weather.R.*;
import static kth.etka.weather.R.string.netw_connection;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.UserHandle;
import android.util.Log;
import android.view.Display;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import kth.etka.weather.R;
import kth.etka.weather.parser.parser;

public class networking {
    RequestQueue queue;
    parser Parser;

    public networking(Context context){
        queue = Volley.newRequestQueue(context);
    }

    static TextView textView;

    /* TESTING LINK */
    static String url = "https://maceo.sth.kth.se/weather/forecast?lonLat=lon/14.333/lat/60.383";

    public void getData(){
        JsonObjectRequest tryRequest = new JsonObjectRequest(
                Request.Method.GET,
                url,
                null,
                (Response.Listener<JSONObject>) response -> {
                    Parser = new parser();
                    try {
                        Parser.Weather(response);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                },
                errorlistener);

        queue.add(tryRequest);
    }
    private Response.ErrorListener errorlistener = error -> Log.i("tag", error.toString());
}
