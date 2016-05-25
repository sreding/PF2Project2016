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
import com.sun.org.apache.xalan.internal.xsltc.compiler.util.TestGenerator;


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


        //table.setFillParent(true);  //setWidth(stage.getWidth());

        //table.setHeight(Gdx.graphics.getHeight());
        table = new Table();
        table.setWidth(stage.getWidth());//Gdx.graphics.getWidth());
        table.align(Align.left| Align.top);
        table.setPosition(0,Gdx.graphics.getHeight());

        verticalGroup = new VerticalGroup();
        //verticalGroup.setWidth(stage.getWidth()/3);
        //verticalGroup.setHeight(stage.getHeight()/3);

        //verticalGroup.center();
        //verticalGroup.setBounds(Gdx.graphics.getWidth()/3,0,Gdx.graphics.getWidth()/3,Gdx.graphics.getHeight());

        scrollPane =  new ScrollPane(verticalGroup);
        //scrollPane.setWidth(verticalGroup.getWidth());
        //scrollPane.setBounds(stage.getWidth()*2/3,0f,stage.getWidth()/3,stage.getHeight());
        //verticalGroup.setFillParent(true);


        esc = autoPad(new TextButton("Back",skin),8);

        scrollPane.setHeight(stage.getHeight()-esc.getHeight());


        TextButton testButton = new TextButton("Title goes here", skin);
        TextButton testButton2 = new TextButton("second title goes here", skin);
        //testButton.setSize(stage.getWidth()/3,stage.getHeight()/3);
        //testButton2.setSize(stage.getWidth()/3,stage.getHeight()/3;
        testButton = autoPad(testButton,3);
        testButton2 = autoPad(testButton2, 3);



        verticalGroup.padBottom(stage.getHeight()-esc.getHeight());
        verticalGroup.addActor(testButton);
        verticalGroup.addActor(testButton2);

        label = new Label("this is the label does it span over multiple lines?"+stage.getHeight()+"Width:"
                +stage.getWidth()+
                "getWidth"
                +Gdx.graphics.getWidth(),skin);
        label.setWrap(true);
        label.setFillParent(true);
        newsContent = new Window("Details",skin);
        newsContent.setWidth(verticalGroup.getWidth());
        newsContent.align(Align.left);
        newsContent.add(label);








        table.add(esc).align(Align.topLeft);
        table.add(new Label("The News",skin));
        //table.layout();
        //table.validate();
        table.row();
        table.add(newsContent).width((Gdx.graphics.getWidth())-testButton.getPrefWidth())
                .height((Gdx.graphics.getHeight()-esc.getPrefHeight()));
        table.add(scrollPane).width(testButton.getPrefWidth());
        table.debug();

        //table.layout();
        //table.validate();





        stage.addActor(table);
        Gdx.input.setInputProcessor(stage);

    }

    @Override
    public void renderGameObject(){
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();


    }


    private static TextButton autoPad(TextButton button,int pad){
        float value = (Gdx.graphics.getWidth()/(2*pad))-(button.getMinWidth()/2);
        button.padRight(value);
        button.padLeft(value);
        button.padBottom(Gdx.graphics.getHeight()/(2*pad));
        button.padTop(Gdx.graphics.getHeight()/(2*pad));
        return button;
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