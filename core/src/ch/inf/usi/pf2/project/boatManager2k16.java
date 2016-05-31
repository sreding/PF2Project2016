package ch.inf.usi.pf2.project;

import com.badlogic.gdx.ApplicationAdapter;
//import com.badlogic.gdx.Gdx;
//import com.badlogic.gdx.graphics.GL20;
//import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Json;

import java.util.ArrayList;

import ch.inf.usi.pf2.project.gameStates.*;
import ch.inf.usi.pf2.project.mapObjects.News;
import ch.inf.usi.pf2.project.mapObjects.Player;

//this is our main class

public class BoatManager2k16 extends ApplicationAdapter {
	SpriteBatch batch;
	GameState currentState;
	ArrayList<GameState> gameStates;
	int i;
	NativeFunctions nf;
	Player player;

	public BoatManager2k16(NativeFunctions nf){
		this.nf=nf;
	}


	//the create method will be called only once, when the aplication is started
	@Override
	public void create () {
		i=0;
		// Sprite batch allows us to draw sprites (pictures) on the screen
		batch = new SpriteBatch();

		// We split the different parts of our game in GameState and GameState has 3 extensions at the moment
		// Map, Menu, MiniGame
		// we start off with the Map at the moment -> we store a Map instance in currentState

		Player player= new Player();
		this.player=player;
		String s = nf.getDataFromDB();



		gameStates = new ArrayList<GameState>();
		gameStates.add(new Map(batch,player));
		player.buildPlayerFromDb(s);
		gameStates.add(new News(batch,player));
		gameStates.add(new Manager(batch,player));

		currentState = gameStates.get(0);

		/*
		Json json = new Json();
		System.out.println(json.toJson(numbers));
		System.out.println( Gdx.files.isLocalStorageAvailable());
		FileHandle file = Gdx.files.internal("db.json");
		String text = file.readString();
		System.out.println(text+"aaa");
		//file.writeString("abc",false);
		*/

	}

	public  void changeState(){
		int n = currentState.nextState();
		currentState = gameStates.get(n);
	}


	// the render method will be called every frame
	@Override
	public void render () {

		//every gameState subclass has these 3 methods.

		//everything that has to due with processing input should be put in the inputHandler methods
		currentState.inputHandler();

		// Gdx.graphics.getDeltaTime() returns the time it took for the last render, we need this to get
		// update positions etc. without depending on how many frames per second we get
		// -> basically we should always multiply any changes we do every frame by the render time
		currentState.update(Gdx.graphics.getDeltaTime());

		changeState();

		// in the renderGameObject method we should everything, that has to do with actually displaying
		// objects, that need to be displayed, like the background or sprites
		currentState.renderGameObject();

		i++;
		if(i > 10000 && gameStates.get(1) instanceof News){
			int number;
			((News) gameStates.get(1)).randomDisasters();
			((News) gameStates.get(1)).rmDisasters();

			System.out.println("new news");

			i = 0;
		}

	}

	@Override
	public void dispose () {
		nf.storeStringInDb(player.buildDatabaseFromPlayer());
		super.dispose();

	}
}
