package main;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFileChooser;

public class Player{
	
	static File file;
	static Clip clip;
	static JFileChooser fileChooser;
	
	Player() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		
		//file = new File("D:\\Programmieren\\Vorlagen\\Audio\\PortOfAdia.wav");
		if(clip!=null) {
		loadFile();
		}		 		
	}

	public static void loadFile() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		
		fileChooser = new JFileChooser();
		fileChooser.setCurrentDirectory(new File("C:/"));
		int response = fileChooser.showOpenDialog(null);
		if(clip!=null) {
			stop();
		}
		if(response==JFileChooser.APPROVE_OPTION) {
			File data = new File(fileChooser.getSelectedFile().getAbsolutePath());
			System.out.println(data);
			file = new File(String.valueOf(data));
			AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
			clip = AudioSystem.getClip();	
			clip.open(audioStream);
		}				
	}
	
	public static void play() {
		if(clip.isRunning()) {
			clip.stop(); 
		} else {
			if(clip!=null) {	
				clip.start(); 
			} else {
				// Buttons disabled when no file is selected yet?
			}
		}
	}
	
	public static void stop() {
		if(clip.isRunning()) {
			clip.setMicrosecondPosition(0);
			clip.stop(); 
		}
	}
	
	public static void reset() {
		clip.setMicrosecondPosition(0);
	}
}