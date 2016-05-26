package ch.inf.usi.pf2.project.mapObjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.objects.EllipseMapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.math.Ellipse;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

import java.util.ArrayList;

/**
 * Created by alexandercamenzind on 17/05/16.
 */
public class Ports {
    private MapObjects ports;
    private OrthographicCamera cam;
    private int WORLD_HEIGHT;

    public Ports(MapObjects ports, OrthographicCamera cam, int WORLD_HEIGHT){
        this.cam = cam;
        this.ports = ports;
        this.WORLD_HEIGHT = WORLD_HEIGHT;
    }

    public boolean portTouched (){
        boolean res = false;


        int x = Gdx.input.getX();
        int y = Gdx.input.getY();

        Vector3 v = cam.unproject(new Vector3(x,y,0));
        //v.y = (WORLD_HEIGHT - v.y);

        for(MapObject p:ports){
            if(p instanceof RectangleMapObject){
                RectangleMapObject rec =  (RectangleMapObject) p;
                Rectangle r = rec.getRectangle();


                if(r.getX()<v.x && v.x <r.getX()+r.getWidth() &&
                        r.getY() < v.y && v.y < r.getY() + r.getHeight()){
                    res =true;
                    System.out.println(rec.getName());
               }

            }
        }

        System.out.println(res);
        return res;
    }

    public ArrayList<Port> portsToPortS(){
        ArrayList<Port> Ports = new ArrayList<Port>();
        for(MapObject p:ports){
            if(p instanceof RectangleMapObject){
                RectangleMapObject rec =  (RectangleMapObject) p;
                int x = (int) ((int) rec.getRectangle().x + rec.getRectangle().width);
                int y = (int) ((int) rec.getRectangle().y + rec.getRectangle().height);
                Port port = new Port(rec.getName(),x,y);
                Ports.add(port);
            }
        }
        return Ports;
    }



}
