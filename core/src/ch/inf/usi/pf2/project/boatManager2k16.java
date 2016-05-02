package ch.inf.usi.pf2.project;

import com.badlogic.gdx.ApplicationAdapter;
//import com.badlogic.gdx.Gdx;
//import com.badlogic.gdx.graphics.GL20;
//import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.Stack;
import ch.inf.usi.pf2.project.GameObjecets.*;

public class boatManager2k16 extends ApplicationAdapter {
	SpriteBatch batch;
	GameObject currentState;
	private Stack<GameObject> stateStack;

	
	@Override
	public void create () {
		batch = new SpriteBatch();
		currentState = new Map(batch);

	}

	@Override
	public void render () {

		currentState.inputHandler();
		currentState.update(Gdx.graphics.getDeltaTime());
		currentState.renderGameObject();

	}
}
