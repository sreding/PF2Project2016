package ch.inf.usi.pf2.project.mapObjects;


import java.util.Random;

/**
 * Created by simonreding on 29/05/16.
 */
public class Disaster {
    private int x;
    private int y;
    private boolean type;//true if in sea
<<<<<<< HEAD
=======
    private String name;
>>>>>>> 0719cd61572beb7ef9546d20539be077b4f545e2

    //how grave the disaster is, not as is getting pulled down to earth. 9 is worst, 0 best
    private int gravity;



    public Disaster(int x,int y, boolean type, int gravity){
        this.x = x;
        this.y =  y;
        this.type = type;
        this.gravity = gravity;
    }
<<<<<<< HEAD
    public Disaster(int x,int y){
=======
    public Disaster(Place place){
        this.name = place.getName();
        x = place.getX();
        y = place.getY();
    }
    public Disaster(int x,int y, String name){
>>>>>>> 0719cd61572beb7ef9546d20539be077b4f545e2
        this.x = x;
        this.y =  y;
        this.type = checkWater(x,y);
        Random rn = new Random();
        this.gravity = rn.nextInt(10);
<<<<<<< HEAD
=======
        this.name = name;
>>>>>>> 0719cd61572beb7ef9546d20539be077b4f545e2

    }

//    TODO: implement function so that it returns true only if disaster is in water
    private boolean checkWater(int x, int y){
        return true;
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
}
