package ch.inf.usi.pf2.project.mapObjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
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
    //private MapObjects ports;

    private int WORLD_WIDTH;
    private ArrayList<Port> ports;
    private Sprite portSymbol;

    public Ports(MapObjects ports, int WORLD_WIDTH){

        this.ports =new ArrayList<Port>();
        addPorts(ports);
        this.WORLD_WIDTH = WORLD_WIDTH;
        this.portSymbol= new Sprite(new Texture("portIcon.png"));
        portSymbol.setAlpha(1f);
    }

    public Port portTouched (OrthographicCamera cam){
        int x = Gdx.input.getX();
        int y = Gdx.input.getY();
        Vector3 v = cam.unproject(new Vector3(x,y,0));
        //v.y = (WORLD_HEIGHT - v.y);
        Port res = null;
        for(Port p: ports) {
            Rectangle r = p.getHitBox();

            if (r.getX() < v.x && v.x < r.getX() + r.getWidth() &&
                    r.getY() < v.y && v.y < r.getY() + r.getHeight()) {
                res = p;
            } else if (r.getX() < v.x - WORLD_WIDTH / 2 && v.x - WORLD_WIDTH / 2 < r.getX() + r.getWidth() &&
                    r.getY() < v.y && v.y < r.getY() + r.getHeight()) {
                res = p;
            }
        }

        return res;
        }

    public Port handlePortInput(OrthographicCamera cam){
        Port p = portTouched(cam);
        if(Gdx.input.justTouched()&& p != null){
            System.out.println("pls display options for port: " + p.getName());
        }
        return p;
    }

    public void addPorts(MapObjects mO){
        for(MapObject o:mO){
            if(o instanceof RectangleMapObject){
                RectangleMapObject rec =  (RectangleMapObject) o;
                Rectangle r = rec.getRectangle();
                Port port = new Port(rec.getName(),r);
                ports.add(port);
            }
        }
    }

    public void drawPorts(SpriteBatch batch){
        for(Port p: ports){
            p.drawPort(batch,portSymbol, WORLD_WIDTH);
        }

    }



}
