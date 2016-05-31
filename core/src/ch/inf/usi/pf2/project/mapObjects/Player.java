package ch.inf.usi.pf2.project.mapObjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g3d.particles.ParticleEffectLoader;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.MapProperties;
import com.badlogic.gdx.maps.objects.EllipseMapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Ellipse;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Json;

import ch.inf. usi.pf2.project.mapObjects.Button;
import ch.inf.usi.pf2.project.mapObjects.Path;
import ch.inf.usi.pf2.project.mapObjects.Ports;
import ch.inf.usi.pf2.project.mapObjects.Port;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by ilijagjorgjiev on 5/19/16.
 */
public class Player {

    public int money;
    private ArrayList<Boat> boats;
    private ArrayList<Boat> possibleBoats;
    private ArrayList<Article> articles;
    private ArrayList<Disaster> disasters;
    private Ports ports;
    public int MAP_WIDTH;
    //




    public Player()
    {
        this.money=10000000;
        this.boats = new ArrayList<Boat>();
        this.articles = new ArrayList<Article>();
        this.disasters = new ArrayList<Disaster>();
        possibleBoats = new ArrayList<Boat>();

        TiledMap tiledMap = new TmxMapLoader().load("tileWorldMap.tmx");
        MapProperties prop = tiledMap.getProperties();
        MAP_WIDTH = prop.get("width", Integer.class) * prop.get("tilewidth", Integer.class);
        ports=new Ports(tiledMap.getLayers().get("SquarePorts").getObjects(),MAP_WIDTH);

    }

    public void addBoat(Boat b){
        boats.add(b);
    }
    public int numberOfBoatsOwned(){
        int i = boats.size();
        return i;
    }

    public void handlePlayerInput(boolean touchUp){

    }
    public void addArticles(ArrayList<Article> newA){
        articles.addAll(newA);
    }

    public void addDisasters(ArrayList<Disaster> dis){
        disasters.addAll(dis);
    }

    public ArrayList<Article> getArticles() {
        return articles;
    }

    public ArrayList<Boat> getBoats() {
        return boats;
    }


    public void setBoats(ArrayList<Boat> boats) {
        this.boats = boats;
    }
    public Ports getPorts() {
        return ports;
    }
    public void addPossibleBoats(SpriteBatch batch ,OrthographicCamera cam,ShapeRenderer shapeRenderer,int MAP_WIDTH,MapObjects polygonMapObjects){

        possibleBoats.add(new Boat(10450,1200,50.2,10000,1110, new Sprite(new Texture("topBoat1.png")),
                new Sprite(new Texture("sideBoat1.png")),batch,cam,shapeRenderer, MAP_WIDTH, polygonMapObjects,"apollo",1));

        possibleBoats.add(new Boat(18000,1600,55.2,19000,110, new Sprite(new Texture("topBoat2.png")),
                new Sprite(new Texture("sideBoat2.png")),batch,cam,shapeRenderer, MAP_WIDTH, polygonMapObjects,"echo",2));

        possibleBoats.add(new Boat(23000,2000,60.2,19000,110, new Sprite(new Texture("topBoat3.png")),
                new Sprite(new Texture("sideBoat3.png")),batch,cam,shapeRenderer, MAP_WIDTH, polygonMapObjects,"frejus",3));

        possibleBoats.add(new Boat(25000,2200,65.2,19000,110, new Sprite(new Texture("topBoat3.png")),
                new Sprite(new Texture("sideBoat4.png")),batch,cam,shapeRenderer, MAP_WIDTH, polygonMapObjects,"helena",4));

        possibleBoats.add(new Boat(30000,3000,61.2,19000,110, new Sprite(new Texture("topBoat5.png")),
                new Sprite(new Texture("sideBoat5.png")),batch,cam,shapeRenderer, MAP_WIDTH, polygonMapObjects,"jester",5));

        possibleBoats.add(new Boat(40100,3500,57.2,19000,110, new Sprite(new Texture("topBoat6.png")),
                new Sprite(new Texture("sideBoat6.png")),batch,cam,shapeRenderer, MAP_WIDTH, polygonMapObjects,"luna",6));

        possibleBoats.add(new Boat(70000,7000,60.2,19000,110, new Sprite(new Texture("topBoat7.png")),
                new Sprite(new Texture("sideBoat7.png")),batch,cam,shapeRenderer, MAP_WIDTH, polygonMapObjects,"aria",7));

        possibleBoats.add(new Boat(100000,12000,55.3,19000,110, new Sprite(new Texture("topBoat8.png")),
                new Sprite(new Texture("sideBoat8.png")),batch,cam,shapeRenderer, MAP_WIDTH, polygonMapObjects,"nicas",8));

        possibleBoats.add(new Boat(150000,25000,60.2,19000,110, new Sprite(new Texture("topBoat9.png")),
                new Sprite(new Texture("sideBoat9.png")),batch,cam,shapeRenderer, MAP_WIDTH, polygonMapObjects,"titanic",9));


    }

    public ArrayList<Boat> getPossibleBoats(){ return possibleBoats; }




    public void updateDamage(){
        for(Disaster dis : disasters){
            for(Boat boat : boats){
                int dist = dis.getGravity() * 10;
                if(boat.isTraveling()){System.out.println(dist);}
                if(dis.getX() - dist < (int)boat.getX()&&
                        dis.getX() + dist > (int)boat.getX()&&
                        dis.getY() - dist < (int)boat.getY() &&
                        dis.getY() + dist > (int)boat.getY() && boat.isTraveling()){
                    Random rn = new Random();
                    System.out.println("dist"+dist);
                    if(boat.getVulnerability() > 0){
                        boat.setVulnerability(rn.nextInt((int)boat.getVulnerability()+5));
                        System.out.println("Vul: " +boat.getVulnerability());

                    }
                }
            }
        }
    }



    //removes disasters
    public void removeDisasters(){
        Random rn = new Random();
        while (disasters.size() > 5){
            disasters.remove(disasters.size()-1);
        }
        //System.out.println(disasters.size());
    }
    //removes articles
    public void removeArticle(){
        Random rn = new Random();
        while (articles.size() > 20){
            articles.remove(articles.size()-1);
        }
        //System.out.println(articles.size());
    }

    public void updateMoney(){
        for(Boat b: boats){
            money+=b.updateMoney();
        }
    }


    public void buildPlayerFromDb(String s){
        //System.out.println(s);
        Json json =  new Json();
        SaveState saveState = json.fromJson(SaveState.class,s);

        money=saveState.playerMoney;

        for(BoatSaver b:saveState.bs){

            boats.add(possibleBoats.get(b.boatVal).copyBoat(0,b.boatVal));

        }


        //Boat b = json.fromJson(Boat.class,s);
        //ArrayList<Boat> b = json.fromJson(ArrayList<Boat.class>,)
        //boats.add(b);
    }

    public String buildDatabaseFromPlayer() {
        SaveState saveState = new SaveState(money);
        for (Boat b : boats) {
            saveState.add(new BoatSaver(b));
        }

        Json json = new Json();
        String s = json.toJson(saveState);
        return s;
    }


    public void rmBoat(){
        for (Boat boat:boats){
            int i = 0;
            if (boat.getVulnerability() <=0){
                boats.remove(i);
                i++;
                System.out.println("removed Boat");
            }
        }

    }


}
