package ch.inf.usi.pf2.project;

import com.badlogic.gdx.ApplicationAdapter;
//import com.badlogic.gdx.Gdx;
//import com.badlogic.gdx.graphics.GL20;
//import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import ch.inf.usi.pf2.project.GameObjecets.*;

public class boatManager2k16 extends ApplicationAdapter {
	SpriteBatch batch;

	GameObject currentState;

	
	@Override
	public void create () {
		batch = new SpriteBatch();
		currentState = new Menu(batch);

	}

	@Override
	public void render () {

		currentState.renderObject();

	}
}
