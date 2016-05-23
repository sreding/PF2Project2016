package ch.inf.usi.pf2.project.mapObjects;
import

import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 * Created by simonreding on 23/05/16.
 */

public class Article {
    private String title;
    private String content;

    public Article(String title,String content){
        this.title = title;
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public String getTitle() {
        return title;
    }
}
