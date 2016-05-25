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
    private ArrayList<Vector2> positions;
    private ShapeRenderer shapeRenderer;
    private OrthographicCamera cam;
    private int c1;


    private  ArrayList<Line> left;
    private Line topLeft;

    private boolean cameraFlag;
    private boolean cameraFlagLeft;
    private int previousCameraPosition;
    private MapObjects landPolygons;




    //private int quadrant; // 0 == 1st quadrant, 1 = 2nd , 3 = 3rd, 4 = 4th
    private int prev;



    public Path(ShapeRenderer shapeRenderer, OrthographicCamera cam, int MAP_WIDTH, MapObjects landPolygons){
        this.shapeRenderer = shapeRenderer;

        positions = new ArrayList<Vector2>();

        left = new ArrayList<Line>();

        this.cam =cam;
        c1=MAP_WIDTH/4;

        this.landPolygons=landPolygons;


    }

    public boolean isEmpty(){
        return left.size() == 0;
    }


    private boolean checkCollision(int x, int y){
        return true;
    }




    public void inputPath3(){
        int pos=computeQuadrant();
        int q;
        Vector3 vec = cam.unproject(new Vector3(Gdx.input.getX(),Gdx.input.getY(),0));
       //Vector2 v = new Vector2(vec.x,vec.y);
        /*
        System.out.println("left: " + cameraFlagLeft);
        System.out.println("right: "+cameraFlag);
        System.out.println("prev: " + prev);
        System.out.println("now: " + pos);
        */
        int addedLines = 0;
        if(topLeft != null){
            if(false){
            }
            else if( prev >= 1 && pos < 3 && cameraFlag){
                System.out.println("case 1");
                left.add(new Line(topLeft.getEnd(),new Vector2(vec.x-2*c1,vec.y)));
                addedLines+=1;

            }

            else if(prev <= 1 && pos >= 2) {
                q = getQ(vec, 2 * c1);
                left.add(new Line(topLeft.getEnd(), new Vector2(2 * c1, q)));
                left.add(new Line(new Vector2(0, q), new Vector2((int) vec.x - 2 * c1, vec.y)));
                addedLines += 2;
                System.out.println("case 2");

            }
            else if(prev>= 2 && pos <= 1  && !cameraFlag){
                q = getReverseQ(vec,2*c1,0);
                left.add(new Line(topLeft.getEnd(),new Vector2(0,q)));
                left.add(new Line(new Vector2(2*c1, q),new Vector2(vec.x,vec.y)));
                addedLines+=2;
                System.out.println("case 3");

            }
            else if( pos > 1) {
                left.add(new Line(topLeft.getEnd() , new Vector2(vec.x - 2*c1,vec.y)));
                addedLines+=1;
                System.out.println("case 4");
            }
            else if(true){
                left.add(new Line(topLeft.getEnd() , new Vector2(vec.x,vec.y)));
                addedLines+=1;
                System.out.println("case 5");
            }
        }
        else{
            if(pos <=1){
                left.add(new Line(new Vector2(vec.x,vec.y) , new Vector2(vec.x,vec.y)));
                addedLines+=1;
            }
            else{System.out.println("case 1");
                left.add(new Line(new Vector2(vec.x-2*c1,vec.y) , new Vector2(vec.x-2*c1,vec.y)));
                addedLines+=1;
            }
        }
        if(addedLines==1 && left.get(left.size() -1).intersectsWithPolygons(landPolygons)) {
                left.remove(left.size() - 1);

        }
        else if(addedLines == 2 && (left.get(left.size()-1).intersectsWithPolygons(landPolygons) ||
                left.get(left.size()-1).intersectsWithPolygons(landPolygons))){
            left.remove(left.size() - 1);
            left.remove(left.size() - 1);

        }
        else{
            prev = pos;
            topLeft = left.get(left.size()-1);
            cameraFlag=false;
            cameraFlagLeft=false;

        }
        System.out.println("contains too big x  " + containsTooBigX());

    }

    private int getReverseQ(Vector3 pos, int transitionPoint,int no){
        Vector2 v = topLeft.getEnd();
        Vector2 last;
        if(no == 0){
            last = new Vector2(v.x+transitionPoint,v.y);
        }
        else{
            last = new Vector2(v.x,v.y);
        }

        double angle = Math.atan((pos.y-last.y)/(last.x-pos.x)); //Math.atan(((double) (pos.y - last.y))/ ((double)(pos.x -last.x)) );
        double q =  (last.x - transitionPoint) * Math.tan(angle);
        return (int) (q+ last.y);
    }

    private int getQ2(Vector3 pos, int transitionPoint){
        Vector2 last = topLeft.getEnd();
        last = new Vector2(last.x+transitionPoint,last.y);
        double angle = Math.atan(((double) (pos.y - last.y))/ ((double)(pos.x -last.x)) );
        double q =  (transitionPoint - last.x ) * Math.tan(angle);
        return (int) (q+ last.y);
    }


    private int getQ(Vector3 pos, int transitionPoint){
        Vector2 last = topLeft.getEnd();
        double angle = Math.atan(((double) (pos.y - last.y))/ ((double)(pos.x -last.x)) );
        double q =  (transitionPoint - last.x ) * Math.tan(angle);
        return (int) (q+ last.y);


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

    public void drawPath3(){
        updateCameraTransition();

        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(Color.RED);
        for(Line l : left){
            l.draw(shapeRenderer);
            l.leftToRight(2*c1).draw(shapeRenderer);
        }
        shapeRenderer.setColor(Color.GOLD);
        if(topLeft!= null) {
            shapeRenderer.circle(topLeft.getEnd().x, topLeft.getEnd().y, 10);
            shapeRenderer.setColor(Color.MAGENTA);
            shapeRenderer.circle(topLeft.getEnd().x+2*c1, topLeft.getEnd().y, 10);
        }
        shapeRenderer.end();
    }

    private void updateCameraTransition(){
        Vector3 v = cam.unproject(new Vector3(cam.position.x,cam.position.y,0));
        if(v.x<c1*2&& previousCameraPosition > c1*2  ){
            cameraFlag = true;
            cameraFlagLeft=false;
        }
        if(previousCameraPosition <=c1*2 && v.x>=2 *c1 ){
            cameraFlagLeft = true;
            cameraFlag = false;
        }
        previousCameraPosition = (int) v.x;

    }

    public boolean containsTooBigX(){
        for(Line l: left){
            if(l.containsTooBigX(2*c1)){
                return true;
            }
        }
        return false;
    }








    public ArrayList<Line> getPositions(){
        return left;
    }
}
