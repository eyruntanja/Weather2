package kth.etka.weather.list;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import kth.etka.weather.R;

public class WeatherAdapter extends RecyclerView.Adapter<WeatherAdapter.ViewHolder> {

    private List<WeatherInfo> weatherInfoList = WeatherList.getInstance();
    // Provide a reference to the views for each data item
    // Complex data items need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView dateText;
        public TextView timeText;
        public TextView temperatureText;
        public ImageView cloudCoverageIcon;
        public TextView apprDate;
        public TextView apprTime;

        public ViewHolder(View v) {
            super(v);
        }
    }

    // Create new views (invoked by the layout manager)
    @Override
    public WeatherAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = (View) LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        final ViewHolder vh = new ViewHolder(itemView);

        vh.dateText = itemView.findViewById(R.id.date_text);
        vh.timeText = itemView.findViewById(R.id.time_text);
        vh.temperatureText = itemView.findViewById(R.id.temperature_text);
        vh.cloudCoverageIcon = itemView.findViewById(R.id.cloud_coverage_icon);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)

    @Override
    public void onBindViewHolder(@NonNull ViewHolder vh, int position) {
        WeatherInfo weather = weatherInfoList.get(position);
        vh.dateText.setText(weather.getDate());
        vh.timeText.setText(weather.getHour());
        vh.temperatureText.setText(weather.getTemperature());
        if ( Integer.valueOf(weather.getCloudCoverage().substring(0,1)) <= 2) {
            vh.cloudCoverageIcon.setImageResource(R.drawable.sunny);
        } else if (Integer.valueOf(weather.getCloudCoverage().substring(0,1)) <= 4 && Integer.valueOf(weather.getCloudCoverage().substring(0,1)) > 2) {
            vh.cloudCoverageIcon.setImageResource(R.drawable.cloud1);
        } else if (Integer.valueOf(weather.getCloudCoverage().substring(0,1)) <= 6 && Integer.valueOf(weather.getCloudCoverage().substring(0,1)) > 4){
            vh.cloudCoverageIcon.setImageResource(R.drawable.cloud2);
        }else if (Integer.valueOf(weather.getCloudCoverage().substring(0,1)) > 6) {
            vh.cloudCoverageIcon.setImageResource(R.drawable.cloud3);
        }


    }
    @Override
    public int getItemCount() {
        return weatherInfoList.size(); }
}
