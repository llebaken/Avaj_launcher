package co.wethinkcode.avaj.simulator.simulation.vehicles;

import co.wethinkcode.avaj.simulator.simulation.WeatherTower;

public interface Flyable {
    public void updateConditions();
    public void registerTower(WeatherTower weatherTower);
}
