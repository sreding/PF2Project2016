package ch.inf.usi.pf2.project.gameStates;
import ch.inf.usi.pf2.project.mapObjects.*;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.ui.VerticalGroup;
import com.badlogic.gdx.scenes.scene2d.ui.Widget;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Cell;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.Sprite;
import  com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.List;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Slider;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;


/**
 * Created by simonreding on 17/05/16.
 */
public class Manager extends GameState {

    private Player playerObject;
    private SpriteBatch batch;
    private TextureAtlas atlas;
    private OrthographicCamera cam;
    private ShapeRenderer shapeRenderer;
    private Table container;
    private Label label;
    private Actor window;
    private BitmapFont font;
    private Texture somebutton;
    private Stage stage;
    private Skin skin;
    private TextButton startButton;
    private TextButton quitButton;
    private Sprite sprite;
    private Label attributes;
    private Table table_atrributes;
    private Texture boat;
    private Table boat_attributes;
    private ScrollPane scrollPane;
    private List list_of_boats;
    private Table my_boats;
    private TextButton play;
    private TextButton back;
    private Texture background;
    private Sprite splash;
    private BitmapFont black;
    private VerticalGroup verticalGroup;
    private boolean bool;
    private String var;
    private Image actor;
    private TextureRegion region;
    private Table table;
    private ScrollPane scroll;
    private Boat testBoat;
    private Label name;
    private Label capacity;
    private Label speed;
    private Label distanceLimit;
    private Label maintenanceCost;
    private Label vulnerability;
    private Label boat_stats;
    private Label player_stats;
    private TextButton upgrade1;
    private TextButton upgrage2;
    private TextButton upgrade3;
    private TextButton buy;









