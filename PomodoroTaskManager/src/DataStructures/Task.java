package DataStructures;

import java.util.GregorianCalendar;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Objects;

/**
*An abstract class for Tasks.
*
*@author Tobiasz Czernigowski
*@version 0.1 2016-06-18
*/
public abstract class Task implements Comparable<Task>{
	private Date startDate;
	private Date endDate;
	private Locale loc;
	private SimpleDateFormat dateFormat;
	private String description;

	/**
	*Constructor that creates an Task for a specyfic time in a day.
	*It takes date of start and date of ending, including starting hour.
	*
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
	public Task(int startDay, int startMonth, int startYear, int startMinute, int startHour,
		int endDay, int endMonth, int endYear, int endMinute, int endHour){
		
		loc = new Locale("pl_PL");
		dateFormat = new SimpleDateFormat("dd.MM.yyyy:HH.mm", loc);
		
		GregorianCalendar startCalendar = new GregorianCalendar(startYear, 
			startMonth - 1, startDay, startHour, startMinute);
		startDate = startCalendar.getTime();
		
		GregorianCalendar endCalendar = new GregorianCalendar(endYear, 
			endMonth - 1, endDay, endHour, endMinute);
		endDate = endCalendar.getTime();
		
		description = "";
		}

	/**
	*Constructor that creates an Task that takes a whole day.
	*It takes date of start and date of ending, without starting hour.
	*
	*@param startDay day of month of start date
	*@param startMonth month of start date
	*@param startYear year of start date
	*@param endDay day of month of end date
	*@param endMonth month of end date
	*@param endYear year of end date
	*/
	public Task(int startDay, int startMonth, int startYear,
		int endDay, int endMonth, int endYear){
			
		
		this(startDay, startMonth, startYear, 00, 00, endDay, endMonth,
			endYear, 59, 23);

	}
	
	/**
	*Coustructor that creates an Task that takes certain time.
	It takes date of start a duration of an Task, then it calculates ending time.
	*
	*@param startDay day of month of start date
	*@param startMonth month of start date
	*@param startYear year of start date
	*@param startMinute minute of start date
	*@param startHour hour of start date
	*@param unitOfTime unit of measurement of duration time should be either minute or hour
	*@param duration duration of the Task 
	*/
	public Task(int startDay, int startMonth, int startYear, int startMinute, 
			int startHour,  String unitOfTime, int duration){
		
		loc = new Locale("pl_PL");
		dateFormat = new SimpleDateFormat("dd.MM.yyyy:HH.mm", loc);
		
		int type = 0;
		switch(unitOfTime){
			case "hour" : type = (GregorianCalendar.MINUTE);
			
			case "minute" : type = (GregorianCalendar.HOUR);
		}
		
		GregorianCalendar startCalendar = new GregorianCalendar(startYear, 
			startMonth - 1, startDay, startHour, startMinute);
		startDate = startCalendar.getTime();
		
		startCalendar.add(type, duration);
		endDate = startCalendar.getTime();
		
		description = "";

}
	
	/**
	*A setter method for description variable.
	*/
	public void setDescription(String aDescription){
		this.description = aDescription;
	}
	
	/**
	*A getter method for description variable.
	*/
	public String getDescription(){
		return this.description;
	}
	
	/**
	*A getter method for startDate variable.
	*/
	public Date getStartDate(){
		return this.startDate;
	}
		
	/**
	*A setter method for startDate variable.
	*/
	public void setStartDate(Date aDate){
		this.startDate = aDate;
	}
	
	/**
	*A getter method for endDate variable.
	*/
	public Date getEndDate(){
		return this.endDate;
	}
	
	/**
	*A setter method for endDate variable.
	*/
	public void setEndDate(Date aDate){
		this.endDate = aDate;
	}
	
	/**
	*An equals method.
	*@return returns a boolean value true if objects are equal, false if not.
	*/
	public boolean equals(Object otherObject){
	
		if (this == otherObject) return true;
		
		if (otherObject == null) return false;
		
		if (this.getClass() != otherObject.getClass()) return false;
		
		Task other = (Task) otherObject;
		
		return this.startDate.equals(other.startDate)
			&& this.endDate.equals(other.endDate)
			&& this.description.equals(other.description);
		
	}
	
	public int compareTo(Task other){
		return this.startDate.compareTo(other.getStartDate());
	}
	
	/**
	*Creates a hashCode for an object.
	*@return int representation of an object.
	*/
	public int hashCode(){
		return Objects.hash(startDate, endDate, description);
	}
	
	/**
	*A setter method for description variable.
	*@return returns a string representation of an object.
	*/
	public String toString(){
		return this.getClass().getName() +
		"[startDate=" + dateFormat.format(this.startDate) + 
		", endDate=" + dateFormat.format(this.endDate) + "]"; 
	}

}