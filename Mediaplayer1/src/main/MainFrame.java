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
		
		this.setSize(660,700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("MusikplayerOne");
		this.setLayout(null);
		this.getContentPane().setBackground(Color.black);
		
		player = new Player();
		
		Border border = BorderFactory.createLineBorder(Color.black,3);

		imageIcon = new ImageIcon("res/BackGround.png");
		label = new JLabel();
		label.setBorder(border);
		//label.setSize(634, 400);
		label.setBounds(5, 5, 634, 500);			
		label.setIcon(imageIcon);
		label.setBackground(Color.black);
		label.setOpaque(true);
		label.setVerticalAlignment(JLabel.CENTER);
		label.setHorizontalAlignment(JLabel.CENTER);
			
		resetIcon = new ImageIcon("res/ResetButton.png");
		resetPressedIcon = new ImageIcon("res/ResetButtonPressed.png");
		resetButton = new JButton();
		resetButton.setBounds(150,515,100,100);
		resetButton.addActionListener(this);
		resetButton.setPressedIcon(resetPressedIcon);
		resetButton.setIcon(resetIcon);
		resetButton.setEnabled(false);
		resetButton.setOpaque(false);
		resetButton.setFocusPainted(false);
		resetButton.setBorderPainted(false);
		resetButton.setContentAreaFilled(false);
		resetButton.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
		
		playIcon = new ImageIcon("res/PlayButton.png");
		playPressedIcon = new ImageIcon("res/PlayButtonPressed.png");
		playButton = new JButton();
		playButton.setBounds(260,515,100,100);
		playButton.addActionListener(this);
		playButton.setPressedIcon(playPressedIcon);
		playButton.setIcon(playIcon);	
		playButton.setOpaque(false);
		playButton.setFocusPainted(false);
		playButton.setBorderPainted(false);
		playButton.setContentAreaFilled(false);
		playButton.setEnabled(false);
		playButton.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
		
		stopIcon = new ImageIcon("res/StopButton.png");
		stopPressedIcon = new ImageIcon("res/StopButtonPressed.png");
		stopButton = new JButton();
		stopButton.setBounds(370,515,100,100);
		stopButton.addActionListener(this);
		stopButton.setPressedIcon(stopPressedIcon);
		stopButton.setIcon(stopIcon);
		stopButton.setOpaque(false);
		stopButton.setFocusPainted(false);
		stopButton.setBorderPainted(false);
		stopButton.setContentAreaFilled(false);
		stopButton.setEnabled(false);
		stopButton.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
		
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
			stopButton.setEnabled(true);
			playButton.setEnabled(true);
			resetButton.setEnabled(true);

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