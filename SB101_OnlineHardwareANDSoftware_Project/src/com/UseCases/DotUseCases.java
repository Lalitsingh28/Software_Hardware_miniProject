package com.UseCases;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.BeenClasses.Complain;
import com.BeenClasses.Engineer;
import com.Dao.HodDao;
import com.Dao.HodDaoImpl;
import com.Exceptions.ComplainException;
import com.Exceptions.EngineerException;

public class DotUseCases {
	
	
	
	public static void optionsHod() {
		Scanner sc = new Scanner(System.in);
		HodDao hd = new HodDaoImpl();
		System.out.println("\nPlease Select An Option To Continue");
		System.out.println(
				"\n1. Register New Engineer\n2. List Of All Engineers\n3. Delete An Engineer\n4. See All Complains\n5. Assign Problem To Engineer\n6. Exit");
		
		int number = sc.nextInt();
		
		switch(number) {
		case 1: 
			System.out.println("Enter Engineer Details");
			System.out.println("Enter ENId : ");
			int id = sc.nextInt();
			System.out.println("Enter Engineer Name : ");
			String ename = sc.next();
			System.out.println("Enter Engineer Email/Username :");
			String email = sc.next();
			System.out.println("Enter Engineer Password :");
			String password = sc.next();
			System.out.println("Enter Engineer Catagory :");
			String catagory = sc.next();
		
	        String rs = hd.registerEngineer(new Engineer(id, ename, email, password, catagory));
	        System.out.println(rs);
	        DotUseCases.optionsHod();
	        break;
	        
		 case 2:
			 System.out.println("List of Engineers :");
			 try {
				List<Engineer> list =  hd.getEngineers();
				list.forEach(e -> System.out.println(e));
			} catch (EngineerException e) {
				System.out.println(e.getMessage());
			}
			 DotUseCases.optionsHod();
		     break;
		     
		  case 3:
			  System.out.println("Enter Engineer Id To Delete :");
			  int eid = sc.nextInt();
			  String del = hd.removeEngineer(eid);
			  System.out.println(del);
			  DotUseCases.optionsHod();
			  break;
			  
		  case 4:
			  try {
				List<Complain> clist = hd.getAllComplain();
				clist.forEach(e -> System.out.println(e));
			} catch (ComplainException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			  DotUseCases.optionsHod();
			  break;
			  
			  
		  case 5:
			  System.out.println("Enter Engineer Id :");
			  int enid = sc.nextInt();
			  System.out.println("Enter Engineer Name :");
			  String enname = sc.next();
			  System.out.println("Enter Engineer Catagory : Software/Hardware ");
			  String cat = sc.next();
			  System.out.println("Enter Complain Id :");
			  int cid = sc.nextInt();
			  System.out.println("Enter Complain Status : ");
			  String sts = sc.next();
			  String rs2 = hd.assignComplain(enid,enname,cat,cid,sts);
			  System.out.println(rs2);
			  DotUseCases.optionsHod();
			  break;
			  
		  case 6:
			  break;
			  
		}
		
		
	}
	
	
	
	
	

}