    public Manager(SpriteBatch batch)
    {
        this.bool=true;
        this.batch=batch;
        stage = new Stage(new ScreenViewport(),batch);
        Skin skin = new Skin(Gdx.files.internal("uiskin.json"));
        Gdx.input.setInputProcessor(stage);
        testBoat = new Boat(1000,50,99999,0, new Sprite(new Texture("topBoat1.png")),
                new Sprite(new Texture("sideBoat1.png")),this.batch,cam,shapeRenderer, 0, null,"Fascinosa");
        // Gdx.graphics.setVSync(false);

        this.name = new Label("Name:"+" "+testBoat.getLabel(),skin);
        this.capacity = new Label("Capacity:"+" "+ testBoat.getCapacity(),skin);
        this.speed = new Label("Speed:"+" "+ testBoat.getSpeed(),skin);
        this.distanceLimit = new Label("Distance Limit:"+ " "+ testBoat.getDistanceLimit(),skin);
        this.maintenanceCost = new Label("Maintenance:"+ " "+ testBoat.getMaintenanceCost(),skin);
        this.vulnerability = new Label("Vulnerability:"+ " "+ testBoat.getVulnerability(),skin);
        this.boat_stats = new Label("BOAT STATS:",skin);
        this.player_stats = new Label("PLAYER STATS",skin);

        container = new Table();
        stage.addActor(container);
        container.setFillParent(true);
        //Uprages Buttons implementation:
        this.upgrade1 = new TextButton("Upgrade1:",skin);
        this.upgrage2 = new TextButton("upgrade2:",skin);
        this.upgrade3 = new TextButton("Upgrade3:",skin);
        this.buy = new TextButton("Buy this boat",skin);

        this.buy.setHeight(Gdx.graphics.getHeight()/4);
        this.buy.setWidth(Gdx.graphics.getWidth()/6);
        this.buy.setPosition(Gdx.graphics.getWidth()/6,Gdx.graphics.getHeight()/17);
        this.stage.addActor(buy);

        this.back = new TextButton("Back",skin);
        this.back.setHeight(Gdx.graphics.getHeight()/5);
        this.back.setWidth(Gdx.graphics.getWidth()/7);
        this.back.setPosition(0,0);
        this.stage.addActor(back);




        //this.back
        table = new Table(skin);
        System.out.println(Gdx.graphics.getDensity());
        table.getSkin().getFont("default-font").getData().setScale(0.6f*Gdx.graphics.getDensity(),0.6f*Gdx.graphics.getDensity());
        table.align(Align.right|Align.top);
        table.setPosition(0,container.getHeight());
        this.list_of_boats = new List(skin);
        this.list_of_boats.setItems(new String[] {"BOAT1", "BOAT2", "BOAT3", "BOAT4", "BOAT5", "BOAT6", "BOAT7","BOAT8", "BOAT9", "BOAT10","BOAT1", "BOAT2", "BOAT3", "BOAT4", "BOAT5", "BOAT6", "BOAT7","BOAT8", "BOAT9", "BOAT10","BOAT1", "BOAT2", "BOAT3", "BOAT4", "BOAT5", "BOAT6", "BOAT7","BOAT8", "BOAT9", "BOAT10","BOAT1", "BOAT2", "BOAT3", "BOAT4", "BOAT5", "BOAT6", "BOAT7","BOAT8", "BOAT9", "BOAT10"});
        list_of_boats.setPosition(0,Gdx.graphics.getHeight());


        scroll = new ScrollPane(table, skin);
        table.add(new Label("YOUR BOATS",skin)).row();
        table.add(list_of_boats);






        container.add(scroll).expand().fill().colspan(4);
        var =  list_of_boats.getSelected().toString();
        boat = new Sprite(testBoat.getSideBoat()).getTexture();
        region = new TextureRegion(boat,boat.getWidth(),boat.getHeight());//(int)(Gdx.graphics.getWidth()/3.37), (int)(Gdx.graphics.getHeight()/3.9));
        actor = new Image(region);







//        this.batch = new SpriteBatch();
//        this.background = new Texture("background_manager.png");
//        this.splash = new Sprite(background);
//        this.splash.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
//        this.skin = new Skin(Gdx.files.internal("uiskin.json"));

        //this.black = new BitmapFont(Gdx.files.internal("font_manager/blackfont.fnt"), false);






//
//        this.stage = new Stage();
//       Gdx.input.setInputProcessor(stage);
//        atlas = new TextureAtlas("uiatlas.pack");
//        skin = new Skin(Gdx.files.internal("uiskin.json"),atlas);
//
//        this.table = new Table();
//
//        this.verticalGroup = new VerticalGroup();
//        this.verticalGroup.setWidth(stage.getWidth());
//        this.verticalGroup.align(Align.right|Align.top);
//        this.verticalGroup.setPosition(0, Gdx.graphics.getHeight());
//        this.verticalGroup.debug();

//        this.list_of_boats = new List(skin);
//        this.list_of_boats.setItems(new String[] {"Fascinosa", "Titanic", "Simon", "Alejandro", "GianMARKET", "PEROZA", "ILIJA","Fascinosa", "Titanic", "Simon","Fascinosa", "Titanic", "Simon", "Alejandro", "GianMARKET", "PEROZA", "ILIJA","Fascinosa", "Titanic", "Simon"});
        //this.scrollPane = new ScrollPane(list_of_boats,skin);



        //this.verticalGroup.addActor(list_of_boats);
//        this.scrollPane = new ScrollPane(list_of_boats,skin);
//
//        this.table.setWidth(stage.getWidth());
//        this.table.align(Align.right| Align.top);
//        this.table.setPosition(0,Gdx.graphics.getHeight()/2);
//        this.table.debug();
//        this.table.setFillParent(true);
//        this.table.add(scrollPane);



//
//        list_of_boats = new List(skin);
//        list_of_boats.setItems(new String[] {"Fascinosa", "Titanic", "Simon", "Alejandro", "GianMARKET", "PEROZA", "ILIJA","Fascinosa", "Titanic", "Simon", "Alejandro", "GianMARKET", "PEROZA", "ILIJA"});
//
//        play = new TextButton("PLAY", skin);
//        play.pad(15);
//
//        back = new TextButton("BACK", skin);
//        back.pad(10);
//
//
//        scrollPane = new ScrollPane(list_of_boats,skin);
//        table.add("MY BOATS");

//
//        table = new Table(skin);
//        table.setWidth(stage.getWidth());
//        table.align(Align.left|Align.top);
//        table.setPosition(0, Gdx.graphics.getHeight());
//        table.add("My Boats");
//
//        stage.addActor(table);

//        table_atrributes=new Table();
//        table_atrributes.setWidth(stage.getWidth());
//        table_atrributes.align(Align.right|Align.top);
//        table_atrributes.setPosition(0, Gdx.graphics.getHeight());


//        my_boats = new Table();
//        my_boats.setBounds(0,0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
//        my_boats.debug();
//        my_boats.add("My Boats");


//
//        list_of_boats = new List(skin);
//        list_of_boats.setItems(new String[] {"Fascinosa", "Titanic", "Simon", "Alejandro", "GianMARKET", "PEROZA", "ILIJA","Fascinosa", "Titanic", "Simon", "Alejandro", "GianMARKET", "PEROZA", "ILIJA"});
//        scrollPane = new ScrollPane(list_of_boats,skin);
//        scrollPane.setWidth(200f);
//        scrollPane.setHeight(stage.getHeight()/1.3f);




//        startButton = new TextButton("Buy new boats",skin, "default");
//        quitButton = new TextButton("Your boats", skin, "default");
//        playerObject=new Player();
//        String text="Current Balance:";
//        text+=playerObject.money;

        //my_boats.add(text);

       // table_atrributes.add(my_boats);

//        startButton.getSkin().getFont("default-font").getData().setScale(1.2f,1.2f);
//        table.padTop(30);
//        table.add(startButton).padBottom(50).width(250f).height(50f);
//        table.row();
//        table.add(quitButton).width(250f).height(50f).row();







        //stage.addActor(my_boats);
       // stage.addActor(table);

       // this.batch = new SpriteBatch();
        //sprite = new Sprite(new Texture(Gdx.files.internal("background.png")));
        //sprite.setSize(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());



        //final TextButton button = new TextButton("Buy a new boat",skin, "default");
        //button.setWidth(300);
        //button.setHeight(400);
        //button.getSkin().getFont("default-font").getData().setScale(2f,2f);
//
//
//        final Dialog dialog = new Dialog ("Click Message", skin);
//        button.addListener(new ClickListener(){
//            @Override
//            public void clicked(InputEvent event, float x, float y)
//            {
//                dialog.show(stage);
//                Timer.schedule(new Timer.Task(){
//                    @Override
//                    public void run()
//                    {
//                        dialog.hide();
//                    }
//
//                },5);
//
//            }
//        });
          //stage.addActor(button);
//        stage.addActor(button);
        //BitmapFont font=new BitmapFont();
        //this.label=new Label("money",new LabelStyle(font, new Color().RED));
        //this.table=new Table(skin);
        //table.add(label);

//        boat_attributes=new Table();
//        boat_attributes.setWidth(stage.getWidth());
//        boat_attributes.align(Align.left|Align.center);
//        boat_attributes.setPosition(0,Gdx.graphics.getHeight()/2);
//
//
//        attributes=new Label("NAME: Fascinosa",skin);
//        boat_attributes.add(attributes).padBottom(10);
//        boat_attributes.row();
//        attributes=new Label("SPEED: 14KNOTS",skin);
//        boat_attributes.add(attributes).padBottom(10);
//        boat_attributes.row();
//        attributes=new Label("CAPACITY: 1400PAX",skin);
//        boat_attributes.add(attributes).padBottom(10);
//        boat_attributes.row();
//        attributes=new Label("MAINTENANCE: 10$/KM",skin);
//        boat_attributes.add(attributes).padBottom(10);
//        boat_attributes.row();
//        boat_attributes.debug();
//
//
//        this.stage.addActor(boat_attributes);
//        this.stage.addActor(table);



//        Gdx.input.setInputProcessor(stage);

        //this.batch=batch;
        //this.background=new Texture("background.png");
//        this.playerObject= new Player();

//        cam = new OrthographicCamera();
//        cam.setToOrtho(false,720*w/h,720);
//        cam.update();
//        //this.window= new Actor();
//        BitmapFont font=new BitmapFont();
//        font.getData().setScale((float) 10, (float) 10);


    }


