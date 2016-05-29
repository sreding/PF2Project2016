package ch.inf.usi.pf2.project.mapObjects;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.objects.PolygonMapObject;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

import java.util.ArrayList;

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
    private OrthographicCamera cam;
    private SpriteBatch batch;
    private ShapeRenderer shapeRenderer;
    private boolean isVisible;
    private int WORLD_WIDTH;
    private String label;
    private int price;
    private float x;
    private float y;
    private Line currentLine;
    private int lineCount;
    private float localDistance;
    private boolean traveling;
    private MapObjects landPolygons;
    private TextButton upgrade1;
    private TextButton upgrade2;
    private TextButton upgrade3;


    //int crewMembers?



    public Boat(int price, int capacity, double speed, double
                distanceLimit, double maintenanceCost,
                Sprite topBoat, Sprite sideBoat,
                SpriteBatch batch, OrthographicCamera cam, ShapeRenderer shapeRenderer, int WORLD_WIDTH,
                MapObjects landPolygons, String label){
        this.price = price;
        this.capacity = capacity;
        this.speed = speed;
        this.distanceLimit = distanceLimit;
        this.maintenanceCost = maintenanceCost;
        this.sideBoat = sideBoat;

        float ratio = sideBoat.getWidth() / sideBoat.getHeight();
        this.sideBoat.setSize(150,150/ratio);

        this.topBoat = topBoat;
        this.vulnerability = (maintenanceCost*distanceLimit)/speed;
        this.WORLD_WIDTH = WORLD_WIDTH;
        this.isVisible = false;

        this.lineCount = 0;

        this.cam = cam;
        this.shapeRenderer = shapeRenderer;
        this.batch=batch;
        this.traveling = false;
        this.landPolygons = landPolygons;
        this.currentPath = new Path(shapeRenderer,cam, WORLD_WIDTH, this.landPolygons);
        this.label = label;






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

    public void drawBoatOnMap(){
        if(isVisible) {
            sideBoat.draw(batch);
            sideBoat.setX(sideBoat.getX() + WORLD_WIDTH/2);
            sideBoat.draw(batch);
            sideBoat.setX(sideBoat.getX() - WORLD_WIDTH/2);
        }
    }

    public void updateBoat(float dt){
        if(traveling){
            Vector2 direction = currentLine.getDirection();
            double dx= direction.x * speed *dt;
            double dy= direction.y * speed *dt;
            localDistance+= Math.sqrt(dx*dx+dy*dy);
            x+= dx;
            y+= dy;
            if(localDistance>currentLine.getLength()){
                lineCount+=1;
                currentLine=currentPath.getPositions().get(lineCount);
                localDistance=0;
                x=currentLine.getStart().x;
                y= currentLine.getStart().y;
                //double time = currentLine.getLength() / speed;
            }

        }

        sideBoat.setPosition(x-sideBoat.getWidth()/2,y-sideBoat.getHeight()/2);


    }
    public void startBoat(){
        if(! currentPath.isEmpty()) {
            traveling = true;
            lineCount+=1;
            currentLine = currentPath.getPositions().get(lineCount);
            x = currentLine.getStart().x;
            y = currentLine.getStart().y;
        }
    }

    public void setVisible(boolean b){
        isVisible = b;
    }


    // various getter Methods
    public Path getCurrentPath() {
        return currentPath;
    }

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

    public String getLabel() {
        return label;
    }

    public int getPrice(){ return price;}
}
