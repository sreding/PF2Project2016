package ch.inf.usi.pf2.project.GameObjecets;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.Texture;

/**
 * Created by alexandercamenzind on 27/04/16.
 */
public class Menu extends GameObject {
    private SpriteBatch batch;
    private final Texture background;


    public Menu(SpriteBatch batch){
        this.batch = batch;
        this.background = new Texture("badlogic.jpg");
    }

    @Override
    public void renderObject() {

        // resets the frame probably
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        //this is where we can actually display stuff on the screen
        batch.begin();

        batch.draw(background,400,300);

        batch.end();

    }
}
