package main;
import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Main {
	
	
	public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException {

		new MainFrame();

	}

}

/* TO DO
 * |Menubar					
 * |Fileloader
 * |Tastaturshortcuts einbauen
 * Datenbankanbindung?
 * PlayList
 * Bild aus Metadaten der Musikdatei
 * 
 */