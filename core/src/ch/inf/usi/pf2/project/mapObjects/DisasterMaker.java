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
<<<<<<< HEAD
            Disaster disaster = new Disaster(rn.nextInt(),rn.nextInt());
=======
            Disaster disaster = new Disaster(new Place(rn.nextInt(),rn.nextInt(),"random"));//TODO: implement proper name
>>>>>>> 0719cd61572beb7ef9546d20539be077b4f545e2
            disasters.add(disaster);
            numberOfDisasters--;
        }
        return disasters;
    }
}
