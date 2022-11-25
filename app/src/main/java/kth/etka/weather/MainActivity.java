package kth.etka.weather;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.json.JSONException;
import org.json.JSONObject;

import kth.etka.weather.Networking.networking;
import kth.etka.weather.parser.parser;

public class MainActivity extends AppCompatActivity {

    Button submit;
    EditText latitude, longitude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        submit = findViewById(R.id.submit);
        submit.setOnClickListener(this::submit);

        JSONObject example = networking.getJson();

        try {
            parser.Time(example);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    //not sure if we have to change the edit text, it looks weird
    private void submit(View view) {
        //if sentence for if the latitude and longitude are inside bounds
            startActivity(new Intent(this, theWeather.class));
        //else show "Requested point is out of bounds"
    }
}