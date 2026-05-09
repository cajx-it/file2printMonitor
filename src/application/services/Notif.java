package application.services;
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import application.settings.Settings;


public class Notif {
	
	public static void play() {
		try {
			
			File music = new File(Settings.sound());
			
			
			AudioInputStream audio = AudioSystem.getAudioInputStream(music);
			Clip clip = AudioSystem.getClip();
			clip.open(audio);
			
			clip.start();
			
			Thread.sleep(clip.getMicrosecondLength() / 700);
			
		}catch(Exception e) {
			System.out.print(e);
		}
	}
}
