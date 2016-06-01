package ch.inf.usi.pf2.project.gameStates;

/**
 * Created by alexandercamenzind on 27/04/16.
 */
public abstract class GameState {

    public void renderGameObject(){
    }

    public void update(float dt){
    }

    public void inputHandler(){
    }

    public abstract int nextState();
    public void removeStage(){
    }

}
