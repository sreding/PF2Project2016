package ch.inf.usi.pf2.project.mapObjects;

/**
 * Created by alexandercamenzind on 31/05/16.
 */
public class BoatSaver {
    private int capacity;
    public String label;
    public int boatVal;

    public BoatSaver(){
    }
    public BoatSaver(Boat b){
        capacity=b.getCapacity();
        label = b.getLabel();
        boatVal=b.type_boat;
    }

}
