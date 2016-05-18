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
import com.badlogic.gdx.maps.objects.EllipseMapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Ellipse;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

import ch.inf. usi.pf2.project.mapObjects.Button;
import ch.inf.usi.pf2.project.mapObjects.Path;
import ch.inf.usi.pf2.project.mapObjects.Ports;

import java.util.ArrayList;
/**
 * Created by alexandercamenzind on 28/04/16.
 */
public class Map extends GameState {

    // all the stuff we need for drawing
    private SpriteBatch batch;
    private OrthographicCamera cam;
    private ShapeRenderer shapeRenderer;
    private TiledMap tiledMap;
    private TiledMapRenderer tiledMapRenderer;
    private MapProperties prop;

    // MAP_WIDTH is the width of the background in pixel
    // MAP_HEIGHT is the height of the background in pixel
    private int MAP_WIDTH;
    private int MAP_HEIGHT;
    private MapObjects objects;
    private MapObjects portObjects;

    private Ports ports;

    // a list to store all buttons
    private ArrayList<Button> buttons;

    // a list of paths
    private ArrayList<Path> paths;

    private int mode; // 0 = moving, 1 = drawing


    public Map(SpriteBatch batch){
        this.batch = batch;

        // setup shapeRenderer (allows us to draw stuff like rectangles or lines)
        shapeRenderer= new ShapeRenderer();

        // set up camera
        float w = Gdx.graphics.getWidth();
        float h = Gdx.graphics.getHeight();
        cam = new OrthographicCamera();
        cam.setToOrtho(false,720*w/h,720);
        cam.update();

        // set up map
        tiledMap = new TmxMapLoader().load("tileWorldMap.tmx");
        tiledMapRenderer = new OrthogonalTiledMapRenderer(tiledMap);
        prop = tiledMap.getProperties();
        MAP_HEIGHT = prop.get("height", Integer.class) * prop.get("tileheight", Integer.class);
        MAP_WIDTH = prop.get("width", Integer.class) * prop.get("tilewidth", Integer.class);
        this.objects = tiledMap.getLayers().get("SquarePorts").getObjects();
        this.portObjects = tiledMap.getLayers().get("Ports").getObjects();

        // set up buttons
        // we can add as many buttons as we need to this ArrayList
        buttons = new ArrayList<Button>();
        buttons.add(new Button(100,50,20, new Sprite(new Texture("buttonTest.png"))));

        //set up path, just a test
        paths = new ArrayList<Path>();
        paths.add(new Path(shapeRenderer, cam, MAP_WIDTH));

        this.ports = new Ports(objects, cam, MAP_HEIGHT);


        // i think we might need this
        Gdx.gl.glClearColor(1, 1, 1, 1);

        mode = 0;



    }

    @Override
    public void renderGameObject(){


        Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA); // im not sure what that does but i'll leave it in case we need it
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // we have to update the camera, before we can render
        cam.update();
        tiledMapRenderer.setView(cam);
        tiledMapRenderer.render();

        // batch will draw according to screen coordinates
        batch.begin();

        for(Button b: buttons){
            b.drawButton(batch);
        }
        batch.end();

        for(Path p : paths) {
            p.drawPath();
        }
        showHitBoxes();
        showPorts();






    }

    // We should write everything that gets updated every frame in here
    @Override
    public void update(float dt){

        pushCameraBack();
    }


    // handles input events
    @Override
    public void inputHandler(){


        boolean modeChanged = false;
        if(buttons.get(0).isTouched()){
            System.out.println("button pressed");
            mode += 1;
            mode %= 2;
            modeChanged = true;
        }

        // moves the camera across the background according to dx and dy
        if(mode == 0) {
            cam.translate(-Gdx.input.getDeltaX(), Gdx.input.getDeltaY());
        }
        else if(mode == 1 && !modeChanged && Gdx.input.justTouched()){
            paths.get(0).inputPath();

        }


        if(Gdx.input.justTouched()){
            ports.portTouched();
        }

    }

    // this method pushes the camera back in bound, if someone tried to leave bounds,
    // also it will make the illusion of an infinite background
    private void pushCameraBack(){
        Vector3 pos = cam.position;
        if(pos.x> 3*MAP_WIDTH/4){
            cam.position.x = MAP_WIDTH/4;
        }
        else if(pos.x< MAP_WIDTH/4){
            cam.position.x = 3*MAP_WIDTH/4;
        }

        // we probably wont need this anymore, but i will leave it in just in case
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

    // this method will draw a red rectangle at the hitboxes defined in the tiled map
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


    private void showPorts() {
    for(MapObject p : portObjects){
        if(p instanceof EllipseMapObject){
            shapeRenderer.setProjectionMatrix(cam.combined);

            Ellipse elip = ((EllipseMapObject) p).getEllipse();

            shapeRenderer.begin(ShapeType.Filled);
            shapeRenderer.setColor(Color.BLUE);
            shapeRenderer.ellipse(elip.x,elip.y,elip.width,elip.height);
            shapeRenderer.end();
        }
    }
    }


}
