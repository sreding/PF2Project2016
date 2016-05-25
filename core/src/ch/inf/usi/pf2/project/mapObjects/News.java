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
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
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
import javafx.scene.control.TextFormatter;
import sun.security.x509.AlgIdDSA;

/**
 * Created by simonreding on 23/05/16.
 */


public class News extends GameState {

    private ArrayList<Article> articles;
    private SpriteBatch batch;
    private int numberOfArticles;
    private ScrollPane scrollPane;
    private Table table;
    private Container newsContent;
    private VerticalGroup verticalGroup;
    private TextButton esc;
    private Stage stage;
    private Skin skin;
    private Label label;
    private Table header;
    private ButtonGroup buttonGroup;




    public News(SpriteBatch batch) {
        this.articles = new ArrayList<Article>();
        stage = new Stage(new ScreenViewport(),batch);
        skin = new Skin(Gdx.files.internal("uiskin.json"));
        numberOfArticles = 0;
        ///ADD ARRAYLIST OF ARTCLES FROM PLAYER!

        buttonGroup = new ButtonGroup();
        buttonGroup.setMaxCheckCount(1);
        table = new Table();
        table.setWidth(stage.getWidth());//Gdx.graphics.getWidth());
        table.align(Align.left| Align.top);
        table.setPosition(0,Gdx.graphics.getHeight());

        verticalGroup = new VerticalGroup();
        scrollPane =  new ScrollPane(verticalGroup);

        esc = autoPad(new TxtButton("Back",skin,-3),8);

        scrollPane.setHeight(stage.getHeight()-esc.getHeight());


        TxtButton testButton = new TxtButton("Title goes here", skin,1);
        TxtButton testButton2 = new TxtButton("second title goes here lets see how many characters go here", skin,2);
        //testButton.setSize(stage.getWidth()/3,stage.getHeight()/3);
        //testButton2.setSize(stage.getWidth()/3,stage.getHeight()/3;
        testButton = autoPad(testButton,3);
        testButton2 = autoPad(testButton2, 3);


        buttonGroup.add(testButton,testButton2);

        verticalGroup.padBottom(stage.getHeight()-esc.getHeight());
        verticalGroup.addActor(testButton);
        verticalGroup.addActor(testButton2);

        label = new Label("this is the label does it span over multiple lines?"+stage.getHeight()+"Width:"
                +stage.getWidth()+
                "getWidth"
                +Gdx.graphics.getWidth(),skin);
        label.setWrap(true);

        newsContent = new Container(label).align(Align.topLeft);
        newsContent.fillX();

        header = new Table(skin);

        header.align(Align.topLeft);
        table.add(esc).align(Align.left).width(esc.getPrefWidth());
        header.add(new Label("The News",skin)).align(Align.center);

        table.add(header).align(Align.center);
        table.add(new Label("Today's Headlines",skin)).align(Align.center);
        table.row();
        table.add(new Table(skin));
        table.add(newsContent).width((stage.getWidth())-verticalGroup.getPrefWidth()-(esc.getPrefWidth()))
                .height((Gdx.graphics.getHeight()-esc.getPrefHeight()));
        table.add(scrollPane).width(testButton.getPrefWidth());
        //table.debug();


        //table.layout();
        //table.validate();
        stage.addActor(table);
        Gdx.input.setInputProcessor(stage);

    }


    @Override
    public void renderGameObject(){
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        TxtButton button = (TxtButton)buttonGroup.getChecked();
        if(button.getIndex()<= articles.size()&& button.getIndex() >= 0) {
            label = new Label(articles.get(button.getIndex()).getContent(), skin);
        }
        if(esc.isPressed() == true){
            // IMPLEMENT GOING BACK TO MAP
        }

        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();
    }



    private void setLabel(int n){
        this.label.setText(articles.get(n).getContent());
    }

    private void addArticles(ArrayList<Article> newA){
        for(Article a:newA){
            TxtButton button = a.getTextButton();
            button.setIndex(numberOfArticles);
            button = autoPad(button, 3);
            verticalGroup.addActor(button);
            this.articles.add(a);
            numberOfArticles++;
        }

    }
    private static TxtButton autoPad(TxtButton button,int pad){
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
                                                   ArrayList<Article> finishedArticles, int n,
                                                   int numberOfArticles) {
        if(events.size() == n){
            return finishedArticles;
    }else{
            Random rn = new Random();
            String country = regions.get(rn.nextInt(regions.size()+1));
            String title = events.get(n)+ " in " +country;
            String text = "The" + events.get(n) + " that destroyed " + country+"appear to" +
                    "have devastating consequences to the region";
            finishedArticles.add(new Article(title,text,numberOfArticles));
            n++;
            numberOfArticles++;
            return makeArticles(regions,events,finishedArticles,n,numberOfArticles);
        }

    }




    }