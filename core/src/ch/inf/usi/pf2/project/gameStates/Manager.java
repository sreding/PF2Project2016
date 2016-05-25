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
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
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


/**
 * Created by simonreding on 17/05/16.
 */
public class Manager extends GameState {

    private Player playerObject;
    private SpriteBatch batch;
    private TextureAtlas atlas;
    private OrthographicCamera cam;
    private ShapeRenderer shapeRenderer;
    private Table table;
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
    private Texture boat1;
    private Table boat_attributes;
    private ScrollPane scrollPane;
    private List list_of_boats;
    private Table my_boats;
    private TextButton play;
    private TextButton back;
    private Texture background;
    private Sprite splash;
    private BitmapFont black;





    public Manager(SpriteBatch batch)
    {

        this.batch = new SpriteBatch();
        this.background = new Texture("background_manager.png");
        this.splash = new Sprite(background);
        this.splash.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        this.skin = new Skin(Gdx.files.internal("uiskin.json"));
        //this.black = new BitmapFont(Gdx.files.internal("font_manager/blackfont.fnt"), false);






//
        this.stage = new Stage();
        Gdx.input.setInputProcessor(stage);
//        atlas = new TextureAtlas("uiatlas.pack");
//        skin = new Skin(Gdx.files.internal("uiskin.json"),atlas);
//
        table = new Table(skin);
        table.debug();

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



//        list_of_boats = new List(skin);
//        list_of_boats.setItems(new String[] {"Fascinosa", "Titanic", "Simon", "Alejandro", "GianMARKET", "PEROZA", "ILIJA","Fascinosa", "Titanic", "Simon", "Alejandro", "GianMARKET", "PEROZA", "ILIJA"});
//        scroll = new ScrollPane(list_of_boats,skin);
//        scroll.setWidth(200f);
//        scroll.setHeight(stage.getHeight()/1.3f);




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

       // stage.addActor(boat_attributes);



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
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();
        splash.draw(batch);
        batch.end();

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
//        boat1 = new Texture(Gdx.files.internal("topBoat1.png"));
//        stage.act(Gdx.graphics.getDeltaTime());
//        stage.draw();
        //batch.begin();

        //batch.draw(boat1, Gdx.graphics.getWidth()/2 - 900/2,
       //         Gdx.graphics.getHeight()/2 - 300/2, 900, 300);
       // batch.end();

//        batch.begin();
//
//        batch.draw(background, 0, 0,(float) Gdx.graphics.getWidth() , (float) Gdx.graphics.getHeight() );
//
//
//        batch.end();

    }

    @Override
    public void update(float dt) {

    }

    @Override
    public void inputHandler() {
    }
}
