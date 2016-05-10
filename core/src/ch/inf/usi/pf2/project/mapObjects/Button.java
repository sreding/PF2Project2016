package ch.inf.usi.pf2.project.mapObjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by alexandercamenzind on 10/05/16.
 */
public class Button {

    private int x;
    private int y;
    private int width;
    private int height;
    private Sprite buttonImg;

    //scale in percentage of world width
    public Button(int x, int y, float scale, Sprite buttonImg){
        this.x = x;
        this.y = y;

        this.buttonImg=buttonImg;

        buttonImg.setPosition(x,y);


        float ratio = buttonImg.getWidth() / buttonImg.getHeight();
        buttonImg.setSize(Gdx.graphics.getWidth()/100 * scale,Gdx.graphics.getWidth()/100 * scale / ratio );
        this.width = (int) buttonImg.getWidth();
        this.height= (int) buttonImg.getHeight();

    }

    public void drawButton(SpriteBatch batch){
       buttonImg.draw(batch);
    }

    public boolean isTouched(){
        return Gdx.input.justTouched() && x < Gdx.input.getX() && Gdx.input.getX() < x+width
                &&  y < -Gdx.input.getY() + Gdx.graphics.getHeight() && -Gdx.input.getY() + Gdx.graphics.getHeight() < y + height ;
    }


}
