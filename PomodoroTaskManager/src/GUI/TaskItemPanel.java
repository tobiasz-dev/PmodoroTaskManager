package GUI;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;

import DataStructures.PomodoroTask;

/*
 *Class defining a single task panel
 */
class TaskItemPanel extends JPanel{
	private PomodoroTask task;
	private Rectangle2D border;
	private JButton startButton;
	private JButton stopButton;
	private static final int HEIGHT = 50;
	private static final int WIDTH = 350;
	private JPanel taskItemPanel;
	private TaskPanel taskPanel;
	
	public TaskItemPanel(PomodoroTask aTask){
	
		taskItemPanel = this;
		task = aTask;
		border = new Rectangle2D.Double(5, 5, WIDTH - 6, HEIGHT - 10);
		
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		this.setMaximumSize(new Dimension(WIDTH, HEIGHT));
		this.setMinimumSize(new Dimension(WIDTH, HEIGHT));
		this.setLayout(new FlowLayout(FlowLayout.RIGHT, 6 , HEIGHT / 4 ));
		
		this.startButton = new JButton();
		this.stopButton = new JButton();
		
		this.stopButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				task.usePomodoroUnit();
				
				if (task.getPomodoroUnits() <= task.getUsedPomodoroUnits()){
					JDialog finished = new JDialog();
					finished.setTitle("Task completed!");
					
					//creating a button that hides OK window
					JButton ok = new JButton("OK");
					ok.addActionListener(new ActionListener(){

						@Override
						public void actionPerformed(ActionEvent e) {
							finished.setVisible(false);
							
						}
						
					});
					finished.add(ok);
					finished.setSize(new Dimension(180, 78));
					finished.setLayout(new FlowLayout());
					finished.setLocationRelativeTo(null);
					finished.setVisible(true);
					
					taskPanel.removeTask(task);
					taskPanel.taskRemovedRefresh();
					taskItemPanel.hide();
					
				}
				revalidate();
				repaint();
				
			}
			
		});
		
		this.startButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				taskPanel.setCurrentTask(task);
			}
			
		});
		
		try{
			Image startIcon = ImageIO.read(getClass().getResource("/Icons/button-play.png"));
			startButton.setIcon(new ImageIcon(startIcon));
			
			Image stopIcon = ImageIO.read(getClass().getResource("/Icons/button-stop.png"));
			stopButton.setIcon(new ImageIcon(stopIcon));
			
		}catch (IOException ex){
			System.out.println("no image found");
		}
		
		this.startButton.setSize(new Dimension(5, 5));
		this.add(startButton);
		this.add(stopButton);
	}
	
	@Override
	public void paintComponent(Graphics g){
		taskPanel = (TaskPanel) taskItemPanel.getParent().getParent().getParent().getParent(); 
		String name = this.task.getName();
		String priority = this.task.priorityToString();
		int usedPomodoroUnits = this.task.getUsedPomodoroUnits();
		int pomodoroUnits = this.task.getPomodoroUnits();
		
		String info = "Pomodoro units: " + usedPomodoroUnits + "/" + pomodoroUnits + " " +
						"Priority: " + priority;
						
		super.paintComponent(g);
		
		Graphics2D g2d = (Graphics2D) g;		
		
		Font sansSerif14 = new Font("SansSerif", Font.PLAIN,  14);
		Font sansSerif14Bold = new Font("SansSerif", Font.BOLD,  14);
		
		g2d.draw(border);
		g2d.setFont(sansSerif14Bold);
		g2d.drawString(name, 8, (int) (HEIGHT * 0.45));
		g2d.setFont(sansSerif14);
		g2d.drawString(info, 8, (int) (HEIGHT * 0.75));
			
	}
	
	
}
