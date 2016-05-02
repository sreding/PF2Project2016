package ch.inf.usi.pf2.project.GameObjecets;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

/**
 * Created by alexandercamenzind on 28/04/16.
 */
public class Map extends GameObject {

    private SpriteBatch batch;
    private OrthographicCamera cam;
    private Sprite worldMap;

    public Map(SpriteBatch batch){
        this.batch = batch;
        float h = Gdx.graphics.getHeight();
        float w = Gdx.graphics.getWidth();
        worldMap = new Sprite(new Texture("worldMap2.jpg"));

        this.cam = new OrthographicCamera(w,h);
        cam.position.set(worldMap.getWidth() / 2f, worldMap.getHeight() / 2f, 0);

        cam.update();



    }

    @Override
    public void renderGameObject(){

        // resets the frame probably
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        //updates the camera
        cam.update();
        batch.setProjectionMatrix(cam.combined);

        //this is where we can actually display stuff on the screen
        batch.begin();
        worldMap.draw(batch);
        batch.end();
    }

    @Override
    public void update(float dt){
    }

    @Override
    public void inputHandler(){
        cam.translate(-Gdx.input.getDeltaX(),Gdx.input.getDeltaY());
    }
}
