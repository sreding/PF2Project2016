package ch.inf.usi.pf2.project.gameStates;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TiledMapTile;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer.Cell;

/**
 * Created by alexandercamenzind on 28/04/16.
 */
public class Map extends gameState {

    private SpriteBatch batch;
    private OrthographicCamera cam;

    private TiledMap tiledMap;
    private TiledMapRenderer tiledMapRenderer;
    private TiledMapTileLayer layer;

    private int index1;
    private int index2;

    public Map(SpriteBatch batch){
        this.batch = batch;
        float w = Gdx.graphics.getWidth();
        float h = Gdx.graphics.getHeight();
        cam = new OrthographicCamera();
        cam.setToOrtho(false,500*w/h,500);
        cam.update();

        tiledMap = new TmxMapLoader().load("tileWorldMap.tmx");
        tiledMapRenderer = new OrthogonalTiledMapRenderer(tiledMap);
        layer = (TiledMapTileLayer) tiledMap.getLayers().get(0);

        index1 =0;
        index2 = 0;



        /*
        worldMap = new Sprite (new Texture("worldMap2.jpg"));


        float aspectRatio = (float) Gdx.graphics.getWidth() / (float) Gdx.graphics.getHeight();
        this.cam = new OrthographicCamera(2f * aspectRatio, 2f);
        cam.setToOrtho(false);
        */




    }

    @Override
    public void renderGameObject(){

        Gdx.gl.glClearColor(1, 1, 1, 1);
       // Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        cam.update();
        tiledMapRenderer.setView(cam);
        tiledMapRenderer.render();

        for(int i = 0; i<100; i++ ){
            for(int j = 0; j < 50; j++){
                Cell c = layer.getCell(i,j);
                if(i % 2 == 0){
                    c.setFlipVertically(true);
                }
                else {
                    c.setFlipHorizontally(true);
                }

            }
        }



        /*
        // resets the frame probably
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        //updates the camera
        cam.update();
        batch.setProjectionMatrix(cam.combined);

        //this is where we can actually display stuff on the screen
        batch.begin();

        batch.end();
        */
    }

    @Override
    public void update(float dt){
        //cam.zoom-=0.2;

    }

    @Override
    public void inputHandler(){
        cam.translate(-Gdx.input.getDeltaX(),Gdx.input.getDeltaY());
        if(Gdx.input.isTouched() && Gdx.input.getX() > 1000){
            //cam.zoom -= 0.1;
        }
    }
}
