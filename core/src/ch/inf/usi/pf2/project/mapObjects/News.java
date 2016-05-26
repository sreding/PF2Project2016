package ch.inf.usi.pf2.project.mapObjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
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
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.scenes.scene2d.utils.TiledDrawable;
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
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import ch.inf.usi.pf2.project.gameStates.GameState;
import javafx.scene.control.TextFormatter;
import javafx.scene.layout.Background;
import sun.security.x509.AlgIdDSA;

/**
 * Created by simonreding on 23/05/16.
 */


public class News extends GameState {

    private ArrayList<Article> articles;
    private SpriteBatch spriteBatch;
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
    private Sprite background;
    private SpriteBatch batch;
    private BitmapFont bitmapFont;




    public News(SpriteBatch batch) {
        bitmapFont = new BitmapFont(Gdx.files.internal("cinzel45.fnt"),Gdx.files.internal("cinzel45.png"),false);
        this.spriteBatch = batch;
        background = new Sprite(new Texture(Gdx.files.internal("backgroundTexture.png")));

        this.articles = new ArrayList<Article>();
        stage = new Stage(new ScreenViewport(),batch);
        skin = new Skin(Gdx.files.internal("uiskin.json"));//,Gdx.files.internal("uiskin.atlas"));
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
        esc.getLabel().setFontScale(Gdx.graphics.getWidth()/1810f,Gdx.graphics.getHeight()/1080f);

        scrollPane.setHeight(stage.getHeight()-esc.getHeight());


        TxtButton testButton = new TxtButton("Title goes here", skin,1);
        TxtButton testButton2 = new TxtButton("second title goes here look it actually displays over multiple lines!", skin,2);
        //testButton.setSize(stage.getWidth()/3,stage.getHeight()/3);
        //testButton2.setSize(stage.getWidth()/3,stage.getHeight()/3;
        testButton.getLabel().setFontScale(Gdx.graphics.getWidth()/1810f,Gdx.graphics.getHeight()/1080f);
        testButton2.getLabel().setFontScale(Gdx.graphics.getWidth()/1810f,Gdx.graphics.getHeight()/1080f);
        testButton = autoPad(testButton,3);
        testButton2 = autoPad(testButton2, 3);


        buttonGroup.add(testButton,testButton2);
        verticalGroup.fill();

        verticalGroup.padBottom(stage.getHeight()-esc.getHeight());
        verticalGroup.addActor(testButton);
        verticalGroup.addActor(testButton2);

        label = new Label("this is the label does it span over multiple lines?"+stage.getHeight()+"Width:"
                +stage.getWidth()+
                "getWidth"
                +Gdx.graphics.getWidth(),skin);
        label.setFontScale(Gdx.graphics.getWidth()/1810f,Gdx.graphics.getHeight()/1080f);
        label.setWrap(true);

        newsContent = new Container(label).align(Align.topLeft);
        newsContent.fillX();
        newsContent.setColor(0.3f,0.4f,0.3f,1f);

        header = new Table(skin);

        header.align(Align.topLeft);
        table.add(esc).align(Align.left).width(esc.getPrefWidth());
        Label news = new Label("NEWS",skin);
        news.setFontScale(Gdx.graphics.getWidth()*4/1810f,Gdx.graphics.getHeight()*4/1080f);
        //news.setFontScale(4);
        news.setColor(0.6f,0.5f,0.6f,1f);
        header.add(news).align(Align.center);
        Label headlines = new Label("Headlines",skin);
        headlines.setFontScale(Gdx.graphics.getWidth()*2/1810f,Gdx.graphics.getHeight()*2/1080f);
        //headlines.setFontScale(2f);
        headlines.setColor(0.6f,0.5f,0.6f,1f);
        table.add(header).align(Align.center);
        table.add(headlines).align(Align.center);
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
        float value = (Gdx.graphics.getWidth()/(2*pad))-button.getMinWidth()/2;
        button.padRight(value);
        button.padLeft(value);
        button.padBottom(Gdx.graphics.getHeight()/(2*pad));
        button.padTop(Gdx.graphics.getHeight()/(2*pad));
        StringBuilder sb = new StringBuilder(button.getText());
        int i = 0;
        while ((i = sb.indexOf(" ", i + 15)) != -1) {
            sb.replace(i, i + 1, "\n");
        }
        button.setText(sb.toString());
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