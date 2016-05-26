package ch.inf.usi.pf2.project.mapObjects;


import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

/**
 * Created by simonreding on 25/05/16.
 */
public class TxtButton extends TextButton{
    int i;
    public TxtButton(String text, Skin skin,int i){
        super(text,skin);
        this.i = i;
    }
    public void setIndex(int i){
        this.i = i;
    }
    public int getIndex(){return i;}

}
