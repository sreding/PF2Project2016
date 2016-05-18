package ch.inf.usi.pf2.project.mapObjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
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
    private OrthographicCamera cam;
    private int MAP_WIDTH;



    public Path(ShapeRenderer shapeRenderer, OrthographicCamera cam, int MAP_WIDTH){
        this.shapeRenderer = shapeRenderer;

        positions = new ArrayList<Vector2>();

        this.cam =cam;
        this.MAP_WIDTH=MAP_WIDTH;



    }


    public void addPoint(int x, int y){
        if(checkColision(x,y)) {
            positions.add(new Vector2(x, y));
        }
    }

    private boolean checkColision(int x, int y){
        return true;
    }

    public void inputPath(){
        if(Gdx.input.isTouched()){
            Vector3 vec = cam.unproject(new Vector3(Gdx.input.getX(),Gdx.input.getY(),0));
            addPoint((int) vec.x,(int) vec.y);
        }

    }


    public void drawPath(){
        Vector2 prev;
        Vector2 pos;




        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(Color.RED);
        for(int i = 1; i < positions.size() -1; i++){
            pos = positions.get(i);
            prev = positions.get(i-1);
            shapeRenderer.rectLine(pos.x,pos.y,prev.x ,prev.y,5);
        }
        shapeRenderer.end();

    }
}
