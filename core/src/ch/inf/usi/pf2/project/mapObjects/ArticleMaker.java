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


    public static String firstArticleText(int gravity){
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


    public static String seaDisaster(){
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
    public static String landDisaster(){
        Random rn = new Random();
        ArrayList<String> disasterList = new ArrayList<String>();
        disasterList.add("Earthquake");
        disasterList.add("Coup d'etat");
        disasterList.add("Typhoon");
        disasterList.add("Hurricane");
        disasterList.add("Storm");
        disasterList.add("War");
        disasterList.add("Corrupt Government");
        return disasterList.get(rn.nextInt(disasterList.size()));
    }

    public static ArrayList<Oceans> getOceans(){
        ArrayList<Oceans> oceanses = new ArrayList<Oceans>(); //Sorry for the plural of the plural
        oceanses.add(new Oceans(12,12,12,"North Atlantic Ocean"));
        oceanses.add(new Oceans(12,12,12,"South Atlantic Ocean"));
        oceanses.add(new Oceans(12,12,12,"North Pacific Ocean"));
        oceanses.add(new Oceans(12,12,12,"South Pacific Ocean"));
        oceanses.add(new Oceans(12,12,12,"Southern Ocean"));
        oceanses.add(new Oceans(12,12,12,"Arctic Ocean"));
        oceanses.add(new Oceans(12,12,12,"Indian Ocean"));
        return oceanses;
    }
}
