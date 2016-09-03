package GUI;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import DataStructures.PomodoroTask;

/**
 * A class that is a blueprint for a window that takes 
 * user input and creates new pomodoro task.
 * @author Tobiasz
 * @version 00.01 04.08.2016
 */
public class AddTask extends JFrame{
	private JFrame addTaskFrame;
	private JPanel addTaskPanel;
	private JTextField taskNameField;
	private JTextField pomodoroNumberField;
	private JLabel priorityLabel;
	private JButton createTaskButton;
	private JLabel taskNameLabel;
	private JLabel pomodoroNumberLabel;
	private JComboBox<String> priorityBox;
	private MainWindow parent;
	
	
	public AddTask(MainWindow aParent){
		super("Add New Task");
		parent = aParent;
		
		
		this.addTaskFrame = this;
		
		//initializing panels, labels, buttons and fields
		this.addTaskPanel = new JPanel();
		this.taskNameField = new JTextField("Enter task name", 20);
		this.pomodoroNumberField = new JTextField("0", 5);
		this.taskNameLabel = new JLabel("Task name: ", SwingConstants.RIGHT);
		this.pomodoroNumberLabel = new JLabel("Pmodoro units: ", SwingConstants.RIGHT);
		this.priorityLabel = new JLabel("Choose priority: ", SwingConstants.RIGHT);
		this.priorityBox = new JComboBox<String>();
		
		priorityBox.addItem("High");
		priorityBox.addItem("Medium");
		priorityBox.addItem("Low");
		this.add(addTaskPanel);
		this.createTaskButton = new JButton("Create Task");
		
		//adding labels and, fileds and buttons to panel
		this.addTaskPanel.add(taskNameLabel);
		this.addTaskPanel.add(taskNameField);
		this.addTaskPanel.add(pomodoroNumberLabel);
		this.addTaskPanel.add(pomodoroNumberField);
		this.addTaskPanel.add(priorityLabel);
		this.addTaskPanel.add(priorityBox);
		this.addTaskPanel.add(createTaskButton);
		
		//adding action listener to a button
		this.createTaskButton.addActionListener(new addTaskAction());
		
		//setting window parameters
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.setSize(350, 200);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setVisible(false);
		
		
		
	}
	
	class addTaskAction implements ActionListener{
		
		@Override 
		public void actionPerformed(ActionEvent e){
			String name = taskNameField.getText().trim();
			int pomodoroNum = Integer.parseInt(pomodoroNumberField.getText().trim());
			taskNameField.setText("Enter task name");
			pomodoroNumberField.setText("0");
						
			//determining priority
			String priority = priorityBox.getItemAt(priorityBox.getSelectedIndex());
			int priorityNum = 0;
			
			switch (priority){
				case "High":  priorityNum = PomodoroTask.HIGH_PRIORITY;
				
				case "Medium" : priorityNum = PomodoroTask.MEDIUM_PRIORITY;
				
				case "Low" : priorityNum = PomodoroTask.LOW_PRIORITY;
			
			}
			//creating task
			parent.getTaskPanel().createTask(name, pomodoroNum, priorityNum);
			addTaskFrame.hide();
			
		}
		
	}

}

