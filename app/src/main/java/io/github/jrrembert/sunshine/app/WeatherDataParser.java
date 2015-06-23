package io.github.jrrembert.sunshine.app;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by jrrembert on 6/23/15.
 */
public class WeatherDataParser {

    /**
     * Give a string of the form returned by the api call:
     * http://api.openweathermap.org/data/2.5/forecast/daily?q=94043&mode=json&units=metric&cnt=7
     * retrieve the maximum temperature for the day indicated by dayIndex.
     */
    public static double getMaxTemperatureForDay(String weatherJsonStr, int dayIndex)
            throws JSONException {
        // Parse JSON string into a JSON Object and then convert the "list" array
        // into a JSONArray
        JSONObject weatherJson = new JSONObject(weatherJsonStr);
        JSONArray array = weatherJson.getJSONArray("list");

        // Get the maximum temperate for a day given by dayIndex. For each day in our array,
        // this value will be found at the path {temp: {max: (double) value}}.
        double maxTemp = array.getJSONObject(dayIndex).getJSONObject("temp").getDouble("max");

        return maxTemp;



}
}
