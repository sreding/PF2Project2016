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
    private int c1;

    private ArrayList<Vector2> positionsLeft;
    private ArrayList<Vector2> positionsRight;

    private  ArrayList<Line> left;
    private Line topLeft;
    private  ArrayList<Line> right;
    private Line topRight;

    private boolean cameraFlag;
    private int previousCameraPosition;




    //private int quadrant; // 0 == 1st quadrant, 1 = 2nd , 3 = 3rd, 4 = 4th
    private int prev;



    public Path(ShapeRenderer shapeRenderer, OrthographicCamera cam, int MAP_WIDTH){
        this.shapeRenderer = shapeRenderer;

        positions = new ArrayList<Vector2>();
        positionsLeft =new ArrayList<Vector2>();
        positionsRight =new ArrayList<Vector2>();

        left = new ArrayList<Line>();
        right = new ArrayList<Line>();


        this.cam =cam;
        c1=MAP_WIDTH/4;


    }


    public void addPoint(int x, int y){
        if(checkCollision(x,y)) {
            positions.add(new Vector2(x, y));
        }
    }
    public void addPointLeft(int x, int y){
        if(checkCollision(x,y)) {
            positionsLeft.add(new Vector2(x, y));
        }
    }
    public void addPointRight(int x, int y){
        if(checkCollision(x,y)) {
            positionsRight.add(new Vector2(x, y));
        }
    }

    private boolean checkCollision(int x, int y){
        return true;
    }

    public void inputPath(){
            cam.update();
            Vector3 vec = cam.unproject(new Vector3(Gdx.input.getX(),Gdx.input.getY(),0));
            addPoint((int) (vec.x) ,(int) vec.y);

    }

    public void inputPath2(){

        Vector2 prev;
        Vector3 vec = cam.unproject(new Vector3(Gdx.input.getX(),Gdx.input.getY(),0));
        if(positionsLeft.size()<0){
             prev = positionsLeft.get(positionsLeft.size()-1);}
        else{
            prev = new Vector2(0,0);
        }
        if(vec.x>2*c1){
            double angle = Math.atan((vec.y-prev.y) / (vec.x-prev.x));
            double q = (2*c1-prev.x)*Math.tan(angle) + prev.y;
            addPointLeft(2*c1,(int) q);
            addPointRight(2*c1,(int) q);
            addPointLeft(0,0);
            addPointLeft((int)vec.x-2*c1,(int) vec.y);
            addPointRight((int) vec.x,(int) vec.y);
            }
        else{
            addPointLeft((int) vec.x, (int) vec.y);
        }
    }

    public void inputPath3(){
        int pos=computeQuadrant();
        int q;
        System.out.println(pos);
        Vector3 vec = cam.unproject(new Vector3(Gdx.input.getX(),Gdx.input.getY(),0));
       //Vector2 v = new Vector2(vec.x,vec.y);
        if(topLeft != null){
            if(false){
            }

            else if(prev <= 1 && pos >= 2){
                q = getQ(vec, 2*c1);

                left.add(new Line(topLeft.getEnd(), new Vector2(2*c1, q)));
                left.add(new Line(new Vector2(0, q), new Vector2((int) vec.x-2*c1, vec.y)));

            }
            else if(prev>= 2 && pos <= 1 && !cameraFlag){
                q = getReverseQ(vec,2*c1,0);
                left.add(new Line(topLeft.getEnd(),new Vector2(0,q)));
                left.add(new Line(new Vector2(2*c1, q),new Vector2(vec.x,vec.y)));

            }
            else if( pos > 1) {
                left.add(new Line(topLeft.getEnd() , new Vector2(vec.x - 2*c1,vec.y)));
               // right.add(new Line(topRight.getEnd(), new Vector2(vec.x+2*c1,vec.y)));
            }
            else if(true){
                left.add(new Line(topLeft.getEnd() , new Vector2(vec.x,vec.y)));
            }
        }
        else{
            if(pos <=1){
                left.add(new Line(new Vector2(vec.x,vec.y) , new Vector2(vec.x,vec.y)));
            }
            else{
                left.add(new Line(new Vector2(vec.x-2*c1,vec.y) , new Vector2(vec.x-2*c1,vec.y)));
            }
        }
        prev = pos;
        topLeft = left.get(left.size()-1);
        cameraFlag=false;
    }

    private int getReverseQ(Vector3 pos, int transitionPoint,int no){
        Vector2 v = topLeft.getEnd();
        Vector2 last;
        if(no == 0){
            last = new Vector2(v.x+transitionPoint,v.y);
        }
        else{
            last = new Vector2(v.x-transitionPoint,v.y);
        }

        double angle = Math.atan((pos.y-last.y)/(last.x-pos.x)); //Math.atan(((double) (pos.y - last.y))/ ((double)(pos.x -last.x)) );
        double q =  (last.x - transitionPoint) * Math.tan(angle);
        System.out.println(q);
        return (int) (q+ last.y);


    }


    private int getQ(Vector3 pos, int transitionPoint){
        Vector2 last = topLeft.getEnd();
        double angle = Math.atan(((double) (pos.y - last.y))/ ((double)(pos.x -last.x)) );
        double q =  (transitionPoint - last.x ) * Math.tan(angle);
        System.out.println(q);
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
        System.out.println(cameraFlag);
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(Color.RED);
        for(Line l : left){
            l.draw(shapeRenderer);
            l.leftToRight(2*c1).draw(shapeRenderer);
        }
        shapeRenderer.end();
    }

    private void updateCameraTransition(){
        Vector3 v = cam.unproject(new Vector3(cam.position.x,cam.position.y,0));
        if(v.x<c1*2&& previousCameraPosition > c1*2 ){
            cameraFlag = true;
        }
        previousCameraPosition = (int) v.x;

    }



    public void drawPath2(){
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(Color.RED);
        Vector2 prev;
        Vector2 pos;
        for(int i = 1; i < positionsLeft.size() ; i++) {
            pos = positionsLeft.get(i);
            prev = positionsLeft.get(i-1);
            if(!(pos.x+pos.y ==0 || prev.x+prev.y == 0) ) {
                shapeRenderer.rectLine(pos.x, pos.y, prev.x, prev.y, 5);
            }
        }
        for(int i = 1; i < positionsRight.size() ; i++) {
            pos = positionsRight.get(i);
            prev = positionsRight.get(i-1);
            shapeRenderer.rectLine(pos.x,pos.y,prev.x ,prev.y,5);
        }
        shapeRenderer.end();

    }


    public void drawPath(){
        Vector2 prev;
        Vector2 pos;

        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(Color.RED);
        for(int i = 1; i < positions.size() ; i++){
            pos = positions.get(i);
            prev = positions.get(i-1);
            shapeRenderer.rectLine(pos.x,pos.y,prev.x ,prev.y,5);
            if(0 <= pos.x && c1 <= 2*c1){
                shapeRenderer.rectLine(pos.x + c1*2,pos.y,prev.x+c1*2 ,prev.y,5);
            }
            if(2*c1<pos.x){
                shapeRenderer.rectLine(pos.x - c1*2,pos.y,prev.x - c1*2 ,prev.y,5);
            }

        }
        shapeRenderer.end();

    }

    public ArrayList<Vector2> getPositions(){
        return positions;
    }
}
