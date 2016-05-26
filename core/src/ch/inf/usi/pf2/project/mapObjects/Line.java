package ch.inf.usi.pf2.project.mapObjects;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.objects.PolygonMapObject;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;

/**
 * Created by alexandercamenzind on 22/05/16.
 */
public class Line {
    private Vector2 start;
    public int startQuadrant;
    private Vector2 end;
    public int endQuadrant;
    private double length;
    private Vector2 direction;
    private float angle;
    private boolean addedTwo;

    public Line(Vector2 start, Vector2 end, int startQuadrant,int endQuadrant){
        this.start = start;
        this.end =end;
        double dx =   end.x-start.x;
        double dy =   end.y-start.y;
        length = Math.sqrt(dx*dx+dy*dy);
        direction = new Vector2((float) (dx/length),(float) (dy/length));
        angle = direction.angle();
        this.startQuadrant=startQuadrant;
        this.endQuadrant=endQuadrant;
        this.addedTwo=false;

    }

    public Vector2 getEnd(){
        return  end;
    }
    public Vector2 getStart(){ return start;}

    public void draw(ShapeRenderer shapeRenderer){
        shapeRenderer.rectLine(start.x, start.y, end.x, end.y, 5);
    }

    public Line leftToRight(int c){
        return new Line(new Vector2(start.x+c,start.y), new Vector2(end.x+c,end.y),0,0);
    }

    public double getLength() {
        return length;
    }

    public Vector2 getDirection() {
        return direction;
    }

    public boolean intersectsWithPolygons(MapObjects polys){
        boolean res =false;
        for(MapObject o:polys){
            if(o instanceof PolygonMapObject){
                Polygon p = ((PolygonMapObject) o).getPolygon();
                if(Intersector.intersectSegmentPolygon(start,end,p)){
                    res =true;
                }

            }
        }
        return res;
    }

    public int computeQ(int position){
        double alpha = Math.atan((double) ((end.y-start.y)/(end.x-start.x)));
        return (int) (((position - start.x ) * Math.tan(alpha))+start.y);
    }

    public boolean containsTooBigX(int bound){
        return (start.x > bound || end.x > bound);
        }

    public void swqpQuadrants(){
        if(startQuadrant>=2){
            startQuadrant-=2;
        }
        else{
            startQuadrant+=2;
        }
        if(endQuadrant>=2){
            endQuadrant-=2;
        }
        else {
            endQuadrant+=2;
        }
    }

    //c should be 1/4 of the worldwidth
    public void addLine(ArrayList<Line> list, int c){
        int sq = startQuadrant;
        int eq = endQuadrant;

        Line v1;
        Line v2;
        if(sq< 2 && eq<2){
            list.add(this);
            System.out.println("case 1");
        }
        else if(sq >=2 && eq >= 2){
            list.add(new Line(new Vector2(start.x,start.y),new Vector2(end.x-2*c,end.y),sq,eq));
            System.out.println("case 2");
        }
        else if(sq<2 && eq>=2){ //needs to be modified such that it doesn't work when we wrapped around the screen
            int q = computeQ(2*c);
            v1 = new Line(start, new Vector2(2*c,q), sq,eq);
            v2 = new Line(new Vector2(0,q), new Vector2(end.x-2*c, end.y),sq,eq);
            v2.addedTwo = true;
            list.add(v1);
            list.add(v2);
            System.out.println("case 3");
        }
        else if(sq>=2 && eq<2){
            v1 = new Line(new Vector2(start.x+2*c,start.y),end,0,0);
            int q = v1.computeQ(2*c);
            v1 = new Line(start,new Vector2(0,q),sq,sq);
            v2 = new Line(new Vector2(2*c,q),end,eq,eq);
            v2.addedTwo=true;
            list.add(v1);
            list.add(v2);
        }


    }


}
