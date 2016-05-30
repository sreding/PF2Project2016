package ch.inf.usi.pf2.project.gameStates;
import ch.inf.usi.pf2.project.managerUpgrade.Upgrade;
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
import com.badlogic.gdx.utils.SnapshotArray;
import java.util.ArrayList;



/**
 * Created by simonreding on 17/05/16.
 */
public class Manager extends GameState {

    private Player playerObject;
    private SpriteBatch batch;
    private Table container;
    private Stage stage;
    private Skin skin;
    private Texture boat;
    private List list_of_boats;
    private TextButton back;
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
    private TextButton upgrade2;
    private TextButton upgrade3;
    private TextButton buy;
    private Label price;
    private Label money;
    private Label boats_owned;
    private Dialog dialog;
    private List list;
    private TextButton buy_boats;
    private TextButton your_boats;
    private ScrollPane scroll1;
    private ScrollPane scroll2;
    private boolean scroll1_bool;
    private boolean scroll2_bool;
    private boolean buy_bool;
    private boolean boat_stats_bool;
    private boolean boat1_bool,boat2_bool;
    private int counter1;
    private int counter2;
    private ArrayList<String> array;
    private TextButton upgrade;
    private Upgrade upgrade_stats;
    private boolean your_boats_bool;
    private Boat your_boat;
    private Texture your_boat_texture;
    private Image your_actor;
    private TextureRegion your_region;
    private ArrayList<Boat> boatArrayList;
    private boolean already_displayed;
    private boolean upgrade_bool;

