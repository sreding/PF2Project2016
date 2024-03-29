package ch.inf.usi.pf2.project.gameStates;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import ch.inf.usi.pf2.project.miniGameObjects.Boat;

/**
 * Created by alexandercamenzind on 28/04/16.
 */
public class MiniGame extends GameState {
    private SpriteBatch batch;
    private OrthographicCamera cam;
    private Sprite bg;
    private Sprite bg2;

    private float WorldHeight;
    private float WorldWidth;
    private Boat boat;
    private float aspectRatio;


    public MiniGame(SpriteBatch batch){


        this.bg = new Sprite ( new Texture("miniGameBackground.png"));
        bg2= new Sprite (new Texture("miniGameBackground.png"));
        bg2.translateX(bg.getWidth());
        this.batch=batch;

        WorldHeight=bg.getHeight();
        WorldWidth=bg.getWidth();
        aspectRatio = (float) Gdx.graphics.getWidth() / (float) Gdx.graphics.getHeight();
        this.cam = new OrthographicCamera(WorldHeight * aspectRatio, WorldHeight);
        cam.position.set((WorldHeight * aspectRatio)/2f,WorldHeight/2f,0); 

        boat = new Boat(new Sprite( new Texture("testBoat.png")), (WorldHeight * aspectRatio)/2f, WorldHeight/2f, WorldHeight, WorldWidth);



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
        bg.draw(batch);
        bg2.draw(batch);
        boat.getBoat().draw(batch);
        batch.end();

    }

    public int nextState(){

        return 0;
    }

    @Override
    public void update(float dt){
        boat.updateBoat(dt);


        //this makes the background be infinite
        if(cam.position.x > 1.5 * WorldWidth ){
            boat.reset();
        }

        cam.position.set(boat.getBoat().getX()+(WorldHeight * aspectRatio)/2f, WorldHeight / 2f, 0);


    }

    @Override
    public void inputHandler(){
        boat.handleInput();
    }

}
