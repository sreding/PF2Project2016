package ch.inf.usi.pf2.project.mapObjects;

import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;

import java.util.ArrayList;
import java.util.Random;

import ch.inf.usi.pf2.project.mapObjects.Article;
/**
 * Created by simonreding on 29/05/16.
 */
public class ArticleMaker {
    private ArrayList<String> regions;
    private ArrayList<String> countries;
    private ArrayList<Disaster> disasters;

    public ArticleMaker(ArrayList<String> regions, ArrayList<Disaster> disasters){
        this.countries = News.portNames();
        this.disasters = disasters;
        this.regions = regions;
    }

    public String seaDisaster(){
        Random rn = new Random();
        ArrayList<String> disasterList = new ArrayList<String>();
        disasterList.add("Tsunami");
        disasterList.add("Pirates");
        disasterList.add("Typhoon");
        disasterList.add("Hurricane");
        disasterList.add("Storm");
        disasterList.add("Naval Military Exercises");
        disasterList.add("War");
        return disasterList.get(rn.nextInt(disasterList.size()));
    }
    public String landDisaster(){
        Random rn = new Random();
        ArrayList<String> disasterList = new ArrayList<String>();
        disasterList.add("Earthquake");
        disasterList.add("Coup d'état");
        disasterList.add("Typhoon");
        disasterList.add("Hurricane");
        disasterList.add("Storm");
        disasterList.add("War");
        disasterList.add("Corrupt Government");
        return disasterList.get(rn.nextInt(disasterList.size()));
    }
}
