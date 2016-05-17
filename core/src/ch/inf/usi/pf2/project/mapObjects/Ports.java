package ch.inf.usi.pf2.project.mapObjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.MapObjects;

/**
 * Created by alexandercamenzind on 17/05/16.
 */
public class Ports {
    private MapObjects ports;

    public Ports(MapObjects ports){
        this.ports = ports;
    }

    public boolean portTouched (){
        boolean res = false;

        int x = Gdx.input.getX();
        int y = Gdx.input.getY();

        // write your stuff in here

        System.out.println(res);
        return res;
    }



}
