package ch.inf.usi.pf2.project.mapObjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Shape;
import com.badlogic.gdx.InputAdapter;

import java.util.ArrayList;

import ch.inf.usi.pf2.project.BoatManager2k16;

/**
 * Created by alexandercamenzind on 14/05/16.
 */
public class Path{
    private ArrayList<Vector2> positions;
    private ShapeRenderer shapeRenderer;
    private final int delta = 1440;


    public Path(ShapeRenderer shapeRenderer){
        this.shapeRenderer = shapeRenderer;

        positions = new ArrayList<Vector2>();
        positions.add(new Vector2(10,10));
        positions.add(new Vector2(900,100));
        positions.add(new Vector2(200,200));



    }


    public void addPoint(int x, int y){
        if(checkColision(x,y)) {
            positions.add(new Vector2(x, y));
        }
    }

    private boolean checkColision(int x, int y){
        return true;
    }


    public void drawPath(){
        Vector2 prev;
        Vector2 pos;
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(Color.RED);
        for(int i = 1; i < positions.size() -1; i++){
            pos = positions.get(i);
            prev = positions.get(i-1);
            shapeRenderer.rectLine(pos.x,pos.y,prev.x,prev.y,5);
            // we draw the line twice because of the way our infinite scrolling is implemented
            shapeRenderer.rectLine(pos.x+delta,pos.y,prev.x+delta,prev.y,5);
        }
        shapeRenderer.end();

    }
}
