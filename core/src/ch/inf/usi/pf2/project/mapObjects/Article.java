package ch.inf.usi.pf2.project.mapObjects;


import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;


/**
 * Created by simonreding on 23/05/16.
 */

public class Article {
    private String title;
    private String content;
    private TxtButton textButton;
    private Skin skin;


    public Article(String title,String content,int n){
        this.title = title;
        this.content = content;
        textButton = new TxtButton(title,skin,n);
    }

    public String getContent() {
        return content;
    }
    public TxtButton getTextButton(){return textButton;}

    public String getTitle() {
        return title;
    }
}
