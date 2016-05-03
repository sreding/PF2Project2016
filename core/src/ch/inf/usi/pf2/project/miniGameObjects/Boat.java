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



    public Boat(Sprite pic, float pos_x, float pos_y, float worldHeight){
        boat = pic;
        float ratio = boat.getWidth() / boat.getHeight();
        //boat.setScale((worldHeight/5f)*ratio,worldHeight/5f);
        //boat.scale(worldHeight/5f);
        boat.setSize((worldHeight/5f)*ratio,worldHeight/5f);



        velocity = new Vector2(100,0);
        boat.setPosition(pos_x-boat.getWidth()/2f,pos_y-boat.getHeight()/2f);

    }

    public Sprite getBoat() {
        return boat;
    }

    public void updateBoat(float dt){
        boat.translate(velocity.x * dt,-velocity.y * dt);
    }

    public void handleInput(){
        if(Gdx.input.isTouched()){
            velocity.set(Gdx.input.getX(),Gdx.input.getY()-worldHeight/2f);
        }
    }

}
