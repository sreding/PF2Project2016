package ch.inf.usi.pf2.project.GameObjecets;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.Texture;

/**
 * Created by alexandercamenzind on 28/04/16.
 */
public class MiniGame extends GameObject {
    private SpriteBatch batch;

    public MiniGame(SpriteBatch batch){
        this.batch=batch;
    }

    @Override
    public void renderGameObject(){

        // resets the frame probably
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        //this is where we can actually display stuff on the screen
        batch.begin();

        batch.end();


    }

    @Override
    public void update(float dt){
    }

    @Override
    public void inputHandler(){
    }

}
