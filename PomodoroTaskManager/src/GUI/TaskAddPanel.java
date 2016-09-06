package GUI;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;

import GUI.TaskAddPanel.AddAction;
import GUI.TaskAddPanel.AddButton;

/**
 * Class for task add panel. This panel contains a button that shows AddTask window.
 * @author Tobiasz
 *
 */
class TaskAddPanel extends JPanel{
	private JPanel panel;
	private int num;
	private JButton addBttn;
	private JPanel parentPanel;
	
	public TaskAddPanel(JPanel parentPanel){
		this.panel = this;
		this.num = 0;
		this.parentPanel = parentPanel;
		//setting parameters of this panel
		this.setLayout(new FlowLayout(FlowLayout.RIGHT));
		this.setPreferredSize(new Dimension(120,38));
		
		//adding button with action to this panel
		Action addAction = new AddAction();
		addBttn = new AddButton(addAction);
		InputMap imap = this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		imap.put(KeyStroke.getKeyStroke("ctrl T"), "added.task");
		ActionMap amap = this.getActionMap();
		amap.put("added.task", addAction);
		
		this.add(addBttn);
		
	}

	@Override
	public void paintComponent(Graphics g){	
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		
		Font sansSerif14 = new Font("SansSerif", Font.PLAIN,  14);
		int taskNum = ((TaskPanel) this.getParent()).getTaskNumber();
		String tasks = "Current tasks: " + taskNum;
		
		FontRenderContext context = g2d.getFontRenderContext();
		Rectangle2D bounds = sansSerif14.getStringBounds(tasks, context);
		
		double x = (this.getWidth() - bounds.getWidth()) / 2;
		double y = (this.getHeight() - bounds.getHeight()) / 20;
		
		g2d.setFont(sansSerif14);
		g2d.drawString(tasks, 10, 20);	

		
	}
	
	/*
	/Wew. klasa przycisku (zawarta w panelu)
	*/
	class AddButton extends JButton{
				
		public AddButton(Action action){
			super(action);
		}
		
	}
	
	class AddAction extends AbstractAction{
		private static final int MAX_POMODORO_TASKS = 10;
		
		public AddAction(){
			this.putValue(Action.NAME, "Add Task");
		}
		
		@Override
		public void actionPerformed(ActionEvent e){
			
			if(num < MAX_POMODORO_TASKS){
				//ERROR: this should count only pomodoro task created not times button was pressed
				num ++;
				
				//displaying add task window
				JFrame mainFrame;
				mainFrame = (JFrame) SwingUtilities.getWindowAncestor(panel);			
				((MainWindow) mainFrame).showAddTaskWindow();
				
				
			}
			else{
				JDialog alert =  new JDialog();
				alert.setVisible(true);
				alert.setLocationRelativeTo(null);
			}
			
		}
	}
	
}
