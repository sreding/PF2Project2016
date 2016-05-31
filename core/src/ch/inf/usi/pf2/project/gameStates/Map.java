package ch.inf.usi.pf2.project.gameStates;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.MapProperties;
import com.badlogic.gdx.maps.objects.EllipseMapObject;
import com.badlogic.gdx.maps.objects.PolygonMapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Ellipse;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ButtonGroup;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.VerticalGroup;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import ch.inf.usi.pf2.project.mapObjects.Boat;
import ch.inf.usi.pf2.project.mapObjects.BoatButton;
import ch.inf. usi.pf2.project.mapObjects.Button;
import ch.inf.usi.pf2.project.mapObjects.Player;
import ch.inf.usi.pf2.project.mapObjects.Ports;
import ch.inf.usi.pf2.project.mapObjects.Port;
import javafx.scene.input.TouchEvent;

import java.util.ArrayList;

/**
 * Created by alexandercamenzind on 28/04/16.
 */
public class Map extends GameState {



    //TODO: Add money to player class for completed task(?) (now have a function to calculate the air distance between two ports)
    //TODO: Reset button, such that you can cancel making a path (at least it cancels the selection now)
    //TODO: Add a button that allows you to switch from drawing to moving, while in drawing mode
    //TODO: format the buttons nicely
    //TODO: maybe add dialogs for stuff


    // all the stuff we need for drawing
    private SpriteBatch batch;
    private final Matrix4 initialProjectionMatrix;


    private OrthographicCamera cam;
    private ShapeRenderer shapeRenderer;
    private TiledMap tiledMap;
    private TiledMapRenderer tiledMapRenderer;
    private MapProperties prop;

    // MAP_WIDTH is the width of the background in pixel
    // MAP_HEIGHT is the height of the background in pixel
    private int MAP_WIDTH;
    private int MAP_HEIGHT;


    private MapObjects polygonMapObjects;


    private int mode; // 0 = moving, 1 = drawing
    private Player player;

    private Boat courrentBoat;
    private Port currentPort;
    private Vector3 portTouchedCoordinates;
    private boolean start;

    private boolean touchUp;
    private boolean wasTouched;
    private boolean modeChanged;
    private boolean stageButtonTouched;
    private boolean boatselected;
    private boolean drawing;
    private boolean selectingBoat;

    private Stage stage; //

    private TextButton managerNext;
    private TextButton newsNext;
    private int nextState;
    private Label playerMoney;
    private Skin skin;
    private ArrayList<BoatButton> boatButtons;


    public Map(SpriteBatch batch,Player player){
        System.out.println(Gdx.input.getInputProcessor());
        this.batch = batch;
        this.initialProjectionMatrix = batch.getProjectionMatrix().cpy();

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

        this.polygonMapObjects = tiledMap.getLayers().get("Polygons").getObjects();




        Boat testBoat = new Boat(9000,1000,50,99999,0, new Sprite(new Texture("topBoat1.png")),
                new Sprite(new Texture("sideBoat1.png")),this.batch,cam,shapeRenderer, MAP_WIDTH, polygonMapObjects ,"test boat");
        Boat testBoat2 = new Boat(9000,1000,50,99999,0, new Sprite(new Texture("topBoat1.png")),
                new Sprite(new Texture("sideBoat5.png")),this.batch,cam,shapeRenderer, MAP_WIDTH, polygonMapObjects ,"another TestBoat");

        this.player=player;
        player.addPossibleBoats(this.batch, this.cam,this.shapeRenderer,this.MAP_WIDTH,polygonMapObjects); // SpriteBatch batch, OrthographicCamera cam, ShapeRenderer shapeRenderer, int WORLD_WIDTH,MapObjects landPolygons,

        //player.addBoat(testBoat);
        //player.addBoat(testBoat2);







        // i think we might need this
        Gdx.gl.glClearColor(1, 1, 1, 1);

        mode = 0;
        touchUp=false;
        wasTouched=false;
        modeChanged=false;
        this.skin = new Skin(Gdx.files.internal("uiskin.json"));

        stage=new Stage(new ScreenViewport(),batch);

        Gdx.input.setInputProcessor(stage);

        stageButtonTouched =false;
        boatselected=false;
        drawing=false;

        start = false;
        selectingBoat=false;


        nextState =0;
        playerMoney = new Label("$$$$ Money $$$$$: ",skin );
        playerMoney.setColor(Color.GOLDENROD);
        permanentActors();
        boatButtons=new ArrayList<BoatButton>();


    }

