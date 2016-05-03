package ch.inf.usi.pf2.project.gameStates;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

/**
 * Created by alexandercamenzind on 28/04/16.
 */
public class Map extends gameState {

    private SpriteBatch batch;
    private OrthographicCamera cam;
    private Sprite worldMap;

    public Map(SpriteBatch batch){
        this.batch = batch;

        worldMap = new Sprite (new Texture("worldMap2.jpg"));


        float aspectRatio = (float) Gdx.graphics.getWidth() / (float) Gdx.graphics.getHeight();
        this.cam = new OrthographicCamera(2f * aspectRatio, 2f);
        cam.setToOrtho(false);

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
        batch.draw(worldMap,0,0);
        batch.end();
    }

    @Override
    public void update(float dt){
        //cam.zoom-=0.2;
    }

    @Override
    public void inputHandler(){
        cam.translate(-Gdx.input.getDeltaX(),Gdx.input.getDeltaY());
    }
}
