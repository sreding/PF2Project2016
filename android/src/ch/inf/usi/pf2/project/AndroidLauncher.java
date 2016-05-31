package ch.inf.usi.pf2.project;

import android.content.Context;
import android.os.Bundle;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Json;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStreamReader;

public class AndroidLauncher extends AndroidApplication implements NativeFunctions {
	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
		initialize(new BoatManager2k16(this), config);
	}

	@Override
	public void storeStringInDb(String s) {
		File file = new File(getFilesDir(), "db.json");
		if(!file.exists()){
			try {
				file.createNewFile();
			}catch (Exception e){
				e.printStackTrace();
			}
		}

		try {
			FileOutputStream outputStream = openFileOutput("db.json", Context.MODE_PRIVATE);
			outputStream.write("asdfg".getBytes());
			outputStream.close();
		}catch (Exception e){
			e.printStackTrace();
		}

	}

	@Override
	public String getDataFromDB() {
		File file = new File(getFilesDir(), "db.json");
		if(!file.exists()){
			try {
				file.createNewFile();
			}catch (Exception e){
				e.printStackTrace();
			}
		}
		StringBuilder sb = new StringBuilder();
		try {
			FileInputStream fis = openFileInput("db.json");
			InputStreamReader isr = new InputStreamReader(fis);
			BufferedReader bufferedReader = new BufferedReader(isr);
			String line;

			while ((line = bufferedReader.readLine()) != null) {
				sb.append(line);
				System.out.println(line);
			}
		}catch (Exception e){
			e.printStackTrace();
		}
		return sb.toString();
	}
}
