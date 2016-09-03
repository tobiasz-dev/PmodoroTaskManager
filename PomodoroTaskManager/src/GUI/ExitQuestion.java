package GUI;

import javax.swing.*;
import java.awt.event.*;


public class ExitQuestion extends JFrame{
	private JFrame exitFrame;
	private JPanel buttonPanel;
	
	public ExitQuestion(){
		super("Exit?");
		
		exitFrame = this;
		buttonPanel = new JPanel();

		
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(200, 65);
		this.setResizable(false);
		this.setVisible(false);
		
		buttonPanel.add(new YesButton());
		buttonPanel.add(new NoButton());
		
		this.add(buttonPanel);
	}
	
	class YesButton extends JButton implements ActionListener{
		
		public YesButton(){
			super("Yes");
			this.addActionListener(this);
		}	
		
		@Override
		public void actionPerformed(ActionEvent e){
			System.exit(0);
		}
	}

	class NoButton extends JButton implements ActionListener{
		
		public NoButton(){
			super("No");
			this.addActionListener(this);
		}	
		
		@Override
		public void actionPerformed(ActionEvent e){
			exitFrame.setVisible(false);
		}
		
	}
		
}


