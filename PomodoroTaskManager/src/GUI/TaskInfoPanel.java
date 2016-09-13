package GUI;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

import DataStructures.PomodoroTask;

/*
 * A panel that displays info about current task
 */
class TaskInfoPanel extends JPanel{
	private static final int HEIGHT = 50;
	private static final int WIDTH = 350;
	//how much time is one pomodoro unita
	private final int pomodoroUnit = 5;//25 * 60;
	private String currentTaskName = "None";
	private PomodoroTask currentTask;
	private int timeRemaining;
	private Timer timer;
	private JPanel thisPanel;
	private JPanel taskPanel;
	private JPanel itemPanel;
	
	public TaskInfoPanel(JPanel taskPanel){
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		this.setMaximumSize(new Dimension(WIDTH, HEIGHT));
		this.setMinimumSize(new Dimension(WIDTH, HEIGHT));
		this.taskPanel = taskPanel;
		this.thisPanel = this;
		this.timeRemaining = pomodoroUnit;
		timer = new Timer(1000, new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				timeRemaining--;
				thisPanel.revalidate();
				thisPanel.repaint();
				if(timeRemaining <= 0){
					((TaskPanel) taskPanel).taskStopped(currentTask, itemPanel);
					timer.stop();
				}
				
			}
			
		});
	}
	
	public void setTask(PomodoroTask task){
		this.currentTaskName = task.getName();
		this.currentTask = task;
		this.revalidate();
		this.repaint();
	}
	
	public void startTask(PomodoroTask task, JPanel itemPanel){
		this.itemPanel = itemPanel;
		this.currentTaskName = task.getName();
		this.currentTask = task;
		timer.start();
		this.revalidate();
		this.repaint();
	}
	
	public void stopTask(){
		this.timer.stop();
		this.timeRemaining = this.pomodoroUnit;
		this.revalidate();
		this.repaint();
	}
	
	public void setNoTask(){
		this.currentTaskName = "None";
		this.revalidate();
		this.repaint();
	}
	
	@Override
	public void paintComponent(Graphics g){
		String name = "Current: ";
		
		
		super.paintComponent(g);
		
		Graphics2D g2d = (Graphics2D) g;
		
		Font sansSerif14 = new Font("SansSerif", Font.PLAIN, 14);
		Font sansSerif14Bold = new Font("SansSerif", Font.BOLD, 14);
		
		g2d.setFont(sansSerif14);
		g2d.drawString(name, 8, (int) (HEIGHT * 0.45));
		
		g2d.setFont(sansSerif14Bold);
		g2d.drawString(this.currentTaskName, 65, (int) (HEIGHT * 0.45));
		
		g2d.setFont(sansSerif14);
		g2d.drawString("Time: ", 270, (int) (HEIGHT * 0.45));
		
		//converting sec to min:sec
		String min = String.format("%02d", (this.timeRemaining / 60));
		String sec = String.format("%02d", (this.timeRemaining % 60));
		
		g2d.drawString(min + ":" + sec, 310, (int) (HEIGHT * 0.45));
		
	}
	
	

}
