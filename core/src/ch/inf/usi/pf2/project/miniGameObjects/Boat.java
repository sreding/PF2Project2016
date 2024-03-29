package ch.inf.usi.pf2.project.miniGameObjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by alexandercamenzind on 03/05/16.
 */
public class Boat {
    private Sprite boat;
    private Vector2 velocity;
    private float worldHeight;
    private float worldWidth;
    private float pos_x;
    private float pos_y;



    public Boat(Sprite pic, float pos_x, float pos_y, float worldHeight,float worldWidth){
        boat = pic;
        float ratio = boat.getWidth() / boat.getHeight();
        //boat.setScale((worldHeight/5f)*ratio,worldHeight/5f);
        //boat.scale(worldHeight/5f);
        boat.setSize((worldHeight/15f)*ratio,worldHeight/15f);

        this.worldHeight = worldHeight;
        this.worldWidth = worldWidth;
        this.pos_x = pos_x;
        this.pos_y = pos_y;

        velocity = new Vector2(0,0);
        boat.setPosition(pos_x-boat.getWidth()/2f,pos_y-boat.getHeight()/2f);

        System.out.println(boat.getHeight());

    }

    public Sprite getBoat() {
        return boat;
    }

    public void updateBoat(float dt){

        if(velocity.y*dt + boat.getY() +boat.getHeight()   < worldHeight && velocity.y*dt + boat.getY() >  0  ){
            boat.translateY(velocity.y * dt);
        }
        boat.translateX(velocity.x * dt);


    }


    //allows for infinite scrolling background doesnt really fit though
    public void reset(){
        //this.boat.setPosition(pos_x-boat.getWidth()/2f,pos_y-boat.getHeight()/2f);
        boat.setX(boat.getX() - worldWidth);
    }


    public void handleInput(){

        if(Gdx.input.isTouched()){
            velocity.set(Gdx.input.getX()/5,-1*(Gdx.input.getY()-Gdx.graphics.getHeight()/2f));
        }
    }

}
