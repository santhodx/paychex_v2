package paychecks;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Devdutt Santhosh
 *
 */
public class Payroll implements PayrollElement{
	//This class represents a payroll entity that can contain other PayrollElement objects.
	private List<PayrollElement> payrollElementList = new ArrayList<PayrollElement>();
	/**
	 * This adds PayrollElement details from object e.
	 * @param e this is the object that holds the PayrollElement details
	 */
	public void add(PayrollElement e){
		payrollElementList.add(e);
	}

	/**
	 * This returns the details of the PayrollElement in the order they were stored.
	 * 
	 * @return this returns PayrollElement details
	 */
	public List<PayrollElement> getElements(){
		return payrollElementList;
	}
	/**
	 * The method getName returns the String "Payroll".
	 * @return
	 */
	public String getName(){
		return "Payroll";
	}
	/**
	 * The method getTotalSalaries returns the sum of the total salaries of all PayrollElement objects contained 
	 * in the Payroll object. The value of the parameter includeBonus applies to all intermediate salary totals.
	 */
	@Override
	public int getTotalSalaries(boolean includeBonus) {
		int totalSalary = 0;
		for (int i = 0; i < payrollElementList.size(); i++){
			totalSalary += payrollElementList.get(i).getTotalSalaries(includeBonus);
		}
		return totalSalary;
	}
	/**
	 * The method printSalaryReport prints the salary report at the given 
	 * indentation, as specified in the UI design supplied elsewhere.
	 */
	@Override
	public void printSalaryReport(PrintStream out, int indent) {
		for(int i=0;i<indent;i++){
			out.print(" ");
		}
		out.println("Payroll, total = $"+getTotalSalaries(true));
		for (int i = 0; i < payrollElementList.size(); i++){
			payrollElementList.get(i).printSalaryReport(out, 3);
		}
	}
}
