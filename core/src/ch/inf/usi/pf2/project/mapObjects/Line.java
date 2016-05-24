package ch.inf.usi.pf2.project.mapObjects;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by alexandercamenzind on 22/05/16.
 */
public class Line {
    private Vector2 start;
    private Vector2 end;
    private double length;
    private Vector2 direction;

    public Line(Vector2 start, Vector2 end){
        this.start = start;
        this.end =end;
        double dx =   end.x-start.x;
        double dy =   end.y-start.y;
        length = Math.sqrt(dx*dx+dy*dy);
        direction = new Vector2((float) (dx/length),(float) (dy/length));
    }

    public Vector2 getEnd(){
        return  end;
    }
    public Vector2 getStart(){ return start;}

    public void draw(ShapeRenderer shapeRenderer){
        shapeRenderer.rectLine(start.x, start.y, end.x, end.y, 5);
    }

    public Line leftToRight(int c){
        return new Line(new Vector2(start.x+c,start.y), new Vector2(end.x+c,end.y));
    }

    public double getLength() {
        return length;
    }

    public Vector2 getDirection() {
        return direction;
    }
}
