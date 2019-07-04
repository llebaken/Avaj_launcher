package co.wethinkcode.avaj.simulator.simulation;

import co.wethinkcode.avaj.simulator.weather.Coordinates;
import co.wethinkcode.avaj.simulator.weather.WeatherProvider;

public class WeatherTower extends Tower {
    public String getWeather(Coordinates coordinates){
        WeatherProvider weatherProvider = WeatherProvider.getProvider();
        String weather = weatherProvider.getCurrentWeather(coordinates);
        return weather;
    }
    void changeWeather(){
        conditionsChange();
    }
}
