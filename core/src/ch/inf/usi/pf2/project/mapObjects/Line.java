package ch.inf.usi.pf2.project.mapObjects;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by alexandercamenzind on 22/05/16.
 */
public class Line {
    private Vector2 start;
    private Vector2 end;

    public Line(Vector2 start, Vector2 end){
        this.start = start;
        this.end =end;
    }

    public Vector2 getEnd(){
        return  end;
    }

    public void draw(ShapeRenderer shapeRenderer){
        shapeRenderer.rectLine(start.x, start.y, end.x, end.y, 5);
    }

    public Line leftToRight(int c){
        return new Line(new Vector2(start.x+c,start.y), new Vector2(end.x+c,end.y));
    }

}
