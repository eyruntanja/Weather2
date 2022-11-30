package kth.etka.weather;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.xml.sax.helpers.AttributesImpl;

import java.util.List;

import kth.etka.weather.Networking.networking;
import kth.etka.weather.list.WeatherInfo;
import kth.etka.weather.list.WeatherList;
import kth.etka.weather.parser.parser;

public class MainActivity extends AppCompatActivity {

    private final parser cparser = new parser();
    Button setCordinatesButton;
    Button viewWeatherButton;
    EditText latitude, longitude;
    float longitudeValue;
    float latitudeValue;

    SharedPreferences sharedPreferences;
    private SharedPreferences shared;
    String sharedPref = "kth.etka.Weather.sharedpref";

    boolean connectedStatus;

    networking networking;
    List<WeatherInfo> weatherList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        weatherList = WeatherList.getInstance();

        longitude = findViewById(R.id.Longitude);
        latitude = findViewById(R.id.Latitude);
        longitude.setInputType(InputType.TYPE_NUMBER_FLAG_DECIMAL);
        latitude.setInputType(InputType.TYPE_NUMBER_FLAG_DECIMAL);

        shared = getSharedPreferences(sharedPref, MODE_PRIVATE);

        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo != null){connectedStatus = true;}
        else {connectedStatus = false;}

        setCordinatesButton = findViewById(R.id.set_coordinates);
        setCordinatesButton.setOnClickListener(this::setCoordinates);

        viewWeatherButton = findViewById(R.id.view_weather);
        viewWeatherButton.setOnClickListener(this::viewWeather);

    }

<<<<<<< HEAD

    //not sure if we have to change the edit text, it looks weird
    private void setCoordinates(View view) {

        Toast toast;
        int duration = Toast.LENGTH_SHORT;

        longitudeValue = shared.getFloat("long",0);
        latitudeValue = shared.getFloat("lat",0);

        longitudeValue = Float.parseFloat(longitude.getText().toString());
        latitudeValue = Float.parseFloat(latitude.getText().toString());
        if (connectedStatus == true) {
            if (-8.541 < longitudeValue && longitudeValue < 37.848) {
                if (52.500 < latitudeValue && latitudeValue < 70.741) {
                    weatherList.clear();
                    networking = new networking(this);
                    networking.getData(longitudeValue, latitudeValue);
                } else {
                    CharSequence latitudeWarning = "Latitude out of range";
                    toast = Toast.makeText(this, latitudeWarning, duration);
                    toast.show();
                }
            } else {
                CharSequence longitudeWarning = "Longitude out of range";
                toast = Toast.makeText(this, longitudeWarning, duration);
                toast.show();
            }
        }
        else{
            CharSequence internetWarning = "No Internet";
            toast = Toast.makeText(this, internetWarning, duration);
            toast.show();
        }
    }

    private void viewWeather(View view) {
        SharedPreferences.Editor myEdit = shared.edit();

        myEdit.putFloat("long",longitudeValue);
        myEdit.putFloat("lat",latitudeValue);

        myEdit.apply();

        startActivity(new Intent(this, theWeather.class));
=======
    public void loadWeatherForecast(String cityName) {
        // init
    }

    //not sure if we have to change the edit text, it looks weird
    private void submit(View view) {
        //if sentence for if the latitude and longitude are inside bounds
        startActivity(new Intent(this, theWeather.class));
        //else show "Requested point is out of bounds"
>>>>>>> f67ccaa4af99852ee979ee656d674507339401f3
    }
}