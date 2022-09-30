package com.UseCases;

import java.util.List;
import java.util.Scanner;

import com.BeenClasses.Complain;
import com.BeenClasses.EngineerComplainDTO;
import com.Dao.EmployeeDao;
import com.Dao.EmployeeDaoImpl;
import com.Exceptions.ComplainException;

public class EmployeeUseCasses {

	public static void optionsEmployee() {
		
		
		Scanner sc = new Scanner(System.in);
		EmployeeDao hd = new EmployeeDaoImpl();
		System.out.println("\nPlease Select An Option To Continue");
		System.out.println(
				"\n1. Register Complain\n2. See Status Of Problems\n3. See All Complains Raised By You :\n4. Change Password\n5. Exit");
		
		int number = sc.nextInt();
		
		switch(number) {
		case 1: 
			System.out.println("Enter Catagory  : Hardware/Software ");
			String com = sc.next();
			System.out.println("Enter Complainer Name :");
			String cname = sc.next();
			String str =hd.registerComplain(cname,com);
			System.out.println(str);
			EmployeeUseCasses.optionsEmployee();
			break;
	        
		 case 2:
			 System.out.println("Enter Complain Id :");
			 int name = sc.nextInt();
			 List<EngineerComplainDTO> s;
			try {
				s = hd.checkComplainStatus(name);
				s.forEach(se -> System.out.println(se));
			} catch (ComplainException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			 
			 EmployeeUseCasses.optionsEmployee();
			 break;
		     
		  case 3:
			  System.out.println("Enter Employee Name :");
			  String ename2 = sc.next();
			  List<Complain> eclist = hd.getComplainByEmployee(ename2);
			  eclist.forEach(e -> System.out.println(e));
			  
			  EmployeeUseCasses.optionsEmployee();
			  break;
			  
			  
		  case 4:
			  System.out.println("Enter Employee Id :");
			  int employeeId = sc.nextInt();
			  System.out.println("Enter New Password :");
			  String password = sc.next();
			  String up = hd.changePassword(employeeId, password);
			  System.out.println(up);
			  EmployeeUseCasses.optionsEmployee();
			  break;
			  
			  
		  case 5:
			  break;
			  			  
		}
	}
}