    public Manager(SpriteBatch batch,Player player)
    {
        already_displayed=false;
        upgrade_bool = false;
        counter1=0;
        counter2=0;
        scroll1_bool=false;
        scroll2_bool=false;
        your_boats_bool=false;
        boat1_bool=false;
        boat1_bool=false;
        buy_bool = false;
        boat_stats_bool=false;
        this.playerObject=player;
        this.bool=true;
        this.batch=batch;
        stage = new Stage(new ScreenViewport(),batch);
        skin = new Skin(Gdx.files.internal("uiskin.json"));
        Gdx.input.setInputProcessor(stage);

        // TEST BOAT !

        testBoat = playerObject.getPossibleBoats().get(0);
        // Gdx.graphics.setVSync(false);

        this.name = new Label("Name:"+" "+testBoat.getLabel(),skin);
        this.price = new Label("Price:"+" "+testBoat.getPrice(),skin);
        this.capacity = new Label("Capacity:"+" "+ testBoat.getCapacity(),skin);
        this.speed = new Label("Speed:"+" "+ testBoat.getSpeed(),skin);
        this.distanceLimit = new Label("Distance Limit:"+ " "+ testBoat.getDistanceLimit(),skin);
        this.maintenanceCost = new Label("Maintenance:"+ " "+ testBoat.getMaintenanceCost(),skin);
        this.vulnerability = new Label("Vulnerability:"+ " "+ testBoat.getVulnerability(),skin);
        this.boat_stats = new Label("BOAT STATS:",skin);

        this.player_stats = new Label("PLAYER STATS:",skin);
        this.money = new Label("Current Balance:"+" "+playerObject.money,skin);
        this.boats_owned = new Label("Boats Owned:"+ " "+playerObject.numberOfBoatsOwned(),skin);



        container = new Table();
        stage.addActor(container);
        container.setFillParent(true);

        //Uprages Buttons implementation:
        upgrade = new TextButton("Upgrade",skin);

        upgrade.setHeight(Gdx.graphics.getHeight()/4);
        upgrade.setWidth(Gdx.graphics.getWidth()/6);
        upgrade.setPosition(Gdx.graphics.getWidth()/6,0);



        this.buy = new TextButton("Buy",skin);

        this.buy.setHeight(Gdx.graphics.getHeight()/4);
        this.buy.setWidth(Gdx.graphics.getWidth()/6);
        this.buy.setPosition(Gdx.graphics.getWidth()/6,0);

        this.back = new TextButton("Back",skin);
        this.back.setHeight(Gdx.graphics.getHeight()/5);
        this.back.setWidth(Gdx.graphics.getWidth()/7);
        this.back.setPosition(0,0);
        this.stage.addActor(back);

        //this.back
        table = new Table(skin);
        table.getSkin().getFont("default-font").getData().setScale(0.6f*Gdx.graphics.getDensity(),0.6f*Gdx.graphics.getDensity());
        table.align(Align.right|Align.top);
        table.setPosition(0,container.getHeight());
        this.list_of_boats = new List(skin);
        this.list_of_boats.setItems(new String[] {"BOAT1", "BOAT2", "BOAT3", "BOAT4", "BOAT5", "BOAT6", "BOAT7","BOAT8", "BOAT9", "BOAT10"});
        list_of_boats.setPosition(0,Gdx.graphics.getHeight());
        final Texture texture = new Texture(Gdx.files.internal("sideTexture.png"));


        this.list = new List(skin);
        this.list.setItems(new String[] {});

        your_boats =  new TextButton("YOUR BOATS",skin);
        buy_boats =  new TextButton("BUY BOATS",skin);




        scroll = new ScrollPane(table, skin);

        table.add(your_boats).width(stage.getWidth()/5).height(stage.getHeight()/2);
        table.row();
        //table.add(list).row();
        table.add(buy_boats).width(stage.getWidth()/5).height(stage.getHeight()/2);

        this.buy_boats.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y)
            {
                if(your_boats_bool)
                {
                    boat_stats.remove();
                    your_actor.remove();
                    name.remove();
                    speed.remove();
                    capacity.remove();
                    distanceLimit.remove();
                    maintenanceCost.remove();
                    vulnerability.remove();
                    price.remove();
                    your_boats_bool=false;
                }
                if(scroll2_bool)
                {
                    scroll2.remove();
                    scroll2_bool=false;
                }
                if(upgrade_bool && playerObject.getBoats().size()>0)
                {
                    upgrade.remove();
                    upgrade_bool=false;
                }
                your_boats.remove();
                buy_boats.remove();
                Table table = new Table(skin);
                table.getSkin().getFont("default-font").getData().setScale(0.6f*Gdx.graphics.getDensity(),0.6f*Gdx.graphics.getDensity());
                table.align(Align.right|Align.top);
                table.setPosition(0,container.getHeight());

                scroll1 = new ScrollPane(table, skin);
                Label label = new Label("Buy Boats" + System.getProperty("line.separator") + "Menu",skin);
                table.add(label).row();
                label.setAlignment(Align.center);

                table.add(list_of_boats);

                your_boats.setHeight(Gdx.graphics.getHeight()/4);
                your_boats.setWidth(Gdx.graphics.getWidth()/6);
                your_boats.setPosition(Gdx.graphics.getWidth()/2,0);
                stage.addActor(buy);
                buy_bool=true;
                stage.addActor(your_boats);

                container.add(scroll1).fill();
                scroll1_bool = true;
                boat_stats_bool = true;
            }
        });


        this.your_boats.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y)
            {
                your_boats_bool=true;
                boatArrayList = new ArrayList<Boat>();
                boatArrayList = playerObject.getBoats();
                array = new ArrayList<String>();
                for(Boat b: boatArrayList)
                {
                    array.add(b.getLabel());
                }
                list.setItems(array.toArray());


                if(scroll1_bool)
                {
                    scroll1.remove();
                    scroll1_bool=false;
                }
                if(buy_bool)
                {
                    buy.remove();
                    buy_bool=false;
                }
                if(boat_stats_bool)
                {
                    boat_stats.remove();
                    actor.remove();
                    name.remove();
                    speed.remove();
                    capacity.remove();
                    distanceLimit.remove();
                    maintenanceCost.remove();
                    vulnerability.remove();
                    price.remove();
                    boat_stats_bool=false;
                    bool = true;
                }
                your_boats.remove();
                buy_boats.remove();

                Table table = new Table(skin);
                table.getSkin().getFont("default-font").getData().setScale(0.6f*Gdx.graphics.getDensity(),0.6f*Gdx.graphics.getDensity());
                table.align(Align.right|Align.top);
                table.setPosition(0,container.getHeight());

                scroll2 = new ScrollPane(table, skin);
                Label label = new Label("Your Boats" + System.getProperty("line.separator") + "Menu",skin);
                table.add(label).row();
                label.setAlignment(Align.center);
                table.add(list);

                buy_boats.setHeight(Gdx.graphics.getHeight()/4);
                buy_boats.setWidth(Gdx.graphics.getWidth()/6);
                buy_boats.setPosition(Gdx.graphics.getWidth()/2,0);
                stage.addActor(buy_boats);
                if(playerObject.getBoats().size()>0)
                {
                    stage.addActor(upgrade);
                    upgrade_bool = true;
                }
                container.add(scroll2).fill();

                scroll2_bool=true;
            }
        });


       // table.add(list_of_boats);


        container.add(scroll).expand().fill().colspan(4);
        var =  list_of_boats.getSelected().toString();
        boat = new Sprite(testBoat.getSideBoat()).getTexture();
        region = new TextureRegion(boat,boat.getWidth(),boat.getHeight());
        actor = new Image(region);

        this.buy.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y)
            {
                if(playerObject.money>=testBoat.getPrice()) {

                    if(testBoat.getLabel().equals("BOAT1"))
                    {
                        counter1+=1;
                        playerObject.addBoat(testBoat.copyBoat(counter1));
                    }
                    else if (testBoat.getLabel().equals("BOAT2"))
                    {
                        counter2+=1;
                        playerObject.addBoat(testBoat.copyBoat(counter2));
                    }

                    playerObject.money-=testBoat.getPrice();

                    money.setText("Current Balance:"+" "+playerObject.money);
                    boats_owned.setText("Boats Owned:"+ " "+playerObject.numberOfBoatsOwned());

                }
                else {
                    dialog = new Dialog("insufficient" + System.getProperty("line.separator") + "funds",skin);
                    dialog.getTitleLabel().setFontScale(Gdx.graphics.getDensity()*0.35f);
                    dialog.pad(stage.getHeight()/11);
                    dialog.getTitleLabel().setAlignment(Align.center);
                    dialog.show(stage);
                    Timer.schedule(new Timer.Task(){
                        @Override
                        public void run()
                        {
                            dialog.hide();
                        }

                    },2);

                }

                }
               // stage.addActor(upgrade2);
               // stage.addActor(upgrade3);


        });


        this.player_stats.setFontScale(0.333f*Gdx.graphics.getDensity(),0.333f*Gdx.graphics.getDensity());
        this.money.setFontScale(0.3f*Gdx.graphics.getDensity(),0.3f*Gdx.graphics.getDensity());
        this.boats_owned.setFontScale(0.3f*Gdx.graphics.getDensity(),0.3f*Gdx.graphics.getDensity());

        this.player_stats.setPosition(Gdx.graphics.getWidth()*40/100,
                Gdx.graphics.getHeight()-boat_stats.getHeight());
        this.money.setPosition(Gdx.graphics.getWidth()*37/100,
                Gdx.graphics.getHeight()-name.getHeight()-Gdx.graphics.getHeight()*5/100);
        this.boats_owned.setPosition(Gdx.graphics.getWidth()*37/100,
                Gdx.graphics.getHeight()-name.getHeight()-Gdx.graphics.getHeight()*5/100*2);

        this.stage.addActor(this.player_stats);
        this.stage.addActor(this.boats_owned);
        this.stage.addActor(this.money);


        // YOUR BOATS BUTTON
