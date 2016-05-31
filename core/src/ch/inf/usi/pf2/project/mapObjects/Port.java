package ch.inf.usi.pf2.project.mapObjects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import java.util.Random;

/**
 * Created by simonreding on 18/05/16.
 */
public class Port extends Place{
    private int x;
    private int y;
    private String name;
    private Rectangle hitBox;
    private int incoming;
    private int outgoing;

    public Port(String name, Rectangle r){
        super((int)r.getX(),(int)r.getY(),name);
        this.name = name;
        this.hitBox=r;
        this.x = (int) r.getX();// (r.getX() + r.getWidth()/2);
        this.y = (int) r.getY();//(r.getY() +r.getHeight()/2);
        Random rn = new Random();
        this.incoming = rn.nextInt(500);
        this.outgoing = rn.nextInt(500);

    }//constructor


    public String getName() {
        return name;
    }

    public Rectangle getHitBox() {
        return hitBox;
    }

    public int getIncoming() {
        return incoming;
    }

    public Vector2 getCoordinates(){
        return new Vector2(x,y);
    }

    public int getOutgoing() {
        return outgoing;
    }
    public void drawPort(SpriteBatch batch,Sprite portSymbol, int WorldWidth){
        portSymbol.setSize(hitBox.getWidth(),hitBox.getHeight());
        portSymbol.setPosition(x,y);
        portSymbol.draw(batch);
        portSymbol.setPosition(x+WorldWidth/2,y);
        portSymbol.draw(batch);

    }

    public int distanceBetweenPorts(Port p1, Port p2, int WorldWidth){
        Vector2 left;
        Vector2 right;
        if(p1.getCoordinates().x>p2.getCoordinates().x){
            left = p2.getCoordinates();
            right = p1.getCoordinates();
        }
        else{
            left= p1.getCoordinates();
            right=p2.getCoordinates();
        }
        int val1 =(int) right.dst(left);
        int val2 = (int) right.dst(new Vector2(left.x+WorldWidth/2,left.y));
        System.out.println(Math.min(val1,val2));
        return Math.min(val1,val2);
    }
}
