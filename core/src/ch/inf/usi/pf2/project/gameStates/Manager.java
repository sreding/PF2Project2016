package ch.inf.usi.pf2.project.gameStates;
import ch.inf.usi.pf2.project.mapObjects.*;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Widget;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Cell;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.graphics.g2d.Sprite;


/**
 * Created by simonreding on 17/05/16.
 */
public class Manager extends GameState {

    private Player playerObject;
    private SpriteBatch batch;
    private OrthographicCamera cam;
    private ShapeRenderer shapeRenderer;
    private Table table;
    private Label label;
    private Actor window;
    private BitmapFont font;
    private Texture background;
    private Texture somebutton;
    private Stage stage;
    private Skin skin;
    private TextButton startButton;
    private TextButton quitButton;
    private Sprite sprite;



    public Manager(SpriteBatch batch)
    {
        skin = new Skin(Gdx.files.internal("uiskin.json"));
        stage = new Stage(new ScreenViewport());

//        table = new Table();
//        table.setWidth(stage.getWidth());
//        table.align(Align.center|Align.top);
//
//        table.setPosition(0, Gdx.graphics.getHeight());
//
//        startButton = new TextButton("New Game", skin);
//        quitButton = new TextButton("Quit Game", skin);
//
//        table.padTop(30);
//        table.add(startButton).padBottom(30);
//        table.row();
//        table.add(quitButton);
//
//        stage.addActor(table);
//
//        this.batch = new SpriteBatch();
//        sprite = new Sprite(new Texture(Gdx.files.internal("background.png")));
//        sprite.setSize(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());



        final TextButton button = new TextButton("Buy a new boat",skin, "default");
        button.setWidth(300);
        button.setHeight(400);


        final Dialog dialog = new Dialog ("Click Message", skin);
        button.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y)
            {
                dialog.show(stage);
                Timer.schedule(new Timer.Task(){
                    @Override
                    public void run()
                    {
                        dialog.hide();
                    }

                },5);

            }
        });
        stage.addActor(button);
//        stage.addActor(button);
        //BitmapFont font=new BitmapFont();
        //this.label=new Label("money",new LabelStyle(font, new Color().RED));
        //this.table=new Table(skin);
        //table.add(label);

        Gdx.input.setInputProcessor(stage);

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
        //batch.begin();
       // sprite.draw(batch);
        //batch.end();
        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();

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
