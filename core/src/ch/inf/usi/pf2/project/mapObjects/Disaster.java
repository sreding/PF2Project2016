package ch.inf.usi.pf2.project.mapObjects;


import java.util.Random;

/**
 * Created by simonreding on 29/05/16.
 */
public class Disaster {
    private int x;
    private int y;
    private boolean type;//true if in sea

    private String name;
    private String locationName;


    //how grave the disaster is, not as is getting pulled down to earth. 9 is worst, 0 best
    private int gravity;



    public Disaster(int x,int y, boolean type, int gravity, String name, String locationName){
        this.x = x;
        this.y =  y;
        this.type = type;
        if(gravity > 10) {
            this.gravity = gravity;
        }else{Random rn = new Random();
            gravity = rn.nextInt(10);}
        this.name = name;
        this.locationName = locationName;
    }



    public Disaster(Oceans oceans){
        this.name = oceans.getName();
        x = oceans.getX();
        y = oceans.getY();
        Random rn = new Random();
        this.gravity = rn.nextInt(10);
    }
    public Disaster(int x,int y, String name){

        this.x = x;
        this.y =  y;
        //this.type = checkWater(x,y);
        Random rn = new Random();
        this.gravity = rn.nextInt(10);


        this.name = name;


    }


    public int getGravity() {
        return gravity;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String getLocationName() {
        return locationName;
    }
}
