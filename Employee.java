package paychecks;

import java.io.PrintStream;

/**
 * This is an abstract class which is extended to the Developer class and the
 * Manager class used to store the employee name, salary, title and bonus.
 * The class Employee is an abstract class that implements PayrollElement.
 * @author Devdutt Santhosh
 */
abstract class Employee implements PayrollElement{
	//This class represents a payroll entity that has a name, title, salary, and bonus.
	private String name;
	private int salary;
	/**
	 * This constructs an employee with a specified name and salary.
	 * 
	 * @param name   name the name of the employee
	 * @param salary the salary of the employee
	 */
	public Employee(String name, int salary){
		this.name = name;
		this.salary = salary;
	}
	/**
	 * This returns the employee's salary as supplied to the constructor.
	 * 
	 * @return this employee's salary
	 */
	public int getSalary(){
		return salary;
	}
	/**
	 * This returns the employee's name as supplied to the constructor.
	 * @return this employee's name
	 */
	public String getName(){
		return name;
	}
	/**
	 * This is an abstract method that returns a String containing the employee's
	 * title.
	 * 
	 * @return the title of the employee
	 */
	public abstract String getTitle();

	/**
	 * This is an abstract method that returns an integer representing the
	 * employee's bonus.
	 * 
	 * @return the bonus amount
	 */
	public abstract int getBonus();
	/**
	 * The method getTotalSalaries returns the salary of this employee, including the bonus if and only if include Bonus is true.
	 */
	@Override
	public int getTotalSalaries(boolean includeBonus) {
		int totalSalaries=salary;
		if(includeBonus){
			totalSalaries+=getBonus();			
		}
		return totalSalaries;
	}

	/**
	 * The method printSalaryReport prints the salary report at the given 
	 * indentation, as specified in the UI design supplied elsewhere.
	 */
	@Override
	public void printSalaryReport(PrintStream out, int indent) {
		out.println(this.name+", "+getTitle()+", $"+getTotalSalaries(true));
	}
}
