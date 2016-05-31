package ch.inf.usi.pf2.project.mapObjects;

/**
 * Created by alexandercamenzind on 31/05/16.
 */
public class BoatSaver {

    public String label;
    public int boatVal;
    public int upgradeCount;
    public double speed;
    public int capacity;

    public BoatSaver(){
    }
    public BoatSaver(Boat b){
        capacity=b.getCapacity();
        label = b.getLabel();
        boatVal=b.type_boat;
        upgradeCount=b.counter_upgrage;
        speed=b.getSpeed();

    }

}
