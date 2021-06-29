import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import javax.swing.border.Border;

public class MainFrame extends JFrame implements ActionListener{
		
	ImageIcon imageIcon;
	ImageIcon playIcon;
	ImageIcon playPressedIcon;
	ImageIcon stopIcon;
	ImageIcon stopPressedIcon;
	ImageIcon resetIcon;
	ImageIcon resetPressedIcon;
	ImageIcon openIcon;
	ImageIcon exitIcon;
	JLabel label;
	JButton playButton;
	JButton stopButton;
	JButton resetButton;
	Player player;
	JMenuBar menuBar;
	JMenu fileMenu;
	JMenuItem openItem;
	JMenuItem exitItem;
	
	public MainFrame() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		
		// Menu ------------------------------------------------------
		
		openIcon = new ImageIcon("res/OpenIcon.png");
		exitIcon = new ImageIcon("res/ExitIcon.png");
		
		menuBar = new JMenuBar();
		
		fileMenu = new JMenu("File");
		
		openItem = new JMenuItem("Open...");
		exitItem = new JMenuItem("Exit");
		
		openItem.addActionListener(this);
		exitItem.addActionListener(this);
		
		openItem.setIcon(openIcon);
		exitItem.setIcon(exitIcon);
		
		fileMenu.add(openItem);
		fileMenu.add(exitItem);
		
		menuBar.add(fileMenu);
		
		this.setJMenuBar(menuBar);
		
		// Frame / Layout --------------------------------------------
		
		this.setSize(666,700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("MusikplayerOne");
		this.setLayout(null);
		
		player = new Player();
		
		Border border = BorderFactory.createLineBorder(Color.black,3);

		imageIcon = new ImageIcon("res/BackGround.png");
		label = new JLabel();
		label.setBorder(border);
		//label.setSize(634, 400);
		label.setBounds(8, 8, 634, 500);			
		label.setIcon(imageIcon);
		label.setBackground(Color.black);
		label.setOpaque(true);
		label.setVerticalAlignment(JLabel.CENTER);
		label.setHorizontalAlignment(JLabel.CENTER);
			
		playIcon = new ImageIcon("res/PlayButton.png");
		playPressedIcon = new ImageIcon("res/PlayButtonPressed.png");
		playButton = new JButton();
		playButton.setBounds(285,515,100,100);
		playButton.addActionListener(this);
		playButton.setPressedIcon(playPressedIcon);
		playButton.setIcon(playIcon);
		
		
		stopIcon = new ImageIcon("res/StopButton.png");
		stopPressedIcon = new ImageIcon("res/StopButtonPressed.png");
		stopButton = new JButton();
		stopButton.setBounds(390,515,100,100);
		stopButton.addActionListener(this);
		stopButton.setPressedIcon(stopPressedIcon);
		stopButton.setIcon(stopIcon);
		
		resetIcon = new ImageIcon("res/ResetButton.png");
		resetPressedIcon = new ImageIcon("res/ResetButtonPressed.png");
		resetButton = new JButton();
		resetButton.setBounds(180,515,100,100);
		resetButton.addActionListener(this);
		resetButton.setPressedIcon(resetPressedIcon);
		resetButton.setIcon(resetIcon);
		
		this.add(label);		
		this.add(resetButton);
		this.add(playButton);
		this.add(stopButton);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);
				
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==playButton) {
			//System.out.println("Playbutton clicked");
			Player.play();
		}
		if(e.getSource()==stopButton) {
			//System.out.println("Stopbutton clicked");
			Player.stop();
		}
		if(e.getSource()==resetButton) {
			//System.out.println("Resetbutton clicked");
			Player.reset();
		}
		if(e.getSource()==openItem) {
			System.out.println("Opening...");
			//Player.stop();
			try {
				Player.loadFile();
			} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
				e1.printStackTrace();
			}
		}
		if(e.getSource()==exitItem) {
			System.exit(0);
		}
			
	}
	
}
