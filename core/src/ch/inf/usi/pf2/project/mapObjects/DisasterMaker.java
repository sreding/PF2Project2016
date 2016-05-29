package ch.inf.usi.pf2.project.mapObjects;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by simonreding on 29/05/16.
 */
public class DisasterMaker {

    public static ArrayList<Disaster> randomDisasters(){
        Random rn = new Random();
        int numberOfDisasters = rn.nextInt(19);
        ArrayList disasters = new ArrayList();
        while(numberOfDisasters > -1){
            Disaster disaster = new Disaster(rn.nextInt(),rn.nextInt());
            disasters.add(disaster);
        }
        return disasters;
    }
}
