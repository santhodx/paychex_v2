package paychecks;

import java.io.PrintStream;
import java.util.List;

/**
 * The class Department inherits from the class Payroll.
 *
 */
public class Department extends Payroll  {
	private String name; 
	/**
	 * The constructor requires a String representing the name of the department.
	 * @param name
	 */
	public Department(String name){
		this.name=name;
	}
	public String getName(){
		return name;
	}
	@Override
	public void printSalaryReport(PrintStream out, int indent) {
		for(int i=0;i<indent;i++){
			out.print(" ");
		}
		List<PayrollElement> allDepartments=getElements();
		out.println(this.getName()+", total = $"+getTotalSalaries(true));
		for (int i = 0; i < allDepartments.size(); i++){
			allDepartments.get(i).printSalaryReport(out,indent+3);
		}
	}
}