    @Override
    public void renderGameObject(){

        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();

//        batch.begin();
//        splash.draw(batch);
//        batch.end();

        //batch.begin();
       // sprite.draw(batch);
        //batch.end();
//        boat_attributes=new Table();
//        boat_attributes.setWidth(stage.getWidth());
//        boat_attributes.align(Align.left|Align.center);
//        boat_attributes.setPosition(0,Gdx.graphics.getHeight()/2);
//
//
//
//
//        attributes=new Label("NAME: Fascinosa",skin);
//        boat_attributes.add(attributes).padBottom(10);
//        boat_attributes.row();
//        attributes=new Label("SPEED: 14KNOTS",skin);
//        boat_attributes.add(attributes).padBottom(10);
//        boat_attributes.row();
//        attributes=new Label("CAPACITY: 1400PAX",skin);
//        boat_attributes.add(attributes).padBottom(10);
//        boat_attributes.row();
//        attributes=new Label("MAINTENANCE: 10$/KM",skin);
//        boat_attributes.add(attributes).padBottom(10);



       // stage.addActor(boat_attributes);
//


//        batch.begin();
//
//        batch.draw(background, 0, 0,(float) Gdx.graphics.getWidth() , (float) Gdx.graphics.getHeight() );
//
//
//        batch.end();



    }

