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
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.objects.PolygonMapObject;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.Shape;
import com.badlogic.gdx.InputAdapter;

import java.util.ArrayList;

import ch.inf.usi.pf2.project.BoatManager2k16;
import ch.inf.usi.pf2.project.gameStates.Map;

/**
 * Created by alexandercamenzind on 14/05/16.
 */
public class Path{
    private ShapeRenderer shapeRenderer;
    private OrthographicCamera cam;
    private int c1; // 1/4 of Map width


    private  ArrayList<Line> left;
    private Line top;

    private MapObjects landPolygons;




    public Path(ShapeRenderer shapeRenderer, OrthographicCamera cam, int MAP_WIDTH, MapObjects landPolygons){
        this.shapeRenderer = shapeRenderer;


        left = new ArrayList<Line>();

        this.cam =cam;
        c1=MAP_WIDTH/4;

        this.landPolygons=landPolygons;


    }

    public boolean isEmpty(){
        return left.size() == 0;
    }



    public void inputPath4(){
        Vector3 in = cam.unproject(new Vector3(Gdx.input.getX(),Gdx.input.getY(),0));
        int cQ = computeQuadrant(); //cq = currentQuadrant
        Line l;

        if(isEmpty() && notInLand(in)){ // path is empty -> we need to check if we start from inside a country
            if(cQ>=2){
                l = new Line(new Vector2(in.x-2*c1,in.y),new Vector2(in.x-2*c1,in.y),cQ,cQ);
            }
            else {
                l = new Line(new Vector2(in.x, in.y), new Vector2(in.x, in.y), cQ, cQ);
            }
            left.add(l);
        }
        else if(! isEmpty()){
            l = new Line(top.getEnd(),new Vector2(in.x,in.y),top.endQuadrant,cQ);
            if(checkLandCollision(l)) {
                l.addLine(left, c1);
            }

        }



        //check if line goes over land
        //
        if(left.size()>0) {
            top = left.get(left.size()-1);
            //System.out.println(l.intersectsWithPolygons(landPolygons));
        }

    }


    // returns true if the line is fine
    private boolean checkLandCollision(Line l){
        //if(l.startQuadrant<l.endQuadrant)
        Line v;
        if(l.startQuadrant >= 2){
            v = new Line(new Vector2(l.getStart().x+2*c1,l.getStart().y),l.getEnd(),0,0);
        }
        else{
            v = l;
        }
        return ! v.intersectsWithPolygons(landPolygons);
    }


    private boolean notInLand(Vector3 in){
        boolean res =true;
        for(MapObject o: landPolygons){
            if(o instanceof PolygonMapObject){
                Polygon p =((PolygonMapObject) o).getPolygon();
                if(p.contains(in.x,in.y)){
                    res =false;
                }
            }
        }
        return res;
    }


    private int computeQuadrant(){
        Vector3 v= cam.unproject( new Vector3(Gdx.input.getX(),0,0));
        int posX =(int) v.x;
        int quadrant;
        if(posX<=c1){
            quadrant = 0;
        }
        else if(posX<2*c1){
            quadrant = 1;
        }
        else if(posX < 3*c1){
            quadrant = 2;
        }
        else{
            quadrant = 3;
        }
        return quadrant;
    }

    public void drawPath3(int mode){

        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(Color.RED);
        for(Line l : left){
            l.draw(shapeRenderer);
            l.leftToRight(2*c1).draw(shapeRenderer);
        }
        if(Gdx.input.isTouched() && !isEmpty() && mode ==1){
            Vector3 v = cam.unproject(new Vector3(Gdx.input.getX(),Gdx.input.getY(),0));
            Line current;
            if(top.endQuadrant>=2) {
                current = new Line(new Vector2(top.getEnd().x+2*c1,top.getEnd().y), new Vector2(v.x, v.y), 0, 0);
            }
            else{
                current = new Line(top.getEnd(), new Vector2(v.x, v.y), 0, 0);
            }
            current.draw(shapeRenderer);
        }
        shapeRenderer.setColor(Color.GOLD);
        if(top!= null) {
            shapeRenderer.circle(top.getEnd().x, top.getEnd().y, 10);
            shapeRenderer.setColor(Color.MAGENTA);
            shapeRenderer.circle(top.getEnd().x+2*c1, top.getEnd().y, 10);
        }
        shapeRenderer.end();
    }


    public void notifyPath() {
        for (Line l : left) {
            l.swqpQuadrants();
        }
    }

    public ArrayList<Line> getPositions(){
        return left;
    }
}
