package GUI;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import DataStructures.PomodoroTask;

/*
 * A panel that displays info about current task
 */
class TaskInfoPanel extends JPanel{
	private static final int HEIGHT = 50;
	private static final int WIDTH = 350;
	private String currentTaskName = "None";
	
	public TaskInfoPanel(){
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		this.setMaximumSize(new Dimension(WIDTH, HEIGHT));
		this.setMinimumSize(new Dimension(WIDTH, HEIGHT));
	}
	
	public void setTask(PomodoroTask task){
		this.currentTaskName = task.getName();
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
		g2d.drawString("Time left", 270, (int) (HEIGHT * 0.45));
		
		
	}

}
