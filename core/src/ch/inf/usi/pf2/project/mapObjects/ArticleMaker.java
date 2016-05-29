package ch.inf.usi.pf2.project.mapObjects;

import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.sun.org.apache.bcel.internal.generic.NEW;

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
    //TODO: make articles and send them to player once disasters happen
    public static Article makeArticle(Disaster disaster){
        String dis = "";
        if(disaster.isType()){dis = seaDisaster();}else{dis = landDisaster();}

        String region = getRegion(disaster.getX(),disaster.getY());

        String title = dis + firstArticleText(disaster.getGravity()) + region;

        return new Article(title,title,0);
    }

    private static String firstArticleText(int gravity){
        ArrayList<String> textList = new ArrayList<String>();
        textList.add(" that wreaked havoc in ");
        textList.add(" caused problems in ");
        textList.add(" destroyed lives ");
        textList.add(" destabilized ");
        textList.add(" haunt ");
        textList.add(" caused serious damage to property in ");
        textList.add(" sank ships in ");
        textList.add(" caused fires in ");
        textList.add(" encouraged looters in ");
        textList.add(" created chaos in ");
        return textList.get(gravity);
    }


//    TODO: get the real region
    private static String getRegion(int x, int y){
        return News.portNames().get(1);
    }

    private static String seaDisaster(){
        Random rn = new Random();
        ArrayList<String> disasterList = new ArrayList<String>();
        disasterList.add("Tsunami");
        disasterList.add("Pirates");
        disasterList.add("Typhoon");
        disasterList.add("Hurricane");
        disasterList.add("Storm");
        disasterList.add("Escalating military tensions");
        disasterList.add("War");
        return disasterList.get(rn.nextInt(disasterList.size()));
    }
    private static String landDisaster(){
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
