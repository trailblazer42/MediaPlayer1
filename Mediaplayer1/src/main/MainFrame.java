package main;


import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import javax.swing.border.Border;

public class MainFrame extends JFrame implements ActionListener, KeyListener{
		
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
		
		openIcon = new ImageIcon(getClass().getClassLoader().getResource("OpenIcon.png")); 
		// in BuildPath we have set up the res folder as another source folder, so we no longer need the whole path 
		exitIcon = new ImageIcon(getClass().getClassLoader().getResource("ExitIcon.png"));
		
		menuBar = new JMenuBar();
		
		fileMenu = new JMenu("File");
		
		openItem = new JMenuItem("Open...");
		openItem.addActionListener(this);
		openItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.ALT_MASK));
		exitItem = new JMenuItem("Exit");
		exitItem.addActionListener(this);
		exitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, ActionEvent.ALT_MASK));
		
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

		imageIcon = new ImageIcon(getClass().getClassLoader().getResource("BackGround.png"));
		label = new JLabel();
		label.setBorder(border);
		label.setBounds(5, 5, 634, 500);			
		label.setIcon(imageIcon);
		label.setBackground(Color.black);
		label.setOpaque(true);
		label.setVerticalAlignment(JLabel.CENTER);
		label.setHorizontalAlignment(JLabel.CENTER);
			
		resetIcon = new ImageIcon(getClass().getClassLoader().getResource("ResetButton.png"));
		resetPressedIcon = new ImageIcon(getClass().getClassLoader().getResource("ResetButtonPressed.png"));
		resetButton = new JButton();
		resetButton.setBounds(150,515,100,100);
		resetButton.addActionListener(this);
		resetButton.setPressedIcon(resetPressedIcon);
		resetButton.setIcon(resetIcon);
		resetButton.setEnabled(false);
		resetButton.setContentAreaFilled(false);	// this makes the button content invisible, so only the icon can be seen
		resetButton.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
		resetButton.setToolTipText("(R)");
		
		playIcon = new ImageIcon(getClass().getClassLoader().getResource("PlayButton.png"));
		playPressedIcon = new ImageIcon(getClass().getClassLoader().getResource("PlayButtonPressed.png"));
		playButton = new JButton();
		playButton.setBounds(260,515,100,100);
		playButton.addActionListener(this);
		playButton.setPressedIcon(playPressedIcon);
		playButton.setIcon(playIcon);	
		playButton.setContentAreaFilled(false);
		playButton.setEnabled(false);
		playButton.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
		playButton.setToolTipText("(P)");

		
		stopIcon = new ImageIcon(getClass().getClassLoader().getResource("StopButton.png"));
		stopPressedIcon = new ImageIcon(getClass().getClassLoader().getResource("StopButtonPressed.png"));
		stopButton = new JButton();
		stopButton.setBounds(370,515,100,100);
		stopButton.addActionListener(this);
		stopButton.setPressedIcon(stopPressedIcon);
		stopButton.setIcon(stopIcon);
		stopButton.setContentAreaFilled(false);
		stopButton.setEnabled(false);
		stopButton.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
		stopButton.setToolTipText("(S)");

		this.addKeyListener(this);
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
			Player.play();
		}
		if(e.getSource()==stopButton) {
			Player.stop();
		}
		if(e.getSource()==resetButton) {
			Player.reset();
		}
		if(e.getSource()==openItem) {
			System.out.println("Opening...");
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

	@Override
	public void keyTyped(KeyEvent e) {
		switch(e.getKeyChar()) {
//			case 'o': 	stopButton.setEnabled(true);
//						playButton.setEnabled(true);
//						resetButton.setEnabled(true);
//			
//						try {
//							Player.loadFile();
//						} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
//							e1.printStackTrace();
//						}; break;
			case 'p': 	Player.play(); break;
			case 'r':  	Player.reset(); break;
			case 's': 	Player.stop(); break;
			case 'q': 	System.exit(0); break;
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}
	
}
