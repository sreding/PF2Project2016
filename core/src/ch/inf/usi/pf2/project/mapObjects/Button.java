package ch.inf.usi.pf2.project.mapObjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Matrix4;

/**
 * Created by alexandercamenzind on 10/05/16.
 */
public class Button {

    private float x;
    private float y;
    private int width;
    private int height;
    private Sprite buttonImg;
    private Sprite buttonImg2;
    private int whatTodDisplay;

    // scale in percentage of screen width
    // x position in percentage of screen width
    // y position in percentage of screen height
    // buttonImg is just the button image
    public Button(int x, int y, float scale, Sprite buttonImg, Sprite buttonImg2){
        this.buttonImg=buttonImg;
        this.buttonImg2=buttonImg2;

        float ratio = buttonImg.getWidth() / buttonImg.getHeight();
        buttonImg.setSize(Gdx.graphics.getWidth()/100 * scale,Gdx.graphics.getWidth()/100 * scale / ratio );

        this.x = (Gdx.graphics.getWidth() - buttonImg.getWidth())/100 * x;
        this.y = (Gdx.graphics.getHeight() - buttonImg.getHeight())/100 *y;
        buttonImg.setPosition(this.x,this.y);
        this.width = (int) buttonImg.getWidth();
        this.height= (int) buttonImg.getHeight();

        buttonImg2.setSize(Gdx.graphics.getWidth()/100 * scale,Gdx.graphics.getWidth()/100 * scale / ratio );
        buttonImg2.setPosition(this.x,this.y);




    }

    // just draws the button
    public void drawButton(SpriteBatch batch){
        if(whatTodDisplay==0){
            buttonImg.draw(batch);
        }
        else{
            buttonImg2.draw(batch);
        }

    }

    // returns true if button is touched
    public boolean isTouched(){
        boolean res= Gdx.input.justTouched() && x < Gdx.input.getX() && Gdx.input.getX() < x+width
                &&  y < -Gdx.input.getY() + Gdx.graphics.getHeight() && -Gdx.input.getY() + Gdx.graphics.getHeight() < y + height ;
        if(res){
            whatTodDisplay += 1;
            whatTodDisplay %= 2;
        }
        return res;
    }


}
