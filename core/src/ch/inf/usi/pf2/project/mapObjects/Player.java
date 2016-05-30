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
        this.money=100000;
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
    public void newDisasters(){
        disasters.addAll(DisasterMaker.randomDisasters());
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
        possibleBoats.add(new Boat(10450,1200,50.2,100000,0, new Sprite(new Texture("topBoat1.png")),
                new Sprite(new Texture("sideBoat1.png")),batch,cam,shapeRenderer, MAP_WIDTH, polygonMapObjects,"Fascinosa"));
        possibleBoats.add(new Boat(18000,1600,55.2,190000,0, new Sprite(new Texture("topBoat2.png")),
                new Sprite(new Texture("sideBoat2.png")),batch,cam,shapeRenderer, MAP_WIDTH, polygonMapObjects,"Divina"));


    }

    public ArrayList<Boat> getPossibleBoats(){ return possibleBoats; }


    //checks if a boat overlaps with a disaster area, reduces vulnerability if true
    public void updateDamage(){
        for(Disaster dis : disasters){
            for(Boat boat : boats){

                if(dis.getX()-dis.getGravity() < (int)boat.getY()&&
                       dis.getX()+dis.getGravity() > (int)boat.getX()&&
                        dis.getY() - dis.getGravity() < (int)boat.getY() &&
                        dis.getY() + dis.getGravity() > (int)boat.getY()){
                    Random rn = new Random();
                    System.out.println("got the sucker");
                    if(rn.nextBoolean()){
                        boat.setVulnerability(rn.nextInt((int)boat.getVulnerability()+5));
                    }
                }
            }
        }
    }


}
