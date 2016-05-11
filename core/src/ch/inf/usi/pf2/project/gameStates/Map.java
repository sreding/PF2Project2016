package ch.inf.usi.pf2.project.gameStates;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.MapProperties;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TiledMapTile;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer.Cell;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

import ch.inf. usi.pf2.project.mapObjects.Button;
import java.util.ArrayList;
/**
 * Created by alexandercamenzind on 28/04/16.
 */
public class Map extends gameState {

    private SpriteBatch batch;
    private OrthographicCamera cam;

    private TiledMap tiledMap;
    private TiledMapRenderer tiledMapRenderer;
    private TiledMapTileLayer layer;
    private MapProperties prop;

    private int MAP_WIDTH;
    private int MAP_HEIGHT;
    private MapObjects objects;

    private ShapeRenderer shapeRenderer;

    private ArrayList<Button> buttons;


    public Map(SpriteBatch batch){
        this.batch = batch;
        shapeRenderer= new ShapeRenderer();


        //set up camera
        float w = Gdx.graphics.getWidth();
        float h = Gdx.graphics.getHeight();
        cam = new OrthographicCamera();
        cam.setToOrtho(false,720*w/h,720);
        cam.update();

        //set up map
        tiledMap = new TmxMapLoader().load("tileWorldMap.tmx");
        tiledMapRenderer = new OrthogonalTiledMapRenderer(tiledMap);
        layer = (TiledMapTileLayer) tiledMap.getLayers().get(0);
        prop = tiledMap.getProperties();
        MAP_HEIGHT = prop.get("height", Integer.class) * prop.get("tileheight", Integer.class);
        MAP_WIDTH = prop.get("width", Integer.class) * prop.get("tilewidth", Integer.class);
        this.objects = tiledMap.getLayers().get("Object Layer 1").getObjects();

        //set up buttons
        buttons = new ArrayList<Button>();
        buttons.add(new Button(100,50,20, new Sprite(new Texture("buttonTest.png"))));





    }

    @Override
    public void renderGameObject(){

        Gdx.gl.glClearColor(1, 1, 1, 1);
       // Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        cam.update();
        tiledMapRenderer.setView(cam);
        tiledMapRenderer.render();

        batch.begin();

        for(Button b: buttons){
            b.drawButton(batch);
        }

        batch.end();


      showHitBoxes();






    }

    @Override
    public void update(float dt){
        //cam.zoom-=0.2;
        pushCameraBack();

    }

    @Override
    public void inputHandler(){

        cam.translate(-Gdx.input.getDeltaX(),Gdx.input.getDeltaY());

        if(Gdx.input.justTouched()){
            System.out.println(cam.unproject(new Vector3(Gdx.input.getX(), Gdx.input.getY(),0)).x);
        }

        if(buttons.get(0).isTouched()){
            System.out.println("button pressed");

        }
    }

    private void pushCameraBack(){
        Vector3 pos = cam.position;
        if(pos.x> 3*MAP_WIDTH/4){
            cam.position.x = MAP_WIDTH/4;
        }
        else if(pos.x< MAP_WIDTH/4){
            cam.position.x = 3*MAP_WIDTH/4;
        }
/*
        if(cam.position.x - cam.viewportWidth/2 < 0){
            cam.position.x = cam.viewportWidth/2;
        }
        if(cam.position.x + cam.viewportWidth/2 > MAP_WIDTH){
            cam.position.x = MAP_WIDTH - cam.viewportWidth/2;
        }
        */
        if(cam.position.y - cam.viewportHeight/2 <0){
            cam.position.y = cam.viewportHeight/2;
        }
        if(cam.position.y + cam.viewportHeight/2 > MAP_HEIGHT){
            cam.position.y = MAP_HEIGHT - cam.viewportHeight/2;
        }
    }

    private void showHitBoxes(){
        shapeRenderer.setProjectionMatrix(cam.combined);

        for(MapObject object : objects){
            if(object instanceof RectangleMapObject){


                RectangleMapObject rec =  (RectangleMapObject) object;

                shapeRenderer.begin(ShapeType.Filled);
                shapeRenderer.setColor(Color.RED);
                Rectangle r = rec.getRectangle();
                shapeRenderer.rect(r.x, r.y, r.width, r.height);
                shapeRenderer.end();
            }
        }

    }



}
