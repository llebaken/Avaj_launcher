package co.wethinkcode.avaj.simulator.weather;

import java.util.Random;

public class WeatherProvider {
    private static WeatherProvider weatherProvider;
    private static String[] weather = {"SUN", "RAIN", "FOG", "SNOW"};

    private WeatherProvider(){}
    public static WeatherProvider getProvider(){
        if(weatherProvider == null){
            weatherProvider = new WeatherProvider();
        }
        return weatherProvider;
    }
    public String getCurrentWeather(Coordinates coordinates){
        int random = new Random().nextInt(weather.length);
        return weather[random];
    }

}
