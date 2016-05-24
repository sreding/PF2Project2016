package ch.inf.usi.pf2.project.mapObjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Value.Fixed;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.Layout;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Pool;
import com.badlogic.gdx.utils.Pools;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.sun.org.apache.bcel.internal.generic.NEW;


import java.util.ArrayList;
import java.util.Random;

import ch.inf.usi.pf2.project.gameStates.GameState;
import sun.security.x509.AlgIdDSA;

/**
 * Created by simonreding on 23/05/16.
 */


public class News extends GameState {

    private ArrayList articles;
    private SpriteBatch batch;

    private ScrollPane scrollPane;
    private Table table;
    private Table newsContent;
    private VerticalGroup verticalGroup;
    private TextButton esc;
    private Stage stage;
    private Skin skin;
    private Label label;



    public News(SpriteBatch batch) {
        this.articles = new ArrayList<Article>();
        stage = new Stage(new ScreenViewport(),batch);
        skin = new Skin(Gdx.files.internal("uiskin.json"));

        table = new Table();
        table.setFillParent(true);  //setWidth(stage.getWidth());
        table.align(Align.left| Align.top);

        verticalGroup = new VerticalGroup();
        verticalGroup.setWidth(stage.getWidth());
        System.out.print(stage.getWidth());
        verticalGroup.align(Align.topRight);

        scrollPane =  new ScrollPane(verticalGroup);
        scrollPane.setWidth(verticalGroup.getWidth());


        esc = new TextButton("esc",skin);
        esc.align(Align.topLeft);


        TextButton testButton = new TextButton("Disaster", skin);
        TextButton testButton2 = new TextButton("second Disaster", skin);
        testButton.setFillParent(true);
        testButton2.setFillParent(true);
        verticalGroup.addActor(testButton);
        verticalGroup.addActor(testButton2);

        label = new Label("this is the label does it span over multiple lines?",skin);
        label.setFillParent(true);
        newsContent =  new Table(skin);
        newsContent.setWidth(verticalGroup.getWidth());
        newsContent.align(Align.bottomLeft);
        newsContent.add(label);


        table.add(newsContent,scrollPane,esc);



        stage.addActor(table);
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void renderGameObject(){
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();


    }



    //creates an arrayList of new Buttons
    private static ArrayList<TextButton> newButtons(ArrayList<Article> articles){
        return makeNewButtons(articles,new ArrayList<TextButton>(),0);
    }
    private static ArrayList<TextButton> makeNewButtons(ArrayList<Article> articles,
                                                    ArrayList<TextButton> buttons,
                                                    int n){
        if(n == articles.size()){
            return buttons;
        }else {
            Skin buttonSkin = new Skin(Gdx.files.internal("uiskin.json")); //// ENTER PARAMETERS FOR SKIN!!!!!
            TextButton newButton = new TextButton(articles.get(n).getTitle(),buttonSkin);
            buttons.add(newButton);
            return makeNewButtons(articles,buttons,n++);

        }


    }
    //simple function that generates a list of articles given lists of
    // strings containing names of regions and desasters
    private static ArrayList<Article> makeArticles(ArrayList<String> regions,
                                                   ArrayList<String> events,
                                                   ArrayList<Article> finishedArticles, int n) {
        if(events.size() == n){
            return finishedArticles;
    }else{
            Random rn = new Random();
            String country = regions.get(rn.nextInt(regions.size()+1));
            String title = events.get(n)+ " in " +country;
            String text = "The" + events.get(n) + " that destroyed " + country+"appear to" +
                    "have devastating consequences to the region";
            finishedArticles.add(new Article(title,text));
            n++;
            return makeArticles(regions,events,finishedArticles,n);
        }

    }




    }