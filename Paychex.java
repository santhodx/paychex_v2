package paychecks;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

/**
 * This class implements payroll computations on your screen.
 * 
 * @author Devdutt Santhosh
 *
 */
public class Paychex{
	/**
	 * supplies command-line arguments as an array of String objects.
	 * 
	 * @param args an array of command-line arguments for the application.
	 */
	public static void main(String[] args){
		Payroll mainPayroll = new Payroll();
		//Department 1
		Department department1=new Department("Department 1");
		mainPayroll.add(department1);
		Developer employee1Developer=new Developer("Employee 1",100000);
		department1.add(employee1Developer);
		Manager employee2Manager=new Manager("Employee 2",120000,department1);
		department1.add(employee2Manager);//////////////
		
		//Department 2 
		Department department2=new Department("Department 2");
		department1.add(department2);
		
		Developer employee2Developer=new Developer("Employee 3",90000);
		department2.add(employee2Developer);
		
		//Department 3
		Department department3=new Department("Department 3");
		mainPayroll.add(department3);
		//Employee 4, Developer
		Developer employee4Developer=new Developer("Employee 4",95000);
		department3.add(employee4Developer);
		
		if(args.length==0){
			mainPayroll.printSalaryReport(System.out,0);
		}else{
			String fileName=args[0];
			try {
				PrintStream printStreamPayroll = new PrintStream(new File(fileName));
				mainPayroll.printSalaryReport(printStreamPayroll,0);
				printStreamPayroll.close(); 
			} catch (FileNotFoundException e){}
			System.out.println("Payroll information has been saved to 'Payroll.txt' file");
		}

	}
}
