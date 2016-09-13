package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JWindow;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.JDialog;

import DataStructures.PomodoroTask;


/**
*
*Class that defines main window of the program
*/
class MainWindow extends JFrame{
	private JFrame mainWindow;
	private JFrame exitFrame;
	private JFrame addFrame;
	private TaskPanel taskPanel;
	
	public MainWindow(){
		super("Pomodoro Task Manager");
		this.mainWindow = this;
		this.addFrame = new AddTask(this);
		
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.taskPanel = new TaskPanel();
		
		JMenuBar menuBar = new JMenuBar();
		this.createMenuBar(menuBar);
		this.setJMenuBar(menuBar);
		
		this.add(taskPanel);
		this.pack();
		
		//displaying a window which asks user whether he wants to quit the program
		this.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e){
				int exitQuestion = JOptionPane.showConfirmDialog(mainWindow, "Close the program", "Exit question", JOptionPane.YES_NO_OPTION, JOptionPane.CANCEL_OPTION);
				if (exitQuestion == JOptionPane.YES_OPTION){
					System.exit(0);
				}

			}
		
		});
		
		
	}
	
	public void showAddTaskWindow(){
		addFrame.setVisible(true);
		addFrame.setLocationRelativeTo(mainWindow);
	}
	
	public TaskPanel getTaskPanel(){
		return this.taskPanel;
	}
	
	public void createMenuBar(JMenuBar menuBar){
		JMenu helpMenu = new JMenu("Help");
		JMenuItem helpItem = new JMenuItem("Help");
		JMenuItem settingsItem = new JMenuItem("Settings");
		
		helpItem.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});;
		
		settingsItem.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});;
		
		menuBar.add(helpMenu);
		helpMenu.add(helpItem);
		helpMenu.add(settingsItem);
	}

	
}








