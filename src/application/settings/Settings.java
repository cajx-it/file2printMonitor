package application.settings;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import application.services.DirWatcher;


public class Settings {
	
	private static String LastTodo;
	private static String LastReject;
	private static String LastDone;
	private static String LastSound;
	
	public static void setup(){
		Settings.LastTodo = Settings.todo();
		Settings.LastReject = Settings.reject();
		Settings.LastDone = Settings.done();
		Settings.LastSound = Settings.sound();
	}
	
	
	public static void CheckChanges() {
		
		Properties props = new Properties();
		
		try {
			props.load(new FileInputStream("src\\application\\settings\\Config.properties"));
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
		if(props.getProperty("todo").equals(Settings.LastTodo) && props.getProperty("reject").equals(Settings.LastReject) && props.getProperty("done").equals(Settings.LastDone) && props.getProperty("notif").equals(Settings.LastSound)) {
			System.out.println("Settings not change!");
		}else {
			System.out.println("Settings has change!");
			Settings.setup();
			DirWatcher.stop();
			DirWatcher.start();
			
		}
	}

	
	public static String todo() {
		
		Properties props = new Properties();
		try {
			props.load(new FileInputStream("src\\application\\settings\\Config.properties"));
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		

		
		return props.getProperty("todo");

		
	}


	public static String reject() {
		
		Properties props = new Properties();
		try {
			props.load(new FileInputStream("src\\application\\settings\\Config.properties"));
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		

	
		 return props.getProperty("reject");

		
	}
	
	public static String done() {
		
		Properties props = new Properties();
		try {
			props.load(new FileInputStream("src\\application\\settings\\Config.properties"));
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		

		 return props.getProperty("done");

		
	}
	
	public static String sound() {
		
		Properties props = new Properties();
		try {
			props.load(new FileInputStream("src\\application\\settings\\Config.properties"));
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}

		 return props.getProperty("notif");

	}

}
