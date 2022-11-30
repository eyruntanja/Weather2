package kth.etka.weather;

import static java.util.Objects.requireNonNull;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Application;
import android.os.Bundle;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import java.util.List;
import org.json.JSONObject;

import java.util.Objects;

import kth.etka.weather.list.WeatherAdapter;
import kth.etka.weather.list.WeatherInfo;
import kth.etka.weather.list.WeatherList;

import kth.etka.weather.Networking.networking;

public class theWeather extends AppCompatActivity {

    networking networking;

    List<WeatherInfo> weatherList;
    WeatherAdapter weatherAdapter;
    WeatherInfo weather1;
    WeatherInfo weather2;
    boolean readyToPrint = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_the_weather);
        weather1 = new WeatherInfo("2022-01-29","22","15","6");
        weather2 = new WeatherInfo("2022-01-29","23","16","7");
        // messageView = findViewById(R.id.message_view);
        // more ui, the recycler view


        networking = new networking(this);
        //call the getdata
        networking.getData();

        // data
        /*weatherList = WeatherList.getInstance(); // get the singleton list ui
        weatherList.add(weather1);
        weatherList.add(weather2);

         */
        System.out.println("Test view");


        printWeather();

        // specify an adapter

    }

    public void printWeather() {
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        weatherAdapter = new WeatherAdapter();
        recyclerView.setAdapter(weatherAdapter);

        weatherList = WeatherList.getInstance();
        System.out.println("Temperature " + weatherList.get(15).getTemperature());
    }

    protected void onBackPressed(Bundle savedInstanceState) {
        //TODO: clear list


    }
}