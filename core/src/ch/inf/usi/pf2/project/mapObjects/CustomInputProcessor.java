package ch.inf.usi.pf2.project.mapObjects;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.OrthographicCamera;
/**
 * Created by alexandercamenzind on 30/05/16.
 */
public class CustomInputProcessor implements InputProcessor {
    Player player;
    OrthographicCamera cam;

    public CustomInputProcessor(Player player, OrthographicCamera cam){
        this.player = player;
        this.cam = cam;


    }
    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        boolean res;
        res = player.getPorts().handlePortInputBoolean(cam);
        return res;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
