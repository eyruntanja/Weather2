package kth.etka.weather;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import kth.etka.weather.Networking.networking;
import kth.etka.weather.parser.parser;

public class MainActivity extends AppCompatActivity {

    private final parser cparser = new parser();
    Button submit;
    EditText latitude, longitude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //TODO: if connected to internet
        submit = findViewById(R.id.submit);
        submit.setOnClickListener(this::submit);
        //TODO: else if not connected to internet

    }

    public void loadWeatherForecast(String cityName) {
        // init
    }

    //not sure if we have to change the edit text, it looks weird
    private void submit(View view) {
        //if sentence for if the latitude and longitude are inside bounds
        startActivity(new Intent(this, theWeather.class));
        //else show "Requested point is out of bounds"
    }
}