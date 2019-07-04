package co.wethinkcode.avaj.simulator.simulation.vehicles;

import co.wethinkcode.avaj.simulator.simulation.Simulator;
import co.wethinkcode.avaj.simulator.simulation.WeatherTower;
import co.wethinkcode.avaj.simulator.weather.Coordinates;
import co.wethinkcode.avaj.simulator.weather.WeatherProvider;

public class JetPlane extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    JetPlane(String name, Coordinates coordinates){
        super(name, coordinates);
    }

    public void updateConditions(){
        String weather = weatherTower.getWeather(this.coordinates);

        switch (weather){
            case "SUN":
                this.coordinates = new Coordinates(this.coordinates.getLongitude() + 10, this.coordinates.getLatitude(), this.coordinates.getHeight() + 2);
                Simulator.writer.println("JetPlane#"+this.name+"("+this.id+")"+" Let's enjoy the good weather and take some pics");
                break;
            case "RAIN":
                this.coordinates = new Coordinates(this.coordinates.getLongitude() + 5, this.coordinates.getLatitude(), this.coordinates.getHeight());
                Simulator.writer.println("JetPlane#"+this.name+"("+this.id+")"+" It's raining. Better watch out for lightings");
                break;
            case "FOG":
                this.coordinates = new Coordinates(this.coordinates.getLongitude() + 1, this.coordinates.getLatitude(), this.coordinates.getHeight());
                Simulator.writer.println("JetPlane#"+this.name+"("+this.id+")"+" I can't see through this fog");
                break;
            case "SNOW":
                this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude(), this.coordinates.getHeight() - 7);
                Simulator.writer.println("JetPlane#"+this.name+"("+this.id+")"+" Winter is coming");
                break;
        }
        if (this.coordinates.getHeight() <= 0){
            this.weatherTower.unregister(this);
            Simulator.writer.println("Tower says: JetPlane#"+this.name+"("+this.id+")"+" unregistered to the weather tower");
        }
    }
    public void registerTower(WeatherTower weatherTower){
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
        Simulator.writer.println("Tower says: JetPlane#"+this.name+"("+this.id+")"+" registered to the weather tower");
    }
}
