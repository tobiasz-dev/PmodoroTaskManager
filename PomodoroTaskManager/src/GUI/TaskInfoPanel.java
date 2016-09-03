package GUI;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

/*
 * A panel that displays info about current task
 */
class TaskInfoPanel extends JPanel{
	private static final int HEIGHT = 50;
	private static final int WIDTH = 350;
	
	public TaskInfoPanel(){
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		this.setMaximumSize(new Dimension(WIDTH, HEIGHT));
		this.setMinimumSize(new Dimension(WIDTH, HEIGHT));
	}
	
	@Override
	public void paintComponent(Graphics g){
		String name = "TASK NAME";
		
		
		super.paintComponent(g);
		
		Graphics2D g2d = (Graphics2D) g;
		
		Font sansSerif14 = new Font("SansSerif", Font.PLAIN, 14);
		g2d.setFont(sansSerif14);
		g2d.drawString(name, 8, (int) (HEIGHT * 0.45));
		
	}
	
}
