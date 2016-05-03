package ch.inf.usi.pf2.project.gameStates;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by alexandercamenzind on 28/04/16.
 */
public class MiniGame extends gameState {
    private SpriteBatch batch;
    private OrthographicCamera cam;
    private Sprite bg;


    public MiniGame(SpriteBatch batch){

        float aspectRatio = (float) Gdx.graphics.getWidth() / (float) Gdx.graphics.getHeight();
        this.cam = new OrthographicCamera(2f * aspectRatio, 2f);
        this.batch=batch;
    }

    @Override
    public void renderGameObject(){

        // resets the frame probably
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        cam.update();
        batch.setProjectionMatrix(cam.combined);

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
