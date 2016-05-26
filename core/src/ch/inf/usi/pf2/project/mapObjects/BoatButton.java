package ch.inf.usi.pf2.project.mapObjects;

import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

/**
 * Created by alexandercamenzind on 27/05/16.
 */
public class BoatButton extends TextButton {
    private Boat b;
    public BoatButton(String text, Skin skin, Boat b){
        super(text,skin);
        this.b = b;

    }

    public Boat getB() {
        return b;
    }
}
