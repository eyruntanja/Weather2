package kth.etka.weather.list;

import java.util.Objects;

public class WeatherInfo {


    private final String hour;
    private String date;
    private String temperature;
    private String cloudCoverage;

    public WeatherInfo(String date, String hour, String temperature, String cloudCoverage) {
        this.hour = hour;
        this.date = date;
        this.temperature = temperature;
        this.cloudCoverage = cloudCoverage;
    }

    public String getDate() {
        return date;
    }

    public String getHour() {
        return hour;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getCloudCoverage() {
        return cloudCoverage;
    }

    public void setCloudCoverage(String cloudCoverage) {
        this.cloudCoverage = cloudCoverage;
    }

    /*
    @Override
    public String toString() {
        return setup + "\n" + delivery;
    }
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WeatherInfo info = (WeatherInfo) o;
        return hour == info.hour;
    }

    @Override
    public int hashCode() {
        return Objects.hash(hour);
    }
}
