package ch.inf.usi.pf2.project.mapObjects;


/**
 * Created by simonreding on 29/05/16.
 */
public class Disaster {
    private int x;
    private int y;
    private boolean type;//land or

    public Disaster(int x,int y, boolean type){
        this.x = x;
        this.y =  y;
        this.type = type;
    }
    public Disaster(int x,int y){
        this.x = x;
        this.y =  y;
        this.type = checkWater(x,y);

    }
    ////STILL HAS TO BE IMPLEMENTED!!!!!
    private boolean checkWater(int x, int y){
        return true;
    }

}
