package ch.inf.usi.pf2.project;

import android.content.Context;
import android.os.Bundle;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Json;

import java.io.File;
import java.io.FileOutputStream;

public class AndroidLauncher extends AndroidApplication {
	@Override
	protected void onCreate (Bundle savedInstanceState) {


		super.onCreate(savedInstanceState);
		System.out.println("############################");
		File file = new File(getFilesDir(), "db.json");
		//file.createNewFile();
		try {
			FileOutputStream outputStream = openFileOutput("db.json", Context.MODE_PRIVATE);
			outputStream.write("asdf".getBytes());
		}catch (Exception e){
			e.printStackTrace();
		}



		System.out.println(getFilesDir());
		AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
		initialize(new BoatManager2k16(), config);
	}
}
