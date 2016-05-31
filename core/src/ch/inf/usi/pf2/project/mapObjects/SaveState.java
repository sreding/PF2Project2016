package ch.inf.usi.pf2.project.mapObjects;

import java.util.ArrayList;

/**
 * Created by alexandercamenzind on 31/05/16.
 */
public class SaveState {
    public ArrayList<BoatSaver> bs;
    public int playerMoney;

    public SaveState(){

    }

    public SaveState(int money){
        bs = new ArrayList<BoatSaver>();
        playerMoney=money;
    }
    public void add(BoatSaver b){
        bs.add(b);
    }
}
