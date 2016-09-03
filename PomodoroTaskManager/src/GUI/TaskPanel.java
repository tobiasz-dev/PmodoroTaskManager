package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import DataStructures.PomodoroTask;

/**
*Class that defines panel with tasks
*/
class TaskPanel extends JPanel{
	private JPanel taskPanel;
	private JPanel taskAddPanel;
	private JPanel taskInfoPanel;
	private List<PomodoroTask> taskList;
	private JScrollPane scrollPanel;
	private JPanel itemPanel;
	
	private static final int HEIGHT = 300;
	private static final int WIDTH = 380;
	
	public TaskPanel(){
		this.taskPanel = this;
		this.taskAddPanel = new TaskAddPanel();
		this.taskInfoPanel = new TaskInfoPanel();
		this.taskList = new ArrayList<PomodoroTask>();
		this.itemPanel = new JPanel();
		itemPanel.setLayout(new BoxLayout(itemPanel, BoxLayout.PAGE_AXIS));
		this.scrollPanel = new JScrollPane(itemPanel);
		
		this.setLayout(new BorderLayout());
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		//adding a TaskAddPanel and setting it north
		this.add(taskInfoPanel, BorderLayout.NORTH);
		this.add(taskAddPanel, BorderLayout.SOUTH);
		this.add(scrollPanel, BorderLayout.CENTER);
	}
	
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
			
	}
	
	//creates a new task, adds it to the list, and displays in the panel
	public void createTask(String name, int pomodoroInit, int priority){
		PomodoroTask task = new PomodoroTask(name, pomodoroInit, priority);
		taskList.add(task);
		
		this.itemPanel.add(new TaskItemPanel(task));

		this.revalidate();
		this.repaint();
		
	}
	
}