package co.wethinkcode.avaj.simulator.simulation;

import co.wethinkcode.avaj.simulator.simulation.vehicles.Flyable;

import java.util.ArrayList;

public abstract class Tower {
    private ArrayList<Flyable> observers = new ArrayList<>();

    public void register(Flyable flyable){
        observers.add(flyable);
    }
    public void unregister(Flyable flyable){
        observers.remove(flyable);
    }
    protected void conditionsChange(){
        for (int i = 0; i < observers.size(); i++){
            Flyable flyable = observers.get(i);
            flyable.updateConditions();
        }

    }

}
