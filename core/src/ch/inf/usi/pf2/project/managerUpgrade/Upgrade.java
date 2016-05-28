package ch.inf.usi.pf2.project.managerUpgrade;

import com.badlogic.gdx.graphics.g2d.Sprite;

/**
 * Created by ilijagjorgjiev on 5/27/16.
 */
public class Upgrade {

    private int price;
    private int capacity;
    private double speed;
    private double distanceLimit;
    private double maintenanceCost;
    private double vulnerability;

    public Upgrade(int price, int capacity, double speed, double distanceLimit,
                   double maintenanceCost, double vulnerability)
    {
        this.price = price;
        this.capacity = capacity;
        this.speed = speed;
        this.distanceLimit = distanceLimit;
        this.maintenanceCost = maintenanceCost;
        this.vulnerability = vulnerability;
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

    public double getVulnerability() {
        return vulnerability;
    }

    public int getPrice(){ return price;}

}