    @Override
    public void renderGameObject(){


        Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA); // im not sure what that does but i'll leave it in case we need it
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // we have to update the camera, before we can render
        cam.update();
        tiledMapRenderer.setView(cam);
        tiledMapRenderer.render();


        for(Boat b: player.getBoats()){
            //if(b.getCurrentPath() != null)
            b.getCurrentPath().drawPath3(mode);
        }

        // batch will draw according to screen coordinates
        batch.begin();
        batch.setProjectionMatrix(cam.combined);
        player.getPorts().drawPorts(batch);

        for(Boat b: player.getBoats()){
            b.drawBoatOnMap();
        }


        batch.setProjectionMatrix(initialProjectionMatrix);





        batch.end();

        stage.draw();

       // showHitBoxes();
        //showPorts();
        showPolygons();

    }

    // We should write everything that gets updated every frame in here
    @Override
    public void update(float dt){
        for(Boat b : player.getBoats()) {
            if (b != null) {
                b.updateBoat(dt);
            }
        }
        Gdx.input.setInputProcessor(stage);
        player.updateDamage();
        player.updateMoney();
        playerMoney.setText("Cash: " + player.money + "$");
        pushCameraBack();
    }


    // handles input events
    @Override
    public void inputHandler(){



        stage.act(Gdx.graphics.getDeltaTime());


        if(newsNext.isPressed()||managerNext.isPressed()){
            stageButtonTouched=true;
        }

        if(! Gdx.input.isTouched() && wasTouched){
            touchUp =true;
        }






        Port p = player.getPorts().handlePortInput(cam);
        if(p!= null && Gdx.input.justTouched() && !selectingBoat){
            System.out.println("wut");
            if(!drawing){
                showBoatButtonList();
            }
            currentPort = p;
            portTouchedCoordinates = cam.unproject(new Vector3(Gdx.input.getX(),Gdx.input.getY(),0));
            start=true;
        }




        // moves the camera across the background according to dx and dy
        if(mode == 0 && !selectingBoat) {
            cam.translate(-Gdx.input.getDeltaX(), Gdx.input.getDeltaY());
        }
        else if(mode == 1 && !modeChanged && touchUp && !stageButtonTouched){
            if(courrentBoat.getCurrentPath().inputPath4(p)){
                mode = 0;
                drawing=false;
                stage.clear();
                permanentActors();
                courrentBoat.setVisible(true);
                courrentBoat.startBoat();

            }
            start=false;

        }
        stageButtonTouched=false;





        if(touchUp){
            modeChanged=false;
        }
        touchUp=false;
        wasTouched=Gdx.input.isTouched();

    }

    // this method pushes the camera back in bound, if someone tried to leave bounds,
    // also it will make the illusion of an infinite background
    private void pushCameraBack(){
        Vector3 pos = cam.position;
        if(pos.x + cam.viewportWidth/2 > MAP_WIDTH ){
            cam.position.x = 2*MAP_WIDTH/4 - cam.viewportWidth/2;
            if(courrentBoat!= null) {
                courrentBoat.getCurrentPath().notifyPath(); //tells the path, that we just wrapped around the screen
            }
        }
        else if(pos.x - cam.viewportWidth/2< 0){
            cam.position.x = 2*MAP_WIDTH/4 + cam.viewportWidth/2;
            if(courrentBoat != null) {
                courrentBoat.getCurrentPath().notifyPath();
            }
        }

        if(cam.position.y - cam.viewportHeight/2 <0){
            cam.position.y = cam.viewportHeight/2;
        }
        if(cam.position.y + cam.viewportHeight/2 > MAP_HEIGHT){
            cam.position.y = MAP_HEIGHT - cam.viewportHeight/2;
        }
    }

    // this method will draw a red rectangle at the hitboxes defined in the tiled map
    /*
    private void showHitBoxes(){
        shapeRenderer.setProjectionMatrix(cam.combined);

        for(MapObject object : objects){
            if(object instanceof RectangleMapObject){


                RectangleMapObject rec =  (RectangleMapObject) object;

                shapeRenderer.begin(ShapeType.Filled);
                shapeRenderer.setColor(Color.RED);
                Rectangle r = rec.getRectangle();
                shapeRenderer.rect(r.x, r.y, r.width, r.height);
                shapeRenderer.rect(r.x+MAP_WIDTH/2,r.y,r.width,r.height);
                shapeRenderer.end();
            }
        }

    }
    */



    private void showPolygons(){
        shapeRenderer.setProjectionMatrix(cam.combined);
        shapeRenderer.begin(ShapeType.Line);
        shapeRenderer.setColor(Color.GREEN);
        for(MapObject o : polygonMapObjects){
            if(o instanceof PolygonMapObject){
                Polygon p = ((PolygonMapObject) o).getPolygon();

                float[] prevVertices = p.getVertices();
                float[] vertices =new float[prevVertices.length];
                float offsetX = p.getX();
                float offsetY = p.getY();
                for(int i = 0; i< vertices.length;i++){
                    if(i%2 == 0){
                        vertices[i] = prevVertices[i]+offsetX;
                    }
                    else{
                        vertices[i] = prevVertices[i]+offsetY;
                    }
                }
                shapeRenderer.polygon(vertices);

            }
        }

        shapeRenderer.end();
    }

    public void showBoatButtonList(){
        selectingBoat=true;

        Table table2 = new Table();
        table2.align(Align.top | Align.center);
        table2.setFillParent(true);



        Table table = new Table();
       // table.setFillParent(true);
        table.align(Align.top| Align.center);
        table.setWidth(stage.getWidth());
        table.setHeight(stage.getHeight());
        //table.debug();



        final TextButton confirm = new TextButton("Confirm",skin);
        confirm.getLabel().setFontScale(Gdx.graphics.getWidth()/1810f,Gdx.graphics.getHeight()/1080f);

        confirm.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {

                stageButtonTouched=true;
                if(boatselected) {
                    courrentBoat.getCurrentPath().addFirstLine(currentPort, portTouchedCoordinates);
                    stage.clear();
                    boatButtons.clear();
                    mode = 1;
                    drawing=true;
                    selectingBoat=false;
                    permanentActors();
                    boatselected=false;


                }
            }
        });
        final TextButton cancel = new TextButton("cancel",skin);
        cancel.getLabel().setFontScale(Gdx.graphics.getWidth()/1810f,Gdx.graphics.getHeight()/1080f);
        cancel.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                stage.clear();
                boatButtons.clear();
                mode=0;
                drawing =false;
                selectingBoat=false;
                permanentActors();
                boatselected=false;

            }
        });



        //table.add(confirm);
        VerticalGroup verticalGroup2 = new VerticalGroup();
        verticalGroup2.setWidth(Gdx.graphics.getWidth()/4);
        verticalGroup2.fill();
        verticalGroup2.addActor(confirm);
        verticalGroup2.addActor(cancel);
        TextButton text  =new TextButton("select boat",skin);
        text.setColor(Color.BLACK);
        verticalGroup2.addActor(text);
        verticalGroup2.padTop(Gdx.graphics.getHeight()/2 - verticalGroup2.getPrefHeight());
        confirm.setWidth(Gdx.graphics.getWidth()/4);


        //verticalGroup2.fill();
        table2.add(verticalGroup2).width(Gdx.graphics.getWidth()/4);//.width(Gdx.graphics.getWidth()/4).padTop();



        VerticalGroup verticalGroup = new VerticalGroup();
        verticalGroup.fill();


        ScrollPane scrollPane =  new ScrollPane(verticalGroup);
        scrollPane.setHeight(stage.getHeight()/2);
        scrollPane.setWidth(Gdx.graphics.getWidth()/4);

        for(Boat b: player.getBoats()){
            final BoatButton tb = new BoatButton(b.getLabel(),skin,b);
            tb.getLabel().setFontScale(Gdx.graphics.getWidth()/1810f,Gdx.graphics.getHeight()/1080f);
            if(b.isTraveling()){
                tb.setColor(Color.RED);
            }
            verticalGroup.addActor(tb);
            boatButtons.add(tb);
            tb.addListener(new ClickListener() {
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    if(!tb.getB().isTraveling()) {
                        courrentBoat = tb.getB();
                    }
                    int i =0;
                    for(Boat b: player.getBoats()){
                        b.getCurrentPath().active=false;
                        BoatButton bb = boatButtons.get(i++);
                        bb.setColor(Color.GOLD);
                        if(bb.getB().isTraveling()){
                            bb.setColor(Color.RED);
                        }


                    }
                    if(!tb.getB().isTraveling()) {
                        courrentBoat.getCurrentPath().active = true;
                        boatselected = true;
                        tb.setColor(Color.GREEN);
                    }
                    stageButtonTouched = true;
                    //stage.clear();
                    //start to draw
                }
            });}




        table.add(scrollPane).width(Gdx.graphics.getWidth()/4).height(Gdx.graphics.getHeight()/2).padTop(Gdx.graphics.getHeight()/2);//.padTop(4*Gdx.graphics.getHeight()/5);

        stage.addActor(table);
        stage.addActor(table2);
        Gdx.input.setInputProcessor(stage);

    }

    private void permanentActors(){

        Table table = new Table();

        table.setFillParent(true);
        if(drawing){
            TextButton undo = new TextButton("undo",skin);
            undo.getLabel().setFontScale(Gdx.graphics.getWidth()/1810f,Gdx.graphics.getHeight()/1080f);
            undo.addListener(new ClickListener() {
                @Override
                public void clicked(InputEvent event, float x, float y) {

                    courrentBoat.getCurrentPath().undo();
                    stageButtonTouched=true;
                }
            });

            TextButton moveDraw = new TextButton("move/draw",skin);
            moveDraw.getLabel().setFontScale(Gdx.graphics.getWidth()/1810f,Gdx.graphics.getHeight()/1080f);
            moveDraw.addListener(new ClickListener() {
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    mode+=1;
                    mode%=2;
                    stageButtonTouched=true;
                }
            });

            table.add(undo);
            table.add(moveDraw);


        }
        TextButton manager = new TextButton("Manager",skin);
        manager.getLabel().setFontScale(Gdx.graphics.getWidth()/1810f,Gdx.graphics.getHeight()/1080f);
        managerNext =manager;
        TextButton news = new TextButton("News",skin);
        news.getLabel().setFontScale(Gdx.graphics.getWidth()/1810f,Gdx.graphics.getHeight()/1080f);
        newsNext=news;

        table.align(Align.bottom| Align.left);
        table.add(manager);
        table.add(news);

        stage.addActor(table);
        Table monaaay = new Table();
        monaaay.setFillParent(true);
        monaaay.align(Align.topLeft);
        monaaay.add(playerMoney);
        stage.addActor(monaaay);
        Gdx.input.setInputProcessor(stage);

    }

    @Override
    public int nextState(){
        if(newsNext.isPressed() && Gdx.input.justTouched()){
            selectingBoat=false;
            stage.clear();
            permanentActors();
            return 1;
        }
        else if(managerNext.isPressed() && Gdx.input.justTouched()){
            selectingBoat=false;
            stage.clear();
            permanentActors();
            return 2;
        }
        else {
            return 0;
        }
    }






}
