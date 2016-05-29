package ch.inf.usi.pf2.project.mapObjects;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import java.util.ArrayList;
import java.util.Random;

import ch.inf.usi.pf2.project.gameStates.GameState;


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
    private Sprite backgroundImage;
    private Sprite titleImage;
    private Sprite sideTexture;
    private Sprite rightSideTex;
    private ArrayList<TxtButton> txtButtons;
    private Player player;

    private int count;
    private int index;




    public News(SpriteBatch batch,Player player) {
        //initializing basic fields
        spriteBatch = new SpriteBatch();
        this.player =player;
        backgroundImage = new Sprite(new Texture(Gdx.files.internal("backgroundTexture.png"))
                ,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());

        this.articles = new ArrayList<Article>();
        txtButtons = new ArrayList<TxtButton>();
        stage = new Stage(new ScreenViewport(),batch);
        skin = new Skin(Gdx.files.internal("uiskin.json"));
        numberOfArticles = 0;


        //set up of the big table that will eventually contain all scene2d objects
        table = new Table();
        table.setWidth(stage.getWidth());
        table.align(Align.left | Align.top);
        table.setPosition(0,Gdx.graphics.getHeight());

        //setting up the verticalGroup and scrollPane for the news headlines on the right
        verticalGroup = new VerticalGroup();
        verticalGroup.fill();
        scrollPane = new ScrollPane(verticalGroup);
        esc = autoPad(new TxtButton("Back",skin,-3),8);
        esc.getLabel().setFontScale(Gdx.graphics.getWidth()/1810f,Gdx.graphics.getHeight()/1080f);
        scrollPane.setHeight(stage.getHeight()-esc.getHeight());

        //TODO:add existing articles from player
        //Adding example articles
        addArticles(randomArticles());


        //set the initial text with some user guidance and put it in a new container to be added later
        label = new Label("Select a news headline on the right to get more details",skin);
        label.setFontScale(Gdx.graphics.getWidth()/1810f,Gdx.graphics.getHeight()/1080f);
        label.setWrap(true);

        newsContent = new Container(label).align(Align.topLeft);
        newsContent.padTop(Gdx.graphics.getHeight()/40);
        newsContent.padRight(Gdx.graphics.getHeight()/40);
        newsContent.fillX();




        //add the first button in the top left of the table
        table.add(esc).align(Align.topLeft).width(esc.getPrefWidth());


        //set the titles
        header = new Table(skin);
        header.align(Align.topLeft);
        Label news = new Label("NEWS",skin);
        news.setFontScale(Gdx.graphics.getWidth()*2/1810f,Gdx.graphics.getHeight()*2/1080f);
        header.add(news).align(Align.center);

        Label headlines = new Label("Headlines",skin);
        headlines.setFontScale(Gdx.graphics.getWidth()*1.5f/1810f,Gdx.graphics.getHeight()*1.5f/1080f);


        //add everything to the table
        table.add(header).align(Align.center);
        table.add(headlines).align(Align.center);
        table.row();
        table.add(new Table(skin));
        table.add(newsContent).width((stage.getWidth())-verticalGroup.getPrefWidth()-(esc.getPrefWidth()))
                .height((Gdx.graphics.getHeight()-esc.getPrefHeight()));
        table.add(scrollPane).width(verticalGroup.getPrefWidth());

        //set the pictures in the background
        titleImage = new Sprite(new Texture(Gdx.files.internal("titleTexture.png")),Gdx.graphics.getWidth(),(int)esc.getPrefHeight());
        titleImage.setPosition(0,Gdx.graphics.getHeight()-esc.getPrefHeight());
        sideTexture = new Sprite(new Texture(Gdx.files.internal("sideTexture.png")),
                (int)esc.getPrefWidth(),Gdx.graphics.getHeight());
        sideTexture.setColor(0.1f,0.1f,0.1f,0.05f);
        rightSideTex = new Sprite(new Texture(Gdx.files.internal("sideTexture.png")),
                (int)verticalGroup.getPrefWidth(),(int)Gdx.graphics.getHeight()-(int)esc.getPrefHeight());
        rightSideTex.setPosition(Gdx.graphics.getWidth()-verticalGroup.getPrefWidth(),0);



        //finally add the whole table to the stage
        stage.addActor(table);
        //setting the input Processor so stage can recieve input
        Gdx.input.setInputProcessor(stage);

        //setting count and index to zero, they are used later to check if actions should be executed
        count = 0;

        randomDisasters();
    }


    @Override
    public void renderGameObject(){
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        Gdx.input.setInputProcessor(stage);
        if(!scrollPane.isPanning()){
            for(TxtButton button:txtButtons){
                if(button.isPressed()) {
                    count++;
                }

                if (button.isPressed() == true && count > 5){

                    label.setText(
                            articles.get(button.getIndex()).getTitle() +":\n\n"+
                            articles.get(button.getIndex()).getContent());
                    label.layout();
                }
            }}else{
            count = 0;
        }

        //table.debug();


        stage.act(Gdx.graphics.getDeltaTime());
        spriteBatch.begin();
        backgroundImage.draw(spriteBatch);
        sideTexture.draw(spriteBatch);
        rightSideTex.draw(spriteBatch);
        titleImage.draw(spriteBatch);
        spriteBatch.end();
        stage.draw();

    }
    public int nextState(){
        if(esc.isPressed() && Gdx.input.justTouched()){
            esc.toggle();

            //System.out.println("return0");
            return 0;
        }
        return 1;
    }



    private void setLabel(int n){
        this.label.setText(articles.get(n).getContent());
    }

    private void addArticles(ArrayList<Article> newA){
        for(Article a:newA){
            TxtButton button = a.getTextButton();
            button.setIndex(numberOfArticles);
            button.getLabel().setFontScale(Gdx.graphics.getWidth()/1810f,Gdx.graphics.getHeight()/1080f);
            button = autoPad(button, 3);
            txtButtons.add(button);
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
        while ((i = sb.indexOf(" ", i + 12)) != -1) {
            sb.replace(i, i + 1, "\n");
        }
        button.setText(sb.toString());
        return button;
    }
    //creates an arrayList of new Buttons
    private ArrayList<TextButton> newButtons(ArrayList<Article> articles){
        return makeNewButtons(articles,new ArrayList<TextButton>(),0);
    }

    private ArrayList<TextButton> makeNewButtons(ArrayList<Article> articles,
                                                 ArrayList<TextButton> buttons,
                                                 int n){
        if(n == articles.size()){
            return buttons;
        }else {
            //Skin buttonSkin = new Skin(Gdx.files.internal("uiskin.json")); //// ENTER PARAMETERS FOR SKIN!!!!!
            TextButton newButton = new TextButton(articles.get(n).getTitle(),skin);
            buttons.add(newButton);

            return makeNewButtons(articles,buttons,n++);
        }


    }
    public static ArrayList<String> portNames(){
        ArrayList<String> portList = new ArrayList<String>();
        TiledMap tm = new TmxMapLoader().load("tileWorldMap.tmx");
        MapObjects mo = tm.getLayers().get("SquarePorts").getObjects();
        for(MapObject o: mo){
            portList.add(o.getName());
        }
        return portList;
    }
    private static ArrayList<Article> randomArticles(){
        ArrayList<String> countries = new ArrayList<String>();
        countries.add("Namibia");
        countries.add("Singapore");
        //countries.add("Lisbon");
        countries.add("the Ocean");
        countries.add("Madagascar");
        //countries.add("Los Angeles");
        countries.addAll(portNames());

        ArrayList<String> disaster = new ArrayList<String>();
        disaster.add("earthquake");
        disaster.add("tsunami");
        disaster.add("pirates");
        disaster.add("Something Dangerous");



        return makeArticles(countries,disaster,new ArrayList<Article>(),0,0);
    }
    //simple function that generates a list of articles given lists of
    // strings containing names of regions and disasters
    private static ArrayList<Article> makeArticles(ArrayList<String> regions,
                                                   ArrayList<String> events,
                                                   ArrayList<Article> finishedArticles, int n,
                                                   int numberOfArticles) {
        if(events.size() == n){
            return finishedArticles;
        }else{
            Random rn = new Random();
            String country = regions.get(rn.nextInt(regions.size()));
            String title = events.get(n)+ " in " +country;
            String text = "The " + events.get(n) + " that destroyed " + country +" appears to " +
                    " have devastating consequences to the region";
            finishedArticles.add(new Article(title,text,numberOfArticles));
            n++;
            numberOfArticles++;
            return makeArticles(regions,events,finishedArticles,n,numberOfArticles);
        }

    }
    public Place randomPlace(){
        Random rn =  new Random();
        if(rn.nextBoolean()){
            ArrayList<Oceans> oce = ArticleMaker.getOceans();
            return oce.get(rn.nextInt(oce.size()));
        }else{
            Ports prt = player.getPorts();
            return prt.getPorts().get(rn.nextInt(prt.getPorts().size()));
        }
    }
    public void randomDisasters(){
        Random rn = new Random();
        int numberOfDisasters = rn.nextInt(19);
        ArrayList disasters = new ArrayList();

        while(numberOfDisasters > -1){
            Place place = randomPlace();
            boolean bool = (place instanceof Oceans);
            String event;
            if(bool){event=ArticleMaker.seaDisaster();}else{event=ArticleMaker.seaDisaster();};
            Disaster disaster = new Disaster(place.getX(),place.getY(),bool,rn.nextInt(10),event,place.getName());
            disasters.add(disaster);
            numberOfDisasters--;
        }
        addArticles(makeArticles(disasters));
        player.addDisasters(disasters);
    }

    public static ArrayList<Article> makeArticles(ArrayList<Disaster> dis){
        ArrayList<Article> articles = new ArrayList<Article>();
        for(Disaster disaster: dis){
            articles.add(makeArticle(disaster));
        }
        return articles;
    }

    public static Article makeArticle(Disaster disaster){
        String dis = "";
        if(disaster.isType()){dis = ArticleMaker.seaDisaster();}else{dis = ArticleMaker.landDisaster();}

        String region = disaster.getLocationName();

        String title = dis + ArticleMaker.firstArticleText(disaster.getGravity()) + region;

        return new Article(title,title,0);
    }




}