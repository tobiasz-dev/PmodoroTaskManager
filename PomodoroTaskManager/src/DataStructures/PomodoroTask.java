package DataStructures;

/**
 * Class defining a task in  pomodoro time managemant system.
 * 
 * @author Tobiasz Czernigowski
 * @version 0.1 01.08.2016
 */
public class PomodoroTask{

	private int pomodoroUnits, usedPomodoroUnits, priority;
	private String name;
	
	public static final int HIGH_PRIORITY = 1;
	public static final int MEDIUM_PRIORITY = 2;
	public static final int LOW_PRIORITY = 3;

	/**
	 * 
	 * Constructor that takes three parametrs to create a pomodoro task
	 * @param aPomodoroUnits initial number of pomodoro units assinged to a task
	 * @param aName name of a task
	 * @param aPriority priority number of a task
	 */
	public PomodoroTask(String aName, int aPomodoroUnits, int aPriority){
		this.pomodoroUnits = aPomodoroUnits;
		this.name = aName;
		this.priority = aPriority;
		this.usedPomodoroUnits = 0;
		}
	
	/**
	 * Adds a certain number of pomidoro units to an already created task.
	 * @param num number of pomodor units added to pool of pomodor units of a task
	 */
	public void addPomodoroUnits(int num){
		this.pomodoroUnits += num;
		}
	
	/**
	 * Substracts a single pomodoro unit from task
	 */
	public void usePomodoroUnit(){
		this.usedPomodoroUnits--;
		}
	
	/**
	 * 
	 * Returns a number of left pomodoro units
	 * @return number of left pomodoro units
	 */
	public int leftPomodoroUnits(){
		return this.pomodoroUnits - this.usedPomodoroUnits;
	}
	
	/**
	 * Returns name of a task
	 * @return value of variable name
	 */
	public String getName(){
		return this.name;
	}
	
	/**
	 * Returns number of pomodoro units assinged to a task
	 * @return number of pomodoro task
	 */
	public int getPomodoroUnits(){
		return this.pomodoroUnits;
	}
	
	/**
	 * Returns a number of used pomodoro units
	 * @return number of used pomodoro units
	 */
	public int getUsedPomodoroUnits(){
		return this.usedPomodoroUnits;
	}
	
	/**
	 * Returns a value assigned to a priority
	 * @return a value assigned to a priority
	 */
	public int getPriority(){
		return this.priority;
	}
	
	public String priorityToString(){
		String stringPriority = null;
		
		switch (this.priority){
		case 1: stringPriority = "high";
				break;
				
		case 2: stringPriority = "medium";
				break;
				
		case 3: stringPriority = "low";
				break;
		}
		
		return stringPriority;
	}
	
	/**
	 * Compares two object, 
	 * @param other object that current object gets compared to
	 * @return a value repressing which is bigger 
	 */
	public int compateTo(PomodoroTask other){
		Integer otherPriority = (Integer) other.getPriority();
		return ((Integer) this.priority).compareTo(otherPriority);
	}

}