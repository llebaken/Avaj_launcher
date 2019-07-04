package co.wethinkcode.avaj.simulator.simulation;

import co.wethinkcode.avaj.simulator.simulation.vehicles.AircraftFactory;
import co.wethinkcode.avaj.simulator.simulation.vehicles.Flyable;

import java.io.*;
import java.util.ArrayList;

public class Simulator {
    public static PrintWriter writer;

    public static void main(String[] arg){
        String line;
        String[] linearray;
        String type;
        String name;
        int noSimulator = -1;
        int longitude;
        int latitude;
        int height;
        Flyable flyable;
        ArrayList<Flyable> flyables = new ArrayList<>();

        try{
            FileReader fileReader = new FileReader(arg[0]);
            writer = new PrintWriter("simulation.txt");

            BufferedReader bufferedReader = new BufferedReader(fileReader);

            if((line = bufferedReader.readLine()) != null){
                if(line.trim() != null){
                    line = line.trim();
                    noSimulator = Integer.parseInt(line);
                }
                else{
                    throw new FileInputException("Simulation Number Not Found");
                }

            }
            if(noSimulator >= 0) {
                WeatherTower weatherTower = new WeatherTower();
                while ((line = bufferedReader.readLine()) != null) {
                    if(line.trim() != null){
                        line = line.trim();
                        linearray = line.split(" ");
                        if(linearray.length == 5){
                            type = linearray[0];
                            name = linearray[1];
                            longitude = Integer.parseInt(linearray[2]);
                            latitude = Integer.parseInt(linearray[3]);
                            height = Integer.parseInt(linearray[4]);
                            if((longitude < 0) || (latitude < 0) || (height < 0)){
                                throw new FileInputException("Error With Flyable coordinates. Coordinates can't be negative");
                            }
                            flyable = AircraftFactory.newAircraft(type, name, longitude, latitude, height);
                            if(flyable == null){
                                throw new FileInputException("Flyable must be Baloon, JetPlane, or Helicopter");
                            }
                            else {
                                flyables.add(flyable);
                            }
                        }
                        else {
                            throw new FileInputException("Can't Create Flyable");
                        }
                    }
                }
                for (int i = 0; i < flyables.size(); i++){
                    Flyable fly = flyables.get(i);
                    fly.registerTower(weatherTower);
                }
                for (int simCounter=0; simCounter < noSimulator; simCounter++){
                    weatherTower.changeWeather();
                }
            }
            else{
                throw new FileInputException("Simulation Number Can't be negative");
            }
            bufferedReader.close();
            writer.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (FileInputException e){
            System.out.println(e.getMessage());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