    @Override
    public void update(float dt) {



        var =  list_of_boats.getSelected().toString();
        if (var.equals("BOAT1") && bool) {
            bool = false;

//            attributes=new Label("NAME: Fascinosa",skin);
//            boat_attributes.add(attributes).padBottom(10);
//            boat_attributes.row();
//            attributes=new Label("SPEED: 14KNOTS",skin);
//            boat_attributes.add(attributes).padBottom(10);
//            boat_attributes.row();
//            attributes=new Label("CAPACITY: 1400PAX",skin);
//            boat_attributes.add(attributes).padBottom(10);
//            boat_attributes.row();
//            attributes=new Label("MAINTENANCE: 10$/KM",skin);
//            boat_attributes.add(attributes).padBottom(10);
            this.actor.setScale(Gdx.graphics.getDensity()*0.5f,Gdx.graphics.getDensity()*0.5f);
            System.out.println(actor.getHeight());
            System.out.println(actor.getWidth());

            this.actor.setPosition(Gdx.graphics.getWidth()/2 - actor.getWidth(),
                    Gdx.graphics.getHeight()/2 - actor.getHeight());



            this.boat_stats.setPosition(Gdx.graphics.getWidth()*6/100,
                    Gdx.graphics.getHeight()-boat_stats.getHeight());
            this.name.setPosition(Gdx.graphics.getWidth()*3/100,
                    Gdx.graphics.getHeight()-name.getHeight()-Gdx.graphics.getHeight()*5/100);
            this.capacity.setPosition(Gdx.graphics.getWidth()*3/100,
                    Gdx.graphics.getHeight()-name.getHeight()-Gdx.graphics.getHeight()*5/100*2);
            this.speed.setPosition(Gdx.graphics.getWidth()*3/100,
                    Gdx.graphics.getHeight()-name.getHeight()-Gdx.graphics.getHeight()*5/100*3);
            this.distanceLimit.setPosition(Gdx.graphics.getWidth()*3/100,
                    Gdx.graphics.getHeight()-name.getHeight()-Gdx.graphics.getHeight()*5/100*4);
            this.maintenanceCost.setPosition(Gdx.graphics.getWidth()*3/100,
                    Gdx.graphics.getHeight()-name.getHeight()-Gdx.graphics.getHeight()*5/100*5);
            this.vulnerability.setPosition(Gdx.graphics.getWidth()*3/100,
                    Gdx.graphics.getHeight()-name.getHeight()-Gdx.graphics.getHeight()*5/100*6);

            this.boat_stats.setFontScale(0.333f*Gdx.graphics.getDensity(),0.333f*Gdx.graphics.getDensity());
            this.name.setFontScale(0.3f*Gdx.graphics.getDensity(),0.3f*Gdx.graphics.getDensity());
            this.capacity.setFontScale(0.3f*Gdx.graphics.getDensity(),0.3f*Gdx.graphics.getDensity());
            this.speed.setFontScale(0.3f*Gdx.graphics.getDensity(),0.3f*Gdx.graphics.getDensity());
            this.maintenanceCost.setFontScale(0.3f*Gdx.graphics.getDensity(),0.3f*Gdx.graphics.getDensity());
            this.distanceLimit.setFontScale(0.3f*Gdx.graphics.getDensity(),0.3f*Gdx.graphics.getDensity());
            this.vulnerability.setFontScale(0.3f*Gdx.graphics.getDensity(),0.3f*Gdx.graphics.getDensity());

            this.stage.addActor(this.boat_stats);
            this.stage.addActor(this.name);
            this.stage.addActor(this.speed);
            this.stage.addActor(this.capacity);
            this.stage.addActor(this.distanceLimit);
            this.stage.addActor(this.maintenanceCost);
            this.stage.addActor(this.vulnerability);
            this.stage.addActor(this.actor);




        }
        else if(var.equals("BOAT1") && !bool) {
        }
        else  {

            this.actor.remove();
            this.name.remove();
            this.speed.remove();
            this.capacity.remove();
            this.distanceLimit.remove();
            this.maintenanceCost.remove();
            this.vulnerability.remove();
            this.bool=true;
        }
    }


    @Override
    public void inputHandler() {
    }
}
