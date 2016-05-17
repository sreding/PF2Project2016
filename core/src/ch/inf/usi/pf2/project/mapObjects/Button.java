package ch.inf.usi.pf2.project.mapObjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by alexandercamenzind on 10/05/16.
 */
public class Button {

    private float x;
    private float y;
    private int width;
    private int height;
    private Sprite buttonImg;

    // scale in percentage of screen width
    // x position in percentage of screen width
    // y position in percentage of screen height
    // buttonImg is just the button image
    public Button(int x, int y, float scale, Sprite buttonImg){
        this.buttonImg=buttonImg;

        float ratio = buttonImg.getWidth() / buttonImg.getHeight();
        buttonImg.setSize(Gdx.graphics.getWidth()/100 * scale,Gdx.graphics.getWidth()/100 * scale / ratio );

        this.x = (Gdx.graphics.getWidth() - buttonImg.getWidth())/100 * x;
        this.y = (Gdx.graphics.getHeight() - buttonImg.getHeight())/100 *y;
        buttonImg.setPosition(this.x,this.y);
        this.width = (int) buttonImg.getWidth();
        this.height= (int) buttonImg.getHeight();



    }

    // just draws the button
    public void drawButton(SpriteBatch batch){
       buttonImg.draw(batch);
    }

    // returns true if button is touched
    public boolean isTouched(){
        return Gdx.input.justTouched() && x < Gdx.input.getX() && Gdx.input.getX() < x+width
                &&  y < -Gdx.input.getY() + Gdx.graphics.getHeight() && -Gdx.input.getY() + Gdx.graphics.getHeight() < y + height ;
    }


}
