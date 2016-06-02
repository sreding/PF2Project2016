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
    private boolean boat1_bool,boat2_bool,boat3_bool,boat4_bool,boat5_bool,boat6_bool,boat7_bool,boat8_bool,boat9_bool;
    private int counter1;
    private int counter2;
    private int counter3;
    private int counter4;
    private int counter5;
    private int counter6;
    private int counter7;
    private int counter8;
    private int counter9;
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
    private boolean first_time_enter;
    private boolean label_boolean;
    private Label label;
    private float height;
    private float fixed_width;
    private float fixed_height;
    private Boat someBoat;
    private Texture someTexture;
    private Sprite someSprite;
    private TextButton sell;
    private boolean sell_bool;
    private int save;


    public Manager(SpriteBatch batch,Player player)
    {

        already_displayed=false;
        upgrade_bool = false;
        label_boolean=false;
        first_time_enter=true;
        counter1=0;
        counter2=0;
        counter3=0;
        counter4=0;
        counter5=0;
        counter6=0;
        counter7=0;
        counter8=0;
        counter9=0;
        scroll1_bool=false;
        scroll2_bool=false;
        sell_bool = false;
        your_boats_bool=false;
        boat1_bool=false;
        boat2_bool=false;
        boat3_bool=false;
        boat4_bool=false;
        boat5_bool=false;
        boat6_bool=false;
        boat7_bool=false;
        boat8_bool=false;
        boat9_bool=false;
        buy_bool = false;
        boat_stats_bool=false;
        this.playerObject=player;
        this.bool=true;
        this.batch=batch;
        stage = new Stage(new ScreenViewport(),batch);
        skin = new Skin(Gdx.files.internal("uiskin.json"));
        someBoat  = playerObject.getPossibleBoats().get(2);
        someSprite =  new Sprite(someBoat.getSideBoat());
        fixed_width = someSprite.getWidth();
        fixed_height = someSprite.getHeight();
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
        this.vulnerability = new Label("Vulnerability:"+ " "+ (int)testBoat.getVulnerability(),skin);
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





        this.buy = new TextButton("Buy"+System.getProperty("line.separator")+"boat",skin);

        this.buy.setHeight(Gdx.graphics.getHeight()/4);
        this.buy.setWidth(Gdx.graphics.getWidth()/6);
        this.buy.setPosition(Gdx.graphics.getWidth()/6,0);
        buy.getLabel().setFontScale(Gdx.graphics.getDensity()*0.3f,Gdx.graphics.getDensity()*0.3f);

        this.sell = new TextButton("sell"+System.getProperty("line.separator")+"boat",skin);

        this.sell.setHeight(Gdx.graphics.getHeight()/6);
        this.sell.setWidth(Gdx.graphics.getWidth()/6);
        this.sell.setPosition(0,Gdx.graphics.getHeight()/3);
        sell.getLabel().setFontScale(Gdx.graphics.getDensity()*0.3f,Gdx.graphics.getDensity()*0.3f);

        this.back = new TextButton("Back",skin);
        this.back.setHeight(Gdx.graphics.getHeight()/4);
        this.back.setWidth(Gdx.graphics.getWidth()/6);
        back.getLabel().setFontScale(Gdx.graphics.getDensity()*0.3f,Gdx.graphics.getDensity()*0.3f);
        this.back.setPosition(0,0);
        this.back.setColor(Color.FIREBRICK);
        this.stage.addActor(back);

        //this.back
        table = new Table(skin);
        table.getSkin().getFont("default-font").getData().setScale(0.6f*Gdx.graphics.getDensity(),0.6f*Gdx.graphics.getDensity());
        table.align(Align.right|Align.top);
        table.setPosition(0,container.getHeight());
        this.list_of_boats = new List(skin);
        this.list_of_boats.setItems(new String[] {"apollo", "echo", "frejus", "helena", "jester", "luna", "aria","nicas", "titanic"});
        list_of_boats.setPosition(0,Gdx.graphics.getHeight());
        final Texture texture = new Texture(Gdx.files.internal("sideTexture.png"));


        this.list = new List(skin);
        this.list.setItems(new String[] {});

        your_boats =  new TextButton("YOUR BOATS" + System.getProperty("line.separator") + "menu",skin);
        buy_boats =  new TextButton("BUY BOATS"  + System.getProperty("line.separator") + "menu" ,skin);
        your_boats.getLabel().setFontScale(Gdx.graphics.getDensity()*0.3f,Gdx.graphics.getDensity()*0.3f);
        buy_boats.getLabel().setFontScale(Gdx.graphics.getDensity()*0.3f,Gdx.graphics.getDensity()*0.3f);




        scroll = new ScrollPane(table, skin);

        table.add(your_boats).width(stage.getWidth()/5).height(stage.getHeight()/2);
        table.row();
        //table.add(list).row();
        table.add(buy_boats).width(stage.getWidth()/5).height(stage.getHeight()/2);

        this.buy_boats.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y)
            {
                boat1_bool = false;
                boat2_bool = false;
                boat3_bool = false;
                boat4_bool = false;
                boat5_bool = false;
                boat6_bool = false;
                boat7_bool = false;
                boat8_bool = false;
                boat9_bool = false;
                if(label_boolean)
                {
                    label.remove();
                    label_boolean=false;
                }
                if(your_boats_bool && playerObject.getBoats().size()>0)
                {
                    boat_stats.remove();
                    your_actor.remove();
                    name.remove();
                    speed.remove();
                    capacity.remove();
                    distanceLimit.remove();
                    maintenanceCost.remove();
                    vulnerability.remove();
                 //   price.remove();
                }
                your_boats_bool=false;
                if(scroll2_bool)
                {
                    scroll2.remove();
                    scroll2_bool=false;
                }

                if(sell_bool)
                {
                    sell.remove();
                    sell_bool = false;
                }

                if(upgrade_bool && playerObject.getBoats().size()>0)
                {
                    upgrade.remove();
                    upgrade_bool=false;
                }
                if(first_time_enter) {
                    your_boats.remove();
                    buy_boats.remove();
                    first_time_enter=false;
                }
                else
                {
                    buy_boats.remove();
                }
                Table table = new Table(skin);
                table.getSkin().getFont("default-font").getData().setScale(0.6f*Gdx.graphics.getDensity(),0.6f*Gdx.graphics.getDensity());
                table.align(Align.right|Align.top);
                table.setPosition(0,container.getHeight());

                scroll1 = new ScrollPane(table, skin);
                Label label = new Label("Buy Boats" + System.getProperty("line.separator") + "Menu",skin);
                label.setFontScale(0.6f*Gdx.graphics.getDensity(),0.6f*Gdx.graphics.getDensity());
                table.add(label).row();
                label.setAlignment(Align.center);

                table.add(list_of_boats);

                your_boats.setHeight(Gdx.graphics.getHeight()/4);
                your_boats.setWidth(Gdx.graphics.getWidth()/6);
                your_boats.setPosition(Gdx.graphics.getWidth()/1.67f,0);
                stage.addActor(your_boats);
                stage.addActor(buy);
                buy_bool=true;

                scroll1.setScrollingDisabled(true,false);
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
                if(playerObject.getBoats().size()>0)
                {
                    stage.addActor(sell);
                    sell_bool = true;
                }
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
                if(first_time_enter) {
                    your_boats.remove();
                    buy_boats.remove();
                    first_time_enter=false;
                }
                else
                {
                    your_boats.remove();
                }
                Table table = new Table(skin);
                table.getSkin().getFont("default-font").getData().setScale(0.6f*Gdx.graphics.getDensity(),0.6f*Gdx.graphics.getDensity());
                table.align(Align.right|Align.top);
                table.setPosition(0,container.getHeight());

                scroll2 = new ScrollPane(table, skin);
                scroll2.setScrollingDisabled(true,false);
                Label label = new Label("Your Boats" + System.getProperty("line.separator") + "Menu",skin);
                label.setFontScale(0.6f*Gdx.graphics.getDensity(),0.6f*Gdx.graphics.getDensity());
                table.add(label).row();
                label.setAlignment(Align.center);
                table.add(list);


                buy_boats.setHeight(Gdx.graphics.getHeight()/4);
                buy_boats.setWidth(Gdx.graphics.getWidth()/6);
                buy_boats.setPosition(Gdx.graphics.getWidth()/1.77f,0);
                stage.addActor(buy_boats);
                if(playerObject.getBoats().size()>0)
                {
                    var =  list.getSelected().toString();
                    boatArrayList = playerObject.getBoats();
                    for(Boat b: boatArrayList)
                    {
                        if(var.equals(b.getLabel()))
                        {
                            your_boat = b;
                            break;
                        }
                    }
                    if(!(your_boat.counter_upgrage>=3)) {
                        stage.addActor(upgrade);
                        upgrade_bool = true;
                    }
//                    else
//                    {
//
//                            label = new Label("fully upgraded", skin);
//                            label.setPosition(Gdx.graphics.getWidth() / 6, 0);
//                            label.setFontScale(0.4f * Gdx.graphics.getDensity(), 0.4f * Gdx.graphics.getDensity());
//                            stage.addActor(label);
//                            label_boolean = true;
//                    }

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

                    if(testBoat.getLabel().equals("apollo"))
                    {
                        counter1+=1;
                        playerObject.addBoat(testBoat.copyBoat(counter1,1));
                    }
                    else if (testBoat.getLabel().equals("echo"))
                    {
                        counter2+=1;
                        playerObject.addBoat(testBoat.copyBoat(counter2,2));
                    }
                    else if (testBoat.getLabel().equals("frejus"))
                    {
                        counter3+=1;
                        playerObject.addBoat(testBoat.copyBoat(counter3,3));
                    }
                    else if (testBoat.getLabel().equals("helena"))
                    {
                        counter4+=1;
                        playerObject.addBoat(testBoat.copyBoat(counter4,4));
                    }
                    else if (testBoat.getLabel().equals("jester"))
                    {
                        counter5+=1;
                        playerObject.addBoat(testBoat.copyBoat(counter5,5));
                    }
                    else if (testBoat.getLabel().equals("luna"))
                    {
                        counter6+=1;
                        playerObject.addBoat(testBoat.copyBoat(counter6,6));
                    }
                    else if (testBoat.getLabel().equals("aria"))
                    {
                        counter7+=1;
                        playerObject.addBoat(testBoat.copyBoat(counter7,7));
                    }
                    else if (testBoat.getLabel().equals("nicas"))
                    {
                        counter8+=1;
                        playerObject.addBoat(testBoat.copyBoat(counter8,8));
                    }
                    else if (testBoat.getLabel().equals("titanic"))
                    {
                        counter9+=1;
                        playerObject.addBoat(testBoat.copyBoat(counter9,9));
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

        upgrade.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                var =  list.getSelected().toString();
                boatArrayList = playerObject.getBoats();
                for(Boat b: boatArrayList)
                {
                    if(var.equals(b.getLabel()))
                    {
                        your_boat = b;
                        break;
                    }
                }
                upgrade_stats = new Upgrade(your_boat.price/10,your_boat.getCapacity()+your_boat.capacity/100*10, your_boat.getSpeed()+your_boat.getSpeed()/100*10);
                if(playerObject.money>=upgrade_stats.getPrice())
                {
                    your_boat.counter_upgrage+=1;
                    your_boat.price+=upgrade_stats.getPrice()/2;
                    your_boat.capacity=upgrade_stats.getCapacity();
                    your_boat.speed = upgrade_stats.getSpeed();
                    playerObject.money-=upgrade_stats.getPrice();
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
        });

        sell.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                var = list.getSelected().toString();
                boatArrayList = playerObject.getBoats();
                if (playerObject.getBoats().size() > 0) {
                    for (Boat b : boatArrayList) {
                        if (var.equals(b.getLabel())) {
                            your_boat = b;
                            break;
                        }
                    }

                    boatArrayList = new ArrayList<Boat>();
                    playerObject.money += your_boat.getPrice()-your_boat.getPrice()/100*20;
                    if(your_boat.type_boat == 1)
                    {
                        counter1-=1;
                    }
                    else if (your_boat.type_boat == 2)
                    {
                        counter2-=1;
                    }
                    else if (your_boat.type_boat == 3)
                    {
                        counter3-=1;
                    }
                    else if (your_boat.type_boat == 4)
                    {
                        counter4-=1;

                    }
                    else if (your_boat.type_boat == 5)
                    {
                        counter5-=1;
                    }
                    else if (your_boat.type_boat == 6)
                    {
                        counter6-=1;

                    }
                    else if (your_boat.type_boat == 7)
                    {
                        counter7-=1;

                    }
                    else if (your_boat.type_boat == 8)
                    {
                        counter8-=1;
                    }
                    else if (your_boat.type_boat == 9)
                    {
                        counter9-=1;
                    }
                    playerObject.removeBoat(your_boat);
                    boatArrayList = playerObject.getBoats();
                    array = new ArrayList<String>();
                    for (Boat b : boatArrayList) {
                        array.add(b.getLabel());
                    }
                    Table table = new Table(skin);
                    table.getSkin().getFont("default-font").getData().setScale(0.6f*Gdx.graphics.getDensity(),0.6f*Gdx.graphics.getDensity());
                    table.align(Align.right|Align.top);
                    table.setPosition(0,container.getHeight());

                    scroll2.remove();

                    scroll2 = new ScrollPane(table, skin);
                    Label label1 = new Label("Your Boats" + System.getProperty("line.separator") + "Menu",skin);
                    label1.setFontScale(0.6f*Gdx.graphics.getDensity(),0.6f*Gdx.graphics.getDensity());
                    table.add(label1).row();
                    label1.setAlignment(Align.center);
                    table.add(list);
                    list.setItems(array.toArray());
                    container.add(scroll2).fill();
                    scroll2_bool=true;
                    money.setText("Current Balance:" + " " + playerObject.money);
                    boats_owned.setText("Boats Owned:" + " " + playerObject.numberOfBoatsOwned());
                    if(playerObject.getBoats().size()==0)
                    {
                        sell.remove();
                        if(upgrade_bool) {
                            upgrade.remove();
                            upgrade_bool = false;
                        }
                        if(label_boolean)
                        {
                            label.remove();
                        }
                        sell_bool = false;
                        boat_stats.remove();
                        your_actor.remove();
                        name.remove();
                        speed.remove();
                        capacity.remove();
                        distanceLimit.remove();
                        maintenanceCost.remove();
                        vulnerability.remove();

                    }
                }
            }
        });




        this.player_stats.setFontScale(0.333f*Gdx.graphics.getDensity(),0.333f*Gdx.graphics.getDensity());
        this.money.setFontScale(0.3f*Gdx.graphics.getDensity(),0.3f*Gdx.graphics.getDensity());
        this.boats_owned.setFontScale(0.3f*Gdx.graphics.getDensity(),0.3f*Gdx.graphics.getDensity());

        this.player_stats.setPosition(Gdx.graphics.getWidth()*40/100,
                stage.getHeight()-player_stats.getHeight());

        this.money.setPosition(Gdx.graphics.getWidth()*37/100,
                Gdx.graphics.getHeight()-name.getHeight()-Gdx.graphics.getHeight()*5/100);
        this.boats_owned.setPosition(Gdx.graphics.getWidth()*37/100,
                Gdx.graphics.getHeight()-name.getHeight()-Gdx.graphics.getHeight()*5/100*2);


        this.stage.addActor(this.player_stats);
        this.stage.addActor(this.boats_owned);
        this.stage.addActor(this.money);

        upgrade.getLabel().setFontScale(Gdx.graphics.getDensity()*0.3f,Gdx.graphics.getDensity()*0.3f);


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
        playerObject.rmBoat();
        playerObject.updateDamage();
        var =  list_of_boats.getSelected().toString();

        if(var.equals("apollo") && !boat1_bool)
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

            actor.setHeight(fixed_height*Gdx.graphics.getDensity());
            actor.setWidth(fixed_width*Gdx.graphics.getDensity());


            this.name = new Label("Name:"+" "+testBoat.getLabel(),skin);
            this.price = new Label("Price:"+" "+testBoat.getPrice(),skin);
            this.capacity = new Label("Capacity:"+" "+ testBoat.getCapacity(),skin);
            this.speed = new Label("Speed:"+" "+ testBoat.getSpeed(),skin);
            this.distanceLimit = new Label("Distance Limit:"+ " "+ testBoat.getDistanceLimit(),skin);
            this.maintenanceCost = new Label("Maintenance:"+ " "+ testBoat.getMaintenanceCost(),skin);
            this.vulnerability = new Label("Vulnerability:"+ " "+ (int)testBoat.getVulnerability(),skin);
            this.boat_stats = new Label("BOAT STATS:",skin);

            boat1_bool = true;
            boat2_bool = false;
            boat3_bool = false;
            boat4_bool = false;
            boat5_bool = false;
            boat6_bool = false;
            boat7_bool = false;
            boat8_bool = false;
            boat9_bool = false;

        }
        else if(var.equals("echo") && !boat2_bool)
        {
            System.out.println("I enter");
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

            actor.setHeight(fixed_height*Gdx.graphics.getDensity());
            actor.setWidth(fixed_width*Gdx.graphics.getDensity());

            this.name = new Label("Name:"+" "+testBoat.getLabel(),skin);
            this.price = new Label("Price:"+" "+testBoat.getPrice(),skin);
            this.capacity = new Label("Capacity:"+" "+ testBoat.getCapacity(),skin);
            this.speed = new Label("Speed:"+" "+ testBoat.getSpeed(),skin);
            this.distanceLimit = new Label("Distance Limit:"+ " "+ testBoat.getDistanceLimit(),skin);
            this.maintenanceCost = new Label("Maintenance:"+ " "+ testBoat.getMaintenanceCost(),skin);
            this.vulnerability = new Label("Vulnerability:"+ " "+ (int)testBoat.getVulnerability(),skin);
            this.boat_stats = new Label("BOAT STATS:",skin);

            boat1_bool = false;
            boat2_bool = true;
            boat3_bool = false;
            boat4_bool = false;
            boat5_bool = false;
            boat6_bool = false;
            boat7_bool = false;
            boat8_bool = false;
            boat9_bool = false;
        }
        else if(var.equals("frejus") && !boat3_bool)
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
            testBoat = playerObject.getPossibleBoats().get(2);

            boat = new Sprite(testBoat.getSideBoat()).getTexture();
            region = new TextureRegion(boat,boat.getWidth(),boat.getHeight());
            actor = new Image(region);

            actor.setHeight(fixed_height*Gdx.graphics.getDensity());
            actor.setWidth(fixed_width*Gdx.graphics.getDensity());

            this.name = new Label("Name:"+" "+testBoat.getLabel(),skin);
            this.price = new Label("Price:"+" "+testBoat.getPrice(),skin);
            this.capacity = new Label("Capacity:"+" "+ testBoat.getCapacity(),skin);
            this.speed = new Label("Speed:"+" "+ testBoat.getSpeed(),skin);
            this.distanceLimit = new Label("Distance Limit:"+ " "+ testBoat.getDistanceLimit(),skin);
            this.maintenanceCost = new Label("Maintenance:"+ " "+ testBoat.getMaintenanceCost(),skin);
            this.vulnerability = new Label("Vulnerability:"+ " "+ (int)testBoat.getVulnerability(),skin);
            this.boat_stats = new Label("BOAT STATS:",skin);

            boat1_bool = false;
            boat2_bool = false;
            boat3_bool = true;
            boat4_bool = false;
            boat5_bool = false;
            boat6_bool = false;
            boat7_bool = false;
            boat8_bool = false;
            boat9_bool = false;

        }
        else if(var.equals("helena") && !boat4_bool)
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
            testBoat = playerObject.getPossibleBoats().get(3);

            boat = new Sprite(testBoat.getSideBoat()).getTexture();
            region = new TextureRegion(boat,boat.getWidth(),boat.getHeight());
            actor = new Image(region);

            actor.setHeight(fixed_height*1.4f*Gdx.graphics.getDensity());
            actor.setWidth(fixed_width*1.2f*Gdx.graphics.getDensity());


            this.name = new Label("Name:"+" "+testBoat.getLabel(),skin);
            this.price = new Label("Price:"+" "+testBoat.getPrice(),skin);
            this.capacity = new Label("Capacity:"+" "+ testBoat.getCapacity(),skin);
            this.speed = new Label("Speed:"+" "+ testBoat.getSpeed(),skin);
            this.distanceLimit = new Label("Distance Limit:"+ " "+ testBoat.getDistanceLimit(),skin);
            this.maintenanceCost = new Label("Maintenance:"+ " "+ testBoat.getMaintenanceCost(),skin);
            this.vulnerability = new Label("Vulnerability:"+ " "+ (int)testBoat.getVulnerability(),skin);
            this.boat_stats = new Label("BOAT STATS:",skin);

            boat1_bool = false;
            boat2_bool = false;
            boat3_bool = false;
            boat4_bool = true;
            boat5_bool = false;
            boat6_bool = false;
            boat7_bool = false;
            boat8_bool = false;
            boat9_bool = false;
        }
        else if(var.equals("jester") && !boat5_bool)
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
            testBoat = playerObject.getPossibleBoats().get(4);

            boat = new Sprite(testBoat.getSideBoat()).getTexture();
            region = new TextureRegion(boat,boat.getWidth(),boat.getHeight());
            actor = new Image(region);

            actor.setHeight(fixed_height*Gdx.graphics.getDensity()*1.1f);
            actor.setWidth(fixed_width*Gdx.graphics.getDensity()*1.1f);

            this.name = new Label("Name:"+" "+testBoat.getLabel(),skin);
            this.price = new Label("Price:"+" "+testBoat.getPrice(),skin);
            this.capacity = new Label("Capacity:"+" "+ testBoat.getCapacity(),skin);
            this.speed = new Label("Speed:"+" "+ testBoat.getSpeed(),skin);
            this.distanceLimit = new Label("Distance Limit:"+ " "+ testBoat.getDistanceLimit(),skin);
            this.maintenanceCost = new Label("Maintenance:"+ " "+ testBoat.getMaintenanceCost(),skin);
            this.vulnerability = new Label("Vulnerability:"+ " "+ (int)testBoat.getVulnerability(),skin);
            this.boat_stats = new Label("BOAT STATS:",skin);

            boat1_bool = false;
            boat2_bool = false;
            boat3_bool = false;
            boat4_bool = false;
            boat5_bool = true;
            boat6_bool = false;
            boat7_bool = false;
            boat8_bool = false;
            boat9_bool = false;

        }
        else if(var.equals("luna") && !boat6_bool)
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
            testBoat = playerObject.getPossibleBoats().get(5);

            boat = new Sprite(testBoat.getSideBoat()).getTexture();
            region = new TextureRegion(boat,boat.getWidth(),boat.getHeight());
            actor = new Image(region);

            actor.setHeight(fixed_height*Gdx.graphics.getDensity()*1.1f);
            actor.setWidth(fixed_width*Gdx.graphics.getDensity()*1.1f);

            this.name = new Label("Name:"+" "+testBoat.getLabel(),skin);
            this.price = new Label("Price:"+" "+testBoat.getPrice(),skin);
            this.capacity = new Label("Capacity:"+" "+ testBoat.getCapacity(),skin);
            this.speed = new Label("Speed:"+" "+ testBoat.getSpeed(),skin);
            this.distanceLimit = new Label("Distance Limit:"+ " "+ testBoat.getDistanceLimit(),skin);
            this.maintenanceCost = new Label("Maintenance:"+ " "+ testBoat.getMaintenanceCost(),skin);
            this.vulnerability = new Label("Vulnerability:"+ " "+ (int)testBoat.getVulnerability(),skin);
            this.boat_stats = new Label("BOAT STATS:",skin);

            boat1_bool = false;
            boat2_bool = false;
            boat3_bool = false;
            boat4_bool = false;
            boat5_bool = false;
            boat6_bool = true;
            boat7_bool = false;
            boat8_bool = false;
            boat9_bool = false;
        }
        else if(var.equals("aria") && !boat7_bool)
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
            testBoat = playerObject.getPossibleBoats().get(6);

            boat = new Sprite(testBoat.getSideBoat()).getTexture();
            region = new TextureRegion(boat,boat.getWidth(),boat.getHeight());
            actor = new Image(region);

            actor.setHeight(fixed_height*Gdx.graphics.getDensity()*1.1f);
            actor.setWidth(fixed_width*Gdx.graphics.getDensity()*1.1f);

            this.name = new Label("Name:"+" "+testBoat.getLabel(),skin);
            this.price = new Label("Price:"+" "+testBoat.getPrice(),skin);
            this.capacity = new Label("Capacity:"+" "+ testBoat.getCapacity(),skin);
            this.speed = new Label("Speed:"+" "+ testBoat.getSpeed(),skin);
            this.distanceLimit = new Label("Distance Limit:"+ " "+ testBoat.getDistanceLimit(),skin);
            this.maintenanceCost = new Label("Maintenance:"+ " "+ testBoat.getMaintenanceCost(),skin);
            this.vulnerability = new Label("Vulnerability:"+ " "+ (int)testBoat.getVulnerability(),skin);
            this.boat_stats = new Label("BOAT STATS:",skin);

            boat1_bool = false;
            boat2_bool = false;
            boat3_bool = false;
            boat4_bool = false;
            boat5_bool = false;
            boat6_bool = false;
            boat7_bool = true;
            boat8_bool = false;
            boat9_bool = false;
        }
        else if(var.equals("nicas") && !boat8_bool)
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
            testBoat = playerObject.getPossibleBoats().get(7);

            boat = new Sprite(testBoat.getSideBoat()).getTexture();
            region = new TextureRegion(boat,boat.getWidth(),boat.getHeight());
            actor = new Image(region);

            actor.setHeight(fixed_height*Gdx.graphics.getDensity());
            actor.setWidth(fixed_width*Gdx.graphics.getDensity());

            this.name = new Label("Name:"+" "+testBoat.getLabel(),skin);
            this.price = new Label("Price:"+" "+testBoat.getPrice(),skin);
            this.capacity = new Label("Capacity:"+" "+ testBoat.getCapacity(),skin);
            this.speed = new Label("Speed:"+" "+ testBoat.getSpeed(),skin);
            this.distanceLimit = new Label("Distance Limit:"+ " "+ testBoat.getDistanceLimit(),skin);
            this.maintenanceCost = new Label("Maintenance:"+ " "+ testBoat.getMaintenanceCost(),skin);
            this.vulnerability = new Label("Vulnerability:"+ " "+ (int)testBoat.getVulnerability(),skin);
            this.boat_stats = new Label("BOAT STATS:",skin);

            boat1_bool = false;
            boat2_bool = false;
            boat3_bool = false;
            boat4_bool = false;
            boat5_bool = false;
            boat6_bool = false;
            boat7_bool = false;
            boat8_bool = true;
            boat9_bool = false;
        }
        else if(var.equals("titanic") && !boat9_bool)
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
            testBoat = playerObject.getPossibleBoats().get(8);

            boat = new Sprite(testBoat.getSideBoat()).getTexture();
            region = new TextureRegion(boat,boat.getWidth(),boat.getHeight());
            actor = new Image(region);

            actor.setHeight(fixed_height*Gdx.graphics.getDensity()*1.7f);
            actor.setWidth(fixed_width*Gdx.graphics.getDensity()*1.3f);

            this.name = new Label("Name:"+" "+testBoat.getLabel(),skin);
            this.price = new Label("Price:"+" "+testBoat.getPrice(),skin);
            this.capacity = new Label("Capacity:"+" "+ testBoat.getCapacity(),skin);
            this.speed = new Label("Speed:"+" "+ testBoat.getSpeed(),skin);
            this.distanceLimit = new Label("Distance Limit:"+ " "+ testBoat.getDistanceLimit(),skin);
            this.maintenanceCost = new Label("Maintenance:"+ " "+ testBoat.getMaintenanceCost(),skin);
            this.vulnerability = new Label("Vulnerability:"+ " "+ (int)testBoat.getVulnerability(),skin);
            this.boat_stats = new Label("BOAT STATS:",skin);

            boat1_bool = false;
            boat2_bool = false;
            boat3_bool = false;
            boat4_bool = false;
            boat5_bool = false;
            boat6_bool = false;
            boat7_bool = false;
            boat8_bool = false;
            boat9_bool = true;
        }
        if ((var.equals("apollo") || var.equals("echo") || var.equals("frejus") || var.equals("helena") || var.equals("jester") ||
                var.equals("luna") || var.equals("aria") || var.equals("nicas") || var.equals("titanic")) && bool && scroll1_bool) {

            bool = false;
            boat_stats_bool=true;
            this.actor.setScale(Gdx.graphics.getDensity()*0.5f,Gdx.graphics.getDensity()*0.5f);
            if(var.equals("titanic"))
            {
                this.actor.setPosition(Gdx.graphics.getWidth()/2 - actor.getWidth(),
                        Gdx.graphics.getHeight()/2 - actor.getHeight()/1.4f);
            }
            else {
                this.actor.setPosition(Gdx.graphics.getWidth() / 2 - actor.getWidth(),
                        Gdx.graphics.getHeight() / 2 - actor.getHeight());
            }




            this.name.setFontScale(0.3f*Gdx.graphics.getDensity(),0.3f*Gdx.graphics.getDensity());
            this.boat_stats.setFontScale(0.333f*Gdx.graphics.getDensity(),0.333f*Gdx.graphics.getDensity());
            this.price.setFontScale(0.3f*Gdx.graphics.getDensity(),0.3f*Gdx.graphics.getDensity());
            this.name.setFontScale(0.3f*Gdx.graphics.getDensity(),0.3f*Gdx.graphics.getDensity());
            this.capacity.setFontScale(0.3f*Gdx.graphics.getDensity(),0.3f*Gdx.graphics.getDensity());
            this.speed.setFontScale(0.3f*Gdx.graphics.getDensity(),0.3f*Gdx.graphics.getDensity());
            this.maintenanceCost.setFontScale(0.3f*Gdx.graphics.getDensity(),0.3f*Gdx.graphics.getDensity());
            this.distanceLimit.setFontScale(0.3f*Gdx.graphics.getDensity(),0.3f*Gdx.graphics.getDensity());
            this.vulnerability.setFontScale(0.3f*Gdx.graphics.getDensity(),0.3f*Gdx.graphics.getDensity());

            this.boat_stats.setPosition(Gdx.graphics.getWidth()*6/100,
                    Gdx.graphics.getHeight()-boat_stats.getHeight()+Gdx.graphics.getDensity()*8);
            this.name.setPosition(Gdx.graphics.getWidth()*3/100,
                    Gdx.graphics.getHeight()-name.getHeight()-Gdx.graphics.getHeight()*5/100+Gdx.graphics.getDensity()*8);
            this.price.setPosition(Gdx.graphics.getWidth()*3/100,
                    Gdx.graphics.getHeight()-name.getHeight()-Gdx.graphics.getHeight()*5/100*2+Gdx.graphics.getDensity()*8);
            this.capacity.setPosition(Gdx.graphics.getWidth()*3/100,
                    Gdx.graphics.getHeight()-name.getHeight()-Gdx.graphics.getHeight()*5/100*3+Gdx.graphics.getDensity()*8);
            this.speed.setPosition(Gdx.graphics.getWidth()*3/100,
                    Gdx.graphics.getHeight()-name.getHeight()-Gdx.graphics.getHeight()*5/100*4+Gdx.graphics.getDensity()*8);
            this.distanceLimit.setPosition(Gdx.graphics.getWidth()*3/100,
                    Gdx.graphics.getHeight()-name.getHeight()-Gdx.graphics.getHeight()*5/100*5+Gdx.graphics.getDensity()*8);
            this.maintenanceCost.setPosition(Gdx.graphics.getWidth()*3/100,
                    Gdx.graphics.getHeight()-name.getHeight()-Gdx.graphics.getHeight()*5/100*6+Gdx.graphics.getDensity()*8);
            this.vulnerability.setPosition(Gdx.graphics.getWidth()*3/100,
                    Gdx.graphics.getHeight()-name.getHeight()-Gdx.graphics.getHeight()*5/100*7+Gdx.graphics.getDensity()*8);

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
                this.vulnerability = new Label("Vulnerability:"+ " "+ (int)your_boat.getVulnerability(),skin);
                this.boat_stats = new Label("BOAT STATS:",skin);

                if(your_boat.type_boat == 1 || your_boat.type_boat == 2 || your_boat.type_boat == 3 || your_boat.type_boat == 8)
                {
                    your_actor.setHeight(fixed_height*Gdx.graphics.getDensity());
                    your_actor.setWidth(fixed_width*Gdx.graphics.getDensity());
                }
                else if(your_boat.type_boat == 4)
                {
                    your_actor.setHeight(fixed_height*1.4f*Gdx.graphics.getDensity());
                    your_actor.setWidth(fixed_width*1.2f*Gdx.graphics.getDensity());
                }
                else if(your_boat.type_boat == 5 || your_boat.type_boat == 6
                    || your_boat.type_boat == 7)
                {
                    your_actor.setHeight(fixed_height*Gdx.graphics.getDensity()*1.1f);
                    your_actor.setWidth(fixed_width*Gdx.graphics.getDensity()*1.1f);
                }
                else if (your_boat.type_boat == 9)
                {
                    your_actor.setHeight(fixed_height*Gdx.graphics.getDensity()*1.7f);
                    your_actor.setWidth(fixed_width*Gdx.graphics.getDensity()*1.3f);
                }

                if(your_boat.type_boat == 9)
                {
                    this.actor.setPosition(Gdx.graphics.getWidth()/2 - actor.getWidth(),
                            Gdx.graphics.getHeight()/2 - actor.getHeight()/1.4f);
                }
                else {
                    this.actor.setPosition(Gdx.graphics.getWidth() / 2 - actor.getWidth(),
                            Gdx.graphics.getHeight() / 2 - actor.getHeight());
                }

                this.your_actor.setScale(Gdx.graphics.getDensity()*0.5f,Gdx.graphics.getDensity()*0.5f);




                this.name.setFontScale(0.3f*Gdx.graphics.getDensity(),0.3f*Gdx.graphics.getDensity());
                this.boat_stats.setFontScale(0.333f*Gdx.graphics.getDensity(),0.333f*Gdx.graphics.getDensity());
                this.price.setFontScale(0.3f*Gdx.graphics.getDensity(),0.3f*Gdx.graphics.getDensity());
                this.name.setFontScale(0.3f*Gdx.graphics.getDensity(),0.3f*Gdx.graphics.getDensity());
                this.capacity.setFontScale(0.3f*Gdx.graphics.getDensity(),0.3f*Gdx.graphics.getDensity());
                this.speed.setFontScale(0.3f*Gdx.graphics.getDensity(),0.3f*Gdx.graphics.getDensity());
                this.maintenanceCost.setFontScale(0.3f*Gdx.graphics.getDensity(),0.3f*Gdx.graphics.getDensity());
                this.distanceLimit.setFontScale(0.3f*Gdx.graphics.getDensity(),0.3f*Gdx.graphics.getDensity());
                this.vulnerability.setFontScale(0.3f*Gdx.graphics.getDensity(),0.3f*Gdx.graphics.getDensity());

                this.boat_stats.setPosition(Gdx.graphics.getWidth()*6/100,
                        Gdx.graphics.getHeight()-boat_stats.getHeight()+Gdx.graphics.getDensity()*8);
                this.name.setPosition(Gdx.graphics.getWidth()*3/100,
                        Gdx.graphics.getHeight()-name.getHeight()-Gdx.graphics.getHeight()*5/100+Gdx.graphics.getDensity()*8);
                this.capacity.setPosition(Gdx.graphics.getWidth()*3/100,
                        Gdx.graphics.getHeight()-name.getHeight()-Gdx.graphics.getHeight()*5/100*2+Gdx.graphics.getDensity()*8);
                this.speed.setPosition(Gdx.graphics.getWidth()*3/100,
                        Gdx.graphics.getHeight()-name.getHeight()-Gdx.graphics.getHeight()*5/100*3+Gdx.graphics.getDensity()*8);
                this.distanceLimit.setPosition(Gdx.graphics.getWidth()*3/100,
                        Gdx.graphics.getHeight()-name.getHeight()-Gdx.graphics.getHeight()*5/100*4+Gdx.graphics.getDensity()*8);
                this.maintenanceCost.setPosition(Gdx.graphics.getWidth()*3/100,
                        Gdx.graphics.getHeight()-name.getHeight()-Gdx.graphics.getHeight()*5/100*5+Gdx.graphics.getDensity()*8);
                this.vulnerability.setPosition(Gdx.graphics.getWidth()*3/100,
                        Gdx.graphics.getHeight()-name.getHeight()-Gdx.graphics.getHeight()*5/100*6+Gdx.graphics.getDensity()*8);

                this.stage.addActor(this.boat_stats);
                this.stage.addActor(this.name);
              //  this.stage.addActor(this.price);
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
                //price.remove();

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
                this.vulnerability = new Label("Vulnerability:"+ " "+ (int)your_boat.getVulnerability(),skin);
                this.boat_stats = new Label("BOAT STATS:",skin);

                if(your_boat.type_boat == 1 || your_boat.type_boat == 2 || your_boat.type_boat == 3 || your_boat.type_boat == 8)
                {
                    your_actor.setHeight(fixed_height*Gdx.graphics.getDensity());
                    your_actor.setWidth(fixed_width*Gdx.graphics.getDensity());
                }
                else if(your_boat.type_boat == 4)
                {
                    your_actor.setHeight(fixed_height*1.4f*Gdx.graphics.getDensity());
                    your_actor.setWidth(fixed_width*1.2f*Gdx.graphics.getDensity());
                }
                else if(your_boat.type_boat == 5 || your_boat.type_boat == 6
                        || your_boat.type_boat == 7)
                {
                    your_actor.setHeight(fixed_height*Gdx.graphics.getDensity()*1.1f);
                    your_actor.setWidth(fixed_width*Gdx.graphics.getDensity()*1.1f);
                }
                else if (your_boat.type_boat == 9)
                {
                    your_actor.setHeight(fixed_height*Gdx.graphics.getDensity()*1.7f);
                    your_actor.setWidth(fixed_width*Gdx.graphics.getDensity()*1.3f);
                }

                if(your_boat.type_boat == 9)
                {
                    this.your_actor.setPosition(Gdx.graphics.getWidth()/2 - your_actor.getWidth(),
                            Gdx.graphics.getHeight()/2 - your_actor.getHeight()/1.4f);
                }
                else {
                    this.your_actor.setPosition(Gdx.graphics.getWidth() / 2 - your_actor.getWidth(),
                            Gdx.graphics.getHeight() / 2 - your_actor.getHeight());
                }

                this.your_actor.setScale(Gdx.graphics.getDensity()*0.5f,Gdx.graphics.getDensity()*0.5f);




                this.name.setFontScale(0.3f*Gdx.graphics.getDensity(),0.3f*Gdx.graphics.getDensity());
                this.boat_stats.setFontScale(0.333f*Gdx.graphics.getDensity(),0.333f*Gdx.graphics.getDensity());
                this.price.setFontScale(0.3f*Gdx.graphics.getDensity(),0.3f*Gdx.graphics.getDensity());
                this.name.setFontScale(0.3f*Gdx.graphics.getDensity(),0.3f*Gdx.graphics.getDensity());
                this.capacity.setFontScale(0.3f*Gdx.graphics.getDensity(),0.3f*Gdx.graphics.getDensity());
                this.speed.setFontScale(0.3f*Gdx.graphics.getDensity(),0.3f*Gdx.graphics.getDensity());
                this.maintenanceCost.setFontScale(0.3f*Gdx.graphics.getDensity(),0.3f*Gdx.graphics.getDensity());
                this.distanceLimit.setFontScale(0.3f*Gdx.graphics.getDensity(),0.3f*Gdx.graphics.getDensity());
                this.vulnerability.setFontScale(0.3f*Gdx.graphics.getDensity(),0.3f*Gdx.graphics.getDensity());

                this.boat_stats.setPosition(Gdx.graphics.getWidth()*6/100,
                        Gdx.graphics.getHeight()-boat_stats.getHeight()+Gdx.graphics.getDensity()*8);
                this.name.setPosition(Gdx.graphics.getWidth()*3/100,
                        Gdx.graphics.getHeight()-name.getHeight()-Gdx.graphics.getHeight()*5/100+Gdx.graphics.getDensity()*8);
                this.capacity.setPosition(Gdx.graphics.getWidth()*3/100,
                        Gdx.graphics.getHeight()-name.getHeight()-Gdx.graphics.getHeight()*5/100*2+Gdx.graphics.getDensity()*8);
                this.speed.setPosition(Gdx.graphics.getWidth()*3/100,
                        Gdx.graphics.getHeight()-name.getHeight()-Gdx.graphics.getHeight()*5/100*3+Gdx.graphics.getDensity()*8);
                this.distanceLimit.setPosition(Gdx.graphics.getWidth()*3/100,
                        Gdx.graphics.getHeight()-name.getHeight()-Gdx.graphics.getHeight()*5/100*4+Gdx.graphics.getDensity()*8);
                this.maintenanceCost.setPosition(Gdx.graphics.getWidth()*3/100,
                        Gdx.graphics.getHeight()-name.getHeight()-Gdx.graphics.getHeight()*5/100*5+Gdx.graphics.getDensity()*8);
                this.vulnerability.setPosition(Gdx.graphics.getWidth()*3/100,
                        Gdx.graphics.getHeight()-name.getHeight()-Gdx.graphics.getHeight()*5/100*6+Gdx.graphics.getDensity()*8);

                this.stage.addActor(this.boat_stats);
                this.stage.addActor(this.name);
                   // this.stage.addActor(this.price);
                this.stage.addActor(this.speed);
                this.stage.addActor(this.capacity);
                this.stage.addActor(this.distanceLimit);
                this.stage.addActor(this.maintenanceCost);
                this.stage.addActor(this.vulnerability);
                this.stage.addActor(this.your_actor);

            }
            if(sell_bool)
            {
                sell.setText("sell boat" + System.getProperty("line.separator") +"for:"+ (your_boat.getPrice()-your_boat.getPrice()/100*20));

            }
            if(your_boat.counter_upgrage<3)
            {
                upgrade.setText("upgrade"+ (your_boat.counter_upgrage+1) + System.getProperty("line.separator")+
                                "price:" + ((int) your_boat.price/10 + System.getProperty("line.separator")) +
                                "capacity:"+ ((float)((your_boat.getCapacity()+(your_boat.getCapacity()/100*10))/1000f))+"k"+ System.getProperty("line.separator") +
                                "speed:"+ ((int)(your_boat.getSpeed()+(your_boat.getSpeed()/100*10))));

            }
            if(your_boat.counter_upgrage>=3)
            {
                if(!label_boolean) {
                    upgrade.remove();
                    label = new Label("fully upgraded", skin);
                    label.setPosition(Gdx.graphics.getWidth() / 6, 0);
                    label.setFontScale(0.4f * Gdx.graphics.getDensity(), 0.4f * Gdx.graphics.getDensity());
                    stage.addActor(label);
                    label_boolean = true;
                }
            }
            else
            {
                if(label_boolean)
                {
                    label.remove();
                    upgrade_stats = new Upgrade(your_boat.price/10,your_boat.getCapacity()+your_boat.getCapacity()/100*10, your_boat.getSpeed()+your_boat.getSpeed()/100*10);
                    stage.addActor(upgrade);
                    label_boolean=false;
                }
            }

    }

    }

    public int nextState(){

        if(back.isPressed() && Gdx.input.justTouched()){
            back.toggle();

            return 0;
        }
        return 2;
    }

    @Override
    public void inputHandler() {
    }
    public void removeStage(){
        stage.dispose();
    }
    }
