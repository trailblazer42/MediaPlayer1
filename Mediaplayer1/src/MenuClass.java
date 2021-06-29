import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuClass implements ActionListener{
	
	JMenuBar menuBar;
	
	JMenu fileMenu;
	
	JMenuItem openItem;
	JMenuItem exitItem;
	
	ImageIcon openIcon;
	ImageIcon exitIcon;
	
	public MenuClass() {
		
		openIcon = new ImageIcon("res/OpenIcon.png");
		exitIcon = new ImageIcon("res/ExitIcon.png");
		
		menuBar = new JMenuBar();
		
		fileMenu = new JMenu("File");
		
		openItem = new JMenuItem("Open...");
		exitItem = new JMenuItem("Exit");
		
		openItem.setIcon(openIcon);
		exitItem.setIcon(exitIcon);
		
		fileMenu.add(openItem);
		fileMenu.add(exitItem);
		
		menuBar.add(fileMenu);
		
	}
	


	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
	
}
