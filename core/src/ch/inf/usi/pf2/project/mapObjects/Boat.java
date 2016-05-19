package ch.inf.usi.pf2.project.mapObjects;
import com.badlogic.gdx.graphics.g2d.Sprite;
/**
 * Created by alexandercamenzind on 17/05/16.
 */
public class Boat {
    private int capacity;
    private double speed;
    private double distanceLimit;
    private double maintenanceCost;
    private double vulnerability;
    private final Sprite topBoat;
    private final Sprite sideBoat;
    private double distFromOrigin;
    private Port origin;
    private Path currentPath;
    //int crewMembers?

    public Boat(int capacity, double speed, double
                distanceLimit, double maintenanceCost,
                Sprite topBoat, Sprite sideBoat){
        this.capacity = capacity;
        this.speed = speed;
        this.distanceLimit = distanceLimit;
        this.maintenanceCost = maintenanceCost;
        this.sideBoat = sideBoat;
        this.topBoat = topBoat;
        this.vulnerability = (maintenanceCost*distanceLimit)/speed;
    }

    public void changeOrigin(Port port){
        origin = port;
    }

    public void moveBoat(){
        if(distFromOrigin <= distanceLimit){
            distFromOrigin = distFromOrigin + speed;
        }
    }

    //upgrade Methods
    public void upgradeCapacity(int upgrade){
        capacity = capacity * upgrade;
        maintenanceCost = maintenanceCost * upgrade;
    }
    public void upgradeVulnerability(double upgrade){
        vulnerability = vulnerability * upgrade;
        maintenanceCost = maintenanceCost * upgrade;
    }


    // various getter Methods
    public int getCapacity() {
        return capacity;
    }

    public double getDistanceLimit() {
        return distanceLimit;
    }

    public double getSpeed() {
        return speed;
    }

    public double getMaintenanceCost() {
        return maintenanceCost;
    }

    public Sprite getSideBoat() {
        return sideBoat;
    }

    public Sprite getTopBoat() {
        return topBoat;
    }

    public double getVulnerability() {
        return vulnerability;
    }
}
