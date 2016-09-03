package DataStructures;

import java.util.Date;

/**
*A class for general tasks.
*
*@author Tobiasz Czernigowski
*@version 0.1 2016-06-18
*/
public class GeneralTask extends Task implements Comparable<Task>, Cloneable{
	private String name;
		
	/**
	*Constructor that creates a Task for a specyfic time in a day.
	*
	*@param aName name of the task	
	*@param startDay day of month of start date
	*@param startMonth month of start date
	*@param startYear year of start date
	*@param startMinute minute of start date
	*@param startHour hour of start date
	*@param endDay day of month of end date
	*@param endMonth month of end date
	*@param endYear year of end date
	*@param endMinute minute of end date
	*@param endHour hour of end date
	*/
	public GeneralTask(String aName, int startDay, int startMonth, int startYear, int startMinute,
				int startHour, int endDay, int endMonth, int endYear, int endMinute, int endHour){
				
		super(startDay, startMonth, startYear, startMinute, startHour, endDay, endMonth,
			endYear, endMinute, endHour);
		this.name = aName;
	}
	
	/**
	*Constructor that creates an task that takes a whole day.
	*
	*@param aName name of the task
	*@param startDay day of month of start date
	*@param startMonth month of start date
	*@param startYear year of start date
	*@param endDay day of month of end date
	*@param endMonth month of end date
	*@param endYear year of end date
	*/
	public GeneralTask(String aName, int startDay, int startMonth, int startYear, int endDay,
			int endMonth, int endYear){
		
		super(startDay, startMonth, startYear, endDay, endMonth, endYear);
		this.name = aName;
	}
	
	/**
	*Coustructor that creates an task that takes certain time.
	*
	*@param aName name of the task
	*@param startDay day of month of start date
	*@param startMonth month of start date
	*@param startYear year of start date
	*@param startMinute minute of start date
	*@param startHour hour of start date
	*@param unitOfTime unit of measurement of duration time should be either minute or hour
	*@param duration duration of the task 
	*/
	public GeneralTask(String aName, int startDay, int startMonth, int startYear, int startMinute, 
			int startHour,  String unitOfTime, int duration){
			
			super(startDay, startMonth, startYear, startMinute, startHour, unitOfTime, duration);
			this.name = aName;
	}
	
	public String getName(){
		return this.name;
	}
	
	public boolean equals(Object otherObject){
		
		if (!super.equals(otherObject)) return false;
				
		GeneralTask other = (GeneralTask) otherObject;
			
		return this.name.equals(other.name);
		
	}
	
	public int compareTo(Task other){
		return super.compareTo(other);
	}
	
	public GeneralTask clone() throws CloneNotSupportedException{
		GeneralTask cloned = (GeneralTask) super.clone();
		cloned.setStartDate((Date) this.getStartDate().clone());
		cloned.setEndDate((Date) this.getEndDate().clone());
		
		return cloned;
	}
	
	public int hashCode(){
		return super.hashCode() + 17 * name.hashCode();
	}
	
	public String toString(){
		return super.toString() + "[name=" + this.name + "]";
	}

}