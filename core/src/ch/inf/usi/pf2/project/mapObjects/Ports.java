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
               }

            }
        }

        /*
        System.out.println( v.x + " " + (WORLD_HEIGHT - v.y));
        // write your stuff in here
        for(MapObject p : ports){
            Ellipse elip = ((EllipseMapObject) p).getEllipse();
            Ellipse e = new Ellipse(elip.x +elip.width/2,elip.y,elip.width,elip.height);


            if(e.contains(v.x,WORLD_HEIGHT - v.y)){
                res=true;
            }

        }
        */

        System.out.println(res);
        return res;
    }



}
