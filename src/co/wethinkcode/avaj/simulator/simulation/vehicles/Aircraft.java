package co.wethinkcode.avaj.simulator.simulation.vehicles;

import co.wethinkcode.avaj.simulator.weather.Coordinates;

public abstract class Aircraft {
    protected long id;
    protected String name;
    protected Coordinates coordinates;
    private static long idCounter;

    protected Aircraft(String name, Coordinates coordinates){
        this.name = name;
        this.coordinates = coordinates;
        this.id = nextID();
    }
    private long nextID(){
        return ++idCounter;
    }
}
