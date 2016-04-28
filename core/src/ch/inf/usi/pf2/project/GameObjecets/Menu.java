package ch.inf.usi.pf2.project.GameObjecets;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Created by alexandercamenzind on 27/04/16.
 */
public class Menu extends GameObject {
    private SpriteBatch batch;
    private final Texture background;
    private int degree;

    private int x;
    private int y;


    public Menu(SpriteBatch batch){
        this.batch = batch;
        this.background = new Texture("badlogic.jpg");


        degree  = 0;
        x=0;
        y=0;
    }

    @Override
    public void renderObject() {

        // resets the frame probably
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        //this is where we can actually display stuff on the screen
        batch.begin();

        batch.draw(new TextureRegion(background),x-100,y-100,100,100,200,200,1,1,degree);

        batch.end();
        x = Gdx.input.getX();
        y = -Gdx.input.getY() + Gdx.graphics.getHeight();

        degree+=Gdx.input.getX();



    }
}
