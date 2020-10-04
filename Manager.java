package paychecks;

import java.io.PrintStream;
import java.util.List;

/**
 * This class is inherited from the Employee class and can execute all the
 * functions in Employee class.
 * 
 * @author Devdutt Santhosh
 *
 */
public class Manager extends Employee{
	private Department department;
	/**
	 * The constructor requires, in addition to the name and salary of the manager, the Department managed by this manager.
	 * @param name
	 * @param salary
	 * @param department
	 */
	public Manager(String name, int salary,Department  department)	{
		super(name, salary);
		this.department=department;
	}

	/**
	 * This returns a String containing the employee's title.
	 * 
	 * @return This returns title "Manager".
	 */
	public String getTitle(){
		return "Manager";
	}

	public int getBonus(){
		int  totalSalariesManagerDepartment=0;
		List<PayrollElement> allDepartments=this.department.getElements();
		for(int i=0;i<allDepartments.size();i++){
			totalSalariesManagerDepartment+=allDepartments.get(i).getTotalSalaries(false);
		}
		return totalSalariesManagerDepartment/100;
	}
	@Override
	public void printSalaryReport(PrintStream out, int indent) {
		for(int i=0;i<indent;i++){
			out.print(" ");
		}
		out.println(this.getName()+", "+getTitle()+", $"+getTotalSalaries(true));
	}
}
