package ch.inf.usi.pf2.project.gameStates;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Created by alexandercamenzind on 27/04/16.
 */
public class Menu extends GameState {
    private SpriteBatch batch;
    private final Texture background;


    public Menu(SpriteBatch batch){
        this.batch = batch;
        this.background = new Texture("badlogic.jpg");

    }

    @Override
    public void renderGameObject() {

        // resets the frame probably
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        //this is where we can actually display stuff on the screen
        batch.begin();

        batch.draw(new TextureRegion(background),100,100,100,100,200,200,1,1,0);

        batch.end();

    }
    public int nextState(){

        return 0;
    }
    @Override
    public void update(float dt){
    }

    @Override
    public void inputHandler(){
    }
}
