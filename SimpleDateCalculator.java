/**********************************************************************
 *  SimpleDateCalculator.java
 *
 *  Author: Chad Harney
 *
 *  Calculates the days in between 2 days. Homework assignment, was not allowed to import anything besides a Scanner. A test in using control flow. 
 **********************************************************************/

import java.util.Scanner;

public class SimpleDateCalculator {

/* Main function
 * -----------------
 *
 * Asks the user to enter the date, calls the daysInBetween function to calculate days. Prints out the number of days.
 */

public static void main(String[] args){
Scanner sc = new Scanner(System.in);
int startYear, startMonth, startDay, endYear, endMonth, endDay, days;

System.out.println("Please enter start year : ");
startYear = sc.nextInt();

System.out.println("Please enter start month : ");
startMonth = sc.nextInt();

System.out.println("Please enter start day : ");
startDay = sc.nextInt();

System.out.println("Please enter end year : ");
endYear = sc.nextInt();

System.out.println("Please enter end month : ");
endMonth = sc.nextInt();

System.out.println("Please enter end day : ");
endDay = sc.nextInt();

boolean error = errorTester(startYear, startMonth, startDay, endYear, endMonth, endDay);

if(error ==true){
	System.out.println("Error");
} else {
days = daysInBetween(startYear, startMonth, startDay, endYear, endMonth, endDay);
System.out.println("There are " + days + " days between " + endMonth + "/" + endDay + "/" + endYear + " and " + startMonth + "/"  + startDay + "/" + startYear);
}
sc.close();
}


/* daysInBetween function
 * -----------------
 *
 * Uses controls flow to count the number of days between 2 dates.
 *
 * @param startYear, startMonth, startDay: The year, month and day of the first date
 * @param endYear, endMonth, endDay: The year, month and day of the ending date
 * @return The days between the two dates
 */
public static int daysInBetween(int startYear,int startMonth, int startDay, int endYear, int endMonth, int endDay){
	int days = 0;
	int startM = startMonth;
	int startY = startYear;
	int endM = endMonth;
	int endY = endYear;
	
	while(startM != endM || startY != endY){
		System.out.println("Before " + " " + startM + " " + startY + " " + days);
		days += daysInMonth(startM, startY);
		startM++;
		System.out.println("After " + startM + " " + " " + startY + " " + days);
		if(startM == 13){
			startY++;
			startM = 1;
		}

	}
	days = days - startDay + endDay;
	
	return days;
	
}

/* daysInMonth function
 * -----------------
 *
 * Calculates the day in the given month
 * 
 * @param month: The current month being calculated
 * @param year: The year in which the month takes place (used for leap years)
 * @return The days in the momth
 */
public static int daysInMonth(int month, int year){
	int days = 0;
	System.out.println("Inside daysInMonth");
	if(month == 1  || month == 3  || month == 5  || month == 7  || month == 8  || month == 10 || month == 12){
		days = 31;
		} else if(month == 4 || month == 6 || month == 9 || month == 11){
		days = 30;
		} else if(month == 2){
		if(leapYear(year)==true){
			days = 29;}
		else{
			days = 28;}}

	return days;
}

/* leapYear function
 * -----------------
 *
 * Determines whether the given year is a leap year
 *
 * @param year: The year being tested for leap year status
 * @return Whether the given year is a leap year
 */
public static boolean leapYear(int year){
System.out.println("Inside leapyears");

	if((year % 4) == 0 || (year % 400) == 0) {
			return true; }
		else{
		return false;}
}

/* errorTester function
 * -----------------
 * 
 * Hard coding for user input error (e.g. Start date is after end date, entered a date that doesn't exist)
 * 
 * @param startYear, startMonth, startDay: The year, month and day of the first date
 * @param endYear, endMonth, endDay: The year, month and day of the ending date
 * @return Whether an error has been found in the user entered dates
 */
public static boolean errorTester(int startYear, int startMonth, int startDay, int endYear, int endMonth, int endDay){
	if(startYear>endYear){
		return true;
	} else if(startYear == endYear && endMonth<startMonth){
		return true;
	} else if (startYear == endYear && startMonth == endMonth && endDay < startDay){
		return true;
	} else if(startMonth == 1  || 
			  startMonth == 3  || 
			  startMonth == 5  || 
			  startMonth == 7  || 
			  startMonth == 8  || 
			  startMonth == 10 || 
			  startMonth == 12 && 
			  startDay<1 || startDay>31){
		return true;
	} else if(startMonth == 4 || 
			  startMonth == 6 || 
			  startMonth == 9 || 
			  startMonth == 11 &&
			  startDay<1 || startDay>30){
		return true;
	} else if(endMonth == 1  || 
			  endMonth == 3  || 
			  endMonth == 5  || 
			  endMonth == 7  || 
			  endMonth == 8  || 
			  endMonth == 10 || 
			  endMonth == 12 && 
			  endDay<1 || endDay>31){
		return true;
	} else if(endMonth == 4 || 
			  endMonth == 6 || 
			  endMonth == 9 || 
			  endMonth == 11 &&
			  endDay<1 || endDay>30){
		return true;
	} else if(startMonth == 2 && leapYear(startYear)==true && startDay<1 || startDay>29){
		return true;
	} else if(startMonth == 2 && leapYear(startYear)==false && startDay<1 || startDay>28){
		return true;
	} else if(endMonth == 2 && leapYear(startYear)==true && endDay<1 || endDay>29){
		return true;
	} else if(endMonth == 2 && leapYear(startYear)==false && endDay<1 || endDay>28){
		return true;
	} else {
	return false;}
	
}
}





	
