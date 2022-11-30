package kth.etka.weather;

import static java.util.Objects.requireNonNull;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;

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
    TextView apprDateText;
    TextView apprTimeText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_the_weather);
        // more ui, the recycler view

        apprDateText = findViewById(R.id.aproved_date_text);
        apprTimeText = findViewById(R.id.aproved_time_text);
        apprDateText.setText(WeatherList.getApprDate());
        apprTimeText.setText(WeatherList.getApprTime());

        // data
        weatherList = WeatherList.getInstance();

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        weatherAdapter = new WeatherAdapter();
        recyclerView.setAdapter(weatherAdapter);
    }

    public void printWeather() {

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        weatherAdapter = new WeatherAdapter();
        recyclerView.setAdapter(weatherAdapter);

        weatherList = WeatherList.getInstance();
    }
}