//        this.batch = new SpriteBatch();
//        this.background = new Texture("background_manager.png");
//        this.splash = new Sprite(background);
//        this.splash.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
//        this.skin = new Skin(Gdx.files.internal("uiskin.json"));

        //this.black = new BitmapFont(Gdx.files.internal("font_manager/blackfont.fnt"), false)

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
        Gdx.input.setInputProcessor(stage);
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
        if(var.equals("BOAT1") && !boat1_bool)
        {
            if(boat_stats_bool)
            {
                boat_stats.remove();
                actor.remove();
                name.remove();
                speed.remove();
                capacity.remove();
                distanceLimit.remove();
                maintenanceCost.remove();
                vulnerability.remove();
                price.remove();
                boat_stats_bool=false;
                bool = true;
            }

            testBoat = playerObject.getPossibleBoats().get(0);

            boat = new Sprite(testBoat.getSideBoat()).getTexture();
            region = new TextureRegion(boat,boat.getWidth(),boat.getHeight());
            actor = new Image(region);

            this.name = new Label("Name:"+" "+testBoat.getLabel(),skin);
            this.price = new Label("Price:"+" "+testBoat.getPrice(),skin);
            this.capacity = new Label("Capacity:"+" "+ testBoat.getCapacity(),skin);
            this.speed = new Label("Speed:"+" "+ testBoat.getSpeed(),skin);
            this.distanceLimit = new Label("Distance Limit:"+ " "+ testBoat.getDistanceLimit(),skin);
            this.maintenanceCost = new Label("Maintenance:"+ " "+ testBoat.getMaintenanceCost(),skin);
            this.vulnerability = new Label("Vulnerability:"+ " "+ testBoat.getVulnerability(),skin);
            this.boat_stats = new Label("BOAT STATS:",skin);

            boat1_bool=true;
            boat2_bool=false;
            //playerObject.updateDamage();
        }
        else if(var.equals("BOAT2") && !boat2_bool)
        {
            if(boat_stats_bool)
            {
                boat_stats.remove();
                actor.remove();
                name.remove();
                speed.remove();
                capacity.remove();
                distanceLimit.remove();
                maintenanceCost.remove();
                vulnerability.remove();
                price.remove();
                boat_stats_bool=false;
                bool = true;
            }
            testBoat = playerObject.getPossibleBoats().get(1);

            boat = new Sprite(testBoat.getSideBoat()).getTexture();
            region = new TextureRegion(boat,boat.getWidth(),boat.getHeight());
            actor = new Image(region);

            this.name = new Label("Name:"+" "+testBoat.getLabel(),skin);
            this.price = new Label("Price:"+" "+testBoat.getPrice(),skin);
            this.capacity = new Label("Capacity:"+" "+ testBoat.getCapacity(),skin);
            this.speed = new Label("Speed:"+" "+ testBoat.getSpeed(),skin);
            this.distanceLimit = new Label("Distance Limit:"+ " "+ testBoat.getDistanceLimit(),skin);
            this.maintenanceCost = new Label("Maintenance:"+ " "+ testBoat.getMaintenanceCost(),skin);
            this.vulnerability = new Label("Vulnerability:"+ " "+ testBoat.getVulnerability(),skin);
            this.boat_stats = new Label("BOAT STATS:",skin);

            boat1_bool = false;
            boat2_bool = true;
        }
        if ((var.equals("BOAT1") || var.equals("BOAT2")) && bool && scroll1_bool) {
            bool = false;
            boat_stats_bool=true;
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

            this.actor.setPosition(Gdx.graphics.getWidth()/2 - actor.getWidth(),
                    Gdx.graphics.getHeight()/2 - actor.getHeight());


            this.boat_stats.setPosition(Gdx.graphics.getWidth()*6/100,
                    Gdx.graphics.getHeight()-boat_stats.getHeight());
            this.name.setPosition(Gdx.graphics.getWidth()*3/100,
                    Gdx.graphics.getHeight()-name.getHeight()-Gdx.graphics.getHeight()*5/100);
            this.price.setPosition(Gdx.graphics.getWidth()*3/100,
                    Gdx.graphics.getHeight()-name.getHeight()-Gdx.graphics.getHeight()*5/100*2);
            this.capacity.setPosition(Gdx.graphics.getWidth()*3/100,
                    Gdx.graphics.getHeight()-name.getHeight()-Gdx.graphics.getHeight()*5/100*3);
            this.speed.setPosition(Gdx.graphics.getWidth()*3/100,
                    Gdx.graphics.getHeight()-name.getHeight()-Gdx.graphics.getHeight()*5/100*4);
            this.distanceLimit.setPosition(Gdx.graphics.getWidth()*3/100,
                    Gdx.graphics.getHeight()-name.getHeight()-Gdx.graphics.getHeight()*5/100*5);
            this.maintenanceCost.setPosition(Gdx.graphics.getWidth()*3/100,
                    Gdx.graphics.getHeight()-name.getHeight()-Gdx.graphics.getHeight()*5/100*6);
            this.vulnerability.setPosition(Gdx.graphics.getWidth()*3/100,
                    Gdx.graphics.getHeight()-name.getHeight()-Gdx.graphics.getHeight()*5/100*7);


            this.name.setFontScale(0.3f*Gdx.graphics.getDensity(),0.3f*Gdx.graphics.getDensity());
            this.boat_stats.setFontScale(0.333f*Gdx.graphics.getDensity(),0.333f*Gdx.graphics.getDensity());
            this.price.setFontScale(0.3f*Gdx.graphics.getDensity(),0.3f*Gdx.graphics.getDensity());
            this.name.setFontScale(0.3f*Gdx.graphics.getDensity(),0.3f*Gdx.graphics.getDensity());
            this.capacity.setFontScale(0.3f*Gdx.graphics.getDensity(),0.3f*Gdx.graphics.getDensity());
            this.speed.setFontScale(0.3f*Gdx.graphics.getDensity(),0.3f*Gdx.graphics.getDensity());
            this.maintenanceCost.setFontScale(0.3f*Gdx.graphics.getDensity(),0.3f*Gdx.graphics.getDensity());
            this.distanceLimit.setFontScale(0.3f*Gdx.graphics.getDensity(),0.3f*Gdx.graphics.getDensity());
            this.vulnerability.setFontScale(0.3f*Gdx.graphics.getDensity(),0.3f*Gdx.graphics.getDensity());

            this.stage.addActor(this.boat_stats);
            this.stage.addActor(this.name);
            this.stage.addActor(this.price);
            this.stage.addActor(this.speed);
            this.stage.addActor(this.capacity);
            this.stage.addActor(this.distanceLimit);
            this.stage.addActor(this.maintenanceCost);
            this.stage.addActor(this.vulnerability);
            this.stage.addActor(this.actor);

        }
        if(your_boats_bool && (playerObject.getBoats().size()>0))
        {
            var =  list.getSelected().toString();
            boatArrayList = playerObject.getBoats();
            if(boat_stats_bool)
            {
                boat_stats.remove();
                actor.remove();
                name.remove();
                speed.remove();
                capacity.remove();
                distanceLimit.remove();
                maintenanceCost.remove();
                vulnerability.remove();
                price.remove();
            }

            if(!already_displayed)
            {
                for(Boat b: boatArrayList)
                {
                    if(var.equals(b.getLabel()))
                    {
                        your_boat = b;
                        your_boat_texture = b.getSideBoat().getTexture();
                        your_region = new TextureRegion(your_boat_texture,your_boat_texture.getWidth(),your_boat_texture.getHeight());
                        your_actor = new Image(your_region);
                        break;
                    }
                }
                this.name = new Label("Name:"+" "+your_boat.getLabel(),skin);
                this.price = new Label("Price:"+" "+your_boat.getPrice(),skin);
                this.capacity = new Label("Capacity:"+" "+ your_boat.getCapacity(),skin);
                this.speed = new Label("Speed:"+" "+ your_boat.getSpeed(),skin);
                this.distanceLimit = new Label("Distance Limit:"+ " "+ your_boat.getDistanceLimit(),skin);
                this.maintenanceCost = new Label("Maintenance:"+ " "+ your_boat.getMaintenanceCost(),skin);
                this.vulnerability = new Label("Vulnerability:"+ " "+ your_boat.getVulnerability(),skin);
                this.boat_stats = new Label("BOAT STATS:",skin);

                this.your_actor.setScale(Gdx.graphics.getDensity()*0.5f,Gdx.graphics.getDensity()*0.5f);

                this.your_actor.setPosition(Gdx.graphics.getWidth()/2 - actor.getWidth(),
                        Gdx.graphics.getHeight()/2 - actor.getHeight());


                this.boat_stats.setPosition(Gdx.graphics.getWidth()*6/100,
                        Gdx.graphics.getHeight()-boat_stats.getHeight());
                this.name.setPosition(Gdx.graphics.getWidth()*3/100,
                        Gdx.graphics.getHeight()-name.getHeight()-Gdx.graphics.getHeight()*5/100);
                this.price.setPosition(Gdx.graphics.getWidth()*3/100,
                        Gdx.graphics.getHeight()-name.getHeight()-Gdx.graphics.getHeight()*5/100*2);
                this.capacity.setPosition(Gdx.graphics.getWidth()*3/100,
                        Gdx.graphics.getHeight()-name.getHeight()-Gdx.graphics.getHeight()*5/100*3);
                this.speed.setPosition(Gdx.graphics.getWidth()*3/100,
                        Gdx.graphics.getHeight()-name.getHeight()-Gdx.graphics.getHeight()*5/100*4);
                this.distanceLimit.setPosition(Gdx.graphics.getWidth()*3/100,
                        Gdx.graphics.getHeight()-name.getHeight()-Gdx.graphics.getHeight()*5/100*5);
                this.maintenanceCost.setPosition(Gdx.graphics.getWidth()*3/100,
                        Gdx.graphics.getHeight()-name.getHeight()-Gdx.graphics.getHeight()*5/100*6);
                this.vulnerability.setPosition(Gdx.graphics.getWidth()*3/100,
                        Gdx.graphics.getHeight()-name.getHeight()-Gdx.graphics.getHeight()*5/100*7);


                this.name.setFontScale(0.3f*Gdx.graphics.getDensity(),0.3f*Gdx.graphics.getDensity());
                this.boat_stats.setFontScale(0.333f*Gdx.graphics.getDensity(),0.333f*Gdx.graphics.getDensity());
                this.price.setFontScale(0.3f*Gdx.graphics.getDensity(),0.3f*Gdx.graphics.getDensity());
                this.name.setFontScale(0.3f*Gdx.graphics.getDensity(),0.3f*Gdx.graphics.getDensity());
                this.capacity.setFontScale(0.3f*Gdx.graphics.getDensity(),0.3f*Gdx.graphics.getDensity());
                this.speed.setFontScale(0.3f*Gdx.graphics.getDensity(),0.3f*Gdx.graphics.getDensity());
                this.maintenanceCost.setFontScale(0.3f*Gdx.graphics.getDensity(),0.3f*Gdx.graphics.getDensity());
                this.distanceLimit.setFontScale(0.3f*Gdx.graphics.getDensity(),0.3f*Gdx.graphics.getDensity());
                this.vulnerability.setFontScale(0.3f*Gdx.graphics.getDensity(),0.3f*Gdx.graphics.getDensity());

                this.stage.addActor(this.boat_stats);
                this.stage.addActor(this.name);
                this.stage.addActor(this.price);
                this.stage.addActor(this.speed);
                this.stage.addActor(this.capacity);
                this.stage.addActor(this.distanceLimit);
                this.stage.addActor(this.maintenanceCost);
                this.stage.addActor(this.vulnerability);
                this.stage.addActor(this.your_actor);
                already_displayed=true;
            }
            else
            {
                boat_stats.remove();
                your_actor.remove();
                name.remove();
                speed.remove();
                capacity.remove();
                distanceLimit.remove();
                maintenanceCost.remove();
                vulnerability.remove();
                price.remove();

                var =  list.getSelected().toString();
                boatArrayList = playerObject.getBoats();


                    for(Boat b: boatArrayList)
                    {
                        if(var.equals(b.getLabel()))
                        {
                            your_boat = b;
                            your_boat_texture = b.getSideBoat().getTexture();
                            your_region = new TextureRegion(your_boat_texture,your_boat_texture.getWidth(),your_boat_texture.getHeight());
                            your_actor = new Image(your_region);
                            break;
                        }
                    }
                this.name = new Label("Name:"+" "+your_boat.getLabel(),skin);
                this.price = new Label("Price:"+" "+your_boat.getPrice(),skin);
                this.capacity = new Label("Capacity:"+" "+ your_boat.getCapacity(),skin);
                this.speed = new Label("Speed:"+" "+ your_boat.getSpeed(),skin);
                this.distanceLimit = new Label("Distance Limit:"+ " "+ your_boat.getDistanceLimit(),skin);
                this.maintenanceCost = new Label("Maintenance:"+ " "+ your_boat.getMaintenanceCost(),skin);
                this.vulnerability = new Label("Vulnerability:"+ " "+ your_boat.getVulnerability(),skin);
                this.boat_stats = new Label("BOAT STATS:",skin);

                this.your_actor.setScale(Gdx.graphics.getDensity()*0.5f,Gdx.graphics.getDensity()*0.5f);

                this.your_actor.setPosition(Gdx.graphics.getWidth()/2 - actor.getWidth(),
                        Gdx.graphics.getHeight()/2 - actor.getHeight());


                    this.boat_stats.setPosition(Gdx.graphics.getWidth()*6/100,
                            Gdx.graphics.getHeight()-boat_stats.getHeight());
                    this.name.setPosition(Gdx.graphics.getWidth()*3/100,
                            Gdx.graphics.getHeight()-name.getHeight()-Gdx.graphics.getHeight()*5/100);
                    this.price.setPosition(Gdx.graphics.getWidth()*3/100,
                            Gdx.graphics.getHeight()-name.getHeight()-Gdx.graphics.getHeight()*5/100*2);
                    this.capacity.setPosition(Gdx.graphics.getWidth()*3/100,
                            Gdx.graphics.getHeight()-name.getHeight()-Gdx.graphics.getHeight()*5/100*3);
                    this.speed.setPosition(Gdx.graphics.getWidth()*3/100,
                            Gdx.graphics.getHeight()-name.getHeight()-Gdx.graphics.getHeight()*5/100*4);
                    this.distanceLimit.setPosition(Gdx.graphics.getWidth()*3/100,
                            Gdx.graphics.getHeight()-name.getHeight()-Gdx.graphics.getHeight()*5/100*5);
                    this.maintenanceCost.setPosition(Gdx.graphics.getWidth()*3/100,
                            Gdx.graphics.getHeight()-name.getHeight()-Gdx.graphics.getHeight()*5/100*6);
                    this.vulnerability.setPosition(Gdx.graphics.getWidth()*3/100,
                            Gdx.graphics.getHeight()-name.getHeight()-Gdx.graphics.getHeight()*5/100*7);


                    this.name.setFontScale(0.3f*Gdx.graphics.getDensity(),0.3f*Gdx.graphics.getDensity());
                    this.boat_stats.setFontScale(0.333f*Gdx.graphics.getDensity(),0.333f*Gdx.graphics.getDensity());
                    this.price.setFontScale(0.3f*Gdx.graphics.getDensity(),0.3f*Gdx.graphics.getDensity());
                    this.name.setFontScale(0.3f*Gdx.graphics.getDensity(),0.3f*Gdx.graphics.getDensity());
                    this.capacity.setFontScale(0.3f*Gdx.graphics.getDensity(),0.3f*Gdx.graphics.getDensity());
                    this.speed.setFontScale(0.3f*Gdx.graphics.getDensity(),0.3f*Gdx.graphics.getDensity());
                    this.maintenanceCost.setFontScale(0.3f*Gdx.graphics.getDensity(),0.3f*Gdx.graphics.getDensity());
                    this.distanceLimit.setFontScale(0.3f*Gdx.graphics.getDensity(),0.3f*Gdx.graphics.getDensity());
                    this.vulnerability.setFontScale(0.3f*Gdx.graphics.getDensity(),0.3f*Gdx.graphics.getDensity());

                    this.stage.addActor(this.boat_stats);
                    this.stage.addActor(this.name);
                    this.stage.addActor(this.price);
                    this.stage.addActor(this.speed);
                    this.stage.addActor(this.capacity);
                    this.stage.addActor(this.distanceLimit);
                    this.stage.addActor(this.maintenanceCost);
                    this.stage.addActor(this.vulnerability);
                    this.stage.addActor(this.your_actor);

            }
    }

    }

    public int nextState(){

        if(back.isPressed() && Gdx.input.justTouched()){
            back.toggle();

            //System.out.println("return0");
            return 0;
        }
        return 2;
    }

    @Override
    public void inputHandler() {
    }
}
