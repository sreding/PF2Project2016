package ch.inf.usi.pf2.project.gameStates;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Container;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import ch.inf.usi.pf2.project.mapObjects.Place;
import ch.inf.usi.pf2.project.mapObjects.Player;

/**
 * Created by simonreding on 01/06/16.
 */
public class Pause extends GameState{
    Label pause;
    Label instructions;
    Label instructionContent;
    Container container;
    Table table;
    Stage stage;
    Player player;
    SpriteBatch batch;
    Skin skin;
    TextButton reset;
    ScrollPane scrollPane;
    TextButton back;
    Sprite background;


    public Pause(SpriteBatch batch, Player player){
        this.batch = batch;
        this.player = player;
        this.skin = new Skin(Gdx.files.internal("uiskin.json"));
        stage = new Stage(new ScreenViewport(),batch);

        pause = new Label("Game Paused",skin);
        instructions = new Label("How to play:",skin);
        instructions.setFontScale(Gdx.graphics.getWidth()*1.3f/1810f,Gdx.graphics.getHeight()*1.3f/1080f);
        instructions.setColor(1f,1f,1f,1f);
        instructionContent = new Label("Map: Drag the map left or right to see different " +
                "parts of the world. Buy a boat in the manager (bottom left) and start " +
                "drawing routes by selecting a port. A window will show up asking you to select " +
                "a boat. Confirm selection and start drawing to a different port." +
                "\n\nIn the news you can find out about disasters along the route. Careful: Disasters may " +
                "harm your boat so stay away from the regions mentioned in the news.\n\n" +
                "Manager: here you can buy new boat or upgrade existing ones." +
                "\n\n\n Credits:" +
                "\nAlexander C: Java, Database\n" +
                "Andrea P: Database, Interface\n" +
                "Ilija G: Java\n" +
                "Gianmarco P: Artwork\n" +
                "Simon R: Java,Interface,Idea\n\n" +
                "An HCI Project under guidance of Omar J.",skin);
        instructionContent.setColor(1f,1f,1f,1f);
        instructionContent.setFontScale(Gdx.graphics.getWidth()/1810f,Gdx.graphics.getHeight()/1080f);
        reset = new TextButton("Reset Game", skin);
        reset.pad(Gdx.graphics.getHeight()/20);
        back = new TextButton("Back", skin);
        back.pad(Gdx.graphics.getHeight()/20);
        instructionContent.setWrap(true);
        container = new Container(instructionContent);
        container.maxWidth(Gdx.graphics.getWidth()/2);
        container.padTop(Gdx.graphics.getHeight()/40);

        //container.padRight(Gdx.graphics.getHeight()/40);
        scrollPane = new ScrollPane(container);
        container.fillX();
        reset.setColor(1f,1f,1f,0.7f);
        back.setColor(1f,1f,1f,0.7f);
        table = new Table();
        table.align(Align.center);
        table.setWidth(Gdx.graphics.getWidth());
        table.setHeight(Gdx.graphics.getHeight());
        //table.add(back);
        table.row();
        table.add(instructions).align(Align.center);
        table.row();
        table.add(scrollPane).align(Align.left).width(Gdx.graphics.getWidth()/2).height(Gdx.graphics.getHeight()/2);
        table.row().height(Gdx.graphics.getHeight()/10);
        table.add();
        table.row();
        table.add(reset);
        //table.debug();
        Table tbl = new Table();
        tbl.setWidth(Gdx.graphics.getWidth());
        tbl.setHeight(Gdx.graphics.getHeight());
        tbl.align(Align.topLeft);
        tbl.add(back);
        tbl.add().width(Gdx.graphics.getWidth()-back.getPrefWidth()-pause.getPrefWidth());
        tbl.add(pause).align(Align.topRight);

        stage.addActor(table);
        stage.addActor(tbl);
        background = new Sprite(new Texture(Gdx.files.internal("backgroundTexture.png")),
                Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        background.setColor(0.4f,0.2f,0.2f,1f);
    }
    public void Update(float dt){
        stage.draw();

    }
    public void renderGameObject(){

        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        Gdx.input.setInputProcessor(stage);
        batch.begin();
        background.draw(batch);
        batch.end();
        stage.draw();
    }
    public void inputHandler(){
        stage.act(Gdx.graphics.getDeltaTime());
    }
    public int nextState(){
        if(back.isPressed() && Gdx.input.justTouched()){
            return 0;
        }else{
        return 3;}
    }
}
